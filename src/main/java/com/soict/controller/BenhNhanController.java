package com.soict.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.soict.entities.BenhNhan;
import com.soict.entities.User;
import com.soict.service.BenhNhanService;

import net.bytebuddy.asm.Advice.This;

@Controller
public class BenhNhanController {
	
	@Autowired
	private BenhNhanService benhNhanService;

	@GetMapping("/createAccout")
	public String createAccount(Model model) {
		BenhNhan benhNhan=new BenhNhan();
		model.addAttribute("benhNhan",benhNhan);
		System.out.println("mã bệnh nhân là: "+benhNhan.getIdBN());
		return "userCreateAccount";
	}
	
	@PostMapping("/createAccout")
	public String createAccount(Model model,@Valid BenhNhan benhNhan,BindingResult result) {
		System.out.println("đã gửi post");
		if(result.hasErrors()) {
			model.addAttribute("error", "Có lỗi xảy ra, quý khách vui lòng gửi lại thông tin.");
			return "userCreateAccount";
		}
		else {
			this.benhNhanService.save(benhNhan);
			User user=new User();
			model.addAttribute("user",user);
			
;			return "signup";
		}
		
	}
	
	@GetMapping("/quanLyBenhNhan")
	public String quanLyBenhNhan(Model model) {
		model.addAttribute("benhNhans",this.benhNhanService.findAll());
		
		return "listBenhNhan";
	}
	
	@GetMapping("/contact/{id}/view")
    public String edit(@PathVariable("id") String id, Model model) {
       model.addAttribute("benhNhan",this.benhNhanService.findById(id));
       return "contact";
		
    }
	
	@GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable("id") String id, Model model) {
       
       return "errorpage";
		
    }
	
	
	@GetMapping("/contact/{id}/sendMessage")
    public String sendMessage(@PathVariable("id") String id, Model model) {
		BenhNhan benhNhan=this.benhNhanService.findById(id);
		System.out.println("mã bd: "+benhNhan.getIdBN());
       model.addAttribute("benhNhan",benhNhan);
       return "sendMessage";
		
    }
	
	@PostMapping(value = "/sendMessageAdmin",consumes = "application/x-www-form-urlencoded")
    public String sendMessage(Model model,@RequestBody(required = false) BenhNhan benhNhan,BindingResult result) {
		System.out.println("mã "+benhNhan.getIdBN());
		if(result.hasErrors()) {
			model.addAttribute("error","Có lỗi, vui lòng kiểm tra lại");
			model.addAttribute("benhNhan",benhNhan);
			return "sendMessage";
		}
		else {
			System.out.println(benhNhan.getIdBN());
			this.benhNhanService.save(benhNhan);
			return "admindemo";
		}
		
    }

}
