/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.dao.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.altkom.spring.spring.capgemini.core.model.Product;

/**
 *
 * @author instruktor
 */
public interface ProductDAO extends JpaRepository<Product, Long>{
    
}
