package com.daga.repository;

import com.daga.model.ShopTransaction;
import org.springframework.data.repository.CrudRepository;

public interface ShopTransactionRepository extends CrudRepository<ShopTransaction, Long> {
}
