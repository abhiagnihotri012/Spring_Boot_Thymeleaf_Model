package com.neosoft.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ticket {
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Id
   private long ticketId;
   private String title;
   public long getBlogId() {
       return ticketId;
   }
   public String getTitle() {
       return title;
   }
   public void setTicketId(long id) {
       this.ticketId = id;
   }
   public void setTitle(String title) {
       this.title = title;
   }
}