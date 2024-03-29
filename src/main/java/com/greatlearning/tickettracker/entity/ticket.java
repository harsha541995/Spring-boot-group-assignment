package com.greatlearning.tickettracker.entity;


import jakarta.persistence.*;
import java.util.Date;



@Entity
@Table(name = "tickets")
public class ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "content")
    private String content;

    
    @Column(name = "date")
    

    private java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
   
    

    public ticket() {


    }


    public ticket(String title, String description, String content ) {
        this.title = title;
        this.description = description;
        this.content = content;
//        this.date = curdate();
        this.date =  new java.sql.Date(System.currentTimeMillis());;

    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

    
	public java.sql.Date getDate() {
		return date;
	}


	public void setDate(java.sql.Date date) {
		this.date = date;
	       
	}

}
