package com.knoldus.db

import com.knoldus.models.Company
import org.scalatest.AsyncFlatSpec

class CompanyReadDtoTest extends  AsyncFlatSpec{
  val companyReadDto = new CompanyReadDto
  "Company" should "exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(result.contains(Company("Knoldus", "knoldus@gmail.com", "Noida")))
  }

  it should " not exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Ksolve")
    assert(!result.contains(Company("Ksolve", "Ksolve@gmail.com", "Noida")))
  }

  "Company Tseries" should "not available in database" in{
    var getCompany =companyReadDto.getCompanyByName("Tseries")
    assert(!getCompany.contains(Company("Tseries", "Tseries@gmail.com", "Noida")))
  }

  "Company IRS" should "not be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("IRS")
    assert(getCompany.isEmpty)
  }

  "Company DTC" should "not be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("DTC")
    assert(getCompany.isEmpty)
  }




}
