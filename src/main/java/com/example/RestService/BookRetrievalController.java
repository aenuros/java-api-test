package com.example.RestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookRetrievalController {
	
	public String string = "";
	
	@GetMapping("/books/all")
	@ResponseBody
	public String allBooks() {
		string ="All Books:<br>" + new BookRetrievalFeature("SELECT * FROM book").returnData;
		return string;
	}
	
	
	@GetMapping("/books/genre/{genre}")
	@ResponseBody
	public String booksByGenre(@PathVariable String genre){
		string = "All " + genre + " Books:<br>"
				+ new BookRetrievalFeature("SELECT * FROM book WHERE genre = \"" + genre + "\"").returnData;
		return string;
	}
	
	
	@GetMapping("/books/mostsold")
	public String booksByGenre(){
		string = "Top 10 Most Sold Books:<br>"
				+ new BookRetrievalFeature("SELECT * FROM book ORDER BY copies_sold DESC LIMIT 10").returnData;
		return string;	
	}
	
	@GetMapping("/books/custom/{chunkSize}/{chunkNum}")
	public String booksByCustom(@PathVariable int chunkSize, @PathVariable int chunkNum){
		string = "Page " + chunkNum + " - Displaying " + chunkSize + " Entries:<br><br>" +
				new BookRetrievalFeature("SELECT * FROM book LIMIT "
				+ ((chunkNum*chunkSize) - chunkSize) + ", " + chunkSize).returnData;
		
		return string;
	}	
}
