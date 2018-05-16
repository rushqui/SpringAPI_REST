package com.rushqui.hibernate.dao;

import java.util.List;

import com.rushqui.hibernate.model.Singer;

public interface SingerDao {
	
	void saveSinger(Singer singer);
	
	void deleteSinger(Long idSinger);
	
	void updateSinger(Singer singer);
	
	List<Singer> findAllSingers();
	
	Singer findSingerById(Long idSinger);
	
	Singer findSingerByName(String name);
	
	

} 
