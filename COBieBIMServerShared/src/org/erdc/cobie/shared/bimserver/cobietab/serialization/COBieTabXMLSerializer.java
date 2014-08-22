package org.erdc.cobie.shared.bimserver.cobietab.serialization;

/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.io.OutputStream;

import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.shared.bimserver.ifc.serialization.BIMServerCOBieTabSerializer;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.LoggerFactory;

/**
 * @author chrisbogen This serializer class generates a flattened XML data view
 *         of COBie that is independent of the typical spreadsheetML format.
 *         This class is a superclass of all serializers in the COBiePlugins
 *         project. The Coordinate, Issue, and Impact portions of the COBie
 *         document are not yet implemented.
 */
public class COBieTabXMLSerializer extends
		BIMServerCOBieTabSerializer
{
	{
		logger = LoggerFactory.getLogger(COBieTabXMLSerializer.class);
	}

	public COBieTabXMLSerializer()
	{
		this(null);
	}

	public COBieTabXMLSerializer(COBIEDocument cobie)
	{
		super(cobie);
		LoggerFactory.getLogger(COBieTabXMLSerializer.class);
	}

	@Override
	protected void writeCOBIE(OutputStream outputStream)
			throws SerializerException
	{
		try
		{
			getCOBieDocument().save(outputStream);
			outputStream.flush();
			outputStream.close();
		}
		catch (Exception e)
		{
			throw new SerializerException(e);
		}

	}

}
