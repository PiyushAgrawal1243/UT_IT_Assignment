package  com.knoldus.Validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.AsyncFlatSpec

class CompanyValidatorTest extends AsyncFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator
  val companyImpl = new CompanyImpl(companyValidator)


  "company" should "return: already exists" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }

  it should "return 'invalid email id'" in {
    val philipsCompany: Company = Company("Philips", "abc", "Noida")
    val result = companyValidator.companyIsValid(philipsCompany)
    val emailvaild =emailValidator.emailIdIsValid(philipsCompany.emailId)
    assert(result && !emailvaild)
  }

  it should "return 'invalid email id and company already exists'" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail", "Noida")
    val result = companyValidator.companyIsValid(knoldusCompany)
    val emailvaild =emailValidator.emailIdIsValid(knoldusCompany.emailId)

    assert(result && !emailvaild)
  }



}
