package com.kirillzhdanov.learningrestapi.security.base64;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;

@Component
public class CodeEncodeBase64 {

    public void testone() {
        String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
        String encodedUrl = coder(originalUrl); // Шифрование base64
        String str = encodedUrl;
        String decodedUrl = decoder(str); // Дешифрование  Base64
        String teststr = decodedUrl;
    }

    public static String decoder(String data) {
        String result = new String(Base64.getUrlDecoder().decode(data));
        return result;
    }

    public static String coder(String date) {
        String result = Base64.getUrlEncoder().encodeToString(date.getBytes());
        return result;
    }

}
