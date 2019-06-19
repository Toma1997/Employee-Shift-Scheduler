package service.employee.EmployeeService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // this means it will be dependency for some other class
public class EmployeesDAOService {

    private static int employeeCount = 6;
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Marko", "Nikolic", "marko@gmail.com", "064-234-222", 1992, 2));
        employees.add(new Employee(2, "Andrej", "Jovic", "andrej@gmail.com", "061-564-222", 1991, 4));
        employees.add(new Employee(3, "Ana", "Peric", "ana@gmail.com", "062-878-456", 1990, 1));
        employees.add(new Employee(4, "Marija", "Maric", "marija@gmail.com", "065-123-456", 1993, 3));
        employees.add(new Employee(5, "Miljan", "Miljanovic", "miljan@gmail.com", "060-000-789", 1994, 2));
        employees.add(new Employee(6, "Marko", "Markovic", "markovic@gmail.com", "069-999-123", 1990, 5));
    }

    public List<Employee> getAllEmployees(){
        return this.employees;
    }

    public Employee addEmployee(Employee employee){
        if(employee.getEmployeeId() == null){
            employee.setEmployeeId(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee replaceEmployee(int id, Employee newEmployee){
        this.employees.remove(id);
        this.employees.add(newEmployee);
        return newEmployee;
    }

    public Employee findOne(int id){
        for(Employee employee: this.employees){
            if(employee.getEmployeeId() == id){
                return employee;
            }
        }
        return null;
    }

    public String deleteEmployee(int id){

        if(id >= 0 && id<employees.size()){
            employees.remove(id-1);
            return "OK, employee deleted";
        }
        return "ID not valid";

    }

    public int numberOfEmployees(){
        return employeeCount;
    }

}
