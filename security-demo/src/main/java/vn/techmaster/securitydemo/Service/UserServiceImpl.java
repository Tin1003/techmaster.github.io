package vn.techmaster.securitydemo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.techmaster.securitydemo.repository.*;
import vn.techmaster.securitydemo.entities.Authority;
import vn.techmaster.securitydemo.entities.User;
import vn.techmaster.securitydemo.repository.UserRepo;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo  userRepo;
    private final AuthorityRepo authorityRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user{} to the database", user.getUsername());
        return userRepo.save(user) ; 
    }

    @Override
    public Authority saveAuthority(Authority authority) {
        log.info("Saving new authority to the database", authority.getName());
        
        return authorityRepo.save(authority);
    }

    @Override
    public void addAuthorityToUser(String username, String name) {
        log.info("Adding authority {} to user {}", name, username  );
        User user = userRepo.findByUsername(username).get();
        Authority authority = authorityRepo.findByname(name).get();
        user.getAuthorities().add(authority);
    }

    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        return userRepo.findByUsername(username).get();
    }

    @Override
    public List<User> getUser() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
    }
    
}
