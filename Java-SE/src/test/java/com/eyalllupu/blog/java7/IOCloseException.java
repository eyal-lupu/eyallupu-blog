package com.eyalllupu.blog.java7;

import java.io.IOException;

public class IOCloseException extends IOException {

	/**
	 * SUID
	 */
	private static final long serialVersionUID = -4601437726516065566L;

	public IOCloseException() {
		super();
	}

	public IOCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public IOCloseException(String message) {
		super(message);
	}

	public IOCloseException(Throwable cause) {
		super(cause);
	}
	
	

}
