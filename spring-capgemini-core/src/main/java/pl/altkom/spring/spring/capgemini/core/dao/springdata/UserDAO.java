/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.dao.springdata;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.altkom.spring.spring.capgemini.core.model.User;

/**
 *
 * @author instruktor
 */
public interface UserDAO extends CrudRepository<User, Long>{
    
    @Query("select u from User u where u.login like :login")
    List<User> findByLoginLikeIgnoreCase(@Param("login") String login);
    
    List<User> findByActiveTrue();
    
}
