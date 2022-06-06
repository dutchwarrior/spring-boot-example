package com.orelly.demo;

import com.orelly.demo.json.Greeting;
import com.orelly.demo.json.Greeting2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context);
		//System.out.println(context.getClass().getName());
		int count = context.getBeanDefinitionCount();
		//tell how many beans spring load at start up
		//System.out.println("There are " + count + " Beans");

		//tell what are the bean loaded
		// we can see that are beans and the default name is the class name with the first letter in lower case
		//we not find Greeting this is not a managed bean in spring because it is not annotated with @Component
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}


	@Test @Disabled
	void noFGreetingInAppCtx() {
		//this is one way to get a bean
		assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(Greeting.class));
	}

	@Test
	void getBeanTwice() {
		Greeting greeting1 = context.getBean(Greeting.class);
		Greeting greeting2 = context.getBean(Greeting.class);

		greeting1.setMessage("What up?");
		System.out.println(greeting2.getMessage());
		assertSame(greeting1, greeting2);

		//by default every time you call get bean the application contest return always the same instance
		//in other words all objects in the application context are singleton. If I ask an autowiring instance
		//return always the same instance. You can change it adding prototype annotation to tell what is the scope
		// but the lesson is, is that spring is expecting to manage singleton's. For example spring doesn't want
		//to manage each connection to the database wants to manage the database connection pool.



	}

	@Test
	void getBeanTwiceGreeting2() {
		Greeting2 greeting1 = context.getBean("defaultGreeting2",Greeting2.class);
		Greeting2 greeting2 = context.getBean("defaultGreeting2", Greeting2.class);
		assertSame(greeting1, greeting2);
	}

}
