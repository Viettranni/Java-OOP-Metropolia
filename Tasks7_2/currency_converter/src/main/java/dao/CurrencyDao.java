package dao;

import entity.Converter;
import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;

// This package contains the code for accessing the database.

public class CurrencyDao {

    public static List<String> loadCurrencyCodes() {
        String sql = "SELECT currency_code FROM currencies";
        List<String> currencyCodes = new ArrayList<>();
    
        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
    
            while (rs.next()) {
                currencyCodes.add(rs.getString(1));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return currencyCodes;
    }
    
    


    public static double getRate(String currency_code) throws SQLException {
        String sql = "SELECT exchange_rate FROM currencies WHERE currency_code=?";
        
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
    
            ps.setString(1, currency_code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1); // Return exchange rate if found
                } else {
                    throw new SQLException("No exchange rate found for currency code: " + currency_code);
                }
            }
        }
    }
    
    
}