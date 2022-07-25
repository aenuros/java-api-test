package com.example.RestService.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Entity
@Transactional
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    private String email;
    private String password;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid")
    private Address address;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "cc_id", referencedColumnName = "id")
    private List<Card> cards;
}
