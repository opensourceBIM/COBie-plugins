package org.bimserver.cobie.shared.cobietab;

import java.io.File;

import org.nibs.cobie.tab.COBIEDocument;

public interface COBieTabTransformable

{
    void transformCOBieSheetXMLData(COBIEDocument cobieDocument, File out) throws Exception;
}
