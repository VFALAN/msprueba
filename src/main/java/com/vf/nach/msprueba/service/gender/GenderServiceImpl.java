package com.vf.nach.msprueba.service.gender;

import com.vf.nach.msprueba.model.entity.GenderEntity;
import com.vf.nach.msprueba.repository.IGenderRepository;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderServiceImpl implements IGenderService {
    @Autowired
    private IGenderRepository iGenderRepository;

    @Override
    public GenderEntity findById(Integer pId) throws MsPruebaException {
        Optional<GenderEntity> mOptionalGenderEntity = this.iGenderRepository.findById(pId);
        if (mOptionalGenderEntity.isPresent()) {
            return mOptionalGenderEntity.get();
        } else {
            throw new MsPruebaException("Gender no foud");
        }
    }
}
