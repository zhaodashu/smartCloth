package com.smartCloth.repository;

import com.smartCloth.model.IntelligenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntelligenceRepository extends JpaRepository<IntelligenceModel, Long> {


}
