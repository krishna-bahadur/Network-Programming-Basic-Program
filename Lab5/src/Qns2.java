import java.net.Socket;
import java.net.SocketException;

//Write a program to show the socket information
public class Qns2 {
    public static void main(String[] args) {
        getInfo("www.google.com");
    }
    private static void getInfo(String host){
        try{
            try{
                Socket socket = new Socket(host, 80);
                System.out.println("Connected to :"+socket.getInetAddress()
                        +"\non port :"+socket.getPort()
                        +"\nfrom Port :"+socket.getLocalPort()
                        +"\nof :"+socket.getLocalAddress());

            }
            catch (SocketException e){
                System.err.println(e);
            }
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
