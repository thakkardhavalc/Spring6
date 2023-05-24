package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootstrapData.class);

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEjb = new Book();
        noEjb.setTitle("J2EE Development without EJB");
        noEjb.setIsbn("111111");

        Author rodSaved = authorRepository.save(rod);
        Book noEjbSaved = bookRepository.save(noEjb);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEjbSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher media = new Publisher();
        media.setPublisherName("Media");
        media.setAddress("123 Red Embers Parade");
        media.setCity("Calgary");
        media.setState("Alberta");
        media.setZip("T3N1P7");

        publisherRepository.save(media);

        LOGGER.info("In Bootstrap");
        LOGGER.info("Author Count: " + authorRepository.count());
        LOGGER.info("Book Count: " + bookRepository.count());
        LOGGER.info("Publisher Count: " + publisherRepository.count());

    }
}
