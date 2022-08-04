package com.ecomApp.Ecom.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService  
{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProduct()
    {
        return productRepository.findAll();
    }

    public void createProduct(Product product) 
    {
    	if(product.getProductInventory() <= 0)
    	{
    		product.setProductStatus("Out-of-Stock");
    	}
    	
    	else
    	{
    		product.setProductStatus("In-Stock");
    	}
    	
        productRepository.save(product);
    }
    
    public List<Product> getProductsByName(String productName) 
    {
        return productRepository.findByNameEqualsAllIgnoreCase(productName);
    }

    public Optional<Product> getProductsById(Long id) 
    {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product product) 
    {
        Product product1 = productRepository.findById(id).get();

        product1.setName(product.getName());
        product1.setProductCategory(product.getProductCategory());
        product1.setUnitPrice(product.getUnitPrice());
        product1.setProductImage(product.getProductImage());
        product1.setProductCondition(product.getProductCondition());
        product1.setProductDescription(product.getProductDescription());
        
        createProduct(product1);
        return product;
    }
    
    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }
}