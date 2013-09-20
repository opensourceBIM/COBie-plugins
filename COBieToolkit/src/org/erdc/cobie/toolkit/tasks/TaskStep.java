package org.erdc.cobie.toolkit.tasks;

public enum TaskStep
{        
    Assembly, 
    Attribute(8), 
    Component(4), 
    Connection, 
    Contact, 
    DerivingCOBieSheetXMLData, 
    Document, 
    Done, 
    Job, 
    Coordinate, 
    Spare, 
    Resource, 
    Facility, 
    Floor, 
    InitializeXLWorkbook, 
    ReadingIfc, 
    Impact, 
    Issue, 
    Space, 
    System, 
    Type, 
    Zone;
    
    private int progress;
    private String message;
    
    private TaskStep()
    {
        this("");
    }
    
    private TaskStep(int progress)
    {
        this(progress, "");
    }
    
    private TaskStep(String message)
    {
        this(4, message);
    }
    
    private TaskStep (int progress, String message)
    {
        this.progress = progress;
        this.message = message;
    }
    
    public int getProgress()
    {
        return progress;
    }
    
    public String getMessage()
    {
        return message;
    }


    
}