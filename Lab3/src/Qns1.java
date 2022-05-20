//  Write a program to split a URL into pieces.

import java.net.URL;

public class Qns1 {
    public static void main(String[] args) {
        spliter("https://www.google.com");
    }
    static void spliter(String url){
        try {
            URL u = new URL(url);
            System.out.println("The url is :"+ u);
            System.out.println("The schema is:"+u.getProtocol());
            System.out.println("The user info:"+u.getUserInfo());
            System.out.println("The port is:"+u.getPort());
            System.out.println("The path is:"+ u.getPath());
            System.out.println("The ref is:"+u.getRef());
        }
        catch (Exception ex){
            System.out.println("Error :"+ex);
        }
    }
}
