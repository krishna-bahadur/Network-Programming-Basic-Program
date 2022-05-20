import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static java.lang.System.in;

//Write a program to read the data from URL in string format.
public class Qns2 {
    public static void main(String[] args) {
        try{
            URL u = new URL("https://www.google.com");
            URLConnection uc = u.openConnection();
            uc.connect();
            System.out.println(uc.getContentType());
            System.out.println(uc.getHeaderField("Expires"));
            System.out.println("\n\n");
            InputStream is = uc.getInputStream();
            int c;
            while ((c = in.read()) != -1) System.out.print(Character.toChars(c));
            in.close();

        }
        catch(Exception ex){
            System.out.println("Error :"+ex);
        }
    }
}
