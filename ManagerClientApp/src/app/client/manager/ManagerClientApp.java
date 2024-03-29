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

        do{
            System.out.println("Enter manager email and password!");
            System.out.println("Email:");
            email = input.nextLine();
            System.out.println("Password:");
            password = input.nextLine();
        } while(!email.equals("toma.joksimovic@gmail.com") || !password.equals("toma1997+"));

        // reset schedule
        for(int i = 0; i < 4; i++){
            String payload =  "[]";  // take list with employee's id's for current shift
            try {
                Connection.postOrPut("http://localhost:1313/set-employees-to-shift/"+ i+1, payload, "PUT");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Manager is logged in!");

        do{
            System.out.println("Choose if you want some operation from Employees service:\n");
            System.out.println("1. Detailed list of all employees");
            System.out.println("2. Retrieve one employee by ID");
            System.out.println("3. Add new employee");
            System.out.println("4. Replace employee by ID with new employee");
            System.out.println("5. Delete employee by ID");
            System.out.println("6. See number of employees");
            System.out.println("7. Detailed list of shifts");
            System.out.println("8. Retrieve one shift by ID");
            System.out.println("9. See number of shifts");
            System.out.println("10. Exit this menu");

            int option = input.nextInt();
            if(option == 10){
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
                            System.out.println("There are no more employees!");

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
                        String firstName = input.next();

                        System.out.println("Enter employee last name:");
                        String lastName = input.next();

                        System.out.println("Enter employee's year of experience in decimal:");
                        double experience = input.nextDouble();

                        String payload = "{" +
                                "\"firstName\":" + "\"" + firstName + "\"," +
                                "\"lastName\":" + "\"" + lastName + "\"," +
                                "\"yearsExperience\":" + experience + "}";

                        try {
                            String response = Connection.postOrPut("http://localhost:8080/add-employee", payload, "POST");
                            System.out.println(response);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4:
                        System.out.println("Enter employee first name:");
                        String firstName2 = input.next();

                        System.out.println("Enter employee last name:");
                        String lastName2 = input.next();

                        System.out.println("Enter employee's year of experience in decimal:");
                        double experience2 = input.nextDouble();

                        String payload2 = "{" +
                                "\"firstName\":" + "\"" + firstName2 + "\"," +
                                "\"lastName\":" + "\"" + lastName2 + "\"," +
                                "\"yearsExperience\":" + experience2 + "}";

                        System.out.println("Enter ID of employee you wanna replace:");
                        int repId = input.nextInt();
                        try {
                            String response = Connection.postOrPut("http://localhost:8080/replace-employee/" + repId , payload2, "PUT");
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

                    case 7:
                        try {
                            String shifts = Connection.getOrDelete("http://localhost:1313/all-shifts", "GET");
                            String [] tempShifts = shifts.substring(1, shifts.length()-2).split("},");

                            System.out.println("Here is the list of all shifts!");
                            for(int i = 0; i < tempShifts.length; i++){
                                tempShifts[i] = tempShifts[i].substring(1);
                                System.out.println(tempShifts[i]);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 8:
                        System.out.println("Enter ID of a shift you want to see:");
                        int shiftId = input.nextInt();
                        try {
                            String response = Connection.getOrDelete("http://localhost:1313/all-shifts/" + shiftId, "GET");
                            System.out.println(response);

                        } catch (Exception e) {
                            System.out.println("There is no such shift!");
                        }
                        break;

                    case 9:
                        System.out.println("Number of shifts for scheduling:");
                        try {
                            String response = Connection.getOrDelete("http://localhost:1313/number-of-shifts", "GET");
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

        System.out.println("Now when you have seen carefully data for employees and shifts, it's time to make schedule for their shifts!");

        try {
            String employeesScheduling = Connection.getOrDelete("http://localhost:8080/all-employees", "GET");
            String [] tempEmployeesList = employeesScheduling.substring(1, employeesScheduling.length()-2).split("},");
            String [][] employeesList = new String[tempEmployeesList.length][4]; // every employee has 4 attributes

            for(int i = 0; i < tempEmployeesList.length; i++){ // for all employees
                String [] employeeAttributes = tempEmployeesList[i].substring(1).split(",");

                for(int j = 0; j < employeeAttributes.length; j++){ // for all employee attributes
                    String oneAttribute = employeeAttributes[j].split(":")[1];
                    employeesList[i][j] = oneAttribute;
                }
            }

            String shiftsScheduling = Connection.getOrDelete("http://localhost:1313/all-shifts", "GET");
            String [] tempShiftsList = shiftsScheduling.substring(1, shiftsScheduling.length()-2).split("},");
            String [][] shiftsList = new String[tempShiftsList.length][6]; // every shift has 7 attributes

            for(int i = 0; i < tempShiftsList.length; i++){ // for all shifts
                String [] shiftAttributes = tempShiftsList[i].substring(1).split(",");

                for(int j = 0; j < shiftAttributes.length; j++){ // for all shift attributes
                    String oneAttribute = shiftAttributes[j].split(":")[1];
                    shiftsList[i][j] = oneAttribute;
                }
            }

            // save scheduled shifts with empployees ID's to PUT on Shift Web Service
            ArrayList<ArrayList<Integer>> scheduledShifts = shiftScheduler(shiftsList, employeesList);

            for(int i = 0; i < scheduledShifts.size(); i++){
                String payload =  "" + scheduledShifts.get(i) + "";  // take list with employee's id's for current shift
                System.out.println(payload);
                Connection.postOrPut("http://localhost:1313/set-employees-to-shift/"+ (i+1), payload, "PUT");
            }

            shiftsScheduling = Connection.getOrDelete("http://localhost:1313/all-shifts", "GET");
            tempShiftsList = shiftsScheduling.substring(1, shiftsScheduling.length()-2).split("},");

            System.out.println("Here is the list of all shifts with scheduled employees id's!");
            for(int i = 0; i < tempShiftsList.length; i++){
                tempShiftsList[i] = tempShiftsList[i].substring(1);
                System.out.println(tempShiftsList[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // this algorithm will reorder peoples for shifts
    // and it will return matrix with 4 lists as shifts and element in list is employee id
    public static ArrayList<ArrayList<Integer>> shiftScheduler(String [][] shifts, String [][] employees){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> morningShift = new ArrayList<>();
        ArrayList<Integer> dayShift = new ArrayList<>();
        ArrayList<Integer> afternoonShift = new ArrayList<>();
        ArrayList<Integer> nightShift = new ArrayList<>();

        employees = insertionSort(employees, 3); // empolyees are sorted in descending order by experience

        shifts = insertionSort(shifts, 4); // shifts are sorted in descending order by required experience

        boolean primaryPopulated = false;
        for(int i = 0; i < employees.length; i++){
            // if (employee has experience AND (primaryPlacesNOTPopulated || (NOT reached max places AND primaryPlacesPopulated)
            if(Double.parseDouble(employees[i][3]) >= 4 &&
                    (Integer.parseInt(shifts[0][2]) > nightShift.size() || (Integer.parseInt(shifts[0][3]) >= nightShift.size() && primaryPopulated) )){ // leastExperience = 4, shift = night
                nightShift.add(Integer.parseInt(employees[i][0])); // add employee id

            } else if(Double.parseDouble(employees[i][3]) >= 3 &&
                    (Integer.parseInt(shifts[1][2]) > afternoonShift.size() || (Integer.parseInt(shifts[1][3]) >= afternoonShift.size() && primaryPopulated) )){ // leastExperience = 3, shift = afternoon
                afternoonShift.add(Integer.parseInt(employees[i][0])); // add employee id

            } else if(Double.parseDouble(employees[i][3]) >= 2 &&
                    (Integer.parseInt(shifts[2][2]) > morningShift.size() || (Integer.parseInt(shifts[2][3]) >= morningShift.size() && primaryPopulated) )){ // leastExperience = 2, shift = morning
                morningShift.add(Integer.parseInt(employees[i][0])); // add employee id

            } else if(Double.parseDouble(employees[i][3]) >= 1 &&
                    (Integer.parseInt(shifts[3][2]) > dayShift.size() || (Integer.parseInt(shifts[3][3]) >= dayShift.size() && primaryPopulated) )) { // leastExperience = 1, shift = day
                dayShift.add(Integer.parseInt(employees[i][0])); // add employee id

            } else { // primary positions are populated, for rest of emplyees search for shift
                if(primaryPopulated){ // maximum places for shifts are reached
                    break;
                } else {
                    primaryPopulated = true;
                    i--;
                }
            }
        }
        result.add(morningShift);
        result.add(dayShift);
        result.add(afternoonShift);
        result.add(nightShift);
        return result;
    }

    // for sorting employees
    public static String [][] insertionSort(String arr[][], int experienceAttr) {
        for (int i = 1; i < arr.length; ++i) {
            String [] key = arr[i];
            int j = i - 1;

            while (j >= 0 && Double.parseDouble(arr[j][experienceAttr])  < Double.parseDouble(key[experienceAttr])) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

}
