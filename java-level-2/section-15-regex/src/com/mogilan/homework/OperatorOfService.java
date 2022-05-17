package com.mogilan.homework;

import com.mogilan.homework.logging.Tasks;

import java.util.Optional;
import java.util.regex.Matcher;

import static com.mogilan.homework.util.ServiceUtil.*;

/**Задача:
 С какой-то периодичностью (например, раз в 2 минуты) считывать все новые записи из лог-файла и отправлять их диспетчерам для созвона с клиентами (ограничить количество диспетчеров, например, 2-3).

 Созвон длится какое-то фиксированное время (например, 3-5 секунд), после чего он записывается в другой лог-файл в виде:
 - Порядковый номер клиента с предыдущего лог файла
 - Дата и время созвона
 - Номер телефона клиента

 Например:
 2, 2022-01-04 04:15, +375 (25) 777-77-65
 1, 2022-01-04 04:30, +375 (29) 999-78-90
 3, 2022-01-04 04:45, +375 (33) 365-21-93

 Номера телефонов могут быть представлены по-разному, поэтому привести их к одному формату: +375 (29) 999-78-90.*/

public class OperatorOfService implements Runnable {

    public static final int SLEEPING_DURATION_IN_SEC = 3;
    private final Tasks tasks;
    private final ReportWriter reportWriter;

    public OperatorOfService(Tasks tasks, ReportWriter reportWriter) {
        this.tasks = tasks;
        this.reportWriter = reportWriter;
    }

    @Override
    public void run() {
        while (!tasks.isEmpty()) {
           tryGetNewTask: {
               Optional<String> newTask = tasks.removeTask();
               String currentTask;
               if (newTask.isPresent()) {
                   currentTask = newTask.get();
               } else {
                   break tryGetNewTask;
               }
               sleep(SLEEPING_DURATION_IN_SEC);
               Matcher matcher = PATTERN_FULL.matcher(currentTask);
               matcher.find();
               String taskNumber = matcher.group(TASK_NUMBER);
               String timeOfTask = matcher.group(TIME_OF_TASK).replace("T", " ");
               String fullTelNumber = phoneNumberFormatter (matcher.group(COUNTRY_CODE), matcher.group(OPERATOR_CODE), matcher.group(PHONE_NUMBER));
               String resultLine = String.format("%s, %s, %s", taskNumber, timeOfTask, fullTelNumber);
               lockWriter();
               try {
                   reportWriter.addToReport(resultLine);
               } finally {
                   reportWriter.getLock().unlock();
               }
               if (tasks.isEmpty()) sleep(20);
            }

        }
    }

    private String phoneNumberFormatter (String countryCode, String operatorCode, String phoneNumber) {
        countryCode = countryCode == null ? "+375" : countryCode;
        String phoneWithoutSpaces = phoneNumber.replaceAll("\\s", "");
        StringBuilder resultPhoneNumber = new StringBuilder(phoneWithoutSpaces);
        resultPhoneNumber.insert(3, '-').insert(6, '-');
        return String.format("%s (%s) %s", countryCode, operatorCode, resultPhoneNumber);
    }

    private void sleep (int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void lockWriter() {
        while (true) {
            boolean lock = reportWriter.getLock().tryLock();
            if (lock) break;
        }
    }

}
