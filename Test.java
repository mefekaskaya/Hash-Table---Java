import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String testFileName = "cartoon.txt";
		//String testFileName = "deneme.txt";
		HashTable hashTable = new HashTable();
		System.out.println(testFileName + " loading...");
		hashTable.loadFromFile(testFileName);
		System.out.println(testFileName + " loaded.");
		Scanner scn = new Scanner(System.in);
		String input = "";
		int choice = 1;
		do {
			System.out.println("1 - Search in file");
			System.out.println("2 - Print all");
			System.out.println("3 - Exit");
			System.out.print("Choice: ");
			input = scn.nextLine();
			try {
				choice = Integer.parseInt(input);
				if(choice == 1) {
					System.out.print("Search input: ");
					input = scn.nextLine();
					if(hashTable.search(input)) {
						System.out.println("Press enter to continue...");
						scn.nextLine();
					}
				}else if(choice == 2) {
					hashTable.print();
					System.out.println("Press enter to continue...");
					scn.nextLine();
				}else if(choice != 3) {
					System.out.println("Wrong input.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Wrong input.");
			}
		} while(choice != 3);
		scn.close();
	}

}
