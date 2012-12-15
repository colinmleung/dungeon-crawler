
public class UpperFloor implements Location {
Player player;
	
	public UpperFloor(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		System.out.println("You are on the upper floor.");
	}

	@Override
	public void inspect() {
		System.out.println("You see a long hallway, with a door to the right and a door to the left halfway down.");
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
}
