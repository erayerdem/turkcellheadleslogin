
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

public class TurkcellClient extends Client {

    TurkcellClient(long phonenumber, int password) {
        super(phonenumber, password, "https://www.turkcell.com.tr/");
    }

    @Override
    public void login() {
        try {
            HtmlPage page = this.getCLIENT().getPage("https://turkcell.com.tr/");
            HtmlAnchor processcenter = page.getFirstByXPath("/html/body/header/div[2]/div/div[2]/div[2]/div/a[2]");
            page = processcenter.click();

            HtmlSelect logintype = (HtmlSelect) page.getElementsByTagName("select").get(0);
            page = logintype.setSelectedAttribute("1", true);
            HtmlTelInput phonenumberinput = (HtmlTelInput) page.getElementById("input-1");
            HtmlPasswordInput passwordinput = (HtmlPasswordInput) page.getElementById("input-2");
            phonenumberinput.setValueAttribute(String.valueOf(this.getPhonenumber()));
            passwordinput.setValueAttribute(String.valueOf(this.getPassword()));
            HtmlButton elementById = (HtmlButton) page.getElementById("login-button");
            HtmlPage loginpage = elementById.click();

        } catch (IOException e) {
            System.err.println("Uygulama ekranında bir sorun oluştu lütfen daha sonra deneyiniz");
            System.exit(5);
        } catch (Exception e) {
            System.err.println("Bir sorun oluştu lütfen daha sonra deneyiniz");
            System.exit(6);
        }


    }
}
