package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.lang.StringBuilder
import java.lang.reflect.Method
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping():String{
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping():String{
        return "request-mapping -put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    //@Valid의 경우 전체 컨트롤러가 아닌 userRequest라는 bean에서만 validaion 체크
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        //@Valid사용시 유효성 검사에 대한 결과를 BindingResult에 담아서 보냄
        //bindingResult.hasError() => validation시 발생한 오류
        if(bindingResult.hasErrors()){
            //500 error
            val msg = StringBuilder();
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field+" : "+message+"\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }
        return ResponseEntity.ok("")
        //0.Response
//        return UserResponse().apply {
//            //1. result
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//            }
//        }.apply {
//            //2. description
//            this.description = "~~~~~~~"
//        }.apply {
//            //3. user mutable list
//            val userList = mutableListOf<UserRequest>()
//            userList.add(userRequest)
//            userList.add(UserRequest().apply {
//                this.name = "a"
//                this.age = 10
//                this.email = "a.@gmail.com"
//                this.address = "a address"
//                this.phoneNumber = "01022223333"
//            })
//            userList.add(UserRequest().apply {
//                this.name = "b"
//                this.age = 20
//                this.email = "b.@gmail.com"
//                this.address = "b address"
//                this.phoneNumber = "01055556666"
//            })
//            this.userRequest = userList
//        }
    }

}