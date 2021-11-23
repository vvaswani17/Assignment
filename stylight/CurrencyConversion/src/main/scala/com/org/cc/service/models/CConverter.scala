package com.org.cc.service.models

import play.api.libs.json.{Format, Json}

case class CConverter(value: Double, currency: String)

object CConverter {
  /* Format for converting greeting messages to and from JSON.
   This will be picked up by a Lagom implicit conversion from Play's JSON format to Lagom's message serializer.*/
  implicit val format: Format[CConverter] = Json.format[CConverter]
}
