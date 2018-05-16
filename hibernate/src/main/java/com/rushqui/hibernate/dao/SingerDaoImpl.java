package com.rushqui.hibernate.dao;

import java.util.List;

import com.rushqui.hibernate.model.Singer;

public class SingerDaoImpl extends MusicSession implements SingerDao{
	
	private MusicSession musicSession;

	public SingerDaoImpl() {
		musicSession = new MusicSession();
		
	}

	public void saveSinger(Singer singer) {
		// TODO Auto-generated method stub
		musicSession.getSession().persist(singer);
		musicSession.getSession().getTransaction().commit();
	
		
	}

	public void deleteSinger(Long idSinger) {
		// TODO Auto-generated method stub
		
	}

	public void updateSinger(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	public List<Singer> findAllSingers() {
		// TODO Auto-generated method stub
		return musicSession.getSession().createQuery("from Singer").list();
	}

	public Singer findSingerById(Long idSinger) {
		// TODO Auto-generated method stub
		return musicSession.getSession().get(Singer.class,idSinger);
	}

	public Singer findSingerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
