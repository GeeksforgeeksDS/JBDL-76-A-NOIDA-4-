package gfg.org.MinorProject1.Digital.Library.service;

import gfg.org.MinorProject1.Digital.Library.dto.CreateBookRequest;
import gfg.org.MinorProject1.Digital.Library.model.Author;
import gfg.org.MinorProject1.Digital.Library.model.Book;
import gfg.org.MinorProject1.Digital.Library.repository.AuthorRepository;
import gfg.org.MinorProject1.Digital.Library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class BookServiceTest {


    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCreateBook() {

        CreateBookRequest createBookRequest = CreateBookRequest.builder()
                .bookName("Test Book")
                .bookNo("123")
                .bookType("PHYSICS")
                .pages(100)
                .cost(10)
                .authorName("John Doe")
                .authorEmail("YHbHx@example.com")
                .producer("Publisher A")
                .build();

        Author mockAuthor = Author.builder()
                .id(1)
                .authorName("Joh")
                .email("YHbgggx@example.com")
                .build();


        when(authorRepository.findByEmail(createBookRequest.getAuthorEmail())).thenReturn(mockAuthor); // mock class method

        Book bookMock = createBookRequest.toBook();
        bookMock.setAuthor(mockAuthor);

        when(bookRepository.save(bookMock)).thenReturn(bookMock); // mock class method

        Book createdBook = bookService.createBook(createBookRequest); //actual class method

        // Assertions
        assertNotNull(createdBook);
        assertEquals(createBookRequest.getBookName(), createdBook.getBookName());
        assertEquals(mockAuthor, createdBook.getAuthor());


        verify(authorRepository, times(1)).findByEmail(createBookRequest.getAuthorEmail());

        verify(bookRepository, times(1)).save(bookMock);




    }









    @Test
    void testGetBook() {
        // Arrange
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);
        book.setBookName("Test Book");


        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));


        // Act
        Book result = bookService.getBook(bookId);


        // Assert
        assertNotNull(result);
        assertEquals(book, result);
        verify(bookRepository, times(1)).findById(bookId);
    }




}
