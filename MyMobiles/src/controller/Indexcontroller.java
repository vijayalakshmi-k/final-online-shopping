package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Indexcontroller 
{
	@Autowired
	ProductDaoImpl productDaoimpl;
	@Autowired
	CategoryDaoImpl categoryDaoimpl
	
	
	
	
	@RequestMapping("/")
  
	public String index()
	{
		return "index";
	}
}
@RequestMapping(value="/gotoregister" method=RequestMethod.post)
public ModelAndView gotoregister
{
	ModelAndView mv=new ModelAnView();
	mv.adobject("user", new User());
	mv.SetViewName(register);
	return mv;
}
 @RequestMapping(value="/SaveRegister" method=Request.post)
public ModelAndView SaveRegister
{
	ModelAndView mv=new ModelAnView();
User.setRole("Role_user");""
UserDaoImpl.insertUser(user);
mv.SetViewname("index");
return mv;

}
 @RequestMapping(value="productCustList")
 public ModelAndView getCustTable(@RequestPara("cid") int cid)
 {
	 ModelAndView mv=	new ModelAndView();
	 mv.addObject(product.prodlist.retrieve());
	 mv.setViewName("productCustList");
 }
 
 
 @RequestMapping("/login")
 
	public String login()
	{
		return "login";
	}

 @RequestMapping("/Userlogged")
 
	public String index()
	{
		return "redirect:/index";
	}

 @RequestMapping("/relogin")
 
	public String goTologin()
	{
		return "redirect:/goTologin";
	}

 @RequestMapping("/error")
 
	public String error()
	{
		return "error";
	}

 @RequestMapping(value="productCustList")
 public ModelAndView getCustTable(@RequestParam("cid") int cid)
 {
	 ModelAndView mv=new ModelAndView();
	 mv.addObject(prodlist.ProductDaoimpl.retrieve());
	 mv.setViewName(ProductDaoimpl);
	 return mv;
 }
 
 @ModelAttribute 
 public getData(Model m)
 {
	 m.addAttribute("catlist.CategoryDaoimpl.retrieve());
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 