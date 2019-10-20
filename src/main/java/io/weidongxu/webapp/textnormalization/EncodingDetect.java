package io.weidongxu.webapp.textnormalization;

import lombok.extern.log4j.Log4j2;
import org.apache.tika.detect.AutoDetectReader;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;

@Log4j2
public class EncodingDetect {

    public static InputSource detectTextEncoding(InputStream inputStream) throws IOException, TikaException {
        Metadata metadata = new Metadata();
        AutoDetectReader reader = new AutoDetectReader(inputStream, metadata);
        log.info("charset detected: " + reader.getCharset());
        return reader.asInputSource();
    }
}
