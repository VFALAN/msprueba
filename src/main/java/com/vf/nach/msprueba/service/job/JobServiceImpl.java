package com.vf.nach.msprueba.service.job;

import com.vf.nach.msprueba.model.entity.JobEntity;
import com.vf.nach.msprueba.repository.IJobRepository;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private IJobRepository iJobRepository;

    @Override
    public JobEntity findById(Integer pId) throws MsPruebaException {
        Optional<JobEntity> mOptionalJobEntity = this.iJobRepository.findById(pId);
        if (mOptionalJobEntity.isPresent()) {
            return mOptionalJobEntity.get();
        } else {
            throw new MsPruebaException("Job not foud id: " + pId);
        }
    }
}
