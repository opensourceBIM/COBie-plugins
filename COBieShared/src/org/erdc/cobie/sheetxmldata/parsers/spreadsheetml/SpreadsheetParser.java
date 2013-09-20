package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.ArrayList;
import java.util.List;

import nl.fountain.xelem.excel.Workbook;

import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;

public class SpreadsheetParser
{
    private final Workbook workbook;
    private final COBIEType cobie;
    private List<Parser> parsers;
    private COBieStringHandler cobieStringWriter;
    public COBieStringHandler getCobieStringWriter()
    {
        return cobieStringWriter;
    }
    public void setCobieStringWriter(COBieStringHandler cobieStringWriter)
    {
        this.cobieStringWriter = cobieStringWriter;
    }
    public SpreadsheetParser(Workbook workbook, COBIEType cobie, COBieStringHandler cobieStringWriter)
    {
        this.workbook = workbook;
        this.cobie = cobie;
        setCobieStringWriter(cobieStringWriter);
        init();
    }
    public SpreadsheetParser(Workbook workbook, COBIEType cobie)
    {
        this(workbook, cobie, new COBieStringHandler());
    }

    public List<Parser> getParsers()
    {
        return parsers;
    }

    private void init()
    {
        parsers = new ArrayList<Parser>();

        ContactParser contactParser = new ContactParser(cobie, workbook, cobieStringWriter);
        parsers.add(contactParser);

        FacilityParser facilityParser = new FacilityParser(cobie, workbook, cobieStringWriter);
        parsers.add(facilityParser);

        FloorParser floorParser = new FloorParser(cobie, workbook, cobieStringWriter);
        parsers.add(floorParser);

        SpaceParser spaceParser = new SpaceParser(cobie, workbook, cobieStringWriter);
        parsers.add(spaceParser);

        ZoneParser zoneParser = new ZoneParser(cobie, workbook, cobieStringWriter);
        parsers.add(zoneParser);

        TypeParser typeParser = new TypeParser(cobie, workbook, cobieStringWriter);
        parsers.add(typeParser);

        ComponentParser componentParser = new ComponentParser(cobie, workbook, cobieStringWriter);
        parsers.add(componentParser);

        SystemParser systemParser = new SystemParser(cobie, workbook, cobieStringWriter);
        parsers.add(systemParser);

        AssemblyParser assemblyParser = new AssemblyParser(cobie, workbook, cobieStringWriter);
        parsers.add(assemblyParser);

        AttributeParser attributeParser = new AttributeParser(cobie, workbook, cobieStringWriter);
        parsers.add(attributeParser);

        ConnectionParser connectionParser = new ConnectionParser(cobie, workbook, cobieStringWriter);
        parsers.add(connectionParser);

        DocumentParser documentParser = new DocumentParser(cobie, workbook, cobieStringWriter);
        parsers.add(documentParser);

        CoordinateParser coordinateParser = new CoordinateParser(cobie, workbook, cobieStringWriter);
        parsers.add(coordinateParser);

        ImpactParser impactParser = new ImpactParser(cobie, workbook, cobieStringWriter);
        parsers.add(impactParser);

        IssueParser issueParser = new IssueParser(cobie, workbook, cobieStringWriter);
        parsers.add(issueParser);

        JobParser jobParser = new JobParser(cobie, workbook, cobieStringWriter);
        parsers.add(jobParser);

        ResourceParser resourceParser = new ResourceParser(cobie, workbook, cobieStringWriter);
        parsers.add(resourceParser);

        SpareParser spareParser = new SpareParser(cobie, workbook, cobieStringWriter);
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
