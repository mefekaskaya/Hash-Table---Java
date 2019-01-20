
public class WordNode extends Hashable {
	private int key;
	private String word;
	private int count;
	
	public WordNode(String value) {
		this.word = value;
		this.key = hash(value);
		this.count = 1;
	}
	
	public void incrementCount() {
		this.count++;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}
	
	public void addCount(int count) {
		this.count += count;
	}
	
	public void print() {
		System.out.println("Word: " + word);
		System.out.println("Key: " + key);
		System.out.println("Count: " + count);
	}
	
}