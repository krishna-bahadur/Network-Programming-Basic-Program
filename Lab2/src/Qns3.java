//Write a program to download the object.

import java.net.URL;

public class Qns3 {
    public static void main(String[] args) {
        downlaod("https://www.google.com");
    }
    static  void downlaod(String url){
        try{
            URL u = new URL(url);
            Object o = u.getContent();
            System.out.println(" I got a"+o.getClass().getName());
        }
        catch (Exception ex){
            System.out.println("Error :"+ex);
        }
    }
}
