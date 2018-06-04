package com.tkmi.acceptance.test.service

import groovyx.net.http.ContentType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RestService {

  @Autowired RESTClientWrapper restClientWrapper

  public static final String AGG_ENDPOINT = '/agg'

  def restAgg(payload) {
    def resWrapper = restClientWrapper.restClient()
    resWrapper.handler.failure = resWrapper.handler.success
    resWrapper.post(path: AGG_ENDPOINT, contentType: ContentType.JSON, body: payload)
  }

}