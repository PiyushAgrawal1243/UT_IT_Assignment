package com.knoldus.request
import com.knoldus.db.UserReadDto
import com.knoldus.models.{Company, User}
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.AsyncFlatSpec

class UserImplTest extends AsyncFlatSpec {
  val mockedUserValidate: UserValidator = mock[UserValidator]
  val mockemailValidator :EmailValidator =mock[EmailValidator]

  val piyushUser: User = User("Piyush","Agrawal",23,"knoldus","piyushagarwal@gmail.com")
  val rakeshUser: User = User("Rakesh","Shanker",23,"knoldus","rakeshhanker@gmail.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "User" should "be valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(piyushUser)) thenReturn true
    val result = userImpl.createUser(piyushUser)
    val emailvalid = mockemailValidator.emailIdIsValid(piyushUser.emailId)
    assert(result.isDefined && !emailvalid)
  }

  "User" should "not exist" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(rakeshUser)) thenReturn false
    val result = userImpl.createUser(rakeshUser)
    val emailvalid = mockemailValidator.emailIdIsValid(rakeshUser.emailId)
    assert(result.isEmpty  && !emailvalid)
  }










}
