package com.rushqui.musicproject.service;

import java.util.List;

import com.rushqui.musicproject.model.Singer;

public interface SingerService {

	
	void saveSinger(Singer singer);
	
	void deleteSingerById(Long idSinger);
	
	void updateSinger(Singer singer);
	
	List<Singer> findAllSingers();
	
	Singer findSingerById(Long idSinger); 
	
	Singer findSingerByName(String name);
}
