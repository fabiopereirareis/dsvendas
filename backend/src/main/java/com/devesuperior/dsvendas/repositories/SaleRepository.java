package com.devesuperior.dsvendas.repositories;

import com.devesuperior.dsvendas.entities.Sale;
import com.devesuperior.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
