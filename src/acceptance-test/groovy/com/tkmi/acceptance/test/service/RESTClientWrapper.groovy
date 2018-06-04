package com.tkmi.acceptance.test.service

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Service

@PropertySource('classpath:application-acceptance.properties')
@Service
class RESTClientWrapper {
	
	@Value('${acceptance.rest.host}') host
	@Value('${acceptance.rest.port}') port
	
	@Bean
	RESTClient restClient(Properties properties) {
		new RESTClient("http://$host:$port")
	}
}
