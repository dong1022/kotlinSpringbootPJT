package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController    //Rest api controller 동작
@RequestMapping("/api") // http://localhost:8080/api uri로 해당 페이지가 노출 됌(특정한 주소를 노출할 때 사용)
class GetApiController {

    //@GetMapping(path = ["/hello","/abc"])  => path속성을 넣을 경우 uri경로를 배열로 넣어 hello 와 abc같은 여러게의 주소를 가질수 있음
    @GetMapping("/hello") // Get방식식 http://localhost:8080/api/hello uri로 동작함
    fun hello(): String{
        return "hello kotlin"
    }
    //@RequestMapping("request-mapping")  =>  http의 제한없이 get post put delete다 동작 가능함 따라서 특정 메서드만 동작하도록 제한을 주기 위해서는 하단의 어노테이션 참고
    @RequestMapping(method = [RequestMethod.GET], path = ["request-mapping"])
    fun requestMapping():String{
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable(@PathVariable name: String, @PathVariable age:Int):String{
        println("${name}, ${age}")
        return name+" "+age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age:Int):String{
        val name = "kotlin" // =====> 상단의 pathVariable에 파라미터인 name이 val name과 중복이 되면 PathVariable속성중 하나인 value 또는 name을 사용하여 uri에
                            //있는 파라미터이름을 value 또는 name에 넣어주면 PathVariable의 이름이 uri 파라미터 네임과 달라도 매핑이 가능함
        println("${_name}, ${age}")
        return _name+" "+age
    }

    @GetMapping("/get-mapping/query-param") //?name=steve&age=20
    fun queryParam(
        @RequestParam(name = "name") name: String,
        @RequestParam(value = "age") age: Int
    ):String{
        println("${name}, ${age}")
        return name+" "+age
    }

    //name, age, address, email 파라미터로 넘겨야 할 데이터의 수가 많아질 경우(이런경우는 잘 없음)
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest{
        println(userRequest)
        return userRequest
    }
}