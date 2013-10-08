package org.erdc.cobie.sqlite.entities.relationships;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.entities.CRUDEntity;

public abstract class Relationship extends CRUDEntity
{
	public abstract Column<Integer> getChildKey();
	public abstract Column<Integer> getParentKey();
}
