package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.nibs.cobie.tab.COBIEBaseType;

public class IssueDispatcher extends TypicalParserDispatcher<org.nibs.cobie.tab.IssueType, IssueCollectionType, IssueType, COBIEBaseType>
{
    public IssueDispatcher(Iterable<org.nibs.cobie.tab.IssueType> childSourceElements, COBIEBaseType targetParent,
            IndexedCOBie indexedCOBie, IssueCollectionType issues)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.IssueType, IssueType> createNewParser(
            org.nibs.cobie.tab.IssueType sourceElement,
            IssueType newTargetElement)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected IssueType createNewTargetElement()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected IssueCollectionType getTargetCollection()
    {
        // targetParent.
        // TODO Auto-generated method stub
        return null;
    }

}
