package dev.belueu.springbootwebapp.bootstrap;


import dev.belueu.springbootwebapp.model.Author;
import dev.belueu.springbootwebapp.model.Book;
import dev.belueu.springbootwebapp.model.Publisher;
import dev.belueu.springbootwebapp.repo.AuthorRepo;
import dev.belueu.springbootwebapp.repo.BookRepo;
import dev.belueu.springbootwebapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Belueu Publishing");
        publisher.setCity("Timisoara");
        publisher.setState("Timis");

        publisherRepo.save(publisher);
        System.out.println("Publisher Count: " + publisherRepo.count());


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "10001");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "10002");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(publisher);


        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Number of Authors: " + authorRepo.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
