package app.client.manager;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerClientApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Scanner input = new Scanner(System.in);

        String email = "";
        String password = "";
        System.out.println("Login to Manager Client Application");
        /*
        do{
            System.out.println("Enter manager email and password!");
            System.out.println("Email:");
            email = input.nextLine();
            System.out.println("Password:");
            password = input.nextLine();
        } while(!email.equals("toma.joksimovic@gmail.com") || !password.equals("toma1997+"));
        */
        System.out.println("Manager is logged in!");

        do{
            System.out.println("Choose if you want some operation from Employees service:");
            System.out.println("1. Detailed list of all employees");
            System.out.println("2. Retrieve one employee by ID");
            System.out.println("3. Add new employee");
            System.out.println("4. Replace employee by ID with new employee");
            System.out.println("5. Delete employee by ID");
            System.out.println("6. See number of employees");
            System.out.println("7. Exit this menu");

            int option = input.nextInt();
            if(option == 7){
                break;
            } else {
                switch (option){
                    case 1:
                        try {
                            String employees = Connection.getOrDelete("http://localhost:8080/all-employees", "GET");

                            String [] temp = employees.substring(1, employees.length()-2).split("},");

                            System.out.println("Here is the list of all employees for scheduling!");
                            for(int i = 0; i < temp.length; i++){
                                temp[i] = temp[i].substring(1);
                                System.out.println(temp[i]);
                            }

                        } catch (StringIndexOutOfBoundsException se) {
                            System.out.println("There are no more empployees!");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        System.out.println("Enter ID of an employee you want to see:");
                        int empId = input.nextInt();
                        try {
                            String response = Connection.getOrDelete("http://localhost:8080/all-employees/" + empId, "GET");
                            System.out.println(response);

                        } catch (Exception e) {
                            System.out.println("There is no such an employee!");
                        }
                        break;

                    case 3:
                        System.out.println("Enter employee first name:");
                        String firstName = input.nextLine();
                        System.out.println("Enter employee last name:");
                        String lastName = input.nextLine();
                        System.out.println("Enter employee email:");
                        String newEmail = input.nextLine();
                        System.out.println("Enter employee phone:");
                        String phone = input.nextLine();
                        System.out.println("Enter employee birth year:");
                        int birth = input.nextInt();
                        System.out.println("Enter employee's year of experience in decimal:");
                        double experience = input.nextDouble();

                        String payload = "{" +
                                "\"firstName\":" + "\"" + firstName + "\"," +
                                "\"lastName\":" + "\"" + lastName + "\"," +
                                "\"email\":" + "\"" + newEmail + "\"," +
                                "\"phone\":" + "\"" + phone + "\"," +
                                "\"birthYear\":" + birth + "," +
                                "\"firstName\":" + experience + "}";

                        try {
                            String response = Connection.post("http://localhost:8080/add-employee", payload);
                            System.out.println(response);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4:
                        System.out.println("Enter employee first name:");
                        String firstName2 = input.nextLine();
                        System.out.println("Enter employee last name:");
                        String lastName2 = input.nextLine();
                        System.out.println("Enter employee email:");
                        String newEmail2 = input.nextLine();
                        System.out.println("Enter employee phone:");
                        String phone2 = input.nextLine();
                        System.out.println("Enter employee birth year:");
                        int birth2 = input.nextInt();
                        System.out.println("Enter employee's year of experience in decimal:");
                        double experience2 = input.nextDouble();

                        String payload2 = "{" +
                                "\"firstName\":" + "\"" + firstName2 + "\"," +
                                "\"lastName\":" + "\"" + lastName2 + "\"," +
                                "\"email\":" + "\"" + newEmail2 + "\"," +
                                "\"phone\":" + "\"" + phone2 + "\"," +
                                "\"birthYear\":" + birth2 + "," +
                                "\"firstName\":" + experience2 + "}";

                        System.out.println("Enter ID of employee you wanna replace:");
                        int repId = input.nextInt();
                        try {
                            String response = Connection.post("http://localhost:8080/replace-employee/" + repId , payload2);
                            System.out.println(response);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 5:
                        System.out.println("Enter ID of an employee you want to delete:");
                        int empId2 = input.nextInt();
                        try {
                            String response = Connection.getOrDelete("http://localhost:8080/delete-employee/" + empId2, "DELETE");
                            System.out.println(response);

                        } catch (Exception e) {
                            System.out.println("There is no such an employee!");
                            e.printStackTrace();
                        }
                        break;

                    case 6:
                        System.out.println("Number of employees for scheduling in shifts:");
                        try {
                            String response = Connection.getOrDelete("http://localhost:8080/number-of-employees", "GET");
                            System.out.println(response);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        System.out.println("There is no such option in menu!");
                        break;
                }
            }

            System.out.println();
        } while(true);
    }
}
