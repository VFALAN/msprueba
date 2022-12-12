package com.vf.nach.msprueba.controller;

import com.vf.nach.msprueba.model.dto.ResponseDTO;
import com.vf.nach.msprueba.model.dto.EmployeeDTO;
import com.vf.nach.msprueba.model.entity.EmployeeEntity;
import com.vf.nach.msprueba.service.employee.IEmployeeService;
import com.vf.nach.msprueba.util.DateUtils;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping
    ResponseEntity<?> save(@RequestBody EmployeeDTO employeeDTO) throws MsPruebaException {
        EmployeeEntity mEmployeeEntity = this.iEmployeeService.save(employeeDTO);

        return new ResponseEntity<>(ResponseDTO.builder().success(true).data(mEmployeeEntity.getId()).build(), HttpStatus.OK);
    }

    @GetMapping("/findByJob")
    ResponseEntity<?> findByJob(@RequestParam("pJobId") Integer pJobId) throws MsPruebaException {
        List<EmployeeEntity> employeeEntityList = this.iEmployeeService.findByJob(pJobId);
        return new ResponseEntity<>(ResponseDTO.builder().success(true).data(employeeEntityList).build(), HttpStatus.OK);
    }

    @GetMapping("/getTotalPayment")
    ResponseEntity<?> totalPayment(@RequestParam("employee_id") Integer pEmployeeId, @RequestParam("start_date") String pStartDate, @RequestParam("end_date") String pEndDate) throws ParseException, MsPruebaException {
        Date mStartDate = DateUtils.parseFromString(pStartDate, "yyyy-MM-dd");
        Date mEndDate = DateUtils.parseFromString(pEndDate, "yyyy-MM-dd");
        Double totalPayment = this.iEmployeeService.totalPayment(pEmployeeId, mStartDate, mEndDate);
        return new ResponseEntity<>(ResponseDTO.builder().data(totalPayment).success(true).build(), HttpStatus.OK);
    }

    @GetMapping("/infoEmployees")
    ResponseEntity<?> infoEmployees(@RequestParam("employee_id")Integer[] pEmployeeId ,
                                    @RequestParam(name ="start_date" , required = false)String pStartDate ,
                                    @RequestParam(name = "end_date" , required = false) String pEndDate) throws ParseException {
        List<EmployeeEntity> employeeEntityList = this.iEmployeeService.findAll(pEmployeeId);
        return new ResponseEntity<>(ResponseDTO.builder().success(true).data(employeeEntityList).build() , HttpStatus.OK);
    }

}
