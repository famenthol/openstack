package com.it.demo.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.demo.demo.dao.TokenDao;
import com.it.demo.demo.vo.TokenVO;

@RestController
@RequestMapping("/helloworld")
public class HelloController {
	
	@Autowired
	private TokenDao tokenDao;
	
	@GetMapping(value="/fan", produces="application/json")
	public Map<String, String> helloWorld() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello world", "fk");
		map.put("com.df", "abcdefg");
		return map;
	} 
	
	@GetMapping(value="/token", produces="application/json")
	public List<TokenVO> findList() {
		return tokenDao.findTokenVO();
	}
	
	@PostMapping(value="/save", produces="application/json")
	public String save(@RequestBody TokenVO token) {
		tokenDao.save(token);
		return null;
	}
	
	@GetMapping(value="/export", produces="application/json")
	public void exportRe() throws IOException{
		//Create Blank workbook
		   XSSFWorkbook workbook = new XSSFWorkbook(); 
	      //Create file system using specific name
	      FileOutputStream out = new FileOutputStream(
	      new File("createworkbook.xlsx"));
	      //write operation workbook using file out object 
	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
	}
	
}
