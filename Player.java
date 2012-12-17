import java.util.Observable;
import java.util.Observer;


public class Player implements Observer {
	
	private volatile static Player player;
	
	private ItemHolder ih;
	
	Location location;
	Location entrance;
	Location livingRoom;
	Location diningRoom;
	Location kitchen;
	Location upperFloor;
	Location hallway;
	Location leftRoom;
	Location rightRoom;
	Location centerRoom;
	
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
		ih = new ItemHolder();
		
		entrance = new Entrance(this);
		entrance.addItem("key");
		livingRoom = new LivingRoom(this);
		livingRoom.addItem("lamp");
		diningRoom = new DiningRoom(this);
		diningRoom.addItem("cushion");
		kitchen = new Kitchen(this);
		livingRoom.addItem("cleaver");
		upperFloor = new UpperFloor(this);
		hallway = new Hallway(this);
		leftRoom = new LeftRoom(this);
		rightRoom = new RightRoom(this);
		centerRoom = new CenterRoom(this);
		
		location = entrance;
	}
	
	public void stateLocation() {
		location.stateLocation();
	}
	
	public void inspect() {
		location.inspect();
	}
	
	public void take(String item) {
		if (location.take(item)) {
			ih.add(item);
		}
	}
	
	public void use(String item) {
		if (ih.search(item)) {
			if (location.use(item)) {
				ih.remove(item);
			}
			System.out.println("You don't have that.");
		}
	}
	
	public void goForward() {
		location.goForward();
	}
	
	public void goBack() {
		location.goBack();
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
	
	
	public Location goToEntrance() {
		return entrance;
	}

	public Location goToLivingRoom() {
		return livingRoom;
	}
	
	public Location goToDiningRoom() {
		return diningRoom;
	}
	
	public Location goToKitchen() {
		return kitchen;
	}
	
	public Location goToUpperFloor() {
		return upperFloor;
	}
	
	public Location goToHallway() {
		return hallway;
	}
	
	public Location goToLeftRoom() {
		return leftRoom;
	}
	
	public Location goToRightRoom() {
		return rightRoom;
	}
	
	public Location goToCenterRoom() {
		return centerRoom;
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
						case "forward":
							goForward();
							break;
						case "back":
							goBack();
							break;
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
