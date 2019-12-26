package uz.xtreme.oauth2server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.xtreme.oauth2server.model.User;

import java.util.Optional;

/**
 * Author: Rustambekov Avazbek
 * Date: 25/12/2019
 * Time: 18:03
 */
public interface UserDetailRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String s);

}
