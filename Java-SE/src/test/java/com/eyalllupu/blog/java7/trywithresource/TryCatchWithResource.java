package com.eyalllupu.blog.java7.trywithresource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eyal lupu
 *
 */
public class TryCatchWithResource {

	@Test(expected = IOWriteException.class)
	public void testTraditionalTryCatch() throws IOException {
		OutputStream os = null;
		try {
			os = new TraceableStream("/tmp/x.x");
			os.write(0);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	@Test(expected = IOCloseException.class)
	public void testTraditionalTryCatchWithExceptionOnFinally() throws IOException {
		OutputStream os = null;
		try {
			os = new TraceableStream(true, "/tmp/x.x");
			os.write(0);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	@Test(expected = IOWriteException.class)
	public void testJava7TryCatchWithExceptionOnFinally() throws IOException {
		try (OutputStream os = new TraceableStream(true, "/tmp/x.x")) {
			os.write(0);
		}
	}

	@Test(expected = IOCloseException.class) 
	public void testJava7TryCatchWithExceptionOnFinally2() throws Throwable {
		try {
			try (OutputStream os = new TraceableStream(true, "/tmp/x.x")) {
				os.write(0);
			}
		} catch (Exception e) {
			throw e.getSuppressed()[0];
		}
	}

	@Test 
	public void testJava7TryCatchWithExceptionOnFinallyExtractingSuppressed() throws Throwable {
		try (OutputStream os = new TraceableStream(true, "/tmp/x.x")) {
				os.write(0);
		} catch (IOException e) {
			Throwable[] suppressed = e.getSuppressed();
			for (Throwable t : suppressed) {
				// Check T's type and decide on action to be taken
			}
		}
	}
	
	// When does the close take place?
	@Test
	public void testJava7TryCatchWhenClosed() throws Throwable {
			TraceableStream streamRef = null; 
			try (TraceableStream os = new TraceableStream(true, "/tmp/x.x")) {
				streamRef = os;
				os.write(0);
			} catch (Exception e) {
				// Assert.assertTrue(os.isOpen()); we cannot refer to OS in here
				Assert.assertFalse(streamRef.isOpen()); 
			} finally {
				Assert.assertFalse(streamRef.isOpen());
			}
	}
	
	private static class TraceableStream extends FileOutputStream {

		private final boolean throwExceptionOnClose;

		private boolean isOpen = true;
		
		public TraceableStream(boolean throwExceptionOnClose, String path) throws IOException {
			super(path);
			this.throwExceptionOnClose = throwExceptionOnClose;
		}

		public TraceableStream(String path) throws IOException {
			this(false, path);
		}

		@Override
		public synchronized void write(int b) throws IOException{
			if (0 == b) {
				throw new IOWriteException("This stream refuses to write the value 0.");
			} else {
				super.write(b);
			}
		}

		@Override
		public void close() throws IOException {
			isOpen=false;
			if (throwExceptionOnClose) {
				throw new IOCloseException("I want to stay open");
			}
			super.close();
		}

		public boolean isOpen() {
			return isOpen;
		}
		
	}
}
