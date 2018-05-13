import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class regexTest {

	public static String TEXTFILE =
			"LOREMIPSUM.txt";
//			"blabla.txt";

	public static void main(String[] args) throws IOException {
//		Pattern p = Pattern.compile("^M*\\.$");
//		Pattern p = Pattern.compile("^M.*\\,");
//		Pattern p = Pattern.compile("lorem");
		String pattern = "lorem";
		File f = new File(TEXTFILE);
		BufferedReader reader = new BufferedReader(new FileReader(f));

		RegexMatchFinder matchFinder =
				new RegexMatchFinder(System.out);

		matchFinder.printAllMatches(pattern, reader);
	}


}
