package com.knoldus.Validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.models.Company
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.AsyncFlatSpec

class UserValidatorTest extends AsyncFlatSpec {

  val googleCompany: Company = Company("Google", "google@gmail.com", "Noida")
  val piyushUser: User = User("Piyush","Agrawal",23,"knoldus","vaibhav@knoldus.com")
  val mockedCompanyREadDto: CompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator: EmailValidator = mock[EmailValidator]

  "User" should "be a valid user" in{

    when(mockedCompanyREadDto.getCompanyByName(piyushUser.companyName)) thenReturn Option(googleCompany)
    when(mockedEmailValidator.emailIdIsValid(piyushUser.emailId)) thenReturn true
    val userValidator= new UserValidator()
    val result=userValidator.userIsValid(piyushUser)
    assert(result)
  }

  "User" should "be a invalid user as it already exists" in{

    when(mockedCompanyREadDto.getCompanyByName(piyushUser.companyName)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(piyushUser.emailId)) thenReturn true
    val userValidator= new UserValidator()
    val result=userValidator.userIsValid(piyushUser)
    assert(result)
  }

  "User" should "be a invalid user and email id is valid" in{

    when(mockedCompanyREadDto.getCompanyByName(piyushUser.companyName)) thenReturn Option(googleCompany)
    when(mockedEmailValidator.emailIdIsValid(piyushUser.emailId)) thenReturn false
    val userValidator= new UserValidator()
    val result=userValidator.userIsValid(piyushUser)
    assert(result)
  }

  "User" should "be a invalid user and as email id is invalid" in{

    when(mockedCompanyREadDto.getCompanyByName(piyushUser.companyName)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(piyushUser.emailId)) thenReturn false
    val userValidator= new UserValidator()
    val result=userValidator.userIsValid(piyushUser)
    assert(result)
  }
}