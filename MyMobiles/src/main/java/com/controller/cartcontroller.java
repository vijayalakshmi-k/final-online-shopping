package com.controller;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Daoimpl.CartDaoImpl;
import com.Daoimpl.CategoryDaoimpl;
import com.Daoimpl.OrdersDaoimpl;
import com.Daoimpl.ProductDaoimpl;
import com.Daoimpl.SupplierDaoimpl;
import com.Daoimpl.UserDaoimpl;
import com.model.Cart;
import com.model.Orders;
import com.model.Product;
import com.model.User;

@Controller
public class cartcontroller {
	
	@Autowired
	SupplierDaoimpl supplierDaoimpl; 
	
	@Autowired
	CategoryDaoimpl categoryDaoimpl; 
	@Autowired
	ProductDaoimpl productDaoimpl; 
	
	@Autowired
	CartDaoImpl cartDaoimpl; 
	
	@Autowired
	OrdersDaoimpl ordersDaoimpl; 
	
	@Autowired
	UserDaoimpl userDaoimpl; 
	
	@RequestMapping(value="/proddetails/${p.pid}")
	public ModelAndView proddet(@PathVariable("pid")int pid)
	{
		ModelAndView mv=new ModelAndView();
		Product prod=productDaoimpl.FindByProductId(pid);
		mv.addObject("prod",prod);
		mv.setViewName("proddetails");
		return mv;
			}
	
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public ModelAndView addtoCart(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView(); 
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		try
		{
			int pid=Integer.parseInt(request.getParameter("pId"));
			double price=Double.parseDouble(request.getParameter("pPrice"));
			int qty=Integer.parseInt(request.getParameter("pQty"));
			String pname=request.getParameter("pname");
			String imgName=request.getParameter("imgName");
			Cart cartExist=cartDaoimpl.getCartById(pid, userEmail);
		    if(cartExist == null) {
			Cart cm=new Cart();
		      cm.setCartid(pid);
		      cm.setCartprice(price);
	      cm.setCartstock(cartExist.getCartstock()+qty);
	       cm.setCartimage(imgName);
	      cm.setCartProductName(pname);
	     User u=userDaoimpl.FindByEmail(userEmail);
	    cm.setCartUserDetails(u);
	    CartDaoImpl.insercart(cm);
		}	
		else if(cartExist!=null)
		{
			Cart cm=new Cart();
			cm.setCartprice(price);
	cm.setCartid(pid);
	cm.setCartstock(qty);
	cm.setCartimage(imgName);
	cm.setCartProductName(pname);
	User u=userDaoimpl.FindByEmail(userEmail);
	cm.setCartUserDetails(u);
	cartDaoimpl.insertCart(cm);
		}
			mv.addObject("cartInfo",cartDaoimpl.FindBycartId(userEmail));
			mv.addObject("cart");
			return mv;
			}catch(Exception e)
		{
				e.printStackTrace();
				mv.addObject("cartInfo",cartDaoimpl.FindBycartId(userEmail));
				mv.addObject("cart");
				return mv;
				
		}
	}
	
	@RequestMapping(value="/checkout",method=RequestMethod.GET)
	public ModelAndView goToCheckout(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView(); 
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		User u=userDaoimpl.FindByEmail(userEmail);
		List<Cart> cart=cartDaoimpl.FindBycartId(userEmail);
		mv.addObject("user",u);
		mv.addObject("cart",cart);
		return mv;
		
	}
	
	@RequestMapping(value="/orderprocess",method=RequestMethod.GET)
	public ModelAndView orderProcess(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView("ack"); 
		Orders ord=new Orders();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		List<Cart> cart=cartDaoimpl.FindBycartId(userEmail);
		
		Double total=Double.parseDouble(request.getParameter("total"));
		String payment=request.getParameter("payment");
		User u=userDaoimpl.FindByEmail(userEmail);
		ord.setUser(u);
		ord.setTotal(total);
		ord.setPayment(payment);
		ordersDaoimpl.insertorder(ord);
		mv.addObject("user",userDaoimpl.FindByEmail(userEmail));
		mv.addObject("orderDetails",u);
		mv.addObject("Cart",cart);
		return mv;
}
	
	@RequestMapping("/ack")
	public String ack()
	{		return "ack"; 		
	}
	
	
	@RequestMapping(value="/deletePCart/{cartId }")
	public ModelAndView deleteCartItem(@PathVariable("cartId")Cart cartId,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView(); 
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		cartDaoimpl.deleteCart(cartId);
		mv.addObject("cartInfo", cartDaoimpl.FindBycartId(userEmail));
	mv.setViewName("cart");
	return mv;}
	
	
	
	@RequestMapping(value="/goToCart",method=RequestMethod.GET)
	public ModelAndView gotocart(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView(); 
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		mv.addObject("cartInfo",cartDaoimpl.FindBycartId(userEmail));
		mv.setViewName("cart");
		return mv;
		
		
	}	
}