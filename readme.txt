8/22/2014 

WHAT’S NEW?
NEW FEATURES
•	Various Refactoring
•	PluginJar for BimServer 1.3 included
KNOWN BUGS AND LIMITATIONS
•	The COBie Deserializer seems to be broken on BIMServer 1.3
•	The Impacts and Issues spreadsheets are not yet populated from IFC imports.
•	There are known issues with the COBie Coordinate Import and Export that may result in incorrect geometry.  This issues may be addressed in a future release.
•	The COBie html reports (excluding the design and construction QC reports) have a minimal amount of formatting and may not be practical for large models.  The reports are provided as a baseline capability and spring-board for improvements.
•	The COBie Lite export does not include the Coordinates or Impacts worksheets.
•	The COBie Toolkit does not export all types of IfcProperty values that may be exported from an Ifc file into the COBie Attribute tab.  However, the supported property types have been robust enough to support the 2013 COBie challenge event and typically work for the most commonly encountered Ifc files.  These capabilities will be more robust in future bulds.
•	Large models can be very memory intensive and users are encouraged to set Max Heap Size liberally (within the scope of available memory) when working with large files
