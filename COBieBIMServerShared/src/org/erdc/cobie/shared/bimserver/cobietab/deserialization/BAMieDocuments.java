package org.erdc.cobie.shared.bimserver.cobietab.deserialization;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.DocumentType;

public class BAMieDocuments
{
    private List<DocumentType> bamieDocuments;
    private final COBieIfcModel model;
    public BAMieDocuments(COBIEType.Documents documents, COBieIfcModel model)
    {
        this.model = model;
        for(DocumentType document : documents.getDocumentArray())
        {
            if(isDocumentBAMie(document))
            {
                bamieDocuments.add(document);
            }
        }
    }
    
    private boolean isDocumentBAMie(DocumentType document)
    {
        boolean isBAMie = false;
        String category = document.getCategory();
        String sheetName = document.getSheetName();
        String rowName = document.getRowName();
        ArrayList<String> bamieCategoryStrings = TypeDeserializer.getBAMieValuesFromCategoryDelimitedList(category);
        if ((bamieCategoryStrings.size() > 0)
                && (sheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Component.name()) && model.containsComponent(rowName)))
        {
            IfcProduct product = (IfcProduct) model.get(model.getComponentOid(rowName));
            for (IfcRelDefines definesBy : product.getIsDefinedBy())
            {
                if (definesBy instanceof IfcRelDefinesByType)
                {
                    IfcTypeObject relatingType = ((IfcRelDefinesByType)definesBy).getRelatingType();
                    if (TypeDeserializer.isTypeBAMie(relatingType))
                    {
                        isBAMie = true;
                    }
                }
            }
        }
        return isBAMie;
    }
    
    public List<DocumentType> getDocuments()
    {
        return bamieDocuments;
    }
}
