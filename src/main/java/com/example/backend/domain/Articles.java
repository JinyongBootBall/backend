package com.example.backend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Teams")
    private Teams teams;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String teamName;

    @Column
    private Date createAt;

    @Column
    private Date updateAt;

    @Column
    private Boolean isDelete = Boolean.FALSE;
}
