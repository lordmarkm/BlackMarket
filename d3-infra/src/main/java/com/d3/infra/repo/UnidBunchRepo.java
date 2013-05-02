package com.d3.infra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.d3.common.model.player.UnidBunch;

public interface UnidBunchRepo extends PagingAndSortingRepository<UnidBunch, Long> {

	@Query("from UnidBunch bunch where bunch.item.name = :itemName")
	public List<UnidBunch> findByItemName(@Param("itemName") String itemName);
	
}
