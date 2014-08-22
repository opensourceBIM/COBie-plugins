package org.erdc.cobie.toolkit.tasks;

import java.util.HashMap;
import java.util.Map;

import nl.fountain.xelem.excel.Workbook;

import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.AssemblyTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.AttributeTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.ComponentTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.ConnectionTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.ContactTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.CoordinateTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.DocumentTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.FacilityTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.FloorTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.ImpactTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.IssueTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.JobTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.SpreadsheetMLTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.ResourceTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.SpaceTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.SpareTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.SpreadsheetParser;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.SystemTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.TypeTransformer;
import org.erdc.cobie.shared.spreadsheetml.transformation.cobietab.ZoneTransformer;
import org.erdc.cobie.shared.utility.COBieStringHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;

public class ThreadedSpreadsheetParser extends SpreadsheetParser
{


    private final DeserializeToCOBieSheetXMLDataTask task;
    private static Map<Class<?>, TaskStep> parserTaskSteps;
    {
        parserTaskSteps = new HashMap<Class<?>, TaskStep>();
        for (TaskStep taskStep : TaskStep.values())
        {
            Class<?> parserClass = null;
            switch (taskStep)
            {

                case Assembly:
                    parserClass = AssemblyTransformer.class;
                    break;
                case Attribute:
                    parserClass = AttributeTransformer.class;
                    break;
                case Component:
                    parserClass = ComponentTransformer.class;
                    break;
                case Connection:
                    parserClass = ConnectionTransformer.class;
                    break;
                case Contact:
                    parserClass = ContactTransformer.class;
                    break;
                case Coordinate:
                    parserClass = CoordinateTransformer.class;
                    break;
                case Document:
                    parserClass = DocumentTransformer.class;
                    break;
                case Facility:
                    parserClass = FacilityTransformer.class;
                    break;
                case Floor:
                    parserClass = FloorTransformer.class;
                    break;
                case Impact:
                    parserClass = ImpactTransformer.class;
                    break;

                case Issue:
                    parserClass = IssueTransformer.class;
                    break;
                case Job:
                    parserClass = JobTransformer.class;
                    break;
                case Resource:
                    parserClass = ResourceTransformer.class;
                    break;
                case Space:
                    parserClass = SpaceTransformer.class;
                    break;
                case Spare:
                    parserClass = SpareTransformer.class;
                    break;
                case System:
                    parserClass = SystemTransformer.class;
                    break;
                case Type:
                    parserClass = TypeTransformer.class;
                    break;
                case Zone:
                    parserClass = ZoneTransformer.class;
                    break;
                default:// no code needed
                    break;

            }
            if (parserClass != null)
            {
                parserTaskSteps.put(parserClass, taskStep);
            }
        }
    }

    public ThreadedSpreadsheetParser(Workbook workbook, COBIEType cobie, DeserializeToCOBieSheetXMLDataTask applicationTask)
    {
        this(workbook, cobie, new COBieStringHandler(), applicationTask);
    }
    
    public ThreadedSpreadsheetParser(Workbook workbook, COBIEType cobie, COBieStringHandler cobieStringHandler, DeserializeToCOBieSheetXMLDataTask applicationTask)
    {
        super(workbook, cobie, cobieStringHandler);
        this.task = applicationTask;
    }
    @Override
    public void parse()
    {          
        for(int i=0; i < getParsers().size(); i++)
        {
            SpreadsheetMLTransformer parser = getParsers().get(i);
            parser.transform();
            publish(parser);
        }
    }


    private void publish(SpreadsheetMLTransformer parser)
    {
        task.publish(parserTaskSteps.get(parser.getClass()));

    }

}
