package com.hifix.springboot04webrestfulcrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller

public class HelloController {
@ResponseBody
@RequestMapping("/hello")
public String hello (){
    return "Hello world";
}



//@RequestMapping({"/","/index.html"})
//public String index(){
//return "login" ;
//
//}



@RequestMapping("/success")
public String success(Map<String,Object> map){
    //classpath:/templates/success.html   thymeleaf默认会自动找到该路径下的html页面进行渲染。
map.put("hello","<h1>你好</h1>");
map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

return "success";

}








}
