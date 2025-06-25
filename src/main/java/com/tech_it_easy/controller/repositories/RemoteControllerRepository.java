package com.tech_it_easy.controller.repositories;

import com.tech_it_easy.controller.models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControllerRepository extends JpaRepository<RemoteController, Long> {
}
