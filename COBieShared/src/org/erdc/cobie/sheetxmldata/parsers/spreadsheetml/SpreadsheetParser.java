package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.ArrayList;
import java.util.List;

import nl.fountain.xelem.excel.Workbook;

import org.erdc.cobie.sheetxmldata.COBIEType;

public class SpreadsheetParser
{
    private final Workbook workbook;
    private final COBIEType cobie;
    private List<Parser> parsers;

    public SpreadsheetParser(Workbook workbook, COBIEType cobie)
    {
        this.workbook = workbook;
        this.cobie = cobie;
        init();
    }

    public List<Parser> getParsers()
    {
        return parsers;
    }

    private void init()
    {
        parsers = new ArrayList<Parser>();

        ContactParser contactParser = new ContactParser(cobie, workbook);
        parsers.add(contactParser);

        FacilityParser facilityParser = new FacilityParser(cobie, workbook);
        parsers.add(facilityParser);

        FloorParser floorParser = new FloorParser(cobie, workbook);
        parsers.add(floorParser);

        SpaceParser spaceParser = new SpaceParser(cobie, workbook);
        parsers.add(spaceParser);

        ZoneParser zoneParser = new ZoneParser(cobie, workbook);
        parsers.add(zoneParser);

        TypeParser typeParser = new TypeParser(cobie, workbook);
        parsers.add(typeParser);

        ComponentParser componentParser = new ComponentParser(cobie, workbook);
        parsers.add(componentParser);

        SystemParser systemParser = new SystemParser(cobie, workbook);
        parsers.add(systemParser);

        AssemblyParser assemblyParser = new AssemblyParser(cobie, workbook);
        parsers.add(assemblyParser);

        AttributeParser attributeParser = new AttributeParser(cobie, workbook);
        parsers.add(attributeParser);

        ConnectionParser connectionParser = new ConnectionParser(cobie, workbook);
        parsers.add(connectionParser);

        DocumentParser documentParser = new DocumentParser(cobie, workbook);
        parsers.add(documentParser);

        CoordinateParser coordinateParser = new CoordinateParser(cobie, workbook);
        parsers.add(coordinateParser);

        ImpactParser impactParser = new ImpactParser(cobie, workbook);
        parsers.add(impactParser);

        IssueParser issueParser = new IssueParser(cobie, workbook);
        parsers.add(issueParser);

        JobParser jobParser = new JobParser(cobie, workbook);
        parsers.add(jobParser);

        ResourceParser resourceParser = new ResourceParser(cobie, workbook);
        parsers.add(resourceParser);

        SpareParser spareParser = new SpareParser(cobie, workbook);
        parsers.add(spareParser);

    }

    public void parse()
    {
        for (Parser parser : parsers)
        {
            parser.parse();
        }
    }

}
