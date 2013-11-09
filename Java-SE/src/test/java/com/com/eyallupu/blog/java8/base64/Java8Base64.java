package com.com.eyallupu.blog.java8.base64;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Samples of Jave 8 Base64 support.
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


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (OutputStream os = Base64.getEncoder().wrap(baos)) {
            os.write("this is an example\n".getBytes("utf-8"));
            os.write("of stream wrapping".getBytes("utf-8"));
        }
        byte[] bytes = baos.toByteArray();

        try (InputStream is = Base64.getDecoder().wrap(new ByteArrayInputStream(bytes))) {
            int len;
            while ((len = is.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len, "utf-8"));
            }
        }
    }

    @Test
    public void urlEncode() throws UnsupportedEncodingException {
        byte[] urlEncoded = Base64.getUrlEncoder().encode("subjects?abcd".getBytes("utf-8"));
        byte[] basicEncoded = Base64.getEncoder().encode("subjects?abcd".getBytes("utf-8"));

        System.out.println(new String(urlEncoded, "utf-8"));
        System.out.println(new String(basicEncoded, "utf-8"));
    }


    @Test
    public void mimeEncode() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 100; ++t) {
            sb.append(UUID.randomUUID().toString());
        }
        byte[] toEncode = sb.toString().getBytes("utf-8");
        byte[] urlEncoded = Base64.getMimeEncoder().encode(toEncode);
        System.out.println(new String(urlEncoded, "utf-8"));
    }
}
