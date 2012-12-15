import java.util.Observable;
import java.util.Observer;


public class Player implements Observer {
	private volatile static Player player;
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
		livingRoom = new LivingRoom(this);
		upperFloor = new UpperFloor(this);
		location = entrance;
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
			if (storage[0].equals("hello")) {
				System.out.println("Hello there, commands are working.");
			} else if (storage[0].equals("go")) {
				if (storage[1].equals("right")) {
					goRight();
				} else if (storage[1].equals("left")) {
					goLeft();
				} else if (storage[1].equals("upstairs")) {
					goUpStairs();
				} else if (storage[1].equals("downstairs")) {
					goDownStairs();
				}
			} else if (storage[0].equals("inspect") && storage[1].equals("location")) {
				inspect();
			} else if (storage[0].equals("state") && storage[1].equals("location")) {
				stateLocation();
			} else {
				System.out.println("Try a different command.");
			}
		}
	}
	
	
}
