// Write a program to display all the Inet4Address properties of localhost.
import java.net.Inet4Address;
import java.util.Arrays;

public class Qns3 {
    public static void main(String[] args) {
        try{
            String url1 = "facebook.com";
            String url2 = "google.com";

            Inet4Address ip1 = (Inet4Address) Inet4Address.getByName(url1);
            Inet4Address ip2 = (Inet4Address) Inet4Address.getByName(url2);

            System.out.println("Address : " + Arrays.toString(ip1.getAddress()));

            System.out.println("Host Address : " + ip1.getHostAddress());

            System.out.println("isAnyLocalAddress : " + ip1.isAnyLocalAddress());

            System.out.println("isLinkLocalAddress : " + ip1.isLinkLocalAddress());

            System.out.println("isLoopbackAddress : " + ip1.isLoopbackAddress());

            System.out.println("isMCGlobal : " + ip1.isMCGlobal());

            System.out.println("isMCLinkLocal : " + ip1.isMCLinkLocal());

            System.out.println("isMCNodeLocal : " + ip1.isMCNodeLocal());

            System.out.println("isMCOrgLocal : " + ip1.isMCOrgLocal());

            System.out.println("isMCSiteLocal : " + ip1.isMCSiteLocal());

            System.out.println("isMulticastAddress : " + ip1.isMulticastAddress());

            System.out.println("isSiteLocalAddress : " + ip1.isSiteLocalAddress());

            System.out.println("hashCode : " + ip1.hashCode());
            System.out.println("hashCode : " + ip2.hashCode());

            System.out.println("ip1==ip2 : " + ip1.equals(ip2));
        }
        catch (Exception ex){
            System.out.println("Error :" + ex);
        }

    }
}
