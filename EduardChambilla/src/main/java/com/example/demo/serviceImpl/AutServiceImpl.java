package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AutDao;
import com.example.demo.entity.Aut;
import com.example.demo.service.AutService;

@Service
public class AutServiceImpl implements AutService{
	@Autowired
    private AutDao dao;
	
	@Override
	public int create(Aut aut) {
		return dao.create(aut);
	}

	@Override
	public int update(Aut aut) {
		return dao.update(aut);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public Aut read(int id) {
		return dao.read(id);
	}

	@Override
	public List<Aut> readAll() {
		return dao.readAll();
	}

}
