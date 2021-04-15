import java.time.LocalDateTime
import java.util.UUID

abstract class Account(id: UUID, name: String, dateOpened: LocalDateTime) {
  private val _id: UUID = id
  private var _name: String = name
  private val _dateOpened: LocalDateTime = dateOpened
  val _accountType: String

  def this(name: String) {
    this(UUID.randomUUID(), name, LocalDateTime.now)
  }

  def getId: UUID = _id
  def getName: String = _name
  def getDateOpened: LocalDateTime = _dateOpened
  def updateName(newName: String): Unit = _name = newName
  def getAccountType: String = _accountType

  override def toString: String = s"Account id=${_id},name=${_name},dateOpened=${_dateOpened}"
}

class CreditAccount(name: String) extends Account(name: String) {
  override val _accountType: String = "Credit"

  override def toString: String = s"Credit Account id=${getId},name=${getName},dateOpened=${getDateOpened},accountType=${getAccountType}"
}

class DepositsAccount(name: String) extends Account(name: String) {
  override val _accountType: String = "Deposit"
  override def toString: String = s"Deposit Account id=${getId},name=${getName},dateOpened=${getDateOpened},accountType=${getAccountType}"
}

trait Balance {
  private var _balance: Double = 0
  def getBalance: Double = _balance
  def setBalance(newBalance: Double): Unit = _balance = newBalance
  override def toString: String = s"Balance=${getBalance}"
}

trait AnnualFees extends Balance {
  override def setBalance(newBalance: Double): Unit = super.setBalance(newBalance - 100)
}

trait HighSavings extends Balance {
  override def setBalance(newBalance: Double): Unit = super.setBalance((newBalance + 500) * (1 + 0.50))
}

class PremiumSavingsAccount(name: String) extends DepositsAccount(name) with AnnualFees
// class PremiumPromotionalSavingsAccount(name: String) extends DepositsAccount(name) with AnnualFees with HighSavings
class PremiumPromotionalSavingsAccount(name: String) extends DepositsAccount(name) with HighSavings with AnnualFees

object AccountRunner extends App {
  val a1 = new PremiumSavingsAccount("Premium Savings Account")
  a1.setBalance(999)
  println(a1.getBalance)

  val a2 = new PremiumPromotionalSavingsAccount("Premium Promotional Savings Account")
  a2.setBalance(999)
  println(a2.getBalance)
}
/*
class C1
class C2
class C3
class C4 extends C1 with C2 with C3

trait T1
trait T2
trait T3
trait T4 extends T1 with T2 with T3
*/
