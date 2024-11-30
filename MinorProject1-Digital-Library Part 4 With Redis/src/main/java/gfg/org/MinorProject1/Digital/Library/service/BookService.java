package gfg.org.MinorProject1.Digital.Library.service;

import gfg.org.MinorProject1.Digital.Library.dto.CreateBookRequest;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterBookBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.Operator;
import gfg.org.MinorProject1.Digital.Library.model.Author;
import gfg.org.MinorProject1.Digital.Library.model.Book;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.BookType;
import gfg.org.MinorProject1.Digital.Library.repository.AuthorRepository;
import gfg.org.MinorProject1.Digital.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate; // Inject the RedisTemplate>

    private final String BOOK_KEY = "book";



    public Book createBook(CreateBookRequest createBookRequest) {
        Author author = authorRepository.findByEmail(createBookRequest.getAuthorEmail());

        if(author == null) {
            author = authorRepository.save(createBookRequest.toAuthor());
        }

        Book book = createBookRequest.toBook();
        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);
         redisTemplate.opsForList().leftPushAll(BOOK_KEY, savedBook);

         redisTemplate.opsForList().leftPushAll(BOOK_KEY+book.getId(), savedBook, Duration.ofMinutes(10));
         redisTemplate.opsForList().leftPushAll(BOOK_KEY+book.getBookNo(), savedBook);
         redisTemplate.opsForList().leftPushAll(BOOK_KEY+book.getBookName(), savedBook);

        return savedBook;


    }

    public Book getBook(int id) {

            List<Object> bookList  =  redisTemplate.opsForList().range(BOOK_KEY+id,0 ,-1);


            if(bookList != null){
                return (Book) bookList.get(0);
            }

        return bookRepository.findById(id).get();
    }


    public List<Book> getAllBooks() {

        List<Object> books = redisTemplate.opsForList().range(BOOK_KEY, 0, -1);

        if(books != null){
            return books.stream()
                    .map(book -> (Book) book)
                    .toList();
        }

        return bookRepository.findAll();
    }


    public Book updateBook(int id, CreateBookRequest createBookRequest) {

        redisTemplate.opsForList().leftPushAll(BOOK_KEY+id, createBookRequest);

        Book book = bookRepository.findById(id).get();


        book.setBookName(createBookRequest.getBookName());
        book.setBookNo(createBookRequest.getBookNo());
        book.setBookType(BookType.valueOf(createBookRequest.getBookType()));
        book.setPages(createBookRequest.getPages());
        book.setCost(createBookRequest.getCost());
        book.setProducer(createBookRequest.getProducer());

        return bookRepository.save(book);
    }

    public List<Book> filterBook(Operator operator, FilterBookBy filterBookBy, String value) {
        switch (operator){
            case EQUALS:
                switch (filterBookBy){
                    case BOOK_NAME:
                      List<Object> bookList = redisTemplate.opsForList().range(BOOK_KEY+value, 0, -1);

                      if(bookList != null){
                          return bookList.stream()
                                  .map(book -> (Book) book)
                                  .toList();
                      }

                        return bookRepository.findByBookName(value);
                    case BOOK_NO:
                        return bookRepository.findByBookNo(value);
                    case COST:
                        return bookRepository.findByCost(Integer.parseInt(value));
                    case PAGES:
                        return bookRepository.findByPages(Integer.parseInt(value));
                }
            case GREATER_THAN:
                switch (filterBookBy){
                    case COST:
                        return bookRepository.findByCostGreaterThan(Integer.parseInt(value));
                    case PAGES:
                        return bookRepository.findByPagesGreaterThan(Integer.parseInt(value));
                }
            case LESS_THAN:
                switch (filterBookBy){
                    case COST:
                        return bookRepository.findByCostLessThan(Integer.parseInt(value));
                    case PAGES:
                        return bookRepository.findByPagesLessThan(Integer.parseInt(value));
                }
            default:
                return new ArrayList<>();
        }

    }

    public void updateBookSave(Book book) {
        bookRepository.save(book);
    }
}
