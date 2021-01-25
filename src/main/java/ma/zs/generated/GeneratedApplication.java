package ma.zs.generated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GeneratedApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratedApplication.class, args);
        System.out.println(">>>>>>>>>>>>>>>>>>"+new BCryptPasswordEncoder().encode("password"));
    }

}
