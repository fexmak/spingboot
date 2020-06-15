package guru.springframework.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.model.Book;
import guru.springframework.springwebapp.model.Publisher;
import guru.springframework.springwebapp.repositories.AuthorRepository;
import guru.springframework.springwebapp.repositories.BookRepository;
import guru.springframework.springwebapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;


	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		
		publisherRepository.save(publisher);
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book ("Domain Driven Design", "1234",publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		//Ron
		Author ron = new Author("Ron", "Chacho");
		Book ddd2 = new Book ("Java Concurrency in Practice", "33234", publisher);
		eric.getBooks().add(ddd2);
		ddd.getAuthors().add(ron);
		
		
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);
		this.authorRepository.save(ron);
		this.bookRepository.save(ddd2);
		
		
	}

}
