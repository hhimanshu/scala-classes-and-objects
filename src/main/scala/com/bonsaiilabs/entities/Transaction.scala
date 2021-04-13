package com.bonsaiilabs.entities

case class Transaction(val user: User) {
  val userId: String = AppUser("Amy", "Jones").getId
  val total: Int = sum(1, 3)
}
