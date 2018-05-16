package com.rushqui.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="singer")
public class Singer implements Serializable {
	
	@Id
	@Column(name="id_singer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSinger;
	
	@Column(name="name")
	private String name;
	
	@Column(name="avatar")	
	private String avatar;
	
	@OneToMany(mappedBy="singer")	//entidad enlace  	
	private Set<Album> albums;
	
	@OneToMany(cascade=CascadeType.ALL) //si borras un singer se borran sus socialmedia 	
	@JoinColumn(name="id_singer")
	private Set<SingerSocialMedia> singerSocialMedia;
	
	
	public Singer(String name, String avatar) {
		super();
		this.name = name;
		this.avatar = avatar;
	}
	public Singer() { 
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSinger() {
		return idSinger;
	}
	public void setIdSinger(Long idSinger) {
		this.idSinger = idSinger;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Set<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
	public Set<SingerSocialMedia> getSingerSocialMedia() {
		return singerSocialMedia;
	}
	public void setSingerSocialMedia(Set<SingerSocialMedia> singerSocialMedia) {
		this.singerSocialMedia = singerSocialMedia;
	}
	
	

}
