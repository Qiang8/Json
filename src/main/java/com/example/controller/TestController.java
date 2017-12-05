package com.example.controller;




import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domian.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/TestController")
public class TestController {
	
	@Autowired
	private ObjectMapper objm;
	
	@RequestMapping("/begin")
	public String begin() {
		return "index";
	}
	
	//接收前台 json数据转为entity
	@RequestMapping("/get")
	@ResponseBody
	public String get(String json) {
		Person person=new Person();
		try {
			person = objm.readValue(json, Person.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(person);
		return "success";
	}
	
	//entity以json返回到 前台
	@RequestMapping("/get1")
	@ResponseBody
	public void get1(HttpServletResponse resp) throws IOException {
		Person p1=new Person("p11","1");
		Person p2=new Person("p22","2");
		Person p3=new Person("p33","3");
		Person p4=new Person("p44","4");
		List<Person> pList = Arrays.asList(p1,p2,p3,p4);
		resp.getWriter().println(pList);
	}
	
	

}
