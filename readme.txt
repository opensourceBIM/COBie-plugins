4/18/2013 - COBieToolkit Release 1.3 - BimServer Dependencies should be gathered from rev 2427 when building the plugins or toolkit

WHAT’S NEW?
NEW FEATURES
•	Updated to support export of COBieLite Release Candidate 2 xml files
•	COBie import accepts import of dates in a variety of string representations – previously only dates with format yyyy-mm-ddTHH:mm:ss were accepted
BUG FIXES
•	Various corrections to address changes in the COBie Responsibility Matrix(v16)
•	Unhandled Exceptions break COBie Import when a COBie worksheet is missing
•	Floor.extObject was not being set to “IfcSite” when IfcBuildingStorey.ObjectType=”Site” or “IfcSite”
•	Spare Key was incorrectly set to “Name” in the QC tools and has been updated to “Name, Category, TypeName”
•	QC reports crash when some columns are absent
•	Spreadsheet Row limit was bound by Excel 2003 limits.  Spreadsheet XML dependency (Xelem) was recompiled to accommodate Excel 2007 specs (1,048,576 rows)
KNOWN BUGS AND LIMITATIONS
•	The Impacts and Issues spreadsheets are not yet populated from IFC imports.
•	There are known compatibility issues with Java 7 JRE (or 1.7 JDK).  The application works best with a 64-bit version of Java 1.6 JRE or JDK 1.6.0.25 (or a higher 1.6 JDK revision).
•	There are known issues with the COBie Coordinate Import and Export that may result in incorrect geometry.  This issues may be addressed in a future release.
•	The COBie html reports (excluding the design and construction QC reports) have a minimal amount of formatting and may not be practical for large models.  The reports are provided as a baseline capability and spring-board for improvements.
•	The COBie Lite export does not include the Coordinates or Impacts worksheets.  However, the schema is designed to store 2D polygon definitions for Space boundaries.
•	The COBie Toolkit does not export all types of IfcProperty values that may be exported from an Ifc file into the COBie Attribute tab.  However, the supported property types have been robust enough to support the 2013 COBie challenge event and typically work for the most commonly encountered Ifc files.  These capabilities will be more robust in future bulds.

