import java.time.LocalDateTime

case class Transaction(name: String, amount: Double, kind: String, when: LocalDateTime)

object TransactionRunner extends App {
  private val when = LocalDateTime.now
  val t1 = Transaction("T1", 12.22, "debit", when)
  println(t1.toString)

  val t2 = Transaction("T1", 12.22, "debit", when)
  println(t1 == t2)
  println(t1.hashCode())

  val t3 = t1.copy(name = "T3", amount = 100.23)
  println(t3)

  val amount = t3 match {
    case Transaction(_, amount, kind, _) if kind == "debit" && amount > 20  => amount - 20
  }
  println(amount)
}