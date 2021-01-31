package com.knoldus.Validator
import com.knoldus.db.UserReadDto
import com.knoldus.models.User
import com.knoldus.request.UserImpl
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.AsyncFlatSpec

class UserValidatorTest extends AsyncFlatSpec {
  val userReadDto = new UserReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)



  "User" should "exist" in {
    val PiyushEmployee: User = User("Piyush", "Agrawal", 21,"Knoldus" , "piyushagarawal@gmail.com")
   val result =userValidator.userIsValid(PiyushEmployee)
    var  valid = emailValidator.emailIdIsValid(PiyushEmployee.emailId)
    assert(result && valid)
  }

  it should "be invalid as company does not exist" in {
    val klausEmployee: User = User("Raju","Sharma",30,"Wipro","Raju@wipro.com")
    val result =  userValidator.userIsValid(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(result && valid)
  }



}
