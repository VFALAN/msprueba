package com.vf.nach.msprueba.controller;

import com.vf.nach.msprueba.model.dto.ResponseDTO;
import com.vf.nach.msprueba.service.employeeworkedhour.IEmployeeWorkedHourService;
import com.vf.nach.msprueba.util.DateUtils;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/api/employeeWorkedHours")
public class EmployeeWorkedHoursController {

    @Autowired
    private IEmployeeWorkedHourService iEmployeeWorkedHourService;


    @GetMapping("/getHoursByEmployee")
    ResponseEntity<?> getHoursByHours(@RequestParam("start_date") String pStartDate, @RequestParam("end_date") String pEndDate, @RequestParam("employee_id") Integer pEmployeeId) throws MsPruebaException, ParseException {
        Date mStartDate = DateUtils.parseFromString(pStartDate, "yyyy-MM-dd");
        Date mEndDate = DateUtils.parseFromString(pEndDate, "yyyy-MM-dd");
        Integer totalHours = this.iEmployeeWorkedHourService.totalHoursWorked(pEmployeeId, mStartDate, mEndDate);
        return new ResponseEntity<>(ResponseDTO.builder().success(true).data(totalHours).build(), HttpStatus.OK);
    }
}
