package com.h2h.configs;

import com.h2h.services.JdbcUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   public void configure(WebSecurity web) throws Exception {
      //membiarkan terbuka
      web.ignoring().antMatchers("/webjars/**", "/resources/**");
      web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/views/**", "/node_modules/**");
   }

   //untuk login
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
         .userDetailsService(jdbcUserDetailsBean())
         .passwordEncoder(passwordEncoder());
   }

   //membuat bean authenticationManagerBean yang akan digunakan di AuthorizationConfiguration.class
   @Override
   @Bean
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }

   @Bean
   public UserDetailsService jdbcUserDetailsBean() throws Exception {
      //untuk mendapatkan username & list authority
      //mengambilnya dari database menggunakan jdbc
      return new JdbcUserDetails();
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

}
