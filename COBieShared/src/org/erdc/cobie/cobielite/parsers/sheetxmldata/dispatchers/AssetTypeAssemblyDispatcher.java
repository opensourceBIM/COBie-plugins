package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyAssignmentCollectionType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.AssemblyParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class AssetTypeAssemblyDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyAssignmentCollectionType, AssemblyType, AssetTypeInfoType>
{

    public AssetTypeAssemblyDispatcher(Iterable<org.erdc.cobie.sheetxmldata.AssemblyType> childSourceElements, AssetTypeInfoType targetParent,
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
        return (AssemblyType)targetCollection.addNewAssemblyAssignment();
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
