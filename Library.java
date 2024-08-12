package maraton.book.dao;

import maraton.book.book.Book;

public interface Library  {
    boolean addBook (Book book);//добавить книгу;
    Book findBook(int isbn);//найти книгу;
    Book deletBook (int isbn);//удалить книгу;
    int quantity();//кол-во книг;
    void printBook();//напечатать список книг.
    Book[] findAuthor(String author);
}
