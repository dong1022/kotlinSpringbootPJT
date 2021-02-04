package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String{
        println("init main")
        return "main.html"
    }
    //=>restController와 달리 Controller의 경우 return값을 static폴더 하위에 있는 html파일 명과 맵핑하여 찾아감
    // 따라서 rest api는 restController로 붙히고 그 외의 html 페이지를 내리는 주소들은 @Controller를 사용한다.

    @ResponseBody
    //@Controller라는 페이지와 관련된 컨트롤러에서 json String을 내려야 할 경우 @ResponseBody를 사용할 경우
    //return값이 static폴더 하위의 html파일을 찾는것이 아니라 json응답을 return
    @GetMapping("/test")
    fun response(): String{
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test2")
    fun response2(): UserRequest{
        return UserRequest().apply {
            this.name = "wavvy"
        }
        //return "main.html"
    }
}