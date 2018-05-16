package com.rushqui.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="album")
public class Album implements Serializable {
	
	@Id
	@Column(name="id_album")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAlbum; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="songs")
	private String songs;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="cover")
	private String cover;

	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_singer")
	private Singer singer;
	
	
	
	public Album(String name, String songs, Integer year, String cover) {
		super();
		this.name = name;
		this.songs = songs;
		this.year = year;
		this.cover = cover;
	
	}
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSongs() {
		return songs;
	}
	public void setSongs(String songs) {
		this.songs = songs;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
	
}
