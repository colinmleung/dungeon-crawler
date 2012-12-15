import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
	private volatile static InputParser ip;
	
	private Scanner sc;
	private Pattern p;
	private Matcher m;
	private Commands comm;
	
	private InputParser() {}
	
	public static InputParser getInstance() {
		if (ip == null) {
			synchronized (InputParser.class) {
				if (ip == null) {
					ip = new InputParser();
				}
			}
		}
		return ip;
	}
	
	public void prepareParser() {
		final String WORD_WHITESPACE_WORD = "^[^\\s]+\\s[^\\s]+$";
		
		sc = new Scanner(System.in);
		p = Pattern.compile(WORD_WHITESPACE_WORD);
		comm = Commands.getInstance();
		comm.prepareCommands();
	}
	
	public void read() {
		final String WHITESPACE_CHARACTER = "\\s";
		
		sc.hasNext();
		String line = sc.nextLine().trim();
		m = p.matcher(line);
		if (m.matches()) {
			comm.setCommands(line.split(WHITESPACE_CHARACTER));
		}
	}
	
	public void addObserver(Player pl) {
		comm.addObserver(pl);
	}
	
	
}