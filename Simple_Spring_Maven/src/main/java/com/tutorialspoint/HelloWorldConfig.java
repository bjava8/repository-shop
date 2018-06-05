/**
 * Java Based Configuration
 * https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 */
package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
	
}


/*

The above code will be equivalent to the following XML configuration −

<beans>
   <bean id = "helloWorld" class = "com.tutorialspoint.HelloWorld" />
</beans>




https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
*/