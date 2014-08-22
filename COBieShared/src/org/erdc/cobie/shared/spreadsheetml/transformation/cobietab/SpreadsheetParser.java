package org.erdc.cobie.shared.spreadsheetml.transformation.cobietab;

import java.util.ArrayList;
import java.util.List;

import nl.fountain.xelem.excel.Workbook;

import org.erdc.cobie.shared.utility.COBieStringHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;

public class SpreadsheetParser
{
    private final Workbook workbook;
    private final COBIEType cobie;
    private List<SpreadsheetMLTransformer> parsers;
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

    public List<SpreadsheetMLTransformer> getParsers()
    {
        return parsers;
    }

    private void init()
    {
        parsers = new ArrayList<SpreadsheetMLTransformer>();

        ContactTransformer contactParser = new ContactTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(contactParser);

        FacilityTransformer facilityParser = new FacilityTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(facilityParser);

        FloorTransformer floorParser = new FloorTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(floorParser);

        SpaceTransformer spaceParser = new SpaceTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(spaceParser);

        ZoneTransformer zoneParser = new ZoneTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(zoneParser);

        TypeTransformer typeParser = new TypeTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(typeParser);

        ComponentTransformer componentParser = new ComponentTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(componentParser);

        SystemTransformer systemParser = new SystemTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(systemParser);

        AssemblyTransformer assemblyParser = new AssemblyTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(assemblyParser);

        AttributeTransformer attributeParser = new AttributeTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(attributeParser);

        ConnectionTransformer connectionParser = new ConnectionTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(connectionParser);

        DocumentTransformer documentParser = new DocumentTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(documentParser);

        CoordinateTransformer coordinateParser = new CoordinateTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(coordinateParser);

        ImpactTransformer impactParser = new ImpactTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(impactParser);

        IssueTransformer issueParser = new IssueTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(issueParser);

        JobTransformer jobParser = new JobTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(jobParser);

        ResourceTransformer resourceParser = new ResourceTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(resourceParser);

        SpareTransformer spareParser = new SpareTransformer(cobie, workbook, cobieStringWriter);
        parsers.add(spareParser);

    }

    public void parse()
    {
        for (SpreadsheetMLTransformer parser : parsers)
        {
            parser.transform();
        }
    }

}
