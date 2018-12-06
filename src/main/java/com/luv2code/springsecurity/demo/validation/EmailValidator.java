package com.luv2code.springsecurity.demo.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 05.12.2018.
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String>{
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN="^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n"+
            "\t\t\t+ \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        if(email==null){
            return false;
        }
        matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
