package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.AssemblyAssignmentCollectionType;
import org.erdc.cobie.cobielite.AssemblyType;
import org.erdc.cobie.cobielite.AssetInfoType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.AssemblyParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class AssetAssemblyDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyAssignmentCollectionType, AssemblyType, AssetInfoType>
{

    public AssetAssemblyDispatcher(Iterable<org.erdc.cobie.sheetxmldata.AssemblyType> childSourceElements, AssetInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyType> createNewParser(
            org.erdc.cobie.sheetxmldata.AssemblyType sourceElement,
            AssemblyType newTargetElement)
    {
        return new AssemblyParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected AssemblyType createNewTargetElement()
    {
        return targetCollection.addNewAssemblyAssignment();
    }

    @Override
    protected AssemblyAssignmentCollectionType getTargetCollection()
    {
        AssemblyAssignmentCollectionType assemblies = targetParent.getAssemblyAssignments();
        if (assemblies == null)
        {
            assemblies = targetParent.addNewAssemblyAssignments();
        }
        return assemblies;
    }

}
