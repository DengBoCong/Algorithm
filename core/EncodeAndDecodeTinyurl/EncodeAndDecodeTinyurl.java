package com.dbc.code;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyurl {
    private final Map<String, String> urlMap = new HashMap<>();
    private final Map<String, String> tinyUrlMap = new HashMap<>();
    private int count = 0;

    public String encode(String longUrl) {
        if (!this.urlMap.containsKey(longUrl)) {
            this.count++;
            String temp = "XHID62" + this.count;
            this.urlMap.put(longUrl, temp);
            this.tinyUrlMap.put(temp, longUrl);
        }
        return this.urlMap.get(longUrl);
    }

    public String decode(String shortUrl) {
        return this.tinyUrlMap.get(shortUrl);
    }
}
