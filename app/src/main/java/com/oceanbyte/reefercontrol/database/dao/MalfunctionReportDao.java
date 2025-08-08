package com.oceanbyte.reefercontrol.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.models.relations.MalfunctionReportWithReefer;

import java.util.List;

@Dao
public interface MalfunctionReportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MalfunctionReport report);

    @Update
    void update(MalfunctionReport report);

    @Delete
    void delete(MalfunctionReport report);

    @Query("SELECT * FROM malfunction_reports ORDER BY createdAt DESC")
    List<MalfunctionReport> getAllSortedByDate();

    @Query("SELECT * FROM malfunction_reports WHERE reeferId = :reeferId ORDER BY createdAt DESC")
    List<MalfunctionReport> getByReeferId(String reeferId);

    @Query("SELECT * FROM malfunction_reports " +
            "WHERE reeferId LIKE '%' || :search || '%' OR " +
            "reeferId IN (SELECT container_number FROM reefers WHERE position LIKE '%' || :search || '%') " +
            "ORDER BY createdAt DESC")
    List<MalfunctionReport> searchByContainerOrPosition(String search);

    @Query("SELECT * FROM malfunction_reports WHERE id = :reportId")
    MalfunctionReport getById(long reportId);
    @Transaction
    @Query("SELECT * FROM malfunction_reports ORDER BY createdAt DESC")
    List<MalfunctionReportWithReefer> getAllWithReefer();

    @Transaction
    @Query("SELECT * FROM malfunction_reports " +
            "JOIN reefers ON malfunction_reports.reeferId = reefers.container_number " +
            "WHERE reefers.container_number LIKE '%' || :search || '%' " +
            "   OR reefers.position LIKE '%' || :search || '%' " +
            "ORDER BY malfunction_reports.createdAt DESC")
    List<MalfunctionReportWithReefer> searchWithReefer(String search);
}
