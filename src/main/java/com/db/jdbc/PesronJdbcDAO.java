package com.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.db.entity.Person;

@Repository
public class PesronJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemp;
	
	class PersonMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getDate("birth_date"));
			return person;
		}
		
	}
	
//	public List<Person> findAll(){
//		return jdbcTemp.query("select * from person", new BeanPropertyRowMapper<Person>());
//	}
	public Person findById(int id){
		return jdbcTemp.queryForObject("select * from person where id = ?", new Object[] {id},new int[]{Types.INTEGER}
		,new PersonMapper());
	}
	
	public int deleteById(int id){
		 return jdbcTemp.update("delete from person where id = ?", new Object[] {id});
	}
	
	public int insert(Person p){
		 return jdbcTemp.update("insert into person(id,name,location,birth_date)values(?,?,?,?)", new Object[] {p.getId(),p.getName(),p.getLocation(),p.getBirthDate()});
	}

}
