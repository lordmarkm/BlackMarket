package com.d3.infra.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.d3.common.model.items.UnidentifiedItem;

public interface UnidItemRepo extends PagingAndSortingRepository<UnidentifiedItem, Long> {

}
