package com.tech_it_easy.controller.repositories;

import com.tech_it_easy.controller.models.CiModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiModuleRepository extends JpaRepository<CiModule, Long> {
}
