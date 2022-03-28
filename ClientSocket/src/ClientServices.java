import java.io.DataInput;

public class ClientServices {
    DataInput inputStream;
    public static void displayServices (){
        System.out.println("welcome to Clothes mall service");
        System.out.println(" please  select a  number from these");
        System.out.println("1- display products");
        System.out.println("2- add products");
        System.out.println("3- delete a product");
        System.out.println(" 4- replace or update product");
        System.out.println("0- Exit");
    }
    public  static void checkNegative(double number){
        if (number<=0)
            System.out.println("please restart the program and put a price more than 0");

    }

}
