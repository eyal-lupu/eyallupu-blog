package com.eyalllupu.blon.java7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Test;

public class TryCatchWithResource {

	@Test(expected = IllegalArgumentException.class)
	public void testTraditionalTryCatch() throws IOException {
		OutputStream os = null;
		try {
			os = new TraceableStream();
			os.write(0);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testTraditionalTryCatchWithExceptionOnFinally()
			throws IOException {
		OutputStream os = null;
		try {
			os = new TraceableStream(true);
			os.write(0);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testJava7TryCatchWithExceptionOnFinally() throws IOException {
		try (OutputStream os = new TraceableStream(true)) {
			os.write(0);
		}
	}

	@Test(expected = UnsupportedOperationException.class) 
	public void testJava7TryCatchWithExceptionOnFinally2() throws Throwable {
		try {
			try (OutputStream os = new TraceableStream(true)) {
				os.write(0);
			}
		} catch (Exception e) {
			throw e.getSuppressed()[0];
		}
	}

	
	// When does the close take place?
	@Test
	public void testJava7TryCatchWhenClosed() throws Throwable {
			TraceableStream streamRef = null; 
			try (TraceableStream os = new TraceableStream(true)) {
				streamRef = os;
				os.write(0);
			} catch (Exception e) {
				// Assert.assertTrue(os.isOpen()); we cannot refer to OS in here
				Assert.assertFalse(streamRef.isOpen()); 
			} finally {
				Assert.assertFalse(streamRef.isOpen());
			}
	}
	
	private static class TraceableStream extends ByteArrayOutputStream {

		private final boolean throwExceptionOnClose;

		private boolean isOpen = true;
		
		public TraceableStream(boolean throwExceptionOnClose) {
			this.throwExceptionOnClose = throwExceptionOnClose;
		}

		public TraceableStream() {
			this(false);
		}

		@Override
		public synchronized void write(int b) {
			if (0 == b) {
				throw new IllegalArgumentException(
						"This stream refuses to write the value 0.");
			} else {
				super.write(b);
			}
		}

		@Override
		public void close() throws IOException {
			isOpen=false;
			if (throwExceptionOnClose) {
				throw new UnsupportedOperationException("I want to stay open");
			}
			super.close();
		}

		public boolean isOpen() {
			return isOpen;
		}
		
	}
}
