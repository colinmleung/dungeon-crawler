

public class LivingRoom implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	
	public LivingRoom(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		System.out.println("You are in the living room.");
	}

	@Override
	public void inspect() {
		System.out.println("You gaze around the living room, noticing the dated furniture, and dust. Lots of it.");
	}

	@Override
	public void goLeft() {
		System.out.println("You turn left and run into the living room wall. Shaken, but not stirred, you regain your posture.");
	}
	
	@Override
	public void goRight() {
		System.out.println("You head back to the entrance.");
		player.setLocation(player.goToEntrance());
	}

	@Override
	public void goUpStairs() {
		 System.out.println("The stairs are nowhere nearby.");
	}

	@Override
	public void goDownStairs() {
		 System.out.println("You are already at the bottom floor of the house.");
	}
	
	@Override
	public void goForward() {
		 System.out.println("You go forward into the dining room.");
		 player.setLocation(player.goToDiningRoom());
	}

	@Override
	public void goBack() {
		System.out.println("You walk into the wall of the living room. Silly you.");
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
