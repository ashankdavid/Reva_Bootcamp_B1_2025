package LibraryManagementSystem;

public class Book {
    private String title;
    private String author;
    private int id;


    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    //Getters

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    //Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void displayBook(){
        System.out.println("ID: "+id+", Title: "+title+",Author: "+author);
    }
}
