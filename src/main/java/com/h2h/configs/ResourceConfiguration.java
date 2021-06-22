/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.configs;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 *
 * @author jp
 */
@Configuration
@EnableResourceServer
public class ResourceConfiguration extends ResourceServerConfigurerAdapter {

   @Value("${spring.application.name}")
   private String resourceId;

   @Override
   public void configure(ResourceServerSecurityConfigurer resources) {
      resources.resourceId(resourceId);
   }

   @Override
   public void configure(HttpSecurity http) throws Exception {
      http
         .requestMatcher((RequestMatcher) new OAuthRequestedMatcher())
         .csrf().disable()
         //.cors().disable()
         .anonymous().disable()
         .authorizeRequests()
         .antMatchers(HttpMethod.OPTIONS, "/oauth/token/**", "/**").permitAll()
         .antMatchers("/register").permitAll()
         .anyRequest().authenticated()
         .and().httpBasic()
         .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
   }

   private static class OAuthRequestedMatcher implements RequestMatcher {
      @Override
      public boolean matches(HttpServletRequest request) {
         String auth = request.getHeader("Authorization");
         // Determine if the client request contained an OAuth Authorization
         boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
         boolean haveAccessToken = request.getParameter("access_token") != null;
         return haveOauth2Token || haveAccessToken;
      }
   }

}
