package io.weidongxu.webapp.textnormalization;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Log4j2
public class Transcode {

    public static String transcodeText(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos.toString(charset.name());
    }
}
