package com.d3.infra.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.d3.common.model.player.Player;

public interface PlayerRepo extends PagingAndSortingRepository<Player, Long>{

	public Player findByBtag(String btag);

}
