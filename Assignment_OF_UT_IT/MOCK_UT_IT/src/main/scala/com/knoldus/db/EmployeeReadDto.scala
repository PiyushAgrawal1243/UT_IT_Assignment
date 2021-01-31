package com.knoldus.db

import com.knoldus.models.{Company, Employee}

import scala.collection.immutable.HashMap

class EmployeeReadDto {


  val knoldusEmployee: Employee = Employee("Piyush", "Agrawal", 21,15000,"Intern","Knoldus","piyushagarawal@gmail.com")
  val philipsEmployee: Employee = Employee("Shiv", "Shanker", 23,30000,"Developer","Philips","Shiv@gmail.com")
  val employees: HashMap[String, Employee] = HashMap("Piyush" -> knoldusEmployee, "Shiv" -> philipsEmployee)

  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)



}
