package com.example.oauthwithjdbc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer implements AuthorizationServerConfigurer {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AuthenticationManager authenticationManager1;

    @Bean
    TokenStore myTokenStore(){
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()").tokenKeyAccess("permitAll()");
      //  security.passwordEncoder(encoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer client) throws Exception {

        client.jdbc(dataSource).passwordEncoder(encoder);
                      //inMemory cleint
      //  client.inMemory().withClient("abc").secret(encoder.encode("666666")).scopes("READ").authorizedGrantTypes("password","authorization_code");
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(myTokenStore());
        endpoints.authenticationManager(authenticationManager1);
    }
}
