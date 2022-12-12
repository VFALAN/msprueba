package com.vf.nach.msprueba.service.employeeworkedhour;

import com.vf.nach.msprueba.model.entity.EmployeeEntity;
import com.vf.nach.msprueba.model.entity.EmployeeWorkedHourEntity;
import com.vf.nach.msprueba.repository.IEmployeeWorkedHourRepository;
import com.vf.nach.msprueba.service.employee.IEmployeeService;
import com.vf.nach.msprueba.util.DateUtils;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeWorkedHourServiceImpl implements IEmployeeWorkedHourService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private IEmployeeWorkedHourRepository iEmployeeWorkedHourRepository;
    @Autowired
    private IEmployeeService iEmployeeService;

    @Override
    public EmployeeWorkedHourEntity findById(Integer pId) {
        return null;
    }

    @Override
    public Integer totalHoursWorked(Integer pId, Date startDate, Date endDate) throws MsPruebaException {
        EmployeeEntity mEmployeeEntity = this.iEmployeeService.findById(pId);
        CriteriaBuilder mCriteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = mCriteriaBuilder.createQuery(Integer.class);
        Root<EmployeeWorkedHourEntity> employeeWorkedHourEntityRoot = criteriaQuery.from(EmployeeWorkedHourEntity.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (DateUtils.validDates(startDate, endDate)) {
            predicateList.add(mCriteriaBuilder.equal(employeeWorkedHourEntityRoot.get("employee"), mEmployeeEntity));
            predicateList.add(mCriteriaBuilder.between(employeeWorkedHourEntityRoot.get("workedDate"), startDate, endDate));
            criteriaQuery.select(mCriteriaBuilder.sum(employeeWorkedHourEntityRoot.get("workedHours"))).where(predicateList.toArray(new Predicate[0]));
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        } else {
            throw new MsPruebaException("Dates are invalid");
        }
    }
}
