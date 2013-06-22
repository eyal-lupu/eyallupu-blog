package com.eyalllupu.blog.java7.trywithresource;

import java.io.IOException;

public class IOWriteException extends IOException {

    /**
     * SUID
     */
    private static final long serialVersionUID = 4601158400433211672L;

    public IOWriteException() {
    }

    public IOWriteException(String message) {
        super(message);
    }

    public IOWriteException(Throwable cause) {
        super(cause);
    }

    public IOWriteException(String message, Throwable cause) {
        super(message, cause);
    }

}
