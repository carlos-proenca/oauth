package br.com.carlos.customerservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableOAuth2Sso
@Configuration
public class SsoSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**")
            .permitAll()
            .anyRequest()
            .authenticated();
    }

}

//    @Autowired
//    @Qualifier("resourceServerRequestMatcher")
//    private RequestMatcher resources;
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        RequestMatcher nonResoures = new NegatedRequestMatcher(resources);
//        http
//            .requestMatcher(nonResoures).authorizeRequests()
//            .anyRequest().authenticated();
//        
//        http.antMatcher("/**")
//        .authorizeRequests()
//        .antMatchers("/", "/login**")
//        .permitAll()
//        .anyRequest()
//        .authenticated();
//    }
//}