package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by OnKa on 28.07.2022.
 */
@RestController
@RequestMapping("/product")
public class ProductRestController
{
    final ProductService pService;

    public ProductRestController(ProductService pService)
    {
        this.pService = pService;
    }

    //Hata denetimi, DB işlemleri, validasyon yazılmaz; genelde tek satır olmalı
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product)
    {
        return pService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list()
    {
        return pService.list();
    }

    @DeleteMapping("/delete/{spid}")
    public ResponseEntity delete(@PathVariable String spid)
    {
        return pService.delete(spid);
    }
}
