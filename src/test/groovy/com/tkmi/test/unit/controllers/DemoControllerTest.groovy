package com.tkmi.test.unit.controllers

import com.google.gson.Gson
import com.tkmi.services.DemoService
import com.tkmi.test.unit.MvcService
import com.tkmi.test.unit.dataProvider.DemoDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Unroll

import static org.mockito.Mockito.when;

@WebMvcTest
class DemoControllerTest extends MvcService {
	
	@Autowired MockMvc mockMvc
	
	@MockBean DemoService demoService
	
	@Unroll paramGreetingShouldReturnTailoredMessage() {
    given:
    def expectedContent = "Hello Mock"
    def requestBody = [
		    message: data[0],
		    key: data[1]
    ]
    when:

    when(demoService.agg()).thenReturn();
    def response = mockMvc.perform(MockMvcRequestBuilders.get(AGG_ENDPOINT)
		    .contentType('application/json; charset=UTF-8')
		    .content(new Gson().toJson(requestBody)))
		    .andReturn().response
    
	  then:
    assert response.content == "Hello Mock"
    where: data << DemoDataProvider.demo()
  }
}
