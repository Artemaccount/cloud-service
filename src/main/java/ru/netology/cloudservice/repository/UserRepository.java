package ru.netology.cloudservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.netology.cloudservice.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    User findByUsername(String username);
//
//    UserDetails findByLogin(String login);

//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    User getUser(String username);

//    @Modifying
//    @Query("update User u set u.token = :token where u.login = :login")
//    void addTokenToUser(String login, String token);
//
//    @Modifying
//    @Query("update User u set u.token = null where u.login=:username")
//    void deleteTokenByUsername(String username);
}
