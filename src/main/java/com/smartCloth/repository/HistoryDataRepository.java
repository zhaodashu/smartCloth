package com.smartCloth.repository;

import com.smartCloth.model.HistoryDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface HistoryDataRepository extends JpaRepository<HistoryDataModel, Long> {

    @Query(nativeQuery = true, value = "SELECT hd.openid, hd.date, avg(hd.oxygen), avg(hd.dp), avg(hd.sp), avg(hd.heartrate) from history_data hd where hd.openid = ?1 and hd.date = ?2")
    Object getAverageInfo(String openId, Date date);

    @Query(nativeQuery = true, value = "SELECT ROUND(AVG(hd.oxygen),2) from history_data hd where hd.openid = ?1 and hd.date = ?2 and hd.oxygen > 0")
    Object getAverageOxygen(String openId, Date date);

    @Query(nativeQuery = true, value = "SELECT ROUND(AVG(hd.dp),2) from history_data hd where hd.openid = ?1 and hd.date = ?2 and hd.dp > 0 and hd.dp < 255")
    Object getAverageDp(String openId, Date date);

    @Query(nativeQuery = true, value = "SELECT ROUND(AVG(hd.sp),2) from history_data hd where hd.openid = ?1 and hd.date = ?2 and hd.sp > 0 and hd.sp<255")
    Object getAverageSp(String openId, Date date);

    @Query(nativeQuery = true, value = "SELECT ROUND(AVG(hd.heartrate),2) from history_data hd where hd.openid = ?1 and hd.date = ?2 and hd.heartrate > 0 and hd.heartrate<255")
    Object getAverageHeartRate(String openId, Date date);

}
