package com.com.eyallupu.blog.java8.base64;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Samples of Java 8 Base64 support.
 *
 * @author Eyal Lupu
 */
public class Java8Base64 {
    @Test
    public void encode() throws UnsupportedEncodingException {
        String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
        System.out.println(asB64);
    }

    @Test
    public void decode() throws UnsupportedEncodingException {
        byte[] asBytes = Base64.getDecoder().decode("c29tZSBzdHJpbmc=");
        System.out.println(new String(asBytes, "utf-8"));
    }


    @Test
    public void wrapping() throws IOException {

        String src = "This is the content of any resource read from somewhere" +
                " into a stream. This can be text, image, video or any other stream.";

        // An encoder wraps an OutputStream. The content of /tmp/buff-base64.txt will be the
        // Base64 encoded form of src.
        try (OutputStream os = Base64.getEncoder().wrap(new FileOutputStream("/tmp/buff-base64.txt"))) {
            os.write(src.getBytes("utf-8"));
        }

        // The section bellow illustrates a wrapping of an InputStream and decoding it as the stream
        // is being consumed. There is no need to buffer the content of the file just for decoding it.
        try (InputStream is = Base64.getDecoder().wrap(new FileInputStream("/tmp/buff-base64.txt"))) {
            int len;
            byte[] bytes = new byte[100];
            while ((len = is.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len, "utf-8"));
            }
        }
    }

    @Test
    public void urlEncode() throws UnsupportedEncodingException {
        String basicEncoded = Base64.getEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
        System.out.println("Using Basic Alphabet: " + basicEncoded);

        String urlEncoded = Base64.getUrlEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
        System.out.println("Using URL Alphabet: " + urlEncoded);
    }


    @Test
    public void mimeEncode() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 10; ++t) {
            sb.append(UUID.randomUUID().toString());
        }
        byte[] toEncode = sb.toString().getBytes("utf-8");
        String mimeEncoded = Base64.getMimeEncoder().encodeToString(toEncode);
        System.out.println(mimeEncoded);
    }

}
