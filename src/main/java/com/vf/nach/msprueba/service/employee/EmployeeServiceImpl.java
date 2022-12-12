package com.vf.nach.msprueba.service.employee;

import com.vf.nach.msprueba.model.dto.EmployeeDTO;
import com.vf.nach.msprueba.model.entity.EmployeeEntity;
import com.vf.nach.msprueba.model.entity.GenderEntity;
import com.vf.nach.msprueba.model.entity.JobEntity;
import com.vf.nach.msprueba.repository.IEmployeeRepository;
import com.vf.nach.msprueba.service.employeeworkedhour.IEmployeeWorkedHourService;
import com.vf.nach.msprueba.service.gender.IGenderService;
import com.vf.nach.msprueba.service.job.IJobService;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private IJobService iJobService;
    @Autowired
    private IGenderService iGenderService;

    @Autowired
    private IEmployeeWorkedHourService iEmployeeWorkedHourService;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeEntity save(EmployeeEntity pEmployeeEntity) {
        return this.iEmployeeRepository.save(pEmployeeEntity);
    }

    @Override
    public EmployeeEntity save(EmployeeDTO pEmployeeDTO) throws MsPruebaException {
        EmployeeEntity mEmployeeEntity = this.modelMapper.map(pEmployeeDTO, EmployeeEntity.class);
        JobEntity mJobEntity = this.iJobService.findById(pEmployeeDTO.getJobId());
        GenderEntity mGender = this.iGenderService.findById(pEmployeeDTO.getGenderId());
        mEmployeeEntity.setGender(mGender);
        mEmployeeEntity.setJob(mJobEntity);
        return this.iEmployeeRepository.save(mEmployeeEntity);
    }

    @Override
    public EmployeeEntity findById(Integer pId) throws MsPruebaException {
        Optional<EmployeeEntity> mOptionalEmployeeEntity = this.iEmployeeRepository.findById(pId);
        if (mOptionalEmployeeEntity.isPresent()) {
            return mOptionalEmployeeEntity.get();
        } else {
            throw new MsPruebaException("employee not foud id: " + pId);
        }
    }

    @Override
    public void delete(EmployeeEntity pEmployeeEntity) {
        this.iEmployeeRepository.delete(pEmployeeEntity);
    }

    @Override
    public List<EmployeeEntity> findByJob(Integer pIdJob) throws MsPruebaException {
        JobEntity mJobEntity = this.iJobService.findById(pIdJob);

        List<EmployeeEntity> mEmployeeEntityList = this.iEmployeeRepository.findByJob(mJobEntity);
        if (!mEmployeeEntityList.isEmpty()) {
            mEmployeeEntityList.sort((EmployeeEntity emp1, EmployeeEntity emp2) -> emp1.getLastName().compareTo(emp2.getLastName()));
        }


        return mEmployeeEntityList;
    }

    @Override
    public Double totalPayment(Integer pId, Date startDate, Date endDate) throws MsPruebaException {
        EmployeeEntity mEmployeeEntity = this.findById(pId);
        Integer totalHours = this.iEmployeeWorkedHourService.totalHoursWorked(pId, startDate, endDate);
        return totalHours != 0 ? totalHours * mEmployeeEntity.getJob().getSalary() : 0;
    }

    @Override
    public List<EmployeeEntity> findAll(Integer[] ids) {
        return this.iEmployeeRepository.findAllById(List.of(ids));
    }
}
