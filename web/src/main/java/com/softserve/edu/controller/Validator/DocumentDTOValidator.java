package com.softserve.edu.controller.Validator;

import com.softserve.edu.dto.DocumentDTO;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by oleg on 19.05.15.
 */
public class DocumentDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return DocumentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DocumentDTO documentDTO = new DocumentDTO();


    }

}
