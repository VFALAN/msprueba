package com.vf.nach.msprueba.service.gender;

import com.vf.nach.msprueba.model.entity.GenderEntity;
import com.vf.nach.msprueba.util.exception.MsPruebaException;

public interface IGenderService {

    GenderEntity findById(Integer pId) throws MsPruebaException;
}
