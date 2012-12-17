

public class Hallway implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	
	public Hallway(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		// TODO Auto-generated method stub
		System.out.println("You are in the hallway.");
	}

	@Override
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("Hallway. You're in it.");
	}

	@Override
	public void goLeft() {
		System.out.println("You walk into the left room.");
		player.setLocation(player.goToLeftRoom());
	}

	@Override
	public void goRight() {
		System.out.println("You walk into the right room.");
		player.setLocation(player.goToRightRoom());
	}
	
	@Override
	public void goForward() {
		// TODO Auto-generated method stub
		System.out.println("You walk into the center room.");
		player.setLocation(player.goToCenterRoom());
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		System.out.println("You walk back to the staircase.");
		player.setLocation(player.goToUpperFloor());
	}


	@Override
	public void goUpStairs() {
		// TODO Auto-generated method stub
		System.out.println("Can't do that.");
	}

	@Override
	public void goDownStairs() {
		// TODO Auto-generated method stub
		System.out.println("Can't do that.");
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
