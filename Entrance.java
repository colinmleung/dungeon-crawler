
public class Entrance implements Location {
	Player player;
	
	public Entrance(Player player) {
		this.player = player;
	}

	@Override
	public void stateLocation() {
		System.out.println("You are at the entrance of the house.");
	}

	@Override
	public void inspect() {
		System.out.println("It takes your eyes some time to get used to the darkness of the place. There is hallway straight ahead. There's a living room to your left, and stairs leading up to the upperfloor to your right.");
	}

	@Override
	public void goLeft() {
		System.out.println("You go left into the living room.");
		player.setLocation(player.goToLivingRoom());
	}

	@Override
	public void goUpStairs() {
		 System.out.println("You take the stairs.");
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
}