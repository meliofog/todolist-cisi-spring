package com.example.todov1.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private boolean iscompleted;



    public Tasks(){
        this.iscompleted =false;

    }

    public Tasks(long id, String name, boolean iscompleted,String description) {
        this.id = id;
        this.name = name;
        this.iscompleted = iscompleted;
        this.description = description;
    }

    public Tasks(String name, boolean iscompleted,String description) {
        this.name = name;
        this.iscompleted = iscompleted;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }
    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}



}

