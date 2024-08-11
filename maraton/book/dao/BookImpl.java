package maraton.book.dao;

import maraton.book.book.Book;

public class BookImpl implements Library{
    private Book[] books;
    private int size;

    public BookImpl(int capacity) {
        books = new Book[capacity];
    }

    @Override
    public boolean addBook(Book book) {
        if (book== null){
            return false;
        }
        if (size == books.length){
            return false;
        }
        if (findBook(book.getIsbn())!= null) {
            return false;
        }
        books[size]= book;
        size++;
        return true;
    }

    @Override
    public Book findBook(int isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn){
                return books[i];
            }
        }return null;
    }

    @Override
    public Book deletBook(int isbn) {
        Book victim = null;
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn()==isbn){
                victim = books[i];
                books[i]= books[size-1];
                books[size-1] = victim;
                size--;
                break;
            }
        }
        return victim;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printBook() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    @Override
    public Book[] findAuthor(String author) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author) ){
                count++;
            }
        }Book[] booksOfAuthor = new Book[count];
        for (int i = 0, j = 0; j < booksOfAuthor.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                booksOfAuthor[j++] = books[i];
            }
        }
        return booksOfAuthor;

    }
}
