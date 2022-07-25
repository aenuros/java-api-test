package com.example.RestService;
//package bookshop;
//
//import java.util.Date;
//import java.util.Objects;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//class Rating {
//
//  private @Id @GeneratedValue Long id;
//  private String name;
//  private User user;
//  private Book book;
//  private Integer rating;
//  private Date date;
//
//  Rating() {}
//
//  Rating(String name, User user, Book book, Integer rating) {
//    this.name = name;
//    this.user = user;
//    this.book = book;
//    this.rating = rating;
//    this.date = new Date();
//  }
//
//  public Long getId() {
//    return this.id;
//  }
//
//  public String getName() {
//    return this.name;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//
//  @Override
//  public boolean equals(Object o) {
//
//    if (this == o)
//      return true;
//    if (!(o instanceof Rating))
//      return false;
//    Rating book = (Rating) o;
//    return Objects.equals(this.id, book.id) && Objects.equals(this.name, book.name);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(this.id, this.name);
//  }
//
//  @Override
//  public String toString() {
//    return "Book{" + "id=" + this.id + ", name='" + this.name;
//  }
//}