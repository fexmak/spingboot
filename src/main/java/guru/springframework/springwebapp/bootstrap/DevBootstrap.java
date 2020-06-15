package guru.springframework.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.model.Book;
import guru.springframework.springwebapp.repositories.AuthorRepository;
import guru.springframework.springwebapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	
	private void initData() {
		
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book ("Domain Driven Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		//Ron
		Author ron = new Author("Ron", "Chacho");
		Book ddd2 = new Book ("Java Concurrency in Practice", "33234", "Editorial Pirulo");
		eric.getBooks().add(ddd2);
		ddd.getAuthors().add(ron);
		
		
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);
		this.authorRepository.save(ron);
		this.bookRepository.save(ddd2);
		
		
	}

}
