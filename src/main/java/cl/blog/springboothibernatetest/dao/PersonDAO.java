package cl.blog.springboothibernatetest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cl.blog.springboothibernatetest.entitys.PersonEntity;

@Transactional
@Repository("personDao")
public class PersonDAO implements IPersonDAO {
	
	@PersistenceContext
	private EntityManager entityManager;	

	public List<PersonEntity> getAllPersons() {
		
		String  hql = "FROM PersonEntity as p ORDER BY p.personId";
		List<PersonEntity> list = (List<PersonEntity>)entityManager.createQuery(hql).getResultList(); 
		return list;
	}

	public PersonEntity getPersonById(Integer personId) {
		return entityManager.find(PersonEntity.class,	personId);
	}

	public void addPerson(PersonEntity person) {
		
		entityManager.persist(person);

	}

	public void deletePerson(PersonEntity person) {
		entityManager.remove(getPersonById(person.getPersonId()));

	}

}
