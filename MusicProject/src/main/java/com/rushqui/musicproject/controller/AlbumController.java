package com.rushqui.musicproject.controller;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.rushqui.musicproject.model.Album;
import com.rushqui.musicproject.service.AlbumService;
import com.rushqui.musicproject.utils.CustomErrorType;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/v1")
public class AlbumController {
	
	@Autowired
	AlbumService _albumService;
	
	//GET
	@RequestMapping(value="/albums", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<Album>> getAlbums(@RequestParam(value="name",required=false)String name){
		List<Album> albums = new ArrayList<>();
	if(name==null) {
		albums = _albumService.findAllAlbums();
		if(albums.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<Album>>(albums,HttpStatus.OK);
	}else {
		Album album = _albumService.findAlbumByName(name);
		if(album == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		albums.add(album);
		return new ResponseEntity<List<Album>>(albums,HttpStatus.OK);
	}
	
	}
	
	//GET
	@RequestMapping(value="/albums/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Album> getAlbumById(@PathVariable("id")Long idAlbum){
		if(idAlbum == null || idAlbum <= 0) {
			return new ResponseEntity(new CustomErrorType("IdAlbum is required"),HttpStatus.CONFLICT);
		}
			Album album = _albumService.findAlbumById(idAlbum);
			if(album==null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Album>(album,HttpStatus.OK);
		}

	
	//POST
	@RequestMapping(value="albums",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<?> createAlbum(@RequestBody Album album, UriComponentsBuilder uriComponentsBuilder){
		if(album.getName().equals(null) || album.getName().isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Album name is required"),HttpStatus.CONFLICT);
		}
		if(_albumService.findAlbumByName(album.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_albumService.saveAlbum(album);
		Album album2 = _albumService.findAlbumByName(album.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/v1/albums/{id}").
				buildAndExpand(album2.getIdAlbum()).
				toUri());
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}

	
	//UPDATE
	@RequestMapping(value="/album/{id}", method=RequestMethod.PATCH, headers="Accept=application/json")
	public ResponseEntity<Album> updateAlbum(@PathVariable("id") Long idAlbum, @RequestBody Album album){
		if(idAlbum==null||idAlbum<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Album currentAlbum = _albumService.findAlbumById(idAlbum);
		if(currentAlbum == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
			currentAlbum.setName(album.getName());
			currentAlbum.setCover(album.getCover());
			
			_albumService.updateAlbum(currentAlbum);
			return new ResponseEntity<Album>(HttpStatus.OK);
	}
	
	
	//DELETE
	@RequestMapping(value="/album/{id}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public ResponseEntity<?> deleteAlbum(@PathVariable("id") Long idAlbum){
		if(idAlbum==null || idAlbum<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Album album = _albumService.findAlbumById(idAlbum);
		if(album == null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		_albumService.deleteAlbum(idAlbum);
		return new ResponseEntity<Album>(HttpStatus.OK);
	}
	
}
