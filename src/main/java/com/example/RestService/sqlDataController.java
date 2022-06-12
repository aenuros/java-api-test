package com.example.RestService;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sqlDataController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/books")
	public String allBooks(@RequestParam(value = "query", defaultValue = "SELECT * FROM book") String query) {
		return new sqlData(query).returnData;
	}
	
	@GetMapping("/books/bygenre")
	public String booksByGenre(@RequestParam(value = "genre") String genre){
		return new sqlData("SELECT * FROM book WHERE genre = \"" + genre + "\"").returnData;
	}
	
	
	@GetMapping("/books/bymostsold")
	public String booksByGenre(){
		return new sqlData("SELECT * FROM book ORDER BY copies_sold LIMIT 10").returnData;
	}
	
	@GetMapping("/books/custom")
	public String booksByCustom(@RequestParam(value = "from", defaultValue = "0")String from){
		return new sqlData("SELECT * FROM book ORDER BY copies_sold LIMIT " + from + ", 23").returnData;
	}	
}

