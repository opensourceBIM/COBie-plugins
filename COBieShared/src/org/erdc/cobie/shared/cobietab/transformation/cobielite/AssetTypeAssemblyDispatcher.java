package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyAssignmentDocument;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class AssetTypeAssemblyDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyAssignmentCollectionType, AssemblyType, AssetTypeInfoType>
{

    public AssetTypeAssemblyDispatcher(Iterable<org.erdc.cobie.sheetxmldata.AssemblyType> childSourceElements, AssetTypeInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyType> createNewParser(
            org.erdc.cobie.sheetxmldata.AssemblyType sourceElement,
            AssemblyType newTargetElement)
    {
        return new AssemblyTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected AssemblyType createNewTargetElement()
    {
        return (AssemblyType)targetCollection.addNewAssemblyAssignment().substitute(AssemblyAssignmentDocument.type.getDocumentElementName(), AssemblyType.type);
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
