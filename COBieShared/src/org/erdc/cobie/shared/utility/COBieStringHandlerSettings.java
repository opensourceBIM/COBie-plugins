package org.erdc.cobie.shared.utility;

public class COBieStringHandlerSettings
{
    public enum EmptyStringMode
    {
        REPLACE_WITH_NA, ALLOW;
    }
    
    public enum SpecialCharacterMode
    {
        REMOVE, ALLOW;
    }
    
    public enum TrailingDelimiterMode
    {
        REMOVE, ALLOW;
    }
    
    public enum InvalidDateTimeStringMode
    {
        SET_TO_CURRENT_DATETIME, SET_TO_MIN_DATETIME, SET_TO_NULL, SET_TO_TEXT;
    }
    private EmptyStringMode emptyStringMode;
    private SpecialCharacterMode specialCharacterMode;
    private TrailingDelimiterMode trailingDelimiterMode;
    private InvalidDateTimeStringMode invalidDateTimeStringMode;
    public EmptyStringMode getEmptyStringMode()
    {
        return emptyStringMode;
    }

    public void setEmptyStringMode(EmptyStringMode emptyStringMode)
    {
        this.emptyStringMode = emptyStringMode;
    
    }
    
    public COBieStringHandlerSettings(EmptyStringMode emptyStringMode, SpecialCharacterMode specialCharacterMode, TrailingDelimiterMode trailingDelimiterMode, InvalidDateTimeStringMode invalidDateTimeMode)
    {
        setEmptyStringMode(emptyStringMode);
        setSpecialCharacterMode(specialCharacterMode);
        setTrailingDelimiterMode(trailingDelimiterMode);
        setInvalidDateTimeStringMode(invalidDateTimeMode);
    }

    public SpecialCharacterMode getSpecialCharacterMode()
    {
        return specialCharacterMode;
    }

    public void setSpecialCharacterMode(SpecialCharacterMode specialCharacterMode)
    {
        this.specialCharacterMode = specialCharacterMode;
    }

    public TrailingDelimiterMode getTrailingDelimiterMode()
    {
        return trailingDelimiterMode;
    }

    public void setTrailingDelimiterMode(TrailingDelimiterMode trailingDelimiterMode)
    {
        this.trailingDelimiterMode = trailingDelimiterMode;
    }

    public InvalidDateTimeStringMode getInvalidDateTimeStringMode()
    {
        return invalidDateTimeStringMode;
    }

    public void setInvalidDateTimeStringMode(InvalidDateTimeStringMode invalidDateTimeStringMode)
    {
        this.invalidDateTimeStringMode = invalidDateTimeStringMode;
    }
}
