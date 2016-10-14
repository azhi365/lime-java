import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Resource
    private UserRepository repository;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    @ResponseBody
    String test(){
        User user = new User();
        repository.delete(user);
        repository.deleteAll();
        return "test";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}