package com.gezhiwei.stacktrace;

/**
 * @author gezhiwei
 */
public final class Utils {


    public static String getMethod() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return className + "." + methodName;
    }
}
