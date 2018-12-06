package com.luv2code.springsecurity.demo.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by admin on 05.12.2018.
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch , Object>{
    private String fPass;
    private String sPass;
    private String message;


    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        fPass = constraintAnnotation.first();
        sPass = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        try
        {
            final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(fPass);
            final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(sPass);

            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // we can ignore
        }

        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(fPass)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
