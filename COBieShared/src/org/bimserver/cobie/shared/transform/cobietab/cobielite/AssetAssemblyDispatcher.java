package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyAssignmentDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyAssignmentCollectionType;

public class AssetAssemblyDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.AssemblyType, AssemblyAssignmentCollectionType, AssemblyType, AssetInfoType>
{

    public AssetAssemblyDispatcher(Iterable<org.nibs.cobie.tab.AssemblyType> childSourceElements, AssetInfoType targetParent,
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
