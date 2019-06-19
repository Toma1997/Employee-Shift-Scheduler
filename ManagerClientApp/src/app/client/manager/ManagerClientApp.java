package app.client.manager;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class ManagerClientApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Scanner input = new Scanner(System.in);

        String email = "";
        String password = "";
        System.out.println("Login to Manager Client Application");
        do{
            System.out.println("Enter manager email and password!");
            System.out.println("Email:");
            email = input.nextLine();
            System.out.println("Password:");
            password = input.nextLine();
        } while(!email.equals("toma.joksimovic@gmail.com") || !password.equals("toma1997+"));

        System.out.println("Manager is logged in!");
    }
}
