
import structure5.*;

public class Mnemonics {

    /*
     * Convert a digit to its letter equivalents.
     * pre: '0' <= c <= '9'
     * post: return telephone letter equivalents for c.
     */
    public static String digitToLetters(char c) {
        switch (c) {
        case '0': return "0";
        case '1': return "1";
        case '2': return "abc";
        case '3': return "def";
        case '4': return "ghi";
        case '5': return "jkl";
        case '6': return "mno";
        case '7': return "prs";
        case '8': return "tuv";
        case '9': return "wxy";
        default:
            Assert.fail("Bad digit");
            return "";
        }
    }


    /*
     * prefix is the prefix for the Mnemonic we're computing.
     * rest  contains the digits remaining for conversion.
     */
    public static void mnemonicsHelper(String prefix, String rest) {
        if (rest.equals("")) {
            // We are at end, so print what we have so far.
            System.out.println(prefix);
        } else {
            // iterate over letter equivalents for first digit,
            // adding that to prefix and recursing to compute
            // rest of Mnemonics
            char digit = rest.charAt(0);
            String letters = digitToLetters(digit);
            for (int i = 0; i < letters.length(); i++) {
                mnemonicsHelper(prefix + letters.charAt(i),
                                rest.substring(1));
            }
        }
    }

    /*
     * Print all mnemonics for the digits is nums
     * pre: nums should be a string of numeric characters
     *      (ie, 0-9).
     */
    public static void listMnemonics(String nums) {
        mnemonicsHelper("", nums);
    }

    public static void main(String args[]) {
        listMnemonics(args[0]);
    }
}
