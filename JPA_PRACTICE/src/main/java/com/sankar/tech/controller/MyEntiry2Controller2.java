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
import com.sankar.tech.entity.MyEntity2;
import com.sankar.tech.repository.MyEntiry1Repository;


@RestController
public class MyEntiry2Controller2 {
	
	@Autowired
	private MyEntiry2Repository myEntiry2Repository;
	
	@PostMapping("/myentity2")
	public MyEntity2 save(@RequestBody MyEntity2 myEntity2)
	{
		return myEntiry2Repository.save(myEntity2);
	}
	
	@GetMapping("/myentity2")
	public List<MyEntity2> findAll()
	{
		return myEntiry2Repository.findAll();
	}
	
	@DeleteMapping("/myentity2/{id}")
	public Map<String, String> deleteById(@PathVariable(name = "id") Integer id)
	{
		 myEntiry2Repository.deleteById(id);
		 Map<String, String> map = new HashMap<>();
		 map.put("ID : "+id, "Deleted !!");
		 return map;
	}
	
	@DeleteMapping("/myentity2")
	public Map<String, String> deleteAll()
	{
		myEntiry2Repository.deleteAll();
		Map<String, String> map = new HashMap<>();
		map.put("deleteAll", "Deleted !!");
		return map;
	}

}
