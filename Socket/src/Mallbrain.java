import java.util.ArrayList;
public class Mallbrain {
    private ArrayList<Shops> shopList = new ArrayList<Shops>();
    public void addProduct(Shops product) {
        shopList.add(product);
    }
    public void removeProduct(int index) {
        shopList.remove(index);
    }
    public String displayProducts() {
        String newProduct = "";                                         //trouser 150
        for (int i = 0; i < shopList.size(); i++) {
            newProduct += (i + 1) + " - " + shopList.get(i).getProduct() + " " +
                    shopList.get(i).getPrice()
                    + shopList.get(i).getSize() + "\n";
        }
        return newProduct;
    }
    public void updateProduct(int index, Shops New) {
        Shops set = shopList.set(index, New);
    }
}