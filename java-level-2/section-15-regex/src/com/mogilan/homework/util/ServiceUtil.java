package com.mogilan.homework.util;

import java.util.regex.Pattern;

public final class ServiceUtil {
//"2022-04-09T16:25:25"

    private ServiceUtil() {
    }
    public static final String TASK_NUMBER = "taskNumber";
    public static final String TIME_OF_TASK = "time";
    public static final String INITIALS = "initials";
    public static final String FULL_TEL_NUMBER = "telNumber";
    public static final String COUNTRY_CODE = "countryCode";
    public static final String OPERATOR_CODE = "operatorCode";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String TASK = "task";
    public static final String TASK_NUMBER_REG_EX = "(?<taskNumber>\\d+)";
    public static final String TIME_REG_EX = "(?<time>\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2})";
    public static final String INITIALS_REG_EX = "(?<initials>[a-zA-Zа-яА-ЯёЁ]{2,}\\s[a-zA-Zа-яА-ЯёЁ]{2,}(\\s[a-zA-Zа-яА-ЯёЁ]{2,})*)";
//    public static final String TEL_NUMBER_REG_EX = "(?<telNumber>(\\+375)?\\s?\\(?\\s?\\d{2,3}\\s?\\)?\\s?\\d\\s?\\d\\s?\\d\\s?\\d\\s?\\d\\s?\\d\\s?\\d)";
    public static final String TEL_NUMBER_REG_EX = "(?<telNumber>(?<countryCode>\\+375)?\\s?\\(?\\s?(?<operatorCode>\\d{2,3})\\s?\\)?\\s?(?<phoneNumber>\\d\\s?\\d\\s?\\d\\s?\\d\\s?\\d\\s?\\d\\s?\\d))";
    public static final String TASK_REG_EX = "(?<task>([a-zA-Zа-яА-ЯёЁ]+\\s*)+)";
    public static final String REG_EX = INITIALS_REG_EX + "\\s*\\,\\s*" + TEL_NUMBER_REG_EX + "\\s*\\,\\s*" + TASK_REG_EX;
    public static final String REG_EX_FULL = TASK_NUMBER_REG_EX + "\\s*\\,\\s*" + TIME_REG_EX + "\\s*\\,\\s*" + REG_EX;
    public static final Pattern PATTERN = Pattern.compile(REG_EX);
    public static final Pattern PATTERN_FULL = Pattern.compile(REG_EX_FULL);

}
