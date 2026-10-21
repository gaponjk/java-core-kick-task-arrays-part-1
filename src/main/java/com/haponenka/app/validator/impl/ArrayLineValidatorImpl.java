package com.haponenka.app.validator.impl;

import com.haponenka.app.validator.ArrayLineValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayLineValidatorImpl implements ArrayLineValidator {

    private static final Pattern VALID_PATTERN =
            Pattern.compile("^\\s*-?\\d+(\\s*[,;\\-\\s]\\s*-?\\d+)*\\s*$");

    public boolean isValid(String line) {
        if (line != null && !line.trim().isEmpty()) {
            Matcher matcher = VALID_PATTERN.matcher(line);
            return matcher.matches();
        }
        return false;
    }
}
