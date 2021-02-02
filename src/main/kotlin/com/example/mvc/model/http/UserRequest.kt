package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)//json에 snakeCase로 작성된 이름이 여러개일 경우 JsonPropertyf를 일일히 수정 할 필요 없이 JsonNaming을 통해 일괄 수정도 가능함.
data class UserRequest (
    //코틀린에서 네이밍 컨벤션은 카멜케이스
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,
    //@JsonProperty("phone_number")// json과 object의 네이밍이 다를때 JsonProperty를 이용하여 이름을 매핑한다.
    var phoneNumber:String?=null //rest api의 json은 스네이크케이스(phone_number)가 많음 즉 json의 네이밍과 object의 네이밍이 달라서 mapping이 불가함
)