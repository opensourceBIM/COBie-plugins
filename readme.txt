5/28/2013 - COBieToolkit Release 1.3 - BimServer Dependencies should be gathered from rev 2547 when building the plugins or toolkit

WHAT’S NEW?
NEW FEATURES
•	Updated to be compatible with BiMServer 1.2 release (upcoming)

BUG FIXES
•	Fixed broken room data sheet, zone, spatial decomposition, and system reports

KNOWN BUGS AND LIMITATIONS
•	The Impacts and Issues spreadsheets are not yet populated from IFC imports.
•	The application works best with a 64-bit version of Java 1.7 JRE or JDK 1.7 (or a higher 1.7 JDK revision).
•	There are known issues with the COBie Coordinate Import and Export that may result in incorrect geometry.  This issues may be addressed in a future release.
•	The COBie html reports (excluding the design and construction QC reports) have a minimal amount of formatting and may not be practical for large models.  The reports are provided as a baseline capability and spring-board for improvements.
•	The COBie Lite export does not include the Coordinates or Impacts worksheets.  However, the schema is designed to store 2D polygon definitions for Space boundaries.
•	The COBie Toolkit does not export all types of IfcProperty values that may be exported from an Ifc file into the COBie Attribute tab.  However, the supported property types have been robust enough to support the 2013 COBie challenge event and typically work for the most commonly encountered Ifc files.  These capabilities will be more robust in future bulds.

