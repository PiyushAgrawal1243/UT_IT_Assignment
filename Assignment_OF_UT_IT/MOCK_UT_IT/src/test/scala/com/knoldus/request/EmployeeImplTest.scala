package com.knoldus.request
import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.AsyncFlatSpec

class EmployeeImplTest extends AsyncFlatSpec {
  val employeeReadDto = new EmployeeReadDto
  val emailValidator = new EmailValidator
  val employeeValidator = new EmployeeValidator
  val employeeImpl = new EmployeeImpl(employeeValidator)



  "Employee" should "exist" in {
    val PiyushEmployee: Employee = Employee("Piyush", "Agrawal", 21,15000,"Intern","Knoldus","piyushagarawal@gmail.com")
    val result =  employeeImpl.createEmployee(PiyushEmployee)
    var  valid = emailValidator.emailIdIsValid(PiyushEmployee.emailId)
    assert(result==Some("piyushagarawal@gmail.com") && valid)
  }

  it should "be invalid as employee does not exist" in {
    val klausEmployee: Employee = Employee("Klaus","Mickelson",30,40000,"Software Trainee","Wipro","niklaus@wipro.com")
    val result =  employeeImpl.createEmployee(klausEmployee)
    var  valid = emailValidator.emailIdIsValid(klausEmployee.emailId)
    assert(!result.isEmpty && valid)
  }



}
