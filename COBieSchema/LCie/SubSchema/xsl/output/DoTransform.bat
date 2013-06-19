@echo off

AltovaXML /xslt2 "MappingMapTo230_01_ProductInspection.xslt" /in "../../../COBieLite/examples/ClinicHandover_COBieLite_RC3.xml" /out "../230_01_ProductInspection.xml" %*
IF ERRORLEVEL 1 EXIT/B %ERRORLEVEL%
