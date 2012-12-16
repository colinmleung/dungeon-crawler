import java.util.Observable;
import java.util.Observer;


public class Player implements Observer {
	private volatile static Player player;
	private ItemHolder ih;
	Location entrance;
	Location livingRoom;
	Location upperFloor;
	Location location;
	
	private Player() {}
	
	public static Player getInstance() {
		if (player == null) {
			synchronized (Player.class) {
				if (player == null) {
					player = new Player();
				}
			}
		}
		return player;
	}
	
	public void preparePlayer() {
		entrance = new Entrance(this);
		entrance.addItem("key");
		livingRoom = new LivingRoom(this);
		upperFloor = new UpperFloor(this);
		location = entrance;
		ih = new ItemHolder();
	}
	
	public void stateLocation() {
		location.stateLocation();
	}
	
	public void inspect() {
		location.inspect();
	}
	
	public void goLeft() {
		location.goLeft();
	}
	
	public void goRight() {
		location.goRight();
	}
	
	public void goUpStairs() {
		location.goUpStairs();
	}
	
	public void goDownStairs() {
		location.goDownStairs();
	}
	
	public void take(String item) {
		if (location.take(item)) {
			ih.add(item);
		}
	}
	
	public void use(String item) {
		if (ih.search(item) && location.use(item)) {
			ih.remove(item);
		}
	}

	public Location goToLivingRoom() {
		return livingRoom;
	}
	
	public Location goToUpperFloor() {
		return upperFloor;
	}
	
	public Location goToEntrance() {
		return entrance;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void update(Observable obj, Object arg) {
		if (arg instanceof String[]) {
			String[] storage = (String[]) arg;
			switch (storage[0]) {
				case "hello":
					System.out.println("Hello there, commands are working.");
					break;
				case "go":
					switch (storage[1]) {
						case "right":
							goRight();
							break;
						case "left":
							goLeft();
							break;
						case "upstairs":
							goUpStairs();
							break;
						case "downstairs":
							goDownStairs();
							break;
						default:
							System.out.println("Go where?");
							break;
					}
					break;
				case "inspect":
					switch (storage[1]) {
						case "location":
							inspect();
							break;
						default:
							System.out.println("Inspect what?");
							break;
					}
					break;
				case "state":
					switch (storage[1]) {
						case "location":
							stateLocation();
							break;
						default:
							System.out.println("State what?");
							break;
					}
					break;
				case "take":
					take(storage[1]);
					break;
				case "use":
					use(storage[1]);
					break;
				default:
					System.out.println("Unrecognized command. Please try again.");
					break;
			}
		}
	}
	
	
}
