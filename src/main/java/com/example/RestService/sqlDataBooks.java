//package com.example.RestService;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class sqlDataBooks {
//	
//	private final AtomicLong counter = new AtomicLong();
//	
////	@GetMapping("/books")
////	public String allBooks(@RequestParam(value = "query", defaultValue = "SELECT * FROM book") String query) {
////		return new sqlData(query).returnData;
////	}
//	
//	@GetMapping("/books/bygenre")
//	public String booksByGenre(@RequestParam(value = "genre") String genre){
//		return new sqlData("SELECT * FROM book WHERE genre = \"" + genre + "\"").returnData;
//	}
//	
//	
//	@GetMapping("/books/bymostsold")
//	public String booksByGenre(){
//		return new sqlData("SELECT * FROM book ORDER BY copies_sold LIMIT 10").returnData;
//	}
//	
//	// Must be able to retrieve a list of ratings and comments, sorted by highest rating
//	@GetMapping("/books/rating")
//	public String booksByRating(){
//		return new sqlDataGetBookByRating("SELECT bookshop.rating.stars,\n"
//				+ "bookshop.rating.comment,\n"
//				+ "bookshop.book.Name,\n"
//				+ "bookshop.user.username,\n"
//				+ "bookshop.rating.datetime\n"
//				+ "FROM bookshop.rating\n"
//				+ "JOIN bookshop.book ON bookshop.rating.book_id = bookshop.book.book_id\n"
//				+ "JOIN bookshop.user ON bookshop.rating.user_id = bookshop.user.user_id\n"
//				+ "ORDER BY bookshop.rating.stars DESC;\n"
//				+ "\n"
//				+ "").returnData;
//	}
//	
//	@GetMapping("/books/avgrating")
//	public String booksByAverageRating(@RequestParam(value = "id") String id) {
//		return new sqlDataGetBookByAverageRating("SELECT bookshop.rating.stars,\n"
//				+ "bookshop.rating.comment,\n"
//				+ "bookshop.book.Name, \n"
//				+ "bookshop.user.username,\n"
//				+ "bookshop.rating.datetime\n"
//				+ "FROM bookshop.rating\n"
//				+ "JOIN bookshop.book ON bookshop.rating.book_id = bookshop.book.book_id\n"
//				+ "JOIN bookshop.user ON bookshop.rating.user_id = bookshop.user.user_id\n"
//				+ "WHERE bookshop.rating.book_id = " + id + "\n"
//				+ "ORDER BY bookshop.rating.stars DESC;").returnData;
//	}
//
//	
//	@RequestMapping("/books/newrating")
//	public String newRating(@RequestParam(value = "stars") int stars,
//			@RequestParam(value="book_id") int book_id,
//			@RequestParam(value="user_id") int user_id,
//			@RequestParam(value="comment") String comment
//			){
////		return new sqlData("SELECT * FROM book WHERE genre = \"" + genre + "\"").returnData;
//		return new sqlDataInsertRating("INSERT INTO bookshop.rating (stars, book_id, user_id, comment) \n"
//		  		+ "VALUES ('" + 1 + "', '" + 10 + "', '" + 4 + "', '" + comment + "');").returnData;
//	}
//	
//	
//
//	
//}
//
