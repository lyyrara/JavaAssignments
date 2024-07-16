import javax.management.InvalidApplicationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Restaurant {
	
	String restName;
	
	public Restaurant(String restName) {
		System.out.println("inside para constr....");
		this.restName = restName;
	}

	public void prepareTea() {

		System.out.println("Tea is being prepared..."+restName);
	}
}

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Restaurant restaurant = context.getBean("restaurantBean", Restaurant.class);
		
		restaurant.prepareTea();
		
	}

}



//class Restaurant {
//	
//	String restName;
//	
//	public Restaurant() {
//		System.out.println("no-arg");
//	}
//	
//	public void setRestName(String restName) {
//		System.out.println("inside setter");
//		this.restName = restName;
//	}
//
//	public void prepareTea() {
//
//		System.out.println("Tea is being prepared..."+restName);
//	}
//}
//
//public class Main {
//
//	public static void main(String[] args) {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("com\\awesome\\beans.xml");
//		
//		Restaurant restaurant = context.getBean("restaurantBean", Restaurant.class);
//		
//		restaurant.prepareTea();
//		
//	}
//
//}