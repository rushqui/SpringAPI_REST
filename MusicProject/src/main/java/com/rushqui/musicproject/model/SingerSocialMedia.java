package com.rushqui.musicproject.model;

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
@Table(name="singer_social_media")
public class SingerSocialMedia implements Serializable {
	
	@Id	
	@Column(name="id_singer_socialmedia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSingerSocialMedia;
	
	@Column(name="nickname")
	private String nickname;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_singer")
	private Singer singer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_socialmedia")
	private SocialMedia socialMedia;
	
	
	
	public SingerSocialMedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public SingerSocialMedia(Singer singer, SocialMedia socialMedia, String nickname) {
		super();
		this.singer = singer;
		this.socialMedia = socialMedia;
		this.nickname=nickname;
	}


	public Long getIdSingerSocialMedia() {
		return idSingerSocialMedia;
	}
	public void setIdSingerSocialMedia(Long idSingerSocialMedia) {
		this.idSingerSocialMedia = idSingerSocialMedia;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	public SocialMedia getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}
	
	
}