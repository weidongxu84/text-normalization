package io.weidongxu.webapp.textnormalization;

import lombok.extern.log4j.Log4j2;
import org.xml.sax.InputSource;

import java.io.*;

@Log4j2
public class Transcode {

    public static String transcodeText(InputSource inputSource) throws IOException {
        try (Reader reader = inputSource.getCharacterStream()) {
            char[] buffer = new char[8 * 1024];
            StringBuilder stringBuilder = new StringBuilder();
            int length;
            while ((length = reader.read(buffer, 0, buffer.length)) != -1) {
                stringBuilder.append(buffer, 0, length);
            }
            return stringBuilder.toString();
        }
    }
}
