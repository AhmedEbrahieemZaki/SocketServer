import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ClothesMall {
    public static void main(String[] args) {
        try {
            Mallbrain item = new Mallbrain();
            int port = 8000;
            Mallbrain brain = new Mallbrain();
            ServerSocket  sSocket =new ServerSocket(port);
            System.out.println( " waiting for client");
            Socket cSocket =sSocket.accept();
            DataInputStream dataInputStream =new DataInputStream(cSocket.getInputStream());
            DataOutputStream dataOutputStream =new DataOutputStream(cSocket.getOutputStream());
            label: while (true) {
                int sms= dataInputStream.readInt();
                System.out.println(" connection well");
                System.out.println( sms);
                switch (sms) {
                    case 1:
                        System.out.println(" display product");
                        String display = item.displayProducts();
                        dataOutputStream.writeUTF(display);
                        break;
                    case 2:
                        System.out.println("add product");
                        String newItem = dataInputStream.readUTF();
                        double newPrice = dataInputStream.readDouble();
                        int newSize = dataInputStream.readInt();
                        Shops newProduct = new Shops(newItem, newPrice, newSize);
                        item.addProduct(newProduct);
                        System.out.println("item has been added by you");
                        break;
                    case 3:
                        System.out.println("remove product");
                        String produc = item.displayProducts();
                        dataOutputStream.writeUTF(produc);
                        int ind = dataInputStream.readInt() ;
                        item.removeProduct(ind);
                        break;
                    case  4:
                        System.out.println("update or replace product");
                        System.out.println("choose and index that you want to update");
                        int inde = dataInputStream.readInt() ;
                        System.out.println("choose the product name");
                        String cloth = dataInputStream.readUTF();
                        System.out.println("put the price");
                        double nPrice= dataInputStream.readDouble();
                        System.out.println("put the size");
                        int nSize= dataInputStream.readInt();
                        Shops nP=new Shops(cloth,nPrice,nSize);
                        item.updateProduct(inde,nP);
                        break ;
                    case 0:
                        break label;
                    default:
                        System.out.println(" Please select a number between  1 to 4");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}