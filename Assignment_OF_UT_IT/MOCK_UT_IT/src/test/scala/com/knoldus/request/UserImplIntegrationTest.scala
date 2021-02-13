package com.knoldus.request
import com.knoldus.models.{Company, User}
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.AsyncFlatSpec
class UserImplIntegrationTest extends  AsyncFlatSpec {


    val mockedUserValidate: UserValidator = mock[UserValidator]
    val piyushUser: User = User("Piyush","Agrawal",23,"knoldus","piyush.agarwal@knoldus.com")
    val shivUser: User = User("Shiv","Shanker",23,"knoldus","shiv.shanker@knoldus.com")
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

    "User" should "be valid" in {

      val userImpl = new UserImpl(mockedUserValidate)
      when(mockedUserValidate.userIsValid(shivUser)) thenReturn true
      val result = userImpl.createUser(shivUser)
      assert(result.isDefined)
    }

    "User" should "be not valid" in {

      val userImpl = new UserImpl(mockedUserValidate)
      when(mockedUserValidate.userIsValid(piyushUser)) thenReturn false
      val result = userImpl.createUser(piyushUser)
      assert(result.isEmpty)
    }
  }
