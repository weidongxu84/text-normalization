package io.weidongxu.webapp.textnormalization;

import lombok.extern.log4j.Log4j2;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.AutoDetectReader;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Log4j2
public class EncodingDetect {

    public static Charset detectTextEncoding(InputStream inputStream) throws IOException, TikaException {
        Metadata metadata = new Metadata();
        AutoDetectReader reader = new AutoDetectReader(new BufferedInputStream(inputStream), metadata);
        Charset charset = reader.getCharset();
        log.info("charset detected: " + charset);
        return charset;
    }
}
