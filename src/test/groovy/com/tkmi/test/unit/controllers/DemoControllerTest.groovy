package com.tkmi.test.unit.controllers

import com.tkmi.test.unit.dataProvider.DemoDataProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Ignore
import spock.lang.Specification

@AutoConfigureMockMvc
@SpringBootTest
class DemoControllerTest extends Specification {
	
	@Autowired MockMvc mockMvc
	
  @Ignore('wip')
	def paramGreetingShouldReturnTailoredMessage() {
    given: ''
    def contentString = "{'message': ${data[0]}, 'key': ${data[1]}}"
    when:
    def response = mockMvc.perform(MockMvcRequestBuilders.post("/agg").content(contentString))
		    .andReturn().response
    then:
    assert response.content.toString() == data[2]
    where: data << DemoDataProvider.demo()
   
  }
}
