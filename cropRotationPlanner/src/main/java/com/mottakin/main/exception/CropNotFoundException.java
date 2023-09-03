package com.mottakin.main.exception;

public class CropNotFoundException extends RuntimeException{
    private static final String MESSAGE = "There is no crop found against this ID";
    public CropNotFoundException()
    {
        super(MESSAGE);
    }
}
