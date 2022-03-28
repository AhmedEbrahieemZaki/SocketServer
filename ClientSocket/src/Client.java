import java.io.DataInputStream;
import java.util.Scanner;
import java.net.Socket;
import  java.io.DataOutputStream;
public class Client {

    public static void main(String[] args) {
        try {
            int port = 8000;
            Socket clientSocket = new Socket("localhost", 8000);
            DataOutputStream outputStream=new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream inputStream= new DataInputStream(clientSocket.getInputStream());
            ClientServices clientServices=new ClientServices();
            clientServices.displayServices();
            Scanner input = new Scanner(System.in);
            label: while (true)    {
                clientServices.displayServices();
                int selectedItem = input.nextInt();
                outputStream.writeInt(selectedItem);
                switch (selectedItem) {
                    case 1:
                        String productList = inputStream.readUTF();
                        System.out.println(productList);
                        break;
                    case 2:
                        System.out.println("please put name ");
                        String newItem = input.next();
                        System.out.println("put a price");
                        double newPrice = input.nextDouble();
                      clientServices.checkNegative(newPrice);
                        System.out.println(" put a size");
                        int newSize = input.nextInt();
                        clientServices.checkNegative(newSize);
                        outputStream.writeUTF(newItem);
                        outputStream.writeDouble(newPrice);
                        outputStream.writeInt(newSize);
                        break;
                    case 3:
                        String list = inputStream.readUTF();
                        System.out.println(list);
                        System.out.println("enter the number that you want to delete");
                        int index =input.nextInt();
                        outputStream.writeInt(index);
                        break ;
                    case 4:
                        System.out.println("put the index that you want to update");
                        int inde = input.nextInt();
                        outputStream.writeInt(inde);
                        System.out.println("please put the name");
                        String cloth=input.next();
                        outputStream.writeUTF(cloth);
                        System.out.println("put the price");
                        double nPrice = input.nextDouble();
                        outputStream.writeDouble(nPrice);
                        System.out.println("put the size" );
                        int nSize=input.nextInt();
                        outputStream.writeInt(nSize);
                        break ;
                    case  0:
                        break label;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}
}
