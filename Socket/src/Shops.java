public class Shops {
    private  String product;
    private  double price;
    private  int size;
    public  Shops (String product , double price , int  size){
        setName(product);
        setPrice(price);
        setSize(size);
    }
    public void  setPrice(double newPrice) {
        if (newPrice > 0)
            price = newPrice;
        else
            System.out.println("price is less than 0 or equal please put a number more than 0");
    }
    public  void setName (String newProduct){
        if (newProduct.isEmpty()) {
            System.out.println("please put a  name of this product");
        } else
            product= newProduct;    }
    public  void setSize (int newSize){
        if (newSize > 0 && newSize < 50)
            size =newSize;
        else
            System.out.println("please put a nummber more than 0 and less than 50");
    }
    public  String  getProduct (){
        return  product;
    }
    public  int getSize (){
        return  size;
    }
    public  double getPrice (){
        return  price;
    }

}

