package springproject_1.springdemoproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "/home")
    public String home(){

        return "index.html";
    }

    @ResponseBody // @ResponseBody 어노테이션을 통해 간단하게는 String, Map, JSON 등을 전달할 수 있다. (view가 아니라 데이터)
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "테스트 String";
        return value;
    }

}
