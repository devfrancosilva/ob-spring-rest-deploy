package com.example.obspringrest2;

import com.example.obspringrest2.entities.Book;
import com.example.obspringrest2.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringRest2Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringRest2Application.class, args);

		BookRepository repository = context.getBean(BookRepository.class);

		Book libro1 = new Book(null, "Harry Potter", "Autor1", 530, 29.99);
		Book libro2 = new Book(null, "Warcraft", "Autor2", 250, 9.99);

		// Guardar

		repository.save(libro1);
		repository.save(libro2);

		System.out.println(repository.findAll().size());
	}

}
