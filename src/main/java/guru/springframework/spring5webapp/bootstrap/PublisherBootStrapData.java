package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PublisherBootStrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public PublisherBootStrapData(
            PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher(111L, "Bosco Publictions", "Kengeri", "Bangalore", "Karnanataka",
                                             "560060");
        Publisher publisher2 = new Publisher(111L, "Dummy Publications", "Rajiv Nagar", "Mysore", "Karnanataka",
                                             "570019");
        publisherRepository.save(publisher1);

        System.out.println("In publisherBootStrap class");
        System.out.println("count of the number of publishers: " + publisherRepository.count());

    }
}
