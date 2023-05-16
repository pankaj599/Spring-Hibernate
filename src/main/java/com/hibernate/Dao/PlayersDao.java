package com.hibernate.Dao;

import java.util.List;

import com.hibernate.entity.Players;

public interface PlayersDao {
public void insert(Players players);
public Players read(int i);
public List<Players> readall();
public void delete(int i);
public void update(Players p);
}
