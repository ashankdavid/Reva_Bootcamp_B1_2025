package LibraryManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do{
            System.out.println("\n====Library Menu====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");

            while(!sc.hasNextInt()){
                System.out.println("Please enter the valid num: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Entee Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.println("Enter Book ID: ");
                    int id = sc.nextInt();
                    library.addBook(title, author, id);
                    break;

            case 2:
                System.out.println("Enter ID: ");
                int removeID = sc.nextInt();
                library.removeBook(removeID);
                break;

            case 3:
                System.out.println("Enter Title or Author: ");
                String query = sc.nextLine();
                library.searchBook(query);
                break;

            case 4:
                library.displayAllBooks();
                break;

            case 5:
                System.out.println("Exiting");
                break;

            default:
                System.out.println("Invalid Choice");
            }
        }while(choice !=5);
        sc.close();
    }
}
