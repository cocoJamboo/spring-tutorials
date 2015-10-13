/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.dao.springdata;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.altkom.spring.spring.capgemini.core.model.Order;

/**
 *
 * @author instruktor
 */
public interface OrderDAO extends JpaRepository<Order, Long>{
    
    public List<Order> findByUserId(long id);
    
    @Query("select o from Order o")
    public Page<Order> findPagedable(Pageable pr);
    
}
