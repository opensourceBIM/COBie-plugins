package org.erdc.cobie.shared.bimserver;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;

public class ProjectQueryUtility
{
    public static final int UNASSIGNED_OID_VAL = -1;

    public static long getAnyRootProjectIdByName(String projectName, Bimsie1ServiceInterface service)
    {
        long poid = -1;
        try
        {
            List<SProject> projects = service.getAllProjects(true, true);
            for (SProject project : projects)
            {
                if (project.getName().equals(projectName))
                {
                    poid = project.getOid();
                }
            }
        } catch (ServerException e)
        {
            // TODO Auto-generated catch block

        } catch (UserException e)
        {
            // TODO Auto-generated catch block

        } catch (Exception e)
        {

        }

        return poid;
    }

    public static long getRootProjectIdByName(String projectName, Bimsie1ServiceInterface service) throws ServerException, UserException
    {
        ArrayList<Long> poids = new ArrayList<Long>();
        long returnPoid = UNASSIGNED_OID_VAL;
        List<SProject> matchingProjects = service.getProjectsByName(projectName);

        for (SProject project : matchingProjects)
        {
            if (project.getParentId() <= 0)
            {
                poids.add(project.getOid());
            }
        }
        if (poids.size() == 1)
        {
            returnPoid = poids.get(0);
        }
        return returnPoid;
    }

    public static long getSubprojectIdByParentIdAndSubprojectName(long parentOid, String subprojectName, Bimsie1ServiceInterface service)
            throws ServerException, UserException
    {
        long subProjectOid = UNASSIGNED_OID_VAL;
        ArrayList<Long> matchingSubProjectOids = new ArrayList<Long>();
        if (parentOid != UNASSIGNED_OID_VAL)
        {
            SProject parentProj = service.getProjectByPoid(parentOid);
            for (Long tmpSubProjOid : parentProj.getSubProjects())
            {
                SProject tmpSubProj = service.getProjectByPoid(tmpSubProjOid);
                if (tmpSubProj.getName().equals(subprojectName))
                {
                    matchingSubProjectOids.add(tmpSubProjOid);
                }
            }
            if (matchingSubProjectOids.size() == 1)
            {
                subProjectOid = matchingSubProjectOids.get(0);
            }
        }
        return subProjectOid;
    }

}
