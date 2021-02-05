package com.example.mvc.model.http

import com.example.mvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)//json에 snakeCase로 작성된 이름이 여러개일 경우 JsonPropertyf를 일일히 수정 할 필요 없이 JsonNaming을 통해 일괄 수정도 가능함.
data class UserRequest (
    //코틀린에서 네이밍 컨벤션은 카멜케이스
    @field:NotEmpty
    @field:Size(min=2, max=8)
    var name:String?=null,

    @field:PositiveOrZero
    var age:Int?=null,

    @field:Email
    var email:String?=null,

    @field:NotBlank
    var address:String?=null,

    //@JsonProperty("phone_number")// json과 object의 네이밍이 다를때 JsonProperty를 이용하여 이름을 매핑한다.
    @field:Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phoneNumber:String?=null, //rest api의 json은 스네이크케이스(phone_number)가 많음 즉 json의 네이밍과 object의 네이밍이 달라서 mapping이 불가함

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss 형태로
){
    //SpringBoot Validation에 없는 기능의 경우 생성방법
//    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss입니다")
//    private fun isValidCreatedAt():Boolean{
//        return try{
//            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            true
//        }catch(e:Exception){
//            false
//        }
//    }
}