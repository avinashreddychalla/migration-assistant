package sample.actuator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloWorldServiceTest {

	@Test
	public void expectedMessage() {
		HelloWorldService helloWorldService = new HelloWorldService();
		assertEquals("Spring boot says hello from a Docker container",helloWorldService.getHelloMessage(),"Expected correct message");
	}
	
}
