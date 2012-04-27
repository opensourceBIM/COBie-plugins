/*
 * Validator.java
 * Part of the Java API for the Schematron XML Schema Language.
 * http://www.ascc.net/xml/schematron/
 *
 * Copyright (c) 2000, 2001 Rick Jelliffe and 
 *                          Academia Sinica Computing Center, Taiwan
 * Copyright (c) 2001 Anna Hovhannisian, Oliver Becker,
 *                    Humboldt University of Berlin
 *
 * This software is provided 'as-is', without any express or implied 
 * warranty. In no event will the authors be held liable for any 
 * damages arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any 
 * purpose, including commercial applications, and to alter it and 
 * redistribute it freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you 
 * must not claim that you wrote the original software. If you use 
 * this software in a product, an acknowledgment in the product 
 * documentation would be appreciated but is not required.
 *
 * 2. Altered source versions must be plainly marked as such, and 
 * must not be misrepresented as being the original software.
 *
 * 3. This notice may not be removed or altered from any source 
 * distribution.
 */

package Schematron;

// TrAX classes
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * An object representing a single Schematron schema, used to validate
 * multiple XML instances.
 *
 * @version 0.1
 * @author Anna Hovhannisian, Oliver Becker
 */
public class Validator
{
  /** DOM representation of the generated validator */
  private DOMResult domValidator = null;
  /** generated xsl:messages from the preprocessor */
  private Vector warnings = new Vector();

  //
  // Constructors
  //

  /**
   * Constructs a new Validator object for a given Schematron schema
   * with a specified preprocessor.
   *
   * @param schema 
   *        The Schematron schema
   * @param preprocessor
   *        The preprocessor which generates the validating stylesheet
   */
  public Validator(Source schema, Source preprocessor) 
    throws TransformerException,
           TransformerConfigurationException,  
           ParserConfigurationException
  {
    init(schema, preprocessor, null);
  }


  /**
   * Constructs a new Validator object for a given Schematron schema
   * with a specified preprocessor and external parameters.
   *
   * @param schema 
   *        The Schematron schema
   * @param preprocessor
   *        The preprocessor which generates the validating stylesheet
   * @param params
   *        Global parameters for the preprocessor.
   *        (e.g. block, hiddenKey, phase)
   */
  public Validator(Source schema, Source preprocessor, 
                   Properties params)
    throws TransformerException,
           TransformerConfigurationException,  
           ParserConfigurationException
  {
    init(schema, preprocessor, params);
  }


  /**
   * Constructs a new Validator object for a given Schematron schema.
   *
   * @param schema 
   *        The Schematron schema
   */
  public Validator (Source schema)
    throws TransformerException,
           TransformerConfigurationException,  
           ParserConfigurationException
  {
    init(schema, resolveDefaultPreprocessor(), null);
  }


  /**
   * Constructs a new Validator object for a given Schematron schema
   * with external parameters for the default preprocessor.
   *
   * @param schema 
   *        The Schematron schema
   * @param params
   *        Global parameters for the preprocessor.
   *        (e.g. block, hiddenKey, phase)
   */
  public Validator (Source schema, Properties params)
    throws TransformerException,
           TransformerConfigurationException,  
           ParserConfigurationException
  {
    init(schema, resolveDefaultPreprocessor(), params);
  }



  //
  // helper methods for the constructors
  //

  /**
   * Initializes a new Validator object from the given Schematron
   * schema, the preprocessor and external parameters. This method
   * constructs a DOM instance of the validating stylesheet.
   *
   * @param schema 
   *        The Schematron schema
   * @param preprocessor
   *        The preprocessor which generates the validating stylesheet
   * @param params
   *        Global parameters for the preprocessor.
   */
  private void init(Source schema, Source preprocessor, 
                    Properties params)
    throws TransformerException,
           TransformerConfigurationException,  
           ParserConfigurationException
  {
    warnings = new Vector();
    TransformerFactory trfactory = TransformerFactory.newInstance();
    Transformer transformer = trfactory.newTransformer(preprocessor);
    Listener listener = new Listener();
    transformer.setErrorListener(listener);

    if (params != null) {
      Enumeration paramsEnum = params.propertyNames();
      while (paramsEnum.hasMoreElements()) {
        String name = paramsEnum.nextElement().toString();
        transformer.setParameter(name, params.getProperty(name));
      }
    }

    domValidator = new DOMResult();
    transformer.transform(schema, domValidator);
  }


  /** The standard schematron preprocessor */
  private static final String PREPROCESSOR = 
    "../COBiePlugins/lib/preprocessor.xslt";

  /**
   * Returns the default preprocessor which is included in the
   * classpath or the jar file resp.
   */
  private static Source resolveDefaultPreprocessor()
    throws TransformerException
  {
    java.net.URL url = Validator.class.getResource(PREPROCESSOR);
    if (url == null) {
      throw new TransformerException("Can't find preprocessor " +
                                     PREPROCESSOR);
    }
    return new javax.xml.transform.stream.StreamSource(url.toString());
  }



  //
  // public methods
  //

  /**
   * Performs validation of the passed xml data.
   *
   * @param xmlsrc The XML data to be validated.
   * @return A Result object which represents the result
   *         of the validation.
   */
  public Result validate(Source xmlsrc) 
    throws TransformerException,
           TransformerConfigurationException,  
           ParserConfigurationException
  {
    TransformerFactory trsfactory = TransformerFactory.newInstance();
    Transformer validator =
      trsfactory.newTransformer(new DOMSource(domValidator.getNode()));
    DOMResult result = new DOMResult();
    validator.transform(xmlsrc, result);

    return new Result(result);
  }


  /**
   * Returns the content of the title element of the Schematron
   * schema.
   * @return null if there's no such element
   */
  public String getTitle()
  {
    Element elem = (Element)domValidator.getNode().getFirstChild();
    NodeList nlist = elem.getElementsByTagName("TITLE");
    if (nlist.getLength() > 0) {
      return nlist.item(0).getFirstChild().getNodeValue();
    }
    else
      return null;
  }


  /**
   * The Listener class which catches xsl:messages during the
   * transformation of the Schematron schema.
   */
  private class Listener implements javax.xml.transform.ErrorListener
  {

    public void warning(TransformerException e) 
    {
      warnings.add(e.getMessage());
    }

    public void error(TransformerException e)
      throws TransformerException
    {
      throw e;
    }

    public void fatalError(TransformerException e)
      throws TransformerException
    {
      throw e;
    }
  }



  /**
   * Returns an array of generated xsl:messages which appeared while 
   * transforming the Schematron schema.
   */
  public String[] getWarnings()
  {
    int size = warnings.size();
    String[] ret = new String[size];

    for (int i=0; i<size; i++)
      ret[i] = (String)warnings.get(i);
  
    return ret;
  }

}
