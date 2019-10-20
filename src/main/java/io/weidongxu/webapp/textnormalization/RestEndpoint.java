package io.weidongxu.webapp.textnormalization;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.CloseShieldInputStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class RestEndpoint {

    @PostMapping(
            value = "/",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    String post(@RequestParam("file") MultipartFile textFile) throws IOException, TikaException {
        InputStream inputStream = new CloseShieldInputStream(textFile.getInputStream());
        InputSource is = EncodingDetect.detectTextEncoding(inputStream);
        String utf8Text = Transcode.transcodeText(is);
        return utf8Text;
    }
}
