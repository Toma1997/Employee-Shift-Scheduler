package service.employee.EmployeeService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // this means it will be dependency for some other class
public class EmployeesDAOService {

    private static int employeeCount = 10;
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Marko", "Nikolic", 2));
        employees.add(new Employee(2, "Andrej", "Jovic", 4));
        employees.add(new Employee(3, "Ana", "Peric", 1));
        employees.add(new Employee(4, "Marija", "Maric", 3));
        employees.add(new Employee(5, "Miljan", "Miljanovic", 2));
        employees.add(new Employee(6, "Marko", "Markovic", 5));
        employees.add(new Employee(7, "Zorana", "Zoric", 5.5));
        employees.add(new Employee(8, "Mirko", "Mirkovic", 2.3));
        employees.add(new Employee(9, "Anita", "Antic", 4));
        employees.add(new Employee(10, "Jovana", "Jovanovic", 3.7));
    }

    public List<Employee> getAllEmployees(){
        return employees;
    }

    public Employee addEmployee(Employee employee){
        if(employee.getEmployeeId() == null){
            employee.setEmployeeId(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee replaceEmployee(int id, Employee newEmployee){
        deleteEmployee(id);
        addEmployee(newEmployee);
        return newEmployee;
    }

    public Employee findOne(int id){
        for(Employee employee: employees){
            if(employee.getEmployeeId() == id){
                return employee;
            }
        }
        return null;
    }

    public String deleteEmployee(int id){
        for(Employee e: employees){
            if(e.getEmployeeId() == id){
                employees.remove(e);
                employeeCount--;
                return "OK, employee deleted";
            }
        }
        return "ID not valid";

    }

    public int numberOfEmployees(){
        return employeeCount;
    }

}
