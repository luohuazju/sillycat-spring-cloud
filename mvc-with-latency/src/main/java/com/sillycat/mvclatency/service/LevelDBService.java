package com.sillycat.mvclatency.service;

public interface LevelDBService {

	public void put(String key, Object val);

	
	public <T> T get(String key, Class<?> clazz);
}
