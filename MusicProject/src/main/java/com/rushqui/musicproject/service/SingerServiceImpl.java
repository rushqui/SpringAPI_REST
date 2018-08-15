package com.rushqui.musicproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rushqui.musicproject.dao.SingerDao;
import com.rushqui.musicproject.model.Singer;

@Repository("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerDao _singerDao;
	
	@Override
	public void saveSinger(Singer singer) {
		// TODO Auto-generated method stub
		_singerDao.saveSinger(singer);
	}

	@Override
	public void deleteSingerById(Long idSinger) {
		// TODO Auto-generated method stub
		_singerDao.deleteSingerById(idSinger);
	}

	@Override
	public void updateSinger(Singer singer) {
		// TODO Auto-generated method stub
		_singerDao.updateSinger(singer);
	}

	@Override
	public List<Singer> findAllSingers() {
		// TODO Auto-generated method stub
		return _singerDao.findAllSingers();
	}

	@Override
	public Singer findSingerById(Long idSinger) {
		// TODO Auto-generated method stub
		return _singerDao.findSingerById(idSinger);
	}

	@Override
	public Singer findSingerByName(String name) {
		// TODO Auto-generated method stub
		return _singerDao.findSingerByName(name);
	}

}
