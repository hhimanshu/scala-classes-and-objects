package com {
  package bonsaiilabs {
    package entities {
      case class AnotherUser(f: String, l: String)
    }
  }
}

package main {
  import com.bonsaiilabs.entities.AnotherUser
  object Runner extends App {
    val u: AnotherUser = AnotherUser("Tim", "Cook")
    println(u)
  }
}



