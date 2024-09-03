package com.example.backend.domain;

import jakarta.persistence.*;

@Entity
public class Leagues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leagueId")
    private Long id;

    @Column
    private String leagueName;

    @Column
    private String nation;
}
