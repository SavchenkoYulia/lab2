import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatronTest {
    private Patron patron;
    private Book book1;
    private Book book2;
    private DVD dvd;
    private Library lib;
    List<Item> testItem;
    @BeforeEach
    public void setUp()
    {
        patron = new Patron("Misha");
        lib = new Library();
        book1 = new Book ("3 ways to go outside","Viktor Dudka");
        book2 = new Book ("Folk medicine","Stepan Ryto");
        dvd = new DVD ("Matrix",90);
        testItem = new ArrayList<Item>();

    }
    @Test
    public void testReturnItem()
    {
        testItem.add(book2);
        testItem.add(dvd);

        patron.borrowItem(book1);
        patron.borrowItem(book2);
        patron.borrowItem(dvd);

        patron.returnItem(book1);

        assertEquals(testItem,patron.getBorrowedItems());

    }
    @Test
    public void testBorrowItem()
    {
        testItem.add(book1);
        testItem.add(book2);
        testItem.add(dvd);

        patron.borrowItem(book1);
        patron.borrowItem(book2);
        patron.borrowItem(dvd);

        assertEquals(testItem,patron.getBorrowedItems());
    }
    @Test
    public void testIsNotBorrowItem()
    {
        testItem.add(book1);
        testItem.add(dvd);

        patron.borrowItem(book1);
        patron.borrowItem(book2);
        patron.borrowItem(dvd);

        assertNotEquals(testItem,patron.getBorrowedItems());
    }

}