package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*
import java.lang.reflect.Method

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping():String{
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    //object mapper
    //json -> object
    // object -> json으로 변환해주는 기능
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest):UserRequest{
        //request body에 있는 json을 object의 이름과 동일하게 맞춰야 매핑이 가능함
        println(userRequest)//json -> object
        return userRequest//object -> json
    }
}