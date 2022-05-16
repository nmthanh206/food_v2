package hcmute.G7.Model;

public class Shop {
    String shopName;
    int imageUrl;
    int id;
    String description;
    public Shop(int id,String shopName, int imageUrl,  String description) {
        this.shopName = shopName;
        this.imageUrl = imageUrl;
        this.id = id;
        this.description = description;
    }


    public Shop(String productName, int imageUrl) {
        this.shopName = productName;
        this.imageUrl = imageUrl;
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }







}
