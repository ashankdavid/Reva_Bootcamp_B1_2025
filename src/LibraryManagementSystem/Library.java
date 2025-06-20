package LibraryManagementSystem;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private final int MAX_BOOKS = 100;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(String title, String author, int id){
        if(books.size() >= MAX_BOOKS){
            System.out.println("Library is FULL");
            return;
        }
        for(Book book : books){
            if(book.getId() == id){
                System.out.println("Book already exists");
                return;
            }
        }

        Book newBook = new Book(title, author, id);
        books.add(newBook);
        System.out.println("Book is added");
    }

    public void removeBook(int id){
        boolean removed = false;
        for(Book book : books){
            if(book.getId() == id){
                books.remove(book);
                System.out.println("Book is removed");
                removed = true;
                break;
            }
        }

        if(!removed){
            System.out.println("Book not found");
        }
    }

    public void searchBook(String query){
        boolean found = false;
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)){
                book.displayBook();
                found = true;
            }
        }
        if(!found){
            System.out.println("No book found");
        }
    }

    public void displayAllBooks(){
        if(books.isEmpty()){
            System.out.println("Library is Empty");
        }else{
            for(Book book : books){
                book.displayBook();
            }
        }
    }
}

