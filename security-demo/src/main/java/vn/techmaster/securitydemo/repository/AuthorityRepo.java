package vn.techmaster.securitydemo.repository;

import vn.techmaster.securitydemo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {

    
    Optional<Authority> findByname (String name);
}