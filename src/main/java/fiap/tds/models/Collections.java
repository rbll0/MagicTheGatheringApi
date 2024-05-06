package fiap.tds.models;

public class Collections {

    private int id_collection;
    private String name_collection;
    private String description_collection;
    private String created_at;

    public Collections() {
    }


    public Collections(int id_collection, String name_collection, String description_collection, String created_at) {
        this.id_collection = id_collection;
        this.name_collection = name_collection;
        this.description_collection = description_collection;
        this.created_at = created_at;
    }

    public int getId_collection() {
        return id_collection;
    }

    public void setId_collection(int id_collection) {
        this.id_collection = id_collection;
    }

    public String getName_collection() {
        return name_collection;
    }

    public void setName_collection(String name_collection) {
        this.name_collection = name_collection;
    }

    public String getDescription_collection() {
        return description_collection;
    }

    public void setDescription_collection(String description_collection) {
        this.description_collection = description_collection;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "id_collection=" + id_collection +
                ", name_collection='" + name_collection + '\'' +
                ", description_collection='" + description_collection + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
