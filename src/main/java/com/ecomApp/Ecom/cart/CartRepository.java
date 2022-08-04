package com.ecomApp.Ecom.cart;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> 
{
	List<Cart> findByNameEqualsAllIgnoreCase(final String cartProductName);
}
