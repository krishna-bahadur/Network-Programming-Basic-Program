//        Write a program to get the IP address of localhost and identify if the address is IPV4 or IPV6.
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Qns1 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            byte[] bytes =ip.getAddress();
            if(bytes.length == 4){
                System.out.println("IPv4");
            }
            else if(bytes.length == 16){
                System.out.println("IPv6");
            }
            else{
                System.out.println("Neither");
            }
        }
        catch (Exception ex){
            System.out.println("Error: " + ex);
        }


    }
}
