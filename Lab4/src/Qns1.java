// Write a program to get all the headers from google.com

import java.net.URL;
import java.net.URLConnection;

public class Qns1 {
    public static void main(String[] args) {
        String url="https://google.com";
        headerView(url);
    }

    private static void headerView(String url) {
        try {
            URL u= new URL(url);
            URLConnection uc = u.openConnection();
            for(int i=1;;i++){
                String header= uc.getHeaderField(i);
                if(header == null)
                    break;
                System.out.println(uc.getHeaderFieldKey(i)+":"+header);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

    }
}
