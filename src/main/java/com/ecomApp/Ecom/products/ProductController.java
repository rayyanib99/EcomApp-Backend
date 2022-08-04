package com.ecomApp.Ecom.products;

import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController 
{
    @Autowired
    private ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody Product product)
    {
        productService.createProduct(product);
    }
    
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.listAllProduct();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id)
    {
        Product product = productService.getProductsById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found: " +  id));
        return ResponseEntity.ok(product);
    }

     @GetMapping("/name")
     public ResponseEntity<Product> getProductByName(@PathVariable String productName)
     {
         Product product = (Product) productService.getProductsByName(productName);
         return ResponseEntity.ok(product);
     }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product productDetails)
    {
        Product updatedProduct = productService.getProductsById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found: " +  id));

        updatedProduct.setName(productDetails.getName());
        updatedProduct.setProductCategory(productDetails.getProductCategory());
        updatedProduct.setUnitPrice(productDetails.getUnitPrice());
        updatedProduct.setProductImage(productDetails.getProductImage());
        updatedProduct.setProductCondition(productDetails.getProductCondition());
        updatedProduct.setProductDescription(productDetails.getProductDescription());

        productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(updatedProduct);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id)
    {
        Product product = productService.getProductsById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not found: " +  id));
        productService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
