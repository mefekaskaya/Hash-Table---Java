
public class HashBucket extends Hashable implements Bucket {
	private int depth, size, emptyPointer;
	private WordNode[] values;
	
	public HashBucket() {
		this.depth = initialDepth;
		this.size = initialSize;
		this.emptyPointer = 0;
		this.values = new WordNode[size];
	}
	
	public HashBucket(int depth) {
		this.depth = depth;
		this.size = initialSize;
		this.emptyPointer = 0;
		this.values = new WordNode[size];
	}
	
	@Override
	public void insert(String word) {
		this.insert(word, 1);
	}
	
	public void insert(WordNode node) {
		this.insert(node.getWord(), node.getCount());
	}
	
	public void insert(String word, int count) {
		WordNode node = find(word);
		if(node == null) {
			if(isFull()) {
				System.out.println("Hata #2\nBucket is full.");
			}else {
				values[emptyPointer++] = new WordNode(word);
			}
		}else {
			node.addCount(count);
		}
	}
	
	@Override
	public WordNode find(String word) {
		for (int i = 0; i < emptyPointer; i++) {
			if(values[i].getWord().equals(word)) return values[i];
		}
		return null;
	}
	
	public void transfer(HashBucket hashTo, int key) {
		WordNode[] oldWords = this.values;
		int oldCount = emptyPointer;
		this.values = new WordNode[size];
		this.emptyPointer = 0;
		for (int i = 0; i < oldCount; i++) {
			if(oldWords[i].getKey()%((1<<depth)) != key%((1<<depth))) {
				hashTo.insert(oldWords[i]);
			}else {
				this.insert(oldWords[i]);
			}
		}
	}
	
	public int getDepth() {
		return depth;
	}
	
	public boolean isFull() {
		return emptyPointer == size;
	}
	
	public void incrementDepth() {
		this.depth++;
	}
	
	private String bitRepresentation(int key) {
		return Integer.toBinaryString(key);
	}
	
	public void print() {
		for (int i = 0; i < emptyPointer; i++) {
			values[i].print();
			System.out.println("Index: " + bitRepresentation(values[i].getKey()%(1<<depth)));
			System.out.println("Local Depth: " + depth);
			System.out.println();
		}
	}
	
	public void print(WordNode node) {
		node.print();
		System.out.println("Index: " + bitRepresentation(node.getKey()%(1<<depth)));
		System.out.println("Local Depth: " + depth);
	}

}