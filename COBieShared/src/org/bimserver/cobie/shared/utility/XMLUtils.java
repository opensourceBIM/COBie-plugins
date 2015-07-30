package org.bimserver.cobie.shared.utility;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtils
{


	@SuppressWarnings("unused")
	private static void saveWithNoNamespaces(XmlObject xml, OutputStream outputStream)
    {
        Node node = xml.getDomNode();
        switch(node.getNodeType())
        {
            case Node.ATTRIBUTE_NODE:
            {
                break;
            }
            
            case Node.ELEMENT_NODE:
            {
                break;
            }
            
            case Node.DOCUMENT_NODE:
            {
                break;
            }
            
            case Node.TEXT_NODE:
            {
                
            }
        }
    }
    
    private static boolean attributeIsRedundant(Node attribute)
    {
        boolean isRedundant = false;

        if (COBieUtility.isNA(attribute.getNodeValue()))
        {
            isRedundant = true;
        }

        return isRedundant;
    }

    private static boolean elementIsRedundant(Element element)
    {
        boolean isRedundant = false;
        if ((element.getChildNodes().getLength() == 1) && (element.getFirstChild().getNodeType() == Node.TEXT_NODE))
        {
            Node textChild = element.getFirstChild();
            if (COBieUtility.isNA(textChild.getNodeValue()))
            {
                isRedundant = true;
            }
        } else if (!element.hasChildNodes() && COBieUtility.isNA(element.getNodeValue()))
        {
            isRedundant = true;
        }

        return isRedundant;
    }

    private static boolean isRedundant(Node node)
    {
        boolean isRedundant = false;

        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            isRedundant = elementIsRedundant((Element)node);
        } else if (node.getNodeType() == Node.ATTRIBUTE_NODE)
        {
            isRedundant = attributeIsRedundant(node);
        }
        return isRedundant;

    }

    public static void removeEmptyChildElements(Element parentElement)
    {
        List<Node> toRemove = new LinkedList<Node>();

        removeRedundantAttributes(parentElement, toRemove);

        NodeList children = parentElement.getChildNodes();

        int childrenCount = children.getLength();
        for (int i = 0; i < childrenCount; ++i)
        {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element childElement = (Element)child;
                removeEmptyChildElements(childElement);
                if (isRedundant(childElement))
                {
                    toRemove.add(childElement);
                }
            }

        }

        for (Node childElement : toRemove)
        {
            if (childElement.getNodeType() == Node.ELEMENT_NODE)
            {
                parentElement.removeChild(childElement);
            } else if (childElement.getNodeType() == Node.ATTRIBUTE_NODE)
            {
                parentElement.removeAttribute(childElement.getNodeName());
            }
        }
        parentElement.normalize();
    }

    private static void removeRedundantAttributes(Element parentElement, List<Node> toRemove)
    {
        NamedNodeMap attributeMap = parentElement.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++)
        {
            Node attribute = attributeMap.item(i);
            if (isRedundant(attribute))
            {
                toRemove.add(attribute);
            }
        }

    }

    public XMLUtils()
    {
        // TODO Auto-generated constructor stub
    }
    
    public static void populateFixedValues(XmlObject root, Document document) throws ParserConfigurationException, SAXException, IOException, XmlException
    {
    	if (root != null)
    	{
    		SchemaType schemaType = root.schemaType();
        	if(schemaType.isSimpleType() && schemaType.getSimpleVariety() == SchemaType.ATOMIC && 
        			schemaType.getContainerField()!=null && 
        			schemaType.getContainerField().isFixed() &&
        			root.isNil())
        	{
        		root.getDomNode().setNodeValue(schemaType.getContainerField().getDefaultText());
        	}
        	else
        	{
        		LinkedHashMap<SchemaProperty, XmlObject[]> childMap = mapExistenceOfProperties(root, schemaType);
        		populateMissingFixedValues(root, document, childMap);
        	}
    	}
    }

	/**
	 * @param root
	 * @param document
	 * @param childMap
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws XmlException
	 */
	private static void populateMissingFixedValues(XmlObject root, Document document, LinkedHashMap<SchemaProperty, XmlObject[]> childMap) throws ParserConfigurationException, SAXException, IOException, XmlException
	{
		Node lastExistingNode = null;
		for(Entry<SchemaProperty, XmlObject[]> entry : childMap.entrySet())
		{
			SchemaProperty childProperty = entry.getKey();
			XmlObject[] children = entry.getValue();
			boolean exists = (children!=null & children.length>0);
			if(exists)
			{
				XmlObject[] existingChildren = root.selectChildren(childProperty.getName());
				lastExistingNode = existingChildren[existingChildren.length-1].getDomNode();
				for(XmlObject child : existingChildren)
				{
					populateFixedValues(child, document);
				}
			}
			else if(childProperty.getMinOccurs().longValue() > 0)
			{
				Element missingElement = document.createElementNS(childProperty.getName().getNamespaceURI(), childProperty.getName().getLocalPart());
				missingElement.appendChild(document.createTextNode(childProperty.getDefaultText()));
				
				if(lastExistingNode == null)
				{
					insertNodeBeforeFirstChild(root, missingElement);		
				}
				else if(lastExistingNode.getNodeType() == Node.ELEMENT_NODE)
				{
					insertNodeAfterLastExistingNode(root, lastExistingNode, missingElement);			
				}
				lastExistingNode = missingElement;
				XmlObject newXmlObject = root.selectChildren(childProperty.getName())[0];
				populateFixedValues(newXmlObject, document);
			}		
		}
	}

	/**
	 * @param root
	 * @param lastExistingNode
	 * @param missingElement
	 */
	private static void insertNodeAfterLastExistingNode(XmlObject root, Node lastExistingNode, Element missingElement)
	{
		Element lastExistingElement = (Element) lastExistingNode;
		
		if(lastExistingElement.getNextSibling() != null)
		{
			root.getDomNode().insertBefore(missingElement, lastExistingElement.getNextSibling());
		}
		else
		{
			root.getDomNode().appendChild(missingElement);
		}
	}

	/**
	 * @param root
	 * @param missingElement
	 */
	private static void insertNodeBeforeFirstChild(XmlObject root, Element missingElement)
	{
		if(root.getDomNode().hasChildNodes())
		{
			root.getDomNode().insertBefore(missingElement, root.getDomNode().getFirstChild());
		}
		else
		{
			root.getDomNode().appendChild(missingElement);
		}
	}

	/**
	 * @param root
	 * @param schemaType
	 * @return
	 */
	private static LinkedHashMap<SchemaProperty, XmlObject[]> mapExistenceOfProperties(XmlObject root, SchemaType schemaType)
	{
		LinkedHashMap<SchemaProperty, XmlObject[]> childMap = new LinkedHashMap<SchemaProperty, XmlObject[]>();
		for(SchemaProperty property : schemaType.getProperties())
		{
			XmlObject[] children = root.selectChildren(property.getName());
			childMap.put(property, children);
		}
		return childMap;
	}
}
