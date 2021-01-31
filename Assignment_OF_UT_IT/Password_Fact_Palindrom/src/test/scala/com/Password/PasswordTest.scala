package com.Password

import  org.scalatest.AsyncFlatSpec;

class PasswordTest extends AsyncFlatSpec {

  "Password" should "Valid" in {

    val password = scala.io.StdIn.readLine()
    assert(Password.PasswordValidator(password))
  }

}
