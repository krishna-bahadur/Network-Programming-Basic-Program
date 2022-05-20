//Write a program to compare URLs

import java.net.URL;

public class Qns2 {
    public static void main(String[] args) {
        try{
            URL u1 = new URL("https://www.google.com");
            URL u2 = new URL("http://www.google.com");
            if (u1.equals(u2)){
                System.out.println(u1+" is same as "+u2);
            }
            else{
                System.out.println(u1+" is not same as "+u2);

            }

        }
        catch (Exception ex){
            System.out.println("Error:"+ex);
        }
    }
}
