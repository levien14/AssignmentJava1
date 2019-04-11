package controller;

import java.util.Scanner;

public class MenuController {
    EmployeeController employeeController = new EmployeeController();

    public void Menu() {
        while (true) {
        String choose;
        Scanner sc = new Scanner(System.in);
        System.out.println("-------MENU-------");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println(" Enter choose : ");
        choose = sc.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("--Register--");
                    employeeController.register();
                    break;
                case "2":
                    System.out.println("--Login--");
                    employeeController.login();
                    break;
                case "3":
                    System.out.println("--GoodBye--");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose 1 to 3");
                    break;
            }
        }
    }
}
