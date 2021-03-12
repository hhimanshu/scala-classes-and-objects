import java.util.UUID

class Customer(first: String, last: String, email: String) { // add final to seal a class from inheriting
  private val _id: UUID = UUID.randomUUID()
  private val _first = first
  private val _last = last
  private val _email = email

  def getId: UUID = _id
  def getFirst: String = _first
  def getLast: String = _last
  def getEmail: String = _email
}
class HackCustomer(first: String = "****", last: String="****", email: String="****") extends Customer(first, last, email) {

}

object EmailRunner extends App {
  val c1: Customer = new Customer("Tony", "Stark", "tony@stark.com")
  println(c1.getId, c1.getFirst, c1.getLast, c1.getEmail)

  val hackC1: HackCustomer = new HackCustomer()
  println(hackC1.getId, hackC1.getFirst, hackC1.getLast, hackC1.getEmail)

}