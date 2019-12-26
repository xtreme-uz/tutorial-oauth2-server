package uz.xtreme.oauth2server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.xtreme.oauth2server.model.AuthUserDetail;
import uz.xtreme.oauth2server.model.User;
import uz.xtreme.oauth2server.repository.UserDetailRepository;

import java.util.Optional;

/**
 * Author: Rustambekov Avazbek
 * Date: 25/12/2019
 * Time: 18:03
 */

@Service("userDetailsService")
public class IUserDetailService implements UserDetailsService {

    private final UserDetailRepository userDetailRepository;

    public IUserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailRepository.findByUsername(name);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
