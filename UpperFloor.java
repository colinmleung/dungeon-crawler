

public class UpperFloor implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	
	public UpperFloor(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		System.out.println("You are on the upper floor.");
	}

	@Override
	public void inspect() {
		System.out.println("You see a long hallway, with a door at the end of it.");
	}

	@Override
	public void goLeft() {
		System.out.println("You run into the left handrail, silly you.");
	}
	
	@Override
	public void goRight() {
		System.out.println("You run into the right handrail, silly you.");
	}

	@Override
	public void goUpStairs() {
		 System.out.println("Unfortunately, there is no stairway to heaven here.");
	}

	@Override
	public void goDownStairs() {
		 System.out.println("You go back down the stairs to the entrance.");
		 player.setLocation(player.goToEntrance());
	}
	

	@Override
	public void goForward() {
		System.out.println("You walk forward into the hallway.");
		player.setLocation(player.goToHallway());
	}

	@Override
	public void goBack() {
		System.out.println("You go back down the stairs to the entrance.");
		player.setLocation(player.goToEntrance());
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
			case "key":
				System.out.println("You summon a horror from the Ninth Dimension of the Chaotic plane. You die. Game over.");
				System.exit(0);
				return true;
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
