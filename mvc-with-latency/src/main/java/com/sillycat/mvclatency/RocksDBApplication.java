package com.sillycat.mvclatency;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.RocksIterator;

public class RocksDBApplication {
	
	private static RocksDB rocksDB;
	
	private static final String DB_PATH = "/opt/rocksdb/db1";

	public static void main(String[] args) {
		System.out.println("RocksDB testing init---------------");
		RocksDB.loadLibrary();
		Options options = new Options();
		options.setCreateIfMissing(true);
		try {
			rocksDB = RocksDB.open(options, DB_PATH);
			System.out.println("RocksDB testing put " + "demo_key1");
			rocksDB.put("demo_key1".getBytes(), "demo_value1".getBytes());
			
			System.out.println("RocksDB testing get " + "demo_key1");
			byte[] byteValue1 = rocksDB.get("demo_key1".getBytes());
			System.out.println(new String(byteValue1));
			
			System.out.println("RocksDB testing scan ");
			RocksIterator iter = rocksDB.newIterator();
			for (iter.seekToFirst(); iter.isValid(); iter.next()) {
				String key = new String(iter.key());
				String value = new String(iter.value());
				System.out.println("key=" + key + " value=" + value);
			}
		} catch (RocksDBException e) {
			e.printStackTrace();
		}
	}

}
