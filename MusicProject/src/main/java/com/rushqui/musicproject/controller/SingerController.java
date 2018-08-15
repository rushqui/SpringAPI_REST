package com.rushqui.musicproject.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.LongFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.rushqui.musicproject.model.Album;
import com.rushqui.musicproject.model.Singer;
import com.rushqui.musicproject.service.SingerService;
import com.rushqui.musicproject.utils.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class SingerController {
	
	@Autowired
	SingerService _singerService;
	
	//GET
	@RequestMapping(value="/singers", method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Singer>> getSingers(@RequestParam(value="name", required=false) String name){
		
		List<Singer> singers = new ArrayList<>();
		
		if(name == null) {
			singers = _singerService.findAllSingers();
			if(singers.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Singer>>(singers, HttpStatus.OK);
		
		}else{
				Singer singer = _singerService.findSingerByName(name);
			if(singer == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
				singers.add(singer);
				return new ResponseEntity<List<Singer>>(singers,HttpStatus.OK);
		}
	}
	
	//GET 
	@RequestMapping(value="/singers/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<Singer> getSingerById(@PathVariable("id") Long idSinger){
		if(idSinger == null || idSinger <=0) {
			return new ResponseEntity(new CustomErrorType("IdSinger is required"), HttpStatus.CONFLICT);
		}
			Singer singer = _singerService.findSingerById(idSinger);
			if(singer == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<Singer>(singer,HttpStatus.OK);
	}

	//POST
	@RequestMapping(value="/singers", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<?> createSinger(@RequestBody Singer singer, UriComponentsBuilder uriComponentsBuilder){
		
		if(singer.getName().equals(null) || singer.getName().isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Singer name is required"), HttpStatus.CONFLICT);	
		}
		
		if(_singerService.findSingerByName(singer.getName())!= null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_singerService.saveSinger(singer);
		Singer singer2 = _singerService.findSingerByName(singer.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("v1/albums/{id}").
				buildAndExpand(singer2.getIdSinger()).
				toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
				
	}
	
	//UPDATE
	@RequestMapping(value="/singers/{id}", method=RequestMethod.PATCH, headers="Accept=application/json")
	public ResponseEntity<Singer> updateSinger(@PathVariable("id") Long idSinger, @RequestBody Singer singer){
		
		if(idSinger==null || idSinger<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Singer currentSinger = _singerService.findSingerById(idSinger);
		if(currentSinger == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		currentSinger.setName(singer.getName());
		currentSinger.setAvatar(singer.getAvatar());
		
		_singerService.updateSinger(currentSinger);
		return new ResponseEntity<Singer>(currentSinger, HttpStatus.OK);
	}

	//DELETE
	@RequestMapping(value="/singers/{id}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public ResponseEntity<?> deleteSinger(@PathVariable("id") Long idSinger){
		
		if(idSinger==null || idSinger<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Singer singer = _singerService.findSingerById(idSinger);
		if(singer == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_singerService.deleteSingerById(idSinger);
		return new ResponseEntity<Singer>(HttpStatus.OK);
	}
	
	public static final String SINGER_UPLOADED_FOLDER="images/singers/";
	
	//CREATE TEACHER IMAGE
	@RequestMapping(value="/singers/images", method=RequestMethod.POST, headers=("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> uploadSingerImage(@RequestParam("id_singer") Long idSinger, 
			@RequestParam("file") MultipartFile multipartFile, 
			UriComponentsBuilder uriComponentsBuilder){
		if(idSinger == null) {
			return new ResponseEntity(new CustomErrorType("Please set id_singer"), HttpStatus.NO_CONTENT);
		}
		
		if(multipartFile.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Please select a file to upload"), HttpStatus.NO_CONTENT);
		}	
		Singer singer = _singerService.findSingerById(idSinger);
		if(singer==null) {
			return new ResponseEntity(new CustomErrorType("Singer with id_singer:"+idSinger+"not found"), HttpStatus.NO_CONTENT);
		}
		if(!singer.getAvatar().isEmpty() || singer.getAvatar()!= null) {
			String fileName = singer.getAvatar();
			Path path = Paths.get(fileName);
			File f = path.toFile();
			if(f.exists()) {
				f.delete();
			}
		}
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateName = dateFormat.format(date);
			
			String fileName = String.valueOf(idSinger) + "-pictureSinger"+dateName+"."+multipartFile.getContentType().split("/")[1];
			singer.setAvatar(SINGER_UPLOADED_FOLDER +  fileName);
			
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(SINGER_UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);
			
			_singerService.updateSinger(singer);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(new CustomErrorType("Error during upload: "+multipartFile.getOriginalFilename()), HttpStatus.NO_CONTENT);
		}
	}
	 
}
