package quiz.number04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Keesun Baik
 */
public class KeesunGooglerese {

    private Map<Character, Character> gl = new HashMap<Character, Character>();

    private Map<Character, Character> al = new HashMap<Character, Character>();

    public String convert(String origin) {
        String result = "";
        char[] chars = origin.toCharArray();
        for(char c : chars) {
            result += gl.get(c);
        }
        return result;
    }

    public void setup(String result, String origin) {
        gl.put('z', 'q');
        gl.put('q', 'z');
        char[] originChars = origin.toCharArray();
        char[] resultChars = result.toCharArray();

        for(int i = 0 ; i < originChars.length ; i++) {
//            System.out.println("origin: " + originChars[i]);
//            System.out.println("result: " + resultChars[i]);
            gl.put(originChars[i], resultChars[i]);
        }
    }



    public void test() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(char a : alphabet) {
            System.out.printf("%c: %c\n", a, gl.get(a));
        }
    }

    public void revert() {
        for(char key : gl.keySet()) {
            al.put(gl.get(key), key);
        }

        for(char a : al.keySet()) {
            System.out.printf("%c: %c\n", a, al.get(a));
        }
    }

    public String one2(String gogglerese) {
        String result = "";
        char[] chars = gogglerese.toCharArray();
        for(char c : chars) {
            result += al.get(c);
        }
        return result;
    }
}
