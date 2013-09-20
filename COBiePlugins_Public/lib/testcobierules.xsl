<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet xmlns:cfn="http://docs.buildingsmartalliance.org/nbims03/cobie/schematron/functions" xmlns:iso="http://purl.oclc.org/dsdl/schematron" xmlns:saxon="http://saxon.sf.net/" xmlns:schold="http://www.ascc.net/xml/schematron" xmlns:xhtml="http://www.w3.org/1999/xhtml" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"><!--Implementers: please note that overriding process-prolog or process-root is 
    the preferred method for meta-stylesheets to use where possible. -->
<xsl:import href="COBieRules_Functions.xsl"/><xsl:param name="archiveDirParameter"/><xsl:param name="archiveNameParameter"/><xsl:param name="fileNameParameter"/><xsl:param name="fileDirParameter"/><xsl:variable name="document-uri">
		<xsl:value-of select="document-uri(/)"/>
	</xsl:variable>

<!--PHASES-->


<!--PROLOG-->
<xsl:output xmlns:svrl="http://purl.oclc.org/dsdl/svrl" method="xml" omit-xml-declaration="no" standalone="yes" indent="yes"/>

<!--XSD TYPES FOR XSLT2-->


<!--KEYS AND FUNCTIONS-->


<!--DEFAULT RULES-->


<!--MODE: SCHEMATRON-SELECT-FULL-PATH-->
<!--This mode can be used to generate an ugly though full XPath for locators-->
<xsl:template match="*" mode="schematron-select-full-path">
		<xsl:apply-templates select="." mode="schematron-get-full-path-3"/>
	</xsl:template>

<!--MODE: SCHEMATRON-FULL-PATH-->
<!--This mode can be used to generate an ugly though full XPath for locators-->
<xsl:template match="*" mode="schematron-get-full-path">
		<xsl:apply-templates select="parent::*" mode="schematron-get-full-path"/>
		<xsl:text>/</xsl:text>
		<xsl:choose>
			<xsl:when test="namespace-uri()=''">
				<xsl:value-of select="name()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text>*:</xsl:text>
				<xsl:value-of select="local-name()"/>
				<xsl:text>[namespace-uri()='</xsl:text>
				<xsl:value-of select="namespace-uri()"/>
				<xsl:text>']</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:variable name="preceding" select="count(preceding-sibling::*[local-name()=local-name(current())                                   and namespace-uri() = namespace-uri(current())])"/>
		<xsl:text>[</xsl:text>
		<xsl:value-of select="1+ $preceding"/>
		<xsl:text>]</xsl:text>
	</xsl:template><xsl:template match="@*" mode="schematron-get-full-path">
		<xsl:apply-templates select="parent::*" mode="schematron-get-full-path"/>
		<xsl:text>/</xsl:text>
		<xsl:choose>
			<xsl:when test="namespace-uri()=''">@<xsl:value-of select="name()"/></xsl:when>
			<xsl:otherwise>
				<xsl:text>@*[local-name()='</xsl:text>
				<xsl:value-of select="local-name()"/>
				<xsl:text>' and namespace-uri()='</xsl:text>
				<xsl:value-of select="namespace-uri()"/>
				<xsl:text>']</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

<!--MODE: SCHEMATRON-FULL-PATH-2-->
<!--This mode can be used to generate prefixed XPath for humans-->
<xsl:template match="node() | @*" mode="schematron-get-full-path-2">
		<xsl:for-each select="ancestor-or-self::*">
			<xsl:text>/</xsl:text>
			<xsl:value-of select="name(.)"/>
			<xsl:if test="preceding-sibling::*[name(.)=name(current())]">
				<xsl:text>[</xsl:text>
				<xsl:value-of select="count(preceding-sibling::*[name(.)=name(current())])+1"/>
				<xsl:text>]</xsl:text>
			</xsl:if>
		</xsl:for-each>
		<xsl:if test="not(self::*)"><xsl:text/>/@<xsl:value-of select="name(.)"/></xsl:if>
	</xsl:template><!--MODE: SCHEMATRON-FULL-PATH-3-->
<!--This mode can be used to generate prefixed XPath for humans 
	(Top-level element has index)-->
<xsl:template match="node() | @*" mode="schematron-get-full-path-3">
		<xsl:for-each select="ancestor-or-self::*">
			<xsl:text>/</xsl:text>
			<xsl:value-of select="name(.)"/>
			<xsl:if test="parent::*">
				<xsl:text>[</xsl:text>
				<xsl:value-of select="count(preceding-sibling::*[name(.)=name(current())])+1"/>
				<xsl:text>]</xsl:text>
			</xsl:if>
		</xsl:for-each>
		<xsl:if test="not(self::*)"><xsl:text/>/@<xsl:value-of select="name(.)"/></xsl:if>
	</xsl:template>

<!--MODE: GENERATE-ID-FROM-PATH -->
<xsl:template match="/" mode="generate-id-from-path"/><xsl:template match="text()" mode="generate-id-from-path">
		<xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
		<xsl:value-of select="concat('.text-', 1+count(preceding-sibling::text()), '-')"/>
	</xsl:template><xsl:template match="comment()" mode="generate-id-from-path">
		<xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
		<xsl:value-of select="concat('.comment-', 1+count(preceding-sibling::comment()), '-')"/>
	</xsl:template><xsl:template match="processing-instruction()" mode="generate-id-from-path">
		<xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
		<xsl:value-of select="concat('.processing-instruction-', 1+count(preceding-sibling::processing-instruction()), '-')"/>
	</xsl:template><xsl:template match="@*" mode="generate-id-from-path">
		<xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
		<xsl:value-of select="concat('.@', name())"/>
	</xsl:template><xsl:template match="*" mode="generate-id-from-path" priority="-0.5">
		<xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
		<xsl:text>.</xsl:text>
		<xsl:value-of select="concat('.',name(),'-',1+count(preceding-sibling::*[name()=name(current())]),'-')"/>
	</xsl:template>

<!--MODE: GENERATE-ID-2 -->
<xsl:template match="/" mode="generate-id-2">U</xsl:template><xsl:template match="*" mode="generate-id-2" priority="2">
		<xsl:text>U</xsl:text>
		<xsl:number level="multiple" count="*"/>
	</xsl:template><xsl:template match="node()" mode="generate-id-2">
		<xsl:text>U.</xsl:text>
		<xsl:number level="multiple" count="*"/>
		<xsl:text>n</xsl:text>
		<xsl:number count="node()"/>
	</xsl:template><xsl:template match="@*" mode="generate-id-2">
		<xsl:text>U.</xsl:text>
		<xsl:number level="multiple" count="*"/>
		<xsl:text>_</xsl:text>
		<xsl:value-of select="string-length(local-name(.))"/>
		<xsl:text>_</xsl:text>
		<xsl:value-of select="translate(name(),':','.')"/>
	</xsl:template><!--Strip characters--><xsl:template match="text()" priority="-1"/>

<!--SCHEMA SETUP-->
<xsl:template match="/">
		<svrl:schematron-output xmlns:svrl="http://purl.oclc.org/dsdl/svrl" title="COBie Validation Rules:  includes design and construction" schemaVersion="ISO19757-3">
			<xsl:attribute name="phase">Construction</xsl:attribute>
			<xsl:comment><xsl:value-of select="$archiveDirParameter"/>   
		 <xsl:value-of select="$archiveNameParameter"/>  
		 <xsl:value-of select="$fileNameParameter"/>  
		 <xsl:value-of select="$fileDirParameter"/></xsl:comment>
			<svrl:active-pattern>
				<xsl:attribute name="document">
					<xsl:value-of select="document-uri(/)"/>
				</xsl:attribute>
				<xsl:attribute name="id">COBieValidation.Information</xsl:attribute>
				<xsl:attribute name="name">Worksheet Counts</xsl:attribute>
				<xsl:apply-templates/>
			</svrl:active-pattern>
			<xsl:apply-templates select="/" mode="M3"/>
			<svrl:active-pattern>
				<xsl:attribute name="document">
					<xsl:value-of select="document-uri(/)"/>
				</xsl:attribute>
				<xsl:attribute name="id">Construction.COBieValidation.Errors</xsl:attribute>
				<xsl:attribute name="name">COBie Checking Rules</xsl:attribute>
				<xsl:apply-templates/>
			</svrl:active-pattern>
			<xsl:apply-templates select="/" mode="M4"/>
		</svrl:schematron-output>
	</xsl:template>

<!--SCHEMATRON PATTERNS-->
<svrl:text xmlns:svrl="http://purl.oclc.org/dsdl/svrl">COBie Validation Rules:  includes design and construction</svrl:text>

<!--PATTERN COBieValidation.InformationWorksheet Counts-->
<svrl:text xmlns:svrl="http://purl.oclc.org/dsdl/svrl">Worksheet Counts</svrl:text>

	<!--RULE COBie.Contacts-->
<xsl:template match="//Contacts" priority="1014" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Contacts" id="COBie.Contacts" role="WorksheetCount"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Counting Worksheet Rows</xsl:message>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="Contact"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Contact">
					<xsl:attribute name="id">Contacts.AtLeastOneContact</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:atLeastOneMessage('Contact','Contacts')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="Contact">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Contact">
				<xsl:attribute name="id">Contacts.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Contacts',count(Contact))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Facilities-->
<xsl:template match="//Facilities" priority="1013" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Facilities" id="COBie.Facilities" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Facility">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Facility">
				<xsl:attribute name="id">Facilities.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Facilities',count(Facility))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Floors-->
<xsl:template match="//Floors" priority="1012" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Floors" id="COBie.Floors" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Floor">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Floor">
				<xsl:attribute name="id">Floors.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Floors',count(Floor))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Spaces-->
<xsl:template match="//Spaces" priority="1011" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Spaces" id="COBie.Spaces" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Space">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Space">
				<xsl:attribute name="id">Spaces.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Spaces',count(Space))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Zones-->
<xsl:template match="//Zones" priority="1010" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Zones" id="COBie.Zones" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Zone">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Zone">
				<xsl:attribute name="id">Zones.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Zones',count(Zone))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Types-->
<xsl:template match="//Types" priority="1009" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Types" id="COBie.Types" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Type">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Type">
				<xsl:attribute name="id">Types.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Types',count(Type))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Components-->
<xsl:template match="//Components" priority="1008" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Components" id="COBie.Components" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Component">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Component">
				<xsl:attribute name="id">Components.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Components',count(Component))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Systems-->
<xsl:template match="//Systems" priority="1007" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Systems" id="COBie.Systems" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="System">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="System">
				<xsl:attribute name="id">Systems.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Systems',count(System))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Assemblies-->
<xsl:template match="//Assemblies" priority="1006" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Assemblies" id="COBie.Assemblies" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Assembly">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Assembly">
				<xsl:attribute name="id">Assemblies.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Assemblies',count(Assembly))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Connections-->
<xsl:template match="//Connections" priority="1005" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Connections" id="COBie.Connections" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Connection">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Connection">
				<xsl:attribute name="id">Connections.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Connections',count(Connection))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Spares-->
<xsl:template match="//Spares" priority="1004" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Spares" id="COBie.Spares" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Spare">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Spare">
				<xsl:attribute name="id">Spares.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Spares',count(Spare))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Resources-->
<xsl:template match="//Resources" priority="1003" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Resources" id="COBie.Resources" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Resource">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Resource">
				<xsl:attribute name="id">Resources.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Resources',count(Resource))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Jobs-->
<xsl:template match="//Jobs" priority="1002" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Jobs" id="COBie.Jobs" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Job">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Job">
				<xsl:attribute name="id">Jobs.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Jobs',count(Job))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Documents-->
<xsl:template match="//Documents" priority="1001" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Documents" id="COBie.Documents" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Document">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Document">
				<xsl:attribute name="id">Documents.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Documents',count(Document))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template>

	<!--RULE COBie.Attributes-->
<xsl:template match="//Attributes" priority="1000" mode="M3"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Attributes" id="COBie.Attributes" role="WorksheetCount"/>

		<!--REPORT -->
<xsl:if test="Attribute">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Attribute">
				<xsl:attribute name="id">Attributes.ReportNumberOf</xsl:attribute>
				<svrl:text>
					<xsl:text/>
					<xsl:value-of select="cfn:reportNumberOfMessage('Attributes',count(Attribute))"/>
					<xsl:text/>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/></xsl:template><xsl:template match="text()" priority="-1" mode="M3"/><xsl:template match="@*|node()" priority="-2" mode="M3">
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M3"/>
	</xsl:template>

<!--PATTERN Construction.COBieValidation.ErrorsCOBie Checking Rules-->
<svrl:text xmlns:svrl="http://purl.oclc.org/dsdl/svrl">COBie Checking Rules</svrl:text>

	<!--RULE COBie.Contacts-->
<xsl:template match="//Contacts" priority="1029" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Contacts" id="COBie.Contacts" role="WorksheetErrors"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Contact Worksheet</xsl:message>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Count.Check</xsl:attribute>
				<xsl:attribute name="flag">ContactSheet</xsl:attribute>
				<svrl:text>Contacts.AtLeastOneRowPresent
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="Contact"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Contact">
					<xsl:attribute name="id">Contacts.AtLeastOneRowPresent</xsl:attribute>
					<xsl:attribute name="flag">ContactSheet</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:atLeastOneMessage('Contact','Contacts')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Contacts.Contact-->
<xsl:template match="//Contacts/Contact" priority="1028" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Contacts/Contact" id="COBie.Contacts.Contact" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Email.Check</xsl:attribute>
				<xsl:attribute name="flag">Email</xsl:attribute>
				<svrl:text>Email.Unique, Email.NotNull, Email.Format
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Contact.Email.Unique</xsl:attribute>
					<xsl:attribute name="flag">Email</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Email)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Email)">
					<xsl:attribute name="id">Contact.Email.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Email</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validEmail(Email)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validEmail(Email)">
					<xsl:attribute name="id">Contact.Email.Format</xsl:attribute>
					<xsl:attribute name="flag">Email</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="cfn:assertMsgPrefix(name(.),Email,'Email')"/><xsl:text/> must be a valid e-mail format (XXX@YYY.ZZZ)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference, CreatedBy.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Contact.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Contact.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (ISO DateTime)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Contact.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Contact.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalSystem)">
					<xsl:attribute name="id">ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalObject)">
					<xsl:attribute name="id">Contact.ExternalObject.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalIdentifier</xsl:attribute>
				<svrl:text>ExternalIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalIdentifier)">
					<xsl:attribute name="id">Contact.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Contact.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Company.Check</xsl:attribute>
				<xsl:attribute name="flag">Company</xsl:attribute>
				<svrl:text>Company.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Company)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Company)">
					<xsl:attribute name="id">Contact.Company.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Company</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="cfn:assertMsgPrefix(name(.),Email,'Company')"/><xsl:text/>  must be provided (n/a is not acceptable)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Phone.Check</xsl:attribute>
				<xsl:attribute name="flag">Phone</xsl:attribute>
				<svrl:text>Phone.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Phone)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Phone)">
					<xsl:attribute name="id">Contact.Phone.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Phone</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Phone')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Department.Check</xsl:attribute>
				<xsl:attribute name="flag">Department</xsl:attribute>
				<svrl:text>Department.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Department)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Department)">
					<xsl:attribute name="id">Contact.Department.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Department</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Department')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.OrganizationCode.Check</xsl:attribute>
				<xsl:attribute name="flag">OrganizationCode</xsl:attribute>
				<svrl:text>OrganizationCode.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(OrganizationCode)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(OrganizationCode)">
					<xsl:attribute name="id">Contact.OrganizationCode.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">OrganizationCode</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'OrganizationCode')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.GivenName.Check</xsl:attribute>
				<xsl:attribute name="flag">GivenName</xsl:attribute>
				<svrl:text>GivenName.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(GivenName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(GivenName)">
					<xsl:attribute name="id">Contact.GivenName.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">GivenName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'GivenName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.FamilyName.Check</xsl:attribute>
				<xsl:attribute name="flag">FamilyName</xsl:attribute>
				<svrl:text>FamilyName.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(FamilyName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(FamilyName)">
					<xsl:attribute name="id">Contact.FamilyName.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">FamilyName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'FamilyName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Street.Check</xsl:attribute>
				<xsl:attribute name="flag">Street</xsl:attribute>
				<svrl:text>Street.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Street)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Street)">
					<xsl:attribute name="id">Contact.Street.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Street</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Street')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.PostalBox.Check</xsl:attribute>
				<xsl:attribute name="flag">PostalBox</xsl:attribute>
				<svrl:text>PostalBox.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(PostalBox)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(PostalBox)">
					<xsl:attribute name="id">Contact.PostalBox.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">PostalBox</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'PostalBox')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Town.Check</xsl:attribute>
				<xsl:attribute name="flag">Town</xsl:attribute>
				<svrl:text>Town.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Town)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Town)">
					<xsl:attribute name="id">Contact.Town.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Town</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Town')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.StateRegion.Check</xsl:attribute>
				<xsl:attribute name="flag">StateRegion</xsl:attribute>
				<svrl:text>StateRegion.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(StateRegion)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(StateRegion)">
					<xsl:attribute name="id">Contact.StateRegion.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">StateRegion</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'StateRegion')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.PostalCode.Check</xsl:attribute>
				<xsl:attribute name="flag">PostalCode</xsl:attribute>
				<svrl:text>PostalCode.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(PostalCode)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(PostalCode)">
					<xsl:attribute name="id">Contact.PostalCode.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">PostalCode</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'PostalCode')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Contact.Country.Check</xsl:attribute>
				<xsl:attribute name="flag">Country</xsl:attribute>
				<svrl:text>Country.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Country)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Country)">
					<xsl:attribute name="id">Contact.Country.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Country</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Country')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Facilities-->
<xsl:template match="//Facilities" priority="1027" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Facilities" id="COBie.Facilities" role="WorksheetErrors"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Facility Worksheet</xsl:message>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facilities.AtLeastOne.Check</xsl:attribute>
				<xsl:attribute name="flag">FacilitySheet</xsl:attribute>
				<svrl:text>Facilities.OneAndOnlyOneFacilityFound
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="count(Facility)=1"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="count(Facility)=1">
					<xsl:attribute name="id">Facilites.OneAndOnlyOneFacilityFound</xsl:attribute>
					<xsl:attribute name="flag">FacilitySheet</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:onlyOneMessage('Facility','Facilities')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Facilities.Facility-->
<xsl:template match="//Facilities/Facility" priority="1026" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Facilities/Facility" id="COBie.Facilities.Facility" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNotNull, Name.Unique<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Common.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Common.Name.Unique</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ProjectName.Check</xsl:attribute>
				<xsl:attribute name="flag">ProjectName</xsl:attribute>
				<svrl:text>ProjectName.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(ProjectName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(ProjectName)">
					<xsl:attribute name="id">Facility.ProjectName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">ProjectName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'ProjectName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.SiteName.Check</xsl:attribute>
				<xsl:attribute name="flag">SiteName</xsl:attribute>
				<svrl:text>SiteName.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(SiteName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(SiteName)">
					<xsl:attribute name="id">Facility.SiteName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">SiteName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'SiteName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.LinearUnits.Check</xsl:attribute>
				<xsl:attribute name="flag">LinearUnits</xsl:attribute>
				<svrl:text>LinearUnits.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(LinearUnits)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(LinearUnits)">
					<xsl:attribute name="id">Facility.LinearUnits.NotNull</xsl:attribute>
					<xsl:attribute name="flag">LinearUnits</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'LinearUnits')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.AreaUnits.Check</xsl:attribute>
				<xsl:attribute name="flag">AreaUnits</xsl:attribute>
				<svrl:text>AreaUnits.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(AreaUnits)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(AreaUnits)">
					<xsl:attribute name="id">Facility.AreaUnits.NotNull</xsl:attribute>
					<xsl:attribute name="flag">AreaUnits</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'AreaUnits')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.VolumeUnits.Check</xsl:attribute>
				<xsl:attribute name="flag">VolumeUnits</xsl:attribute>
				<svrl:text>VolumeUnits.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(VolumeUnits)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(VolumeUnits)">
					<xsl:attribute name="id">Facility.VolumeUnits.NotNull</xsl:attribute>
					<xsl:attribute name="flag">VolumeUnits</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'VolumeUnits')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.CurrencyUnit.Check</xsl:attribute>
				<xsl:attribute name="flag">CurrencyUnit</xsl:attribute>
				<svrl:text>Currency.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CurrencyUnit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CurrencyUnit)">
					<xsl:attribute name="id">Facility.Currency.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CurrencyUnit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CurrencyUnit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.AreaMeasurement.Check</xsl:attribute>
				<xsl:attribute name="flag">AreaMeasurement</xsl:attribute>
				<svrl:text>AreaMeasurement.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(AreaMeasurement)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(AreaMeasurement)">
					<xsl:attribute name="id">Facility.AreaMeasurement.NotNull</xsl:attribute>
					<xsl:attribute name="flag">AreaMeasurement</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'AreaMeasurement')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalSystem)">
					<xsl:attribute name="id">Facility.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalProjectObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalProjectObject</xsl:attribute>
				<svrl:text>ExternalProjectObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalProjectObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalProjectObject)">
					<xsl:attribute name="id">Facility.ExternalProjectObject.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalProjectObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalProjectObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalProjectIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalProjectIdentifier</xsl:attribute>
				<svrl:text>ExternalProjectIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalProjectIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalProjectIdentifier)">
					<xsl:attribute name="id">Facility.ProjectIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalProjectIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalProjectIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalSiteObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSiteObject</xsl:attribute>
				<svrl:text>ExternalSiteObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalSiteObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalSiteObject)">
					<xsl:attribute name="id">Facility.ExternalSiteObject.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalSiteObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalSiteObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalSiteIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSiteIdentifier</xsl:attribute>
				<svrl:text>ExternalSiteIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalSiteIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalSiteIdentifier)">
					<xsl:attribute name="id">Facility.ExternalSiteIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalSiteIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalSiteIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalFacilityObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalFacilityObject</xsl:attribute>
				<svrl:text>ExternalFacilityObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalFacilityObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalFacilityObject)">
					<xsl:attribute name="id">FacilityExternalFacilityObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalFacilityObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalFacilityObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Facility.ExternalFacilityIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalFacilityIdentifier</xsl:attribute>
				<svrl:text>ExternalFacilityIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExternalFacilityIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExternalFacilityIdentifier)">
					<xsl:attribute name="id">Facility.ExternalFacilityIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExternalFacilityIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExternalFacilityIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Floors-->
<xsl:template match="//Floors" priority="1025" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Floors" id="COBie.Floors" role="WorksheetErrors"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Floor Worksheet</xsl:message>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Floor.Count.Check</xsl:attribute>
				<xsl:attribute name="flag">FloorSheet</xsl:attribute>
				<svrl:text>Floors.AtLeastOneRowPresent
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="Floor"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Floor">
					<xsl:attribute name="id">Floors.AtLeastOneRowPresent</xsl:attribute>
					<svrl:text>
						<cfn:value-of xmlns="http://purl.oclc.org/dsdl/schematron" select="cfn:atLeastOneMessage('Floor','Floors')"/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Floors.Floor-->
<xsl:template match="//Floors/Floor" priority="1024" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Floors/Floor" id="COBie.Floors.Floor" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNotNull, Name.Unique<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Common.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Common.Name.Unique</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Floor.Elevation.Check</xsl:attribute>
				<xsl:attribute name="flag">Elevation</xsl:attribute>
				<svrl:text>Floor.Elevation.ValidNumberOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumber(Elevation)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumber(Elevation)">
					<xsl:attribute name="id">Floor.Elevation.ValidNumberOrNA</xsl:attribute>
					<xsl:attribute name="flag">Elevation</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'Elevation')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Floor.Height.Check</xsl:attribute>
				<xsl:attribute name="flag">Height</xsl:attribute>
				<svrl:text>Floor.Height.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(Height)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(Height)">
					<xsl:attribute name="id">Floor.Height.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">Height</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'Height')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Spaces-->
<xsl:template match="//Spaces" priority="1023" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Spaces" id="COBie.Spaces" role="WorksheetErrors"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Space Worksheet</xsl:message>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.Count.Check</xsl:attribute>
				<xsl:attribute name="flag">SpaceSheet</xsl:attribute>
				<svrl:text>Spaces.AtLeastOneRowPresent
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="Space"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Space">
					<xsl:attribute name="id">Spaces.AtLeastOneRowPresent</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="name(.)"/><xsl:text/> must have at least one entry<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Spaces.Space-->
<xsl:template match="//Spaces/Space" priority="1022" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Spaces/Space" id="COBie.Spaces.Space" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull, PrimaryKey.Unique.Warning (Name), PrimaryKey.Unique.Error (Name, FloorName)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Common.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Space.PrimaryKey.Unique.Error</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.FloorName.Check</xsl:attribute>
				<xsl:attribute name="flag">FloorName</xsl:attribute>
				<svrl:text>FloorName.NotNull, FloorName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(FloorName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(FloorName)">
					<xsl:attribute name="id">Space.FloorName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">FloorName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'FloorName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('FloorKey',FloorName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('FloorKey',FloorName)">
					<xsl:attribute name="id">Space.FloorName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">FloorName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'FloorName','Floor','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Description)">
					<xsl:attribute name="id">Space.Description.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.RoomTag.Check</xsl:attribute>
				<xsl:attribute name="flag">RoomTag</xsl:attribute>
				<svrl:text>RoomTag.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(RoomTag)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(RoomTag)">
					<xsl:attribute name="id">Space.RoomTag.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">RoomTag</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'RoomTag')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.UsableHeight.Check</xsl:attribute>
				<xsl:attribute name="flag">UsableHeight</xsl:attribute>
				<svrl:text>UsableHeight.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(UsableHeight)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(UsableHeight)">
					<xsl:attribute name="id">Space.UsableHeight.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">UsableHeight</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'UsableHeight')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.GrossArea.Check</xsl:attribute>
				<xsl:attribute name="flag">GrossArea</xsl:attribute>
				<svrl:text>GrossArea.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(GrossArea)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(GrossArea)">
					<xsl:attribute name="id">Space.GrossArea.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">GrossArea</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'GrossArea')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Space.NetArea.Check</xsl:attribute>
				<xsl:attribute name="flag">NetArea</xsl:attribute>
				<svrl:text>NetArea.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(NetArea)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(NetArea)">
					<xsl:attribute name="id">Space.NetArea.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">NetArea</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'NetArea')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Zones" priority="1021" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Zones"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Zone Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Zones.Zone-->
<xsl:template match="//Zones/Zone" priority="1020" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Zones/Zone" id="COBie.Zones.Zone" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Zone.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull, PrimaryKey.Unique (Name, Category, SpaceNames)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Zone.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Zone.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name,Category,SpaceNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Zone.SpaceNames.Check</xsl:attribute>
				<xsl:attribute name="flag">SpaceNames</xsl:attribute>
				<svrl:text>SpaceNames.NotNull, SpaceNames.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(SpaceNames)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(SpaceNames)">
					<xsl:attribute name="id">Zone.SpaceNames.NotNull</xsl:attribute>
					<xsl:attribute name="flag">SpaceNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'SpaceNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:delimListInKeys(SpaceNames,'Space',/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:delimListInKeys(SpaceNames,'Space',/)">
					<xsl:attribute name="id">Zone.SpaceNames.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">SpaceNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeysMessage(.,'SpaceNames','Space','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Types-->
<xsl:template match="//Types" priority="1019" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Types" id="COBie.Types" role="WorksheetErrors"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Type Worksheet</xsl:message>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Count.Check</xsl:attribute>
				<xsl:attribute name="flag">TypeSheet</xsl:attribute>
				<svrl:text>Types.AtLeastOneRowPresent
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="Type"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Type">
					<xsl:attribute name="id">Types.AtLeastOneRowPresent</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="name(.)"/><xsl:text/>:  At least one Type must be provided<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Types.Type-->
<xsl:template match="//Types/Type" priority="1018" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Types/Type" id="COBie.Types.Type" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNotNull, Name.Unique<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Common.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Common.Name.Unique</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.ComponentCount.Check</xsl:attribute>
				<xsl:attribute name="flag">TypeComponentSheets</xsl:attribute>
				<svrl:text>Type.Component.AComponentForEachType
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="some $comp in ../../Components/Component satisfies ($comp/TypeName=@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="some $comp in ../../Components/Component satisfies ($comp/TypeName=@Name)">
					<xsl:attribute name="id">Type.Component.AComponentForEachType</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="name(.)"/><xsl:text/>.<xsl:text/><xsl:value-of select="@Name"/><xsl:text/>: All Types must have at least one associated Component
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.AssetType.Check</xsl:attribute>
				<xsl:attribute name="flag">AssetType</xsl:attribute>
				<svrl:text>AssetType.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(AssetType)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(AssetType)">
					<xsl:attribute name="id">Type.AssetType.NotNull</xsl:attribute>
					<xsl:attribute name="flag">AssetType</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'AssetType')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Manufacturer.Check</xsl:attribute>
				<xsl:attribute name="flag">Manufacturer</xsl:attribute>
				<svrl:text>Manufacturer.NotNull, Manufacturer.CrossReference (Contact Sheet)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Manufacturer)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Manufacturer)">
					<xsl:attribute name="id">Type.Manufacturer.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Manufacturer</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Manufacturer')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',Manufacturer)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',Manufacturer)">
					<xsl:attribute name="id">Type.Manufacturer.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">Manufacturer</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'Manufacturer','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.ModelNumber.Check</xsl:attribute>
				<xsl:attribute name="flag">ModelNumber</xsl:attribute>
				<svrl:text>ModelNumber.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(ModelNumber)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(ModelNumber)">
					<xsl:attribute name="id">Type.ModelNumber.NotNull</xsl:attribute>
					<xsl:attribute name="flag">ModelNumber</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'ModelNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.WarrantyGuarantorParts.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyGuarantorParts</xsl:attribute>
				<svrl:text>WarrantyGuarantorParts.NotNull, WarrantyGuarantorParts.CrossReference (Contact Sheet)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(WarrantyGuarantorParts)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(WarrantyGuarantorParts)">
					<xsl:attribute name="id">Type.WarrantyGuarantorParts.NotNull</xsl:attribute>
					<xsl:attribute name="flag">WarrantyGuarantorParts</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'WarrantyGuarantorParts')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',WarrantyGuarantorParts)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',WarrantyGuarantorParts)">
					<xsl:attribute name="id">Type.WarrantyGuarantorParts.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">WarrantyGuarantorParts</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'WarrantyGuarantorParts','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.WarrantyDurationParts.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyDurationParts</xsl:attribute>
				<svrl:text>WarrantyDurationParts.validNumberZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(WarrantyDurationParts)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(WarrantyDurationParts)">
					<xsl:attribute name="id">Type.WarrantyDurationParts.validNumberZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">WarrantyDurationParts</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'WarrantyDurationParts')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.WarrantyGuarantorLabor.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyGuarantorLabor</xsl:attribute>
				<svrl:text>WarrantyGuarantorLabor.NotNull, WarrantyGuarantorLabor.CrossReference (Contact Sheet)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(WarrantyGuarantorLabor)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(WarrantyGuarantorLabor)">
					<xsl:attribute name="id">Type.WarrantyGuarantorLabor.NotNull</xsl:attribute>
					<xsl:attribute name="flag">WarrantyGuarantorLabor</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'WarrantyGuarantorLabor')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',WarrantyGuarantorLabor)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',WarrantyGuarantorLabor)">
					<xsl:attribute name="id">Type.WarrantyGuarantorLabor.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">WarrantyGuarantorLabor</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'WarrantyGuarantorLabor,','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.WarrantyDurationLabor.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyDurationLabor</xsl:attribute>
				<svrl:text>WarrantyDurationLabor.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(WarrantyDurationLabor)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(WarrantyDurationLabor)">
					<xsl:attribute name="id">Type.WarrantyDurationLabor.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">WarrantyDurationLabor</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'WarrantyDurationLabor')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.WarrantyDurationUnit.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyDurationUnit</xsl:attribute>
				<svrl:text>WarrantyDurationUnit.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(WarrantyDurationUnit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(WarrantyDurationUnit)">
					<xsl:attribute name="id">Type.WarrantyDurationUnit.NotNull</xsl:attribute>
					<xsl:attribute name="flag">WarrantyDurationUnit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'WarrantyDurationUnit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.ReplacementCost.Check</xsl:attribute>
				<xsl:attribute name="flag">ReplacementCost</xsl:attribute>
				<svrl:text>ReplacementCost.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(ReplacementCost)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(ReplacementCost)">
					<xsl:attribute name="id">Type.ReplacementCost.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">ReplacementCost</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'ReplacementCost')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.ExpectedLife.Check</xsl:attribute>
				<xsl:attribute name="flag">ExpectedLife</xsl:attribute>
				<svrl:text>ExpectedLife.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(ExpectedLife)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(ExpectedLife)">
					<xsl:attribute name="id">Type.ExpectedLife.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">ExpectedLife</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'ExpectedLife')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.DurationUnit.Check</xsl:attribute>
				<xsl:attribute name="flag">DurationUnit</xsl:attribute>
				<svrl:text>DurationUnit.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(DurationUnit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(DurationUnit)">
					<xsl:attribute name="id">Type.DurationUnit.NotNull</xsl:attribute>
					<xsl:attribute name="flag">DurationUnit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'DurationUnit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.WarrantyDescription.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyDescription</xsl:attribute>
				<svrl:text>WarrantyDescription.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(WarrantyDescription)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(WarrantyDescription)">
					<xsl:attribute name="id">Type.WarrantyDescription.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">WarrantyDescription</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'WarrantyDescription')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.NominalLength.Check</xsl:attribute>
				<xsl:attribute name="flag">NominalLength</xsl:attribute>
				<svrl:text>NominalLength.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(NominalLength)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(NominalLength)">
					<xsl:attribute name="id">Type.NominalLength.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">NominalLength</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'NominalLength')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.NominalWidth.Check</xsl:attribute>
				<xsl:attribute name="flag">NominalWidth</xsl:attribute>
				<svrl:text>NominalWidth.ZeroOrGreaterOrNA
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(NominalWidth)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(NominalWidth)">
					<xsl:attribute name="id">Type.NominalWidth.ZeroOrGreaterOrNA</xsl:attribute>
					<xsl:attribute name="flag">NominalWidth</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'NominalWidth')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.NominalHeight.Check</xsl:attribute>
				<xsl:attribute name="flag">NominalHeight</xsl:attribute>
				<svrl:text>NominalHeight.ZeroOrGreater
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validNumberZeroOrGreater(NominalHeight)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validNumberZeroOrGreater(NominalHeight)">
					<xsl:attribute name="id">Type.NominalHeight.ZeroOrGreater</xsl:attribute>
					<xsl:attribute name="flag">NominalHeight</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyNumberMessage(.,'NominalHeight')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.ModelReference.Check</xsl:attribute>
				<xsl:attribute name="flag">ModelReference</xsl:attribute>
				<svrl:text>ModelReference.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ModelReference)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ModelReference)">
					<xsl:attribute name="id">Type.ModelReference.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ModelReference</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ModelReference')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Shape.Check</xsl:attribute>
				<xsl:attribute name="flag">Shape</xsl:attribute>
				<svrl:text>Shape.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Shape)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Shape)">
					<xsl:attribute name="id">Type.Shape.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Shape</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Shape')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Size.Check</xsl:attribute>
				<xsl:attribute name="flag">Size</xsl:attribute>
				<svrl:text>Size.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Size)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Size)">
					<xsl:attribute name="id">Type.Size.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Size</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Size')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Color.Check</xsl:attribute>
				<xsl:attribute name="flag">Color</xsl:attribute>
				<svrl:text>Color.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Color)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Color)">
					<xsl:attribute name="id">Type.Color.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Color</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Color')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Finish.Check</xsl:attribute>
				<xsl:attribute name="flag">Finish</xsl:attribute>
				<svrl:text>Finish.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Finish)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Finish)">
					<xsl:attribute name="id">Type.Finish.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Finish</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Finish')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Grade.Check</xsl:attribute>
				<xsl:attribute name="flag">Grade</xsl:attribute>
				<svrl:text>Grade.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Grade)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Grade)">
					<xsl:attribute name="id">Type.Grade.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Grade</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Grade')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Material.Check</xsl:attribute>
				<xsl:attribute name="flag">Material</xsl:attribute>
				<svrl:text>Material.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Material)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Material)">
					<xsl:attribute name="id">Type.Material.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Material</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Material')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Constituents.Check</xsl:attribute>
				<xsl:attribute name="flag">Constituents</xsl:attribute>
				<svrl:text>Constituents.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Constituents)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Constituents)">
					<xsl:attribute name="id">Type.Constituents.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Constituents</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Constituents')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.Features.Check</xsl:attribute>
				<xsl:attribute name="flag">Features</xsl:attribute>
				<svrl:text>Features.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Features)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Features)">
					<xsl:attribute name="id">Type.Features.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Features</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Features')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.AccessibilityPerformance.Check</xsl:attribute>
				<xsl:attribute name="flag">AccessibilityPerformance</xsl:attribute>
				<svrl:text>AccessibilityPerformance.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(AccessibilityPerformance)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(AccessibilityPerformance)">
					<xsl:attribute name="id">Type.AccessibilityPerformance.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">AccessibilityPerformance</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'AccessibilityPerformance')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.CodePerformance.Check</xsl:attribute>
				<xsl:attribute name="flag">CodePerformance</xsl:attribute>
				<svrl:text>CodePerformance.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(CodePerformance)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(CodePerformance)">
					<xsl:attribute name="id">Type.CodePerformance.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">CodePerformance</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'CodePerformance')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Type.SustainabilityPerformance.Check</xsl:attribute>
				<xsl:attribute name="flag">SustainabilityPerformance</xsl:attribute>
				<svrl:text>SustainabilityPerformance.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(SustainabilityPerformance)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(SustainabilityPerformance)">
					<xsl:attribute name="id">Type.SustainabilityPerformance.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">SustainabilityPerformance</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'SustainabilityPerformance')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Components-->
<xsl:template match="//Components" priority="1017" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Components" id="COBie.Components" role="WorksheetErrors"/><xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Component Worksheet</xsl:message>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.Count.Check</xsl:attribute>
				<xsl:attribute name="flag">ComponentSheet</xsl:attribute>
				<svrl:text>Components.AtLeastOneRowPresent
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="Component"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="Component">
					<xsl:attribute name="id">Components.AtLeastOneRowPresent</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="name(.)"/><xsl:text/>:  at least one Component must be provided.<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Components.Component-->
<xsl:template match="//Components/Component" priority="1016" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Components/Component" id="COBie.Components.Component" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull, PrimaryKey.Unique.Warning (Name), PrimaryKey.Unique.Error (Name, Space)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Common.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Component.PrimaryKey.Unique.Error</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.TypeName.Check</xsl:attribute>
				<xsl:attribute name="flag">TypeName</xsl:attribute>
				<svrl:text>TypeName.NotNull, TypeName.CrossReference (Type Worksheet)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(TypeName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(TypeName)">
					<xsl:attribute name="id">Component.TypeName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">TypeName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'TypeName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('TypeKey',TypeName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('TypeKey',TypeName)">
					<xsl:attribute name="id">Component.TypeName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">TypeName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.Space.Check</xsl:attribute>
				<xsl:attribute name="flag">Space</xsl:attribute>
				<svrl:text>Space.NotNull, Space.CrossReference (Component Worksheet)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Space)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Space)">
					<xsl:attribute name="id">Component.Space.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Space</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Space')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:componentSpaceKeyMatch(Space,ExtObject,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:componentSpaceKeyMatch(Space,ExtObject,/)">
					<xsl:attribute name="id">Component.Space.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">Space</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:componentSpaceForeignKeyMessage(.,'Space','Space','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Description)">
					<xsl:attribute name="id">Component.Description.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.SerialNumber.Check</xsl:attribute>
				<xsl:attribute name="flag">SerialNumber</xsl:attribute>
				<svrl:text>SerialNumber.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(SerialNumber)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(SerialNumber)">
					<xsl:attribute name="id">Component.SerialNumber.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">SerialNumber</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'SerialNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.InstallationDate.Check</xsl:attribute>
				<xsl:attribute name="flag">InstallationDate</xsl:attribute>
				<svrl:text>InstallationDate.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(InstallationDate)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(InstallationDate)">
					<xsl:attribute name="id">Component.InstallationDate.NotNull</xsl:attribute>
					<xsl:attribute name="flag">InstallationDate</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'InstallationDate')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.WarrantyStartDate.Check</xsl:attribute>
				<xsl:attribute name="flag">WarrantyStartDate</xsl:attribute>
				<svrl:text>WarrantyStartDate.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(WarrantyStartDate)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(WarrantyStartDate)">
					<xsl:attribute name="id">Component.WarrantyStartDate.NotNull</xsl:attribute>
					<xsl:attribute name="flag">WarrantyStartDate</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'WarrantyStartDate')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.TagNumber.Check</xsl:attribute>
				<xsl:attribute name="flag">TagNumber</xsl:attribute>
				<svrl:text>TagNumber.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(TagNumber)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(TagNumber)">
					<xsl:attribute name="id">Component.TagNumber.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">TagNumber</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'TagNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.BarCode.Check</xsl:attribute>
				<xsl:attribute name="flag">BarCode</xsl:attribute>
				<svrl:text>BarCode.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(BarCode)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(BarCode)">
					<xsl:attribute name="id">Component.BarCode.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">BarCode</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'BarCode')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Component.AssetIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">AssetIdentifier</xsl:attribute>
				<svrl:text>AssetIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(AssetIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(AssetIdentifier)">
					<xsl:attribute name="id">Component.AssetIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">AssetIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'AssetIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Systems" priority="1015" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Systems"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating System Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Systems.System-->
<xsl:template match="//Systems/System" priority="1014" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Systems/System" id="COBie.Systems.System" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">System.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>PrimaryKey.Unique (Name, Category, ComponentNames), Name.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">System.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name,Category,ComponentNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">System.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">System.ComponentNames.Check</xsl:attribute>
				<xsl:attribute name="flag">ComponentNames</xsl:attribute>
				<svrl:text>ComponentNames.NotNull, ComponentNames.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(ComponentNames)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(ComponentNames)">
					<xsl:attribute name="id">System.ComponentNames.NotNull</xsl:attribute>
					<xsl:attribute name="flag">ComponentNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'ComponentNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:delimListInKeys(ComponentNames,'Component',/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:delimListInKeys(ComponentNames,'Component',/)">
					<xsl:attribute name="id">System.ComponentNames.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">ComponentNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'ComponentNames','Component','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Assemblies" priority="1013" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Assemblies"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Assembly Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Assemblies.Assembly-->
<xsl:template match="//Assemblies/Assembly" priority="1012" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Assemblies/Assembly" id="COBie.Assemblies.Assembly" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Assembly.PrimaryKey.Check</xsl:attribute>
				<xsl:attribute name="flag">PrimaryKey</xsl:attribute>
				<svrl:text>Assembly.PrimaryKey.Unique (Name, SheetName, ParentName, ChildNames)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Assembly.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">AssemblyKey</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name, SheetName, ParentName,ChildNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Assembly.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Assembly.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Assembly.SheetName.Check</xsl:attribute>
				<xsl:attribute name="flag">SheetName</xsl:attribute>
				<svrl:text>SheetName.NotNull, SheetName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(SheetName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(SheetName)">
					<xsl:attribute name="id">Assembly.SheetName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">SheetName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'SheetName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="lower-case(SheetName)='component' or lower-case(SheetName)='type'"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="lower-case(SheetName)='component' or lower-case(SheetName)='type'">
					<xsl:attribute name="id">Assembly.SheetName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">SheetName</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="cfn:assertMsgPrefix(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'SheetName')"/><xsl:text/>: SheetName may only be Component or type
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Assembly.ParentName.Check</xsl:attribute>
				<xsl:attribute name="flag">ParentName</xsl:attribute>
				<svrl:text>ParentName.NotNull, ParentName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(ParentName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(ParentName)">
					<xsl:attribute name="id">Assembly.ParentName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">ParentName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'ParentName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:keyMatch(SheetName,ParentName,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:keyMatch(SheetName,ParentName,/)">
					<xsl:attribute name="id">Assembly.ParentName.Reference</xsl:attribute>
					<xsl:attribute name="flag">ParentName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'ParentName',SheetName,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Assembly.ChildNames.Check</xsl:attribute>
				<xsl:attribute name="flag">ChildNames</xsl:attribute>
				<svrl:text>ChildNames.NotNull, ChildNames.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(ChildNames)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(ChildNames)">
					<xsl:attribute name="id">Assembly.ChildNames.NotNull</xsl:attribute>
					<xsl:attribute name="flag">ChildNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'ChildNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:delimListInKeys(ChildNames,SheetName,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:delimListInKeys(ChildNames,SheetName,/)">
					<xsl:attribute name="id">Assembly.ChildNames.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">ChildNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'ChildNames',SheetName,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Assembly.AssemblyType.Check</xsl:attribute>
				<xsl:attribute name="flag">AssemblyType</xsl:attribute>
				<svrl:text>AssemblyType.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(AssemblyType)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(AssemblyType)">
					<xsl:attribute name="id">Assembly.AssemblyType.NotNull</xsl:attribute>
					<xsl:attribute name="flag">AssemblyType</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'AssemblyType')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Connections" priority="1011" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Connections"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Connection Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Connections.Connection-->
<xsl:template match="//Connections/Connection" priority="1010" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Connections/Connection" id="COBie.Connections.Connection" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.PrimaryKey.Check</xsl:attribute>
				<xsl:attribute name="flag">PrimaryKey</xsl:attribute>
				<svrl:text>PrimaryKey.Unique (Name, ConnectionType, SheetName, RowName1, RowName2)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Connection.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">ConnectionKey</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Name)">
					<xsl:attribute name="id">Connection.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.ConnectionType.Check</xsl:attribute>
				<xsl:attribute name="flag">ConnectionType</xsl:attribute>
				<svrl:text>ConnectionType.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(ConnectionType)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(ConnectionType)">
					<xsl:attribute name="id">Connection.ConnectionType.NotNull</xsl:attribute>
					<xsl:attribute name="flag">ConnectionType</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'ConnectionType')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.SheetName.Check</xsl:attribute>
				<xsl:attribute name="flag">SheetName</xsl:attribute>
				<svrl:text>SheetName.NotNull, SheetName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(SheetName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(SheetName)">
					<xsl:attribute name="id">Connection.SheetName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">SheetName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'SheetName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="lower-case(SheetName)='type' or lower-case(SheetName)='component'"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="lower-case(SheetName)='type' or lower-case(SheetName)='component'">
					<xsl:attribute name="id">Connection.SheetName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">SheetName</xsl:attribute>
					<svrl:text><xsl:text/><xsl:value-of select="cfn:assertMsgPrefix(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'SheetName')"/><xsl:text/>: SheetName must be Type or Component, <xsl:text/><xsl:value-of select="SheetName"/><xsl:text/> is not valid.<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element></svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.RowName1.Check</xsl:attribute>
				<xsl:attribute name="flag">RowName1</xsl:attribute>
				<svrl:text>RowName1.NotNull, RowName1.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(RowName1)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(RowName1)">
					<xsl:attribute name="id">Connection.RowName1.NotNull</xsl:attribute>
					<xsl:attribute name="flag">RowName1</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'RowName1')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:keyMatch(SheetName,RowName1,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:keyMatch(SheetName,RowName1,/)">
					<xsl:attribute name="id">Connection.RowName1.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">RowName1</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'RowName1',SheetName,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.RowName2.Check</xsl:attribute>
				<xsl:attribute name="flag">RowName2</xsl:attribute>
				<svrl:text>RowName2.NotNull, RowName2.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(RowName2)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(RowName2)">
					<xsl:attribute name="id">Connection.RowName2.NotNull</xsl:attribute>
					<xsl:attribute name="flag">RowName2</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'RowName2')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:keyMatch(SheetName,RowName2,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:keyMatch(SheetName,RowName2,/)">
					<xsl:attribute name="id">Connection.RowName2.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">RowName2</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'RowName2',SheetName,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.RealizingElement.Check</xsl:attribute>
				<xsl:attribute name="flag">RealizingElement</xsl:attribute>
				<svrl:text>RealizingElement.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(RealizingElement)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(RealizingElement)">
					<xsl:attribute name="id">Connection.RealizingElement.NotNull</xsl:attribute>
					<xsl:attribute name="flag">RealizingElement</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'RealizingElement')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.PortName1.Check</xsl:attribute>
				<xsl:attribute name="flag">PortName1</xsl:attribute>
				<svrl:text>PortName1.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(PortName1)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(PortName1)">
					<xsl:attribute name="id">Connection.PortName1.NotNull</xsl:attribute>
					<xsl:attribute name="flag">PortName1</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'PortName1')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Connection.PortName2.Check</xsl:attribute>
				<xsl:attribute name="flag">PortName2</xsl:attribute>
				<svrl:text>PortName2.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(PortName2)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(PortName2)">
					<xsl:attribute name="id">Connection.PortName2.NotNull</xsl:attribute>
					<xsl:attribute name="flag">PortName2</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'PortName2')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Spares" priority="1009" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Spares"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Spare Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Spares.Spare-->
<xsl:template match="//Spares/Spare" priority="1008" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Spares/Spare" id="COBie.Spares.Spare" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Spare.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Spare.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Spare.PrimaryKey.Check</xsl:attribute>
				<xsl:attribute name="flag">PrimaryKey</xsl:attribute>
				<svrl:text>PrimaryKey.Unique (Name, TypeName)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Spare.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">SpareKey</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name, TypeName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Spare.TypeName.Check</xsl:attribute>
				<xsl:attribute name="flag">TypeName</xsl:attribute>
				<svrl:text>TypeName.NotNull, TypeName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(TypeName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(TypeName)">
					<xsl:attribute name="id">Spare.TypeName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">TypeName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'TypeName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('TypeKey',TypeName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('TypeKey',TypeName)">
					<xsl:attribute name="id">Spare.TypeName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">TypeName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Spare.Suppliers.Check</xsl:attribute>
				<xsl:attribute name="flag">Suppliers</xsl:attribute>
				<svrl:text>Suppliers.NotNull, Suppliers.CrossReference (Contact Sheet)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Suppliers)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Suppliers)">
					<xsl:attribute name="id">Spare.Suppliers.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Suppliers</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Suppliers')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:delimListInKeys(Suppliers,'Contact',/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:delimListInKeys(Suppliers,'Contact',/)">
					<xsl:attribute name="id">Spare.Suppliers.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">Suppliers</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'Suppliers','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Spare.SetNumber.Check</xsl:attribute>
				<xsl:attribute name="flag">SetNumber</xsl:attribute>
				<svrl:text>SetNumber.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(SetNumber)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(SetNumber)">
					<xsl:attribute name="id">Spare.SetNumber.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">SetNumber</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'SetNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Spare.PartNumber.Check</xsl:attribute>
				<xsl:attribute name="flag">PartNumber</xsl:attribute>
				<svrl:text>PartNumber.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(PartNumber)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(PartNumber)">
					<xsl:attribute name="id">Spare.PartNumber.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">PartNumber</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'PartNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Resources" priority="1007" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Resources"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Resource Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Resources.Resource-->
<xsl:template match="//Resources/Resource" priority="1006" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Resources/Resource" id="COBie.Resources.Resource" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNotNull, Name.Unique<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Common.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Common.Name.Unique</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Jobs" priority="1005" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Jobs"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Job Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Jobs.Job-->
<xsl:template match="//Jobs/Job" priority="1004" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Jobs/Job" id="COBie.Jobs.Job" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Job.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.PrimaryKey.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>PrimaryKey.Unique (Name,TypeName,TaskNumber)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isKeyUnique(.)">
					<xsl:attribute name="id">Job.PrimaryKey.Unique</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name,TypeName,TaskNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.Status.Check</xsl:attribute>
				<xsl:attribute name="flag">Status</xsl:attribute>
				<svrl:text>Status.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Status)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Status)">
					<xsl:attribute name="id">Job.Status.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Status</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Status')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.TypeName.Check</xsl:attribute>
				<xsl:attribute name="flag">TypeName</xsl:attribute>
				<svrl:text>TypeName.NotNull, TypeName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(TypeName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(TypeName)">
					<xsl:attribute name="id">Job.TypeName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">TypeName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'TypeName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('TypeKey',TypeName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('TypeKey',TypeName)">
					<xsl:attribute name="id">Job.TypeName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">TypeName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.Duration.Check</xsl:attribute>
				<xsl:attribute name="flag">Duration</xsl:attribute>
				<svrl:text>Duration.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Duration)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Duration)">
					<xsl:attribute name="id">Job.Duration.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Duration</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Duration')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.DurationUnit.Check</xsl:attribute>
				<xsl:attribute name="flag">DurationUnit</xsl:attribute>
				<svrl:text>DurationUnit.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(DurationUnit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(DurationUnit)">
					<xsl:attribute name="id">Job.DurationUnit.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">DurationUnit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'DurationUnit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.Start.Check</xsl:attribute>
				<xsl:attribute name="flag">Start</xsl:attribute>
				<svrl:text>Start.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Start)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Start)">
					<xsl:attribute name="id">Job.Start.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Start</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Start')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.TaskStartUnit.Check</xsl:attribute>
				<xsl:attribute name="flag">TaskStartUnit</xsl:attribute>
				<svrl:text>TaskStartUnit.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(TaskStartUnit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(TaskStartUnit)">
					<xsl:attribute name="id">Job.TaskStartUnit.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">TaskStartUnit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'TaskStartUnit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.Frequency.Check</xsl:attribute>
				<xsl:attribute name="flag">Frequency</xsl:attribute>
				<svrl:text>Frequency.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Frequency)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Frequency)">
					<xsl:attribute name="id">Job.Frequency.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Frequency</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Frequency')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.FrequencyUnit.Check</xsl:attribute>
				<xsl:attribute name="flag">FrequencyUnit</xsl:attribute>
				<svrl:text>FrequencyUnit.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(FrequencyUnit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(FrequencyUnit)">
					<xsl:attribute name="id">Job.FrequencyUnit.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">FrequencyUnit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'FrequencyUnit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.TaskNumber.Check</xsl:attribute>
				<xsl:attribute name="flag">TaskNumber</xsl:attribute>
				<svrl:text>TaskNumber.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(TaskNumber)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(TaskNumber)">
					<xsl:attribute name="id">Job.TaskNumber.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">TaskNumber</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'TaskNumber')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.Priors.Check</xsl:attribute>
				<xsl:attribute name="flag">Priors</xsl:attribute>
				<svrl:text>Priors.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Priors)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Priors)">
					<xsl:attribute name="id">Job.Priors.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Priors</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Priors')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Job.ResourceNames.Check</xsl:attribute>
				<xsl:attribute name="flag">ResourceNames</xsl:attribute>
				<svrl:text>ResourceNames.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ResourceNames)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ResourceNames)">
					<xsl:attribute name="id">Job.ResourceNames.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ResourceNames</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ResourceNames')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Documents" priority="1003" mode="M4">
		<svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Documents"/>
		<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Document Worksheet</xsl:message>
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template>

	<!--RULE COBie.Documents.Document-->
<xsl:template match="//Documents/Document" priority="1002" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Documents/Document" id="COBie.Documents.Document" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.PrimaryKey.Check</xsl:attribute>
				<xsl:attribute name="flag">PrimaryKey</xsl:attribute>
				<svrl:text>PrimaryKey.Unique (Name, Stage, SheetName, RowName)
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isDocumentKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isDocumentKeyUnique(.)">
					<xsl:attribute name="id">Document.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">DocumentKey</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name,Stage,SheetName,RowName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Document.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.ApprovalBy.Check</xsl:attribute>
				<xsl:attribute name="flag">ApprovalBy</xsl:attribute>
				<svrl:text>ApprovalBy.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ApprovalBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ApprovalBy)">
					<xsl:attribute name="id">Document.ApprovalBy.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ApprovalBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ApprovalBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.Stage.Check</xsl:attribute>
				<xsl:attribute name="flag">Stage</xsl:attribute>
				<svrl:text>Stage.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Stage)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Stage)">
					<xsl:attribute name="id">Document.Stage.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Stage</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Stage')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.SheetName.Check</xsl:attribute>
				<xsl:attribute name="flag">SheetName</xsl:attribute>
				<svrl:text>SheetName.NotNull, SheetNameRowName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(SheetName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(SheetName)">
					<xsl:attribute name="id">Document.SheetName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">SheetName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'SheetName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:keyMatch(SheetName,RowName,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:keyMatch(SheetName,RowName,/)">
					<xsl:attribute name="id">Document.SheetNameRowName.Reference</xsl:attribute>
					<xsl:attribute name="flag">RowName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'RowName',SheetName,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.RowName.Check</xsl:attribute>
				<xsl:attribute name="flag">RowName</xsl:attribute>
				<svrl:text>RowName.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(RowName)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(RowName)">
					<xsl:attribute name="id">Document.RowName.NotNull</xsl:attribute>
					<xsl:attribute name="flag">RowName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'RowName')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.Directory.Check</xsl:attribute>
				<xsl:attribute name="flag">Directory</xsl:attribute>
				<svrl:text>Directory.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Directory)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Directory)">
					<xsl:attribute name="id">Document.Directory.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Directory</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Directory')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.File.Check</xsl:attribute>
				<xsl:attribute name="flag">File</xsl:attribute>
				<svrl:text>File.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(File)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(File)">
					<xsl:attribute name="id">Document.File.NotNull</xsl:attribute>
					<xsl:attribute name="flag">File</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'File')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Document.Reference.Check</xsl:attribute>
				<xsl:attribute name="flag">Reference</xsl:attribute>
				<svrl:text>Reference.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Reference)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Reference)">
					<xsl:attribute name="id">Document.Reference.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Reference</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Reference')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE -->
<xsl:template match="//Attributes" priority="1001" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Attributes"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<svrl:text>
					<xsl:message xmlns="http://purl.oclc.org/dsdl/schematron" terminate="no">Validating Attribute Worksheet</xsl:message>
					<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element>
				</svrl:text>
			</svrl:successful-report>
		</xsl:if><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template>

	<!--RULE COBie.Attributes.Attribute-->
<xsl:template match="//Attributes/Attribute" priority="1000" mode="M4"><svrl:fired-rule xmlns:svrl="http://purl.oclc.org/dsdl/svrl" context="//Attributes/Attribute" id="COBie.Attributes.Attribute" role="WorksheetErrors"/>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedBy.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedBy</xsl:attribute>
				<svrl:text>CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="key('ContactKey',CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="key('ContactKey',CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedBy)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedBy)">
					<xsl:attribute name="id">Common.CreatedBy.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedBy</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.CreatedOn.Check</xsl:attribute>
				<xsl:attribute name="flag">CreatedOn</xsl:attribute>
				<svrl:text>CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.NotNull</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validDateTime(CreatedOn)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validDateTime(CreatedOn)">
					<xsl:attribute name="id">Common.CreatedOn.Valid</xsl:attribute>
					<xsl:attribute name="flag">CreatedOn</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalSystem.Check</xsl:attribute>
				<xsl:attribute name="flag">ExternalSystem</xsl:attribute>
				<svrl:text>ExternalSystem.NotEmpty<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtSystem)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtSystem)">
					<xsl:attribute name="id">Common.ExternalSystem.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtSystem</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalObject.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtObject</xsl:attribute>
				<svrl:text>ExternalObject.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtObject)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtObject)">
					<xsl:attribute name="id">Common.External.ObjectNotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtObject</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.ExternalIdentifier.Check</xsl:attribute>
				<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
				<svrl:text>ExtIdentifier.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(ExtIdentifier)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(ExtIdentifier)">
					<xsl:attribute name="id">Common.ExternalIdentifier.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">ExtIdentifier</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Description.Check</xsl:attribute>
				<xsl:attribute name="flag">Description</xsl:attribute>
				<svrl:text>Description.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Description)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Description)">
					<xsl:attribute name="id">Common.Description.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Description</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Description')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Common.Category.Check</xsl:attribute>
				<xsl:attribute name="flag">Category</xsl:attribute>
				<svrl:text>Category.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(Category)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(Category)">
					<xsl:attribute name="id">Common.Category.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Category</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Attribute.PrimaryKey.Check</xsl:attribute>
				<xsl:attribute name="flag">PrimaryKey</xsl:attribute>
				<svrl:text>PrimaryKey.Unique (Name, SheetName, RowName) 
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:isAttributeKeyUnique(.)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:isAttributeKeyUnique(.)">
					<xsl:attribute name="id">Attribute.PrimaryKey.Unique</xsl:attribute>
					<xsl:attribute name="flag">AttributeKey</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:uniqueNameMessage(.,'Name,SheetName,RowName,Category')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Attribute.Name.Check</xsl:attribute>
				<xsl:attribute name="flag">Name</xsl:attribute>
				<svrl:text>Name.NotNull
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validString(@Name)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validString(@Name)">
					<xsl:attribute name="id">Attribute.Name.NotNull</xsl:attribute>
					<xsl:attribute name="flag">Name</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notNullMessage(.,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Attribute.SheetNameRowName.Check</xsl:attribute>
				<xsl:attribute name="flag">SheetNameRowName</xsl:attribute>
				<svrl:text>SheetNameRowName.CrossReference
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:keyMatch(SheetName,RowName,/)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:keyMatch(SheetName,RowName,/)">
					<xsl:attribute name="id">Attribute.SheetNameRowName.CrossReference</xsl:attribute>
					<xsl:attribute name="flag">RowName</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:foreignKeyMessage(.,'RowName',SheetName,'Name')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Attribute.Value.Check</xsl:attribute>
				<xsl:attribute name="flag">Value</xsl:attribute>
				<svrl:text>Value.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Value)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Value)">
					<xsl:attribute name="id">Attribute.Value.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Value</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Value')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Attribute.Unit.Check</xsl:attribute>
				<xsl:attribute name="flag">Unit</xsl:attribute>
				<svrl:text>Unit.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(Unit)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(Unit)">
					<xsl:attribute name="id">Attribute.Unit.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">Unit</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'Unit')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose>

		<!--REPORT -->
<xsl:if test="true()">
			<svrl:successful-report xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="true()">
				<xsl:attribute name="id">Attribute.AllowedValues.Check</xsl:attribute>
				<xsl:attribute name="flag">AllowedValues</xsl:attribute>
				<svrl:text>AllowedValues.NotEmpty
			<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
						<xsl:value-of select="cfn:getLocation(., position())"/>
					</xsl:element></svrl:text>
			</svrl:successful-report>
		</xsl:if>

		<!--ASSERT -->
<xsl:choose>
			<xsl:when test="cfn:validStringOrNA(AllowedValues)"/>
			<xsl:otherwise>
				<svrl:failed-assert xmlns:svrl="http://purl.oclc.org/dsdl/svrl" test="cfn:validStringOrNA(AllowedValues)">
					<xsl:attribute name="id">Attribute.AllowedValues.NotEmpty</xsl:attribute>
					<xsl:attribute name="flag">AllowedValues</xsl:attribute>
					<svrl:text>
						<xsl:text/>
						<xsl:value-of select="cfn:notEmptyMessage(.,'AllowedValues')"/>
						<xsl:text/>
						<xsl:element xmlns="http://purl.oclc.org/dsdl/schematron" name="location">
							<xsl:value-of select="cfn:getLocation(., position())"/>
						</xsl:element>
					</svrl:text>
				</svrl:failed-assert>
			</xsl:otherwise>
		</xsl:choose><xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/></xsl:template><xsl:template match="text()" priority="-1" mode="M4"/><xsl:template match="@*|node()" priority="-2" mode="M4">
		<xsl:apply-templates select="*|comment()|processing-instruction()" mode="M4"/>
	</xsl:template></xsl:stylesheet>