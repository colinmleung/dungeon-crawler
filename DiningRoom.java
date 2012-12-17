
public class DiningRoom implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	boolean leverPushed = false; 
	
	public DiningRoom(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		// TODO Auto-generated method stub
		System.out.println("You are in the dining room.");
	}

	@Override
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("You are in the nicely kept dining room.");
		
	}

	@Override
	public void goLeft() {
		// TODO Auto-generated method stub
		System.out.println("You walk into the wall of the dining room. Silly you.");
	}

	@Override
	public void goRight() {
		// TODO Auto-generated method stub
		System.out.println("You walk into the kitchen.");
		player.setLocation(player.goToKitchen());
	}
	
	@Override
	public void goForward() {
		// TODO Auto-generated method stub
		System.out.println("You see a door that might go out to the patio. It's locked.");
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		System.out.println("You go back to the living room.");
		player.setLocation(player.goToLivingRoom());
	}

	@Override
	public void goUpStairs() {
		// TODO Auto-generated method stub
		System.out.println("You are nowhere near stairs.");
	}

	@Override
	public void goDownStairs() {
		// TODO Auto-generated method stub
		System.out.println("You are already at the bottom floor of the house.");
	}

	@Override
	public boolean take(String item) {
		if (ih.search(item)) {
			ih.remove(item);
			return true;
		}
		System.out.println(item + " doesn't even exist here.");
		return false;
	}

	@Override
	public boolean use(String item) {
		switch (item) {
			default:
				System.out.println("You can't use that here.");
				return false;
		}
	}

	@Override
	public void addItem(String item) {
		ih.add(item);
	}

	
}