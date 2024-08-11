package maraton.book.test;

import maraton.book.book.Book;
import maraton.book.dao.BookImpl;
import maraton.book.dao.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookImplTest {
    Library library;
    Book[] books;

    @BeforeEach
    void setUp() {
        library = new BookImpl(5);
        books = new Book[5];
        books[0] = new Book(00, 2000, "Lev Tolstoj", "Anna Karenina");
        books[1] = new Book(01, 2001, "Fedor Dostojevskij", "Crime and Punishmen");
        books[2] = new Book(02, 2002, "Anton chekhov", " board number 6");
        books[3] = new Book(03, 2003, "Nikolaj Gogol", "Dead Souls");
        for (int i = 0; i < books.length; i++) {
            library.addBook(books[i]);
        }
    }

    @Test
    void addBook() {
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(books[0]));
        Book book = new Book(05,2005,"Schneider","Rose");
        assertTrue(library.addBook(book));
        assertEquals(5,library.quantity());
        book = new Book(06,2006,"Kassco","Tanja");
        assertFalse(library.addBook(book));

    }

    @Test
    void findBook() {
        assertEquals(books[2], library.findBook(02));
        assertNull(library.findBook(05));

    }

    @Test
    void deletBook() {
        Book bookVictim = library.deletBook(02);
        assertEquals(books[2],bookVictim);
        assertEquals(3,library.quantity());
        assertNull(library.deletBook(02));
    }

    @Test
    void quantity() {
        assertEquals(4,library.quantity());
    }

    @Test
    void printBook() {
        library.printBook();
    }
    @Test
    void findAuthor(){
        Book[] expend = {books[0]};
        Book[] actual = library.findAuthor("Lev Tolstoj");
        assertArrayEquals(expend,actual);

    }
}