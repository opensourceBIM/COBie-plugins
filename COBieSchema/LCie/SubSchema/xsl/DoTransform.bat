@echo off

AltovaXML /xslt2 "MappingMapTocobielite.xslt" /in "010_ProductTypeTemplate.xml" /out "../../../COBieLite/xsd/cobielite.xml" %*
IF ERRORLEVEL 1 EXIT/B %ERRORLEVEL%
