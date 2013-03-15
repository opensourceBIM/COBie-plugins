package org.erdc.cobie.utils.deserializer.modelhandlers;

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
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.OidProvider;
import org.eclipse.emf.ecore.EClass;

public class COBieOidProvider implements OidProvider<Long>
{

    IfcModelInterface model;

    public COBieOidProvider(IfcModelInterface modelInterface)
    {
        model = modelInterface;
    }

    @Override
    public Long newOid(EClass eClass)
    {
        // TODO Auto-generated method stub
        return model.size() + 1;
    }

}
