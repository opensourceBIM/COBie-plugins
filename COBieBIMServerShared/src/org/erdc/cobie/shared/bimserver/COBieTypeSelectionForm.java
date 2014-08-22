package org.erdc.cobie.shared.bimserver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "COBieTypeSelectionForm")
public class COBieTypeSelectionForm
{
    @XmlElement
    public String poid;
    @XmlElement
    public String TypeName;
    @XmlElement
    public String TypeCreatedBy;
    @XmlElement
    public String TypeCategory;
    @XmlElement
    public String TypeAssetType;
    @XmlElement
    public String TypeDescription;
    @XmlElement
    public String TypeModelNumber;
    @XmlElement
    public String TypeReplacementCost;
    @XmlElement
    public String TypeExpectedLife;
    @XmlElement
    public String TypeWarrantyDurationParts;
    @XmlElement
    public String TypeWarrantyGuarantorParts;
    @XmlElement
    public String TypeWarrantyDurationLabor;
    @XmlElement
    public String TypeWarrantyGuarantorLabor;
    @XmlElement
    public String TypeWarrantyDescription;
    @XmlElement
    public String CreatedOn;
    @XmlElement
    public String TypeManufacturer;
    @XmlElement
    public String TypeExtIdentifier;
    @XmlElement
    public String TypeDurationUnit;
    @XmlElement
    public String TypeWarrantyDurationUnit;
    @XmlElement
    public String Document1Name;
    @XmlElement
    public String Document1RowName;
    @XmlElement
    public String Documen1tCategory;
    @XmlElement
    public String DocumentCreatedBy;
    @XmlElement
    public String DocumentCreatedOn;
    @XmlElement
    public String Stage;
    @XmlElement
    public String Document1Directory;
    @XmlElement
    public String Document2Name;
    @XmlElement
    public String Document2Category;
    @XmlElement
    public String Document2RowName;
    @XmlElement
    public String Document2Directory;
    @XmlElement
    public String FacilityName;
    @XmlElement
    public String TypeExtObject;

}
