package top.jsoft.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.jsoft.springcore.model.Product;
import top.jsoft.springcore.service.CartService;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreApplication.class, args);
		CartService cartService = applicationContext.getBean(CartService.class);
		cartService.addProduct(new Product(1, "Phone", 5));
		cartService.addProduct(new Product(2, "TV", 10));
		cartService.addProduct(new Product(3, "PlayStation", 7));

		System.out.println("Get bean");
		System.out.println(cartService.getProduct(2));
		System.out.println(cartService.getProducts());

		cartService.deleteProduct(2);

		System.out.println(cartService.getProducts());

		System.out.println("Get next bean");
		CartService cartService2 = applicationContext.getBean(CartService.class);
		System.out.println(cartService2.getProducts());
	}

}
