package com.example.demo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AutDao;
import com.example.demo.entity.Aut;

@Component
public class AutDaoImpl implements AutDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(Aut aut) {
		String SQL="insert into autores (nombres, apellidos, pais, estado) values(?,?,?,?)";
        return jdbcTemplate.update(SQL,new Object[]{aut.getNombres(),aut.getApellidos(),aut.getPais(),aut.getEstado()});
	}

	@Override
	public int update(Aut aut) {
		String SQL="update autores set nombres=?, apellidos=?, pais=?, estado=? where id=?";
        return jdbcTemplate.update(SQL,new Object[]{aut.getNombres(),aut.getApellidos(),aut.getPais(),aut.getEstado(),aut.getId()});
	}

	@Override
	public int delete(int id) {
		String SQL="delete from autores where id=?";
        return jdbcTemplate.update(SQL,new Object[]{id});
	}

	@Override
	public Aut read(int id) {
		String SQL="select * from autores where id=?";
        Aut aut = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Aut.class), id);
        return aut;
	}

	@Override
	public List<Aut> readAll() {
		String SQL="select *from autores";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Aut.class));
	}

}
