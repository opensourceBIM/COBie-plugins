@echo off

AltovaXML /xslt2 "MappingMapTo090_02_ProductTypeTemplate.xslt" /in "../../../COBieLite/examples/ClinicHandover_COBieLite_RC3.xml" /out "../090_02_ProductTypeTemplate.xml" %*
IF ERRORLEVEL 1 EXIT/B %ERRORLEVEL%
