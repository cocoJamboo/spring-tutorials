/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.dao.jpa;

import java.util.List;
import pl.altkom.spring.spring.capgemini.core.model.User;

/**
 *
 * @author instruktor
 */
public interface UserDAO {

    User load(long id);

    void save(User user);

    List<User> findByLogin(String loginName);
    
}
