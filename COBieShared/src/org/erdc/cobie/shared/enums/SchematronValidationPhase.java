package org.erdc.cobie.shared.enums;



import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.XdmAtomicValue;

public enum SchematronValidationPhase
{
    Design("Design"), Construction("Construction");
    private QName phaseParameterName = new QName("phase");
    private XdmAtomicValue phaseParameterValue;
    private QName titleParameterName = new QName("Title");
    private XdmAtomicValue titleParameterValue;
    private SchematronValidationPhase(String parameterValue)
    {
        this.phaseParameterValue = new XdmAtomicValue(parameterValue);
        this.setTitleParameterValue(new XdmAtomicValue(getReportTitle()));
    }
    
    public QName getSchematronPhaseParameterName()
    {
        return this.phaseParameterName;
    }
    
    public XdmAtomicValue getSchematronPhaseParameterValue()
    {
        return this.phaseParameterValue;
    }
    
    public String getReportTitle()
    {
        return "COBie QC report - " + getSchematronPhaseParameterValue().getStringValue() + " Deliverable";
    }

    public QName getTitleParameterName()
    {
        return titleParameterName;
    }

    public void setTitleParameterName(QName titleParameterName)
    {
        this.titleParameterName = titleParameterName;
    }

    public XdmAtomicValue getTitleParameterValue()
    {
        return titleParameterValue;
    }

    public void setTitleParameterValue(XdmAtomicValue titleParameterValue)
    {
        this.titleParameterValue = titleParameterValue;
    }
}
