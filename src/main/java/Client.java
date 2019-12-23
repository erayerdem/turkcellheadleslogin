
import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
import lombok.Getter;

import java.io.IOException;

@Getter
public abstract class Client {


    private final String url;
    private final int phonenumber;
    private final int password;
    private final WebClient CLIENT;


    Client(final long phonenumber, final int password, String url) {
        Utils.checktoRegex(phonenumber, password);
        this.phonenumber = Utils.buildPhoneNumber(phonenumber);
        this.password = password;
        this.CLIENT = new WebClient();
        this.url = url;
        CLIENT.getCookieManager().setCookiesEnabled(true);
        CLIENT.getOptions().setJavaScriptEnabled(false);
        CLIENT.getOptions().setCssEnabled(false);
        CLIENT.getOptions().setThrowExceptionOnScriptError(false);
        CLIENT.getOptions().setThrowExceptionOnFailingStatusCode(false);
        CLIENT.getOptions().setRedirectEnabled(true);
        //CLIENT.setAjaxController(new AjaxController());
       // CLIENT.setJavaScriptEngine(new JavaScriptEngine(CLIENT));
       // CLIENT.waitForBackgroundJavaScriptStartingBefore(3000);
    }

    public abstract void login() ;
}
