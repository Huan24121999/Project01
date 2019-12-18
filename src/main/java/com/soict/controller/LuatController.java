package com.soict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.soict.entities.Benh;
import com.soict.entities.Luat;
import com.soict.entities.TrieuChung;
import com.soict.service.BenhService;
import com.soict.service.LuatService;
import com.soict.service.TrieuChungService;

@Controller
public class LuatController {
	@Autowired
	private LuatService luatService;
	@Autowired
	private BenhService benhService;
	@Autowired
	private TrieuChungService trieuChungService;
	
	@GetMapping("/quanLyLuat")
	public String quanLyTrieuChung(Model model) {
		model.addAttribute("luats",this.luatService.findAll());
		model.addAttribute("luat", new Luat());
		return "quanLyLuat";
	}
	@PostMapping("/quanLyLuat")
	public String quanLyTC(Model model,@ModelAttribute("luat") Luat luat) {
		this.luatService.save(luat);
		model.addAttribute("luats",this.luatService.findAll());
		model.addAttribute("luat", new Luat());
		return "quanLyLuat";
	}
	
	@GetMapping({"/quanLyLuat/{id}/view","/quanLyLuat/{id}/edit"})
    public String viewBenh(@PathVariable("id") String id, Model model) {
		System.out.println(id);
		String[] strings=id.split("null");
		for (String string : strings) {
			System.out.println(string);
		}
		List<Luat> luats=this.luatService.searchNhieu(strings[1],strings[0]);
		if(luats==null || luats.size()==0) {
			model.addAttribute("luats",this.luatService.findAll());
			model.addAttribute("luat", new Luat());
			return "quanLyLuat";
		}
		
		model.addAttribute("luat", luats.get(0));
		Benh benh=this.benhService.findByIdBenh(luats.get(0).getIdBenh());
		TrieuChung trieuchung=this.trieuChungService.findByIdTC(luats.get(0).getIdTC());
		model.addAttribute("benh", benh);
		model.addAttribute("trieuchung", trieuchung);
        return "suaLuat";
    }
//	@GetMapping("/quanLyTC/{id}/edit")
//    public String editBenh(@PathVariable("id") String id, Model model) {
//		TrieuChung tc=this.trieuChungService.findByIdTC(id);
//	    model.addAttribute("trieuchung",tc);
//	    
//        return "suaLuat";
//    }
	@GetMapping("/quanLyLuat/{id}/delete")
    public String deleteBenh(@PathVariable("id") String id, Model model) {
		System.out.println(id);
		String[] strings=id.split("null");
		for (String string : strings) {
			System.out.println(string);
		}
		List<Luat> luats=this.luatService.searchNhieu(strings[1],strings[0]);
		if(luats!=null && luats.size()!=0) {
			this.luatService.delete(luats.get(0));
		}
		model.addAttribute("luats",this.luatService.findAll());
		model.addAttribute("luat", new Luat());
		return "quanLyLuat";
    }



}
