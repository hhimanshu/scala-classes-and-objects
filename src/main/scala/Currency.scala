object Currency {
  private val conversionTable: Map[String, Double] = Map("CAD" -> 1 / 1.30, "NZD" -> 1 / 1.50)
  def apply(code: String, amount: Double) = new Currency(code, amount)
  def createUSD(amount: Double) = new Currency("USD", amount)
  def createNZD(amount: Double) = new Currency("NZD", amount)
  def createCAD(amount: Double) = new Currency("CAD", amount)
}
class Currency(code: String, amount: Double) {
  import Currency.conversionTable
  private val _code = code
  private val _amount = amount
  private val _inUSD: Double = getCostInUsd

  private def getCostInUsd: Double = {
    _code match {
      case "USD" => _amount
      case "NZD" => _amount * conversionTable("NZD")
      case "CAD" => _amount * conversionTable("CAD")
      case _ => throw new IllegalArgumentException(s"No conversion available for ${_code}")
    }
  }

  override def toString: String = s"${code} ${_amount} = USD ${_inUSD}"
}

object CurrencyRunner extends App {
  val usd1 = Currency(code = "USD", amount = 100.12)
  println(usd1)

  val nzd1 = Currency(code = "NZD", amount = 100.12)
  println(nzd1)

  val cad1 = Currency(code = "CAD", amount = 100.12)
  println(cad1)

  import Currency._
  val usd2 = createUSD(25)
  val nzd2 = createNZD(25)
  val cad2 = createCAD(25)
  println(usd2)
  println(nzd2)
  println(cad2)
}