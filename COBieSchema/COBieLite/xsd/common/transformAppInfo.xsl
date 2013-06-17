<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
    xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
  <xsl:template match="xs:schema">

      <xsl:apply-templates/>

  </xsl:template>
  <xsl:template match="*">
<xsl:value-of select="*"/>
    <xsl:apply-templates/>
  </xsl:template>
  <xsl:template match="xs:annotation"/>
</xsl:stylesheet>