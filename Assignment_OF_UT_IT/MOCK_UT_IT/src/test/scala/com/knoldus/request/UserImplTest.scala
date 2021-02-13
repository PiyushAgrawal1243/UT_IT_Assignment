package com.knoldus.request
import com.knoldus.db.UserReadDto
import com.knoldus.models.{Company, User}
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.AsyncFlatSpec

class UserImplTest extends AsyncFlatSpec {
  val mockedUserValidate: UserValidator = mock[UserValidator]
  val mockemailValidator :EmailValidator =mock[EmailValidator]

  val piyushUser: User = User("Piyush","Agrawal",23,"knoldus","piyush@knoldus.com")
  val shivUser: User = User("Shiv","Shanker",23,"knoldus","shiv.shanker@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "User" should "be valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(piyushUser)) thenReturn true
    val result = userImpl.createUser(piyushUser)
    val emailvalid = mockemailValidator.emailIdIsValid(piyushUser.emailId)
    assert(result.isDefined && emailvalid)
  }

  "User" should "not valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(shivUser)) thenReturn false
    val result = userImpl.createUser(shivUser)
    val emailvalid = mockemailValidator.emailIdIsValid(shivUser.emailId)
    assert(result.isEmpty  && emailvalid)
  }










}
