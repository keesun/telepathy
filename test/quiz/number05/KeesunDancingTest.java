package quiz.number05;

import java.io.*;
import java.util.Arrays;

/**
 * @author Keesun Baik
 */
public class KeesunDancingTest {

	public static void main(String[] args) throws IOException {
		KeesunDancingTest dancing = new KeesunDancingTest();

		BufferedReader in = new BufferedReader(new FileReader("/workspace/telepathy/test/quiz/number05/B-large.in"));
		String s;
		int lineNum = 0;
		int problemNum = 0;
		String answer = "";
		while ((s = in.readLine()) != null) {
			if (s.isEmpty()) {
				return;
			}
			if (lineNum == 0) {
				problemNum = Integer.parseInt(s);
			} else {
				answer += "Case #" + lineNum + ": " + dancing.figureP(s) + "\n";
			}
			lineNum++;
		}
		in.close();

		System.out.println(answer);

		BufferedWriter out = new BufferedWriter(new FileWriter("/workspace/telepathy/test/quiz/number05/B-large.out"));
		out.write(answer);
		out.close();
	}

	private int figureP(String s) {
		String[] inputs = s.split(" ");

		int surprise = Integer.parseInt(inputs[1]);
		int minScore = Integer.parseInt(inputs[2]);

		String[] scoreStrings = Arrays.copyOfRange(inputs, 3, inputs.length);

		int[] scores = new int[scoreStrings.length];
		for (int i = 0; i < scoreStrings.length; i++) {
			scores[i] = Integer.parseInt(scoreStrings[i]);
		}

		int cases = 0;

		for (int score : scores) {
			int base = score / 3;
			switch (score % 3) {
				case 0: {
					if (base >= minScore) {
						cases++;
					} else if (surprise > 0 && base > 0 && base + 1 >= minScore) {
						cases++;
						surprise--;
					}
					break;
				}
				case 1: {
					if (base >= minScore || base + 1 >= minScore) {
						cases++;
					} else if (surprise > 0 && base + 1 >= minScore) {
						cases++;
						surprise--;
					}
					break;
				}
				case 2: {
					if (base >= minScore || base + 1 >= minScore) {
						cases++;
					} else if (surprise > 0 && base + 2 >= minScore) {
						cases++;
						surprise--;
					}
					break;
				}
			}
		}
		return cases;
	}
}
