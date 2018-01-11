 package admincontroller.java;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale.Category;
import java.util.function.Supplier;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class admincontroller 
{
	@Autowired
	Supplier supplierDaoimpl;
	
	@Autowired
	Category categoryDaoimpl;
	
	@Autowired
	Product productDaoimpl;
	
@RequestMapping("/modal")

public String modal()
{
	return "modal";
}

@RequestMapping(value="/SaveSupplier", method=RequestMethod.POST)
public ModelAndView SaveSupplier(@RequestParam("sid") int cid,@RequestParam("sname")String sname)
{
ModelAndView mv=new ModelAndView();
Supplier s=new Supplier();
s.setSid(sid);
s.setSname(sname);
supplierDaoimpl.insertSupplier(s);
mv.setViewName("adding");
return mv;
}

@RequestMapping(value="/SaveCategory", method=RequestMethod.POST)
public ModelAndView SaveCAtegory(@RequestParam("cid") int cid,@RequestParam("cname")String cname)
{
	ModelAndView mv=new ModelAndView();
Category c=new Category();
c.setCid(cid);
c.setCname(cname);
CategoryDaoImpl.insertCategory(c);
mv.setViewName("adding");
return mv;
}
@RequestMapping(value="/SaveProduct", method=RequestMethod.POST)
public String SaveProduct(HttpServletRequest request,@RequestParam("file")MultipartFile file)  
{
	Product prod=new Product();
	prod.setPname(request.getParameter("pName"));
	prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
	prod.setDescription(request.getParameter("pDescription"));
	prod.setStock(Integer.parseInt(request.getParameter("pStock")));
	prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
	prod.setSupplier(supplierDaoImpl.findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
	prod.setProduct(productDaoImpl.findByProductId(Integer.parseInt(request.getParameter("pProduct"))));
	String filepath=request.getSession(). getServletContext().getRealPath("/");
	String filename=file.getOriginalFilename();
	prod.setImgName(filename);
	ProductDaoimpl.insertProduct(prod);
	System.out.println("File Path" +filepath);
	try
	{
	byte imagebyte[]= file.getBytes();
	 BufferedOutputStream buff = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
	 fos.write(imagebyte);
	 fos.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
return "adding";
}
@ModelAttribute
public void loadingDataInPage(Model m)
{
	m.addAttribute("satList",supplierDaoimpl.retrieve ());
	m.addAttribute("catList",categoryDaoimpl.retrieve());
	m.addAttribute("catList",productDaoimpl.retrieve());
 
	
}

   @RequestMapping(value="/Productlist" )
public ModelAndView Prodlist()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("Product".prodlist.retrieve());
	mv.setViewName("productadminlist");
	return mv;
	
}


@RequestMapping(value="/Categorylist" )
public ModelAndView Catlist()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("Catlist".categoryDaoImpl.retrieve());
	mv.setViewName("categoryadminlist");
	return mv;
	
}


@RequestMapping(value="/Supplierlist" )
public ModelAndView Satlist()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("Satlist".supplierDaoImpl.retrieve());
	mv.setViewName("supplieradminlist");
	return mv;
	
}}















