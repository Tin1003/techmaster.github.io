package vn.techmaster.securitydemo.Service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

import org.springframework.security.core.userdetails.*;

import vn.techmaster.securitydemo.entities.CustomUserDetail;
import vn.techmaster.securitydemo.repository.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        
        Supplier<UsernameNotFoundException> s = ()->new UsernameNotFoundException("Problem during authentication");
        vn.techmaster.securitydemo.entities.User user = userRepo.findByUsername(username).orElseThrow(s);
        return new CustomUserDetail(user);
    }
    
    
}
