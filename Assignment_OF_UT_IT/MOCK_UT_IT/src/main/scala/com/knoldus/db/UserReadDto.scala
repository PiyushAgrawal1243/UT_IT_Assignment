package com.knoldus.db

import com.knoldus.models.{Company, User}

import scala.collection.immutable.HashMap

class UserReadDto {
  val user1: User = User("Piyush","Agrawal", 22, "knoldus","piyushagarwal@gmail.com")
  val user2: User = User("Shiv","Shanker",23,"Google","Shivshanker@gmail.com")
  val users: HashMap[String, User] = HashMap("Piyush" -> user1, "Shiv" -> user2)

  def getUserByName(name: String): Option[User] = users.get(name)

}
