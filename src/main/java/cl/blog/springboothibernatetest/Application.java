package cl.blog.springboothibernatetest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.blog.springboothibernatetest.dao.IPersonDAO;
import cl.blog.springboothibernatetest.entitys.PersonEntity;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	@Autowired
	private IPersonDAO personDao;
	
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
	public void run(String... args) throws Exception {
    	
    	System.out.println("-------------------------------");
    	System.out.println("First people search");
    	System.out.println("-------------------------------");
    	
    	List<PersonEntity> listPerson = personDao.getAllPersons();

    	for (PersonEntity personEntity : listPerson) {
    		System.out.println(personEntity);
		}
    	
    	System.out.println("-------------------------------");
    	System.out.println("Person (Martin Amis) is added and a new search is performed");
    	System.out.println("-------------------------------");
    	
    	PersonEntity person = new PersonEntity();
    	person.setPersonId(4);
    	person.setFirstName("Martin");
    	person.setLastName("Amis");
    	person.setEmail("martin.amis@mail.com");
    	person.setState(1);
    	
    	personDao.addPerson(person);
    	listPerson = personDao.getAllPersons();
    	for (PersonEntity personEntity : listPerson) {
    		System.out.println(personEntity);
		}
    	
    	
    	System.out.println("-------------------------------");
    	System.out.println("Person (Martin Amis) is deleted and a new search is performed");
    	System.out.println("-------------------------------");
    	
    	personDao.deletePerson(person);
    	listPerson = personDao.getAllPersons();
    	for (PersonEntity personEntity : listPerson) {
    		System.out.println(personEntity);
		}
    	
    }
}
