package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.ArrayList;

import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.nibs.cobie.tab.COBIEBaseType;

public abstract class ParentTransformer<TSource extends COBIEBaseType, TTarget extends CobieBaseType>
        extends ChildTransformer<TSource, TTarget>
{
    public ParentTransformer(TSource cobieSheetXMLData, TTarget cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    protected abstract ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers();

    protected abstract void parseChildLeaves();

    @Override
    protected void parseComplexElements()
    {
        parseChildLeaves();
        @SuppressWarnings("rawtypes")
        ArrayList<COBieLiteParserDispatcher> dispatchers = getChildParsingDispatchers();
        for (@SuppressWarnings("rawtypes") COBieLiteParserDispatcher dispatcher : dispatchers)
        {
            dispatcher.dispatchParsers();
        }
    }

}
