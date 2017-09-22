package com.hrportal.repository;

import com.hrportal.model.ExpensesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@RepositoryRestResource(collectionResourceRel = "expensesCategory", path = "expensesCategory")
public interface ExpensesCategoryRepository extends JpaRepository<ExpensesCategory, Long> {
}
