package com.qa.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil() {	//constructor
		this.gson = new Gson();
	}
	
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
		//transform it to json
	}
	
	//generic means it can work on any types of object
	//convert objects to work on any type of class
	//to work and return objects generically
	//"convert JSON string to an object"
	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
}
