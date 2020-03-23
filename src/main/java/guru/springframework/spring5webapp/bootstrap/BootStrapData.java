package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author azhar = new Author("azhar","ahmed");
        Book book = new Book("Lord of the Rings", "12345");

        //Add book to azhar
        azhar.getBookSet().add(book);

        //Add azhar as author of the book
        book.getAuthors().add(azhar);

        authorRepository.save(azhar);
        bookRepository.save(book);

        Author sal = new Author("sal","azhar");
        Book salbook = new Book("Stem Cell Biology","123233");
        sal.getBookSet().add(salbook);
        salbook.getAuthors().add(sal);

        authorRepository.save(sal);
        bookRepository.save(salbook);

        System.out.println("***********************Started bootstrap");
        System.out.println("Number of books: "+bookRepository.count());

    }
}
