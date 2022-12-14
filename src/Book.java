public class Book {
    int id;
    String title;

    public Book (int id, String title) {
        this.id = id;
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    }

    public int getId()
    {
        return id;
    }
}
