package com.tkmi.acceptance.test.controllerTest

import com.tkmi.acceptance.test.AcceptanceTest
import com.tkmi.acceptance.test.dataProvider.DemoDataProvider
import spock.lang.Unroll

class DemoControllerTest extends AcceptanceTest {
	
	
	@Unroll 'Test Get Event Ticket Types Endpoint - Data table'() {
		given: 'some request'
		def payload = [
				message: message,
				key: key
		]
		when: 'getEventTicketTypes endpoint'
		def res = restService.restAgg(payload)
		then: 'actual BART response match expected'
		assert res.data.data == expected
		where: 'data table'
		message               | key           || expected
		DemoDataProvider.json | 'value'       || [5192015, 6647675, 932414, 1107660, 171793, 1498823]
		DemoDataProvider.json | 'doc_count'   || [12848485, 3308947, 3140190, 168757, 1527124]
		DemoDataProvider.json | '_doc_count'  || [[value:6647675], [value:5192015], [value:1107660], [value:932414], [value:171793], [value:1498823]]
	}

	def 'Test Get Event Ticket Types Endpoint - Shared Data Provider'() {
		given: 'some request'
		def payload = [
				message: data[0],
				key: data[1]
		]
		when: 'getEventTicketTypes endpoint'
		def res = restService.restAgg(payload)
		then: 'actual BART response match expected'
		assert res.data.data == data[2]
		where: data << DemoDataProvider.demo()
	}
	
}
