package com.example.RestService;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
class Book {

  private @Id @GeneratedValue Long id;
  private String name;
  private String genre;
  private Integer copiesSold;
  private BigDecimal price;

  Book() {}

  Book(String name, String genre, Integer copiesSold, BigDecimal price) {

    this.name = name;
    this.genre = genre;
    this.copiesSold = copiesSold;
    this.price = price;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getGenre() {
	  return this.genre;
  }
  
  public void setGenre(String genre) {
	  this.genre = genre;
  }
  
  public Integer getCopiesSold() {
	  return this.copiesSold;
  }
  
  public void setCopiesSold(Integer copiesSold) {
	  this.copiesSold = copiesSold;
  }
  
  public BigDecimal getPrice() {
	  return this.price;
  }
  
  public void setPrice(BigDecimal price) {
	  this.price = price;
  }
  


//  @Override
//  public boolean equals(Object o) {
//
//    if (this == o)
//      return true;
//    if (!(o instanceof User))
//      return false;
//    User book = (User) o;
//    return Objects.equals(this.id, book.id) && Objects.equals(this.name, book.name);
//  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Book{" + "id=" + this.id + ", name='" + this.name + ", genre =" + this.genre;
  }
}