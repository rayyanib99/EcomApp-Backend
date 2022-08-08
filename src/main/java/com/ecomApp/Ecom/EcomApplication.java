package com.ecomApp.Ecom;

import com.ecomApp.Ecom.cart.*;
import com.ecomApp.Ecom.orders.OrderService;
import com.ecomApp.Ecom.orders.Orders;
import com.ecomApp.Ecom.products.Product;
import com.ecomApp.Ecom.products.ProductService;
import com.ecomApp.Ecom.users.User;
import com.ecomApp.Ecom.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(EcomApplication.class, args);
	}

	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;

	@Override
	public void run(String... args) throws Exception 
	{
		productService.createProduct(new Product("Apple Iphone 13", "https://wholesale.alegre.net.au/assets/full/S-IPHX-ALL-NIB.jpg?20201124095923", 199.99, "Smart Phones", "In-Stock" , 5, "Straight from the warehouse to your door.", "Used"));
		productService.createProduct(new Product("Adidas Tennis Shoes - Size 8", "https://tse3.mm.bing.net/th?id=OIP.JY3vfhOnpJPGpOxICQkasQHaHa&pid=Api&P=0", 99.99, "Sports", "In-Stock", 9, "Straight from the warehouse to your door.", "New"));
		productService.createProduct(new Product("Schwinn 22in  Mountain Bike", "https://tse1.mm.bing.net/th?id=OIP.j_xhcHLP7Wa98BPfjU7MzQHaFS&pid=Api&P=0", 299.99, "Sports", "In-Stock", 2, "Straight from the warehouse to your door.", "New"));
		productService.createProduct(new Product("Bass Guitar", "https://images.reverb.com/image/upload/s--mezLTpGs--/f_auto,t_large/v1573760285/lpwteqevszthxvjmf1ju.jpg", 89.99, "Musical Instruments", "In-Stock", 10, "Straight from the warehouse to your door.", "New"));
		productService.createProduct(new Product("LG 15.5in Laptop", "https://www.bhphotovideo.com/images/images2500x2500/lg_13z990_r_aas7u1_gram_i7_8565u_16gb_256ssd_1459831.jpg", 1499.99, "Laptops", "In-Stock", 13, "Straight from the warehouse to your door.", "New"));
		productService.createProduct(new Product("Spalding BasketBall", "https://s7.orientaltrading.com/is/image/OrientalTrading/VIEWER_ZOOM/spalding-basketball-paper-dinner-plates-18-ct-~3_3411", 49.99, "Sports", "In-Stock", 18, "Straight from the warehouse to your door.", "New"));
		productService.createProduct(new Product("Nike T-Shirt - LARGE", "https://tse2.mm.bing.net/th?id=OIP.WiL2dmQxKt7lvbfGFO3jmAHaHa&pid=Api&P=0", 19.99, "Sports", "In-Stock", 7, "Straight from the warehouse to your door.", "New"));
	
		// For User
		userService.createNewUser(new User("Administrator", "N/A", "123-456-7890", "271 Capstone St.", "Cary", "NC", "27514", "USA", "admin@kamray.com", "admin1", "Yes"));
		userService.createNewUser(new User("Kamarel", "Malanda", "111-222-3333", "2510 Falls Of Neuse", "Raleigh", "NC", "27609", "USA", "kamarelngunda@gmail.com", "kamarel", "No"));
		userService.createNewUser(new User("Rayyan", "Abdulmunib", "444-555-6666", "8764 HCL Rd.", "Frisco", "TX", "75008", "USA", "ray@yahoo.com", "rayyan", "No"));
		
		// For Order 
		orderService.addOrder(new Orders(23.2, 25, "02/25/2022"));
		
		// For Cart
		cartService.addCartProduct(new Cart(23));
	}
}
