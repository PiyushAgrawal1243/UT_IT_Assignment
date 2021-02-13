package com.Password

import com.Fact_Palindrom.Fact_Palindrom
import org.scalatest.AsyncFlatSpec;

class PasswordTest extends AsyncFlatSpec {

  "Password" should "Valid" in {

    assert(Password.PasswordValidator("Piyush123@"))

  }
  "String" should "Plaindrom" in {
    assert(Fact_Palindrom.Palindrom("12321"))
  }



  "String" should "not Plaindrom" in {
    assert(!Fact_Palindrom.Palindrom("1231"))
  }

}
