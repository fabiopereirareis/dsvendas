package com.devesuperior.dsvendas.services;

import com.devesuperior.dsvendas.dto.SaleDTO;
import com.devesuperior.dsvendas.dto.SellerDTO;
import com.devesuperior.dsvendas.entities.Sale;
import com.devesuperior.dsvendas.entities.Seller;
import com.devesuperior.dsvendas.repositories.SaleRepository;
import com.devesuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }
}
