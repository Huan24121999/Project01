package com.soict.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soict.entities.Benh;
import com.soict.entities.BenhNhan;
import com.soict.service.BenhService;
import com.soict.service_impl.BenhService_impl;

import javassist.expr.NewArray;
import net.bytebuddy.asm.Advice.This;

@Controller
public class BenhController {
	@Autowired
	private BenhService benhService;

	@GetMapping("/showBenh")
	public String showBenh(Model model) {
		Benh benh=new Benh();
		model.addAttribute("benh",benh);
		return "form";
	}
	
//	@GetMapping("/")
//	public String home(Model model) {
//		model.addAttribute("benhs", this.benhService.findAll());
//		return "index";
//	}
	
	@PostMapping("/showBenh")
	public String showBenhPost(Model model,@Valid Benh benh,BindingResult result ) {
		 if (result.hasErrors()) {
		      return "form";
		  }
		 this.benhService.save(benh);
		 model.addAttribute("benhs", this.benhService.findAll());
		 return "home";
		
	}
	@GetMapping("/quanLyBenh")
	public String quanLyBenh(Model model) {
		model.addAttribute("benhs", this.benhService.findAll());
		model.addAttribute("benh",new Benh());
		return "quanLyBenh";
	}
	@GetMapping("/quanLyBenhUser")
	public String quanLyBenhUser(Model model) {
		model.addAttribute("benhs", this.benhService.findAll());
		model.addAttribute("benh",new Benh());
		return "quanLyBenhUser";
	}
	
	
	
	@PostMapping("/quanLyBenhUser")
	public String themBenh(Model model,@ModelAttribute("benh") Benh benh) {
		System.out.println("mã: "+benh.getIdBenh()+" "+benh.getTenBenh());
		this.benhService.save(benh);
		model.addAttribute("benhs", this.benhService.findAll());
		model.addAttribute("benh",new Benh());
		return "quanLyBenhUser";
	}
	
	@GetMapping("/quanLyBenh/{id}/view")
    public String viewBenh(@PathVariable("id") String id, Model model) {
		Benh benh=this.benhService.findByIdBenh(id);
		  
	       model.addAttribute("benh",benh);
        return "suaBenh";
		
    }
	@GetMapping("/quanLyBenh/{id}/edit")
    public String editBenh(@PathVariable("id") String id, Model model) {
		Benh benh=this.benhService.findByIdBenh(id);
		
       model.addAttribute("benh",benh);
       return "suaBenh";// gửi dữ liệu để e dit
		
    }
	@GetMapping("/quanLyBenh/{id}/delete")
    public String deleteBenh(@PathVariable("id") String id, Model model) {
		model.addAttribute("mess", "Trang này đang được bảo trì");
       return "errorpage";
		
    }
	@GetMapping("/home")
	public String home() {
		return "admindemo";
	}
	
		
	

}
