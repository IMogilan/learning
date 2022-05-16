package com.mogilan.practice;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class ScheduleUtil {

    public static final LocalTime END_OF_THE_DAY = LocalTime.of (18, 30);

    public static final ArrayList<String> ACTIVITIES = new ArrayList (List.of ("Упражнения", "Решения", "Перерыв", "Обеденный перерыв"));

    public static final int LECTURES_MIN_DURATION_IN_MINUTES = 90;

    public static final int LECTURES_MAX_DURATION_IN_MINUTES = 120;

    public static final int ACTIVITIES_MIN_DURATION_IN_MINUTES = 10;

    public static final int ACTIVITIES_MAX_DURATION_IN_MINUTES = 30;

    public static final String REG_EX = "(?<time>\\d{2}:\\d{2})\\s(?<name>.+)";

    public static final Pattern PATTERN = Pattern.compile(REG_EX);

    public ScheduleUtil() {
    }
}
