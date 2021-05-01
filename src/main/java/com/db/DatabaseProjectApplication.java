package com.db;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.db.entity.Person;
import com.db.jdbc.PesronJdbcDAO;

@SpringBootApplication
public class DatabaseProjectApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PesronJdbcDAO personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//personJdbcDao.findAll();
		//logger.info("Pesron {}",personJdbcDao.findAll());
		logger.info("Pesron Find by Id>10002 {}",personJdbcDao.findById(10002));
		logger.info("Delete from person by Id>10002 {}",personJdbcDao.deleteById(10002));
		Person p = new Person();
		p.setId(10006);
		p.setName("Iram Fatima");
		p.setLocation("Bangalore");
		p.setBirthDate(new Date());
		logger.info("Inserting New Person>10006 {}",personJdbcDao.insert(p));		
	}

}
