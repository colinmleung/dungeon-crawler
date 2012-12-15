
public class LivingRoom implements Location {
Player player;
	
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
		 System.out.println("You take the stairs.");
	}

	@Override
	public void goDownStairs() {
		 System.out.println("You are already at the bottom floor of the house.");
	}
}
