package com.vf.nach.msprueba.service.job;

import com.vf.nach.msprueba.model.entity.JobEntity;
import com.vf.nach.msprueba.util.exception.MsPruebaException;

public interface IJobService {

    JobEntity findById(Integer pId) throws MsPruebaException;

}
