package fr.sncf.d2d.up2dev.tortycolis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloWorlController {
   
    private final TestService testService;

    public HelloWorlController(TestService testService){
        this.testService = testService;

    }
   
   @RequestMapping(path = "/hello")
    public String home (
        @RequestParam(name = "name") String name
    ){
            // return "hello world!";
            return this.testService.sayHello(name);
    }
}
