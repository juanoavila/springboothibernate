package cl.blog.springboothibernatetest.dao;

import java.util.List;

import cl.blog.springboothibernatetest.entitys.PersonEntity;

public interface IPersonDAO {
	
	List<PersonEntity> getAllPersons();
	
	PersonEntity getPersonById(Integer personId);
	
	void addPerson(PersonEntity person);
	
	void deletePerson(PersonEntity person);

}
