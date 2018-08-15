package com.rushqui.musicproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushqui.musicproject.dao.AlbumDao;
import com.rushqui.musicproject.model.Album;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumDao _albumDao;
	

	@Override
	public void saveAlbum(Album album) {
		// TODO Auto-generated method stub
		_albumDao.saveAlbum(album);
	}

	@Override
	public void deleteAlbum(Long idAlbum) {
		// TODO Auto-generated method stub
		_albumDao.deleteAlbum(idAlbum);
	}

	@Override
	public void updateAlbum(Album album) {
		// TODO Auto-generated method stub
		_albumDao.updateAlbum(album);
	}

	@Override
	public List<Album> findAllAlbums() {
		// TODO Auto-generated method stub
		return _albumDao.findAllAlbums();
	}

	@Override
	public Album findAlbumById(Long idAlbum) {
		// TODO Auto-generated method stub
		return _albumDao.findAlbumById(idAlbum);
	}

	@Override
	public Album findAlbumByName(String name) {
		// TODO Auto-generated method stub
		return _albumDao.findAlbumByName(name);
	}

	@Override
	public List<Album> findAlbumsByIdSinger(Long idSinger) {
		// TODO Auto-generated method stub
		return _albumDao.findAlbumsByIdSinger(idSinger);
	}

}
