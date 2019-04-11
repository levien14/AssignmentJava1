package controller;

import entity.Employee;
import model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    EmployeeModel employeeModel = new EmployeeModel();
    Scanner sc = new Scanner(System.in);
    public void register(){
        boolean check = true;
        while (check){
            System.out.println("Enter your name : ");
            String name = sc.nextLine();
            System.out.println("Enter your address : ");
            String add = sc.nextLine();
            System.out.println("Enter your email : ");
            String email = sc.nextLine();
            System.out.println("Enter your account : ");
            String account = sc.nextLine();
            System.out.println("Enter your password : ");
            String password = sc.nextLine();
            if (employeeModel.checkExistAccount(account)){
                Employee employee = new Employee(name,add,email,account,password);
                if (employeeModel.register(employee)){
                    System.out.println("Register success");
                }else{
                    System.out.println("Currently cannot register, please try again at another time. Thanks !!!");
                }
                check = false;
            }else{
                System.out.println("Account already exists, please register another account. Thanks !!!  ");
            }
        }
    }
    public void login(){
        System.out.println("Enter your account : ");
        String account = sc.nextLine();
        System.out.println("Enter your password : ");
        String password = sc.nextLine();
        if (employeeModel.login(account,password) == null){
            System.out.println("wrong account information !!!");
        }else{
            Employee employee = employeeModel.login(account,password);
            System.out.println("   Information");
            System.out.printf("%15s | %15s |  %15s |  %15s |  %15s |  %15s |  %15s |  %15s | \n","Name","Address","Email","Account","Password","CreatedAt","UpdateAt","Status");
            System.out.printf("%15s | %15s |  %15s |  %15s |  %15s |  %15s |  %15s |  %15s | \n"
                    ,employee.name,employee.address,employee.email,employee.account,employee.password,employee.createdAt,employee.updateAt,employee.status);
            System.out.println("Login success");
        }
    }
}
