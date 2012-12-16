interface Location {
	void stateLocation();
	void inspect();
	void goLeft();
	void goRight();
	void goUpStairs();
	void goDownStairs();
	boolean take(String item);
	boolean use(String item);
	void addItem(String item);
}