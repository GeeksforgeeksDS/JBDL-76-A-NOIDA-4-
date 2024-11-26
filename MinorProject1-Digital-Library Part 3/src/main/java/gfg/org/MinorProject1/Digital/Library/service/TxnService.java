package gfg.org.MinorProject1.Digital.Library.service;


import gfg.org.MinorProject1.Digital.Library.dto.CreateTxnRequest;
import gfg.org.MinorProject1.Digital.Library.dto.ReturnTxnRequest;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterBookBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterStudentBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.Operator;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.TxnStatus;
import gfg.org.MinorProject1.Digital.Library.model.Book;
import gfg.org.MinorProject1.Digital.Library.model.Student;
import gfg.org.MinorProject1.Digital.Library.model.Txn;
import gfg.org.MinorProject1.Digital.Library.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxnService {

    @Autowired
    private TxnRepository txnRepository;


    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;


    public int createTxn(CreateTxnRequest createTxnRequest) throws Exception {
     List<Student> students=  studentService.filterStudent(Operator.EQUALS, FilterStudentBy.EMAIL,createTxnRequest.getStudentEmail());
        Student student = students.get(0);

        if(student==null){
            throw new Exception("student not found");
        }

       List<Book> books = bookService.filterBook(Operator.EQUALS, FilterBookBy.BOOK_NO,createTxnRequest.getBookNo());

        Book book = books.get(0);

        if(book==null){
            throw new Exception("book not found");
        }


        Txn txn = Txn.builder()
                .student(student)
                .book(book)
                .paidAmount(createTxnRequest.getPaidAmount())
                .txnStatus(TxnStatus.ISSUED)
                .build();
        txnRepository.save(txn);

        book.setStudent(student);
        bookService.updateBookSave(book);
        return txn.getId();
    }

    public String returnBook(ReturnTxnRequest returnTxnRequest) throws Exception {

       List<Student> students = studentService.filterStudent(Operator.EQUALS, FilterStudentBy.EMAIL,returnTxnRequest.getStudentEmail());
       Student student = students.get(0);

       if(student==null){
           throw new Exception("Student not found");
       }

       List<Book> books = bookService.filterBook(Operator.EQUALS, FilterBookBy.BOOK_NO,returnTxnRequest.getBookNo());
       Book book = books.get(0);

       if(book==null){
           throw new Exception("Book not found");
       }

       Txn txn = txnRepository.findById(returnTxnRequest.getTxnId()).get();

       if(txn.getTxnStatus() == TxnStatus.ISSUED){
           txn.setTxnStatus(TxnStatus.RETURNED);
       }

       long issuedTime = txn.getCreatedOn().getTime();
        System.out.println(issuedTime);

       long returnTime = System.currentTimeMillis();

       long diff = returnTime - issuedTime;

       long days = diff/(24*60*60*1000); //total number of days

        if(days>30){
            long  dueDays = days - 30; //number of days after 30 days
            int fine = (int) (dueDays*10); //fine per day

            txn.setFine(fine);
            txn.setPaidAmount(txn.getPaidAmount()-fine);
        }

        txnRepository.save(txn);

        book.setStudent(null);
        bookService.updateBookSave(book);

        return "Book returned successfully";

        }









    }

