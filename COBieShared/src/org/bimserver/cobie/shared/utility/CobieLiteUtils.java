package org.bimserver.cobie.shared.utility;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType;

public final class CobieLiteUtils
{
	public static AttributeType castToCobieLite(org.buildingsmartalliance.docs.nbims03.lcie.core.AttributeType attributeType)
	{
		return (AttributeType)attributeType.changeType(AttributeType.type);
	}
	
	public static DocumentType castToCobieLite(org.buildingsmartalliance.docs.nbims03.lcie.core.DocumentType documentType)
	{
		return (DocumentType)documentType.changeType(DocumentType.type);
	}
}
