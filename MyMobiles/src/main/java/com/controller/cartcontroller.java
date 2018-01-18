package com.controller;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.function.Supplier;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.Category;
import com.model.Orders;
import com.model.Product;
import com.model.User;

@Controller
public class CartController {
	
	@Autowired
	SupplierDaoimpl supplierDaoimpl; 
	
	@Autowired
	CategoryDaoimpl categoryDaoimpl; 
	@Autowired
	ProductDaoimpl productDaoimpl; 
	
	@Autowired
	CartDaoimpl cartDaoimpl; 
	
	@Autowired
	OrdersDaoimpl ordersDaoimpl; 
	
	@Autowired
	UserDaoimpl userDaoimpl; 
	
	@RequestMapping(value="/proddetails/${p.pid}")
	public ModelAndView proddet(@PathVariable("pid")int pid)
	{
		ModelAndView mv=new ModelAndView();
		Product prod=productDaoimpl.findByPID(pid);
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
			Double price=Double.parseDouble(request.getParameter("pPrice"));
			int qty=Integer.parseInt(request.getParameter("pQty"));
			String pname=request.getParameter("pname");
			String imgName=request.getParameter("imgName");
			Cart cartExist=cartDaoimpl.getCartById(pid, userEmail);
		if(cartExist == null) {
			Cart cm=new Cart();
			cm.setCartPrice(price);
	cm.setCartProductID(pid);
	cm.setCartStock(cartExist.getCartStock()+qty);
	cm.setCartImage(imgName);
	cm.setCartProductName(pname);
	User u=userDaoimpl.findUserByEmail(userEmail);
	cm.setCartUserDetails(u);
	cartDaoimpl.insertCart(cm);
		}	
		else if(cartExist!=null)
		{
			Cart cm=new Cart();
			cm.setCartPrice(price);
	cm.setCartProductID(pid);
	cm.setCartStock(qty);
	cm.setCartImage(imgName);
	cm.setCartProductName(pname);
	User u=userDaoimpl.findUserByEmail(userEmail);
	cm.setCartUserDetails(u);
	cartDaoimpl.insertCart(cm);
		}
			mv.addObject("cartInfo",cartDaoimpl.findByCartID(userEmail));
			mv.addObject("cart");
			return mv;
			}catch(Exception e)
		{
				e.printStackTrace();
				mv.addObject("cartInfo",cartDaoimpl.findByCartID(userEmail));
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
		User u=userDaoimpl.findUserByEmail(userEmail);
		List<Cart> cart=cartDaoimpl.findByCartID(userEmail);
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
		List<Cart> cart=cartDaoimpl.findByCartID(userEmail);
		
		Double total=Double.parseDouble(request.getParameter("total"));
		String payment=request.getParameter("payment");
		User u=userDaoimpl.findUserByEmail(userEmail);
		ord.setUser(u);
		ord.setTotal(total);
		ord.setPayment(payment);
		ordersDaoimpl.insertOrder(ord);
		mv.addObject("user",userDaoimpl.findUserByEmail(userEmail));
		mv.addObject("orderDetails",u);
		mv.addObject("Cart",cart);
		return mv;
}
	
	@RequestMapping("/ack")
	public String ack()
	{		return "ack"; 		
	}
	
	
	@RequestMapping(value="/deletePCart/{cartId }")
	public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView(); 
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		cartDaoimpl.deleteCart(cartId);
		mv.addObject("cartInfo", cartDaoimpl.findByCartID(userEmail));
	mv.setViewName("cart");
	return mv;}
	
	
	
	@RequestMapping(value="/goToCart",method=RequestMethod.GET)
	public ModelAndView gotocart(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView(); 
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		mv.addObject("cartInfo",cartDaoimpl.findByCartID(userEmail));
		mv.setViewName("cart");
		return mv;
		
		
	}	
}