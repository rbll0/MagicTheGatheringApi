package fiap.tds.repositories;

import fiap.tds.infraestructure.DatabaseConnection;
import fiap.tds.models.Collections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionsRepository {
    private DatabaseConnection dbConnection;

    public CollectionsRepository() {
        this.dbConnection = new DatabaseConnection();
    }

    public List<Collections> getAllCollections() {
        List<Collections> collectionsList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Collections");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                collectionsList.add(new Collections(
                        rs.getInt("id_collection"),
                        rs.getString("name_collection"),
                        rs.getString("description_collection"),
                        rs.getString("created_at")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return collectionsList;
    }

    public Collections getCollectionById(int id) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Collections WHERE id_collection = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Collections(
                        rs.getInt("id_collection"),
                        rs.getString("name_collection"),
                        rs.getString("description_collection"),
                        rs.getString("created_at"));
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCollection(Collections collection) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(
                    "INSERT INTO Collections (id_collection, name_collection, description_collection) VALUES (?, ?, ?)");
            stmt.setInt(1, collection.getId_collection());
            stmt.setString(2, collection.getName_collection());
            stmt.setString(3, collection.getDescription_collection());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCollection(Collections collection) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(
                    "UPDATE Collections SET  name_collection = ?, description_collection = ?, created_at = ? WHERE id_collection = ?");
            stmt.setString(1, collection.getName_collection());
            stmt.setString(2, collection.getDescription_collection());
            stmt.setString(3, collection.getCreatedAt());
            stmt.setInt(4, collection.getId_collection());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCollection(int id) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Collections WHERE id_collection = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
