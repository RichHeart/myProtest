package cn.kgc.product.client;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductClientApplicationTests {

    String test = "1234564987";
    char [] chars = new char[test.length()];
    @Test
    void contextLoads() {
       test.getChars(0, test.length(), chars, 0);
        for (int i = (chars.length-1); i >=0 ; i--) {
            System.out.println(chars[i]);
        }

    }

}
