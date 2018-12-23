package com.deemo.repo;

import com.deemo.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Long> {
}
