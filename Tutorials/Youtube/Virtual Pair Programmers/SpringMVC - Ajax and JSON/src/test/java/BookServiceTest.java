import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import com.jurik99.model.Book;

public class BookServiceTest {

	private List<Book> preparedListOfBooks = Book.prepateListOfBooks();

	@Test
	public void sizeOfPreparedListOfBooks() {
		assertNotNull(preparedListOfBooks);
		assertEquals(10, preparedListOfBooks.size());
	}

	@Test
	public void lastTitleOfBook() {
		final int LAST_BOOK = preparedListOfBooks.size() - 1;
		assertEquals("Spring w akcji", preparedListOfBooks.get(LAST_BOOK).getTitle());
	}
}
