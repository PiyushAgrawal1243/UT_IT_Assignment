package com.knoldus.request
import com.knoldus.db.UserReadDto
import com.knoldus.models.{Company, User}
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.AsyncFlatSpec
class UserImplIntegrationTest extends  AsyncFlatSpec {


  val userReadDto = new UserReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)

  // Integration testing for the methods of UserImpl class by providing wanted class's objects.

  "User" should "exist" in {
    val PiyushEmployee: User = User("Piyush", "Agrawal", 21,"Knoldus" , "piyushagarawal@gmail.com")
    val result =  userImpl.createUser(PiyushEmployee)
    var  valid = emailValidator.emailIdIsValid(PiyushEmployee.emailId)
    assert(result.contains(PiyushEmployee.emailId) && valid)
  }

  it should "be invalid as user does not exist" in {
    val klausEmployee: User = User("Raju","Khatri",30,"Wipro","niklaus@wipro.com")
    val result =  userImpl.createUser(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(result==None && valid)
  }

  "User" should "invalid as email id is invalid" in {

    val RakeshEmployee: User = User("Rakesh","Bansal",23,"Knoldus","rakesh.bansalknoldus.com")
    val result = userImpl.createUser(RakeshEmployee)

    val emailvalid =emailValidator.emailIdIsValid(RakeshEmployee.emailId)

    assert(result==None && !emailvalid)
  }

  "User" should "be invalid as email id is invalid and company does not exists in DB" in {

    val vaibhavUser: User = User("Vaibhav","Bansal",23,"Google","vaibhav@knoldus.com")
    val result =  userImpl.createUser(vaibhavUser)

    assert(result==None   )
  }


}
