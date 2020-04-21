package com.capg.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.capg.dto.ProductDto;
import com.capg.entities.Product;
import com.capg.exceptions.ProductNotFoundException;
import com.capg.service.IProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductRestController {

	private static Logger Log= LoggerFactory.getLogger(ProductRestController.class);
	
    @Autowired
    private IProductService service;

	@GetMapping("/find/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
    	Product product = service.findById(id);
        ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProductt(@RequestBody ProductDto dto) {
        Product product = convert(dto);
       product = service.update(product);
        ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }

      Product convert(ProductDto dto) {
        Product product = new  Product();
        product.setProdName(dto.getProdName());
        product.setProdPrice(dto.getProdPrice());
        return product;
    }


    @GetMapping
    public ResponseEntity<List<Product>> fetchAll() {
        List<Product> products = service.fetchAll();
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>deleteProduct(@PathVariable("id") int id){
       boolean result= service.remove(id);
       ResponseEntity<Boolean>response=new ResponseEntity<>(result, HttpStatus.OK);
       return response;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product>updateProduct(@RequestBody ProductDto dto ,@PathVariable("id") int id){
    	Product  product=convert(dto);
        product.setProdId(id);
        product = service.update(product);
        ResponseEntity<Product>response=new ResponseEntity<>(product,HttpStatus.OK);
        return response;
    }
    
    @ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFound(ProductNotFoundException exception) {
        Log.error("handling exception", exception);
        String exceptionMsg=exception.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(exceptionMsg,HttpStatus.NOT_FOUND);
        return response;
}

    @ExceptionHandler(Throwable.class)
      public ResponseEntity<String> handleAllExceptions(Throwable exception)
      {
    	Log.error("Handling all exceptions",exception);
    	String msg = "Something went wrong";
    	ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
    	return response;
      }
}
