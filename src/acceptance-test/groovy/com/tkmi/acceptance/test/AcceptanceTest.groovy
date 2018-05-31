package com.tkmi.acceptance.test

import com.tkmi.acceptance.test.service.RestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@ComponentScan('com.tkmi.acceptance.test')
@PropertySource('classpath:application-acceptance.properties')
@SpringBootTest
class AcceptanceTest extends Specification {
	
	@Autowired RestService restService
}
