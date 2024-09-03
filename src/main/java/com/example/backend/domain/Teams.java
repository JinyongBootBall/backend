package com.example.backend.domain;

import jakarta.persistence.*;

@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    private Long id;

    @JoinColumn(name = "leagueId")
    @ManyToOne
    private Leagues leagues;

    @Column
    private String teamName;

    @Column
    private String emblemImage;
}
