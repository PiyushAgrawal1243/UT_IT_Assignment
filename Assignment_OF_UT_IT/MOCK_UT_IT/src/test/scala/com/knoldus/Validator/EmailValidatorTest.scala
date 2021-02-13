package com.knoldus.Validator

import com.knoldus.validator.EmailValidator
import org.scalatest.AsyncFlatSpec

class EmailValidatorTest extends AsyncFlatSpec {

  val emailValidator = new EmailValidator

  "email" should "have alphanumeric username in lowercase and uppercase " in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush@knoldus.com")
    assert(result)
  }

  "email" should "valid when with starting numbers" in {

    val result: Boolean = emailValidator.emailIdIsValid("2piyush@knoldus.com")
    assert(result)
  }

  "email" should "invalid with missing @" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyushknoldus.com")
    assert(!result)
  }

  "email" should "invalid with starting with special symbols except dot and underscore" in {

    val result: Boolean = emailValidator.emailIdIsValid("*/piyushknoldus.com")
    assert(!result)
  }

  "email" should "invalid with space in between" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush @knoldus.com")
    assert(!result)
  }

  "email" should "invalid with missing top level domain" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush@knoldus")
    assert(!result)
  }

  "email" should "invalid with missing domain main" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush@.com")
    assert(!result)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush@knoldus.xyz")
    assert(!result)
  }

  "email" should "invalid with more than one top level domain" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush@knoldus.com.net")
    assert(result)
  }

  "email" should "invalid with double dots after domain name" in {

    val result: Boolean = emailValidator.emailIdIsValid("piyush@knoldus..com")
    assert(result)
  }
}