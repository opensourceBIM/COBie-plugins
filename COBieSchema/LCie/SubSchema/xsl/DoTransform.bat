@echo off

AltovaXML /xslt2 "MappingMapTo250_04_SystemOperation.xslt" /in "../../../COBieLite/examples/ClinicHandover_COBieLite_RC3.xml" /out "../250_04_SystemOperation.xml" %*
IF ERRORLEVEL 1 EXIT/B %ERRORLEVEL%
