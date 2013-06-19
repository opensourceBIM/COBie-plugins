@echo off

AltovaXML /xslt2 "MappingMapTocobielite.xslt" /in "../../examples/2013-03-28_ClinicHandover_COBieLite.xml" /out "../cobielite.xml" %*
IF ERRORLEVEL 1 EXIT/B %ERRORLEVEL%
