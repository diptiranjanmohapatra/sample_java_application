package com.example.demo.controller;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService service;
  public ProductController(ProductService service) { this.service = service; }

  @GetMapping
  public List<Product> all() { return service.getAllProducts(); }

  @PostMapping
  public Product add(@RequestBody Product p) { return service.addProduct(p); }
}
