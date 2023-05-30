package com.neosoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.Ticket;
import com.neosoft.service.TicketServiceImpl;
@RestController
public class TicketController {
   
   @Autowired
	private TicketServiceImpl ticketServiceImpl;
	
	@GetMapping("/tickets")
	public String listteachers(Model model) {
		
		model.addAttribute("tickets",ticketServiceImpl.getAllTickets());
		
		return "tickets";
	}
	
	@GetMapping("/tickets/new")
	public String createteacherForm(Model model) {
		
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		
		return "create_teacher";
	}
	
	@PostMapping("/tickets")
	public String saveteacher(@ModelAttribute("ticket") Ticket ticket) {
		
		ticketServiceImpl.saveTicket(ticket);
		
		return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/edit/{id}")
	public String editteacherForm(@PathVariable Long id, Model model) {
		
		model.addAttribute("ticket",ticketServiceImpl.getTicketById(id));
		
		return "edit_teacher";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateteacher(@PathVariable Long id, 
			@ModelAttribute("ticket") Ticket ticket,	Model model) {
		
		Ticket ticketModel = ticketServiceImpl.getTicketById(id);
		ticketModel.setTicketId(id);
		ticketModel.setTitle(ticket.getTitle());
		ticketServiceImpl.updateTicket(ticketModel);
		
		return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/{id}")
	public String deleteteacher(@PathVariable Long id) {
		
		ticketServiceImpl.deleteTicketById(id);
		
		return "redirect:/tickets";
	}	
}