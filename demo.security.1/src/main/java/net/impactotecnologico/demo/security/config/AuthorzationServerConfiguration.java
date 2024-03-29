package net.impactotecnologico.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorzationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	  @Qualifier("authenticationManagerBean")
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private PasswordEncoder passwordEncoder;

	  @Override
	  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	    clients
	      .inMemory()
	      .withClient("client_api")
	      .secret(passwordEncoder.encode("secret"))
	      .authorizedGrantTypes("authorization_code")
	      .redirectUris("http://localhost:8080")
	      .resourceIds("client_api")
	      .scopes("read");
	  }
	  
	  @Override
	  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	    //nothing
	    oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()");
	  }
	  
	  @Override
	  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	    endpoints.tokenStore(new InMemoryTokenStore()).authenticationManager(authenticationManager);
	  }
}
