
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {


    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int password = 0;
        long phonenumber = 0;

        try {
            System.out.print("Phone number is (example : 5332637210) :");
            password = scan.nextInt();
            System.out.print("Password is :");
            phonenumber = scan.nextLong();

        } catch (InputMismatchException e) {
            System.err.println("Lütfen doğru parametreler giriniz");
            System.exit(3);
        } catch (Exception e) {
            System.err.println("Bir sorun oluştu lütfen daha sonra deneyiniz");
            System.exit(4);
        }

        Client client = new TurkcellClient(phonenumber, password);

        client.login();
        scan.close();

    }
}
