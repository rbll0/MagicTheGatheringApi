package fiap.tds.models;

public class Cards {

    private int id_card;
    private String name_card;
    private String type_card;
    private String rarity;
    private String manaCost;
    private Integer power_card;
    private Integer toughness;

    public Cards() {
    }

    public Cards(int id_card, String name_card, String type_card, String rarity, String manaCost, Integer power_card, Integer toughness) {
        this.id_card = id_card;
        this.name_card = name_card;
        this.type_card = type_card;
        this.rarity = rarity;
        this.manaCost = manaCost;
        this.power_card = power_card;
        this.toughness = toughness;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public String getName_card() {
        return name_card;
    }

    public void setName_card(String name_card) {
        this.name_card = name_card;
    }

    public String getType_card() {
        return type_card;
    }

    public void setType_card(String type_card) {
        this.type_card = type_card;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public Integer getPower_card() {
        return power_card;
    }

    public void setPower_card(Integer power_card) {
        this.power_card = power_card;
    }

    public Integer getToughness() {
        return toughness;
    }

    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id_card=" + id_card +
                ", name_card='" + name_card + '\'' +
                ", type_card='" + type_card + '\'' +
                ", rarity='" + rarity + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", power_card=" + power_card +
                ", toughness=" + toughness +
                '}';
    }
}
