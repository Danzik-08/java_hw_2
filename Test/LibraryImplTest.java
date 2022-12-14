import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;



public class LibraryImplTest {
    LibraryImpl library;
    Book book1 = new Book(1, "A");
    Book book2 = new Book(2, "B");
    Book book3 = new Book(3, "C");


    @org.junit.Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
        library.addNewBook(book1);
        library.addNewBook(book2);
        library.addNewBook(book3);



    }

    @org.junit.After
    public void tearDown() throws Exception {
        library = null;

    }

    @org.junit.Test
    public void addNewBook() {

        List<Book> books1 = library.findAvailableBooks();
        List<Integer> bks1 = new ArrayList<Integer>();

        for(Book tmp: books1){
            bks1.add(tmp.getId());

        }


        assertThat(bks1, hasItems(book1.getId(), book2.getId(), book3.getId()));
        Book book4 = new Book(4, "D");

        assertThat(bks1, not(hasItem(book4.getId())));


        library.addNewBook(book4);
        List<Book> books2 = library.findAvailableBooks();
        List<Integer> bks2 = new ArrayList<Integer>();
        for(Book tmp: books2){
            bks2.add(tmp.getId());

        }

        assertThat(bks2, hasItems(book1.getId(), book2.getId(), book3.getId(), book4.getId()));

    }

    @org.junit.Test
    public void borrowBook() {
        library.borrowBook(book2, "Den");
        List<Book> books1 = library.findAvailableBooks();
        List<Integer> bks1 = new ArrayList<Integer>();

        for(Book tmp: books1){
            bks1.add(tmp.getId());
        }

        assertThat(bks1, not(hasItems(book2.getId())));

    }

    @org.junit.Test
    public void returnBook() {
        library.borrowBook(book2, "Den");
        library.returnBook(book2, "Den");
        List<Book> books1 = library.findAvailableBooks();
        List<Integer> bks1 = new ArrayList<Integer>();

        for(Book tmp: books1){
            bks1.add(tmp.getId());
        }

        assertThat(bks1, hasItems(book2.getId()));
    }

}