package com.example.nbp_api.repository;

import com.example.nbp_api.entity.RequestInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<RequestInfo, Long> {

}
