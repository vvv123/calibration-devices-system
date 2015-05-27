package com.softserve.edu.service;

import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.repository.CalibratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CalibratorService {

    @Autowired
    private CalibratorRepository calibratorRepository;

    public void saveCalibrator(Calibrator calibrator) {
       // Address address = calibrator.getAddress();

        //Assert.isNull(address.getIndex(), "calibrator's index can't be null");
       // Assert.notNull(address.getFlat(), "calibrator can't have flat in address");
        calibratorRepository.save(calibrator);
    }

    public List<Calibrator> findByDistrict(String district) {
        return calibratorRepository.findByAddressDistrict(district);
    }
}
