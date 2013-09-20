package org.erdc.cobie.shared.sqlite.serializers;

public class IntegerKey
{
    private static final int DEFAULT_INITIAL_KEY = -1;
    private int key = DEFAULT_INITIAL_KEY;
    
    public IntegerKey()
    {
        this(DEFAULT_INITIAL_KEY);
    }
    
    public IntegerKey(int initialKey)
    {
        key = initialKey;
    }
    
    public int get()
    {
        return key;
    }
    
    public int next()
    {
        return ++key;
    }
}
