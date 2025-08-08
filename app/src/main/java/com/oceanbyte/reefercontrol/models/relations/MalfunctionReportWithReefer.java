package com.oceanbyte.reefercontrol.models.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.models.Reefer;

public class MalfunctionReportWithReefer {

    @Embedded
    public MalfunctionReport report;

    @Relation(
            parentColumn = "reeferId",
            entityColumn = "container_number"
    )
    public Reefer reefer;
}