package com.papounidis.space_data_hub.infrastructure;

import com.papounidis.space_data_hub.model.Mission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Creates the connection between Spring Framework and In-Memory database
 */

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer> {

}
