9/20/2013 - COBieToolkit Release 1.4 - BimServer Dependencies should be gathered from rev 2547 when building the plugins or toolkit

WHAT’S NEW?
NEW FEATURES
•	Updated to work with Java 7
•	Updated checking reports to NBIMS v03 COBie ballot
•	Optimized checking reports
•	New SQLite Serializer (experimental)
•	COBieLite export updated for RC4 per the COBie NBIMS v03 ballot
BUG FIXES
•	CreatedOn values not being checked on COBie Import
•	Incorrect rule names in QC report
•	Room Data, Zone, System, and Spatial Decomposition reports were blank
KNOWN BUGS AND LIMITATIONS
•	The Impacts and Issues spreadsheets are not yet populated from IFC imports.
•	There are known issues with the COBie Coordinate Import and Export that may result in incorrect geometry.  This issues may be addressed in a future release.
•	The COBie html reports (excluding the design and construction QC reports) have a minimal amount of formatting and may not be practical for large models.  The reports are provided as a baseline capability and spring-board for improvements.
•	The COBie Lite export does not include the Coordinates or Impacts worksheets.
•	The COBie Toolkit does not export all types of IfcProperty values that may be exported from an Ifc file into the COBie Attribute tab.  However, the supported property types have been robust enough to support the 2013 COBie challenge event and typically work for the most commonly encountered Ifc files.  These capabilities will be more robust in future bulds.
•	Large models can be very memory intensive and users are encouraged to set Max Heap Size liberally (within the scope of available memory) when working with large files
