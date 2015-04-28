package demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin")
				.roles("ADMIN").and().withUser("user").password("user")
				.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
 
		 http.exceptionHandling()
         .accessDeniedPage( "/403" ).and()
	        .authorizeRequests()
	            .anyRequest().authenticated() 
	            .and()
	        .formLogin().defaultSuccessUrl("/home", true).failureUrl("/loginpage").usernameParameter("j_username").passwordParameter("j_password")                    
	            .and()
	        .httpBasic().and().sessionManagement().invalidSessionUrl("/loginpage").maximumSessions(1); 	
	}
	
	@Override
    public void configure( WebSecurity web ) throws Exception
    {
        web
            .ignoring()
                .antMatchers( "/static/**" );
    }
}