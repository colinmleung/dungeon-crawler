//import java.util.Vector;

// Singleton, represents the playing field.
public class HouseOfHorrors {

	private volatile static HouseOfHorrors hoh;
	private Player player;
	private InputParser ip;
	
	private HouseOfHorrors() {}
	
	public static HouseOfHorrors getInstance() {
		if (hoh == null) {
			synchronized (HouseOfHorrors.class) {
				if (hoh == null) {
					hoh = new HouseOfHorrors();
				}
			}
		}
		return hoh;
	}
	
	public void setUpGame() {
		ip = InputParser.getInstance();
		player = Player.getInstance();
		
		ip.prepareParser();
		ip.addObserver(player);
		
		player.preparePlayer();
	}
	
	public void playGame() {
		while (true) {
			ip.read();
		}
	}
}