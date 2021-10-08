package vn.techmaster.securitydemo.Service;
import java.util.List;

import vn.techmaster.securitydemo.entities.*;




public interface UserService {
    User saveUser(User user);
    Authority saveAuthority (Authority authority);
    void addAuthorityToUser (String username, String name );
    User getUser (String username);
    List<User> getUser();
}
