package com.org.cc.impl

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.NonFatal
import com.org.cc.service.models.CConverter
import com.typesafe.config.ConfigFactory

import scala.concurrent.Future

class ServiceCallFunctions () {

  def convertCurrency(source:String,converter: CConverter): Future[CConverter] = Future {
    val validCurrencies = ConfigFactory.load().getStringList("ValidCurrencies")
    if(validCurrencies.contains(source) && validCurrencies.contains(converter.currency)) {
      try {
        val url: String = s"https://free.currconv.com/api/v7/convert?q=${source}_${converter.currency}&compact=ultra&apiKey=35f244be42e44cc209a1"
        val json: String = scala.io.Source.fromURL(url).mkString
        val convertedAmount: Double = json.split(":")(1).replaceAll("}", "").toDouble
        CConverter(convertedAmount, source)
      } catch {
        case NonFatal(e) => throw new Exception(e.getMessage)
      }
    }else{
      CConverter(0, converter.currency)
    }
  }
}