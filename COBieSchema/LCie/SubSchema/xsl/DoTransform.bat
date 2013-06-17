@echo off

AltovaXML /xslt2 "MappingMapTo100_02_ProductTypeCandidate.xslt" /in "../../../COBieLite/examples/ClinicHandover_COBieLite_RC3.xml" /out "../100_02_ProductTypeCandidate.xml" %*
IF ERRORLEVEL 1 EXIT/B %ERRORLEVEL%
