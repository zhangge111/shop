package com.zg.beans;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/*
* @author gez
* @version 0.1
*/

public class JsonJavaTransformerImpl implements JsonJavaTransformer {

	@Override
	public <T> List<T> json2JavaList(String jsons, Class<T> clazz) {
        JSONArray jsonArray=(JSONArray)JSONSerializer.toJSON(jsons);
        JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(clazz);
		return (List<T>) JSONSerializer.toJava(jsonArray, jsonConfig);
	}

	@Override
	public <T> String javaList2json(List<T> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	@Override
	public <T> T json2Java(String json, Class<T> clazz) {
		JsonConfig jsonConfig = new JsonConfig();
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(clazz);
		jsonConfig.setRootClass(TenpayConfig.class);
		return (T) JSONSerializer.toJava(jsonObject, jsonConfig);
	}

	@Override
	public <T> String java2json(T obj) {
		JSONObject jsonObject = JSONObject.fromObject(obj);
		return jsonObject.toString();
	}

}
