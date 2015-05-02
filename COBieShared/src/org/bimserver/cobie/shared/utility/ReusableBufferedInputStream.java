package org.bimserver.cobie.shared.utility;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReusableBufferedInputStream extends BufferedInputStream
{

	 private int totalUse;
	    private int used;

	    public ReusableBufferedInputStream(InputStream in, Integer totalUse)
	    {
	        super(in);
	        if (totalUse > 1)
	        {
	            super.mark(Integer.MAX_VALUE - 1);
	            this.totalUse = totalUse;
	            this.used = 1;
	        }
	        else
	        {
	            this.totalUse = 1;
	            this.used = 1;
	        }
	    }

	    @Override
	    public void close() throws IOException
	    {
	        if (used < totalUse)
	        {
	            super.reset();
	            ++used;
	        }
	        else
	        {
	            super.close();
	        }
	    }
	    
	    public void forceClose() throws IOException
	    {
	    	super.close();
	    }

}
