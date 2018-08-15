package com.rushqui.musicproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rushqui.musicproject.model.SingerSocialMedia;
import com.rushqui.musicproject.model.SocialMedia;


@Repository	
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().persist(socialMedia);
		
	}

	@Override
	public void deleteSocialMedia(Long idSocialMedia) {
		// TODO Auto-generated method stub
		SocialMedia socialmedia = findSocialMediaById(idSocialMedia);
		if(socialmedia != null) {
			getSession().delete(socialmedia);
		}
		
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);
	}

	@Override
	public List<SocialMedia> findAllSocialMedias() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);  
	}

	@Override
	public SocialMedia findSocialMediaByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery(
				"from SocialMedia where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public SingerSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		List<Object[]> objects = getSession().createQuery(
				"from SingerSocialMedia ssm join ssm.socialMedia sm "
				+ "where sm.idSocialMedia = :idSocialMedia and ssm.nickname= :nickname")
				.setParameter("idSocialMedia", idSocialMedia)
				.setParameter("nickname", nickname).list();
		if (objects.size() > 0) {
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if (object instanceof SingerSocialMedia) {
							return (SingerSocialMedia) object;
					}
					
				}
			}
		}
		
		return null;
	}

}
