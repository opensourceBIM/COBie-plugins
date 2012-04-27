/*
 * Result.java
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * An object representing the result of a Schematron based validation.
 * <p>
 * A schematron.Result object can only be retrieved by a call to
 * {@link Validator#validate validate} on a {@link Validator} object.
 * @version 0.1
 * @author Anna Hovhannisian, Oliver Becker
 */
public class Result
{
  /** The root element of the constructed result DOM tree. */
  private Element root = null;

  //
  // Constructor
  //

  /** 
   * Constructs a new Result object - only accessible for classes 
   * inside of the schematron package.
   * Only a {@link Validator} object should construct new Result 
   * objects.
   */
  Result(javax.xml.transform.Result result)
  {
    DOMResult dres = (DOMResult)result;
    root = (Element)dres.getNode().getFirstChild();
  }



  //
  // Methods
  //

  /**
   * Get a node list of all messages (asserts and reports) for a 
   * given input element name.
   *
   * @param name name of the requested element
   * @return node list containing the messages for this element
   */
  public NodeList getAllMsgForElement(String name)
  {
    return root.getElementsByTagName(name);
  }


  /**
   * Get a node list of all report messages.
   *
   * @return node list of all &lt;REPORT&gt; nodes
   */
  public NodeList getAllReportMsgs()
  {
    return root.getElementsByTagName("REPORT");
  }


  /**
   * Get a node list of all assert messages.
   *
   * @return List of all &lt;ASSERT&gt; nodes
   */
  public NodeList getAllAssertMsgs()
  {
    return root.getElementsByTagName("ASSERT");
  }


  /**
   * Check if the validation succeeded without assert or report
   * messages.
   *
   * @return <code>true</code>, if the validation was successful,
   *         <code>false</code> otherwise.
   */
  public boolean isBlank()
  {
    if ((root.getElementsByTagName("ASSERT").getLength() == 0) &&
        (root.getElementsByTagName("REPORT").getLength() == 0) )
      return true;
    else
      return false;
  }


  /**
   * Returns the XML representation of the validation result.
   * This is for debugging purposes only.
   */
  public String getResultAsText() 
    throws TransformerException, 
           TransformerConfigurationException,
           ParserConfigurationException
  {
    Writer sw = new StringWriter();
    PrintWriter out = new PrintWriter(sw);

    TransformerFactory tfactory = TransformerFactory.newInstance();
    Transformer transformer = tfactory.newTransformer();
    Properties oprops = new Properties();
    oprops.put("method", "xml");
    oprops.put("indent", "yes");
    transformer.setOutputProperties(oprops);
    transformer.transform(new DOMSource(root), 
                          new StreamResult(out));
    out.close();

    return sw.toString();
  }
}
