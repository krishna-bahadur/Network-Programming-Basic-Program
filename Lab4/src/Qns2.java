//Write a program to download a page via URLConnection

import java.io.*;

import java.net.*;


public class Qns2 {
    public static void main(String[] args) {
        downloadPage("https://google.com");
    }
    private static void downloadPage(String url){
        try{
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            try(InputStream is = uc.getInputStream()){
                InputStream buffer = new BufferedInputStream(is);
                Reader reader= new InputStreamReader(buffer);
                int c;
                while(( c = reader.read()) != -1){
                    System.out.print((char) c);
                }

            }
            catch (MalformedURLException ex){
                System.err.println(ex);
            }
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }
}


