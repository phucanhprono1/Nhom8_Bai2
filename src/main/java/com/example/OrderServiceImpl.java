package com.example;

import javax.jws.WebService;

import java.sql.*;

@WebService(endpointInterface = "com.example.OrderService")

public class OrderServiceImpl implements OrderService {
    private Connection conn;
    public String checkOrderStatus(String orderNumber, String companyID) {
        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM checkorderstatus WHERE order_number = ? ");
            stmt.setString(1, orderNumber);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String status = rs.getString("order_status");
                result=status;
            }

            rs.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}