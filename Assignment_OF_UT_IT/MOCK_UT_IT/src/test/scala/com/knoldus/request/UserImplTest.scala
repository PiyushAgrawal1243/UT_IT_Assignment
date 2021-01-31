package com.knoldus.request
import com.knoldus.db.UserReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.AsyncFlatSpec

class UserImplTest extends AsyncFlatSpec {
  val userReadDto = new UserReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)



  "User" should "exist" in {
    val PiyushEmployee: User = User("Piyush", "Agrawal", 21,"Knoldus" , "piyushagarawal@gmail.com")
    val result =  userImpl.createUser(PiyushEmployee)
    var  valid = emailValidator.emailIdIsValid(PiyushEmployee.emailId)
    assert(result==Some("piyushagarawal@gmail.com") && valid)
  }

  it should "be invalid as company does not exist" in {
    val klausEmployee: User = User("Klaus","Mickelson",30,"Wipro","niklaus@wipro.com")
    val result =  userImpl.createUser(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(!result.isEmpty && valid)
  }



}
