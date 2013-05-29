package org.erdc.cobie.shared.merge;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQConstants;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

import org.bimserver.shared.cobie.generated.idm.COBieLifeCycleIDMType.IDMRuleset;
import org.bimserver.shared.cobie.generated.idm.FullRuleQueryType;
import org.bimserver.shared.cobie.generated.idm.ModelDomainType;
import org.bimserver.shared.cobie.generated.idm.RulesetOperationType;
import org.bimserver.shared.cobie.generated.merge.COBieMergeIDMDocument;
import org.bimserver.shared.cobie.generated.merge.COBieMergeIDMType;
import org.erdc.cobie.shared.COBIERowDictionary;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.w3c.dom.Node;

public class COBieMergeIDMItem extends COBieMergeItem<COBieMergeIDMDocument>
{

    private HashMap<String, ArrayList<String>> sheetNameToCobieRowId_IgnoreList;

    public COBieMergeIDMItem(COBIEDocument cobie, COBieMergeIDMDocument mergeIDMRules)
    {
        super(cobie, mergeIDMRules);
        init();
    }

    private void applyFullRuleQueryType(FullRuleQueryType query, RulesetOperationType.Enum defaultAction)
    {

        if (defaultAction == RulesetOperationType.EXCLUDE)
        {
            if (query.isSetRuleOperationOverride() && (query.getRuleOperationOverride() == RulesetOperationType.INCLUDE))
            {

            } else
            {
                executeExclusionRule(query);
            }
        } else if (defaultAction == RulesetOperationType.INCLUDE)
        {
            if (query.isSetRuleOperationOverride() && (query.getRuleOperationOverride() == RulesetOperationType.EXCLUDE))
            {
                executeExclusionRule(query);
            }
        }
    }

    private void applyIDMChangesToCOBieDocument() throws Exception
    {
        cobie = cobieSheetDictionary.asCOBie();
    }

    public void applyPreMergeRules()
    {
        COBieMergeIDMType mergeIDM = mergeRules.getCOBieMergeIDM();
        IDMRuleset ruleset = mergeIDM.getIDMRuleset();
        org.bimserver.shared.cobie.generated.idm.RulesetOperationType.Enum rulesetDefaultAction = ruleset.getRuleOperation();
        for (FullRuleQueryType query : ruleset.getCOBieXQueryArray())
        {
            applyFullRuleQueryType(query, rulesetDefaultAction);
        }
        try
        {
            applyIDMChangesToCOBieDocument();
        } catch (Exception e)
        {

        }

    }

    @Override
    public int compareTo(COBieMergeItem<COBieMergeIDMDocument> o)
    {
        int baseSortValue = getThisRulesetSortRank();
        int oSortValue = getRulesetSortRank(o);
        return baseSortValue - oSortValue;
    }

    private XQResultSequence evaluateCOBieIDMXQuery(String queryString) throws XQException
    {
        XQDataSource xDataSource = new SaxonXQDataSource();
        XQConnection conn = xDataSource.getConnection();
        XQPreparedExpression exp = conn.prepareExpression(queryString);
        exp.bindDocument(XQConstants.CONTEXT_ITEM, cobie.newXMLStreamReader(), conn.createDocumentType());
        XQResultSequence result = exp.executeQuery();
        return result;
        /*
         * while(result.next()) {
         * System.out.println(result.getItemAsString(null)); }
         */

    }

    private void executeExclusionRule(FullRuleQueryType query)
    {
        try
        {
            XQResultSequence queryResult = evaluateCOBieIDMXQuery(query.getStringValue());
            while (queryResult.next())
            {
                Node xmlNode = queryResult.getNode();
                COBIERowDictionary cobieRow = new COBIERowDictionary(xmlNode);
                String rowKey = cobieRow.getCOBieRowIdString();
                cobieSheetDictionary.get(cobieRow.getSheetName()).removeByCOBieRowIdString(rowKey);
            }
        } catch (XQException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private int getRulesetSortRank(COBieMergeItem<COBieMergeIDMDocument> o)
    {
        COBieMergeIDMType oIDMRules = o.getMergeRules().getCOBieMergeIDM();
        ModelDomainType.Enum oModelDomain = oIDMRules.getLifeCycleMetadata().getModelDomain();
        int oSortValue = oModelDomain.intValue();
        return oSortValue;
    }

    public ArrayList<String> getSheetIgnoreRowCOBieIds(String cobieSheetName)
    {
        ArrayList<String> cobieIds = new ArrayList<String>();
        cobieSheetDictionary.get(cobieSheetName);

        return cobieIds;
    }

    private int getThisRulesetSortRank()
    {
        return getRulesetSortRank(this);
    }

    private void init()
    {
        setSheetNameToCobieRowId_IgnoreList(new HashMap<String, ArrayList<String>>());
    }

    public HashMap<String, ArrayList<String>> getSheetNameToCobieRowId_IgnoreList()
    {
        return sheetNameToCobieRowId_IgnoreList;
    }

    public void setSheetNameToCobieRowId_IgnoreList(HashMap<String, ArrayList<String>> sheetNameToCobieRowId_IgnoreList)
    {
        this.sheetNameToCobieRowId_IgnoreList = sheetNameToCobieRowId_IgnoreList;
    }

}
