package org.erdc.cobie.shared.utils;

import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.xmlbeans.XmlObject;
import org.erdc.cobie.shared.COBieUtility;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils
{

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

}
