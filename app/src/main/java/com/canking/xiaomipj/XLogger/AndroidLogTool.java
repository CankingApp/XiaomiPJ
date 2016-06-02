package com.canking.xiaomipj.XLogger;

import android.util.Log;

/**
 * default log tool
 */
public class AndroidLogTool implements Printer, LogTool {

    public Printer t(String tag, int methodCount) {
        return this;
    }

    public Settings init(String tag) {
        return null;
    }

    public Settings getSettings() {
        return null;
    }

    public void d(String message, Object... args) {

    }

    public void e(String message, Object... args) {

    }

    public void e(Throwable throwable, String message, Object... args) {

    }

    public void w(String message, Object... args) {
    }

    public void i(String message, Object... args) {

    }

    public void v(String message, Object... args) {

    }

    public void wtf(String message, Object... args) {

    }

    public void json(String json) {

    }

    public void xml(String xml) {

    }

    public void clear() {

    }


    @Override
    public void d(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void w(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void i(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    public void v(String tag, String message) {
        Log.v(tag, message);
    }

    @Override
    public void wtf(String tag, String message) {
        Log.wtf(tag, message);
    }
}
