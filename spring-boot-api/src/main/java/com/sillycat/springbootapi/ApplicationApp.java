package com.sillycat.springbootapi;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;

public class ApplicationApp {

	public static void main(String[] args) {
		System.out.println("Verify the consul library----------");

		Consul client = Consul.builder().build();
		KeyValueClient kvClient = client.keyValueClient();

		String value = kvClient.getValueAsString("epj.config").get();
		System.out.println(value);

		Gson gson = new GsonBuilder().create();
		HashMap<String, Object> fields = gson.fromJson(value, HashMap.class);
		fields.get("name");

	}

}
