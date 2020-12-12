package com.sankar.tech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.tech.entity.MyEntity1;
import com.sankar.tech.repository.MyEntiry1Repository;


@RestController
public class MyEntiry1Controller {
	
	@Autowired
	private MyEntiry1Repository myEntiry1Repository;
	
	@PostMapping("/myentity1")
	public MyEntity1 save(@RequestBody MyEntity1 myEntity1)
	{
		return myEntiry1Repository.save(myEntity1);
	}
	
	@GetMapping("/myentity1")
	public List<MyEntity1> findAll()
	{
		return myEntiry1Repository.findAll();
	}
	
	@DeleteMapping("/myentity1/{id}")
	public Map<String, String> deleteById(@PathVariable(name = "id") Integer id)
	{
		 myEntiry1Repository.deleteById(id);
		 Map<String, String> map = new HashMap<>();
		 map.put("ID : "+id, "Deleted !!");
		 return map;
	}
	
	@DeleteMapping("/myentity1")
	public Map<String, String> deleteAll()
	{
		myEntiry1Repository.deleteAll();
		Map<String, String> map = new HashMap<>();
		map.put("deleteAll", "Deleted !!");
		return map;
	}
	
	

}
