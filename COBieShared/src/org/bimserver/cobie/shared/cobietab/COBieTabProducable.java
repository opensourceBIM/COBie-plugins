package org.bimserver.cobie.shared.cobietab;

import java.io.File;

import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.nibs.cobie.tab.COBIEDocument;

public interface COBieTabProducable
{
    COBIEDocument toCOBieSheetXMLData(File incomingFile, COBieStringHandler stringHandler) throws Exception;
}
