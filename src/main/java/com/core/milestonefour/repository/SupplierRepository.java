package com.core.milestonefour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.milestonefour.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>
{
	
}
