package basicJavaPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MatchResult interface
 * Matcher class
 * Pattern class
 * PatternSyntaxException
 */

public class RegexPractice {
    public static void main(String[] args) {
        basicRegexEx();
    }

    private static void basicRegexEx() {
        Pattern p = Pattern.compile(".s");
        Matcher m = p.matcher("aas");
        boolean b = m.matches();

        boolean b1 = Pattern.compile(".s").matcher("as").matches();

        boolean b2 = Pattern.matches(".s", "as");

        System.out.println(b + " , " + b1 + " , " + b2);
    }
}
