package org.erdc.cobie.shared.targetunits.monetary;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcCurrencyEnum;
import org.erdc.cobie.shared.searchalgorithms.StringDistanceCalculator;
import org.erdc.cobie.shared.searchalgorithms.StringDistanceCalculator.EditDistanceAlgorithmEnum;

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
                case AES:
                    currencyToKeywords.put(IfcCurrencyEnum.AES, new String[]
                    {
                            "Argentina", "Argentine peso", "AES", "Argentine pesos"
                    });
                    break;
                case AUD:
                    currencyToKeywords.put(IfcCurrencyEnum.AUD, new String[]
                    {
                            "Australia", "Australian dollar", "AUD", "Australian dollars"
                    });
                    break;
                case ATS:
                    currencyToKeywords.put(IfcCurrencyEnum.ATS, new String[]
                    {
                            "Austria", "European euro", "ATS", "European euros"
                    });
                    break;
                case BSD:
                    currencyToKeywords.put(IfcCurrencyEnum.BSD, new String[]
                    {
                            "Bahamas", "Bahamian dollar", "BSD", "Bahamian dollars"
                    });
                    break;
                case BHD:
                    currencyToKeywords.put(IfcCurrencyEnum.BHD, new String[]
                    {
                            "Bahrain", "Bahraini dinar", "BHD", "Bahraini dinars"
                    });
                    break;
                case BBD:
                    currencyToKeywords.put(IfcCurrencyEnum.BBD, new String[]
                    {
                            "Barbados", "Barbadian dollar", "BBD", "Barbadian dollars"
                    });
                    break;
                case BEG:
                    currencyToKeywords.put(IfcCurrencyEnum.BEG, new String[]
                    {
                            "Belgium", "European euro", "BEG", "European euros"
                    });
                    break;
                case BZD:
                    currencyToKeywords.put(IfcCurrencyEnum.BZD, new String[]
                    {
                            "Belize", "Belize dollar", "BZD", "Belize dollars"
                    });
                    break;
                case BMD:
                    currencyToKeywords.put(IfcCurrencyEnum.BMD, new String[]
                    {
                            "Bermuda", "BMD", "BMDs"
                    });
                    break;
                case BWP:
                    currencyToKeywords.put(IfcCurrencyEnum.BWP, new String[]
                    {
                            "Botswana", "Botswana pula", "BWP", "Botswana pulas"
                    });
                    break;
                case BRL:
                    currencyToKeywords.put(IfcCurrencyEnum.BRL, new String[]
                    {
                            "Brazil", "Brazilian real", "BRL", "Brazilian reals"
                    });
                    break;
                case BND:
                    currencyToKeywords.put(IfcCurrencyEnum.BND, new String[]
                    {
                            "Brunei", "Brunei dollar", "BND", "Brunei dollars"
                    });
                    break;
                case BGL:
                    currencyToKeywords.put(IfcCurrencyEnum.BGL, new String[]
                    {
                            "Bulgaria", "Bulgarian lev", "BGL", "Bulgarian levs"
                    });
                    break;
                case CAD:
                    currencyToKeywords.put(IfcCurrencyEnum.CAD, new String[]
                    {
                            "Canada", "Canadian dollar", "CAD", "Canadian dollars"
                    });
                    break;
                case CBD:
                    currencyToKeywords.put(IfcCurrencyEnum.CBD, new String[]
                    {
                            "Carribean", "CBD", "CBDs"
                    });
                    break;
                case KYD:
                    currencyToKeywords.put(IfcCurrencyEnum.KYD, new String[]
                    {
                            "Cayman Islands", "Cayman Islands dollar", "KYD", "Cayman Islands dollars"
                    });
                    break;
                case CLP:
                    currencyToKeywords.put(IfcCurrencyEnum.CLP, new String[]
                    {
                            "Chile", "Chilean peso", "CLP", "Chilean pesos"
                    });
                    break;
                case CNY:
                    currencyToKeywords.put(IfcCurrencyEnum.CNY, new String[]
                    {
                            "China", "Chinese renminbi", "CNY", "Chinese renminbis"
                    });
                    break;
                case CYS:
                    currencyToKeywords.put(IfcCurrencyEnum.CYS, new String[]
                    {
                            "Cyprus", "European euro", "CYS", "European euros"
                    });
                    break;
                case CZK:
                    currencyToKeywords.put(IfcCurrencyEnum.CZK, new String[]
                    {
                            "Czech Republic", "Czech koruna", "CZK", "Czech korunas"
                    });
                    break;
                case DKK:
                    currencyToKeywords.put(IfcCurrencyEnum.DKK, new String[]
                    {
                            "Denmark", "Danish krone", "DKK", "Danish krones"
                    });
                    break;
                case DDP:
                    currencyToKeywords.put(IfcCurrencyEnum.DDP, new String[]
                    {
                            "Dominican Republic", "Dominican peso", "DDP", "Dominican pesos"
                    });
                    break;
                case EGL:
                    currencyToKeywords.put(IfcCurrencyEnum.EGL, new String[]
                    {
                            "Egypt", "Egyptian pound", "EGL", "Egyptian pounds"
                    });
                    break;
                case XEU:
                    currencyToKeywords.put(IfcCurrencyEnum.XEU, new String[]
                    {
                            "Europe (States of the European Union)", "XEU", "XEUs"
                    });
                    break;
                case EUR:
                    currencyToKeywords.put(IfcCurrencyEnum.EUR, new String[]
                    {
                            "Europe currency", "EUR", "EURs"
                    });
                    break;
                case FKP:
                    currencyToKeywords.put(IfcCurrencyEnum.FKP, new String[]
                    {
                            "Falkland Islands", "Falkland Islands pound", "FKP", "Falkland Islands pounds"
                    });
                    break;
                case FAK:
                    currencyToKeywords.put(IfcCurrencyEnum.FAK, new String[]
                    {
                            "Faroe Islands", "FAK", "FAKs"
                    });
                    break;
                case FJD:
                    currencyToKeywords.put(IfcCurrencyEnum.FJD, new String[]
                    {
                            "Fiji", "Fijian dollar", "FJD", "Fijian dollars"
                    });
                    break;
                case FIM:
                    currencyToKeywords.put(IfcCurrencyEnum.FIM, new String[]
                    {
                            "Finland", "European euro", "FIM", "European euros"
                    });
                    break;
                case FRF:
                    currencyToKeywords.put(IfcCurrencyEnum.FRF, new String[]
                    {
                            "France", "European euro", "FRF", "European euros"
                    });
                    break;
                case GMD:
                    currencyToKeywords.put(IfcCurrencyEnum.GMD, new String[]
                    {
                            "Gambia", "Gambian dalasi", "GMD", "Gambian dalasis"
                    });
                    break;
                case DEM:
                    currencyToKeywords.put(IfcCurrencyEnum.DEM, new String[]
                    {
                            "Germany", "European euro", "DEM", "European euros"
                    });
                    break;
                case GIP:
                    currencyToKeywords.put(IfcCurrencyEnum.GIP, new String[]
                    {
                            "Gibraltar", "Gibraltar pound", "GIP", "Gibraltar pounds"
                    });
                    break;
                case GRX:
                    currencyToKeywords.put(IfcCurrencyEnum.GRX, new String[]
                    {
                            "Greece", "European euro", "GRX", "European euros"
                    });
                    break;
                case HKD:
                    currencyToKeywords.put(IfcCurrencyEnum.HKD, new String[]
                    {
                            "Hong Kong", "Hong Kong dollar", "HKD", "Hong Kong dollars"
                    });
                    break;
                case HUF:
                    currencyToKeywords.put(IfcCurrencyEnum.HUF, new String[]
                    {
                            "Hungary", "Hungarian forint", "HUF", "Hungarian forints"
                    });
                    break;
                case ICK:
                    currencyToKeywords.put(IfcCurrencyEnum.ICK, new String[]
                    {
                            "Iceland", "Icelandic króna", "ICK", "Icelandic krónas"
                    });
                    break;
                case INR:
                    currencyToKeywords.put(IfcCurrencyEnum.INR, new String[]
                    {
                            "India", "Indian rupee", "INR", "Indian rupees"
                    });
                    break;
                case IDR:
                    currencyToKeywords.put(IfcCurrencyEnum.IDR, new String[]
                    {
                            "Indonesia", "Indonesian rupiah", "IDR", "Indonesian rupiahs"
                    });
                    break;
                case IRP:
                    currencyToKeywords.put(IfcCurrencyEnum.IRP, new String[]
                    {
                            "Ireland", "European euro", "IRP", "European euros"
                    });
                    break;
                case ILS:
                    currencyToKeywords.put(IfcCurrencyEnum.ILS, new String[]
                    {
                            "Israel", "Israeli new sheqel", "ILS", "Israeli new sheqels"
                    });
                    break;
                case ITL:
                    currencyToKeywords.put(IfcCurrencyEnum.ITL, new String[]
                    {
                            "Italy", "European euro", "ITL", "European euros"
                    });
                    break;
                case JMD:
                    currencyToKeywords.put(IfcCurrencyEnum.JMD, new String[]
                    {
                            "Jamaica", "Jamaican dollar", "JMD", "Jamaican dollars"
                    });
                    break;
                case JPY:
                    currencyToKeywords.put(IfcCurrencyEnum.JPY, new String[]
                    {
                            "Japan", "Japanese yen", "JPY", "Japanese yens"
                    });
                    break;
                case JOD:
                    currencyToKeywords.put(IfcCurrencyEnum.JOD, new String[]
                    {
                            "Jordan", "Jordanian dinar", "JOD", "Jordanian dinars"
                    });
                    break;
                case KES:
                    currencyToKeywords.put(IfcCurrencyEnum.KES, new String[]
                    {
                            "Kenya", "Kenyan shilling", "KES", "Kenyan shillings"
                    });
                    break;
                case KWD:
                    currencyToKeywords.put(IfcCurrencyEnum.KWD, new String[]
                    {
                            "Kuwait", "Kuwaiti dinar", "KWD", "Kuwaiti dinars"
                    });
                    break;
                case LUF:
                    currencyToKeywords.put(IfcCurrencyEnum.LUF, new String[]
                    {
                            "Luxembourg", "European euro", "LUF", "European euros"
                    });
                    break;
                case MYR:
                    currencyToKeywords.put(IfcCurrencyEnum.MYR, new String[]
                    {
                            "Malaysia", "Malaysian ringgit", "MYR", "Malaysian ringgits"
                    });
                    break;
                case MTL:
                    currencyToKeywords.put(IfcCurrencyEnum.MTL, new String[]
                    {
                            "Malta", "European Euro", "MTL", "European Euros"
                    });
                    break;
                case MUR:
                    currencyToKeywords.put(IfcCurrencyEnum.MUR, new String[]
                    {
                            "Mauritius", "Mauritian rupee", "MUR", "Mauritian rupees"
                    });
                    break;
                case MXN:
                    currencyToKeywords.put(IfcCurrencyEnum.MXN, new String[]
                    {
                            "Mexico", "Mexican peso", "MXN", "Mexican pesos"
                    });
                    break;
                case NLG:
                    currencyToKeywords.put(IfcCurrencyEnum.NLG, new String[]
                    {
                            "Netherlands", "European euro", "NLG", "European euros"
                    });
                    break;
                case NZD:
                    currencyToKeywords.put(IfcCurrencyEnum.NZD, new String[]
                    {
                            "New Zealand", "New Zealand dollar", "NZD", "New Zealand dollars"
                    });
                    break;
                case NOK:
                    currencyToKeywords.put(IfcCurrencyEnum.NOK, new String[]
                    {
                            "Norway", "Norwegian krone", "NOK", "Norwegian krones"
                    });
                    break;
                case OMR:
                    currencyToKeywords.put(IfcCurrencyEnum.OMR, new String[]
                    {
                            "Oman", "Omani rial", "OMR", "Omani rials"
                    });
                    break;
                case PKR:
                    currencyToKeywords.put(IfcCurrencyEnum.PKR, new String[]
                    {
                            "Pakistan", "Pakistani rupee", "PKR", "Pakistani rupees"
                    });
                    break;
                case PGK:
                    currencyToKeywords.put(IfcCurrencyEnum.PGK, new String[]
                    {
                            "Papua New Guinea", "Papua New Guinean kina", "PGK", "Papua New Guinean kinas"
                    });
                    break;
                case PHP:
                    currencyToKeywords.put(IfcCurrencyEnum.PHP, new String[]
                    {
                            "Philipines", "PHP", "PHPs"
                    });
                    break;
                case PLN:
                    currencyToKeywords.put(IfcCurrencyEnum.PLN, new String[]
                    {
                            "Poland", "Polish zloty", "PLN", "Polish zlotys"
                    });
                    break;
                case PTN:
                    currencyToKeywords.put(IfcCurrencyEnum.PTN, new String[]
                    {
                            "Portugal", "European euro", "PTN", "European euros"
                    });
                    break;
                case QAR:
                    currencyToKeywords.put(IfcCurrencyEnum.QAR, new String[]
                    {
                            "Qatar", "Qatari riyal", "QAR", "Qatari riyals"
                    });
                    break;
                case KRW:
                    currencyToKeywords.put(IfcCurrencyEnum.KRW, new String[]
                    {
                            "Republic of Korea", "KRW", "KRWs"
                    });
                    break;
                case RUR:
                    currencyToKeywords.put(IfcCurrencyEnum.RUR, new String[]
                    {
                            "Russia", "Russian ruble", "RUR", "Russian rubles"
                    });
                    break;
                case SAR:
                    currencyToKeywords.put(IfcCurrencyEnum.SAR, new String[]
                    {
                            "Saudi Arabia", "Saudi riyal", "SAR", "Saudi riyals"
                    });
                    break;
                case SCR:
                    currencyToKeywords.put(IfcCurrencyEnum.SCR, new String[]
                    {
                            "Seychelles", "Seychellois rupee", "SCR", "Seychellois rupees"
                    });
                    break;
                case SGD:
                    currencyToKeywords.put(IfcCurrencyEnum.SGD, new String[]
                    {
                            "Singapore", "Singapore dollar>", "SGD", "Singapore dollar>s"
                    });
                    break;
                case ZAR:
                    currencyToKeywords.put(IfcCurrencyEnum.ZAR, new String[]
                    {
                            "South Africa", "South African rand", "ZAR", "South African rands"
                    });
                    break;
                case EST:
                    currencyToKeywords.put(IfcCurrencyEnum.EST, new String[]
                    {
                            "Spain", "European euro", "EST", "European euros"
                    });
                    break;
                case LKR:
                    currencyToKeywords.put(IfcCurrencyEnum.LKR, new String[]
                    {
                            "Sri Lanka", "Sri Lankan rupee", "LKR", "Sri Lankan rupees"
                    });
                    break;
                case SKP:
                    currencyToKeywords.put(IfcCurrencyEnum.SKP, new String[]
                    {
                            "St.Helena", "SKP", "SKPs"
                    });
                    break;
                case SEK:
                    currencyToKeywords.put(IfcCurrencyEnum.SEK, new String[]
                    {
                            "Sweden", "Swedish krona", "SEK", "Swedish kronas"
                    });
                    break;
                case CHF:
                    currencyToKeywords.put(IfcCurrencyEnum.CHF, new String[]
                    {
                            "Switzerland", "Swiss franc", "CHF", "Swiss francs"
                    });
                    break;
                case TWD:
                    currencyToKeywords.put(IfcCurrencyEnum.TWD, new String[]
                    {
                            "Taiwan", "New Taiwan dollar", "TWD", "New Taiwan dollars"
                    });
                    break;
                case THB:
                    currencyToKeywords.put(IfcCurrencyEnum.THB, new String[]
                    {
                            "Thailand", "Thai baht", "THB", "Thai bahts"
                    });
                    break;
                case TTD:
                    currencyToKeywords.put(IfcCurrencyEnum.TTD, new String[]
                    {
                            "Trinidad and Tobago", "Trinidad and Tobago dollar", "TTD", "Trinidad and Tobago dollars"
                    });
                    break;
                case TRL:
                    currencyToKeywords.put(IfcCurrencyEnum.TRL, new String[]
                    {
                            "Turkey", "Turkish new lira", "TRL", "Turkish new liras"
                    });
                    break;
                case AED:
                    currencyToKeywords.put(IfcCurrencyEnum.AED, new String[]
                    {
                            "United Arab Emirates", "UAE dirham", "AED", "UAE dirhams"
                    });
                    break;
                case GBP:
                    currencyToKeywords.put(IfcCurrencyEnum.GBP, new String[]
                    {
                            "United Kingdom", "British pound", "GBP", "British pounds", "pound", "pounds"
                    });
                    break;
                case USD:
                    currencyToKeywords.put(IfcCurrencyEnum.USD, new String[]
                    {
                            "United States of America", "United States dollar", "USD", "United States dollars", "dollar", "dollars"
                    });
                    break;
                case VEB:
                    currencyToKeywords.put(IfcCurrencyEnum.VEB, new String[]
                    {
                            "Venezuela", "Venezuelan bolivar", "VEB", "Venezuelan bolivars"
                    });
                    break;
                case VND:
                    currencyToKeywords.put(IfcCurrencyEnum.VND, new String[]
                    {
                            "Viet-Nam", "VND", "VNDs"
                    });
                    break;
                case ZWD:
                    currencyToKeywords.put(IfcCurrencyEnum.ZWD, new String[]
                    {
                            "Zimbabwe", "Zimbabwean dollar", "ZWD", "Zimbabwean dollars"
                    });
                    break;
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
