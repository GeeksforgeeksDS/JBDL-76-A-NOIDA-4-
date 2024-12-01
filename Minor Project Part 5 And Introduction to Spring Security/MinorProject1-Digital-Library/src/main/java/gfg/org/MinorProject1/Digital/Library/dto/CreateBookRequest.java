package gfg.org.MinorProject1.Digital.Library.dto;

import gfg.org.MinorProject1.Digital.Library.model.Author;
import gfg.org.MinorProject1.Digital.Library.model.Book;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.BookType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest  implements Serializable {
    private String bookName;
    private String bookNo;
    private String bookType;
    private int pages;
    private int cost;
    private String authorName;
    private String authorEmail;

    private String producer;

    public Book toBook() {
        return Book.builder()
                .bookName(bookName)
                .bookNo(bookNo)
                .bookType(BookType.valueOf(bookType))
                .pages(pages)
                .cost(cost)
                .producer(producer)
                .build();
    }

    public Author toAuthor() {
        return Author.builder()
                .authorName(authorName)
                .email(authorEmail)
                .build();
    }
}

