package org.erdc.cobie.toolkit.tasks;

import java.util.HashMap;
import java.util.Map;

import nl.fountain.xelem.excel.Workbook;

import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.AssemblyParser;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.AttributeParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.ComponentParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.ConnectionParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.ContactParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.CoordinateParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.DocumentParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.FacilityParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.FloorParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.ImpactParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.IssueParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.JobParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.Parser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.ResourceParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.SpaceParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.SpareParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.SpreadsheetParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.SystemParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.TypeParser;
import org.erdc.cobie.sheetxmldata.parsers.spreadsheetml.ZoneParser;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;

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
                    parserClass = AssemblyParser.class;
                    break;
                case Attribute:
                    parserClass = AttributeParser.class;
                    break;
                case Component:
                    parserClass = ComponentParser.class;
                    break;
                case Connection:
                    parserClass = ConnectionParser.class;
                    break;
                case Contact:
                    parserClass = ContactParser.class;
                    break;
                case Coordinate:
                    parserClass = CoordinateParser.class;
                    break;
                case Document:
                    parserClass = DocumentParser.class;
                    break;
                case Facility:
                    parserClass = FacilityParser.class;
                    break;
                case Floor:
                    parserClass = FloorParser.class;
                    break;
                case Impact:
                    parserClass = ImpactParser.class;
                    break;

                case Issue:
                    parserClass = IssueParser.class;
                    break;
                case Job:
                    parserClass = JobParser.class;
                    break;
                case Resource:
                    parserClass = ResourceParser.class;
                    break;
                case Space:
                    parserClass = SpaceParser.class;
                    break;
                case Spare:
                    parserClass = SpareParser.class;
                    break;
                case System:
                    parserClass = SystemParser.class;
                    break;
                case Type:
                    parserClass = TypeParser.class;
                    break;
                case Zone:
                    parserClass = ZoneParser.class;
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
            Parser parser = getParsers().get(i);
            parser.parse();
            publish(parser);
        }
    }


    private void publish(Parser parser)
    {
        task.publish(parserTaskSteps.get(parser.getClass()));

    }

}
