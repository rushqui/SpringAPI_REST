package com.rushqui.musicproject.dao;

import java.util.List;

import com.rushqui.musicproject.model.SingerSocialMedia;
import com.rushqui.musicproject.model.SocialMedia;

public interface SocialMediaDao {

	void saveSocialMedia(SocialMedia socialMedia);
	
	void deleteSocialMedia(Long idSocialMedia);
	
	void updateSocialMedia(SocialMedia socialMedia);
	
	List<SocialMedia> findAllSocialMedias();
	
	SocialMedia findSocialMediaById(Long idSocialMedia);
	
	SocialMedia findSocialMediaByName(String name);
	
	SingerSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);
	
	
}
