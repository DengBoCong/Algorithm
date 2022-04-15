package com.dbc;

import java.util.*;

public class RestoreIpAddresses {
    private final Set<String> remain = new HashSet<>();
    private final List<String> res = new ArrayList<>();

    private void dfs(String subStr, String prefix, int num) {
        if (num == 4 && subStr.length() > 0 && subStr.length() <= 3 && Integer.parseInt(subStr) >= 0 &&
                Integer.parseInt(subStr) <= 255) {
            if (subStr.startsWith("0") && subStr.length() > 1) return;
            prefix = prefix + "." + subStr;
            if (!this.remain.contains(prefix)) {
                this.res.add(prefix);
                this.remain.add(prefix);
            }
        }
        if (num < 4) {
            for (int i = 1; i < Math.min(4, subStr.length()); i++) {
                String tempStr = subStr.substring(0, i);
                if ((tempStr.startsWith("0") && tempStr.length() > 1) || Integer.parseInt(tempStr) < 0 || Integer.parseInt(tempStr) > 255) continue;
                if (num != 1) tempStr = prefix + "." + tempStr;
                dfs(subStr.substring(i), tempStr, num + 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(s, "", 1);
        return this.res;
    }
}
