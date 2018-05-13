import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class RegexMatchFinder {

	PrintStream out;
	public RegexMatchFinder(PrintStream target) {
		this.out = target;
	}
	public void setOut(PrintStream out) {
		this.out = out;
	}

	public void printAllMatches(String pattern, BufferedReader text) throws IOException
	{
		Pattern p = Pattern.compile(pattern);
		ArrayList<Integer> positions = new ArrayList<>();
		int i=1;

		String line;
		while ((line = text.readLine()) != null) {
			Matcher m = p.matcher(line);
			positions.clear();
			while (m.find())
				positions.add(m.start());

			if (!positions.isEmpty()) {
				out.println(line + " (line " + i + ")");
				out.println(locationer(positions));
			}
			i++;
		}
	}

	public static String locationer(ArrayList<Integer> positions) {
		StringBuilder r = new StringBuilder();
		int cur = 0;
		for(Integer p : positions) {
			IntStream.range(cur, p).forEach(i -> r.append(' '));
			r.append('^');
			cur+=p+1;
		}
		return r.toString();
	}
}
