package com.codeup;

import com.codeup.services.UserDetailsLoader;
import com.codeup.services.UserWithRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vanessamnoble on 2/13/17.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = UserWithRoles.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsLoader userDetailsLoader;

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/ads/create") // only admin users can create ads
//                .hasAuthority("ADMIN");
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/ads/create") // either admin or sellers can create ads
//                .hasAnyAuthority("ADMIN", "SELLER");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/me") // user's home page, it can be any URL
                    .permitAll() // Anyone can go to the login page
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/logout") // anyone can see the home and logout page
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout") // append a query string value
                .and()
                    .authorizeRequests()
                    .antMatchers("/posts/create") // only authenticated users can create ads
                    .authenticated()
        ;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsLoaderService(userDetailsLoader).passwordEncoder(passwordEncoder());
    }

//      where does this go?
//    (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
}

