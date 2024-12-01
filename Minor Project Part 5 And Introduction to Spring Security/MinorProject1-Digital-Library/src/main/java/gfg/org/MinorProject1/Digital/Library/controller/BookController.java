package gfg.org.MinorProject1.Digital.Library.controller;

import gfg.org.MinorProject1.Digital.Library.dto.CreateBookRequest;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterBookBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.Operator;
import gfg.org.MinorProject1.Digital.Library.model.Book;
import gfg.org.MinorProject1.Digital.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest createBookRequest){
        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody CreateBookRequest createBookRequest){
        return ResponseEntity.ok(bookService.updateBook(id,createBookRequest));
    }

    @GetMapping("/filter/{operator}/{filterBookBy}/{value}")
    public ResponseEntity<List<Book>> filterBook(@PathVariable Operator operator, @PathVariable FilterBookBy filterBookBy, @PathVariable String value){
        return ResponseEntity.ok(bookService.filterBook(operator,filterBookBy,value));
    }





}
