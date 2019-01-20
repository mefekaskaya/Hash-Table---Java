
public interface Bucket {
	final int initialDepth = 8;
	final int initialSize = 10;
	
	public abstract void insert(String key);
	public abstract WordNode find(String key);
}