package vn.techmaster.securitydemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.*;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.techmaster.securitydemo.entities.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {
    @Autowired
    private CustomUserDetailService userDetailService; 
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        CustomUserDetail user = (CustomUserDetail) userDetailService.loadUserByUsername(username);
        return checkPassword(user, password, bCryptPasswordEncoder);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // TODO Auto-generated method stub
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

    private Authentication checkPassword(CustomUserDetail user, String rawPassword, PasswordEncoder encoder) {
        if(encoder.matches(rawPassword,user.getPassword())){
            return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
        }else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
    
}
