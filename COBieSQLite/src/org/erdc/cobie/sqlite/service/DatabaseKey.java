package org.erdc.cobie.sqlite.service;

public class DatabaseKey
{
    private static final long DEFAULT_INITIAL_KEY = Executor.ID_NONE;
    private long key = DEFAULT_INITIAL_KEY;
    
    public DatabaseKey()
    {
        this(DEFAULT_INITIAL_KEY);
    }
    
    public DatabaseKey(long initialKey)
    {
        key = initialKey;
    }
    
    public long get()
    {
        return key;
    }
    
    public long next()
    {
        return ++key;
    }
}
