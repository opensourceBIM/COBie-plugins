package org.bimserver.shared.cobie;

import java.io.File;

import org.bimserver.cobie.cobielite.COBIEDocument;

public interface COBieLiteProducable
{
	COBIEDocument toCOBieLite(File incomingFile) throws Exception;
}
