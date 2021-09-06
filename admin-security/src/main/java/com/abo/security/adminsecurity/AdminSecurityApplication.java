package com.abo.security.adminsecurity;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class AdminSecurityApplication {
//echo 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home/' >> ~/.bash_profile
    public static void main(String[] args) {
        SpringApplication.run(AdminSecurityApplication.class, args);
//        HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
//        DefaultLoginPageGeneratingFilter
    }

}
