import java.util.ArrayList;

public class ItemHolder {
	private ArrayList<String> storage = new ArrayList<String>();
	
	public boolean search(String item) {
		return storage.contains(item);
	}
	
	public void add(String item) {
		storage.add(item);
	}
	
	public void remove(String item) {
		storage.remove(item);
	}
}
