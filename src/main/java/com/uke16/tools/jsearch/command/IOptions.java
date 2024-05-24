package com.uke16.tools.jsearch.command;

public interface IOptions {
    IOptions EMPTY_OPTIONS = null;
    Object getValue(String key);

    void setValue(String key, Object value);

}
