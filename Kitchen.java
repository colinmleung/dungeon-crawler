

public class Kitchen implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	
	public Kitchen(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		// TODO Auto-generated method stub
		System.out.println("You are in the kitchen.");
	}

	@Override
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("A messy kitchen.");
	}

	@Override
	public void goLeft() {
		// TODO Auto-generated method stub
		System.out.println("You walk into the dining room.");
		player.setLocation(player.goToDiningRoom());
	}

	@Override
	public void goRight() {
		// TODO Auto-generated method stub
		System.out.println("You walk into the wall of the kitchen. Silly you.");
	}
	
	@Override
	public void goForward() {
		// TODO Auto-generated method stub
		System.out.println("You walk into the wall of the kitchen. Silly you.");
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		System.out.println("You walk back to the entrance.");
		player.setLocation(player.goToEntrance());
	}

	@Override
	public void goUpStairs() {
		// TODO Auto-generated method stub
		System.out.println("You are nowhere near the stairs.");
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
