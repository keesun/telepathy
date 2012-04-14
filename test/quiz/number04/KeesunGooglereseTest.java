package quiz.number04;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class KeesunGooglereseTest {

    @Test
    public void cast() throws IOException {
        KeesunGooglerese g = new KeesunGooglerese();
        g.setup("ejp mysljylc kd kxveddknmc re jsicpdrysi", "our language is impossible to understand");
        g.setup("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd", "there are twenty six factorial possibilities");
        g.setup("de kr kd eoya kw aej tysr re ujdr lkgc jv", "so it is okay if you want to just give up");

//        g.test();

        String result = g.convert("a zoo");
        assertThat(result, is("y qee"));

        g.revert();
        assertThat(g.one2("ejp mysljylc kd kxveddknmc re jsicpdrysi"), is("our language is impossible to understand"));
        assertThat(g.one2("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd"), is("there are twenty six factorial possibilities"));
        assertThat(g.one2("de kr kd eoya kw aej tysr re ujdr lkgc jv"), is("so it is okay if you want to just give up"));

        BufferedReader in = new BufferedReader(new FileReader("/work/telepathy/test/quiz/number04/A-small-attempt0.in"));
        String s;
        int lineNum = 0;
        int problemNum = 0;
        String answer = "";
        while ((s = in.readLine()) != null) {
            if(s.isEmpty()) {
                return;
            }
            if(lineNum == 0) {
                problemNum = Integer.parseInt(s);
            } else {
                answer += "Case #" + lineNum + ": " + g.one2(s) + "\n";
            }
            lineNum++;
        }
        in.close();

        System.out.println(answer);

        BufferedWriter out = new BufferedWriter(new FileWriter("/work/telepathy/test/quiz/number04/A-small-attempt0.out"));
        out.write(answer);
        out.close();
    }


}
