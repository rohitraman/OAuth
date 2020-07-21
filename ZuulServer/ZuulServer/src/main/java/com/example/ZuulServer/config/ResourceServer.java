package com.example.ZuulServer.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@RefreshScope
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/wishlistmicroservice/**")
			.authenticated().anyRequest().permitAll();
	}
	
	
	@Bean
	public RemoteTokenServices tokenServices()
	{
		RemoteTokenServices tokenServices=new RemoteTokenServices();
		tokenServices.setCheckTokenEndpointUrl("http://localhost:8061/oauth/check_token");
		tokenServices.setClientId("guest");
		tokenServices.setClientSecret("secret");
		
		return tokenServices;
	}
		
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		resources.tokenServices(tokenServices());
	}
}
