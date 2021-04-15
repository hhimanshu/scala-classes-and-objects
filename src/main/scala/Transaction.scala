import java.time.LocalDateTime

sealed trait Kind
case object Debit extends Kind
case object Credit extends Kind
case object Refund extends Kind

case class Transaction(name: String, amount: Double, kind: Kind, when: LocalDateTime)

object TransactionRunner extends App {
  private val when = LocalDateTime.now
  val t1 = Transaction("T1", 12.22, Debit, when)
  println(t1.toString)

  val t2 = Transaction("T1", 12.22, Credit, when)
  println(t1 == t2)
  println(t1.hashCode())

  val t3 = t1.copy(name = "T3", amount = 100.23, kind = Refund)
  println(t3)

  val amount = t3 match {
    case Transaction(_, amount, kind, _) if kind == Debit && amount > 20  => amount - 20
    case t: Transaction => t.amount
  }
  println(amount)

  def getMessage(kind: Kind): String = kind match {
    case Debit => "Debit Transaction"
    case Credit => "Credit Transaction"
    case Refund => "Refund Transaction"
  }
  println(getMessage(t3.kind))
}