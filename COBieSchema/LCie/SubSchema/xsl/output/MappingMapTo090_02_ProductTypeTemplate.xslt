<?xml version="1.0" encoding="UTF-8"?>
<!--
This file was generated by Altova MapForce 2013r2

YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.

Refer to the Altova MapForce Documentation for further details.
http://www.altova.com/mapforce
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns0="http://assettype.cobielite.cobie.erdc.org" xmlns:ns1="http://attribute.cobielite.cobie.erdc.org" xmlns:ns2="http://cobielite.cobie.erdc.org" xmlns:cobielite="http://core.cobielite.cobie.erdc.org" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" exclude-result-prefixes="ns0 ns1 ns2 xs fn">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<ProductTypeTemplate xmlns="http://typetemplate090.lcie.cobielite.cobie.erdc.org" xmlns:att="http://attribute.lcie.cobielite.cobie.erdc.org" xmlns:con="http://contact.lcie.cobielite.cobie.erdc.org" xmlns:cobielite="http://core.cobielite.cobie.erdc.org" xmlns:doc="http://document.lcie.cobielite.cobie.erdc.org" xmlns:lcie="http://lcie.cobielite.cobie.erdc.org" xmlns:ttd="http://typetemplate090.defs.lcie.cobielite.cobie.erdc.org">
			<xsl:attribute name="xsi:schemaLocation" namespace="http://www.w3.org/2001/XMLSchema-instance" select="'http://typetemplate090.lcie.cobielite.cobie.erdc.org C:/Users/RDITLACB/git/cobieserver/COBieSchema/LCie/SubSchema/090_02_ProductTypeTemplate.xsd'"/>
			<ttd:InformationExchangeID>090.02_ProductTypeTemplate</ttd:InformationExchangeID>
			<xsl:for-each select="ns2:Facility/cobielite:AssetTypes">
				<cobielite:AssetTypes>
					<xsl:for-each select="ns0:AssetType">
						<xsl:variable name="var1_externalSystemName" as="node()?" select="@cobielite:externalSystemName"/>
						<xsl:variable name="var2_externalEntityName" as="node()?" select="@cobielite:externalEntityName"/>
						<xsl:variable name="var3_externalID" as="node()?" select="@cobielite:externalID"/>
						<ttd:AssetType>
							<xsl:if test="fn:exists($var2_externalEntityName)">
								<xsl:attribute name="cobielite:externalEntityName" select="fn:string($var2_externalEntityName)"/>
							</xsl:if>
							<xsl:if test="fn:exists($var3_externalID)">
								<xsl:attribute name="cobielite:externalID" select="fn:string($var3_externalID)"/>
							</xsl:if>
							<xsl:if test="fn:exists($var1_externalSystemName)">
								<xsl:attribute name="cobielite:externalSystemName" select="fn:string($var1_externalSystemName)"/>
							</xsl:if>
							<cobielite:AssetTypeName>
								<xsl:sequence select="fn:string(cobielite:AssetTypeName)"/>
							</cobielite:AssetTypeName>
							<xsl:for-each select="cobielite:AssetTypeCategory">
								<cobielite:AssetTypeCategory>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeCategory>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeDescription">
								<cobielite:AssetTypeDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeAccountingCategory">
								<cobielite:AssetTypeAccountingCategory>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeAccountingCategory>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeNominalLength">
								<cobielite:AssetTypeNominalLength>
									<xsl:sequence select="(./@node(), ./node())"/>
								</cobielite:AssetTypeNominalLength>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeNominalWidth">
								<cobielite:AssetTypeNominalWidth>
									<xsl:sequence select="(./@node(), ./node())"/>
								</cobielite:AssetTypeNominalWidth>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeNominalHeight">
								<cobielite:AssetTypeNominalHeight>
									<xsl:sequence select="(./@node(), ./node())"/>
								</cobielite:AssetTypeNominalHeight>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeAccessibilityText">
								<cobielite:AssetTypeAccessibilityText>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeAccessibilityText>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeCodePerformance">
								<cobielite:AssetTypeCodePerformance>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeCodePerformance>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeColorCode">
								<cobielite:AssetTypeColorCode>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeColorCode>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeConstituentsDescription">
								<cobielite:AssetTypeConstituentsDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeConstituentsDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeFeaturesDescription">
								<cobielite:AssetTypeFeaturesDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeFeaturesDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeFinishDescription">
								<cobielite:AssetTypeFinishDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeFinishDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeGradeDescription">
								<cobielite:AssetTypeGradeDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeGradeDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeMaterialDescription">
								<cobielite:AssetTypeMaterialDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeMaterialDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeShapeDescription">
								<cobielite:AssetTypeShapeDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeShapeDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeSizeDescription">
								<cobielite:AssetTypeSizeDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeSizeDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeSustainabilityPerformanceDescription">
								<cobielite:AssetTypeSustainabilityPerformanceDescription>
									<xsl:sequence select="fn:string(.)"/>
								</cobielite:AssetTypeSustainabilityPerformanceDescription>
							</xsl:for-each>
							<xsl:for-each select="cobielite:AssetTypeAttributes">
								<cobielite:AssetTypeAttributes>
									<xsl:for-each select="ns1:Attribute">
										<xsl:variable name="var4_propertySetExternalIdentifier" as="node()?" select="@cobielite:propertySetExternalIdentifier"/>
										<xsl:variable name="var5_propertySetName" as="node()?" select="@cobielite:propertySetName"/>
										<xsl:variable name="var6_externalSystemName" as="node()?" select="@cobielite:externalSystemName"/>
										<xsl:variable name="var7_externalEntityName" as="node()?" select="@cobielite:externalEntityName"/>
										<xsl:variable name="var8_externalID" as="node()?" select="@cobielite:externalID"/>
										<att:Attribute>
											<xsl:if test="fn:exists($var7_externalEntityName)">
												<xsl:attribute name="cobielite:externalEntityName" select="fn:string($var7_externalEntityName)"/>
											</xsl:if>
											<xsl:if test="fn:exists($var8_externalID)">
												<xsl:attribute name="cobielite:externalID" select="fn:string($var8_externalID)"/>
											</xsl:if>
											<xsl:if test="fn:exists($var6_externalSystemName)">
												<xsl:attribute name="cobielite:externalSystemName" select="fn:string($var6_externalSystemName)"/>
											</xsl:if>
											<xsl:if test="fn:exists($var5_propertySetName)">
												<xsl:attribute name="cobielite:propertySetName" select="fn:string($var5_propertySetName)"/>
											</xsl:if>
											<xsl:if test="fn:exists($var4_propertySetExternalIdentifier)">
												<xsl:attribute name="cobielite:propertySetExternalIdentifier" select="fn:string($var4_propertySetExternalIdentifier)"/>
											</xsl:if>
											<cobielite:AttributeName>
												<xsl:sequence select="fn:string(cobielite:AttributeName)"/>
											</cobielite:AttributeName>
											<cobielite:AttributeCategory>
												<xsl:sequence select="fn:string(cobielite:AttributeCategory)"/>
											</cobielite:AttributeCategory>
											<xsl:for-each select="cobielite:AttributeDescription">
												<cobielite:AttributeDescription>
													<xsl:sequence select="fn:string(.)"/>
												</cobielite:AttributeDescription>
											</xsl:for-each>
											<xsl:for-each select="cobielite:AttributeValue">
												<cobielite:AttributeValue>
													<xsl:sequence select="(./@node(), ./node())"/>
												</cobielite:AttributeValue>
											</xsl:for-each>
										</att:Attribute>
									</xsl:for-each>
								</cobielite:AssetTypeAttributes>
							</xsl:for-each>
						</ttd:AssetType>
					</xsl:for-each>
				</cobielite:AssetTypes>
			</xsl:for-each>
		</ProductTypeTemplate>
	</xsl:template>
</xsl:stylesheet>
