package com.example.productservicemorningbatch.controllers;

import com.example.productservicemorningbatch.commons.AuthenticationCommons;
import com.example.productservicemorningbatch.dtos.UserDto;
import com.example.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.example.productservicemorningbatch.models.Product;
import com.example.productservicemorningbatch.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private AuthenticationCommons authenticationCommons;

    ProductController(@Qualifier("selfProductService") ProductService productService, AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping({"/{id}"})
    public Product getProductById(@PathVariable("id") Long id) throws InvalidProductIdException {
        return productService.getProductById(id);
    }

    //localhost:8080/products
    @GetMapping("/all/{token}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable String token) {

        //Validate the token using UserService.
        UserDto userDto = authenticationCommons.validateToken(token);

        if (userDto == null) {
            //token is invalid
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

//        boolean isAdmin = false;
//        for (Role role : userDto.getRoles()) {
//            if (role.equals("ADMIN")) {
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if (!isAdmin) {
//            //throw some exception
//            return null;
//        }

        List<Product> products = productService.getAllProducts(); // @76589

        //products = new ArrayList<>(); // @98123

//        products.get(0).setImage("sample url1");
//        products.get(1).setImage("sample url2");
//        products.get(2).setImage("sample url3");

        return new ResponseEntity<>(products, HttpStatus.OK); //@98123
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    //Partial Update.
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        return new Product();
    }

    //Replace Product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }
}
