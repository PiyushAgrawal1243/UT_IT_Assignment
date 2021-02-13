package com.knoldus.db



import  org.scalatest.AsyncFlatSpec;

class UserReadDtoTest extends AsyncFlatSpec {

  "User" should "exist" in {

    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Piyush")
    assert(result.isDefined)
  }

  "User" should "not exist" in {

    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Rakesh")
    assert(result.isEmpty)
  }
}