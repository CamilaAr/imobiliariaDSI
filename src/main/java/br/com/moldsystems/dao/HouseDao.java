package br.com.moldsystems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import br.com.moldsystems.models.House;

public class HouseDao {

	private EntityManagerFactory factory;

	public HouseDao() {

		factory = Persistence.createEntityManagerFactory("imobiliaria");

	}

	public void insert(House house) {
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(house);
			manager.getTransaction().commit();
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<House> list() {

		EntityManager manager = factory.createEntityManager();
		try {

			List<House> houses = manager.createQuery("from House").getResultList();
			return houses;
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}

	}

	public void delete(long id) {

		EntityManager manager = factory.createEntityManager();
		try {
			House fp = manager.find(House.class, id);
			manager.getTransaction().begin();
			manager.remove(fp);
			manager.getTransaction().commit();
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}

	}

	public House search(long id) {
		EntityManager manager = factory.createEntityManager();
		try {
			House house = manager.find(House.class, id);
			return house;
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}

	}

	public void update(House house) {

		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(house);
			manager.getTransaction().commit();
		} catch (EntityNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close();
		}
	}
}
