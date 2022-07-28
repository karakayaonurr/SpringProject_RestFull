package com.works.services;

import com.works.repositories.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * Created by OnKa on 28.07.2022.
 */
@Service
public class ProductService
{
    final ProductRepository pRepo;
    public ProductService(ProductRepository pRepo)
    {
        this.pRepo = pRepo;
    }
    
}
