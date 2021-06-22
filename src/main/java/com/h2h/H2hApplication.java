package com.h2h;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class H2hApplication {

   public static void main(String[] args) {
      SpringApplication.run(H2hApplication.class, args);
      //System.out.println(passwordEncoder().encode("lpdb_h2h_amv@2019"));
//      System.out.println(passwordEncoder().encode("bpd_jateng_2019"));
      
   }
   
//   public static PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}
