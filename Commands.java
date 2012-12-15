import java.util.Observable;

public class Commands extends Observable {
	private volatile static Commands c; 
	private String[] storage;
	
	public static Commands getInstance() {
		if (c == null) {
			synchronized(Commands.class) {
				if (c == null) {
					return new Commands();
				}
			}
		}
		return c;
	}
	
	public void prepareCommands() {
		final int NUMBER_OF_WORDS = 2;
		storage = new String[NUMBER_OF_WORDS];
	}
	
	public void setCommands(String[] array) {
		System.arraycopy(array, 0, storage, 0, 2);
		setChanged();
		notifyObservers(storage);
	}
	
	public String getFirstWord() {
		return storage[0];
	}
	
	public String getSecondWord() {
		return storage[1];
	}
	
	private Commands() {}
}
