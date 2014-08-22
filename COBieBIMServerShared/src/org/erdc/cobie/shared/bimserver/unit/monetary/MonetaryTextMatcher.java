package org.erdc.cobie.shared.bimserver.unit.monetary;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcCurrencyEnum;
import org.erdc.cobie.shared.bimserver.search.algorithm.StringDistanceCalculator;
import org.erdc.cobie.shared.bimserver.search.algorithm.StringDistanceCalculator.EditDistanceAlgorithmEnum;
import org.erdc.cobie.shared.unit.CurrencyUnit;

public class MonetaryTextMatcher
{
    private final StringDistanceCalculator.EditDistanceAlgorithmEnum distanceAlgorithm = EditDistanceAlgorithmEnum.Levenshtein;
    private final StringDistanceCalculator.EditDistanceAlgorithmEnum secondaryDistanceAlgorithm = EditDistanceAlgorithmEnum.OccurenceBased;
    private String bestKeywordMatch;
    private HashMap<IfcCurrencyEnum, String[]> currencyToKeywords;
    private HashMap<IfcCurrencyEnum, String> currencyToMatchedKeyword;
    private HashMap<IfcCurrencyEnum, Double> currencyToShortestKeywordSearchDistance;
    private boolean isInitialized;
    private IfcCurrencyEnum matchingCurrency;
    private double matchRank;
    private double bestMatchSecondaryDistance;

    private String searchString;

    public MonetaryTextMatcher(String searchString)
    {
        init(searchString);
        findMatch();
    }

    private void buildCurrencyKeywordMap()
    {
        for (IfcCurrencyEnum currencyLiteral : IfcCurrencyEnum.values())
        {
            switch (currencyLiteral)
            {
            	case AES: currencyToKeywords.put(IfcCurrencyEnum.AES, CurrencyUnit.AES.getMeasurable().getSynonymousNames()); break;
            	case AUD: currencyToKeywords.put(IfcCurrencyEnum.AUD, CurrencyUnit.AUD.getMeasurable().getSynonymousNames()); break;
            	case ATS: currencyToKeywords.put(IfcCurrencyEnum.ATS, CurrencyUnit.ATS.getMeasurable().getSynonymousNames()); break;
            	case BSD: currencyToKeywords.put(IfcCurrencyEnum.BSD, CurrencyUnit.BSD.getMeasurable().getSynonymousNames()); break;
            	case BHD: currencyToKeywords.put(IfcCurrencyEnum.BHD, CurrencyUnit.BHD.getMeasurable().getSynonymousNames()); break;
            	case BBD: currencyToKeywords.put(IfcCurrencyEnum.BBD, CurrencyUnit.BBD.getMeasurable().getSynonymousNames()); break;
            	case BEG: currencyToKeywords.put(IfcCurrencyEnum.BEG, CurrencyUnit.BEG.getMeasurable().getSynonymousNames()); break;
            	case BZD: currencyToKeywords.put(IfcCurrencyEnum.BZD, CurrencyUnit.BZD.getMeasurable().getSynonymousNames()); break;
            	case BMD: currencyToKeywords.put(IfcCurrencyEnum.BMD, CurrencyUnit.BMD.getMeasurable().getSynonymousNames()); break;
            	case BWP: currencyToKeywords.put(IfcCurrencyEnum.BWP, CurrencyUnit.BWP.getMeasurable().getSynonymousNames()); break;
            	case BRL: currencyToKeywords.put(IfcCurrencyEnum.BRL, CurrencyUnit.BRL.getMeasurable().getSynonymousNames()); break;
            	case BND: currencyToKeywords.put(IfcCurrencyEnum.BND, CurrencyUnit.BND.getMeasurable().getSynonymousNames()); break;
            	case BGL: currencyToKeywords.put(IfcCurrencyEnum.BGL, CurrencyUnit.BGL.getMeasurable().getSynonymousNames()); break;
            	case CAD: currencyToKeywords.put(IfcCurrencyEnum.CAD, CurrencyUnit.CAD.getMeasurable().getSynonymousNames()); break;
            	case CBD: currencyToKeywords.put(IfcCurrencyEnum.CBD, CurrencyUnit.CBD.getMeasurable().getSynonymousNames()); break;
            	case KYD: currencyToKeywords.put(IfcCurrencyEnum.KYD, CurrencyUnit.KYD.getMeasurable().getSynonymousNames()); break;
            	case CLP: currencyToKeywords.put(IfcCurrencyEnum.CLP, CurrencyUnit.CLP.getMeasurable().getSynonymousNames()); break;
            	case CNY: currencyToKeywords.put(IfcCurrencyEnum.CNY, CurrencyUnit.CNY.getMeasurable().getSynonymousNames()); break;
            	case CYS: currencyToKeywords.put(IfcCurrencyEnum.CYS, CurrencyUnit.CYS.getMeasurable().getSynonymousNames()); break;
            	case CZK: currencyToKeywords.put(IfcCurrencyEnum.CZK, CurrencyUnit.CZK.getMeasurable().getSynonymousNames()); break;
            	case DKK: currencyToKeywords.put(IfcCurrencyEnum.DKK, CurrencyUnit.DKK.getMeasurable().getSynonymousNames()); break;
            	case DDP: currencyToKeywords.put(IfcCurrencyEnum.DDP, CurrencyUnit.DDP.getMeasurable().getSynonymousNames()); break;
            	case EGL: currencyToKeywords.put(IfcCurrencyEnum.EGL, CurrencyUnit.EGL.getMeasurable().getSynonymousNames()); break;
            	case XEU: currencyToKeywords.put(IfcCurrencyEnum.XEU, CurrencyUnit.XEU.getMeasurable().getSynonymousNames()); break;
            	case EUR: currencyToKeywords.put(IfcCurrencyEnum.EUR, CurrencyUnit.EUR.getMeasurable().getSynonymousNames()); break;
            	case FKP: currencyToKeywords.put(IfcCurrencyEnum.FKP, CurrencyUnit.FKP.getMeasurable().getSynonymousNames()); break;
            	case FAK: currencyToKeywords.put(IfcCurrencyEnum.FAK, CurrencyUnit.FAK.getMeasurable().getSynonymousNames()); break;
            	case FJD: currencyToKeywords.put(IfcCurrencyEnum.FJD, CurrencyUnit.FJD.getMeasurable().getSynonymousNames()); break;
            	case FIM: currencyToKeywords.put(IfcCurrencyEnum.FIM, CurrencyUnit.FIM.getMeasurable().getSynonymousNames()); break;
            	case FRF: currencyToKeywords.put(IfcCurrencyEnum.FRF, CurrencyUnit.FRF.getMeasurable().getSynonymousNames()); break;
            	case GMD: currencyToKeywords.put(IfcCurrencyEnum.GMD, CurrencyUnit.GMD.getMeasurable().getSynonymousNames()); break;
            	case DEM: currencyToKeywords.put(IfcCurrencyEnum.DEM, CurrencyUnit.DEM.getMeasurable().getSynonymousNames()); break;
            	case GIP: currencyToKeywords.put(IfcCurrencyEnum.GIP, CurrencyUnit.GIP.getMeasurable().getSynonymousNames()); break;
            	case GRX: currencyToKeywords.put(IfcCurrencyEnum.GRX, CurrencyUnit.GRX.getMeasurable().getSynonymousNames()); break;
            	case HKD: currencyToKeywords.put(IfcCurrencyEnum.HKD, CurrencyUnit.HKD.getMeasurable().getSynonymousNames()); break;
            	case HUF: currencyToKeywords.put(IfcCurrencyEnum.HUF, CurrencyUnit.HUF.getMeasurable().getSynonymousNames()); break;
            	case ICK: currencyToKeywords.put(IfcCurrencyEnum.ICK, CurrencyUnit.ICK.getMeasurable().getSynonymousNames()); break;
            	case INR: currencyToKeywords.put(IfcCurrencyEnum.INR, CurrencyUnit.INR.getMeasurable().getSynonymousNames()); break;
            	case IDR: currencyToKeywords.put(IfcCurrencyEnum.IDR, CurrencyUnit.IDR.getMeasurable().getSynonymousNames()); break;
            	case IRP: currencyToKeywords.put(IfcCurrencyEnum.IRP, CurrencyUnit.IRP.getMeasurable().getSynonymousNames()); break;
            	case ILS: currencyToKeywords.put(IfcCurrencyEnum.ILS, CurrencyUnit.ILS.getMeasurable().getSynonymousNames()); break;
            	case ITL: currencyToKeywords.put(IfcCurrencyEnum.ITL, CurrencyUnit.ITL.getMeasurable().getSynonymousNames()); break;
            	case JMD: currencyToKeywords.put(IfcCurrencyEnum.JMD, CurrencyUnit.JMD.getMeasurable().getSynonymousNames()); break;
            	case JPY: currencyToKeywords.put(IfcCurrencyEnum.JPY, CurrencyUnit.JPY.getMeasurable().getSynonymousNames()); break;
            	case JOD: currencyToKeywords.put(IfcCurrencyEnum.JOD, CurrencyUnit.JOD.getMeasurable().getSynonymousNames()); break;
            	case KES: currencyToKeywords.put(IfcCurrencyEnum.KES, CurrencyUnit.KES.getMeasurable().getSynonymousNames()); break;
            	case KWD: currencyToKeywords.put(IfcCurrencyEnum.KWD, CurrencyUnit.KWD.getMeasurable().getSynonymousNames()); break;
            	case LUF: currencyToKeywords.put(IfcCurrencyEnum.LUF, CurrencyUnit.LUF.getMeasurable().getSynonymousNames()); break;
            	case MYR: currencyToKeywords.put(IfcCurrencyEnum.MYR, CurrencyUnit.MYR.getMeasurable().getSynonymousNames()); break;
            	case MTL: currencyToKeywords.put(IfcCurrencyEnum.MTL, CurrencyUnit.MTL.getMeasurable().getSynonymousNames()); break;
            	case MUR: currencyToKeywords.put(IfcCurrencyEnum.MUR, CurrencyUnit.MUR.getMeasurable().getSynonymousNames()); break;
            	case MXN: currencyToKeywords.put(IfcCurrencyEnum.MXN, CurrencyUnit.MXN.getMeasurable().getSynonymousNames()); break;
            	case NLG: currencyToKeywords.put(IfcCurrencyEnum.NLG, CurrencyUnit.NLG.getMeasurable().getSynonymousNames()); break;
            	case NZD: currencyToKeywords.put(IfcCurrencyEnum.NZD, CurrencyUnit.NZD.getMeasurable().getSynonymousNames()); break;
            	case NOK: currencyToKeywords.put(IfcCurrencyEnum.NOK, CurrencyUnit.NOK.getMeasurable().getSynonymousNames()); break;
            	case OMR: currencyToKeywords.put(IfcCurrencyEnum.OMR, CurrencyUnit.OMR.getMeasurable().getSynonymousNames()); break;
            	case PKR: currencyToKeywords.put(IfcCurrencyEnum.PKR, CurrencyUnit.PKR.getMeasurable().getSynonymousNames()); break;
            	case PGK: currencyToKeywords.put(IfcCurrencyEnum.PGK, CurrencyUnit.PGK.getMeasurable().getSynonymousNames()); break;
            	case PHP: currencyToKeywords.put(IfcCurrencyEnum.PHP, CurrencyUnit.PHP.getMeasurable().getSynonymousNames()); break;
            	case PLN: currencyToKeywords.put(IfcCurrencyEnum.PLN, CurrencyUnit.PLN.getMeasurable().getSynonymousNames()); break;
            	case PTN: currencyToKeywords.put(IfcCurrencyEnum.PTN, CurrencyUnit.PTN.getMeasurable().getSynonymousNames()); break;
            	case QAR: currencyToKeywords.put(IfcCurrencyEnum.QAR, CurrencyUnit.QAR.getMeasurable().getSynonymousNames()); break;
            	case KRW: currencyToKeywords.put(IfcCurrencyEnum.KRW, CurrencyUnit.KRW.getMeasurable().getSynonymousNames()); break;
            	case RUR: currencyToKeywords.put(IfcCurrencyEnum.RUR, CurrencyUnit.RUR.getMeasurable().getSynonymousNames()); break;
            	case SAR: currencyToKeywords.put(IfcCurrencyEnum.SAR, CurrencyUnit.SAR.getMeasurable().getSynonymousNames()); break;
            	case SCR: currencyToKeywords.put(IfcCurrencyEnum.SCR, CurrencyUnit.SCR.getMeasurable().getSynonymousNames()); break;
            	case SGD: currencyToKeywords.put(IfcCurrencyEnum.SGD, CurrencyUnit.SGD.getMeasurable().getSynonymousNames()); break;
            	case ZAR: currencyToKeywords.put(IfcCurrencyEnum.ZAR, CurrencyUnit.ZAR.getMeasurable().getSynonymousNames()); break;
            	case EST: currencyToKeywords.put(IfcCurrencyEnum.EST, CurrencyUnit.EST.getMeasurable().getSynonymousNames()); break;
            	case LKR: currencyToKeywords.put(IfcCurrencyEnum.LKR, CurrencyUnit.LKR.getMeasurable().getSynonymousNames()); break;
            	case SKP: currencyToKeywords.put(IfcCurrencyEnum.SKP, CurrencyUnit.SKP.getMeasurable().getSynonymousNames()); break;
            	case SEK: currencyToKeywords.put(IfcCurrencyEnum.SEK, CurrencyUnit.SEK.getMeasurable().getSynonymousNames()); break;
            	case CHF: currencyToKeywords.put(IfcCurrencyEnum.CHF, CurrencyUnit.CHF.getMeasurable().getSynonymousNames()); break;
            	case TWD: currencyToKeywords.put(IfcCurrencyEnum.TWD, CurrencyUnit.TWD.getMeasurable().getSynonymousNames()); break;
            	case THB: currencyToKeywords.put(IfcCurrencyEnum.THB, CurrencyUnit.THB.getMeasurable().getSynonymousNames()); break;
            	case TTD: currencyToKeywords.put(IfcCurrencyEnum.TTD, CurrencyUnit.TTD.getMeasurable().getSynonymousNames()); break;
            	case TRL: currencyToKeywords.put(IfcCurrencyEnum.TRL, CurrencyUnit.TRL.getMeasurable().getSynonymousNames()); break;
            	case AED: currencyToKeywords.put(IfcCurrencyEnum.AED, CurrencyUnit.AED.getMeasurable().getSynonymousNames()); break;
            	case GBP: currencyToKeywords.put(IfcCurrencyEnum.GBP, CurrencyUnit.GBP.getMeasurable().getSynonymousNames()); break;
            	case USD: currencyToKeywords.put(IfcCurrencyEnum.USD, CurrencyUnit.USD.getMeasurable().getSynonymousNames()); break;
            	case VEB: currencyToKeywords.put(IfcCurrencyEnum.VEB, CurrencyUnit.VEB.getMeasurable().getSynonymousNames()); break;
            	case VND: currencyToKeywords.put(IfcCurrencyEnum.VND, CurrencyUnit.VND.getMeasurable().getSynonymousNames()); break;
            	case ZWD: currencyToKeywords.put(IfcCurrencyEnum.ZWD, CurrencyUnit.ZWD.getMeasurable().getSynonymousNames()); break;
                default: break;
            }

        }

    }

    private void evaluateAgainstBestMatch(IfcCurrencyEnum currency, double localShortestDistance, String localMatchedKeyword)
    {
        if (localShortestDistance < getMatchRank())
        {
            setBestMatch(currency, localShortestDistance, localMatchedKeyword);

        } else if (localShortestDistance == getMatchRank())
        {
            double tmpSecondaryDistance = getSecondaryDistance(searchString, localMatchedKeyword);
            if (tmpSecondaryDistance < bestMatchSecondaryDistance)
            {
                setBestMatch(currency, localShortestDistance, localMatchedKeyword);
            }
        }
    }

    private void findMatch()
    {
        initializeSearchResults();
    }

    public String getBestKeywordMatch()
    {
        return bestKeywordMatch;
    }

    public HashMap<IfcCurrencyEnum, String[]> getCurrencyToKeywords()
    {
        return currencyToKeywords;
    }

    public HashMap<IfcCurrencyEnum, Double> getCurrencyToLevenshteinDistance()
    {
        return currencyToShortestKeywordSearchDistance;
    }

    public HashMap<IfcCurrencyEnum, String> getCurrencyToMatchedKeyword()
    {
        return currencyToMatchedKeyword;
    }

    public HashMap<IfcCurrencyEnum, Double> getCurrencyToShortestKeywordSearchDistance()
    {
        return currencyToShortestKeywordSearchDistance;
    }

    private double getDistance(String searchString, String keywordTarget)
    {
        return StringDistanceCalculator.getEditDistance(searchString, keywordTarget, distanceAlgorithm);
    }

    public IfcCurrencyEnum getMatchingCurrency()
    {
        return matchingCurrency;
    }

    public double getMatchRank()
    {
        return matchRank;
    }

    public String getSearchString()
    {
        return searchString;
    }

    private double getSecondaryDistance(String searchString, String keywordTarget)
    {
        return StringDistanceCalculator.getEditDistance(searchString, keywordTarget, secondaryDistanceAlgorithm);
    }

    private void init(String searchString)
    {
        setInitialized(false);
        setCurrencyToLevenshteinDistance(new HashMap<IfcCurrencyEnum, Double>());
        setCurrencyToKeywords(new HashMap<IfcCurrencyEnum, String[]>());
        setCurrencyToShortestKeywordSearchDistance(new HashMap<IfcCurrencyEnum, Double>());
        setCurrencyToMatchedKeyword(new HashMap<IfcCurrencyEnum, String>());
        buildCurrencyKeywordMap();
        setSearchString(searchString);
        setInitialized(true);
    }

    private void initializeSearchResults()
    {
        setMatchRank(Integer.MAX_VALUE);
        for (IfcCurrencyEnum currency : IfcCurrencyEnum.VALUES)
        {
            double tmpDistance = Integer.MAX_VALUE;
            double localShortestDistance = Integer.MAX_VALUE;
            String localMatchedKeyword = "";
            if (currencyToKeywords.containsKey(currency))
            {
                String[] keywords = getCurrencyToKeywords().get(currency);
                for (String keyword : keywords)
                {
                    tmpDistance = getDistance(searchString, keyword);
                    if (tmpDistance < localShortestDistance)
                    {
                        localShortestDistance = tmpDistance;
                        localMatchedKeyword = keyword;
                    }

                }
            }
            currencyToShortestKeywordSearchDistance.put(currency, localShortestDistance);
            currencyToMatchedKeyword.put(currency, localMatchedKeyword);
            evaluateAgainstBestMatch(currency, localShortestDistance, localMatchedKeyword);
        }
    }

    private void setBestKeywordMatch(String bestKeywordMatch)
    {
        this.bestKeywordMatch = bestKeywordMatch;
    }

    private void setBestMatch(IfcCurrencyEnum currency, double localShortestDistance, String localMatchedKeyword)
    {
        setMatchRank(localShortestDistance);
        setBestKeywordMatch(localMatchedKeyword);
        setMatchingCurrency(currency);
        setBestMatchSecondaryDistance(getSecondaryDistance(searchString, localMatchedKeyword));
    }

    private void setBestMatchSecondaryDistance(double bestMatchSecondaryDistance)
    {
        this.bestMatchSecondaryDistance = bestMatchSecondaryDistance;
    }

    public void setCurrencyToKeywords(HashMap<IfcCurrencyEnum, String[]> currencyToKeywords)
    {
        this.currencyToKeywords = currencyToKeywords;
        if (isInitialized)
        {
            findMatch();
        }
    }

    private void setCurrencyToLevenshteinDistance(HashMap<IfcCurrencyEnum, Double> currencyToLevenshteinDistance)
    {
        currencyToShortestKeywordSearchDistance = currencyToLevenshteinDistance;
    }

    private void setCurrencyToMatchedKeyword(HashMap<IfcCurrencyEnum, String> currencyToMatchedKeyword)
    {
        this.currencyToMatchedKeyword = currencyToMatchedKeyword;
    }

    private void setCurrencyToShortestKeywordSearchDistance(HashMap<IfcCurrencyEnum, Double> currencyToShortestKeywordSearchDistance)
    {
        this.currencyToShortestKeywordSearchDistance = currencyToShortestKeywordSearchDistance;
    }

    private void setInitialized(boolean isInitialized)
    {
        this.isInitialized = isInitialized;
    }

    private void setMatchingCurrency(IfcCurrencyEnum matchingCurrency)
    {
        this.matchingCurrency = matchingCurrency;
    }

    private void setMatchRank(double matchRank)
    {
        this.matchRank = matchRank;
    }

    public void setSearchString(String searchString)
    {
        this.searchString = searchString;
        if (isInitialized)
        {
            findMatch();
        }

    }

}
