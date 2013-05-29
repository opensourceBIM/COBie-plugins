package org.erdc.cobie.shared.collections;

import java.util.HashMap;

public class NonCaseSensitiveHashMap<T> extends HashMap<String, T>
{
    /**
     * 
     */
    private static final long serialVersionUID = 3787383103504601472L;

    public T get(String key)
    {
        // TODO Auto-generated method stub
        return super.get(key.toLowerCase());
    }

    @Override
    public T put(String key, T value)
    {
        return super.put(key.toLowerCase(), value);
    }
 

}
