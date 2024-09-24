package conta_digital.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoEmail {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static String isValidEmail(String email) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            return email;
        } else {
            throw new IllegalArgumentException("O e-mail" + email + " é inválido");
        }
    }

}
