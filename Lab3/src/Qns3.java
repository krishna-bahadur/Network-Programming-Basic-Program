// Write a program to Split the URI into pieces.

import java.net.URI;
public class Qns3 {
    public static void main(String[] args) {
        spilter("file:/C:/Users/james/Desktop/test.jar!/test.txt");
    }
    static  void spilter(String url) {
        try {
            URI u = new URI(url);
            System.out.println("The URI is :" + u);
            System.out.println("The scheme is:" + u.getScheme());
            System.out.println("The user info:" + u.getUserInfo());
            System.out.println("The authority is: " + u.getAuthority());
            System.out.println("The host is:" + u.getHost());
            System.out.println("The port is:" + u.getPort());
            System.out.println("The path is:"+u.getPath());
            System.out.println("The query is :"+u.getQuery());

        } catch (Exception ex) {
            System.out.println("Error "+ex);
        }
    }
}
