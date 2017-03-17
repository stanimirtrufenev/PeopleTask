package com.task.daos;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import model.TAddress;
import model.TMail;
import model.TPeople;

@Component
public class CreateDao {

	public void create(String name, String pin, String addrType, String addrInfo, String emailType, String email) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		TPeople person = new TPeople();
		person.setFullName(name);
		person.setPin(pin);

		TMail mail = new TMail();
		mail.setEmail(email);
		mail.setEmailType(emailType);
		mail.setTPeople(person);

		TAddress address = new TAddress();
		address.setAddrInfo(addrInfo);
		address.setAddrType(addrType);
		address.setTPeople(person);

		entitymanager.persist(person);
		entitymanager.persist(mail);
		entitymanager.persist(address);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();

	}

}
