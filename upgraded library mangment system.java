import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter the number of books u have");
		int number_of_books = input.nextInt();
		System.out.println("Welcome to the library Mangement System!");
		System.out.println("_______________________________________");
		String[] book_title = new String[number_of_books];
		String[] book_describition = new String[number_of_books];
		boolean[] book_issued = new boolean[number_of_books];
		int book_count = 0;
		int user_input = 0;
		while (user_input != 8) {
			System.out.println("1.Add a Book");
			System.out.println("2.search for a Book(by Title or Id)");
			System.out.println("3.issue a book  (Id)");
			System.out.println("4.return a Book(id)");
			System.out.println("5.delete a book(id)");
			System.out.println("6 Edit Book details(Title/Descripition by id)");
			System.out.println("7.view all Books");
			System.out.println("8.Exit");
			System.out.println("_______________________________________");
			System.out.println("enter your choice");
			user_input = input.nextInt();
			input.nextLine();
			if (user_input == 1) {
				do {
					System.out.println("enter your book title");
					book_title[book_count] = input.nextLine();
				} while (book_title[book_count].isEmpty());
				

				System.out.println("enter your book descripition");
				book_describition[book_count] = input.nextLine();

				book_issued[book_count] = false;
				book_count += 1;
			} else if (user_input == 2) {
				System.out.println(" 1. book id \n 2. title");
				int user2 = input.nextInt();
				if (user2 == 1) {
					System.out.println("enter ur book id");
					int id = input.nextInt();
					if (id < book_count) {
						System.out.println("[Found] " + "the book name is " + book_title[id]
								+ "   \nthe book descripition is " + book_describition[id]);
					} else {
						System.out.println("[Not-Found]");
					}
				} else if (user2 == 2) {
					input.nextLine();
					System.out.println("enter the book title");
					String title = input.nextLine();
					Boolean found = false;
					for (int i = 0; i < book_count; i++) {
						if (book_title[i].equals(title)) {
							System.out.println("[Found]");
							found = true;
							break;
						}
					}
					if (!found) {
						System.out.println("[Not-Found]");
					}
				}
			} else if (user_input == 3) {
				System.out.println("enter the book id that u want to borrow");
				int id = input.nextInt();
				if (book_issued[id] == false) {
					book_issued[id] = true;
					System.out.println("Dont Forget to Return the book!");

				} else {
					System.out.println("the book is already loaned");
				}
			} else if (user_input == 4) {
				System.out.println("enter the book id that u want to return");
				int id = input.nextInt();
				if (book_issued[id] == true) {
					book_issued[id] = false;
					System.out.println("the book is returned Thanks");
				}
				else {
					System.out.println("the book is not loaned");
				}
			} else if(user_input == 5) {
				System.out.println("enter the book id that u want to delete");
				int id = input.nextInt();
				for (int i = id; i < book_count; i++) {
					book_title[i] = book_title[i + 1];
					book_describition[i] = book_describition[i + 1];
					book_issued[i] = book_issued[i + 1];
				}
				book_count -= 1;
				
			} else if (user_input == 6) {
				System.out.println("enter the book id that u want to edit");
				int id = input.nextInt();
				System.out.println("1) Do u want to edit title\n2) Do u want edit describtion");
				int the_choice = input.nextInt();

				if (the_choice == 1) {
					System.out.println("enter the new title");
					input.nextLine();
					book_title[id] = input.nextLine();
					System.out.println("The title changed!");
				} else if (the_choice == 2) {
					System.out.println("enter the new describtion");
					input.nextLine();
					book_describition[id] = input.nextLine();
					System.out.println("The describtion changed!");
				}
				else {
					System.out.println("invalid choice");
				}
			} else if (user_input == 7) {
				for (int i = 0; i < book_count; i++)
					System.out.println(book_title[i]);

			}
			
		}
	}
}