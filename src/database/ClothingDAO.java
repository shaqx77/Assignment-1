package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingDAO {

    public void insertItem(ClothingItem item) {
        String sql = "INSERT INTO clothing_item (name, category, price, brand, size, stock_quantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getCategory());
            pstmt.setDouble(3, item.getPrice());
            pstmt.setString(4, item.getBrand());
            pstmt.setString(5, item.getSize());
            pstmt.setInt(6, item.getStockQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<ClothingItem> getAllItems() {
        List<ClothingItem> items = new ArrayList<>();
        String sql = "SELECT * FROM clothing_item ORDER BY item_id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) items.add(map(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return items;
    }

    public ClothingItem getItemById(int id) {
        String sql = "SELECT * FROM clothing_item WHERE item_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return map(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public boolean updateItem(ClothingItem item) {
        String sql = "UPDATE clothing_item SET name=?, price=?, brand=?, stock_quantity=? WHERE item_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setString(3, item.getBrand());
            pstmt.setInt(4, item.getStockQuantity());
            pstmt.setInt(5, item.getItemId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteItem(int id) {
        String sql = "DELETE FROM clothing_item WHERE item_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ClothingItem> searchByName(String name) {
        List<ClothingItem> items = new ArrayList<>();
        String sql = "SELECT * FROM clothing_item WHERE name ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) items.add(map(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return items;
    }

    private ClothingItem map(ResultSet rs) throws SQLException {
        int id = rs.getInt("item_id");
        String name = rs.getString("name");
        String cat = rs.getString("category");
        double pr = rs.getDouble("price");
        String br = rs.getString("brand");
        String sz = rs.getString("size");
        int st = rs.getInt("stock_quantity");
        return cat.equalsIgnoreCase("Jacket") ?
                new Jacket(id, name, sz, pr, br, st, true) :
                new Shirt(id, name, sz, pr, br, st, "Cotton");
    }
}