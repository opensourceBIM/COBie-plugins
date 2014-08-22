package org.erdc.cobie.shared.transformation;

public abstract class Transformer<TSource, TTarget>
{
    protected final TSource source;
    protected TTarget target;
    
    public final TTarget getTarget()
    {
        return target;
    }
    
    public final void setTarget(TTarget targetCOBie)
    {
        this.target = targetCOBie;
    }
    
    public final TSource getSource()
    {
        return source;
    }
    
    public Transformer(TSource source, TTarget target)
    {
        this.source = source;
        setTarget(target);
        
    }
    
    public abstract TTarget transform();
     
}
