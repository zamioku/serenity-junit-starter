package sauce.inventory;

public class CartItem {
    public String title;
    public String description;
    public Double price;

    public CartItem(String title, String desc, Double price){
        this.title = title;
        this.description = desc;
        this.price = price;
    }

}
