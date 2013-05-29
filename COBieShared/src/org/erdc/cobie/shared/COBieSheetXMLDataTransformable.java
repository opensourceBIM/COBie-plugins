package org.erdc.cobie.shared;

import java.io.File;

import org.erdc.cobie.sheetxmldata.COBIEDocument;

public interface COBieSheetXMLDataTransformable

{
    void transformCOBieSheetXMLData(COBIEDocument cobieDocument, File out) throws Exception;
}
