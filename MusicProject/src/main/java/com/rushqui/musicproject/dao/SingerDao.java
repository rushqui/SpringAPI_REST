package com.rushqui.musicproject.dao;

import java.util.List;

import com.rushqui.musicproject.model.Singer;



public interface SingerDao {
	
	void saveSinger(Singer singer);
	
	
	void deleteSingerById(Long idSinger);
	
	void updateSinger(Singer singer);
	
	List<Singer> findAllSingers();
	
	Singer findSingerById(Long idSinger); 
	
	Singer findSingerByName(String name);
	

} 
