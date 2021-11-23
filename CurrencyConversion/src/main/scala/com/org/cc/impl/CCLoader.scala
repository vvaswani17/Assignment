package com.org.cc.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import com.org.cc.service.CCService
import com.softwaremill.macwire.wire
import play.api.libs.ws.ahc.AhcWSComponents

class CCLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new CCLoaderApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new CCLoaderApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[CCService])
}

abstract class CCLoaderApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {
  override lazy val lagomServer: LagomServer = serverFor[CCService](wire[CCServiceImpl])
  lazy val ccService: CCService = serviceClient.implement[CCService]
  lazy val service: ServiceCallFunctions = wire[ServiceCallFunctions]
}
