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
//class Comment {
//
//  private @Id @GeneratedValue Long id;
//  private String name;
//  private User user;
//  private Book book;
//  private String review;
//  private Date date;
//
//  Comment() {}
//
//  Comment(String name, User user, Book book, String review) {
//    this.name = name;
//    this.user = user;
//    this.book = book;
//    this.review = review;
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
//    if (!(o instanceof Comment))
//      return false;
//    Comment book = (Comment) o;
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