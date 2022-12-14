import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

import java.util.ArrayList;

public class LibraryImpl implements Library {
    public HashMap<Integer,String> library;
    public HashMap<Integer,String> allBooks;
    public LibraryImpl()
    {
        this.library = new HashMap<Integer,String>();
        this.allBooks = new HashMap<Integer,String>();
    }
    @Override
    public void addNewBook(Book book)
    {
        allBooks.put(book.getId(), book.getTitle());
        library.put(book.getId(), null);
    }
    @Override
    public void borrowBook(Book book, String student)
    {
        if (library.containsKey(book.getId()))
        {
            if (library.containsValue(null))
            {
                library.put(book.getId(), student);

            }
            else
            {
                throw new BookWasTakenException("Error");
            }
        }
        else
        {
            throw new NoBookException("Error");
        }

    }

    public void returnBook(Book book, String student)
    {
        if (library.containsKey(book.getId()))
        {
            if (library.containsValue(student))
            {
                library.put(book.getId(), null);

            }
            else
            {
                throw new ErrorException("Error");
            }
        }
        else
        {
            throw new ErrorException("Error");
        }
    }

    public List<Book> findAvailableBooks()
    {
        if(library.isEmpty())
        {
            throw new EmptyMapException("Error");
        }
        else{
            List<Book> books = new ArrayList<Book>();
            for (Integer item : library.keySet())
            {
                if (library.get(item) == null) {

                    Book tmp = new Book(item, allBooks.get(item));
                    books.add(tmp);

                }
            }
            return books;
        }

    }


}