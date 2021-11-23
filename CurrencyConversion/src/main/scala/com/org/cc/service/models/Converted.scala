package com.org.cc.service.models

import play.api.libs.json.{Format, Json}

case class Converted(value: Double )

object Converted {
  /* Format for converting greeting messages to and from JSON.
   This will be picked up by a Lagom implicit conversion from Play's JSON format to Lagom's message serializer.*/
  implicit val format: Format[Converted] = Json.format[Converted]
}
