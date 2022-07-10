package bookshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class sqlDataController {
	
	private String string = "";
	
	@GetMapping("/books/all")
	@ResponseBody
	public String allBooks() {
		string ="All Books:<br>" + new sqlBookData("SELECT * FROM book").returnData;
		return string;
	}
	
	
	@GetMapping("/books/genre/{genre}")
	@ResponseBody
	public String booksByGenre(@PathVariable String genre){
		string = "All " + genre + " Books:<br>"
				+ new sqlBookData("SELECT * FROM book WHERE genre = \"" + genre + "\"").returnData;
		return string;
	}
	
	
	@GetMapping("/books/mostsold")
	public String booksByGenre(){
		string ="Top 10 Most Sold Books:<br>"
				+ new sqlBookData("SELECT * FROM book ORDER BY copies_sold DESC LIMIT 10").returnData;
		return string;	
	}
	
//	@GetMapping("/books/custom")
//	public String booksByCustom(@RequestParam(value = "from", defaultValue = "0")String from){
//		return new sqlBookData("SELECT * FROM BooksData ORDER BY copies_sold LIMIT " + from + ", 23").returnData;
//	}	
}
