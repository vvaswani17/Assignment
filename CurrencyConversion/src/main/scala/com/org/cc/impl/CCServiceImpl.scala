package com.org.cc.impl

import akka.NotUsed
import akka.util.Timeout
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.org.cc.service.CCService
import com.org.cc.service.models.CConverter

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class CCServiceImpl (service: ServiceCallFunctions)(implicit ec: ExecutionContext)
  extends CCService {

  implicit val timeout = Timeout(1200.seconds)

  override def convertCurrency(source: String): ServiceCall[CConverter, CConverter] = {
    request =>
      service.convertCurrency(source,request)
  }
}
