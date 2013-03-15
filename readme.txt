3-15-2013 

WHAT’S NEW?
NEW FEATURES
•	New COBieLite XML RC2 Export.  For more information about COBieLite XML visit: http://buildingsmartalliance.org/index.php/projects/cobielite/
•	jSon IFC export added
•	Single .jar distribution – previous distributions required additional directories
BUG FIXES
•	IFCINTEGER values were not being handled properly in Attribute export
•	Category column imports were not parsed correctly if a comma was part of the name token
•	Attribute units of measure were not populated with the default project units if no unit was assigned to the IfcProperty value
•	IfcReferenceValue, IfcCalendarDate representations of fields such as Component.WarrantyStartDate and Component.InstallationDate were not recognized
•	Incorrect string output of IfcDerivedUnit exponents in Attribute worksheet
•	COBie to IFC transformation incorrectly placed Space.UsableHeight in a COBie_Pset_Space property set instead of qto_SpaceBaseQuantities
•	Compare panel was not initializing file dialog with last directory imported/exported from/to
•	Various untracked bugs fixed during the months leading up to the January 2013 COBie Challenge event
KNOWN BUGS AND LIMITATIONS
•	The Impacts and Issues spreadsheets are not yet populated from IFC imports.
•	There are known compatibility issues with Java 7 JRE (or 1.7 JDK).  The application works best with a 64-bit version of Java 1.6 JRE or JDK 1.6.0.25 (or a higher 1.6 JDK revision).
•	There are known issues with the COBie Coordinate Import and Export that may result in incorrect geometry.  This issues may be addressed in a future release.
•	The COBie html reports (excluding the design and construction QC reports) have a minimal amount of formatting and may not be practical for large models.  The reports are provided as a baseline capability and spring-board for improvements.
•	The COBie Lite export does not include the Coordinates or Impacts worksheets.  However, the schema is designed to store 2D polygon definitions for Space boundaries.
•	The COBie Toolkit does not export all types of IfcProperty values that may be exported from an Ifc file into the COBie Attribute tab.  However, the supported property types have been robust enough to support the 2013 COBie challenge event and typically work for the most commonly encountered Ifc files.  These capabilities will be more robust in future bulds.
DISCLAIMERS
•	This software is provided with no warranty or technical support.  If you have special support needs then a consultation agreement may be arranged on an incident-by-incident basis.  Bug reporting is encouraged and will be considered, but bug fixes are not guaranteed.
•	COBieToolkit uses some of the BiMServer.org client libraries and plugins found in the BiMServer product.  The license under which the BIMserver.org software is released is a combination of Affero GPL, GPLv3 and/or LGPL (for binaries) from the GNU project. The different projects in our SVN repository are diffently licensed. More info on that can be found on their wiki.

COBie EXPORT FORMATS
The COBie exports are handled by BiMServer plugins maintained by the developers of the COBie Toolkit.  Descriptions of the supported COBie file exports are provided below.  
•	COBie Spreadsheet XML (2003)
This is the most common COBie artifact used by practitioners.  This file begins as a blank COBie spreadsheet with only the column headings, color codings, and Instructions tab populated.  All incoming data is transformed to COBie data structures that provide slots for the COBie spreadsheet columns.  Thus, a transformation to the COBie Spreadsheet XML format is the most straight-forward and usually the fastest of all export processes.
•	COBIE Lite RC2 (XML)
 COBie Lite is a new NIEM-conformant (National Information Exchange Model) XML format designed to support lightweight COBie information exchanges with Web Services.  This format utilizes nesting to represent the relationships between entities instead of using the Sheet Name/Row Name references in the spreadsheet XML format.  
Duplicate naming of cross-referenced entities may result in the translation of duplicate Attributes, Documents, and Issues.  Consider the following example: a COBie Type spreadsheet contains two rows with Name set to “Door Type A”, the Document spreadsheet contains a row with Name=Installation Guide, SheetName=Type and RowName=Door Type. The corresponding COBieLite document will contain two Asset Types with Name=Door Type A and each with a nested instance of the Installation Guide Document.  
In a few instances some of the features of the SpreadsheetXML format are not supported, e.g. Created By and Created On fields.   Also, some of the artifacts have different names, e.g. Components are now called Assets and Types are now called Asset Types.  These changes were performed to make the schema more accessible and less ambiguous to a wider audience of users.  For more information about COBieLite go to: http://buildingsmartalliance.org/index.php/projects/cobielite/
•	COBIE QC Reports
There are two COBie quality checking (QC) documents available:  1) COBie QC Report – Design Deliverable, and 2) COBie QC Report – Construction Deliverable.   These documents present a summary of various checks performed on the COBie data: e.g. at least one Component for each Type, unique names for Types, at least one Floor, etc.  These reports are delivered as .html documents and are produced using a chain of xml document transformations:  a)  quality checking ruleset file to .xslt file, b) transformation of imported cobie data to schematron validation report language (SVRL)  using the quality checking .xslt, and c) transformation of the SVRL results to formatted .html.
This is usually the slowest and most memory intensive export available in the toolkit where Steps b) and c) consuming the most substantial amount of time.  
•	Other COBIE html reports:  There are four other .html reports available that summarize the imported COBie data:
o	COBie Spatial Decomposition Report:  Summarizes the decomposition of Facility to Floors, and Spaces.
o	COBie Zone Report:  Summarizes the decomposition of Facility, Floors, Zones, and Spaces
o	COBie System Report:  Summarizes the decomposition of Systems to Components
o	COBie Room Data Sheet:  Summarizes Types and Components indexed by Floors and Spaces containing
These reports offer a modest amount of formatting and are provided as a baseline reporting capability and a starting point for improvements.
