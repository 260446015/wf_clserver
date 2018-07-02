package com.zkjl.wf_clserver.core.exception;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public class UndefinedFileUpload extends Exception{
    public UndefinedFileUpload() {
        super();
    }

    public UndefinedFileUpload(String message) {
        super(message);
    }

    public UndefinedFileUpload(String message, Throwable cause) {
        super(message, cause);
    }

    public UndefinedFileUpload(Throwable cause) {
        super(cause);
    }

    protected UndefinedFileUpload(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
