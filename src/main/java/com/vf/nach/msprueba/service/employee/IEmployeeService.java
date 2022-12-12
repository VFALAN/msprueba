package com.vf.nach.msprueba.service.employee;

import com.vf.nach.msprueba.model.dto.EmployeeDTO;
import com.vf.nach.msprueba.model.entity.EmployeeEntity;
import com.vf.nach.msprueba.util.exception.MsPruebaException;

import java.util.Date;
import java.util.List;

public interface IEmployeeService {

    EmployeeEntity save(EmployeeEntity pEmployeeEntity);

    EmployeeEntity save(EmployeeDTO pEmployeeDTO) throws MsPruebaException;

    EmployeeEntity findById(Integer pId) throws MsPruebaException;

    void delete(EmployeeEntity pEmployeeEntity);

    List<EmployeeEntity> findByJob(Integer pIdJob) throws MsPruebaException;

    Double totalPayment(Integer pId, Date startDate, Date endDate) throws MsPruebaException;

    List<EmployeeEntity> findAll(Integer[] ids);
}
