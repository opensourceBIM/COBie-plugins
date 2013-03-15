<?xml version="1.0" encoding="utf-8"?>
<iso:schema xmlns="http://purl.oclc.org/dsdl/schematron"  xmlns:iso="http://purl.oclc.org/dsdl/schematron" xmlns:xs="http://www.w3.org/2001/XMLSchema" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" schemaVersion="ISO19757-3" defaultPhase="#ALL">
	<xsl:key name="ContactKey" match="//Contacts/Contact" use="Email"/>
	<xsl:key name="FacilityKey" match="//Facilities/Facility" use="@Name"/>
	<xsl:key name="FloorKey" match="//Floors/Floor" use="@Name"/>
	<xsl:key name="SpaceKey" match="//Spaces/Space" use="@Name"/>
	<xsl:key name="ZoneKey" match="//Zones/Zone" use="concat(@Name,',',Category,',',SpaceNames)"/>
	<xsl:key name="TypeKey" match="//Types/Type" use="@Name"/>
	<xsl:key name="ComponentKey" match="//Components/Component" use="@Name"/>
	<xsl:key name="SystemKey" match="//Systems/System" use="concat(@Name,',',Category,',',ComponentNames)"/>
	<xsl:key name="AssemblyKey" match="//Assemblies/Assembly" use="@Name"/>
	<xsl:key name="ConnectionKey" match="//Connections/Connection" use="@Name"/>
	<xsl:key name="SpareKey" match="//Spares/Spare" use="@Name"/>
	<xsl:key name="ResourceKey" match="//Resources/Resource" use="@Name"/>
	<xsl:key name="JobKey" match="//Jobs/Job" use="@Name"/>
	<xsl:key name="DocumentKey" match="//Documents/Document" use="@Name"/>
	<xsl:key name="AttributeKey" match="//Attributes/Attribute" use="concat(concat(concat(concat(@Name,',') ,SheetName),','),RowName)"/>
	
	<xsl:function name="iso:keyMatch" as="xs:boolean">
		<xsl:param name="sheetName"/>
		<xsl:param name="keyValue"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="(lower-case($sheetName)='facility') or (lower-case($sheetName)='floor') or (lower-case($sheetName)='space') or (lower-case($sheetName)='zone') or (lower-case($sheetName)='type') or (lower-case($sheetName)='component') or (lower-case($sheetName)='system') or (lower-case($sheetName)='assembly') or (lower-case($sheetName)='connection') or (lower-case($sheetName)='spare') or (lower-case($sheetName)='resource') or (lower-case($sheetName)='job') or (lower-case($sheetName)='document')">
				<xsl:variable name="keyName" select="concat(iso:titleCase($sheetName),'Key')"/>
				<xsl:choose>
					<xsl:when test="key($keyName,$keyValue,$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:componentSpaceKeyMatch" as="xs:boolean">
		<xsl:param name="space" as="xs:string"/>
		<xsl:param name="extObject" as="xs:string"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="(lower-case($extObject)='ifcwindow' or lower-case($extObject)='ifcdoor')">
				<xsl:value-of select="iso:delimListInKeys($space,'Space',$context)"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="iso:keyMatch('Space',$space,$context)"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:assertMsgPrefix" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:choose>
			<xsl:when test="$RowKey">
				<xsl:value-of select="concat($SheetName,'.',$RowKey,':  ',iso:assertMsgSubject($SheetName,$FieldName))"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat($SheetName,':  ',iso:assertMsgSubject($SheetName,$FieldName))"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function xmlns="http://purl.oclc.org/dsdl/schematron" name="iso:delimListInKeys" as="xs:boolean">
		<xsl:param name="delimString" as="xs:string"/>
		<xsl:param name="keyName" as="xs:string"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="contains($delimString,',')">
				<xsl:variable name="tokenizedString" select="tokenize($delimString,',')"/>
				<xsl:variable name="booleanList">
					<xsl:for-each select="$tokenizedString">
						<xsl:choose>
							<xsl:when test="iso:keyMatch($keyName,.,$context)">
								<xsl:value-of select="true()"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="false()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:for-each>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="$booleanList[text()='false']">
						<xsl:value-of select="false()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="true()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="iso:keyMatch($keyName,$delimString,$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:assertMsgSubject" as="xs:string">
		<xsl:param name="SheetName"/>
		<xsl:param name="FieldName"/>
		<xsl:value-of select="concat($SheetName,'.',$FieldName)"/>
	</xsl:function>
	<xsl:function name="iso:uniqueNameMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be unique')"/>
	</xsl:function>
	<xsl:function name="iso:foreignKeyMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="FSheet" as="xs:string"/>
		<xsl:param name="FKey" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey)"/>
	</xsl:function>
	<xsl:function name="iso:foreignKeysMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="FSheet" as="xs:string"/>
		<xsl:param name="FKey" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey, ' (comma delimitted list for multiple entries is acceptable)')"/>
	</xsl:function>
	<xsl:function name="iso:atLeastOneMessage" as="xs:string">
		<xsl:param name="SheetNameSingular" as="xs:string"/>
		<xsl:param name="SheetNamePlural" as="xs:string"/>
		<xsl:value-of select="concat($SheetNamePlural,' must have at least one ',$SheetNameSingular)"/>
	</xsl:function>
	<xsl:function name="iso:onlyOneMessage" as="xs:string">
		<xsl:param name="SheetNameSingular" as="xs:string"/>
		<xsl:param name="SheetNamePlural" as="xs:string"/>
		<xsl:variable name="Msg" select="' must have exactly one '"/>
		<xsl:value-of select="concat($SheetNamePlural,' must have exactly one ',$SheetNameSingular)"/>
	</xsl:function>
	<xsl:function name="iso:dateTimeFormatMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be in the correct format (YYYY-MM-DDTHH:MM:SS)')"/>
	</xsl:function>
	<xsl:function name="iso:notNullMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is unacceptable)')"/>
	</xsl:function>
	<xsl:function name="iso:notEmptyMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is acceptable)')"/>
	</xsl:function>
	<xsl:function name="iso:notEmptyNumberMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is not acceptable, 0 should be used if value is unknown)')"/>
	</xsl:function>
	<xsl:function name="iso:validEmail" as="xs:boolean">
		<xsl:param name="text" as="xs:string"/>
		<xsl:choose>
			<xsl:when test="$text">
				<xsl:variable name="regExMatch" as="xs:boolean">
					<xsl:analyze-string select="$text" regex="[^@]+@[^\.]+\..+">
						<xsl:matching-substring>
							<xsl:value-of select="true()"/>
						</xsl:matching-substring>
						<xsl:non-matching-substring>
							<xsl:value-of select="false()"/>
						</xsl:non-matching-substring>
					</xsl:analyze-string>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="$regExMatch">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:titleCase" as="xs:string">
		<xsl:param name="str" as="xs:string"/>
		<xsl:sequence select="string-join(for $x in tokenize($str,'\s') return
concat(upper-case(substring($x, 1, 1)), lower-case(substring($x, 2))), ' ')"/>
	</xsl:function>
	<xsl:function name="iso:validStringOrNA" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="string-length(normalize-space($text))=0">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="true()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:validString" as="xs:boolean">
		<xsl:param name="text" as="xs:string"/>
		<xsl:choose>
			<xsl:when test="string-length(normalize-space($text))=0 or lower-case(normalize-space($text))='n/a'">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="true()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:validNumber" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not($text castable as xs:decimal)">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="true()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:validNumberNotZero" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not($text castable as xs:decimal)">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="number($text)>0">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:validNumberZeroOrGreater" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not($text castable as xs:decimal)">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="number($text)>=0">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:validDateTime" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="$text castable as xs:dateTime">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<iso:title>Test ISO schematron file. Introduction mode</iso:title>
	<iso:pattern id="COBieValidation.General">
		<iso:title>General Rules Applicable to All COBie Documents</iso:title>
		<iso:rule abstract="true" id="COBie.Abstract.Name">
			<iso:assert id="NameNotNull" test="iso:validString(@Name)">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
			</iso:assert>
			<iso:assert id="NameUnique" test="count(key(concat(name(.),'Key'),@Name))=1">
				<value-of select="iso:uniqueNameMessage(name(.),@Name,'Name')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Created">
			<iso:assert id="CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'CreatedBy','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="CreatedBy.NotNull" test="iso:validString(CreatedBy)">
				<value-of select="iso:notNullMessage(name(.),@Name,'CreatedBy')"/>
			</iso:assert>
			<iso:assert id="CreatedOn.NotNull" test="iso:validString(CreatedOn)">
				<value-of select="iso:notNullMessage(name(.),@Name,'CreatedOn')"/>
			</iso:assert>
			<iso:assert id="CreatedOn.Valid" test="iso:validDateTime(CreatedOn)">
				<value-of select="iso:dateTimeFormatMessage(name(.),@Name,'CreatedOn')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.External">
			<iso:assert id="ExternalSystem.NotEmpty" test="iso:validStringOrNA(ExtSystem)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExtSystem')"/>
			</iso:assert>
			<iso:assert id="External.ObjectNotEmpty" test="iso:validStringOrNA(ExtObject)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExtObject')"/>
			</iso:assert>
			<iso:assert id="ExternalIdentifier.NotEmpty" test="iso:validStringOrNA(ExtIdentifier)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExtIdentifier')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Category">
			<iso:assert id="Category.NotNull" test="iso:validString(Category)">
				<value-of select="iso:notNullMessage(name(.),@Name,'Category')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Description">
			<iso:assert id="Description.NotEmpty" test="iso:validStringOrNA(Description)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Description')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts" id="COBie.Contacts" role="Errors">
			<iso:assert id="Contacts.AtLeastOneContact" test="Contact">
				<value-of select="iso:atLeastOneMessage('Contact','Contacts')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts/Contact" id="COBie.Contacts.Contact" role="Errors">
			<iso:assert id="Contact.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)">
				<value-of select="iso:foreignKeyMessage(name(.),Email,'CreatedBy','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="Contact.CreatedBy.NotNull" test="iso:validString(CreatedBy)">
				<value-of select="iso:notNullMessage(name(.),Email,'CreatedBy')"/>
			</iso:assert>
			<iso:assert id="Contact.CreatedOn.NotNull" test="iso:validString(CreatedOn)">
				<value-of select="iso:notNullMessage(name(.),Email,'CreatedOn')"/>
			</iso:assert>
			<iso:assert id="Contact.CreatedOn.Valid" test="iso:validDateTime(CreatedOn)">
				<value-of select="iso:dateTimeFormatMessage(name(.),Email,'CreatedOn')"/>
			</iso:assert>
			<iso:assert id="ExternalSystem.NotEmpty" test="iso:validStringOrNA(ExternalSystem)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'ExternalSystem')"/>
			</iso:assert>
			<iso:assert id="Contact.ExternalObject.NotEmpty" test="iso:validStringOrNA(ExternalObject)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'ExternalObject')"/>
			</iso:assert>
			<iso:assert id="Contact.ExternalIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalIdentifier)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'ExternalIdentifier')"/>
			</iso:assert>
			<iso:assert id="Contact.Category.NotNull" test="iso:validString(Category)">
				<value-of select="iso:notNullMessage(name(.),Email,'Category')"/>
			</iso:assert>

			<iso:assert id="Contact.Email.NotNull" test="iso:validString(Email)">
				<value-of select="iso:notNullMessage(name(.),Email,'Email')"/>
			</iso:assert>
			<iso:assert id="Contact.Email.Format" test="iso:validEmail(Email)">
				<value-of select="iso:assertMsgPrefix(name(.),Email,'Email')"/> must be a valid e-mail format (XXX@YYY.ZZZ)</iso:assert>
			<iso:assert id="Contact.Company.NotNull" test="iso:validString(Company)">
				<value-of select="iso:assertMsgPrefix(name(.),Email,'Company')"/>  must be provided (n/a is not acceptable)</iso:assert>
			<iso:assert id="Contact.Phone.NotNull" test="iso:validString(Phone)">
				<value-of select="iso:notNullMessage(name(.),Email,'Phone')"/>
			</iso:assert>
			<iso:assert id="Contact.Department.NotEmpty" test="iso:validStringOrNA(Department)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Department')"/>
			</iso:assert>
			<iso:assert id="Contact.OrganizationCode.NotEmpty" test="iso:validStringOrNA(OrganizationCode)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'OrganizationCode')"/>
			</iso:assert>
			<iso:assert id="Contact.GivenName.NotEmpty" test="iso:validStringOrNA(GivenName)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'GivenName')"/>
			</iso:assert>
			<iso:assert id="Contact.FamilyName.NotEmpty" test="iso:validStringOrNA(FamilyName)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'FamilyName')"/>
			</iso:assert>
			<iso:assert id="Contact.Street.NotEmpty" test="iso:validStringOrNA(Street)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Street')"/>
			</iso:assert>
			<iso:assert id="Contact.PostalBox.NotEmpty" test="iso:validStringOrNA(PostalBox)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'PostalBox')"/>
			</iso:assert>
			<iso:assert id="Contact.Town.NotEmpty" test="iso:validStringOrNA(Town)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Town')"/>
			</iso:assert>
			<iso:assert id="Contact.StateRegion.NotEmpty" test="iso:validStringOrNA(StateRegion)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'StateRegion')"/>
			</iso:assert>
			<iso:assert id="Contact.PostalCode.NotEmpty" test="iso:validStringOrNA(PostalCode)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'PostalCode')"/>
			</iso:assert>
			<iso:assert id="Contact.Country.NotEmpty" test="iso:validStringOrNA(Country)">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Country')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities" id="COBie.Facilities" role="Errors">
			<iso:assert id="Facilites.OnlyOneFacility" test="count(Facility)=1">
				<value-of select="iso:onlyOneMessage('Facility','Facilities')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities/Facility" id="COBie.Facilities.Facility" role="Errors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:assert id="Facility.ProjectName.NotNull" test="iso:validString(ProjectName)">
				<value-of select="iso:notNullMessage(name(.),@Name,'ProjectName')"/>
			</iso:assert>
			<iso:assert id="Facility.SiteName.NotNull" test="iso:validString(SiteName)">
				<value-of select="iso:notNullMessage(name(.),@Name,'SiteName')"/>
			</iso:assert>
			<iso:assert id="Facility.LinearUnits.NotNull" test="iso:validString(LinearUnits)">
				<value-of select="iso:notNullMessage(name(.),@Name,'LinearUnits')"/>
			</iso:assert>
			<!-- TODO Insert LinearUnits Picklist assert -->
			<iso:assert id="Facility.AreaUnits.NotNull" test="iso:validString(AreaUnits)">
				<value-of select="iso:notNullMessage(name(.),@Name,'AreaUnits')"/>
			</iso:assert>
			<!--TODO Insert AreaUnits Picklist assert -->
			<iso:assert id="Facility.VolumeUnits.NotNull" test="iso:validString(VolumeUnits)">
				<value-of select="iso:notNullMessage(name(.),@Name,'VolumeUnits')"/>
			</iso:assert>
			<!-- TODO Insert VolumeUnits Picklist assert -->
			<iso:assert id="Facility.Currency.NotNull" test="iso:validString(CurrencyUnits)">
				<value-of select="iso:notNullMessage(name(.),@Name,'CurrencyUnits')"/>
			</iso:assert>
			<!-- TODO Currency Unit Picklist -->
			<iso:assert id="Facility.AreaMeasurement.NotNull" test="iso:validString(AreaMeasurement)">
				<value-of select="iso:notNullMessage(name(.),@Name,'AreaMeasurement')"/>
			</iso:assert>
			<iso:assert id="Facility.ExternalSystem.NotEmpty" test="iso:validStringOrNA(ExternalSystem)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalSystem')"/>
			</iso:assert>
			<iso:assert id="Facility.ExternalProjectObject.NotEmpty" test="iso:validStringOrNA(ExternalProjectObject)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalProjectObject')"/>
			</iso:assert>
			<iso:assert id="Facility.ProjectIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalProjectIdentifier)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalProjectIdentifier')"/>
			</iso:assert>
			<iso:assert id="Facility.ExternalSiteObject.NotEmpty" test="iso:validStringOrNA(ExternalSiteObject)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalSiteObject')"/>
			</iso:assert>
			<iso:assert id="Facility.ExternalSiteIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalSiteIdentifier)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalSiteIdentifier')"/>
			</iso:assert>
			<iso:assert id="FacilityExternalFacilityObjectNotEmpty" test="iso:validStringOrNA(ExternalFacilityObject)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalFacilityObject')"/>
			</iso:assert>
			<iso:assert id="Facility.ExternalFacilityIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalFacilityIdentifier)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalFacilityIdentifier')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors" id="COBie.Floors" role="Errors">
			<iso:assert id="Floors.AtLeastOneFloor" test="Floor">
				<iso:value-of select="iso:atLeastOneMessage('Floor','Floors')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors/Floor" id="COBie.Floors.Floor" role="Errors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:assert id="Floor.Elevation.ValidNumber" test="iso:validNumber(Elevation)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'Elevation')"/>
			</iso:assert>
			<iso:assert id="Floor.Height.ZeroOrGreater" test="iso:validNumberZeroOrGreater(Height)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'Height')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces" id="COBie.Spaces" role="Errors">
			<iso:assert id="Spaces.AtLeastOneSpace" test="Space">
				<name/> must have at least one entry</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces/Space" id="COBie.Spaces.Space" role="Errors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:assert id="Space.FloorName.NotNull" test="iso:validString(FloorName)">
				<value-of select="iso:notNullMessage(name(.),@Name,'FloorName')"/>
			</iso:assert>
			<iso:assert id="Space.FloorName.Reference" test="key('FloorKey',FloorName)">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'FloorName','Floor','Name')"/>
			</iso:assert>
			<iso:assert id="Space.Description.NotNull" test="iso:validString(Description)">
				<value-of select="iso:notNullMessage(name(.),@Name,'Description')"/>
			</iso:assert>
			<iso:assert id="Space.RoomTag.NotEmpty" test="iso:validStringOrNA(RoomTag)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'RoomTag')"/>
			</iso:assert>
			<iso:assert id="Space.UsableHeight" test="iso:validNumberZeroOrGreater(UsableHeight)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'UsableHeight')"/>
			</iso:assert>
			<iso:assert id="Space.GrossArea" test="iso:validNumberZeroOrGreater(GrossArea)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'GrossArea')"/>
			</iso:assert>
			<iso:assert id="Space.NetArea" test="iso:validNumberZeroOrGreater(NetArea)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'NetArea')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Zones/Zone" id="COBie.Zones.Zone" role="Errors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:assert id="Zone.Name.NotNull" test="iso:validString(@Name)">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'Name')"/>
			</iso:assert>
			<iso:assert id="Zone.Name.Unique" test="count(key('ZoneKey',concat(@Name,',',Category,',',SpaceNames)))=1">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'Name,Category,SpaceNames')"/>
			</iso:assert>
			<!-- TODO Category Picklists -->
			<iso:assert id="Zone.SpaceNames.NotNull" test="iso:validString(SpaceNames)">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'SpaceNames')"/>
			</iso:assert>
			<iso:assert id="Zone.SpaceNames.CrossReference" test="iso:delimListInKeys(SpaceNames,'Space',/)">
				<value-of select="iso:foreignKeysMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'SpaceNames','Space','Name')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Types" id="COBie.Types" role="Errors">
			<iso:assert id="Types.AtLeastOne" test="Type">
				<name/>:  At least one Type must be provided</iso:assert>
		</iso:rule>
		<iso:rule context="//Types/Type" id="COBie.Types.Type" role="Errors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:assert id="Type.Component.AtLeastOneB" test="some $comp in ../../Components/Component satisfies ($comp/TypeName=@Name)">
				<name/>.<value-of select="@Name"/>: All Types must have at least one associated Component
			</iso:assert>
			<iso:assert id="Type.AssetType.NotNull" test="iso:validString(AssetType)">
				<value-of select="iso:notNullMessage(name(.),@Name,'AssetType')"/>
			</iso:assert>
			<iso:assert id="Type.ModelNumber.NotNull" test="iso:validString(ModelNumber)">
				<value-of select="iso:notNullMessage(name(.),@Name,'ModelNumber')"/>
			</iso:assert>
			<iso:assert id="Type.Manufacturer.NotNull" test="iso:validString(Manufacturer)">
				<value-of select="iso:notNullMessage(name(.),@Name,'Manufacturer')"/>
			</iso:assert>
			<iso:assert id="Type.Manufacturer.Reference" test="key('ContactKey',Manufacturer)">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'Manufacturer','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorParts.NotNull" test="iso:validString(WarrantyGuarantorParts)">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyGuarantorParts')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorParts.Reference" test="key('ContactKey',WarrantyGuarantorParts)">
				<value-of select="iso:foreignKeyMessage(name(.),WarrantyGuarantorParts,'WarrantyGuarantorParts','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorLabor.NotNull" test="iso:validString(WarrantyGuarantorLabor)">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyGuarantorLabor')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorLabor.Reference" test="key('ContactKey',WarrantyGuarantorLabor)">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'WarrantyGuarantorLabor,','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyDurationLabor.ZeroOrGreater" test="iso:validNumberZeroOrGreater(WarrantyDurationLabor)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'WarrantyDurationLabor')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyDurationParts.ZeroOrGreater" test="iso:validNumberZeroOrGreater(WarrantyDurationParts)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'WarrantyDurationParts')"/>
			</iso:assert>
			<iso:assert id="Type.ReplacementCost.ZeroOrGreater" test="iso:validNumberZeroOrGreater(ReplacementCost)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'ReplacementCost')"/>
			</iso:assert>
			<iso:assert id="Type.ExpectedLife.ZeroOrGreater" test="iso:validNumberZeroOrGreater(ExpectedLife)">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'ExpectedLife')"/>
			</iso:assert>
			<iso:assert id="Type.Size.NotEmpty" test="iso:validStringOrNA(Size)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Size')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyDurationUnit.NotNull" test="iso:validString(WarrantyDurationUnit)">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyDurationUnit')"/>
			</iso:assert>
			<iso:assert id="Type.DurationUnit.NotNull" test="iso:validString(DurationUnit)">
				<value-of select="iso:notNullMessage(name(.),@Name,'DurationUnit')"/>
			</iso:assert>
			<iso:assert id="Type.NominalLength.NotNull" test="iso:validString(NominalLength)">
				<value-of select="iso:notNullMessage(name(.),@Name,'NominalLength')"/>
			</iso:assert>
			<iso:assert id="Type.NominalWidth.NotNull" test="iso:validString(NominalWidth)">
				<value-of select="iso:notNullMessage(name(.),@Name,'NominalWidth')"/>
			</iso:assert>
			<iso:assert id="Type.NominalHeight.NotNull" test="iso:validString(NominalHeight)">
				<value-of select="iso:notNullMessage(name(.),@Name,'NominalHeight')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyDescription.NotEmpty" test="iso:validStringOrNA(WarrantyDescription)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'WarrantyDescription')"/>
			</iso:assert>
			<iso:assert id="Type.ModelReference.NotEmpty" test="iso:validStringOrNA(ModelReference)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ModelReference')"/>
			</iso:assert>
			<iso:assert id="Type.Shape.NotEmpty" test="iso:validStringOrNA(Shape)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Shape')"/>
			</iso:assert>
			<iso:assert id="Type.Color.NotEmpty" test="iso:validStringOrNA(Color)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Color')"/>
			</iso:assert>
			<iso:assert id="Type.Finish.NotEmpty" test="iso:validStringOrNA(Finish)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Finish')"/>
			</iso:assert>
			<iso:assert id="Type.Grade.NotEmpty" test="iso:validStringOrNA(Grade)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Grade')"/>
			</iso:assert>
			<iso:assert id="Type.Material.NotEmpty" test="iso:validStringOrNA(Material)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Material')"/>
			</iso:assert>
			<iso:assert id="Type.Constituents.NotEmpty" test="iso:validStringOrNA(Constituents)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Constituents')"/>
			</iso:assert>
			<iso:assert id="Type.Features.NotEmpty" test="iso:validStringOrNA(Features)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Features')"/>
			</iso:assert>
			<iso:assert id="Type.AccessibilityPerformance.NotEmpty" test="iso:validStringOrNA(AccessibilityPerformance)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'AccessibilityPerformance')"/>
			</iso:assert>
			<iso:assert id="Type.CodePerformance.NotEmpty" test="iso:validStringOrNA(CodePerformance)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'CodePerformance')"/>
			</iso:assert>
			<iso:assert id="Type.SustainabilityPerformance.NotEmpty" test="iso:validStringOrNA(SustainabilityPerformance)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'SustainabilityPerformance')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Components" id="COBie.Components" role="Errors">
			<iso:assert id="Components.AtLeastOneComponent" test="Component">
				<name/>:  at least one Component must be provided.</iso:assert>
		</iso:rule>
		<iso:rule context="//Components/Component" id="COBie.Components.Component" role="Errors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:assert id="Component.TypeName.NotNull" test="iso:validString(TypeName)">
				<value-of select="iso:notNullMessage(name(.),@Name,'TypeName')"/>
			</iso:assert>
			<iso:assert id="Component.TypeName.Reference" test="key('TypeKey',TypeName)">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'TypeName','Type','Name')"/>
			</iso:assert>
			<iso:assert id="Component.Space.NotNull" test="iso:validString(Space)">
				<value-of select="iso:notNullMessage(name(.),@Name,'Space')"/>
			</iso:assert>
			<iso:assert id="Component.Space.Reference" test="iso:componentSpaceKeyMatch(Space,ExtObject,/)">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'Space','Space','Name')"/>
			</iso:assert>
			<iso:assert id="Component.Description.NotNull" test="iso:validString(Description)">
				<value-of select="iso:notNullMessage(name(.),@Name,'Description')"/>
			</iso:assert>
			<iso:assert id="Component.SerialNumber.NotEmpty" test="iso:validStringOrNA(SerialNumber)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'SerialNumber')"/>
			</iso:assert>
			<iso:assert id="Component.InstallationDate.NotNull" test="iso:validString(InstallationDate)">
				<value-of select="iso:notNullMessage(name(.),@Name,'InstallationDate')"/>
			</iso:assert>
			<iso:assert id="Component.WarrantyStartDate.NotNull" test="iso:validString(WarrantyStartDate)">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyStartDate')"/>
			</iso:assert>
			<iso:assert id="Component.TagNumber.NotEmpty" test="iso:validStringOrNA(TagNumber)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'TagNumber')"/>
			</iso:assert>
			<iso:assert id="Component.BarCode.NotEmpty" test="iso:validStringOrNA(BarCode)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'BarCode')"/>
			</iso:assert>
			<iso:assert id="Component.AssetIdentifier.NotEmpty" test="iso:validStringOrNA(AssetIdentifier)">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'AssetIdentifier')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Systems/System" id="COBie.Systems.System" role="Errors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:assert id="System.Name.Unique" test="count(key('SystemKey',concat(@Name,',',Category,',',ComponentNames)))=1">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',Category,',',ComponentNames),'Name,Category,ComponentNames')"/>
			</iso:assert>
			<iso:assert id="System.Name.NotNull" test="iso:validString(@Name)">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',ComponentNames),'Name')"/>
			</iso:assert>
			<iso:assert id="System.ComponentNames.NotNull" test="iso:validString(ComponentNames)">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',ComponentNames),'ComponentNames')"/>
			</iso:assert>
			<iso:assert id="System.ComponentNames.Reference" test="iso:delimListInKeys(ComponentNames,'Component',/)">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',Category,',',ComponentNames),ComponentNames,'Component','Name')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Attributes/Attribute" id="Attribute" role="Errors">
			<iso:assert id="AttributeKeyUnique" test="count(key('AttributeKey',concat(concat(concat( concat(@Name,',') ,SheetName),','),RowName)))=1">Attribute <value-of select="@Name"/>,<value-of select="SheetName"/>,<value-of select="RowName"/>:  Attribute Name, Sheet Name, Row Name must be unique</iso:assert>
			<iso:assert id="AttributeSheetMatch" test="iso:keyMatch(SheetName,RowName,/)">Attribute <value-of select="@Name"/>:  SheetName and RowName must reference an existing row in one of the COBie worksheets.  <value-of select="SheetName"/>, <value-of select="RowName"/> is invalid.</iso:assert>
		</iso:rule>
	</iso:pattern>
</iso:schema>
