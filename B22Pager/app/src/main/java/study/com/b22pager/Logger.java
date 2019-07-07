package study.com.b22pager;

import android.util.Log;

public class Logger {
    public static void logAll() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stack.length; i++) {
            Log.d("happy", " " + i + " " +
                    stack[i].getClassName() +
                    " " + stack[i].getMethodName());
        }
    }

    public static void logMe() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        Log.d("happy", stack[3].getClassName() +
                " " + stack[3].getMethodName());
    }
}