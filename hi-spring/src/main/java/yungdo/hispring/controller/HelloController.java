package yungdo.hispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";

    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // view 라는 템플릿에서 조작
    }

    @GetMapping("hello-string")
    @ResponseBody // http 통신 프로토콜 body 부에 이 내용을 직접 넣어주겠다.(view에 안던짐)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 뷰 없이 문자가 그대로 내려감(API) -> 소스 보면 html 태그가 없음
    }

    //문자가 아닌 데이터를 달라고 할때
    @GetMapping("hello-api")
    @ResponseBody // http에 바로 넘김 -> http message converter 동작
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //문자가 아닌 객체를 넘김(json) : 키 밸류로 이루어진 구조, 예전에는 xml 많이 썼었는데 요새는 json이 대세
    }

    static class Hello {
        private String name;

        // 게터 세터 만들기: ctrl+N
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
