package com.org.cc.service

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import com.org.cc.service.models.CConverter

trait CCService extends Service {

  def convertCurrency(source: String): ServiceCall[CConverter,CConverter]

  override final def descriptor: Descriptor = {
    import Service._
    named("currency-convertor")
      .withCalls(
        restCall(Method.POST,"/v1/cc/api/convertCurrency/:source", convertCurrency _),
      ).withAutoAcl(true)
  }
}




