

public class Entrance implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	
	public Entrance(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		System.out.println("You are at the entrance of the house.");
	}

	@Override
	public void inspect() {
		System.out.println("It takes your eyes some time to get used to the darkness of the place." +
				"There is hallway straight ahead. There's a living room to your left, and stairs " +
				"leading up to the upperfloor to your right. You notice a key on the stand beside you.");
	}

	@Override
	public void goLeft() {
		System.out.println("You go left into the living room.");
		player.setLocation(player.goToLivingRoom());
	}

	@Override
	public void goUpStairs() {
		 System.out.println("You take the stairs up.");
		 player.setLocation(player.goToUpperFloor());
	}

	@Override
	public void goDownStairs() {
		 System.out.println("You are already at the bottom floor of the house.");
	}

	@Override
	public void goRight() {
		System.out.println("You take the stairs.");
		player.setLocation(player.goToUpperFloor());
	}
	
	@Override
	public void goForward() {
		System.out.println("You walk forward into the kitchen.");
		player.setLocation(player.goToKitchen());
	}

	@Override
	public void goBack() {
		System.out.println("You try to get out of the house. You didn't notice the door closing slowly behind you and locking. " +
				"Guess you gotta do this the hard way.");
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