package com.capgemini.chess.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.mapper.UserMapper;
import com.capgemini.chess.service.access.UserDao;
import com.capgemini.chess.service.to.UserTo;

@Repository
public class MapUserDao implements UserDao {
	private final Map<Long, UserEntity> users = new HashMap<>();

	@Override
	public UserTo save(UserTo to) {
		UserEntity user = UserMapper.map(to);
		Long id = generateId();
		to.setId(id);
		users.put(id, user);
		return UserMapper.map(user);
	}

	@Override
	public UserTo findByEmail(String email) {
		UserEntity user = users.values().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
		return UserMapper.map(user);
	}

	private Long generateId() {
		return users.keySet().stream().max((i1, i2) -> i1.compareTo(i2)).orElse(0L) + 1;
	}
}