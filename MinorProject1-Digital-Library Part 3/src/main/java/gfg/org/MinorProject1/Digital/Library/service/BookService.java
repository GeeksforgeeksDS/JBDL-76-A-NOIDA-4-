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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;



    public Book createBook(CreateBookRequest createBookRequest) {
        Author author = authorRepository.findByEmail(createBookRequest.getAuthorEmail());

        if(author == null) {
            author = authorRepository.save(createBookRequest.toAuthor());
        }

        Book book = createBookRequest.toBook();
        book.setAuthor(author);
        return bookRepository.save(book);


    }

    public Book getBook(int id) {
        return bookRepository.findById(id).get();
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book updateBook(int id, CreateBookRequest createBookRequest) {
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
