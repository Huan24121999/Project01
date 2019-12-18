package com.soict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.soict.entities.Benh;
import com.soict.entities.TrieuChung;
import com.soict.service.TrieuChungService;

import javassist.expr.NewArray;
import net.bytebuddy.asm.Advice.This;

@Controller
public class TrieuChungController {
	
	@Autowired
	private TrieuChungService trieuChungService;
	
	@GetMapping("/quanLyTC")
	public String quanLyTrieuChung(Model model) {
		model.addAttribute("trieuchungs",this.trieuChungService.findAll());
		model.addAttribute("trieuchung", new TrieuChung());
		return "quanlytrieuchung";
	}
	@GetMapping("/quanLyTCUser")
	public String quanLyTrieuChungUser(Model model) {
		model.addAttribute("trieuchungs",this.trieuChungService.findAll());
		model.addAttribute("trieuchung", new TrieuChung());
		return "quanlytrieuchungUser";
	}
	
	
	@PostMapping("/quanLyTC")
	public String quanLyTC(Model model,@ModelAttribute("trieuchung") TrieuChung trieuChung) {
		this.trieuChungService.save(trieuChung);
		model.addAttribute("trieuchungs",this.trieuChungService.findAll());
		model.addAttribute("trieuchung", new TrieuChung());
		return "quanlytrieuchung";
	}
	
	@PostMapping("/quanLyTCUser")
	public String quanLyTCUser(Model model,@ModelAttribute("trieuchung") TrieuChung trieuChung) {
		this.trieuChungService.save(trieuChung);
		model.addAttribute("trieuchungs",this.trieuChungService.findAll());
		model.addAttribute("trieuchung", new TrieuChung());
		return "quanlytrieuchungUser";
	}
	
	@GetMapping("/quanLyTC/{id}/view")
    public String viewBenh(@PathVariable("id") String id, Model model) {
		TrieuChung tc=this.trieuChungService.findByIdTC(id);
	    model.addAttribute("trieuchung",tc);
        return "suaTC";
    }
	@GetMapping("/quanLyTC/{id}/edit")
    public String editBenh(@PathVariable("id") String id, Model model) {
		TrieuChung tc=this.trieuChungService.findByIdTC(id);
	    model.addAttribute("trieuchung",tc);
        return "suaTC";
    }
	@GetMapping("/quanLyTC/{id}/delete")
    public String deleteBenh(@PathVariable("id") String id, Model model) {
		
        return "errorpage";
    }


}
