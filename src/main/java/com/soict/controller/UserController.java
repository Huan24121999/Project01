package com.soict.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.soict.entities.BN_TC;
import com.soict.entities.Benh;
import com.soict.entities.BenhNhan;
import com.soict.entities.BoSo;
import com.soict.entities.ListBN_TC;
import com.soict.entities.ListUser;
import com.soict.entities.Luat;
import com.soict.entities.User;
import com.soict.service.BN_TCService;
//import com.soict.model.UserBenhNhan;
import com.soict.service.BenhNhanService;
import com.soict.service.BenhService;
import com.soict.service.LuatService;
import com.soict.service.TrieuChungService;
import com.soict.service.UserService;

import javassist.expr.NewArray;
import lombok.experimental.var;
import net.bytebuddy.asm.Advice.This;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired 
	private BenhNhanService benhNhanService;
	
	@Autowired
	private TrieuChungService trieuChungService;
	
	@Autowired
	private BenhService benhService;
	
	@Autowired
	private BN_TCService bn_TCService;
	
	@Autowired
	private LuatService luatService;
	
	@GetMapping("/homeUser")
	public String homeUser(Model model) {
		return "user";
	}
	
	
	@GetMapping({"/signup","/","signin"})
	public String signup(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "index";
	}
	
	@PostMapping("/signup")
	public String signup(Model model, @Valid User user,BindingResult result) {
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		System.out.println("đã vòa đây!");
		if(result.hasErrors()) {
			System.out.println("có lỗi ");
			return "index";
		}
		else {
			User userTest=this.userService.findByUsername(user.getUsername());
			if(userTest!=null) {

				if(userTest.getPassword().trim().equals(user.getPassword().trim())){
					System.out.println(user.getUsername()+ "   "+user.getPassword()+"  "+user.getActive());
					if(userTest.getActive()==1) {
						return "admindemo";
					}
					else if(userTest.getActive()==2) {
						return "user";
					}
					else {
						model.addAttribute("error","Tài khoản của quý khách đã bị khóa");
						
					}
				}
			}
			
		}
		model.addAttribute("error","Username hoặc password không đúng, vui lòng kiểm tra lại lại!");
		return "index";
		
	}
	@GetMapping("/forgotUser")
	public String forgotUser(Model model) {
		
		return "errorpage";
	}
	
	@PostMapping("/signin")
	public String signin(Model model,@Valid User user,BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("error", "có lỗi");
			model.addAttribute("user",user);
			return "signup";
		}
		else {
			User user2=this.userService.findByUsername(user.getUsername());
			if(user2!=null) {
				model.addAttribute("error","tài khoản đã tồn tại");
				return "signup";
			}
			else {
				this.userService.save(user);
				if(user.getActive()==1) {
					return "admindemo";
				}
				else {
					return "user";
				}
			
			}
		}
	}
	
//	@GetMapping("/chandoan")
//	public String chandoan(Model model) {
//		model.addAttribute("benhs",this.benhService.findAll());
//		model.addAttribute("trieuChungs",this.trieuChungService.findAll());
//		model.addAttribute("benhNhans",this.benhNhanService.findAll());
//		return "chanDoan";
//	}
	
//	@GetMapping("/doan")
//	public String chandoann(Model model) {
//		model.addAttribute("benhs",this.benhService.findAll());
//		model.addAttribute("trieuChungs",this.trieuChungService.findAll());
//		model.addAttribute("benhNhans",this.benhNhanService.findAll());
//		return "doan";
//	}
//	
	@GetMapping("/chanDoan")
	public String chandoannn(Model model) {
		model.addAttribute("benhs",this.benhService.findAll());
		model.addAttribute("trieuChungs",this.trieuChungService.findAll());
		model.addAttribute("benhNhans",this.benhNhanService.findAll());
		

	    ListBN_TC listLoaiDoanAAA = new ListBN_TC();
	    ArrayList<BN_TC> LDD =new ArrayList<BN_TC>(10);
	    for(int i=0;i<10;i++) {
	    	LDD.add(new BN_TC()); 
	    }
	    listLoaiDoanAAA.setBn_TCs(LDD);
	    model.addAttribute("listBNTC",listLoaiDoanAAA);
	    model.addAttribute("benhNhanCL",new BenhNhan());
	    
		
		
		return "doan2";
	}
	
	@GetMapping("/chanDoanUser")
	public String chandoanUser(Model model) {
		model.addAttribute("benhs",this.benhService.findAll());
		model.addAttribute("trieuChungs",this.trieuChungService.findAll());
		model.addAttribute("benhNhans",this.benhNhanService.findAll());
		

	    ListBN_TC listLoaiDoanAAA = new ListBN_TC();
	    ArrayList<BN_TC> LDD =new ArrayList<BN_TC>(10);
	    for(int i=0;i<10;i++) {
	    	LDD.add(new BN_TC()); 
	    }
	    listLoaiDoanAAA.setBn_TCs(LDD);
	    model.addAttribute("listBNTC",listLoaiDoanAAA);
	    model.addAttribute("benhNhanCL",new BenhNhan());
	    
		
		return "userdemo";
	}
	
	@PostMapping("/ketqua")
	public String daon2(Model model,@ModelAttribute("listBNTC") ListBN_TC listBN_TC,@ModelAttribute("benhNhanCL") BenhNhan benhNhan) {
		for(int i=0;i<10;i++) {
			System.out.println("value: "+listBN_TC.getBn_TCs().get(i).getKd()+"  "+listBN_TC.getBn_TCs().get(i).getTb()+"   "
					+listBN_TC.getBn_TCs().get(i).getPd()  +listBN_TC.getBn_TCs().get(i).getIdTC()
					+"   "+listBN_TC.getBn_TCs().get(i).getIdBN());
			listBN_TC.getBn_TCs().get(i).getKd();
			
			
		}
		
		
		ArrayList<BoSo> listBNTCArrayList=new ArrayList<BoSo>();// chứa mảng bệnh nhân- triệu chứng
		ArrayList<BoSo> listTCBArrayList=new ArrayList<BoSo>();// chứa mảng TC-bệnh
		int n=0;
		for(int i=0;i<10;i++) {
			BN_TC bn_TC=listBN_TC.getBn_TCs().get(i);
			if(bn_TC.getIdTC()!=null || bn_TC.getIdTC()=="") {
				n++;
				listBNTCArrayList.add(new BoSo(bn_TC.getKd(),bn_TC.getTb(),bn_TC.getTb()));
				//Luat luat=this.luatService.findByTC_B(listBN_TC.getBn_TCs().get(i).getIdTC(),listBN_TC.getBn_TCs().get(0).getIdBN() );
				String tcString=listBN_TC.getBn_TCs().get(i).getIdTC();
				String bString=listBN_TC.getBn_TCs().get(0).getIdBN();
				List<Luat> luatlist=this.luatService.searchNhieu(tcString,bString);
				
				System.out.println("vừa seach luật xong: ");
				System.out.println("lần thứ:  "+n+" "+listBN_TC.getBn_TCs().get(i).getIdTC()+" "+listBN_TC.getBn_TCs().get(0).getIdBN());
				if(luatlist==null || luatlist.size()==0) {
					System.out.println("lần "+n+"  luat null");
					listTCBArrayList.add(new BoSo(0,0,1));
				}
				else {
					Luat luat=luatlist.get(0);
					System.out.println("lần "+n+"  luat khac null");
					
					listTCBArrayList.add(new BoSo(luat.getKd(),luat.getTb(),luat.getPd()));
				}
			}
		}
		System.out.println(n);
		
		
		
		float x=this.bn_TCService.xuly(listBNTCArrayList, listTCBArrayList);
		System.out.println("x đây____________________: "+x);
		if(x>0.5) {
			model.addAttribute("mess","DƯƠNG TÍNH");
		}
		else {
			model.addAttribute("mess","ÂM TÍNH");
		}
		
		return "admin";
	}
	
	@PostMapping("/ketquaUser")
	public String doanuser(Model model,@ModelAttribute("listBNTC") ListBN_TC listBN_TC) {
		for(int i=0;i<10;i++) {
			System.out.println("value: "+listBN_TC.getBn_TCs().get(i).getKd()+"  "+listBN_TC.getBn_TCs().get(i).getTb()+"   "
					+listBN_TC.getBn_TCs().get(i).getPd()  +listBN_TC.getBn_TCs().get(i).getIdTC()
					+"   "+listBN_TC.getBn_TCs().get(i).getIdBN());
			listBN_TC.getBn_TCs().get(i).getKd();
		}
		
		ArrayList<BoSo> listBNTCArrayList=new ArrayList<BoSo>();// chứa mảng bệnh nhân- triệu chứng
		ArrayList<BoSo> listTCBArrayList=new ArrayList<BoSo>();// chứa mảng TC-bệnh
		
		Set<String> benhs = new HashSet<String>();
		for(int i=0;i<10;i++) {
			List<Luat> luats=this.luatService.findByIdTC(listBN_TC.getBn_TCs().get(i).getIdTC());
			for (Luat luat : luats) {
				String idBenhString=luat.getIdBenh();
				benhs.add(idBenhString);
			}
		}
		//tìm tập bệnh cần so khớp
		
		List<String> duongTinhList = new ArrayList<String>();
		for (String string : benhs) {
			int n=0;
			for(int i=0;i<10;i++) {
				BN_TC bn_TC=listBN_TC.getBn_TCs().get(i);
				if(bn_TC.getIdTC()!=null || bn_TC.getIdTC()=="") {
					n++;
					listBNTCArrayList.add(new BoSo(bn_TC.getKd(),bn_TC.getTb(),bn_TC.getTb()));
					//Luat luat=this.luatService.findByTC_B(listBN_TC.getBn_TCs().get(i).getIdTC(),listBN_TC.getBn_TCs().get(0).getIdBN() );
					String tcString=listBN_TC.getBn_TCs().get(i).getIdTC();
					String bString=string;
					List<Luat> luatlist=this.luatService.searchNhieu(tcString,bString);
					
					
					
					if(luatlist==null || luatlist.size()==0) {
						System.out.println("lần "+n+"  luat null");
						listTCBArrayList.add(new BoSo(0,0,1));
					}
					else {
						Luat luat=luatlist.get(0);
						System.out.println("lần "+n+"  luat khac null");
						
						listTCBArrayList.add(new BoSo(luat.getKd(),luat.getTb(),luat.getPd()));
					}
				}
			}
			System.out.println(n);
			float x=this.bn_TCService.xuly(listBNTCArrayList, listTCBArrayList);
			System.out.println("x đây____________________: "+x);
			if(x>0.5) {
				duongTinhList.add(this.benhService.findByIdBenh(string).getTenBenh());
				
			}
			else {
				
			}
			
		}
		String resultString=duongTinhList.toString();
		model.addAttribute("mess",resultString );
		
		return "admin";
	}
	
	
	
	@GetMapping("/luunhieuobject")
	public String LoadNhieuObjectCungLuc(Model model) {
		
//		ListLoaiDoan listLoaiDoanAAA = new ListLoaiDoan();
//        ArrayList<LoaiDoan> LDD = new ArrayList<LoaiDoan>(10);
//        listLoaiDoanAAA.setLoaiDoans(LDD);
//        model.addAttribute("listLoaiDoan111", listLoaiDoanAAA);
		
	    ListUser listLoaiDoanAAA = new ListUser();
	    ArrayList<User> LDD =new ArrayList<User>(10);
	    LDD.add(new User());
	    LDD.add(new User());
	    LDD.add(new User());
	    LDD.add(new User());
	    listLoaiDoanAAA.setUsers(LDD);
	    model.addAttribute("listUser",listLoaiDoanAAA);
	    
	            return "demolist";
	        }
	//This is the method save list Object from thymeleaf to controller
	@PostMapping("/luunhieuobject")
	public String processQuery(@ModelAttribute("listLoaiDoan111") ListUser listUser) {
		System.out.println(listUser.getUsers().get(0).getUsername()+"  0_USERNAME");
		System.out.println(listUser.getUsers().get(0).getPassword());
		System.out.println(listUser.getUsers().get(1).getUsername());
		return "haha";
	
	  }
	
	@PostMapping("/luunhieuobjectt")
	public String processQuery22(@ModelAttribute("listBNTC") ListBN_TC listBN_TC) {
	System.out.println(listBN_TC.getBn_TCs().get(0).getKd() +"ok");
	System.out.println(listBN_TC.getBn_TCs().get(1).getKd());
	System.out.println(listBN_TC.getBn_TCs().get(2).getKd());
		return "haha";
	
	  }
	@GetMapping("/luunhieuobjectt")
	public String LoadNhieuObjectCungLucc(Model model) {
		
//		ListLoaiDoan listLoaiDoanAAA = new ListLoaiDoan();
//        ArrayList<LoaiDoan> LDD = new ArrayList<LoaiDoan>(10);
//        listLoaiDoanAAA.setLoaiDoans(LDD);
//        model.addAttribute("listLoaiDoan111", listLoaiDoanAAA);
		
	    ListBN_TC listLoaiDoanAAA = new ListBN_TC();
	    ArrayList<BN_TC> LDD =new ArrayList<BN_TC>(10);
	    LDD.add(new BN_TC());
	    LDD.add(new BN_TC());
	    LDD.add(new BN_TC());
	    LDD.add(new BN_TC());
	    listLoaiDoanAAA.setBn_TCs(LDD);
	    model.addAttribute("listBNTC",listLoaiDoanAAA);
	    
	            return "demolist";
	        }
	
//	@GetMapping("/huan")
//	public String demoSuongSUong() {
//		List<Luat> list=this.luatService.findByIdTC("TC-02");
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).getIdBenh());
//		}
//		
//		List<Luat> list2=this.luatService.searchNhieu("TC-01","B-01");
//		System.out.println(list2.size()+"      hahahahah");
//		System.out.println(list2.get(0).getIdBenh()+" "+list2.get(0).getIdTC());
//		return "admin";
//	}
	@GetMapping("/userdemo")
	public String user(Model model) {
		model.addAttribute("benhs",this.benhService.findAll());
		model.addAttribute("trieuChungs",this.trieuChungService.findAll());
		model.addAttribute("benhNhans",this.benhNhanService.findAll());
		

	    ListBN_TC listLoaiDoanAAA = new ListBN_TC();
	    ArrayList<BN_TC> LDD =new ArrayList<BN_TC>(10);
	    for(int i=0;i<10;i++) {
	    	LDD.add(new BN_TC()); 
	    }
	    listLoaiDoanAAA.setBn_TCs(LDD);
	    model.addAttribute("listBNTC",listLoaiDoanAAA);
	    model.addAttribute("benhNhanCL",new BenhNhan());
	    
		
		return "userdemo";
	}
		
		
		 	
}
