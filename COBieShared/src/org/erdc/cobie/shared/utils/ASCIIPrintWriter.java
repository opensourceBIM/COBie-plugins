package org.erdc.cobie.shared.utils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.google.common.base.Charsets;

public class ASCIIPrintWriter extends PrintWriter
{
    public ASCIIPrintWriter(OutputStream out) 
    {
        super(new PrintWriter(new OutputStreamWriter(out, Charsets.US_ASCII)), false);
   
    }
}
