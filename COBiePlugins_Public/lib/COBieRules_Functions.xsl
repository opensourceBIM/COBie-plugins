<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://docs.buildingsmartalliance.org/nbims03/cobie/schematron/functions" xmlns:cfn="http://docs.buildingsmartalliance.org/nbims03/cobie/schematron/functions" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:key name="AssemblyKey" match="Assemblies/Assembly" use="@Name"/>
	<xsl:key name="AssemblyKeyAlternate" match="Assemblies/Assembly" use="@Name"/>
	<xsl:key name="AttributeCategoryKey" match="Attribute" use="Category"/>
	<xsl:key name="AttributeKey" match="Attributes/Attribute" use="concat(@Name, ',', SheetName, ',', RowName, ',', Category)"/>
	<xsl:key name="AttributeNameKey" match="Attribute" use="@Name"/>
	<xsl:key name="AttributeRowNameKey" match="Attributes/Attribute" use="RowName"/>
	<xsl:key name="AttributeSheetNameKey" match="Attribute" use="SheetName"/>
	<xsl:key name="ComponentKey" match="Components/Component" use="@Name"/>
	<xsl:key name="ComponentKeyAlternate" match="Components/Component" use="concat(@Name,',',Space)"/>
	<xsl:key name="ContactKey" match="Contacts/Contact" use="Email"/>
	<xsl:key name="ConnectionKey" match="Connections/Connection" use="@Name"/>
	<xsl:key name="DocumentKey" match="Documents/Document" use="concat(@Name,',',Stage,',',SheetName,',',RowName)"/>
	<xsl:key name="DocumentNameKey" match="Document" use="@Name"/>
	<xsl:key name="DocumentRowNameKey" match="Documents/Document" use="RowName"/>
	<xsl:key name="DocumentSheetNameKey" match="Document" use="SheetName"/>
	<xsl:key name="DocumentStageKey" match="Document" use="Stage"/>
	<xsl:key name="FacilityKey" match="Facilities/Facility" use="@Name"/>
	<xsl:key name="FloorKey" match="Floors/Floor" use="@Name"/>
	<xsl:key name="JobKey" match="Jobs/Job" use="concat(@Name,',',TypeName,',',TaskNumber)"/>
	<xsl:key name="ResourceKey" match="Resources/Resource" use="@Name"/>
	<xsl:key name="SpaceKey" match="Spaces/Space" use="@Name"/>
	<xsl:key name="SpaceKeyAlternate" match="Spaces/Space" use="concat(@Name,',',FloorName)"/>
	<xsl:key name="SpareKey" match="Spares/Spare" use="concat(@Name,',',TypeName)"/>
	<xsl:key name="SystemKey" match="Systems/System" use="concat(@Name,',',Category,',',ComponentNames)"/>
	<xsl:key name="SystemKeyAlternate" match="Systems/System" use="@Name"/>
	<xsl:key name="TypeKey" match="Types/Type" use="@Name"/>
	<xsl:key name="ZoneKey" match="Zones/Zone" use="concat(@Name,',',Category,',',SpaceNames)"/>
	<xsl:key name="ZoneKeyAlternate" match="Zones/Zone" use="@Name"/>
	<xsl:function name="cfn:assertMsgPrefix" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
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
		<xsl:param name="SheetName"/>
		<xsl:param name="FieldName"/>
		<xsl:value-of select="concat($SheetName,'.',$FieldName)"/>
	</xsl:function>
	<xsl:function name="cfn:atLeastOneMessage" as="xs:string">
		<xsl:param name="SheetNameSingular" as="xs:string"/>
		<xsl:param name="SheetNamePlural" as="xs:string"/>
		<xsl:value-of select="concat($SheetNamePlural,' must have at least one ',$SheetNameSingular)"/>
	</xsl:function>
	<xsl:function name="cfn:canComponentBeInTwoSpaces" as="xs:boolean">
		<xsl:param name="extObject" as="xs:string"/>
		<xsl:param name="Name" as="xs:string"/>
		<xsl:param name="Description" as="xs:string"/>
		<xsl:param name="TypeName" as="xs:string"/>
		<xsl:choose>
			<!--Need to check for name containing door or window...also need to check for is external -->
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
	<xsl:function name="cfn:stringContainsWindowOrDoor" as="xs:boolean">
		<xsl:param name="text" as="xs:string"/>
		<xsl:choose>
			<xsl:when test="contains(lower-case($text),'window') or contains(lower-case($text),'door')">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="cfn:componentSpaceForeignKeyMessage" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="FSheet" as="xs:string"/>
		<xsl:param name="FKey" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey,'.  If component is a window or door it may be placed in up to two spaces, but only one otherwise.')"/>
	</xsl:function>
	<xsl:function name="cfn:componentSpaceKeyMatch" as="xs:boolean">
		<xsl:param name="space" as="xs:string"/>
		<xsl:param name="extObject" as="xs:string"/>
		<xsl:param name="RootContext"/>
		<xsl:param name="ItemContext"/>
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
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be in the correct format (YYYY-MM-DDTHH:MM:SS)')"/>
	</xsl:function>
	<xsl:function xmlns="http://purl.oclc.org/dsdl/schematron" name="cfn:delimListInKeys" as="xs:boolean">
		<xsl:param name="delimString" as="xs:string"/>
		<xsl:param name="keyName" as="xs:string"/>
		<xsl:param name="context"/>
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
		<xsl:param name="delimString" as="xs:string"/>
		<xsl:param name="keyName" as="xs:string"/>
		<xsl:param name="context"/>
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
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="FSheet" as="xs:string"/>
		<xsl:param name="FKey" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey)"/>
	</xsl:function>
	<xsl:function name="cfn:foreignKeysMessage" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="FSheet" as="xs:string"/>
		<xsl:param name="FKey" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey, ' (comma delimitted list for multiple entries is acceptable)')"/>
	</xsl:function>
	<xsl:function name="cfn:getKeyAlternateValue" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="SheetName"/>
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
		<xsl:param name="Context"/>
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
		<xsl:param name="context"/>
		<xsl:param name="position"/>
		<xsl:value-of select="concat(name($context), '[', $position, ']')"/>
	</xsl:function>
	<xsl:function name="cfn:isAttributeKeyUnique" as="xs:boolean">
		<xsl:param name="Context"/>
		<xsl:variable name="Name" select="$Context/@Name"/>
		<xsl:variable name="RowName" select="$Context/RowName"/>
		<xsl:variable name="SheetName" select="$Context/SheetName"/>
		<xsl:variable name="Category" select="$Context/Category"/>
		<xsl:variable name="RowMatches">
			<xsl:copy-of select="key('AttributeRowNameKey',$RowName,$Context/parent::*)"/>
		</xsl:variable>
		<xsl:variable name="NameMatches">
			<xsl:copy-of select="key('AttributeNameKey',$Name,$RowMatches)"/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="count($NameMatches/*:Attribute)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="SheetMatches">
					<xsl:copy-of select="key('AttributeSheetNameKey',$SheetName,$NameMatches)"/>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="count($SheetMatches/*:Attribute)=1">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:variable name="CategoryMatches">
							<xsl:copy-of select="key('AttributeCategoryKey',$Category,$SheetMatches)"/>
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
		<xsl:param name="Context"/>
		<xsl:variable name="Name" select="$Context/@Name"/>
		<xsl:variable name="RowName" select="$Context/RowName"/>
		<xsl:variable name="SheetName" select="$Context/SheetName"/>
		<xsl:variable name="Stage" select="$Context/Stage"/>
		<xsl:variable name="RowMatches">
			<xsl:copy-of select="key('DocumentRowNameKey',$RowName,$Context/parent::*)"/>
		</xsl:variable>
		<xsl:variable name="NameMatches">
			<xsl:copy-of select="key('DocumentNameKey',$Name,$RowMatches)"/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="count($NameMatches/*:Document)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="SheetMatches">
					<xsl:copy-of select="key('DocumentSheetNameKey',$SheetName,$NameMatches)"/>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="count($SheetMatches/*:Document)=1">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:variable name="StageMatches">
							<xsl:copy-of select="key('DocumentStageKey',$Stage,$SheetMatches)"/>
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
		<xsl:param name="context"/>
		<xsl:param name="fieldName"/>
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
		<xsl:param name="SheetName"/>
		<xsl:param name="Context"/>
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
		<xsl:param name="SheetName"/>
		<xsl:param name="Context"/>
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
		<xsl:param name="Context"/>
		<xsl:variable name="SheetName" select="name($Context)"/>
		<xsl:variable name="KeyValue" select="cfn:getKeyAlternateValue($Context,$SheetName)"/>
		<xsl:variable name="KeyName" select="concat($SheetName,'KeyAlternate')"/>
		<xsl:variable name="KeyMatchCount" select="count(key($KeyName,$KeyValue,$Context/parent::*))"/>
		<xsl:value-of select="$KeyMatchCount=1 or not(cfn:isFirstRepeatedKeyAlternateValue($SheetName,$Context))"/>
	</xsl:function>
	<xsl:function name="cfn:isKeyUnique" as="xs:boolean">
		<xsl:param name="Context"/>
		<xsl:variable name="SheetName" select="name($Context)"/>
		<xsl:variable name="KeyValue" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="KeyName" select="concat($SheetName,'Key')"/>
		<xsl:variable name="KeyMatchCount" select="count(key($KeyName,$KeyValue,$Context/parent::*))"/>
		<xsl:value-of select="$KeyMatchCount=1 or not(cfn:isFirstRepeatedKeyValue($SheetName,$Context))"/>
	</xsl:function>
	<xsl:function name="cfn:keyMatch" as="xs:boolean">
		<xsl:param name="sheetName"/>
		<xsl:param name="keyValue"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="(lower-case($sheetName)='facility') or (lower-case($sheetName)='floor') or (lower-case($sheetName)='space') or (lower-case($sheetName)='zone')  or (lower-case($sheetName)='contact')  or (lower-case($sheetName)='type') or (lower-case($sheetName)='component') or (lower-case($sheetName)='system') or (lower-case($sheetName)='assembly') or (lower-case($sheetName)='connection') or (lower-case($sheetName)='spare') or (lower-case($sheetName)='resource') or (lower-case($sheetName)='job') or (lower-case($sheetName)='document')">
				<xsl:variable name="keyName" select="concat(cfn:titleCase($sheetName),'Key')"/>
				<xsl:choose>
					<xsl:when test="key($keyName,$keyValue,$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="(lower-case($sheetName)='system' or lower-case($sheetName)='assembly' or lower-case($sheetName)='zone') and key(concat($keyName,'Alternate'),$keyValue,$context)">
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
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is acceptable)')"/>
	</xsl:function>
	<xsl:function name="cfn:notEmptyNumberMessage" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a should be used if value is unknown, further restrictions may apply to some fields, e.g. lengths>=0)')"/>
	</xsl:function>
	<xsl:function name="cfn:notNullNumberMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is not acceptable, further restrictions may apply to some fields, e.g. lengths>=0)')"/>
	</xsl:function>
	<xsl:function name="cfn:notNullMessage" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is unacceptable)')"/>
	</xsl:function>
	<xsl:function name="cfn:onlyOneMessage" as="xs:string">
		<xsl:param name="SheetNameSingular" as="xs:string"/>
		<xsl:param name="SheetNamePlural" as="xs:string"/>
		<xsl:variable name="Msg" select="' must have exactly one '"/>
		<xsl:value-of select="concat($SheetNamePlural,' must have exactly one ',$SheetNameSingular)"/>
	</xsl:function>
	<xsl:function name="cfn:reportAssertMessage">
		<xsl:param name="AssertionId"/>
		<xsl:value-of select="$AssertionId"/>
	</xsl:function>
	<xsl:function name="cfn:reportCheckMessage">
		<xsl:param name="SheetName"/>
		<xsl:param name="FieldName"/>
		<xsl:value-of select="cfn:assertMsgSubject($SheetName,$FieldName)"/>
	</xsl:function>
	<xsl:function name="cfn:reportNumberOfMessage" as="xs:string">
		<xsl:param name="SheetNamePlural"/>
		<xsl:param name="RowCount"/>
		<xsl:value-of select="concat(string($RowCount),' ',$SheetNamePlural)"/>
	</xsl:function>
	<xsl:function name="cfn:titleCase" as="xs:string">
		<xsl:param name="str" as="xs:string"/>
		<xsl:sequence select="string-join(for $x in tokenize($str,'\s') return
concat(upper-case(substring($x, 1, 1)), lower-case(substring($x, 2))), ' ')"/>
	</xsl:function>
	<xsl:function name="cfn:uniqueNameMessage" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="SheetName" select="cfn:WorksheetName($Context)"/>
		<xsl:variable name="RowKey" select="cfn:getKeyValue($Context)"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be unique')"/>
	</xsl:function>
	<xsl:function name="cfn:uniqueNameWarningMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="AltKey" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="cfn:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat('Warning:  ',$MsgPrefix,' must be unique, but ',$AltKey,' is acceptable')"/>
	</xsl:function>
	<xsl:function name="cfn:validDateTime" as="xs:boolean">
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
	<xsl:function name="cfn:validEmail" as="xs:boolean">
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
	<xsl:function name="cfn:validNumber" as="xs:boolean">
		<xsl:param name="text"/>
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
		<xsl:param name="text"/>
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
		<xsl:param name="text"/>
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
		<xsl:param name="text"/>
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
		<xsl:param name="text"/>
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
		<xsl:param name="text"/>
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
		<xsl:param name="text"/>
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
	<xsl:function name="cfn:WorksheetCountRole">
		<xsl:value-of>WorksheetCount</xsl:value-of>
	</xsl:function>
	<xsl:function name="cfn:WorksheetErrorRole">
		<xsl:value-of>WorksheetErrors</xsl:value-of>
	</xsl:function>
	<xsl:function name="cfn:WorksheetName">
		<xsl:param name="Context"/>
		<xsl:value-of select="$Context/local-name()"/>
	</xsl:function>
</xsl:stylesheet>
