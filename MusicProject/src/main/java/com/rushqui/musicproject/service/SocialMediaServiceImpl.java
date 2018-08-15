package com.rushqui.musicproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rushqui.musicproject.dao.SocialMediaDao;
import com.rushqui.musicproject.model.SingerSocialMedia;
import com.rushqui.musicproject.model.SocialMedia;

@Repository("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService {

	@Autowired
	private SocialMediaDao _socialMediaDao;
	
	
	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.saveSocialMedia(socialMedia);
	}

	@Override
	public void deleteSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.deleteSocialMedia(idSocialMedia);
		
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.updateSocialMedia(socialMedia);
	}

	@Override
	public List<SocialMedia> findAllSocialMedias() {
		// TODO Auto-generated method stub
		return _socialMediaDao.findAllSocialMedias();
	}

	@Override
	public SocialMedia findSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findSocialMediaById(idSocialMedia);
	}

	@Override
	public SocialMedia findSocialMediaByName(String name) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findSocialMediaByName(name);
	}

	@Override
	public SingerSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findSocialMediaByIdAndName(idSocialMedia, nickname);
	}

}
