package com.rushqui.musicproject.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rushqui.musicproject.model.Singer;
import com.rushqui.musicproject.model.SingerSocialMedia;



@Repository	
@Transactional
public class SingerDaoImpl extends AbstractSession implements SingerDao{
	



	public void saveSinger(Singer singer) {
		// TODO Auto-generated method stub
		getSession().persist(singer);	
	}
	
	public void deleteSingerById(Long idSinger) {
		// TODO Auto-generated method stub
		Singer singer = findSingerById(idSinger);
		if (singer != null) {
			
			Iterator<SingerSocialMedia> i = singer.getSingerSocialMedia().iterator();
			while (i.hasNext()) {
				SingerSocialMedia singerSocialMedia = i.next();
				i.remove();
				getSession().delete(singerSocialMedia);
				
				
			}
			singer.getSingerSocialMedia().clear();
			getSession().delete(singer);
		}
		
		
	}

	public void updateSinger(Singer singer) {
		// TODO Auto-generated method stub
		getSession().update(singer);
	}


	public List<Singer> findAllSingers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Singer").list();
	}

	public Singer findSingerById(Long idSinger) {
		// TODO Auto-generated method stub
		return (Singer) getSession().get(Singer.class, idSinger);
	}

	public Singer findSingerByName(String name) {
		// TODO Auto-generated method stub
		return (Singer) getSession().createQuery(
				"from Singer where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	
	

}
