package service.employee.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeServiceController {

    @GetMapping(path = "hello-world")
    public  String helloWorld(){
        return "Hello world!";
    }
}
