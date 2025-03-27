package ut.edu.webjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "ut.edu.webjava")
//@SpringBootApplication
public class WebJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebJavaApplication.class, args);
    }

}
