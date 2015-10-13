/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pl.altkom.spring.spring.capgemini.core.model.User;

/**
 *
 * @author instruktor
 */
@Repository
public class UserDAOImpl implements UserDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public User load(long id) {
        return em.find(User.class, id);
    }
    
    @Override
    public void save(User user) {
        em.persist(user);
    }
    
    @Override
    public List<User> findByLogin(String loginName) {
        
        return em.createNamedQuery("User.findByLogin")
                .setParameter("name", loginName)
                .getResultList();
        
    }
}
