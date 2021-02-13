package com.Password

import com.Fact_Palindrom.Fact_Palindrom

object Password {

  val pattern ="^.*(?=.{8,15})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
  def PasswordValidator(password :String): Boolean = password.matches(pattern)

  println("enter no")
  val num =io.StdIn.readInt()
  Fact_Palindrom.Factorial(num)
  println("enter string")
  val string=io.StdIn.readLine()
  Fact_Palindrom.Palindrom(string)
}
