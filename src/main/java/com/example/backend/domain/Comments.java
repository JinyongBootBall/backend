package com.example.backend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Articles")
    private Articles articles;

    @Column
    private String content;

    @Column
    private Date createAt;

    @Column
    private Date updateAt;

    @Column
    private Boolean isDelete = Boolean.FALSE;
}
