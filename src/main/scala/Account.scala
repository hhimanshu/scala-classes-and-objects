import java.time.LocalDateTime
import java.util.UUID

class Account(id: UUID, name: String, dateOpened: LocalDateTime) {
  private val _id: UUID = id
  private var _name: String = name
  private val _dateOpened: LocalDateTime = dateOpened

  def this(name: String) {
    this(UUID.randomUUID(), name, LocalDateTime.now)
  }

  def getId: UUID = _id
  def getName: String = _name
  def getDateOpened: LocalDateTime = _dateOpened
  def updateName(newName: String): Unit = _name = newName
}

class CreditAccount(name: String) extends Account(name: String) {
  private val _accountType = "Credit"
  def getAccountType: String = _accountType
}

class DepositsAccount(name: String) extends Account(name: String) {
  private val _accountType = "Deposit"
  def getAccountType: String = _accountType
}

object AccountRunner extends App {
  val ca1: CreditAccount = new CreditAccount("Travel Mastercard")
  println(ca1.getId, ca1.getName, ca1.getDateOpened, ca1.getAccountType)

  val da1: DepositsAccount = new DepositsAccount("Super Savings")
  println(da1.getId, da1.getName, da1.getDateOpened, da1.getAccountType)
}
