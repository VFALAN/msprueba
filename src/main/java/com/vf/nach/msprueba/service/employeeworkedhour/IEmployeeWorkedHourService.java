package com.vf.nach.msprueba.service.employeeworkedhour;

import com.vf.nach.msprueba.model.entity.EmployeeWorkedHourEntity;
import com.vf.nach.msprueba.util.exception.MsPruebaException;

import java.util.Date;

public interface IEmployeeWorkedHourService {

    EmployeeWorkedHourEntity findById(Integer pId);

    Integer totalHoursWorked(Integer pId, Date startDate, Date endDate) throws MsPruebaException;
}
