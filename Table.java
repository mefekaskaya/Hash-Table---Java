
public interface Table {
	final int initialDepth = 8;
	
	public abstract void insert(String word);
	public abstract boolean search(String word);
	public abstract void loadFromFile(String fileName);
}
