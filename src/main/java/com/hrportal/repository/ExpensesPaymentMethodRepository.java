package com.hrportal.repository;

import com.hrportal.model.ExpensesPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "expensesPaymentMethod", path = "expensesPaymentMethod")
public interface ExpensesPaymentMethodRepository extends JpaRepository<ExpensesPaymentMethod, Long> {
}
