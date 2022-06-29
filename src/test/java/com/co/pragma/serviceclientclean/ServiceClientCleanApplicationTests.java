package com.co.pragma.serviceclientclean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.co.pragma.serviceclientclean.infraestructure.driveradapters.api.ImageClient;

@SpringBootTest
@Configuration
class ServiceClientCleanApplicationTests {
	
	
	@Test
	  void main() {
	    ServiceClientCleanApplication.main(new String[] {});
	  }
}
