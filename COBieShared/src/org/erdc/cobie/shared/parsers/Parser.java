package org.erdc.cobie.shared.parsers;

public abstract class Parser<SOURCE, TARGET>
{
    protected final SOURCE sourceCOBie;
    protected TARGET targetCOBie;
    public TARGET getTargetCOBie()
    {
        return targetCOBie;
    }
    public void setTargetCOBie(TARGET targetCOBie)
    {
        this.targetCOBie = targetCOBie;
    }
    public SOURCE getSourceCOBie()
    {
        return sourceCOBie;
    }
    public Parser(SOURCE sourceCOBie, TARGET targetCOBie)
    {
        this.sourceCOBie = sourceCOBie;
        setTargetCOBie(targetCOBie);
        
    }
    public abstract TARGET parse();
    protected abstract void parseSimpleElements();
    protected abstract void parseComplexElements();    
}
