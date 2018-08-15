package com.rushqui.musicproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rushqui.musicproject.model.Album;
import com.rushqui.musicproject.model.Singer;


@Repository	
@Transactional 	
public class AlbumDaoImpl extends AbstractSession implements AlbumDao {

	@Override
	public void saveAlbum(Album album) {
		// TODO Auto-generated method stub																																																																													
		getSession().persist(album);
	}

	@Override
	public void deleteAlbum(Long idAlbum) {
		// TODO Auto-generated method stub
		Album album = findAlbumById(idAlbum);
		if(album != null) {
			getSession().delete(album);
		}
	}

	@Override
	public void updateAlbum(Album album) {
		// TODO Auto-generated method stub
		getSession().update(album);
		
	}

	@Override
	public List<Album> findAllAlbums() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Album").list();
	}

	@Override
	public Album findAlbumById(Long idAlbum) {
		// TODO Auto-generated method stub
		return getSession().get(Album.class, idAlbum);
	}

	@Override
	public Album findAlbumByName(String name) {
		// TODO Auto-generated method stub
		return (Album) getSession().createQuery(
				"from Album where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Album> findAlbumsByIdSinger(Long idSinger) {
		// TODO Auto-generated method stub
		return (List<Album>) getSession().createQuery(
				"from Album a join a.singer s where s.idSinger = :idSinger")
				.setParameter("idSinger", idSinger).list();
	}
	

}
