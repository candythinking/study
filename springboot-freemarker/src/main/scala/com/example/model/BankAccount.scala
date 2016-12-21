package com.example.model

import io.searchbox.annotations.JestId

import scala.beans.BeanProperty

class BankAccount {
  @JestId
  @BeanProperty var id: Long = _

  @BeanProperty var account_number: Long = _
  @BeanProperty var balance: Int = _
  @BeanProperty var firstname: String = _
  @BeanProperty var lastname: String = _
  @BeanProperty var age: Int = _
  @BeanProperty var gender: String = _
  @BeanProperty var address: String = _
  @BeanProperty var employer: String = _
  @BeanProperty var email: String = _
  @BeanProperty var city: String = _
  @BeanProperty var state: String = _

  override def toString = s"BankAccount($id, $account_number, $balance, $firstname, $lastname, $age, $gender, $address, $employer, $email, $city, $state)"
}