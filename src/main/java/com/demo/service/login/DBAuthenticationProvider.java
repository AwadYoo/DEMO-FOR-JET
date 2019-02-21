package com.demo.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token) throws AuthenticationException {

        String userName = "yhy";
        String password = (String) token.getCredentials();
        if (username == null || !userName.equalsIgnoreCase(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        String pwd = "123456";
        if (!pwd.equals(password)) {
            throw new PasswordNotMatchException("密码不匹配");
        }

        return new User(username, password, true
                , true, true
                , true, Arrays.asList(new SimpleGrantedAuthority("default")));
    }
}
