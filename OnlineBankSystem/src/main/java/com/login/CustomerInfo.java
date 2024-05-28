package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerInfo")
public class CustomerInfo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("accountNumber");

        if (accountNumber == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/sravanthi";
        String username = "root";
        String password = "Rohith123#";

        Customer customer = null;
        Addresss address = null;
        CusAddress cusaddress = null;
//        List<Transaction> transactions = new ArrayList<>();
        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            // Fetch personal info
            String sql1 = "SELECT * FROM personalinfo WHERE acc = ?";
            PreparedStatement statement1 = con.prepareStatement(sql1);
            statement1.setString(1, accountNumber);
            ResultSet resultSet1 = statement1.executeQuery();
            if (resultSet1.next()) {
                String firstname = resultSet1.getString("fname");
                String lastname = resultSet1.getString("lname");
                String fathername = resultSet1.getString("father");
                String mothername = resultSet1.getString("mother");
                String gender = resultSet1.getString("gender");
                String dob = resultSet1.getDate("dob").toString();
                String acctype = resultSet1.getString("acctype");
                double balance = resultSet1.getDouble("balance");
                customer = new Customer(accountNumber, firstname, lastname, fathername, mothername, gender, dob, acctype, balance);
            }
            resultSet1.close();
            statement1.close();

            // Fetch KYC info
            String sql2 = "SELECT * FROM kyc WHERE acc = ?";
            PreparedStatement statement2 = con.prepareStatement(sql2);
            statement2.setString(1, accountNumber);
            ResultSet resultSet2 = statement2.executeQuery();
            if (resultSet2.next()) {
                String pan = resultSet2.getString("pan");
                String adhar = resultSet2.getString("adhar");
                String email = resultSet2.getString("email");
                String phone = resultSet2.getString("phone");
                address = new Addresss(accountNumber, pan, adhar, email, phone);
            }
            resultSet2.close();
            statement2.close();

            // Fetch address info
            String sql3 = "SELECT * FROM address WHERE acc = ?";
            PreparedStatement statement3 = con.prepareStatement(sql3);
            statement3.setString(1, accountNumber);
            ResultSet resultSet3 = statement3.executeQuery();
            if (resultSet3.next()) {
                String add1 = resultSet3.getString("add1");
                String state = resultSet3.getString("state");
                String add2 = resultSet3.getString("add2");
                String zip = resultSet3.getString("zip");
                cusaddress = new CusAddress(accountNumber, add1, state, add2, zip);
            }
            resultSet3.close();
            statement3.close();

//            // Fetch transactions
//            String sql4 = "SELECT * FROM transactions WHERE acc = ? ORDER BY date DESC";
//            PreparedStatement statement4 = con.prepareStatement(sql4);
//            statement4.setString(1, accountNumber);
//            ResultSet resultSet4 = statement4.executeQuery();
//            if (resultSet4.next()) {
//                int id = resultSet4.getInt("id");
//                String type = resultSet4.getString("type");
//                double amount = resultSet4.getDouble("amount");
//                double balanceAfter = resultSet4.getDouble("balance_after");
//                String date = resultSet4.getTimestamp("date").toString();
//                transactions.add(new Transaction(id, accountNumber, type, amount, balanceAfter, date));
//            }
//            resultSet4.close();
//            statement4.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

     // Set customer, address, and cusaddress attributes for profile.jsp
        request.setAttribute("customer", customer);
        request.setAttribute("address", address);
        request.setAttribute("cusaddress", cusaddress);
//        request.setAttribute("transactions", transactions);

        // Forward to profile.jsp
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
//        request.setAttribute("customer", customer);
//        request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);

//        // Set transactions attribute for transactions.jsp
//        request.setAttribute("transactions", transactions);
//
//        // Forward to transactions.jsp
//        request.getRequestDispatcher("/transactions.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNumber = (String) session.getAttribute("accountNumber");
        String action = request.getParameter("action");
        double amount = Double.parseDouble(request.getParameter("amount"));

        if (accountNumber == null || action == null || amount <= 0) {
            response.sendRedirect("login.jsp");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/sravanthi";
        String dbUsername = "root";
        String dbPassword = "Rohith123#";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

            if ("deposit".equals(action)) {
                handleDeposit(con, accountNumber, amount);
            } else if ("withdraw".equals(action)) {
                handleWithdraw(con, accountNumber, amount, request, response);
            } else if ("transfer".equals(action)) {
                String toAccount = request.getParameter("toAccount");
                handleTransfer(con, accountNumber, toAccount, amount, request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("CustomerInfo");
    }

    private void handleDeposit(Connection con, String accountNumber, double amount) throws Exception {
        String getBalanceSql = "SELECT balance FROM personalinfo WHERE acc = ?";
        PreparedStatement getBalanceStmt = con.prepareStatement(getBalanceSql);
        getBalanceStmt.setString(1, accountNumber);
        ResultSet rs = getBalanceStmt.executeQuery();

        if (rs.next()) {
            double currentBalance = rs.getDouble("balance");
            double newBalance = currentBalance + amount;

            String updateBalanceSql = "UPDATE personalinfo SET balance = ? WHERE acc = ?";
            PreparedStatement updateBalanceStmt = con.prepareStatement(updateBalanceSql);
            updateBalanceStmt.setDouble(1, newBalance);
            updateBalanceStmt.setString(2, accountNumber);
            updateBalanceStmt.executeUpdate();

            logTransaction(con, accountNumber, "deposit", amount, newBalance);
        }

        rs.close();
        getBalanceStmt.close();
    }

    private void handleWithdraw(Connection con, String accountNumber, double amount, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String getBalanceSql = "SELECT balance FROM personalinfo WHERE acc = ?";
        PreparedStatement getBalanceStmt = con.prepareStatement(getBalanceSql);
        getBalanceStmt.setString(1, accountNumber);
        ResultSet rs = getBalanceStmt.executeQuery();

        if (rs.next()) {
            double currentBalance = rs.getDouble("balance");

            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;

                String updateBalanceSql = "UPDATE personalinfo SET balance = ? WHERE acc = ?";
                PreparedStatement updateBalanceStmt = con.prepareStatement(updateBalanceSql);
                updateBalanceStmt.setDouble(1, newBalance);
                updateBalanceStmt.setString(2, accountNumber);
                updateBalanceStmt.executeUpdate();

                logTransaction(con, accountNumber, "withdraw", amount, newBalance);
            } else {
                request.setAttribute("error", "Insufficient balance.");
                request.getRequestDispatcher("/withdraw.jsp").forward(request, response);
            }
        }

        rs.close();
        getBalanceStmt.close();
    }

    private void handleTransfer(Connection con, String fromAccount, String toAccount, double amount, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String getFromBalanceSql = "SELECT balance FROM personalinfo WHERE acc = ?";
        PreparedStatement getFromBalanceStmt = con.prepareStatement(getFromBalanceSql);
        getFromBalanceStmt.setString(1, fromAccount);
        ResultSet rsFrom = getFromBalanceStmt.executeQuery();

        if (rsFrom.next()) {
            double fromBalance = rsFrom.getDouble("balance");

            if (fromBalance >= amount) {
                String getToBalanceSql = "SELECT balance FROM personalinfo WHERE acc = ?";
                PreparedStatement getToBalanceStmt = con.prepareStatement(getToBalanceSql);
                getToBalanceStmt.setString(1, toAccount);
                ResultSet rsTo = getToBalanceStmt.executeQuery();

                if (rsTo.next()) {
                    double toBalance = rsTo.getDouble("balance");
                    double newFromBalance = fromBalance - amount;
                    double newToBalance = toBalance + amount;

                    String updateFromBalanceSql = "UPDATE personalinfo SET balance = ? WHERE acc = ?";
                    PreparedStatement updateFromBalanceStmt = con.prepareStatement(updateFromBalanceSql);
                    updateFromBalanceStmt.setDouble(1, newFromBalance);
                    updateFromBalanceStmt.setString(2, fromAccount);
                    updateFromBalanceStmt.executeUpdate();

                    String updateToBalanceSql = "UPDATE personalinfo SET balance = ? WHERE acc = ?";
                    PreparedStatement updateToBalanceStmt = con.prepareStatement(updateToBalanceSql);
                    updateToBalanceStmt.setDouble(1, newToBalance);
                    updateToBalanceStmt.setString(2, toAccount);
                    updateToBalanceStmt.executeUpdate();

                    logTransaction(con, fromAccount, "transfer", amount, newFromBalance);
                    logTransaction(con, toAccount, "transfer", amount, newToBalance);
                } else {
                    request.setAttribute("error", "Destination account not found.");
                    request.getRequestDispatcher("/transfer.jsp").forward(request, response);
                }

                rsTo.close();
                getToBalanceStmt.close();
            } else {
                request.setAttribute("error", "Insufficient balance.");
                request.getRequestDispatcher("/transfer.jsp").forward(request, response);
            }
        }

        rsFrom.close();
        getFromBalanceStmt.close();
    }

    private void logTransaction(Connection con, String accountNumber, String type, double amount, double balanceAfter) throws Exception {
        String insertTransactionSql = "INSERT INTO transactions (acc, type, amount, balance_after) VALUES (?, ?, ?, ?)";
        PreparedStatement insertTransactionStmt = con.prepareStatement(insertTransactionSql);
        insertTransactionStmt.setString(1, accountNumber);
        insertTransactionStmt.setString(2, type);
        insertTransactionStmt.setDouble(3, amount);
        insertTransactionStmt.setDouble(4, balanceAfter);
        insertTransactionStmt.executeUpdate();
        insertTransactionStmt.close();
    }
}
