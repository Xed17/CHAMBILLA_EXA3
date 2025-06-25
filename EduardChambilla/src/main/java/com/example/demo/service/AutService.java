package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Aut;

public interface AutService {
	public int create(Aut aut);
    public int update(Aut aut);
    public int delete(int id);
    public Aut read(int id);
    public List<Aut> readAll();
}
