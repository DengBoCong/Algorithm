package com.dbc;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int row = 0, line = 0;
        for (int i = 0; i < s.length(); i++) {
            if (widths[s.charAt(i) - 'a'] + line > 100) {
                line = widths[s.charAt(i) - 'a'];
                row++;
            } else {
                line += widths[s.charAt(i) - 'a'];
            }
        }

        if (line != 0) row++;
        return new int[]{row, line};
    }
}
