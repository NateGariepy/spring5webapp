package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Three Moons Publishing");
        publisher.setCity("Augusta");
        publisher.setState("ME");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author nate = new Author("Nate", "Gariepy");
        Book dfg = new Book("Dwarf Fortress Guide", "123123");
        nate.getBooks().add(dfg);
        dfg.getAuthors().add(nate);

        authorRepository.save(nate);
        bookRepository.save(dfg);

        Author rob = new Author("Robert", "Waters");
        Book bgm = new Book("Beginners Guide to Meteorology", "321321");
        nate.getBooks().add(bgm);
        dfg.getAuthors().add(rob);


        authorRepository.save(rob);
        bookRepository.save(bgm);

        System.out.println("Number of Books: " + bookRepository.count());
    }
}