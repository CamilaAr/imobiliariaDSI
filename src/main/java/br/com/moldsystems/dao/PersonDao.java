package br.com.moldsystems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import br.com.moldsystems.models.Person;

public class PersonDao {
	private EntityManagerFactory factory;

	public PersonDao() {

		factory = Persistence.createEntityManagerFactory("imobiliaria");

	}

	public void insert(Person person) {
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(person);
			manager.getTransaction().commit();
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {

		EntityManager manager = factory.createEntityManager();
		try {

			List<Person> persons = manager.createQuery("from Person").getResultList();
			return persons;
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}

	}

	public void delete(long id) {

		EntityManager manager = factory.createEntityManager();
		try {
			Person fp = manager.find(Person.class, id);
			manager.getTransaction().begin();
			manager.remove(fp);
			manager.getTransaction().commit();
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}

	}

	public Person search(long id) {
		EntityManager manager = factory.createEntityManager();
		try {
			Person person = manager.find(Person.class, id);
			return person;
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}

	}

	public void update(Person person) {

		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(person);
			manager.getTransaction().commit();
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}
	}

}
