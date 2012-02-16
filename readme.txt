Notes on BimServer COBie plugins 2/15/2012
OUTLINE
1.	 Introduction
2.	COBie Serializers
2.1.	COBie
2.2.	COBieCompliance
2.3.	COBieRoomDataSheet
2.4.	COBieSpatialDecompositionReport
3.	COBieDeserializer
4.	Notes
-------------------------------------------------------------------------------------
1.  Introduction
These plugins were developed to facilitate COBie information exchanges on BiMServer hosted IFC models.  These COBie plugins provide import (deserialize) and export (serialize) functionalities similar to those provided by bimServices by AEC3 - the asCOBie and fromCOBie xslt transformations served as the basis for defining import and export rules in these plugins.
As this is an on-going project, these plugins are provided with no warranty or gaurantee.  
Thos interested in learning more about COBie should visit
http://www.buildingsmartalliance.org/index.php/projects/cobie
2.  COBie Serializers
COBie serializers provide various export capabilities from BiMServer models.  The COBieLite XML serializer has a superclass which all other COBie serializers inherit.  
The COBieLite XML schema is a simplified data schema representing the tabs and columns of COBie spreadsheets.  In this schema the document root is "COBie" and its children include nodes such as "Contacts", "Facilities", "Floors", etc (plural COBie sheet names).  In the next level of the tree there are nodes with singular COBie sheet names, and these reprsent rows, e.g. COBie-->Facilities-->Facility or COBie-->Contacts-->Contact.  This serializer exports IFC data to the COBie lite data structures based on rules defined in the COBie responsibility matrix (see http://www.buildingsmartalliance.org/index.php/projects/cobie).  Impact, Issue, and Coordinate are not yet implemented.   
2.1. COBie
This serializer writes COBieLite data to a spreadsheetML formatted COBie document. This is perhaps the most common COBie artifact one may encounter.  The COBie file begins as a blank spreadsheet template provided in the COBiePlugins\lib folder and is populated based on field name matches.  
2.2  COBieCompliance
Generates an HTML report indicating the compliance of the underlying COBieLite data.  This report is produced via a chain of XSLT transformations.  First, a set of Schematron validation rules (COBiePlugins\lib\COBieRules.sch) is transformed into an XSLT document through the official Schematron SVRL for XSLT 2.0 stylesheet (COBiePlugins\lib\iso_svrl_for_xslt2.xsl).  The COBieRules.sch Schematron XML file was defined based on constraints identified in the COBie responsibility matrix (see http://www.buildingsmartalliance.org/index.php/projects/cobie).  
In the second step, the underlying COBieLite data is transformed to an Schematron Validation Report Language (SVRL) document via the XSL output of step 1.  The SVRL document provides a listing of failed assertions and other information about the results of the Schematron-based validation.
Finally, the SVRL XML document is transformed to a tabular HTML report via COBiePlugins\lib\SVRL_HTML.xsl
Currently this report only evaluates from the Contact worksheet to the System worksheet.  More rules are under development to cover the other COBie worksheets.
2.3  COBieRoomDataSheet
Provides an HTML report on Components grouped by Floor, Space, and Type.  Produces output based on COBiePlugins\lib\SpaceReport.xsl
2.4  COBieSpatialDecompositionReport
Provides an HTML report of spaces grouped by floor.  Produces output based on COBiePlugins\lib\SpatialDecompReport.xsl
3.  COBie Deserializer
Imports COBie spreadsheetML file and de-serializes it into IFC model entities.  When using this deserializer make sure that the target file is a spreadsheetML COBie file!  Others will not work and you will end up with an empty check-in or, in worst case, a broken check-in state.
The following COBie worksheets are currently included in the COBie Deserializer:
Contact, Facility, Floor, Space, Zone, Type, Component, System, Assembly, Connection, and Attribute.

4. Notes
•	When getting results that you do not expect, please consult the COBie responsibility matrix to determine relevant import/export rules.  Some types and components are excluded based on these rules – e.g. IfcMechanicalFastener may be in the model, but it is not included in the exported Component sheet
•	COBie sheets that include pluralized referential fields (e.g. Assembly.ChildNames, Zone.SpaceNames) are exported with one Parent/Child entry per row – this is the current preference.  However, if a COBie sheet is imported with comma-delimitted lists (e.g. Zone.SpaceNames=A10,A12,A31) they will be imported properly.  Because either format is allowed on import, one must be careful not to use commas in name fields.
•	MaterialLayers and MaterialLayerSets are included in Type and Assembly exports, but they are ignored on import.
•	When a field is null it is exported as “n/a” if it is a text field or 0 if it is a numerical field
•	In Attribute the ExternalId identifies the property set that holds the property.  The extObject is the name of the propertyset.  Hence, only properties contained in property sets are present in the current version of Attribute serializer.
•	Pick lists are not imported into the IFC model in the current COBie deserializer
•	These plugins were tested using the common COBie models (Duplex, Clinic, Office building) available at http://buildingsmartalliance.org/index.php/projects/commonbimfiles/  These tests were run with the following JVM settings:  4096m for Max Heap Size, 1024m for Max Perm Size, and 4096k for stack size.
