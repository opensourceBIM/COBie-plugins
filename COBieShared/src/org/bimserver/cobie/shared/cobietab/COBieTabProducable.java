package org.bimserver.cobie.shared.cobietab;

import java.io.File;

import org.nibs.cobie.tab.COBIEDocument;

public interface COBieTabProducable
{
    COBIEDocument toCOBieSheetXMLData(File incomingFile) throws Exception;
}
