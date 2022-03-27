package com.sillycat.mvclatency.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LevelDBServiceImpl implements LevelDBService{
	
	private DB db;

	@Value("${leveldb.dir.path}")
	private String DB_DIR_PATH;

	private static final String CHARSET = "utf-8";

	// spring init at start
	@PostConstruct
	public void initLevelDB() {
		DBFactory factory = new Iq80DBFactory();
		Options options = new Options();
		options.cacheSize(100 * 1024 * 1024); // 100MB cache
		options.createIfMissing(true);
		options.logger(System.out::println); // print logging
		try {
			this.db = factory.open(new File(DB_DIR_PATH), options);
		} catch (IOException e) {
			log.error("levelDB factory open exception:", e);
		}
	}

	// JSON to byte
	private byte[] serializer(Object obj) {
		return JSON.toJSONBytes(obj, SerializerFeature.DisableCircularReferenceDetect);
	}

	/**
	 * save data
	 * 
	 * @param key 
	 * @param value
	 */
	public void put(String key, Object val) {
		try {
			this.db.put(key.getBytes(CHARSET), this.serializer(val));
		} catch (UnsupportedEncodingException e) {
			log.error("serializer exception", e);
		}
	}

	/**
	 * get value by key
	 * 
	 * @param key
	 * @return value
	 */
	public Object get(String key) {
		byte[] val = null;
		try {
			val = db.get(key.getBytes(CHARSET));
		} catch (Exception e) {
			log.error("levelDB get error", e);
		}
		if (val != null)
			return JSON.parse(val);
		else
			return null;
	}

	/**
	 * get data object
	 * 
	 * @param key   key
	 * @param clazz class
	 * @param <T>   T
	 * @return value
	 */
	public <T> T get(String key, Class<?> clazz) {
		byte[] val = null;
		try {
			val = db.get(key.getBytes(CHARSET));
		} catch (Exception e) {
			log.error("levelDB get error", e);
		}
		if (val != null) {
			return JSON.parseObject(val, clazz);
		}
		else {
			return null;
		}
	}

	/**
	 * delete data by key
	 * 
	 * @param key 
	 */
	public void delete(String key) {
		try {
			db.delete(key.getBytes(CHARSET));
		} catch (Exception e) {
			log.error("levelDB delete error", e);
		}

	}

	/**
	 * scan key
	 * 
	 * @return all keys
	 */
	public List<String> getKeys() {

		List<String> list = new ArrayList<>();
		DBIterator iterator = null;
		try {
			iterator = db.iterator();
			while (iterator.hasNext()) {
				Map.Entry<byte[], byte[]> item = iterator.next();
				String key = new String(item.getKey(), CHARSET);
				list.add(key);
			}
		} catch (Exception e) {
			log.error("scan exception: ", e);
		} finally {
			if (iterator != null) {
				try {
					iterator.close();
				} catch (IOException e) {
					log.error("scan exception: ", e);
				}

			}
		}
		return list;
	}

	// spring destroy resources
	@PreDestroy
	public void closeDB() {
		if (db != null) {
			try {
				db.close();
			} catch (IOException e) {
				log.error("levelDB close exception: ", e);
			}
		}
	}
}
