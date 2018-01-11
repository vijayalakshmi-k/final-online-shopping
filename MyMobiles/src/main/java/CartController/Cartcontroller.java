package CartController;

import org.springframework.beans.factory.annotation.Autowired;

public class Cartcontroller {
	
	@Autowired
	SupplierDaoimpl supplierDaoimpl;
	@Autowired
	CategoryDaoimpl categoryDaoimpl;
	@Autowired 
	ProductDaoimpl productDaoimpl;
	
	@Autowired 
	OrderDaoimpl oredrDaoimpl;
	@AutoWired
	CartDaoimpl cartDaoimpl;

}
