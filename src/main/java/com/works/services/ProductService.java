package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public ResponseEntity save(Product pro)
    {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        pRepo.save(pro);

        hm.put(REnum.status, true);
        hm.put(REnum.message, "Save Success");
        hm.put(REnum.result, pro);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list()
    {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findAll();

        hm.put(REnum.status, true);
        hm.put(REnum.message, "List Success");
        hm.put(REnum.result, ls);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String spid)
    {
        Map<REnum, Object> hm = new LinkedHashMap<>();

        try
        {
            int pid = Integer.parseInt(spid);
            pRepo.deleteById(pid);
            hm.put(REnum.status, true);
            hm.put(REnum.message, "Delete Success");
            hm.put(REnum.result, pid);
            return new ResponseEntity(hm, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            hm.put(REnum.status, false);
            hm.put(REnum.message, ex.getMessage());
            hm.put(REnum.result, spid);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
    }

}
