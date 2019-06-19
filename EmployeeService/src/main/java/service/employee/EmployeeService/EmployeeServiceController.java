package service.employee.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeServiceController {

    @Autowired
    EmployeesDAOService service;

    //localhost:8080/all-employees
    @GetMapping("/all-employees")
    public List<Employee> retrieveAllEmployees(){
        return service.getAllEmployees();
    }

    // example -> localhost:8080/all-employees/2
    @GetMapping("/all-employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id){
        return service.findOne(id);
    }

    //localhost:8080/add-employee
    @PostMapping("/add-employee")
    public void addNewBook(@RequestBody Employee newEmployee){
        service.addEmployee(newEmployee);
    }

    // example -> localhost:8080/replace-employees/2
    @PutMapping("/replace-employee/{id}")
    public Employee replaceEmployee(@PathVariable int id, @RequestBody Employee newEmployee){
        return service.replaceEmployee(id, newEmployee);
    }

    // example -> localhost:8080/delete-employees/2
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    //localhost:8080/number-of-employees
    @GetMapping("/number-of-employees")
    public int employeesCount(){
        return service.numberOfEmployees();
    }


}
