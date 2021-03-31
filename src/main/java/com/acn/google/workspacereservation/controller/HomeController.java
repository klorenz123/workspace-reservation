package com.acn.google.workspacereservation.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acn.google.workspacereservation.entity.Accounts;
import com.acn.google.workspacereservation.entity.Rooms;
import com.acn.google.workspacereservation.service.AccountService;
import com.acn.google.workspacereservation.service.RoomService;


@Controller
@RequestMapping("/index")
public class HomeController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoomService roomService;


	@GetMapping("")
	public String registration() {
		return "index";
	}


	@GetMapping("/showFormforReg")
	public String showFormforReg(Model model) {
		//create model to bind form data
		Accounts accounts = new Accounts();
		model.addAttribute("clients", accounts);
		return "guest-register";
	}

	@GetMapping("/back")
	public String backToIndex() {
		return "index";
	}


	@PostMapping("/save")
	public String saveClients(@ModelAttribute("clients") Accounts accounts) {
		if(!accountService.findByEmail(accounts.getEmail())) {
			accountService.save(accounts);	
			return"redirect:/index/showFormforLogin";
		}
		return "redirect:/index/showFormforReg?error";
	}

	@GetMapping("/showFormforLogin")
	public String showFormforLogin(Model model) {
		//create model to bind form data
		Accounts accounts = new Accounts();
		model.addAttribute("clients", accounts);
		return "login";
	}

	@PostMapping("/request")
	public String requestToLog(@ModelAttribute("clients") Accounts accounts) {
		if(accountService.findByEmail(accounts.getEmail())) {
			Accounts acc = new Accounts();
			acc=accountService.getByEmail(accounts.getEmail());
			if(acc.getEmail().equals(accounts.getEmail()) 
					&& acc.getPassword().equals(accounts.getPassword())) {
				return"redirect:/index";
			}else {

				return "redirect:/index/showFormforLogin?error";
			}
		}

		return "redirect:/index/showFormforLogin?notFound";



	}


	@GetMapping("/reservation")
	public String reservationView(Model model) {
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("\"EEE, MMM dd, ''yyyy\"");
		model.addAttribute("dateNow", today.format(dateFormat));
		return "reservation";
	}

	@GetMapping("/reserved-rooms")
	public String reservedRoomsView(Model model) {
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("\"EEE, MMM dd, ''yyyy\"");

		model.addAttribute("dateNow", today.format(dateFormat));
		return "reserved-rooms";
	}

	@GetMapping("/rooms")
	public String roomsView(Model model) {
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("\"EEE, MMM dd, ''yyyy\"");
		model.addAttribute("dateNow", today.format(dateFormat));
		List<Rooms> theAccounts = roomService.findAll();
		model.addAttribute("accounts", theAccounts);
		return "rooms";
	}

	@GetMapping("/accounts")
	public String accountsView(Model model) {
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("\"EEE, MMM dd, ''yyyy\"");

		model.addAttribute("dateNow", today.format(dateFormat));
		List<Accounts> theAccounts = accountService.findAll();
		model.addAttribute("accounts", theAccounts);

		return "list-accounts";
	}

}
