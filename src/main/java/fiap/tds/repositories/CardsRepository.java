package fiap.tds.repositories;

import fiap.tds.infraestructure.DatabaseConnection;
import fiap.tds.models.Cards;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardsRepository {
    private DatabaseConnection dbConnection;

    public CardsRepository() {
        this.dbConnection = new DatabaseConnection();
    }

    public List<Cards> getCardAll() {
        List<Cards> cardsList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Cards");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cardsList.add(new Cards(
                        rs.getInt("id_card"),
                        rs.getString("name_card"),
                        rs.getString("type_card"),
                        rs.getString("rarity"),
                        rs.getString("manaCost"),
                        rs.getInt("power_card"),
                        rs.getInt("toughness")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardsList;
    }


    public Cards getCardById(int id) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Cards WHERE id_card = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cards(
                        rs.getInt("id_card"),
                        rs.getString("name_card"),
                        rs.getString("type_card"),
                        rs.getString("rarity"),
                        rs.getString("manaCost"),
                        rs.getInt("power_card"),
                        rs.getInt("toughness"));
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCard(Cards card) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(
                    "INSERT INTO Cards (" +
                            "id_card,name_card, " +
                            "type_card, rarity, " +
                            "manaCost, power_card," +
                            " toughness) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, card.getId_card());
            stmt.setString(2, card.getName_card());
            stmt.setString(3, card.getType_card());
            stmt.setString(4, card.getRarity());
            stmt.setString(5, card.getManaCost());
            stmt.setInt(6, card.getPower_card());
            stmt.setInt(7, card.getToughness());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

 public void updateCard(Cards card) {
    try {
        PreparedStatement stmt = dbConnection.getConnection().prepareStatement(
                "UPDATE Cards SET " +
                        "name_card = ?, " +
                        "type_card = ?, " +
                        "rarity = ?, " +
                        "manaCost = ?, " +
                        "power_card = ?," +
                        "toughness = ? WHERE id_card = ?");
        stmt.setString(1, card.getName_card());
        stmt.setString(2, card.getType_card());
        stmt.setString(3, card.getRarity());
        stmt.setString(4, card.getManaCost());
        stmt.setInt(5, card.getPower_card());
        stmt.setInt(6, card.getToughness());
        stmt.setInt(7, card.getId_card());
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public void deleteCard(int id) {
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Cards WHERE id_card = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
