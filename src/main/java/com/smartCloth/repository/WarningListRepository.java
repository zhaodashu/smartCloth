package com.smartCloth.repository;

import com.smartCloth.model.HistoryDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WarningListRepository extends JpaRepository<HistoryDataModel, Long> {

}
