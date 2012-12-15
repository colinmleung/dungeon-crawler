/*import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;*/



public class DungeonCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the House of Horrors. You find yourself at the front door of a spooky mansion. Type in commands to perform actions.");
		HouseOfHorrors hoh = HouseOfHorrors.getInstance();
		hoh.setUpGame();
		hoh.playGame();
	}
}