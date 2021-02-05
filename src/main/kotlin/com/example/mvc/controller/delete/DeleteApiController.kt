package com.example.mvc.controller.delete


import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated //해당 어노테이션을 넣게 되면 하위의 컨트롤러에 validation 과 관련된 기능(@NotNull,@Min)을 실행시킴
class DeleteApiController {
    //1.path variable
    //2.request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value="name") _name :String,
        @NotNull(message = "age값이 누락되었습니다다") //쿼리파람의 null checking
        @Min(value=20, message = "age는 2보다 커야 합니다.") //쿼리파람의 최소값 checking
        @RequestParam(name="age") _age :Int //age는 bean이 아니기 때문에 상단에 @Validated를 추가 시켜야 함
    ):String{
        println(_name)
        println(_age)
        return _name+" "+_age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @Size(min=2, max=10, message = "이름의 길이가 2~10자리여야 합니다.")// String파람 문자 최소 ,최대 길이 체크
        @NotNull
        @PathVariable(value="name") _name:String,

        @NotNull(message = "age값이 누락되었습니다다") //쿼리파람의 null checking
        @Min(value=20, message = "age는 2보다 커야 합니다.") //쿼리파람의 최소값 checking
        @PathVariable(name="age") _age: Int):String{
        println(_name)
        println(_age)
        return _name+" "+_age
    }
}