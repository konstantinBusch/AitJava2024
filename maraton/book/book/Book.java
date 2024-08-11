package maraton.book.book;

import java.util.Objects;

//Book - Library, найти несколько книг по автору
public class Book {
    private int isbn;
    private int year;
    private String author;
    private String title;

    public Book(int isbn, int year, String author, String title) {
        this.isbn = isbn;
        this.year = year;
        this.author = author;
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book: ");
        sb.append("isbn = ").append(isbn);
        sb.append(", year = ").append(year);
        sb.append(", author = ").append(author);
        sb.append(", title = ").append(title);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
