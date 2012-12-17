

public class RightRoom implements Location {
	Player player;
	ItemHolder ih = new ItemHolder();
	
	public RightRoom(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		System.out.println("You are in the right room.");
	}

	@Override
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("You are in the right room.");
	}

	@Override
	public void goLeft() {
		// TODO Auto-generated method stub
		System.out.println("You go back into the hallway.");
		player.setLocation(player.goToHallway());
	}

	@Override
	public void goRight() {
		// TODO Auto-generated method stub
		System.out.println("Can't let you go that way.");
	}
	
	@Override
	public void goForward() {
		// TODO Auto-generated method stub
		System.out.println("Can't let you go that way.");
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		System.out.println("Can't let you go that way.");
	}

	@Override
	public void goUpStairs() {
		// TODO Auto-generated method stub
		System.out.println("Can't let you go that way.");
	}

	@Override
	public void goDownStairs() {
		// TODO Auto-generated method stub
		System.out.println("Can't let you go that way.");
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
