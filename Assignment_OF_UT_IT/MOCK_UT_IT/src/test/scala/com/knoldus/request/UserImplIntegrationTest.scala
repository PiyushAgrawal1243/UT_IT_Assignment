package com.knoldus.request
import com.knoldus.db.UserReadDto
import com.knoldus.models.{Company, User}
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.AsyncFlatSpec
class UserImplIntegrationTest extends  AsyncFlatSpec {


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

  it should "be invalid as user does not exist" in {
    val klausEmployee: User = User("Raju","Khatri",30,"Wipro","niklaus@wipro.com")
    val result =  userImpl.createUser(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(!result.isEmpty && valid)
  }

  "Employee" should "invalid as email id is invalid" in {

    val PiyushEmployee: User = User("Rakesh","Bansal",23,"Knoldus","rakesh.bansal@knoldus.com")
    val result = userImpl.createUser(PiyushEmployee)
    assert(!result.isEmpty)
  }

  "Employee" should "be invalid as email id is invalid and company does not exists in DB" in {

    val vaibhavUser: User = User("Vaibhav","Bansal",23,"Google","vaibhav.knoldus.com")
    val result =  userImpl.createUser(vaibhavUser)
    assert(!result.isEmpty)
  }


}
