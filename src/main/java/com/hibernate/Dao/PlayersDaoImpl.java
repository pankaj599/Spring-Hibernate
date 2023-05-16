package com.hibernate.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.hibernate.entity.Players;
@Component("players")
public class PlayersDaoImpl implements PlayersDao{
	
	@Autowired
	private HibernateTemplate temp;
	
	public HibernateTemplate getTemp() {
		return temp;
	}

	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}

	@Transactional
	public void insert(Players players) {
		//note save method returns the unique id of the row and not the no. of row affected
	Integer i = (Integer) this.temp.save(players);
	}

	//select single players
	public Players read(int i) {
		Players p = this.temp.get(Players.class, i);
		return p;
	}

	//select all players
	public List<Players> readall() {
		List<Players> loadAll = this.temp.loadAll(Players.class);
		return loadAll;
	}

	//delete query;
	@Transactional
	public void delete(int i) {
		Players p = this.temp.get(Players.class, i);
		this.temp.delete(p);
		
	}

	//update 
	@Transactional
	public void update(Players p) {
		this.temp.update(p);
	}
	

}
