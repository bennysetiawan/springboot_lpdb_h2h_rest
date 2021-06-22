package com.h2h.configs;

import java.security.KeyPair;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//   @Autowired
//   private DataSource dataSource;

   @Autowired
   @Qualifier("authenticationManagerBean")
   private AuthenticationManager authenticationManager;

   @Value("classpath:lpdb_h2h.pfx")
   private Resource keystoreFile;
   //mengambil dari file appplication.properties
   @Value("${keystore.password}")
   private String keystorePassword;
   @Value("${keystore.alias}")
   private String keystoreAlias;

   @Override
   public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
      //clients.jdbc(this.dataSource);

      clients.inMemory()
         .withClient("lpdb-client")
         .secret(passwordEncoder().encode("123456"))
         .authorities("ADMIN", "USER", "MANAGER")
         .authorizedGrantTypes("password", "authorization_code", "refresh_token")
         .scopes("read", "write")
         .autoApprove(false)
         .accessTokenValiditySeconds(60 * 60 * 24 * 30)// seconds*minute*hours*days
         .refreshTokenValiditySeconds(60 * 60 * 24 * 30);// 30 days
//         .accessTokenValiditySeconds(60)// seconds*minute*hours*days
//         .refreshTokenValiditySeconds(60);// 30 days
         //.redirectUris("xxx", "http://localhost:8089/");
   }

   @Override
   public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
      oauthServer
         .tokenKeyAccess("isAuthenticated()")
         .checkTokenAccess("isAuthenticated()")
         .allowFormAuthenticationForClients();
   }

   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
      tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));

      endpoints
         //.approvalStore(approvalStore())
         //.authorizationCodeServices(authorizationCodeServices())
         .tokenStore(tokenStore())//tempat menyimpan token
         .accessTokenConverter(jwtAccessTokenConverter())
         .tokenEnhancer(tokenEnhancerChain)//configurasi custom output saat login, menambahkan principal
         .authenticationManager(authenticationManager);//kalau dibuang akan menyebabkan : "error": "unsupported_grant_type",
   }

   //token disimpan dalam database
   //kalau dibuang maka akan error pada package controller, karena digunakan pada controller
   @Bean
   public TokenStore tokenStore() {
      return new JwtTokenStore(jwtAccessTokenConverter());//
      //return new JdbcTokenStore(this.dataSource);
   }

   //konfigurasi jwt
   @Bean
   public JwtAccessTokenConverter jwtAccessTokenConverter() {
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      KeyPair keyPair = new KeyStoreKeyFactory(
         keystoreFile, //nama file
         keystorePassword.toCharArray() //password sp.jks
      ).getKeyPair(keystoreAlias); //alias saat membuat file sp.jks (-alias)

      converter.setKeyPair(keyPair);
      return converter;
   }

   //custom output token saat pertama kali login di : /oauth/token
   @Bean
   public TokenEnhancer tokenEnhancer() {
      return new CustomTokenEnhancer();
   }
   
//   //kalau dibuang maka akan error pada package controller, karena digunakan pada controller
//   @Bean
//   @Primary
//   public DefaultTokenServices tokenServices() {
//      final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//      defaultTokenServices.setTokenStore(tokenStore());
//      defaultTokenServices.setSupportRefreshToken(true);
//      return defaultTokenServices;
//   }
//
//   @Bean
//   public JdbcClientDetailsService clientDetailsService() {
//      //return new JdbcClientDetailsService(dataSource());
//      return new JdbcClientDetailsService(this.dataSource);
//   }
//
//   @Bean
//   public ApprovalStore approvalStore() {
//      //return new JdbcApprovalStore(dataSource());
//      return new JdbcApprovalStore(this.dataSource);
//   }
//
//   @Bean
//   public AuthorizationCodeServices authorizationCodeServices() {
//      //return new JdbcAuthorizationCodeServices(dataSource());
//      return new JdbcAuthorizationCodeServices(this.dataSource);
//   }
   
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
