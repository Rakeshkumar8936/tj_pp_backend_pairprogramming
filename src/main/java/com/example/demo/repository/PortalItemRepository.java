package com.example.demo.repository;

import com.example.demo.entity.PortalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortalItemRepository extends JpaRepository<PortalItem, Long> {

}
