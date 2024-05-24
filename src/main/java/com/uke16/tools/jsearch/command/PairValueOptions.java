package com.uke16.tools.jsearch.command;

import java.util.HashMap;
import java.util.Map;

public class PairValueOptions implements IOptions {
    private Map<String, Object> pairs;

    public PairValueOptions() {
        this.pairs = new HashMap<>();
    }

    @Override
    public Object getValue(String key) {
        return pairs.get(key);
    }

    @Override
    public void setValue(String key, Object value) {
        this.pairs.put(key, value);
    }
}
