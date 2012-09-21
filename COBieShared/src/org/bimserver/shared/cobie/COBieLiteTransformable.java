package org.bimserver.shared.cobie;

import java.io.File;
import java.io.OutputStream;

import org.bimserver.cobie.cobielite.COBIEDocument;

public interface COBieLiteTransformable

{
	void transformCOBieLite(COBIEDocument cobieDocument,File out) throws Exception;
}
