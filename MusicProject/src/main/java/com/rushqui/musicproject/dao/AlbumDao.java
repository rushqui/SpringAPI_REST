package com.rushqui.musicproject.dao;

import java.util.List;

import com.rushqui.musicproject.model.Album;

public interface AlbumDao {
	
	void saveAlbum(Album album);
	
	void deleteAlbum(Long idAlbum);
	
	void updateAlbum(Album album);
	
	List<Album> findAllAlbums();
	
	Album findAlbumById(Long idAlbum);
	
	Album findAlbumByName(String name);
	
	List<Album> findAlbumsByIdSinger(Long idSinger);
	
}
	