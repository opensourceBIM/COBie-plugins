<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://docs.buildingsmartalliance.org/nbims03/cobie/schematron/functions" xmlns:cfn="http://docs.buildingsmartalliance.org/nbims03/cobie/schematron/functions" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<!-- KEYS and INDEXES for COBie Worksheets -->
	<xsl:key name="AssemblyKey" match="Assemblies/Assembly" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="AssemblyKeyAlternate" match="Assemblies/Assembly" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="AttributeCategoryKey" match="Attribute" use="normalize-space(lower-case(Category))"/>
	<xsl:key name="AttributeKey" match="Attributes/Attribute" use="normalize-space(lower-case(concat(@Name, ',', SheetName, ',', RowName, ',', Category)))"/>
	<xsl:key name="AttributeNameKey" match="Attribute" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="AttributeRowNameKey" match="Attributes/Attribute" use="normalize-space(lower-case(RowName))"/>
	<xsl:key name="AttributeSheetNameKey" match="Attribute" use="normalize-space(lower-case(SheetName))"/>
	<xsl:key name="ComponentKey" match="Components/Component" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="ComponentKeyAlternate" match="Components/Component" use="normalize-space(lower-case(concat(@Name,',',Space)))"/>
	<xsl:key name="ContactKey" match="Contacts/Contact" use="normalize-space(lower-case(Email))"/>
	<xsl:key name="ConnectionKey" match="Connections/Connection" use="@Name"/>
	<xsl:key name="DocumentKey" match="Documents/Document" use="normalize-space(lower-case(concat(@Name,',',Stage,',',SheetName,',',RowName)))"/>
	<xsl:key name="DocumentNameKey" match="Document" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="DocumentRowNameKey" match="Documents/Document" use="normalize-space(lower-case(RowName))"/>
	<xsl:key name="DocumentSheetNameKey" match="Document" use="normalize-space(lower-case(SheetName))"/>
	<xsl:key name="DocumentStageKey" match="Document" use="normalize-space(lower-case(Stage))"/>
	<xsl:key name="FacilityKey" match="Facilities/Facility" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="FloorKey" match="Floors/Floor" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="JobKey" match="Jobs/Job" use="normalize-space(lower-case(concat(@Name,',',TypeName,',',TaskNumber)))"/>
	<xsl:key name="PicklistKey" match="CobiePicklists/SheetPicklists/Picklist" use="concat(normalize-space(lower-case(../@SheetName)),',',normalize-space(lower-case(@ColumnName)))"/>
	<xsl:key name="ResourceKey" match="Resources/Resource" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="SpaceKey" match="Spaces/Space" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="SpaceKeyAlternate" match="Spaces/Space" use="normalize-space(lower-case(concat(@Name,',',FloorName)))"/>
	<xsl:key name="SpareKey" match="Spares/Spare" use="normalize-space(lower-case(concat(@Name,',',TypeName)))"/>
	<xsl:key name="SpareKeyAlternate" match="Spares/Spare" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="SystemKey" match="Systems/System" use="normalize-space(lower-case(concat(@Name,',',Category,',',ComponentNames)))"/>
	<xsl:key name="SystemKeyAlternate" match="Systems/System" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="TypeKey" match="Types/Type" use="normalize-space(lower-case(@Name))"/>
	<xsl:key name="ZoneKey" match="Zones/Zone" use="normalize-space(lower-case(concat(@Name,',',Category,',',SpaceNames)))"/>
	<xsl:key name="ZoneKeyAlternate" match="Zones/Zone" use="normalize-space(lower-case(@Name))"/>
	<!-- FUNCTIONS -->
	<xsl:function name="cfn:assertMsgPrefix" as="xs:string">
		<!--**This function returns a string that is used as a prefix for assert error messages in the format of SheetName.RowName: Field Name -->
		<xsl:param name="SheetName" as="xs:string?"/>
		<!--**The COBie worksheet name that is the subject of the error message-->
		<xsl:param name="RowKey" as="xs:string?"/>
		<!--**The key value for the row that is the subject of the error message (see getKeyValue).-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The name of the field that is the subject of the error message -->
		<xsl:choose>
			<xsl:when test="$RowKey">
				<xsl:value-of select="concat($SheetName,'.',$RowKey,':  ',cfn:assertMsgSubject($SheetName,$FieldName))"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat($SheetName,':  ',cfn:assertMsgSubject($SheetName,$FieldName))"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:assertMsgSubject" as="xs:string">
		<!--**This function returns a string that represents the Subject of an error message in the format SheetName.FieldName.  This function is called by assertMsgPrefix. -->
		<xsl:param name="SheetName"/>
		<!--**The COBie worksheet name that is the subject of the error message-->
		<xsl:param name="FieldName"/>
		<!--**The name of the field that is the subject of the error message -->
		<xsl:value-of select="concat($SheetName,'.',$FieldName)"/>
	</xsl:function>
	<xsl:function name="cfn:atLeastOneMessage" as="xs:string">
		<!--**This function returns an error message for failed assertions that test if there is at least one of something - e.g. At least one Space. -->
		<xsl:param name="SheetNameSingular" as="xs:string?"/>
		<!--**The singular form of the COBie Spreadsheet name referenced by this error message.-->
		<xsl:param name="SheetNamePlural" as="xs:string?"/>
		<!--**The plural form of the COBie Spreadsheet name referenced by this error message. -->
		<xsl:value-of select="concat($SheetNamePlural,' must have at least one ',$SheetNameSingular)"/>
	</xsl:function>
	<xsl:function name="cfn:canComponentBeInTwoSpaces" as="xs:boolean">
		<!--**This function returns true if a call to stringContainsWindowOrDoor is true using the Name, Description, or TypeName fields.  This function also returns true if the extObject=autodesk.revit.db.familyinstance:ost_windows, or extObject=autodesk.revit.db.familyinstance:ost_doors or if the extObject field is invalid.  Otherwise, this function returns a false.  Note that this is not a definitive test of whether or not a Component represents a door or a window, but it is an approximate guess based on requirements that were discovered during the COBie challenge events. In the future it may be useful to add tests on category.-->
		<xsl:param name="extObject" as="xs:string?"/>
		<!--**The value of the extObject field of the Component. -->
		<xsl:param name="Name" as="xs:string?"/>
		<!--**The value of the Component Name field-->
		<xsl:param name="Description" as="xs:string?"/>
		<!--**The value of the Component Description field-->
		<xsl:param name="TypeName" as="xs:string?"/>
		<!--**The value of the Component TypeName field-->
		<xsl:choose>
			<xsl:when test="(lower-case($extObject)='ifcwindow' or lower-case($extObject)='ifcdoor') or 
				cfn:stringContainsWindowOrDoor($Name) or
				cfn:stringContainsWindowOrDoor($Description) or
				cfn:stringContainsWindowOrDoor($TypeName) or  
				lower-case($extObject)='autodesk.revit.db.familyinstance:ost_windows' or 
				lower-case($extObject)='autodesk.revit.db.familyinstance:ost_doors' or 
				not(cfn:validString($extObject))">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:checkPicklist" as="xs:boolean">
		<!--**This function returns true if the sheetname colname parameters do not have a corresponding picklist or if the value parameter is a value in the matching picklist (if one exists for the sheetname colname) -->
		<xsl:param name="sheetName" as="xs:string?"/>
		<!--**The COBie spreadsheet name to use for looking up the picklist -->
		<xsl:param name="colName" as="xs:string?"/>
		<!--**The spreadsheet column name to use for looking up the picklist-->
		<xsl:param name="value" as="xs:string?"/>
		<!--**The value to check for adherance to a picklist-->
		<xsl:param name="Context"/>
		<!--**The context of the check-->
		<xsl:variable name="strValue" select="string($value)" />
		<xsl:variable name="picklistMatch" select="key('PicklistKey',concat(normalize-space(lower-case($sheetName)),',',normalize-space(lower-case($colName))),$Context/parent::*/parent::*)"/>
		<xsl:choose>
			<xsl:when test="not(count($picklistMatch) &gt; 0)">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="count($picklistMatch[1]/PicklistValue[normalize-space(lower-case(text())) = normalize-space(lower-case($strValue))]) > 0">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isComponentDoor" as="xs:boolean">
		<!--**This function returns true if the extObject, Name, Description, or TypeName fields of a Component contain "Door" or if extObject="autodesk.revit.db.familyinstance:ost_doors."  Otherwise this function returns a false. -->
		<xsl:param name="extObject" as="xs:string?"/>
		<!--**The value of the extObject field of the Component. -->
		<xsl:param name="Name" as="xs:string?"/>
		<!--**The value of the Component Name field. -->
		<xsl:param name="Description" as="xs:string?"/>
		<!--**The value of the Component Description field. -->
		<xsl:param name="TypeName" as="xs:string?"/>
		<!--**The value of the Component TypeName field. -->
		<xsl:choose>
			<!--Need to check for name containing dooralso need to check for is external -->
			<xsl:when test="(lower-case($extObject)='ifcdoor') or 
				cfn:stringContainsDoor($Name) or
				cfn:stringContainsDoor($Description) or
				cfn:stringContainsDoor($TypeName) or  
				lower-case($extObject)='autodesk.revit.db.familyinstance:ost_doors'">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:stringContainsWindowOrDoor" as="xs:boolean">
		<!--**This function returns a boolean value that returns true if  $text = ifcWindow, $text= ifcDoor or if the $text contains "door" or if the Description contains"window."  Otherwise, this function returns false. -->
		<xsl:param name="text" as="xs:string?"/>
		<!--**The text to test. -->
		<xsl:choose>
			<xsl:when test="contains(lower-case($text),'window') or contains(lower-case($text),'door')">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:stringContainsDoor" as="xs:boolean">
		<xsl:param name="text" as="xs:string?"/>
		<xsl:choose>
			<xsl:when test="contains(lower-case($text),'door')">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:componentSpaceForeignKeyMessage" as="xs:string">
		<!--**This function returns an error message related to the assignment of a component to more than one space.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the error.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The name of the field (e.g. Component.Space).-->
		<xsl:param name="FSheet" as="xs:string?"/>
		<!--**The name of the foreign key field (e.g. Space)-->
		<xsl:param name="FKey" as="xs:string?"/>
		<!--**The value of the Space foreign Key-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<!--**The sheet name (e.g. Component)-->
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<!--**The key value of the Component row that is tested.-->
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey,'.  If component is a window or door it may be placed in up to two spaces, but only one otherwise.')"/>
	</xsl:function>
	<xsl:function name="cfn:componentSpaceKeyMatch" as="xs:boolean">
		<!--**This function returns true if $space is a reference to a row in the Space worksheet.  If the extObject field indicates that the Component is a space or a window, then space may be parsed as a comma delimited value where all spaces in the comma delimted list are tested.-->
		<xsl:param name="space" as="xs:string?"/>
		<!--**The value in Component.Space.-->
		<xsl:param name="extObject" as="xs:string?"/>
		<!--**The value in Component.extObject-->
		<xsl:param name="RootContext"/>
		<!--**The context of the root of the COBieTab XML document-->
		<xsl:param name="ItemContext"/>
		<!--**The context of the Component row-->
		<xsl:choose>
			<xsl:when test="cfn:canComponentBeInTwoSpaces($extObject, $ItemContext/@Name, $ItemContext/Description, $ItemContext/TypeName)">
				<xsl:value-of select="cfn:delimPairInKeys($space,'Space',$RootContext)"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="cfn:keyMatch('Space',$space,$RootContext)"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:dateTimeFormatMessage" as="xs:string">
		<!--**This function returns a message related to date-time format errors typically found in the "CreatedBy" columns. -->
		<xsl:param name="Context"/>
		<!--**The XPath context of the subject node-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name that is the subject of the message-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<!--**The COBie worksheet name that is the subject of this error message-->
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<!--**The key value for the subject row in the worksheet -->
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be in the correct format (YYYY-MM-DDTHH:MM:SS)')"/>
	</xsl:function>
	<xsl:function xmlns="http://purl.oclc.org/dsdl/schematron" name="cfn:delimListInKeys" as="xs:boolean">
		<!--**This function tests key values in delimString against a specific key named by keyName.  The function returns true if the keey value references an existing row, and it returns false otherwise.-->
		<xsl:param name="delimString" as="xs:string?"/>
		<!--**The key value.  For sheets that have compound keys, the field values are comma delimted.  (See the keys at the top of the COBieRules_Functions.xsl file)-->
		<xsl:param name="keyName" as="xs:string?"/>
		<!--**The name of the key (see the keys in the top of the COBieRules_Functions.xsl file)-->
		<xsl:param name="context"/>
		<!--**The XPath context of the tested node.-->
		<xsl:choose>
			<xsl:when test="contains($delimString,',')">
				<xsl:variable name="tokenizedString" select="tokenize($delimString,',')"/>
				<xsl:variable name="booleanList">
					<xsl:for-each select="$tokenizedString">
						<xsl:choose>
							<xsl:when test="cfn:keyMatch($keyName,normalize-space(.),$context)">
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
					<xsl:when test="cfn:keyMatch($keyName,$delimString,$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function xmlns="http://purl.oclc.org/dsdl/schematron" name="cfn:delimPairInKeys" as="xs:boolean">
		<!--**Tests the validity of a comma delimted list of key values for a specific key.  Returns true if the key references -->
		<xsl:param name="delimString" as="xs:string?"/>
		<!--**A key value.  For sheets that have compound keys, the fields are comma delimted.  See the block of key elements at the top of COBieRules_Functions.xsl-->
		<xsl:param name="keyName" as="xs:string?"/>
		<!--**The name of the key to be tested.-->
		<xsl:param name="context"/>
		<!--**The XPath context of the test.-->
		<xsl:choose>
			<xsl:when test="contains($delimString,',')">
				<xsl:variable name="tokenizedString" select="tokenize($delimString,',')"/>
				<xsl:variable name="booleanList">
					<xsl:for-each select="$tokenizedString">
						<xsl:choose>
							<xsl:when test="cfn:keyMatch($keyName,normalize-space(.),$context)">
								<xsl:value-of select="true()"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="false()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:for-each>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="$booleanList[text()='false'] or count($booleanList/text())>2">
						<xsl:value-of select="false()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="true()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="cfn:keyMatch($keyName,$delimString,$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:foreignKeyMessage" as="xs:string">
		<!--**This function returns an error message related to invalid foreign key values in the format, SheetName.RowKeyValue.FieldName must exist in ForeignKeySheetName.RowKey-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the message subject.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name of the message subject.-->
		<xsl:param name="FSheet" as="xs:string?"/>
		<!--**The foreign key COBie spreadsheet name.-->
		<xsl:param name="FKey" as="xs:string?"/>
		<!--**The foreign key value in the current Context.-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey)"/>
	</xsl:function>
	<xsl:function name="cfn:foreignKeysMessage" as="xs:string">
		<!--**This function returns an error message related to invalid foreign key values in the format, SheetName.RowKeyValue.FieldName must exist in ForeignKeySheetName.RowKey. The FKey parameter may contain multiple comma delimted values.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the message subject.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name of the message subject.-->
		<xsl:param name="FSheet" as="xs:string?"/>
		<!--**The foreign key COBie spreadsheet name.-->
		<xsl:param name="FKey" as="xs:string?"/>
		<!--**The foreign key value in the current Context.-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey, ' (comma delimitted list for multiple entries is acceptable)')"/>
	</xsl:function>
	<xsl:function name="cfn:getKeyAlternateValue" as="xs:string">
		<!--**This function returns the key value of the current context according to an alternate key representation where Space is keyed by SpaceName, Floor name, Zone is keyed by Name, Component is keyed by Name and Space, System is keyed by name, and Assembly is keyed by Name.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the node to generate the key of..-->
		<xsl:param name="SheetName"/>
		<!--**The COBie spreadsheet name of the current context.-->
		<xsl:variable name="LowerSheetName" select="lower-case($SheetName)"/>
		<xsl:choose>
			<xsl:when test="$LowerSheetName='space'">
				<xsl:value-of select="concat($Context/@Name,',',$Context/FloorName)"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="$LowerSheetName='zone'">
						<xsl:value-of select="$Context/@Name"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="$LowerSheetName='component'">
								<xsl:value-of select="concat($Context/@Name,',',$Context/Space)"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:choose>
									<xsl:when test="$LowerSheetName='system'">
										<xsl:value-of select="$Context/@Name"/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:choose>
											<xsl:when test="$LowerSheetName='assembly'">
												<xsl:value-of select="$Context/@Name"/>
											</xsl:when>
											<xsl:otherwise>
												<xsl:value-of select="generate-id($Context)"/>
											</xsl:otherwise>
										</xsl:choose>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:getKeyValue" as="xs:string">
		<!--**This function returns the key value of the node in the current Context according to the COBie primary keys. See the block of keys in the beginning of the COBieRules_Functions.xsl file.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the referenced node.-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="LowerSheetName" select="lower-case($SheetName)"/>
		<xsl:choose>
			<xsl:when test="$LowerSheetName='contact'">
				<xsl:value-of select="$Context/Email"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="$LowerSheetName='facility'">
						<xsl:value-of select="$Context/@Name"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="$LowerSheetName='floor'">
								<xsl:value-of select="$Context/@Name"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:choose>
									<xsl:when test="$LowerSheetName='space'">
										<xsl:value-of select="$Context/@Name"/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:choose>
											<xsl:when test="$LowerSheetName='zone'">
												<xsl:value-of select="concat($Context/@Name,',',$Context/Category,',',$Context/SpaceNames)"/>
											</xsl:when>
											<xsl:otherwise>
												<xsl:choose>
													<xsl:when test="$LowerSheetName='type'">
														<xsl:value-of select="$Context/@Name"/>
													</xsl:when>
													<xsl:otherwise>
														<xsl:choose>
															<xsl:when test="$LowerSheetName='component'">
																<xsl:value-of select="$Context/@Name"/>
															</xsl:when>
															<xsl:otherwise>
																<xsl:choose>
																	<xsl:when test="$LowerSheetName='system'">
																		<xsl:value-of select="concat($Context/@Name,',',$Context/Category,',',$Context/ComponentNames)"/>
																	</xsl:when>
																	<xsl:otherwise>
																		<xsl:choose>
																			<xsl:when test="$LowerSheetName='assembly'">
																				<xsl:value-of select="$Context/@Name"/>
																			</xsl:when>
																			<xsl:otherwise>
																				<xsl:choose>
																					<xsl:when test="$LowerSheetName='connection'">
																						<xsl:value-of select="$Context/@Name"/>
																					</xsl:when>
																					<xsl:otherwise>
																						<xsl:choose>
																							<xsl:when test="$LowerSheetName='spare'">
																								<xsl:value-of select="concat($Context/@Name,',',$Context/TypeName)"/>
																							</xsl:when>
																							<xsl:otherwise>
																								<xsl:choose>
																									<xsl:when test="$LowerSheetName='resource'">
																										<xsl:value-of select="$Context/@Name"/>
																									</xsl:when>
																									<xsl:otherwise>
																										<xsl:choose>
																											<xsl:when test="$LowerSheetName='job'">
																												<xsl:value-of select="concat($Context/@Name,',',$Context/TypeName,',',$Context/TaskNumber)"/>
																											</xsl:when>
																											<xsl:otherwise>
																												<xsl:choose>
																													<xsl:when test="$LowerSheetName='document'">
																														<xsl:value-of select="concat($Context/@Name,',',$Context/Stage,',',$Context/SheetName,',',$Context/RowName)"/>
																													</xsl:when>
																													<xsl:otherwise>
																														<xsl:choose>
																															<xsl:when test="$LowerSheetName='attribute'">
																																<xsl:value-of select="concat($Context/@Name, ',', $Context/SheetName, ',', $Context/RowName, ',', $Context/Category)"/>
																															</xsl:when>
																															<xsl:otherwise>
																																<xsl:value-of select="generate-id($Context)"/>
																															</xsl:otherwise>
																														</xsl:choose>
																													</xsl:otherwise>
																												</xsl:choose>
																											</xsl:otherwise>
																										</xsl:choose>
																									</xsl:otherwise>
																								</xsl:choose>
																							</xsl:otherwise>
																						</xsl:choose>
																					</xsl:otherwise>
																				</xsl:choose>
																			</xsl:otherwise>
																		</xsl:choose>
																	</xsl:otherwise>
																</xsl:choose>
															</xsl:otherwise>
														</xsl:choose>
													</xsl:otherwise>
												</xsl:choose>
											</xsl:otherwise>
										</xsl:choose>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:getLocation">
		<!--**This function returns the Sheet name and row position of the current context in the format SheetName[row number].  This function is typically used to generate error messages that reference a specific COBie worksheet row.-->
		<xsl:param name="context"/>
		<!--**The XPath context of the node to get the location of-->
		<xsl:param name="position"/>
		<!--**The position of the node that is the subject of this message.-->
		<xsl:value-of select="concat(name($context), '[', $position, ']')"/>
	</xsl:function>
	<xsl:function name="cfn:hasAttribute" as="xs:boolean">
		<!--**This function tests to see if a specific row in a COBie worksheet has a specific attribute in the Attribute worksheet. -->
		<xsl:param name="Context"/>
		<!--**The XPath context of the node to be tested.-->
		<xsl:param name="AttributeName"/>
		<!--**The name of the attribute that will be used in the query for existing attributes of the tested node.-->
		<xsl:param name="SheetName"/>
		<!--**The COBie worksheet name of the node that is tested.-->
		<xsl:param name="RowName"/>
		<!--**The value of the Name field of the tested node.-->
		<xsl:variable name="AttributeMatches">
			<xsl:copy-of select="$Context/../../Attributes/Attribute[upper-case(@Name)=upper-case($AttributeName) and upper-case(RowName)=upper-case($RowName) and upper-case(SheetName)=upper-case($SheetName) and cfn:validString(Value)]"/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="count($AttributeMatches/*:Attribute) > 0">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isAttributeKeyUnique" as="xs:boolean">
		<!--**This function returns true if there is one and only one Attribute with the specified Name, RowName, SheetName, and Category of the Attribute in the current Context.-->
		<xsl:param name="Context"/>
		<!--**XPath context of the tested Attribute.-->
		<xsl:variable name="Name" select="$Context/@Name"/>
		<xsl:variable name="RowName" select="$Context/RowName"/>
		<xsl:variable name="SheetName" select="$Context/SheetName"/>
		<xsl:variable name="Category" select="$Context/Category"/>
		<xsl:variable name="RowMatches">
			<xsl:copy-of select="key('AttributeRowNameKey',normalize-space(lower-case($RowName)),$Context/parent::*)"/>
		</xsl:variable>
		<xsl:variable name="NameMatches">
			<xsl:copy-of select="key('AttributeNameKey',normalize-space(lower-case($Name)),$RowMatches)"/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="count($NameMatches/*:Attribute)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="SheetMatches">
					<xsl:copy-of select="key('AttributeSheetNameKey',normalize-space(lower-case($SheetName)),$NameMatches)"/>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="count($SheetMatches/*:Attribute)=1">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:variable name="CategoryMatches">
							<xsl:copy-of select="key('AttributeCategoryKey',normalize-space(lower-case($Category)),$SheetMatches)"/>
						</xsl:variable>
						<xsl:choose>
							<xsl:when test="count($CategoryMatches/*:Attribute)=1 or not(cfn:isFirstRepeatedKeyValue('Attribute',$Context))">
								<xsl:value-of select="true()"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="false()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isDocumentKeyUnique" as="xs:boolean">
		<!--**This function tests to see if there is one and only one Document with Name, RowName, SheetName, and Stage equal to the values found in the Context parameter (a pointer to a Document).-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the Document that will be tested-->
		<xsl:variable name="Name" select="$Context/@Name"/>
		<xsl:variable name="RowName" select="$Context/RowName"/>
		<xsl:variable name="SheetName" select="$Context/SheetName"/>
		<xsl:variable name="Stage" select="$Context/Stage"/>
		<xsl:variable name="RowMatches">
			<xsl:copy-of select="key('DocumentRowNameKey',normalize-space(lower-case($RowName)),$Context/parent::*)"/>
		</xsl:variable>
		<xsl:variable name="NameMatches">
			<xsl:copy-of select="key('DocumentNameKey',normalize-space(lower-case($Name)),$RowMatches)"/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="count($NameMatches/*:Document)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="SheetMatches">
					<xsl:copy-of select="key('DocumentSheetNameKey',normalize-space(lower-case($SheetName)),$NameMatches)"/>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="count($SheetMatches/*:Document)=1">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:variable name="StageMatches">
							<xsl:copy-of select="key('DocumentStageKey',normalize-space(lower-case($Stage)),$SheetMatches)"/>
						</xsl:variable>
						<xsl:choose>
							<xsl:when test="count($StageMatches/*:Document)=1 or not(cfn:isFirstRepeatedKeyValue('Document',$Context))">
								<xsl:value-of select="true()"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="false()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isFirstRepeatedFieldValue" as="xs:boolean">
		<!--**This function returns a true if the row represeted by context has a value is the first repeated instance of the field represented by fieldName.  Otherwise this function returns false.-->
		<xsl:param name="context"/>
		<!--**The XPath context of the row that is tested-->
		<xsl:param name="fieldName"/>
		<!--**The field name that is tested.-->
		<xsl:variable name="contextElementValue" select="$context/child::*[name()=$fieldName]/text()"/>
		<xsl:variable name="contextAttributeValue" select="string($context/attribute::*[name()=$fieldName])"/>
		<xsl:variable name="countPreviousElementMatch" select="count($context/preceding-sibling::*/child::*[name()=$fieldName and $contextElementValue=text()])"/>
		<xsl:variable name="countPreviousAttributeMatch" select="count($context/preceding-sibling::*/attribute::*[name()=$fieldName and string()=$contextAttributeValue])"/>
		<xsl:choose>
			<xsl:when test="$countPreviousElementMatch=1 or $countPreviousAttributeMatch=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isFirstRepeatedKeyAlternateValue" as="xs:boolean">
		<!--**This function returns a true if the current context key value is the first repeated instance of the alternate key value in the worksheet represented by the context parameter.  Otherwise this function returns false.-->
		<xsl:param name="SheetName"/>
		<!--**COBie worksheet name of the tested row.-->
		<xsl:param name="Context"/>
		<!--**XPath context of the tested row.-->
		<xsl:variable name="KeyValue" select="cfn:getKeyAlternateValue($Context,$SheetName)"/>
		<xsl:variable name="MatchingSiblings" select="$Context/preceding-sibling::*[cfn:getKeyAlternateValue(.,$SheetName)=$KeyValue]"/>
		<xsl:choose>
			<xsl:when test="count($MatchingSiblings)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isFirstRepeatedKeyValue" as="xs:boolean">
		<!--**This function returns a true if the current context key value is the first repeated instance of the key value in the worksheet represented by the context parameter.  Otherwise this function returns false.-->
		<xsl:param name="SheetName"/>
		<!--**COBie worksheet name of the tested row.-->
		<xsl:param name="Context"/>
		<!--**XPath context of the tested row.-->
		<xsl:variable name="KeyValue" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MatchingSiblings" select="$Context/preceding-sibling::*[cfn:getKeyValue(.)=$KeyValue]"/>
		<xsl:choose>
			<xsl:when test="count($MatchingSiblings)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:isKeyAlternateUnique" as="xs:boolean">
		<!--**This function returns true if and only if the key value of the current context is unique.  The alternate key representation schema is used for the test - see the block of keys at the beginning of the COBieRules_Functions.xsl file.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the COBie row that is tested.-->
		<xsl:variable name="SheetName" select="name($Context)"/>
		<xsl:variable name="KeyValue" select="cfn:getKeyAlternateValue($Context,$SheetName)"/>
		<xsl:variable name="KeyName" select="concat($SheetName,'KeyAlternate')"/>
		<xsl:variable name="KeyMatchCount" select="count(key($KeyName,normalize-space(lower-case($KeyValue)),$Context/parent::*))"/>
		<xsl:value-of select="$KeyMatchCount=1 or not(cfn:isFirstRepeatedKeyAlternateValue($SheetName,$Context))"/>
	</xsl:function>
	<xsl:function name="cfn:isKeyUnique" as="xs:boolean">
		<!--**This function returns true if and only if the key value of the current context is unique. See the block of keys at the beginning of the COBieRules_Functions.xsl file.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the COBie row that is tested.-->
		<xsl:variable name="SheetName" select="name($Context)"/>
		<xsl:variable name="KeyValue" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="KeyName" select="concat($SheetName,'Key')"/>
		<xsl:variable name="KeyMatchCount" select="count(key($KeyName,normalize-space(lower-case($KeyValue)),$Context/parent::*))"/>
		<xsl:value-of select="$KeyMatchCount=1 or not(cfn:isFirstRepeatedKeyValue($SheetName,$Context))"/>
	</xsl:function>
	<xsl:function name="cfn:keyMatch" as="xs:boolean">
		<!--**This function returns true if and only if the COBie Spreadsheet represented by sheetName contains at least one entry with the specified keyValue.-->
		<xsl:param name="sheetName"/>
		<!--**The COBie worksheet name of the worksheet that will be searched for instances of the key value.-->
		<xsl:param name="keyValue"/>
		<!--**The key value that will be used in the query.-->
		<xsl:param name="context"/>
		<!--**The XPath context of the node that is tested.  Note that this will probably not be in the same worksheet as sheetName since this function is typically used to test the validity of foreign keys.-->
		<xsl:choose>
			<xsl:when test="(lower-case($sheetName)='facility') or (lower-case($sheetName)='floor') or (lower-case($sheetName)='space') or (lower-case($sheetName)='zone')  or (lower-case($sheetName)='contact')  or (lower-case($sheetName)='type') or (lower-case($sheetName)='component') or (lower-case($sheetName)='system') or (lower-case($sheetName)='assembly') or (lower-case($sheetName)='spare') or (lower-case($sheetName)='connection') or (lower-case($sheetName)='resource') or (lower-case($sheetName)='job') or (lower-case($sheetName)='document')">
				<xsl:variable name="keyName" select="concat(cfn:titleCase($sheetName),'Key')"/>
				<xsl:choose>
					<xsl:when test="key($keyName,normalize-space(lower-case($keyValue)),$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="(lower-case($sheetName)='system' or lower-case($sheetName)='assembly' or lower-case($sheetName)='zone' or lower-case($sheetName)='spare') and key(concat($keyName,'Alternate'),normalize-space(lower-case($keyValue)),$context)">
								<xsl:value-of select="true()"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="false()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:notEmptyMessage" as="xs:string">
		<!--**This function returns an error message that states that states that a field value "must be provided (n/a is acceptable").-->
		<xsl:param name="Context"/>
		<!--**The context of the subject of the error message.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name that is subject of the error message.-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is acceptable)')"/>
	</xsl:function>
	<xsl:function name="cfn:picklistMessage" as="xs:string">
		<!--**This function displays a picklist error message - to be displayed when a value does not pass picklist checking. -->
		<xsl:param name="Context"/>
		<!--**The context of the subject of the error message -->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The subject field name -->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be one of the Picklist values.')"/>
	</xsl:function>
	<xsl:function name="cfn:notEmptyNumberMessage" as="xs:string">
		<!--**This function returns an error message that n/a or a valid number must be provided in a specific field-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the subject of the error message.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name that is the subject of the error message.-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a should be used if value is unknown, further restrictions may apply to some fields, e.g. lengths>=0)')"/>
	</xsl:function>
	<xsl:function name="cfn:notNullNumberMessage" as="xs:string">
		<!--**This function returns an error message that states that a numeric field value must be provided and that n/a is not acceptable.-->
		<xsl:param name="SheetName" as="xs:string?"/>
		<!--**The COBie worksheet name that is the subject of the error message.-->
		<xsl:param name="RowKey" as="xs:string?"/>
		<!--**The row key value of the message subject.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name of the message subject.-->
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is not acceptable, further restrictions may apply to some fields, e.g. lengths>=0)')"/>
	</xsl:function>
	<xsl:function name="cfn:notNullMessage" as="xs:string">
		<!--**This function produces an error message that states that a specific field value must be provided and that n/a is unacceptable.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the message subject.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name of the message subject.-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<!--**The COBie worksheet name of the message subject.-->
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is unacceptable)')"/>
	</xsl:function>
	<xsl:function name="cfn:onlyOneMessage" as="xs:string">
		<!--**This function returns an error message that states that x must have exactly one y, where x is a singular string and y is a plural string.  For example, this function is used to produce the message, "Facilities must have exactly one Facility."-->
		<xsl:param name="SheetNameSingular" as="xs:string?"/>
		<!--**The singular name of the COBie Worksheet referenced by the error message.-->
		<xsl:param name="SheetNamePlural" as="xs:string?"/>
		<!--**The plural name of the COBie Worksheet referenced by the error message.-->
		<xsl:variable name="Msg" select="' must have exactly one '"/>
		<xsl:value-of select="concat($SheetNamePlural,' must have exactly one ',$SheetNameSingular)"/>
	</xsl:function>
	<xsl:function name="cfn:reportAssertMessage">
		<!--**This function returns a message with information about the specified Assertion, represented by AssertionId.  This function should be deprecated since it is cujrrently returning the input parameter.-->
		<xsl:param name="AssertionId"/>
		<!--**The assertion Id of the message subject.-->
		<xsl:value-of select="$AssertionId"/>
	</xsl:function>
	<xsl:function name="cfn:reportCheckMessage">
		<!--**This function returns a message that references a sheet name and a field name and is used to indicate that a given field is under test.-->
		<xsl:param name="SheetName"/>
		<!--**The COBie worksheet name of the message subject.-->
		<xsl:param name="FieldName"/>
		<!--**The COBie worksheet field name of the message subject.-->
		<xsl:value-of select="cfn:assertMsgSubject($SheetName,$FieldName)"/>
	</xsl:function>
	<xsl:function name="cfn:reportNumberOfMessage" as="xs:string">
		<!--**This function returns a message that returns RowCount and SheetNamePlural delimted by a space. This function may need to be deprecated since it is currently performing a very simple operation.-->
		<xsl:param name="SheetNamePlural"/>
		<xsl:param name="RowCount"/>
		<xsl:value-of select="concat(string($RowCount),' ',$SheetNamePlural)"/>
	</xsl:function>
	<xsl:function name="cfn:titleCase" as="xs:string">
		<!--**This function converts a provided string to proper title case - e.g. facilities becomes Facilities.-->
		<xsl:param name="str" as="xs:string?"/>
		<!--**The string to be converted into Title case.-->
		<xsl:sequence select="string-join(for $x in tokenize($str,'\s') return
concat(upper-case(substring($x, 1, 1)), lower-case(substring($x, 2))), ' ')"/>
	</xsl:function>
	<xsl:function name="cfn:uniqueNameMessage" as="xs:string">
		<!--**This function returns an error message that states that a specific COBie worksheet row must have a unique name.-->
		<xsl:param name="Context"/>
		<!--**The XPath context of the message subject-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name of the message subject-->
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be unique')"/>
	</xsl:function>
	<xsl:function name="cfn:uniqueNameWarningMessage" as="xs:string">
		<!--**This function returns a warning message that a specific COBie worksheet row must have a unique key -->
		<xsl:param name="SheetName" as="xs:string?"/>
		<!--**The COBie worksheet name of the message subject.-->
		<xsl:param name="RowKey" as="xs:string?"/>
		<!--**The row key value of the message subject.-->
		<xsl:param name="FieldName" as="xs:string?"/>
		<!--**The field name of the message subject-->
		<xsl:param name="AltKey" as="xs:string?"/>
		<!--**The alternate key of the message subject if one exists-->
		<xsl:variable name="MsgPrefix" as="xs:string?" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat('Warning:  ',$MsgPrefix,' must be unique, but ',$AltKey,' is acceptable')"/>
	</xsl:function>
	<xsl:function name="cfn:validDateTime" as="xs:boolean">
		<!--**This function returns true if the text parameter represents a valid date-time string, and this function returns a false otherwise.-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed.-->
		<xsl:choose>
			<xsl:when test="$text castable as xs:dateTime">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validEmail" as="xs:boolean">
		<!--**This function returns a true if the text parameter represents a correctly formatted email address (xxxx@yyy.zzz) and false otherwise-->
		<xsl:param name="text" as="xs:string?"/>
		<!--**The text that will be parsed.-->
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
	<xsl:function name="cfn:validNumber" as="xs:boolean">
		<!--**This function returns a true if the text parameter represents a valid numeric value and false otherwise-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed-->
		<xsl:choose>
			<xsl:when test="($text castable as xs:decimal) or ($text castable as xs:float) or (lower-case($text)='n/a')">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validNumberNotNA" as="xs:boolean">
		<!--**This function returns a true if the text parameter represents a valid numeric value or contains "n/a," otherwise this function returns false-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed..-->
		<xsl:choose>
			<xsl:when test="($text castable as xs:decimal) or ($text castable as xs:float)">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validNumberNotNANotZero" as="xs:boolean">
		<!--**This function returns a true if the text parameter represents a valid numeric value and is "n/a" and is not "0".-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed-->
		<xsl:choose>
			<xsl:when test="not(cfn:validNumberNotNA($text))">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="not(number($text)=0)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="false()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validNumberNotZero" as="xs:boolean">
		<!--**This function returns a true if the text parameter contains a valid numeric value and it is not equal to "0".-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed-->
		<xsl:choose>
			<xsl:when test="not(cfn:validNumber($text))">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="lower-case($text)='n/a'">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="not(number($text)=0)">
								<xsl:value-of select="true()"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="false()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validNumberNotNAZeroOrGreater" as="xs:boolean">
		<!--**This function returns a true if the text parameter contains a valid numeric value, the value is not "n/a," and the value is greater than 0. Otherwise this function returns false.-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed.-->
		<xsl:choose>
			<xsl:when test="not(cfn:validNumberNotNA($text))">
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
	<xsl:function name="cfn:validNumberZeroOrGreater" as="xs:boolean">
		<!--**This function returns a true if the text parameter contains a valid numeric value that is greater than or equal to zero, and otherwise the function returns false.-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed.-->
		<xsl:choose>
			<xsl:when test="not(cfn:validNumber($text))">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="lower-case($text)='n/a'">
						<xsl:value-of select="true()"/>
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
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validString" as="xs:boolean">
		<!--**This function returns a false if the text parameter is empty or contains "n/a," otherwise this function returns true -->
		<xsl:param name="text"/>
		<!--**The text that will be parsed.-->
		<xsl:choose>
			<xsl:when test="string-length(normalize-space($text))=0 or lower-case(normalize-space($text))='n/a'">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="true()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:validStringOrNA" as="xs:boolean">
		<!--**This function returns true if the text parameter is not an empty string.-->
		<xsl:param name="text"/>
		<!--**The text that will be parsed-->
		<xsl:choose>
			<xsl:when test="string-length(normalize-space($text))=0">
				<xsl:value-of select="false()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="true()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:WorksheetCountRole">
		<!--**This function returns a string constant "WorksheetCount" that corresponds to role attributes in the COBieRules.sch file.-->
		<xsl:value-of>WorksheetCount</xsl:value-of>
	</xsl:function>
	<xsl:function name="cfn:WorksheetErrorRole">
		<!--**This function returns a string constant "WorksheetErrors" that corresponds to role attributes in the COBieRules.sch file.-->
		<xsl:value-of>WorksheetErrors</xsl:value-of>
	</xsl:function>
	<xsl:function name="cfn:WorksheetName">
		<!--**This function returns the COBie worksheet name of the specific XPath context..-->
		<xsl:param name="Context"/>
		<!--**The XPath context of a COBie worksheet row-->
		<xsl:value-of select="$Context/local-name()"/>
	</xsl:function>
</xsl:stylesheet>
