package com.mogilan.practice;

import java.util.List;

public final class MarkLength {
    private static final int REQUIRED_STRING_LENGTH = 4;
    private static final String NEW_ELEMENT = "****";

    private MarkLength () {}

    public static void markLength4(List<String> list)  {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() == REQUIRED_STRING_LENGTH) {
                    list.add((i), NEW_ELEMENT);
                    i++;
                }
            }
        }
    }
}
