import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {


    public static void checktoRegex(long phonenumber, int password) {
        Pattern p = Pattern.compile("^5+[0-9]{2}[0-9]{3}[0-9]{2}[0-9]{2}");
        Matcher matcher = p.matcher(String.valueOf(phonenumber));
        boolean matches = matcher.matches();
        if (!matches) {
            System.err.println("Telefon numarası formatı uygun değil !");
            System.exit(1);
        }
        if (password < 99999 || password > 1000000) {
            System.err.println("Parola uygun formatda değil ");
            System.exit(2);
        }
    }

    public static int buildPhoneNumber(long phonenumber) {
        int basamakdegeri = 1;
        int newphonenumber = 0;

        for (int i = 0; i < 9; i++) {
            newphonenumber += (phonenumber % 10) * basamakdegeri;
            phonenumber /= 10;
            basamakdegeri *= 10;
        }

        return newphonenumber;
    }
}
