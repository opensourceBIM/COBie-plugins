package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyAssignmentDocument;

public class AssetTypeAssemblyDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.AssemblyType, AssemblyAssignmentCollectionType, AssemblyType, AssetTypeInfoType>
{

    public AssetTypeAssemblyDispatcher(Iterable<org.nibs.cobie.tab.AssemblyType> childSourceElements, AssetTypeInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.AssemblyType, AssemblyType> createNewParser(
            org.nibs.cobie.tab.AssemblyType sourceElement,
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
