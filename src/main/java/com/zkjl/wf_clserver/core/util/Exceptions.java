package com.zkjl.wf_clserver.core.util;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Exceptions
{
    public static RuntimeException unchecked(Exception e)
    {
        if ((e instanceof RuntimeException)) {
            return (RuntimeException)e;
        }
        return new RuntimeException(e);
    }

    public static String getStackTraceAsString(Throwable e)
    {
        if (e == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean isCausedBy(Exception ex, Class<? extends Exception>[] causeExceptionClasses)
    {
        Throwable cause = ex.getCause();
        while (cause != null) {
            for (Class causeClass : causeExceptionClasses) {
                if (causeClass.isInstance(cause)) {
                    return true;
                }
            }
            cause = cause.getCause();
        }
        return false;
    }

    public static Throwable getThrowable(HttpServletRequest request)
    {
        Throwable ex = null;
        if (request.getAttribute("exception") != null) {
            ex = (Throwable)request.getAttribute("exception");
        }
        else if (request
                .getAttribute("javax.servlet.error.exception") != null)
        {
            ex = (Throwable)request
                    .getAttribute("javax.servlet.error.exception");
        }

        return ex;
    }
}
