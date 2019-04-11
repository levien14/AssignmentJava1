package model;

import entity.Employee;


import java.sql.*;
import java.sql.SQLException;

public class EmployeeModel {
    Connection connection;
    private void initConnection(){
        try {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection("jdbc:mysql://localhost/human_resource?user=root&password=");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean register(Employee emp){
        initConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees(name,address,email,account,password,createdAt,updateAt) values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,emp.getName());
            preparedStatement.setString(2,emp.getAddress());
            preparedStatement.setString(3,emp.getEmail());
            preparedStatement.setString(4,emp.getAccount());
            preparedStatement.setString(5,emp.getPassword());
            preparedStatement.setDate(6,emp.getCreatedAt());
            preparedStatement.setDate(7,emp.getUpdateAt());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkExistAccount(String account){
        initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where account = ?");
            preparedStatement.setString(1,account);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String accountUser = rs.getString(4);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public Employee login(String account, String password){
        initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where account = ? and ?");
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(1);
                String addre = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date create = resultSet.getDate(6);
                Date update = resultSet.getDate(7);
                String status = resultSet.getString(8);

                Employee employee = new Employee(name,addre,email,account,password,create,update,status);
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
