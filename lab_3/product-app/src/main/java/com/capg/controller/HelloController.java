package com.capg.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.capg.entities.Product;
import com.capg.service.IProductService;

@Controller
public class HelloController {
	private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IProductService productService;


    @GetMapping("/find")
    public ModelAndView findPage() {
        return new ModelAndView("findproduct");
    }


    @GetMapping("/processfindproduct")
    public ModelAndView productDetails(@RequestParam("prodId")int prodId) {
        System.out.println("Product Details , id=" +prodId);
        Product product= productService.findById(prodId);
        return new ModelAndView("productdetails", "product", product);
    }


    @GetMapping("/add")
    public ModelAndView addProduct() {
        return new ModelAndView("productadd"); 
    }

    @GetMapping("/processadd")
    public ModelAndView addProduct(@RequestParam("prodId" )   int prodId,
                                  @RequestParam("prodName") String prodName,
    		                       @RequestParam("prodPrice")  double prodPrice)
      {
        Product product=new Product();
        product.setProdId(prodId);
        product.setProdName(prodName);
        product.setProdPrice(prodPrice);
        product = productService.update(product);
        return new ModelAndView("productdetails",  "product", product);
    }

    @GetMapping("/displayallproducts")
    public ModelAndView displayAll(){
        List<Product> products= productService.fetchAll();
        ModelAndView modelAndView=new ModelAndView("listproducts","products",products);
        return modelAndView;
    }


}
