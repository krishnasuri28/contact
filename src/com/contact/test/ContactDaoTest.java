package com.contact.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.contact.Contact;
import com.contact.ContactDaoImpl;

class ContactDaoTest {
	
	private DriverManagerDataSource dataSource;
	private ContactDaoImpl contact;
	
	@BeforeEach
	public void initilize() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Anurag@69");
		contact = new ContactDaoImpl(dataSource);
	}

	@Test
	void testSave() {
		
		Contact insert = new Contact("Sowmya", "Sowmya@gmail.com", "813 SW Mill", "9441827278");
		int result = contact.save(insert);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact update = new Contact(2,"Anurag","anurag@gmail.com", "us","1234");
		int result = contact.update(update);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Contact result = contact.get(1);
		assertThat(result.getName(), is("Vanam Valinda"));
	}

	@Test
	void testDelete() {
		int result = contact.delete(1);
		System.out.println(result);
	}

	@Test
	void testList() {
		List<Contact> result = contact.list();
		assertThat(result.size(),is(2));
	}

}
