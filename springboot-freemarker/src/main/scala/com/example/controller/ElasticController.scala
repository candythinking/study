package com.example.controller

import com.example.model.{BankAccount, Person}
import com.google.gson.JsonObject
import io.searchbox.client.JestClientFactory
import io.searchbox.core.{Delete, Get, Index, Search}
import io.searchbox.indices.CreateIndex
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RestController}

/**
  * Docker image: https://hub.docker.com/r/sebp/elk/
  * Sample data: https://www.elastic.co/guide/en/kibana/current/getting-started.html
  * Elasticsearch DSL: https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/java-query-dsl.html
  */
@RestController
class ElasticController {

  val jestClient = new JestClientFactory().getObject

  @RequestMapping(value = Array(""))
  def index = "index"

  @RequestMapping(value = Array("/bankAccount"))
  def bankAccount: Any = {
    val searchSourceBuilder = new SearchSourceBuilder()

    // searchSourceBuilder.query(QueryBuilders.matchAllQuery())

    searchSourceBuilder.query(
      QueryBuilders.boolQuery()
        .must(QueryBuilders.matchQuery("gender", "F"))
        .must(QueryBuilders.rangeQuery("balance").gt(46000))
    )
    searchSourceBuilder.size(100)
    // pagination - results 20-30
    // searchSourceBuilder.from(20).size(10)

    println(searchSourceBuilder.toString)

    val searchBuilder = new Search.Builder(searchSourceBuilder.toString).addIndex("ba*")
    val result = jestClient.execute(searchBuilder.build())

    println(s"hits: ${result.getTotal}")

    jestClient.shutdownClient()

    val resultList = result.getSourceAsObjectList(classOf[BankAccount])
    println(s"result size: ${resultList.size}")

    resultList
  }

  @RequestMapping(value = Array("/bankAccount/{accountNumber}"))
  def bankAccountByAccountNumber(@PathVariable(value = "accountNumber") accountNumber: String): BankAccount = {
    // index must be exact!
    val get = new Get.Builder("bank", accountNumber).build()
    val result = jestClient.execute(get)

    result.getSourceAsObject(classOf[BankAccount])
  }

  @RequestMapping(value = Array("/bankAccount/create"))
  def create(): Any = {
    val newAccount = new BankAccount()
    newAccount.setAccount_number(9999)
    newAccount.setAddress("TEST ADDRESS")
    newAccount.setAge(99)
    newAccount.setBalance(999999)
    newAccount.setCity("TEST CITY")
    newAccount.setEmail("TEST EMAIL")
    newAccount.setId(9999)

    // index must be exact
    val index = new Index.Builder(newAccount).index("bank").`type`("account").build()
    val result = jestClient.execute(index)

    result.getSourceAsString
  }

  @RequestMapping(value = Array("/bankAccount/delete/{accountNumber}"))
  def deleteByAccountNumber(@PathVariable(value = "accountNumber") accountNumber: String): Any = {
    val get = new Get.Builder("bank", accountNumber).build()
    val result = jestClient.execute(get)

    // index must be exact
    val delete = new Delete.Builder(accountNumber).index("bank").`type`("account").build()
    jestClient.execute(delete)

    result.getSourceAsString
  }

  @RequestMapping(value = Array("index/create/{name}"))
  def createIndex(@PathVariable(value = "name") name: String): Any = {
    val result = jestClient.execute(new CreateIndex.Builder(name).build())

    val resultObject: JsonObject = result.getJsonObject
    val error = resultObject.get("error")
    val status = resultObject.get("status")

    error.toString
  }

  @RequestMapping(value = Array("insert/person/{index}"))
  def insertPersonIntoIndex(@PathVariable(value = "index") index: String): Any = {
    val person = Person("John")

    val result = jestClient.execute(new Index.Builder(person).index(index).`type`("person").build())

    val resultObject: JsonObject = result.getJsonObject

    result.getJsonString
  }


}