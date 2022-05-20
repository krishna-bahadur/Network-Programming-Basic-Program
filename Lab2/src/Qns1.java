//Write a program to show the support of protocols in your machine.
import java.net.URL;

public class Qns1 {
    public static void main(String[] args) {
        testProtocol("http://google.com");
        testProtocol("https://google.com");
        testProtocol("ftp://google.com");
        testProtocol("tel:+1-816-555-1212");
        testProtocol("news:comp.lang.java");
    }
    static  void testProtocol(String url){
        try{
            URL u = new URL(url);
            System.out.println(u.getProtocol()+" is supported");
        }
        catch (Exception ex){
            System.out.println("Error :"+ ex);
        }
    }
}
