<?xml version="1.0" encoding="utf-8"?>
<!-- edited with XMLSpy v2011 rel. 2 sp1 (http://www.altova.com) by US Army Corp of Engineers (US Army Corp of Engineers) -->
<iso:schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:iso="http://purl.oclc.org/dsdl/schematron" xmlns:xs="http://www.w3.org/2001/XMLSchema" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" schemaVersion="ISO19757-3" defaultPhase="#ALL">
	<xsl:key name="ContactKey" match="//Contacts/Contact" use="Email"/>
	<xsl:key name="FacilityKey" match="//Facilities/Facility" use="@Name"/>
	<xsl:key name="FloorKey" match="//Floors/Floor" use="@Name"/>
	<xsl:key name="SpaceKey" match="//Spaces/Space" use="@Name"/>
	<xsl:key name="SpaceKeyLite" match="//Spaces/Space" use="concat(@Name,',',FloorName)"/>
	<xsl:key name="ZoneKey" match="//Zones/Zone" use="concat(@Name,',',Category,',',SpaceNames)"/>
	<xsl:key name="ZoneKeyLite" match="//Zones/Zone" use="@Name"/>
	<xsl:key name="TypeKey" match="//Types/Type" use="@Name"/>
	<xsl:key name="ComponentKey" match="//Components/Component" use="@Name"/>
	<xsl:key name="ComponentKeyLite" match="//Components/Component" use="concat(@Name,',',Space)"/>
	<xsl:key name="SystemKey" match="//Systems/System" use="concat(@Name,',',Category,',',ComponentNames)"/>
	<xsl:key name="SystemKeyLite" match="//Systems/System" use="@Name"/>
	<xsl:key name="AssemblyKey" match="//Assemblies/Assembly" use="concat(@Name,',',SheetName,',',ParentName,',',ChildNames)"/>
	<xsl:key name="AssemblyKeyLite" match="//Assemblies/Assembly" use="@Name"/>
	<xsl:key name="ConnectionKey" match="//Connections/Connection" use="concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2)"/>
	<xsl:key name="SpareKey" match="//Spares/Spare" use="@Name"/>
	<xsl:key name="ResourceKey" match="//Resources/Resource" use="@Name"/>
	<xsl:key name="JobKey" match="//Jobs/Job" use="concat(@Name,',',TypeName,',',TaskNumber)"/>
	<xsl:key name="DocumentKey" match="//Documents/Document" use="concat(@Name,',',Stage,',',SheetName,',',RowName)"/>
	<xsl:key name="AttributeKey" match="//Attributes/Attribute" use="concat(concat(concat(concat(@Name,',') ,SheetName),','),RowName)"/>
	<xsl:function name="iso:WorksheetCountRole">
		<xsl:value-of>WorksheetCount</xsl:value-of>
	</xsl:function>
	<xsl:function name="iso:WorksheetErrorRole">
		<xsl:value-of>WorksheetErrors</xsl:value-of>
	</xsl:function>

	<xsl:function name="iso:getKeyValue" as="xs:string">
		<xsl:param name="Context"/>
		<xsl:param name="SheetName"/>
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
																					<xsl:value-of select="concat($Context/@Name,',',$Context/SheetName,',',$Context/ParentName,',',$Context/ChildNames)"/>
																				</xsl:when>
																				<xsl:otherwise>
																					<xsl:choose>
																						<xsl:when test="$LowerSheetName='connection'">
																							<xsl:value-of select="concat($Context/@Name,',',$Context/ConnectionType,',',$Context/SheetName,',',$Context/RowName1,',',$Context/RowName2)"/>
																						</xsl:when>
																						<xsl:otherwise>
																							<xsl:choose>
																								<xsl:when test="$LowerSheetName='spare'">
																									<xsl:value-of select="$Context/@Name"/>
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
																															<xsl:value-of select="concat($Context/@Name,',',$Context/SheetName,',',$Context/RowName)"/>
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
	<xsl:function name="iso:getKeyLiteValue" as="xs:string">
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
	<xsl:function name="iso:isFirstRepeatedFieldValue" as="xs:boolean">
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
	<xsl:function name="iso:isFirstRepeatedKeyValue" as="xs:boolean">
		<xsl:param name="SheetName"/>		
		<xsl:param name="Context"/>
		<xsl:variable name="KeyValue" select="iso:getKeyValue($Context,$SheetName)"/>
		<xsl:variable name="MatchingSiblings" select="$Context/preceding-sibling::*[iso:getKeyValue(.,$SheetName)=$KeyValue]"/>
		<xsl:choose>
			<xsl:when test="count($MatchingSiblings)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
		<xsl:function name="iso:isFirstRepeatedKeyLiteValue" as="xs:boolean">
		<xsl:param name="SheetName"/>		
		<xsl:param name="Context"/>
		<xsl:variable name="KeyValue" select="iso:getKeyLiteValue($Context,$SheetName)"/>
		<xsl:variable name="MatchingSiblings" select="$Context/preceding-sibling::*[iso:getKeyLiteValue(.,$SheetName)=$KeyValue]"/>
		<xsl:choose>
			<xsl:when test="count($MatchingSiblings)=1">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:isKeyUnique" as="xs:boolean">
		<xsl:param name="Context"/>
		<xsl:variable name="SheetName" select="name($Context)"/>
		<xsl:variable name="KeyValue" select="iso:getKeyValue($Context,$SheetName)"/>
		<xsl:variable name="KeyName" select="concat($SheetName,'Key')"/>
		<xsl:variable name="KeyMatchCount" select="count(key($KeyName,$KeyValue,$Context/parent::*))"/>
		<xsl:value-of select="$KeyMatchCount=1 or not(iso:isFirstRepeatedKeyValue($SheetName,$Context))"/>
	</xsl:function>
		<xsl:function name="iso:isKeyLiteUnique" as="xs:boolean">
		<xsl:param name="Context"/>
		<xsl:variable name="SheetName" select="name($Context)"/>
		<xsl:variable name="KeyValue" select="iso:getKeyLiteValue($Context,$SheetName)"/>
		<xsl:variable name="KeyName" select="concat($SheetName,'KeyLite')"/>
		<xsl:variable name="KeyMatchCount" select="count(key($KeyName,$KeyValue,$Context/parent::*))"/>
		<xsl:value-of select="$KeyMatchCount=1 or not(iso:isFirstRepeatedKeyLiteValue($SheetName,$Context))"/>
	</xsl:function>
	<xsl:function name="iso:canComponentBeInTwoSpaces" as="xs:boolean">
		<xsl:param name="extObject" as="xs:string"/>
		<xsl:choose>
			<xsl:when test="(lower-case($extObject)='ifcwindow' or lower-case($extObject)='ifcdoor') or lower-case($extObject)='autodesk.revit.db.familyinstance:ost_windows' or lower-case($extObject)='autodesk.revit.db.familyinstance:ost_doors' or not(iso:validString($extObject))">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:keyMatch" as="xs:boolean">
		<xsl:param name="sheetName"/>
		<xsl:param name="keyValue"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="(lower-case($sheetName)='facility') or (lower-case($sheetName)='floor') or (lower-case($sheetName)='space') or (lower-case($sheetName)='zone')  or (lower-case($sheetName)='contact')  or (lower-case($sheetName)='type') or (lower-case($sheetName)='component') or (lower-case($sheetName)='system') or (lower-case($sheetName)='assembly') or (lower-case($sheetName)='connection') or (lower-case($sheetName)='spare') or (lower-case($sheetName)='resource') or (lower-case($sheetName)='job') or (lower-case($sheetName)='document')">
				<xsl:variable name="keyName" select="concat(iso:titleCase($sheetName),'Key')"/>
				<xsl:choose>
					<xsl:when test="key($keyName,$keyValue,$context)">
						<xsl:value-of select="true()"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="(lower-case($sheetName)='system' or lower-case($sheetName)='assembly' or lower-case($sheetName)='zone') and key(concat($keyName,'Lite'),$keyValue,$context)">
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
	<xsl:function name="iso:componentSpaceKeyMatch" as="xs:boolean">
		<xsl:param name="space" as="xs:string"/>
		<xsl:param name="extObject" as="xs:string"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="iso:canComponentBeInTwoSpaces($extObject)">
				<xsl:value-of select="iso:delimPairInKeys($space,'Space',$context)"/>
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
							<xsl:when test="iso:keyMatch($keyName,normalize-space(.),$context)">
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
	<xsl:function xmlns="http://purl.oclc.org/dsdl/schematron" name="iso:delimPairInKeys" as="xs:boolean">
		<xsl:param name="delimString" as="xs:string"/>
		<xsl:param name="keyName" as="xs:string"/>
		<xsl:param name="context"/>
		<xsl:choose>
			<xsl:when test="contains($delimString,',')">
				<xsl:variable name="tokenizedString" select="tokenize($delimString,',')"/>
				<xsl:variable name="booleanList">
					<xsl:for-each select="$tokenizedString">
						<xsl:choose>
							<xsl:when test="iso:keyMatch($keyName,normalize-space(.),$context)">
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
	<xsl:function name="iso:reportCheckMessage">
		<xsl:param name="SheetName"/>
		<xsl:param name="FieldName"/>
		<xsl:value-of select="iso:assertMsgSubject($SheetName,$FieldName)"/>
	</xsl:function>
	<xsl:function name="iso:reportAssertMessage">
		<xsl:param name="AssertionId"/>
		<xsl:value-of select="$AssertionId"/>
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
		<xsl:function name="iso:uniqueNameWarningMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="AltKey" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat('Warning:  ',$MsgPrefix,' must be unique, but ',$AltKey,' is acceptable')"/>
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
	<xsl:function name="iso:componentSpaceForeignKeyMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:param name="FSheet" as="xs:string"/>
		<xsl:param name="FKey" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must exist in ',$FSheet,'.',$FKey,'.  If component is a window or door it may be placed in up to two spaces, but only one otherwise.')"/>
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
	<xsl:function name="iso:reportNumberOfMessage" as="xs:string">
		<xsl:param name="SheetNamePlural"/>
		<xsl:param name="RowCount"/>
		<xsl:value-of select="concat(string($RowCount),' ',$SheetNamePlural)"/>
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
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a should be used if value is unknown, further restrictions may apply to some fields, e.g. lengths>=0)')"/>
	</xsl:function>
	<xsl:function name="iso:notNullNumberMessage" as="xs:string">
		<xsl:param name="SheetName" as="xs:string"/>
		<xsl:param name="RowKey" as="xs:string"/>
		<xsl:param name="FieldName" as="xs:string"/>
		<xsl:variable name="MsgPrefix" as="xs:string" select="iso:assertMsgPrefix($SheetName,$RowKey,$FieldName)"/>
		<xsl:value-of select="concat($MsgPrefix,' must be provided (n/a is not acceptable, further restrictions may apply to some fields, e.g. lengths>=0)')"/>
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
			<xsl:when test="($text castable as xs:decimal) or ($text castable as xs:float) or (lower-case($text)='n/a')">
				<xsl:value-of select="true()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="false()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="iso:validNumberNotNA" as="xs:boolean">
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
	<xsl:function name="iso:validNumberNotNANotZero" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not(iso:validNumberNotNA($text))">
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
	<xsl:function name="iso:validNumberNotZero" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not(iso:validNumber($text))">
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
	<xsl:function name="iso:validNumberZeroOrGreater" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not(iso:validNumber($text))">
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
	<xsl:function name="iso:validNumberNotNAZeroOrGreater" as="xs:boolean">
		<xsl:param name="text"/>
		<xsl:choose>
			<xsl:when test="not(iso:validNumberNotNA($text))">
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
	<iso:pattern id="COBieValidation.Information">
		<iso:title>Worksheet Counts</iso:title>
		<iso:rule context="//Contacts" id="COBie.Contacts" role="WorksheetCount">
			<iso:assert id="Contacts.AtLeastOneContact" test="Contact">
				<value-of select="iso:atLeastOneMessage('Contact','Contacts')"/>
			</iso:assert>
			<iso:report id="Contacts.ReportNumberOf" test="Contact">
				<value-of select="iso:reportNumberOfMessage('Contacts',count(Contact))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Facilities" id="COBie.Facilities" role="WorksheetCount">
			<iso:report id="Facilities.ReportNumberOf" test="Facility">
				<value-of select="iso:reportNumberOfMessage('Facilities',count(Facility))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Floors" id="COBie.Floors" role="WorksheetCount">
			<iso:report id="Floors.ReportNumberOf" test="Floor">
				<value-of select="iso:reportNumberOfMessage('Floors',count(Floor))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Spaces" id="COBie.Spaces" role="WorksheetCount">
			<iso:report id="Spaces.ReportNumberOf" test="Space">
				<value-of select="iso:reportNumberOfMessage('Spaces',count(Space))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Zones" id="COBie.Zones" role="WorksheetCount">
			<iso:report id="Zones.ReportNumberOf" test="Zone">
				<value-of select="iso:reportNumberOfMessage('Zones',count(Zone))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Types" id="COBie.Types" role="WorksheetCount">
			<iso:report id="Types.ReportNumberOf" test="Type">
				<value-of select="iso:reportNumberOfMessage('Types',count(Type))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Components" id="COBie.Components" role="WorksheetCount">
			<iso:report id="Components.ReportNumberOf" test="Component">
				<value-of select="iso:reportNumberOfMessage('Components',count(Component))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Systems" id="COBie.Systems" role="WorksheetCount">
			<iso:report id="Systems.ReportNumberOf" test="System">
				<value-of select="iso:reportNumberOfMessage('Systems',count(System))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Assemblies" id="COBie.Assemblies" role="WorksheetCount">
			<iso:report id="Assemblies.ReportNumberOf" test="Assembly">
				<value-of select="iso:reportNumberOfMessage('Assemblies',count(Assembly))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Connections" id="COBie.Connections" role="WorksheetCount">
			<iso:report id="Connections.ReportNumberOf" test="Connection">
				<value-of select="iso:reportNumberOfMessage('Connections',count(Connection))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Spares" id="COBie.Spares" role="WorksheetCount">
			<iso:report id="Spares.ReportNumberOf" test="Spare">
				<value-of select="iso:reportNumberOfMessage('Spares',count(Spare))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Resources" id="COBie.Resources" role="WorksheetCount">
			<iso:report id="Resources.ReportNumberOf" test="Resource">
				<value-of select="iso:reportNumberOfMessage('Resources',count(Resource))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Jobs" id="COBie.Jobs" role="WorksheetCount">
			<iso:report id="Jobs.ReportNumberOf" test="Job">
				<value-of select="iso:reportNumberOfMessage('Jobs',count(Job))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Documents" id="COBie.Documents" role="WorksheetCount">
			<iso:report id="Documents.ReportNumberOf" test="Document">
				<value-of select="iso:reportNumberOfMessage('Documents',count(Document))"/>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Attributes" id="COBie.Attributes" role="WorksheetCount">
			<iso:report id="Attributes.ReportNumberOf" test="Attribute">
				<value-of select="iso:reportNumberOfMessage('Attributes',count(Attribute))"/>
			</iso:report>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="COBieValidation.Errors">
		<iso:title>COBie Checking Rules</iso:title>
		<iso:rule abstract="true" id="COBie.Abstract.Name" role="WorksheetErrors">
			<iso:report id="Common.Name.Check" test="true()" flag="Name">Name.NotNotNull, Name.Unique</iso:report>
			<iso:assert id="Common.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
			</iso:assert>
			<iso:assert id="Common.Name.Unique" test="iso:isKeyUnique(.)" flag="Name">  
				<value-of select="iso:uniqueNameMessage(name(.),@Name,'Name')"/>
			</iso:assert>
		</iso:rule>

		<iso:rule abstract="true" id="COBie.Abstract.Created" role="WorksheetErrors">
			<iso:report id="Common.CreatedBy.Check" test="true()" flag="CreatedBy">CreatedBy.CrossReference (ToContact), CreatedBy.NotNull</iso:report>
			<iso:assert id="Common.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)" flag="CreatedBy">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'CreatedBy','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="Common.CreatedBy.NotNull" test="iso:validString(CreatedBy)" flag="CreatedBy">
				<value-of select="iso:notNullMessage(name(.),@Name,'CreatedBy')"/>
			</iso:assert>
			<iso:report id="Common.CreatedOn.Check" test="true()" flag="CreatedOn">CreatedOn.NotNull, CreatedOn.Valid (Valid Email Address)</iso:report>
			<iso:assert id="Common.CreatedOn.NotNull" test="iso:validString(CreatedOn)" flag="CreatedOn">
				<value-of select="iso:notNullMessage(name(.),@Name,'CreatedOn')"/>
			</iso:assert>
			<iso:assert id="Common.CreatedOn.Valid" test="iso:validDateTime(CreatedOn)" flag="CreatedOn">
				<value-of select="iso:dateTimeFormatMessage(name(.),@Name,'CreatedOn')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.External" role="WorksheetErrors">
			<iso:report id="Common.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty</iso:report>
			<iso:assert id="Common.ExternalSystem.NotEmpty" test="iso:validStringOrNA(ExtSystem)" flag="ExtSystem">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExtSystem')"/>
			</iso:assert>
			<iso:report id="Common.ExternalObject.Check" test="true()" flag="ExtObject">ExternalObject.NotEmpty
			</iso:report>
			<iso:assert id="Common.External.ObjectNotEmpty" test="iso:validStringOrNA(ExtObject)" flag="ExtObject">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExtObject')"/>
			</iso:assert>
			<iso:report id="Common.ExternalIdentifier.Check" test="true()" flag="ExtIdentifier">ExtIdentifier.NotEmpty
			</iso:report>
			<iso:assert id="Common.ExternalIdentifier.NotEmpty" test="iso:validStringOrNA(ExtIdentifier)" flag="ExtIdentifier">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExtIdentifier')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Category" role="WorksheetErrors">
			<iso:report id="Common.Category.Check" test="true()" flag="Category">Category.NotNull
			</iso:report>
			<iso:assert id="Common.Category.NotNull" test="iso:validString(Category)" flag="Category">
				<value-of select="iso:notNullMessage(name(.),@Name,'Category')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Description" role="WorksheetErrors">
			<iso:report id="Common.Description.Check" test="true()" flag="Description">Description.NotEmpty
			</iso:report>
			<iso:assert id="Common.Description.NotEmpty" test="iso:validStringOrNA(Description)" flag="Description">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Description')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts" id="COBie.Contacts" role="WorksheetErrors">
			<iso:report id="Contact.Count.Check" test="true()" flag="ContactSheet">Contacts.AtLeastOneRowPresent
			</iso:report>
			<iso:assert id="Contacts.AtLeastOneRowPresent" test="Contact" flag="ContactSheet">
				<value-of select="iso:atLeastOneMessage('Contact','Contacts')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts/Contact" id="COBie.Contacts.Contact" role="WorksheetErrors">
			<iso:report id="Contact.Email.Check" test="true()" flag="Email">Email.Unique, Email.NotNull, Email.Format
			</iso:report>
			<!--<iso:assert id="Contact.Email.Unique" test="count(key(concat(name(.),'Key'),Email))=1 or not(iso:isFirstRepeatedKeyValue('Contact',.))" flag="Email">-->
			<iso:assert id="Contact.Email.Unique" test="iso:isKeyUnique(.)" flag="Email">
				<value-of select="iso:uniqueNameMessage(name(.),Email,'Email')"/>
			</iso:assert>
			<iso:assert id="Contact.Email.NotNull" test="iso:validString(Email)" flag="Email">
				<value-of select="iso:notNullMessage(name(.),Email,'Email')"/>
			</iso:assert>
			<iso:assert id="Contact.Email.Format" test="iso:validEmail(Email)" flag="Email">
				<value-of select="iso:assertMsgPrefix(name(.),Email,'Email')"/> must be a valid e-mail format (XXX@YYY.ZZZ)
			</iso:assert>
			<iso:report id="Contact.CreatedBy.Check" test="true()" flag="CreatedBy">CreatedBy.CrossReference, CreatedBy.NotNull
			</iso:report>
			<iso:assert id="Contact.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)" flag="CreatedBy">
				<value-of select="iso:foreignKeyMessage(name(.),Email,'CreatedBy','Contact','Email')"/>
			</iso:assert>
			<iso:assert id="Contact.CreatedBy.NotNull" test="iso:validString(CreatedBy)" flag="CreatedBy">
				<value-of select="iso:notNullMessage(name(.),Email,'CreatedBy')"/>
			</iso:assert>
			<iso:report id="Contact.CreatedOn.Check" test="true()" flag="CreatedOn">CreatedOn.NotNull, CreatedOn.Valid (ISO DateTime)
			</iso:report>
			<iso:assert id="Contact.CreatedOn.NotNull" test="iso:validString(CreatedOn)" flag="CreatedOn">
				<value-of select="iso:notNullMessage(name(.),Email,'CreatedOn')"/>
			</iso:assert>
			<iso:assert id="Contact.CreatedOn.Valid" test="iso:validDateTime(CreatedOn)" flag="CreatedOn">
				<value-of select="iso:dateTimeFormatMessage(name(.),Email,'CreatedOn')"/>
			</iso:assert>
			<iso:report id="Contact.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty
			</iso:report>
			<iso:assert id="ExternalSystem.NotEmpty" test="iso:validStringOrNA(ExternalSystem)" flag="ExternalSystem">
				<value-of select="iso:notEmptyMessage(name(.),Email,'ExternalSystem')"/>
			</iso:assert>
			<iso:report id="Contact.ExternalObject.Check" test="true()" flag="ExternalObject">ExternalObject.NotEmpty
			</iso:report>
			<iso:assert id="Contact.ExternalObject.NotEmpty" test="iso:validStringOrNA(ExternalObject)" flag="ExternalObject">
				<value-of select="iso:notEmptyMessage(name(.),Email,'ExternalObject')"/>
			</iso:assert>
			<iso:report id="Contact.ExternalIdentifier.Check" test="true()" flag="ExternalIdentifier">ExternalIdentifier.NotEmpty
			</iso:report>
			<iso:assert id="Contact.ExternalIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalIdentifier)" flag="ExternalIdentifier">
				<value-of select="iso:notEmptyMessage(name(.),Email,'ExternalIdentifier')"/>
			</iso:assert>
			<iso:report id="Contact.Category.Check" test="true()" flag="Category">Category.NotNull
			</iso:report>
			<iso:assert id="Contact.Category.NotNull" test="iso:validString(Category)" flag="Category">
				<value-of select="iso:notNullMessage(name(.),Email,'Category')"/>
			</iso:assert>
			<iso:report id="Contact.Company.Check" test="true()" flag="Company">Company.NotNull
			</iso:report>
			<iso:assert id="Contact.Company.NotNull" test="iso:validString(Company)" flag="Company">
				<value-of select="iso:assertMsgPrefix(name(.),Email,'Company')"/>  must be provided (n/a is not acceptable)</iso:assert>
			<iso:report id="Contact.Phone.Check" test="true()" flag="Phone">Phone.NotNull
			</iso:report>
			<iso:assert id="Contact.Phone.NotNull" test="iso:validString(Phone)" flag="Phone">
				<value-of select="iso:notNullMessage(name(.),Email,'Phone')"/>
			</iso:assert>
			<iso:report id="Contact.Department.Check" test="true()" flag="Department">Department.NotEmpty
			</iso:report>
			<iso:assert id="Contact.Department.NotEmpty" test="iso:validStringOrNA(Department)" flag="Department">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Department')"/>
			</iso:assert>
			<iso:report id="Contact.OrganizationCode.Check" test="true()" flag="OrganizationCode">OrganizationCode.NotEmpty
			</iso:report>
			<iso:assert id="Contact.OrganizationCode.NotEmpty" test="iso:validStringOrNA(OrganizationCode)" flag="OrganizationCode">
				<value-of select="iso:notEmptyMessage(name(.),Email,'OrganizationCode')"/>
			</iso:assert>
			<iso:report id="Contact.GivenName.Check" test="true()" flag="GivenName">GivenName.NotEmpty
			</iso:report>
			<iso:assert id="Contact.GivenName.NotEmpty" test="iso:validStringOrNA(GivenName)" flag="GivenName">
				<value-of select="iso:notEmptyMessage(name(.),Email,'GivenName')"/>
			</iso:assert>
			<iso:report id="Contact.FamilyName.Check" test="true()" flag="FamilyName">FamilyName.NotEmpty
			</iso:report>
			<iso:assert id="Contact.FamilyName.NotEmpty" test="iso:validStringOrNA(FamilyName)" flag="FamilyName">
				<value-of select="iso:notEmptyMessage(name(.),Email,'FamilyName')"/>
			</iso:assert>
			<iso:report id="Contact.Street.Check" test="true()" flag="Street">Street.NotEmpty
			</iso:report>
			<iso:assert id="Contact.Street.NotEmpty" test="iso:validStringOrNA(Street)" flag="Street">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Street')"/>
			</iso:assert>
			<iso:report id="Contact.PostalBox.Check" test="true()" flag="PostalBox">PostalBox.NotEmpty
			</iso:report>
			<iso:assert id="Contact.PostalBox.NotEmpty" test="iso:validStringOrNA(PostalBox)" flag="PostalBox">
				<value-of select="iso:notEmptyMessage(name(.),Email,'PostalBox')"/>
			</iso:assert>
			<iso:report id="Contact.Town.Check" test="true()" flag="Town">Town.NotEmpty
			</iso:report>
			<iso:assert id="Contact.Town.NotEmpty" test="iso:validStringOrNA(Town)" flag="Town">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Town')"/>
			</iso:assert>
			<iso:report id="Contact.StateRegion.Check" test="true()" flag="StateRegion">StateRegion.NotEmpty
			</iso:report>
			<iso:assert id="Contact.StateRegion.NotEmpty" test="iso:validStringOrNA(StateRegion)" flag="StateRegion">
				<value-of select="iso:notEmptyMessage(name(.),Email,'StateRegion')"/>
			</iso:assert>
			<iso:report id="Contact.PostalCode.Check" test="true()" flag="PostalCode">PostalCode.NotEmpty
			</iso:report>
			<iso:assert id="Contact.PostalCode.NotEmpty" test="iso:validStringOrNA(PostalCode)" flag="PostalCode">
				<value-of select="iso:notEmptyMessage(name(.),Email,'PostalCode')"/>
			</iso:assert>
			<iso:report id="Contact.Country.Check" test="true()" flag="Country">Country.NotEmpty
			</iso:report>
			<iso:assert id="Contact.Country.NotEmpty" test="iso:validStringOrNA(Country)" flag="Country">
				<value-of select="iso:notEmptyMessage(name(.),Email,'Country')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities" id="COBie.Facilities" role="WorksheetErrors">
			<iso:report id="Facilities.AtLeastOne.Check" test="true()" flag="FacilitySheet">Facilities.OneAndOnlyOneFacilityFound
			</iso:report>
			<iso:assert id="Facilites.OneAndOnlyOneFacilityFound" test="count(Facility)=1" flag="FacilitySheet">
				<value-of select="iso:onlyOneMessage('Facility','Facilities')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities/Facility" id="COBie.Facilities.Facility" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="Facility.ProjectName.Check" test="true()" flag="ProjectName">ProjectName.NotNull
			</iso:report>
			<iso:assert id="Facility.ProjectName.NotNull" test="iso:validString(ProjectName)" flag="ProjectName">
				<value-of select="iso:notNullMessage(name(.),@Name,'ProjectName')"/>
			</iso:assert>
			<iso:report id="Facility.SiteName.Check" test="true()" flag="SiteName">SiteName.NotNull
			</iso:report>
			<iso:assert id="Facility.SiteName.NotNull" test="iso:validString(SiteName)" flag="SiteName">
				<value-of select="iso:notNullMessage(name(.),@Name,'SiteName')"/>
			</iso:assert>
			<iso:report id="Facility.LinearUnits.Check" test="true()" flag="LinearUnits">LinearUnits.NotNull
			</iso:report>
			<iso:assert id="Facility.LinearUnits.NotNull" test="iso:validString(LinearUnits)" flag="LinearUnits">
				<value-of select="iso:notNullMessage(name(.),@Name,'LinearUnits')"/>
			</iso:assert>
			<!-- TODO Insert LinearUnits Picklist assert -->
			<iso:report id="Facility.AreaUnits.Check" test="true()" flag="AreaUnits">AreaUnits.NotNull
			</iso:report>
			<iso:assert id="Facility.AreaUnits.NotNull" test="iso:validString(AreaUnits)" flag="AreaUnits">
				<value-of select="iso:notNullMessage(name(.),@Name,'AreaUnits')"/>
			</iso:assert>
			<!--TODO Insert AreaUnits Picklist assert -->
			<iso:report id="Facility.VolumeUnits.Check" test="true()" flag="VolumeUnits">VolumeUnits.NotNull
			</iso:report>
			<iso:assert id="Facility.VolumeUnits.NotNull" test="iso:validString(VolumeUnits)" flag="VolumeUnits">
				<value-of select="iso:notNullMessage(name(.),@Name,'VolumeUnits')"/>
			</iso:assert>
			<!-- TODO Insert VolumeUnits Picklist assert -->
			<iso:report id="Facility.CurrencyUnit.Check" test="true()" flag="CurrencyUnit">Currency.NotNull
			</iso:report>
			<iso:assert id="Facility.Currency.NotNull" test="iso:validString(CurrencyUnit)" flag="CurrencyUnit">
				<value-of select="iso:notNullMessage(name(.),@Name,'CurrencyUnit')"/>
			</iso:assert>
			<!-- TODO Currency Unit Picklist -->
			<iso:report id="Facility.AreaMeasurement.Check" test="true()" flag="AreaMeasurement">AreaMeasurement.NotNull
			</iso:report>
			<iso:assert id="Facility.AreaMeasurement.NotNull" test="iso:validString(AreaMeasurement)" flag="AreaMeasurement">
				<value-of select="iso:notNullMessage(name(.),@Name,'AreaMeasurement')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty
			</iso:report>
			<iso:assert id="Facility.ExternalSystem.NotEmpty" test="iso:validStringOrNA(ExternalSystem)" flag="ExternalSystem">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalSystem')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalProjectObject.Check" test="true()" flag="ExternalProjectObject">ExternalProjectObject.NotEmpty
			</iso:report>
			<iso:assert id="Facility.ExternalProjectObject.NotEmpty" test="iso:validStringOrNA(ExternalProjectObject)" flag="ExternalProjectObject">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalProjectObject')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalProjectIdentifier.Check" test="true()" flag="ExternalProjectIdentifier">ExternalProjectIdentifier.NotEmpty
			</iso:report>
			<iso:assert id="Facility.ProjectIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalProjectIdentifier)" flag="ExternalProjectIdentifier">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalProjectIdentifier')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalSiteObject.Check" test="true()" flag="ExternalSiteObject">ExternalSiteObject.NotEmpty
			</iso:report>
			<iso:assert id="Facility.ExternalSiteObject.NotEmpty" test="iso:validStringOrNA(ExternalSiteObject)" flag="ExternalSiteObject">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalSiteObject')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalSiteIdentifier.Check" test="true()" flag="ExternalSiteIdentifier">ExternalSiteIdentifier.NotEmpty
			</iso:report>
			<iso:assert id="Facility.ExternalSiteIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalSiteIdentifier)" flag="ExternalSiteIdentifier">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalSiteIdentifier')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalFacilityObject.Check" test="true()" flag="ExternalFacilityObject">ExternalFacilityObject.NotEmpty
			</iso:report>
			<iso:assert id="FacilityExternalFacilityObjectNotEmpty" test="iso:validStringOrNA(ExternalFacilityObject)" flag="ExternalFacilityObject">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalFacilityObject')"/>
			</iso:assert>
			<iso:report id="Facility.ExternalFacilityIdentifier.Check" test="true()" flag="ExternalFacilityIdentifier">ExternalFacilityIdentifier.NotEmpty
			</iso:report>
			<iso:assert id="Facility.ExternalFacilityIdentifier.NotEmpty" test="iso:validStringOrNA(ExternalFacilityIdentifier)" flag="ExternalFacilityIdentifier">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ExternalFacilityIdentifier')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors" id="COBie.Floors" role="WorksheetErrors">
			<iso:report id="Floor.Count.Check" test="true()" flag="FloorSheet">Floors.AtLeastOneRowPresent
			</iso:report>
			<iso:assert id="Floors.AtLeastOneRowPresent" test="Floor">
				<iso:value-of select="iso:atLeastOneMessage('Floor','Floors')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors/Floor" id="COBie.Floors.Floor" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Floor.Elevation.Check" test="true()" flag="Elevation">Floor.Elevation.ValidNumberOrNA
			</iso:report>
			<iso:assert id="Floor.Elevation.ValidNumberOrNA" test="iso:validNumber(Elevation)" flag="Elevation">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'Elevation')"/>
			</iso:assert>
			<iso:report id="Floor.Height.Check" test="true()" flag="Height">Floor.Height.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Floor.Height.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(Height)" flag="Height">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'Height')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces" id="COBie.Spaces" role="WorksheetErrors">
			<iso:report id="Space.Count.Check" test="true()" flag="SpaceSheet">Spaces.AtLeastOneRowPresent
			</iso:report>
			<iso:assert id="Spaces.AtLeastOneRowPresent" test="Space">
				<name/> must have at least one entry</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces/Space" id="COBie.Spaces.Space" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Space.Name.Check" test="true()" flag="Name">Name.NotNull, PrimaryKey.Unique.Warning (Name), PrimaryKey.Unique.Error (Name, FloorName)
			</iso:report>
			<iso:assert id="Common.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
				</iso:assert>
			<iso:assert id="Space.PrimaryKey.Unique.Error" test="iso:isKeyLiteUnique(.)" flag="Name">
				<value-of select="iso:uniqueNameMessage(name(.),@Name,'Name, FloorName')"/>
			</iso:assert>
			<iso:assert id="Space.PrimaryKey.Unique.Warning"  test="iso:isKeyUnique(.) or not(iso:isKeyLiteUnique(.))" flag="Name">
					<value-of select="iso:uniqueNameWarningMessage(name(.),@Name,'Name','Name and Space.FloorName')"/>
			</iso:assert>
			<!--<iso:assert id="Space.PrimaryKey.Unique.Error" test="count(key('SpaceKeyLite',concat(@Name,',',FloorName)))=1" flag="Name">
				<value-of select="iso:uniqueNameMessage(name(.),@Name,'Name, FloorName')"/>
			</iso:assert>
			<iso:assert id="Space.PrimaryKey.Unique.Warning"  test="count(key('SpaceKey',@Name))=1 or not(count(key('SpaceKeyLite',concat(@Name,',',FloorName)))=1)" flag="Name">
					<value-of select="iso:uniqueNameWarningMessage(name(.),@Name,'Name','Name,FloorName')"/>
</iso:assert> -->
			<iso:report id="Space.FloorName.Check" test="true()" flag="FloorName">FloorName.NotNull, FloorName.CrossReference
			</iso:report>
			<iso:assert id="Space.FloorName.NotNull" test="iso:validString(FloorName)" flag="FloorName">
				<value-of select="iso:notNullMessage(name(.),@Name,'FloorName')"/>
			</iso:assert>
			<iso:assert id="Space.FloorName.CrossReference" test="key('FloorKey',FloorName)" flag="FloorName">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'FloorName','Floor','Name')"/>
			</iso:assert>
			<iso:report id="Space.Description.Check" test="true()" flag="Description">Description.NotNull
			</iso:report>
			<iso:assert id="Space.Description.NotNull" test="iso:validString(Description)" flag="Description">
				<value-of select="iso:notNullMessage(name(.),@Name,'Description')"/>
			</iso:assert>
			<iso:report id="Space.RoomTag.Check" test="true()" flag="RoomTag">RoomTag.NotEmpty
			</iso:report>
			<iso:assert id="Space.RoomTag.NotEmpty" test="iso:validStringOrNA(RoomTag)" flag="RoomTag">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'RoomTag')"/>
			</iso:assert>
			<iso:report id="Space.UsableHeight.Check" test="true()" flag="UsableHeight">UsableHeight.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Space.UsableHeight.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(UsableHeight)" flag="UsableHeight">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'UsableHeight')"/>
			</iso:assert>
			<iso:report id="Space.GrossArea.Check" test="true()" flag="GrossArea">GrossArea.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Space.GrossArea.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(GrossArea)" flag="GrossArea">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'GrossArea')"/>
			</iso:assert>
			<iso:report id="Space.NetArea.Check" test="true()" flag="NetArea">NetArea.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Space.NetArea.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(NetArea)" flag="NetArea">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'NetArea')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Zones/Zone" id="COBie.Zones.Zone" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Zone.Name.Check" test="true()" flag="Name">Name.NotNull, PrimaryKey.Unique (Name, Category, SpaceNames)
			</iso:report>
			<iso:assert id="Zone.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'Name')"/>
			</iso:assert>
			<iso:assert id="Zone.PrimaryKey.Unique" test="iso:isKeyUnique(.)" flag="Name">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'Name,Category,SpaceNames')"/>
			</iso:assert>
			<!-- TODO Category Picklists -->
			<iso:report id="Zone.SpaceNames.Check" test="true()" flag="SpaceNames">SpaceNames.NotNull, SpaceNames.CrossReference
			</iso:report>
			<iso:assert id="Zone.SpaceNames.NotNull" test="iso:validString(SpaceNames)" flag="SpaceNames">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'SpaceNames')"/>
			</iso:assert>
			<iso:assert id="Zone.SpaceNames.CrossReference" test="iso:delimListInKeys(SpaceNames,'Space',/)" flag="SpaceNames">
				<value-of select="iso:foreignKeysMessage(name(.),concat(@Name,',',Category,',',SpaceNames),'SpaceNames','Space','Name')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Types" id="COBie.Types" role="WorksheetErrors">
			<iso:report id="Type.Count.Check" test="true()" flag="TypeSheet">Types.AtLeastOneRowPresent
			</iso:report>
			<iso:assert id="Types.AtLeastOneRowPresent" test="Type">
				<name/>:  At least one Type must be provided</iso:assert>
		</iso:rule>
		<iso:rule context="//Types/Type" id="COBie.Types.Type" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Type.ComponentCount.Check" test="true()" flag="TypeComponentSheets">Type.Component.AComponentForEachType
			</iso:report>
			<iso:assert id="Type.Component.AComponentForEachType" test="some $comp in ../../Components/Component satisfies ($comp/TypeName=@Name)" flag="Name">
				<name/>.<value-of select="@Name"/>: All Types must have at least one associated Component
			</iso:assert>
			<iso:report id="Type.AssetType.Check" test="true()" flag="AssetType">AssetType.NotNull
			</iso:report>
			<iso:assert id="Type.AssetType.NotNull" test="iso:validString(AssetType)" flag="AssetType">
				<value-of select="iso:notNullMessage(name(.),@Name,'AssetType')"/>
			</iso:assert>
			<iso:report id="Type.Manufacturer.Check" test="true()" flag="Manufacturer">Manufacturer.NotNull, Manufacturer.CrossReference (Contact Sheet)
			</iso:report>
			<iso:assert id="Type.Manufacturer.NotNull" test="iso:validString(Manufacturer)" flag="Manufacturer">
				<value-of select="iso:notNullMessage(name(.),@Name,'Manufacturer')"/>
			</iso:assert>
			<iso:assert id="Type.Manufacturer.CrossReference" test="key('ContactKey',Manufacturer)" flag="Manufacturer">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'Manufacturer','Contact','Email')"/>
			</iso:assert>
			<iso:report id="Type.ModelNumber.Check" test="true()" flag="ModelNumber">ModelNumber.NotNull
			</iso:report>
			<iso:assert id="Type.ModelNumber.NotNull" test="iso:validString(ModelNumber)" flag="ModelNumber">
				<value-of select="iso:notNullMessage(name(.),@Name,'ModelNumber')"/>
			</iso:assert>
			<iso:report id="Type.WarrantyGuarantorParts.Check" test="true()" flag="WarrantyGuarantorParts">WarrantyGuarantorParts.NotNull, WarrantyGuarantorParts.CrossReference (Contact Sheet)
			</iso:report>
			<iso:assert id="Type.WarrantyGuarantorParts.NotNull" test="iso:validString(WarrantyGuarantorParts)" flag="WarrantyGuarantorParts">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyGuarantorParts')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorParts.CrossReference" test="key('ContactKey',WarrantyGuarantorParts)" flag="WarrantyGuarantorParts">
				<value-of select="iso:foreignKeyMessage(name(.),WarrantyGuarantorParts,'WarrantyGuarantorParts','Contact','Email')"/>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationParts.Check" test="true()" flag="WarrantyDurationParts">WarrantyDurationParts.validNumberZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Type.WarrantyDurationParts.validNumberZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(WarrantyDurationParts)" flag="WarrantyDurationParts">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'WarrantyDurationParts')"/>
			</iso:assert>
			<iso:report id="Type.WarrantyGuarantorLabor.Check" test="true()" flag="WarrantyGuarantorLabor">WarrantyGuarantorLabor.NotNull, WarrantyGuarantorLabor.CrossReference (Contact Sheet)
			</iso:report>
			<iso:assert id="Type.WarrantyGuarantorLabor.NotNull" test="iso:validString(WarrantyGuarantorLabor)" flag="WarrantyGuarantorLabor">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyGuarantorLabor')"/>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorLabor.CrossReference" test="key('ContactKey',WarrantyGuarantorLabor)" flag="WarrantyGuarantorLabor">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'WarrantyGuarantorLabor,','Contact','Email')"/>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationLabor.Check" test="true()" flag="WarrantyDurationLabor">WarrantyDurationLabor.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Type.WarrantyDurationLabor.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(WarrantyDurationLabor)" flag="WarrantyDurationLabor">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'WarrantyDurationLabor')"/>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationUnit.Check" test="true()" flag="WarrantyDurationUnit">WarrantyDurationUnit.NotNull
			</iso:report>
			<iso:assert id="Type.WarrantyDurationUnit.NotNull" test="iso:validString(WarrantyDurationUnit)" flag="WarrantyDurationUnit">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyDurationUnit')"/>
			</iso:assert>
			<iso:report id="Type.ReplacementCost.Check" test="true()" flag="ReplacementCost">ReplacementCost.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Type.ReplacementCost.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(ReplacementCost)" flag="ReplacementCost">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'ReplacementCost')"/>
			</iso:assert>
			<iso:report id="Type.ExpectedLife.Check" test="true()" flag="ExpectedLife">ExpectedLife.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Type.ExpectedLife.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(ExpectedLife)" flag="ExpectedLife">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'ExpectedLife')"/>
			</iso:assert>
			<iso:report id="Type.DurationUnit.Check" test="true()" flag="DurationUnit">DurationUnit.NotNull
			</iso:report>
			<iso:assert id="Type.DurationUnit.NotNull" test="iso:validString(DurationUnit)" flag="DurationUnit">
				<value-of select="iso:notNullMessage(name(.),@Name,'DurationUnit')"/>
			</iso:assert>
			<iso:report id="Type.WarrantyDescription.Check" test="true()" flag="WarrantyDescription">WarrantyDescription.NotEmpty
			</iso:report>
			<iso:assert id="Type.WarrantyDescription.NotEmpty" test="iso:validStringOrNA(WarrantyDescription)" flag="WarrantyDescription">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'WarrantyDescription')"/>
			</iso:assert>
			<iso:report id="Type.NominalLength.Check" test="true()" flag="NominalLength">NominalLength.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Type.NominalLength.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(NominalLength)" flag="NominalLength">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'NominalLength')"/>
			</iso:assert>
			<iso:report id="Type.NominalWidth.Check" test="true()" flag="NominalWidth">NominalWidth.ZeroOrGreaterOrNA
			</iso:report>
			<iso:assert id="Type.NominalWidth.ZeroOrGreaterOrNA" test="iso:validNumberZeroOrGreater(NominalWidth)" flag="NominalWidth">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'NominalWidth')"/>
			</iso:assert>
			<iso:report id="Type.NominalHeight.Check" test="true()" flag="NominalHeight">NominalHeight.ZeroOrGreater
			</iso:report>
			<iso:assert id="Type.NominalHeight.ZeroOrGreater" test="iso:validNumberZeroOrGreater(NominalHeight)" flag="NominalHeight">
				<value-of select="iso:notEmptyNumberMessage(name(.),@Name,'NominalHeight')"/>
			</iso:assert>
			<iso:report id="Type.ModelReference.Check" test="true()" flag="ModelReference">ModelReference.NotEmpty
			</iso:report>
			<iso:assert id="Type.ModelReference.NotEmpty" test="iso:validStringOrNA(ModelReference)" flag="ModelReference">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ModelReference')"/>
			</iso:assert>
			<iso:report id="Type.Shape.Check" test="true()" flag="Shape">Shape.NotEmpty
			</iso:report>
			<iso:assert id="Type.Shape.NotEmpty" test="iso:validStringOrNA(Shape)" flag="Shape">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Shape')"/>
			</iso:assert>
			<iso:report id="Type.Size.Check" test="true()" flag="Size">Size.NotEmpty
			</iso:report>
			<iso:assert id="Type.Size.NotEmpty" test="iso:validStringOrNA(Size)" flag="Size">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Size')"/>
			</iso:assert>
			<iso:report id="Type.Color.Check" test="true()" flag="Color">Color.NotEmpty
			</iso:report>
			<iso:assert id="Type.Color.NotEmpty" test="iso:validStringOrNA(Color)" flag="Color">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Color')"/>
			</iso:assert>
			<iso:report id="Type.Finish.Check" test="true()" flag="Finish">Finish.NotEmpty
			</iso:report>
			<iso:assert id="Type.Finish.NotEmpty" test="iso:validStringOrNA(Finish)" flag="Finish">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Finish')"/>
			</iso:assert>
			<iso:report id="Type.Grade.Check" test="true()" flag="Grade">Grade.NotEmpty
			</iso:report>
			<iso:assert id="Type.Grade.NotEmpty" test="iso:validStringOrNA(Grade)" flag="Grade">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Grade')"/>
			</iso:assert>
			<iso:report id="Type.Material.Check" test="true()" flag="Material">Material.NotEmpty
			</iso:report>
			<iso:assert id="Type.Material.NotEmpty" test="iso:validStringOrNA(Material)" flag="Material">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Material')"/>
			</iso:assert>
			<iso:report id="Type.Constituents.Check" test="true()" flag="Constituents">Constituents.NotEmpty
			</iso:report>
			<iso:assert id="Type.Constituents.NotEmpty" test="iso:validStringOrNA(Constituents)" flag="Constituents">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Constituents')"/>
			</iso:assert>
			<iso:report id="Type.Features.Check" test="true()" flag="Features">Features.NotEmpty
			</iso:report>
			<iso:assert id="Type.Features.NotEmpty" test="iso:validStringOrNA(Features)" flag="Features">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Features')"/>
			</iso:assert>
			<iso:report id="Type.AccessibilityPerformance.Check" test="true()" flag="AccessibilityPerformance">AccessibilityPerformance.NotEmpty
			</iso:report>
			<iso:assert id="Type.AccessibilityPerformance.NotEmpty" test="iso:validStringOrNA(AccessibilityPerformance)" flag="AccessibilityPerformance">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'AccessibilityPerformance')"/>
			</iso:assert>
			<iso:report id="Type.CodePerformance.Check" test="true()" flag="CodePerformance">CodePerformance.NotEmpty
			</iso:report>
			<iso:assert id="Type.CodePerformance.NotEmpty" test="iso:validStringOrNA(CodePerformance)" flag="CodePerformance">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'CodePerformance')"/>
			</iso:assert>
			<iso:report id="Type.SustainabilityPerformance.Check" test="true()" flag="SustainabilityPerformance">SustainabilityPerformance.NotEmpty
			</iso:report>
			<iso:assert id="Type.SustainabilityPerformance.NotEmpty" test="iso:validStringOrNA(SustainabilityPerformance)" flag="SustainabilityPerformance">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'SustainabilityPerformance')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Components" id="COBie.Components" role="WorksheetErrors">
			<iso:report id="Component.Count.Check" test="true()" flag="ComponentSheet">Components.AtLeastOneRowPresent
			</iso:report>
			<iso:assert id="Components.AtLeastOneRowPresent" test="Component">
				<name/>:  at least one Component must be provided.</iso:assert>
		</iso:rule>
		<iso:rule context="//Components/Component" id="COBie.Components.Component" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Component.Name.Check" test="true()" flag="Name">Name.NotNull, PrimaryKey.Unique.Warning (Name), PrimaryKey.Unique.Error (Name, Space)
			</iso:report>
			<iso:assert id="Common.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
				</iso:assert>
			<iso:assert id="Component.PrimaryKey.Unique.Error" test="iso:isKeyLiteUnique(.)" flag="Name">
				<value-of select="iso:uniqueNameMessage(name(.),@Name,'Name,Space')"/>
			</iso:assert>
			<iso:assert id="Component.PrimaryKey.Unique.Warning"  test="iso:isKeyUnique(.) or not(iso:isKeyLiteUnique(.))" flag="Name">
					<value-of select="iso:uniqueNameWarningMessage(name(.),@Name,'Name','Name,Space')"/>
			</iso:assert>
			<!--<iso:assert id="Component.PrimaryKey.Unique.Error" test="count(key('ComponentKeyLite',concat(@Name,',',Space)))=1" flag="Name">
				<value-of select="iso:uniqueNameMessage(name(.),@Name,'Name,Space')"/>
			</iso:assert>
			<iso:assert id="Component.PrimaryKey.Unique.Warning"  test="count(key('ComponentKey',@Name))=1 or not(count(key('ComponentKeyLite',concat(@Name,',',Space)))=1)" flag="Name">
					<value-of select="iso:uniqueNameWarningMessage(name(.),@Name,'Name','Name,Space')"/>
			</iso:assert> -->
			<iso:report id="Component.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference (Type Worksheet)
			</iso:report>
			<iso:assert id="Component.TypeName.NotNull" test="iso:validString(TypeName)" flag="TypeName">
				<value-of select="iso:notNullMessage(name(.),@Name,'TypeName')"/>
			</iso:assert>
			<iso:assert id="Component.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'TypeName','Type','Name')"/>
			</iso:assert>
			<iso:report id="Component.Space.Check" test="true()" flag="Space">Space.NotNull, Space.CrossReference (Component Worksheet)
			</iso:report>
			<iso:assert id="Component.Space.NotNull" test="iso:validString(Space)" flag="Space">
				<value-of select="iso:notNullMessage(name(.),@Name,'Space')"/>
			</iso:assert>
			<iso:assert id="Component.Space.CrossReference" test="iso:componentSpaceKeyMatch(Space,ExtObject,/)" flag="Space">
				<value-of select="iso:componentSpaceForeignKeyMessage(name(.),@Name,'Space','Space','Name')"/>
			</iso:assert>
			<iso:report id="Component.Description.Check" test="true()" flag="Description">Description.NotNull
			</iso:report>
			<iso:assert id="Component.Description.NotNull" test="iso:validString(Description)" flag="Description">
				<value-of select="iso:notNullMessage(name(.),@Name,'Description')"/>
			</iso:assert>
			<iso:report id="Component.SerialNumber.Check" test="true()" flag="SerialNumber">SerialNumber.NotNull
			</iso:report>
			<iso:assert id="Component.SerialNumber.NotEmpty" test="iso:validStringOrNA(SerialNumber)" flag="SerialNumber">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'SerialNumber')"/>
			</iso:assert>
			<iso:report id="Component.InstallationDate.Check" test="true()" flag="InstallationDate">InstallationDate.NotNull
			</iso:report>
			<iso:assert id="Component.InstallationDate.NotNull" test="iso:validString(InstallationDate)" flag="InstallationDate">
				<value-of select="iso:notNullMessage(name(.),@Name,'InstallationDate')"/>
			</iso:assert>
			<iso:report id="Component.WarrantyStartDate.Check" test="true()" flag="WarrantyStartDate">WarrantyStartDate.NotNull
			</iso:report>
			<iso:assert id="Component.WarrantyStartDate.NotNull" test="iso:validString(WarrantyStartDate)" flag="WarrantyStartDate">
				<value-of select="iso:notNullMessage(name(.),@Name,'WarrantyStartDate')"/>
			</iso:assert>
			<iso:report id="Component.TagNumber.Check" test="true()" flag="TagNumber">TagNumber.NotEmpty
			</iso:report>
			<iso:assert id="Component.TagNumber.NotEmpty" test="iso:validStringOrNA(TagNumber)" flag="TagNumber">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'TagNumber')"/>
			</iso:assert>
			<iso:report id="Component.BarCode.Check" test="true()" flag="BarCode">BarCode.NotEmpty
			</iso:report>
			<iso:assert id="Component.BarCode.NotEmpty" test="iso:validStringOrNA(BarCode)" flag="BarCode">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'BarCode')"/>
			</iso:assert>
			<iso:report id="Component.AssetIdentifier.Check" test="true()" flag="AssetIdentifier">AssetIdentifier.NotEmpty
			</iso:report>
			<iso:assert id="Component.AssetIdentifier.NotEmpty" test="iso:validStringOrNA(AssetIdentifier)" flag="AssetIdentifier">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'AssetIdentifier')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Systems/System" id="COBie.Systems.System" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="System.Name.Check" test="true()" flag="Name">PrimaryKey.Unique (Name, Category, ComponentNames), Name.NotNull
			</iso:report>
			<iso:assert id="System.PrimaryKey.Unique" test="iso:isKeyUnique(.)" flag="Name">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',Category,',',ComponentNames),'Name,Category,ComponentNames')"/>
			</iso:assert>
			<iso:assert id="System.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',ComponentNames),'Name')"/>
			</iso:assert>
			<iso:report id="System.ComponentNames.Check" test="true()" flag="ComponentNames">ComponentNames.NotNull, ComponentNames.CrossReference
			</iso:report>
			<iso:assert id="System.ComponentNames.NotNull" test="iso:validString(ComponentNames)" flag="ComponentNames">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',Category,',',ComponentNames),'ComponentNames')"/>
			</iso:assert>
			<iso:assert id="System.ComponentNames.CrossReference" test="iso:delimListInKeys(ComponentNames,'Component',/)" flag="ComponentNames">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',Category,',',ComponentNames),ComponentNames,'Component','Name')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Assemblies/Assembly" id="COBie.Assemblies.Assembly" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="Assembly.PrimaryKey.Check" test="true()" flag="PrimaryKey">Assembly.PrimaryKey.Unique (Name, SheetName, ParentName, ChildNames)
			</iso:report>
			<iso:assert id="Assembly.PrimaryKey.Unique" test="iso:isKeyUnique(.)" flag="AssemblyKey">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'Name, SheetName, ParentName,ChildNames')"/>
			</iso:assert>
			<iso:report id="Assembly.Name.Check" test="true()" flag="Name">Name.NotNull
			</iso:report>
			<iso:assert id="Assembly.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'Name')"/>
			</iso:assert>
			<iso:report id="Assembly.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetName.CrossReference
			</iso:report>
			<iso:assert id="Assembly.SheetName.NotNull" test="iso:validString(SheetName)" flag="SheetName">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'SheetName')"/>
			</iso:assert>
			<iso:assert id="Assembly.SheetName.CrossReference" test="lower-case(SheetName)='component' or lower-case(SheetName)='type'" flag="SheetName">
				<value-of select="iso:assertMsgPrefix(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'SheetName')"/>: SheetName may only be Component or type
			</iso:assert>
			<iso:report id="Assembly.ParentName.Check" test="true()" flag="ParentName">ParentName.NotNull, ParentName.CrossReference
			</iso:report>
			<iso:assert id="Assembly.ParentName.NotNull" test="iso:validString(ParentName)" flag="ParentName">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'ParentName')"/>
			</iso:assert>
			<iso:assert id="Assembly.ParentName.Reference" test="iso:keyMatch(SheetName,ParentName,/)" flag="ParentName">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'ParentName',SheetName,'Name')"/>
			</iso:assert>
			<iso:report id="Assembly.ChildNames.Check" test="true()" flag="ChildNames">ChildNames.NotNull, ChildNames.CrossReference
			</iso:report>
			<iso:assert id="Assembly.ChildNames.NotNull" test="iso:validString(ChildNames)" flag="ChildNames">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'ChildNames')"/>
			</iso:assert>
			<iso:assert id="Assembly.ChildNames.CrossReference" test="iso:delimListInKeys(ChildNames,SheetName,/)" flag="ChildNames">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'ChildNames',SheetName,'Name')"/>
			</iso:assert>
			<iso:report id="Assembly.AssemblyType.Check" test="true()" flag="AssemblyType">AssemblyType.NotNull
			</iso:report>
			<iso:assert id="Assembly.AssemblyType.NotNull" test="iso:validString(AssemblyType)" flag="AssemblyType">
				<value-of select="iso:notNullMessage(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'AssemblyType')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Connections/Connection" id="COBie.Connections.Connection" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="Connection.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, ConnectionType, SheetName, RowName1, RowName2)
			</iso:report>
			<iso:assert id="Connection.PrimaryKey.Unique" test="iso:isKeyUnique(.)" flag="ConnectionKey">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'Name, ConnectionType,SheetName,RowName1,RowName2')"/>
			</iso:assert>
			<iso:report id="Connection.Name.Check" test="true()" flag="Name">Name.NotNull
			</iso:report>
			<iso:assert id="Connection.Name.NotNull" test="iso:validString(Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
			</iso:assert>
			<iso:report id="Connection.ConnectionType.Check" test="true()" flag="ConnectionType">ConnectionType.NotNull
			</iso:report>
			<iso:assert id="Connection.ConnectionType.NotNull" test="iso:validString(ConnectionType)" flag="ConnectionType">
				<value-of select="iso:notNullMessage(name(.),@Name,'ConnectionType')"/>
			</iso:assert>
			<iso:report id="Connection.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetName.CrossReference
			</iso:report>
			<iso:assert id="Connection.SheetName.NotNull" test="iso:validString(SheetName)" flag="SheetName">
				<value-of select="iso:notNullMessage(name(.),@Name,'SheetName')"/>
			</iso:assert>
			<iso:assert id="Connection.SheetName.CrossReference" test="lower-case(SheetName)='type' or lower-case(SheetName)='component'" flag="SheetName">
				<value-of select="iso:assertMsgPrefix(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'SheetName')"/>: SheetName must be Type or Component, <value-of select="SheetName"/> is not valid.</iso:assert>
			<iso:report id="Connection.RowName1.Check" test="true()" flag="RowName1">RowName1.NotNull, RowName1.CrossReference
			</iso:report>
			<iso:assert id="Connection.RowName1.NotNull" test="iso:validString(RowName1)" flag="RowName1">
				<value-of select="iso:notNullMessage(name(.),@Name,'RowName1')"/>
			</iso:assert>
			<iso:assert id="Connection.RowName1.CrossReference" test="iso:keyMatch(SheetName,RowName1,/)" flag="RowName1">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'RowName1',SheetName,'Name')"/>
			</iso:assert>
			<iso:report id="Connection.RowName2.Check" test="true()" flag="RowName2">RowName2.NotNull, RowName2.CrossReference
			</iso:report>
			<iso:assert id="Connection.RowName2.NotNull" test="iso:validString(RowName2)" flag="RowName2">
				<value-of select="iso:notNullMessage(name(.),@Name,'RowName2')"/>
			</iso:assert>
			<iso:assert id="Connection.RowName2.CrossReference" test="iso:keyMatch(SheetName,RowName2,/)" flag="RowName2">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'RowName2',SheetName,'Name')"/>
			</iso:assert>
			<iso:report id="Connection.RealizingElement.Check" test="true()" flag="RealizingElement">RealizingElement.NotNull
			</iso:report>
			<iso:assert id="Connection.RealizingElement.NotNull" test="iso:validString(RealizingElement)" flag="RealizingElement">
				<value-of select="iso:notNullMessage(name(.),@Name,'RealizingElement')"/>
			</iso:assert>
			<iso:report id="Connection.PortName1.Check" test="true()" flag="PortName1">PortName1.NotNull
			</iso:report>
			<iso:assert id="Connection.PortName1.NotNull" test="iso:validString(PortName1)" flag="PortName1">
				<value-of select="iso:notNullMessage(name(.),@Name,'PortName1')"/>
			</iso:assert>
			<iso:report id="Connection.PortName2.Check" test="true()" flag="PortName2">PortName2.NotNull
			</iso:report>
			<iso:assert id="Connection.PortName2.NotNull" test="iso:validString(PortName2)" flag="PortName2">
				<value-of select="iso:notNullMessage(name(.),@Name,'PortName2')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spares/Spare" id="COBie.Spares.Spare" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Spare.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference
			</iso:report>
			<iso:assert id="Spare.TypeName.NotNull" test="iso:validString(TypeName)" flag="TypeName">
				<value-of select="iso:notNullMessage(name(.),@Name,'TypeName')"/>
			</iso:assert>
			<iso:assert id="Spare.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'TypeName','Type','Name')"/>
			</iso:assert>
			<iso:report id="Spare.Suppliers.Check" test="true()" flag="Suppliers">Suppliers.NotNull, Suppliers.CrossReference (Contact Sheet)
			</iso:report>
			<iso:assert id="Spare.Suppliers.NotNull" test="iso:validString(Suppliers)" flag="Suppliers">
				<value-of select="iso:notNullMessage(name(.),@Name,'Suppliers')"/>
			</iso:assert>
			<iso:assert id="Spare.Suppliers.CrossReference" test="iso:delimListInKeys(Suppliers,'Contact',/)" flag="Suppliers">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'Suppliers','Contact','Email')"/>
			</iso:assert>
			<iso:report id="Spare.SetNumber.Check" test="true()" flag="SetNumber">SetNumber.NotEmpty
			</iso:report>
			<iso:assert id="Spare.SetNumber.NotEmpty" test="iso:validStringOrNA(SetNumber)" flag="SetNumber">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'SetNumber')"/>
			</iso:assert>
			<iso:report id="Spare.PartNumber.Check" test="true()" flag="PartNumber">PartNumber.NotEmpty
			</iso:report>
			<iso:assert id="Spare.PartNumber.NotEmpty" test="iso:validStringOrNA(PartNumber)" flag="PartNumber">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'PartNumber')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Resources/Resource" id="COBie.Resources.Resource" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
		</iso:rule>
		<iso:rule context="//Jobs/Job" id="COBie.Jobs.Job" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Job.Name.Check" test="true()" flag="Name">Name.NotNull
			</iso:report>
			<iso:assert id="Job.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
			</iso:assert>
			<iso:report id="Job.PrimaryKey.Check" test="true()" flag="Name">PrimaryKey.Unique (Name,TypeName,TaskNumber)
			</iso:report>
			<iso:assert id="Job.PrimaryKey.Unique" test="iso:isKeyUnique(.)">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',TypeName,',',TaskNumber),'Name,TypeName,TaskNumber')"/>
			</iso:assert>
			<iso:report id="Job.Status.Check" test="true()" flag="Status">Status.NotNull
			</iso:report>
			<iso:assert id="Job.Status.NotNull" test="iso:validString(Status)" flag="Status">
				<value-of select="iso:notNullMessage(name(.),@Name,'Status')"/>
			</iso:assert>
			<iso:report id="Job.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference
			</iso:report>
			<iso:assert id="Job.TypeName.NotNull" test="iso:validString(TypeName)" flag="TypeName">
				<value-of select="iso:notNullMessage(name(.),@Name,'TypeName')"/>
			</iso:assert>
			<iso:assert id="Job.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="iso:foreignKeyMessage(name(.),@Name,'TypeName','Type','Name')"/>
			</iso:assert>
			<iso:report id="Job.Duration.Check" test="true()" flag="Duration">Duration.NotEmpty
			</iso:report>
			<iso:assert id="Job.Duration.NotEmpty" test="iso:validStringOrNA(Duration)" flag="Duration">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Duration')"/>
			</iso:assert>
			<iso:report id="Job.DurationUnit.Check" test="true()" flag="DurationUnit">DurationUnit.NotEmpty
			</iso:report>
			<iso:assert id="Job.DurationUnit.NotEmpty" test="iso:validStringOrNA(DurationUnit)" flag="DurationUnit">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'DurationUnit')"/>
			</iso:assert>
			<iso:report id="Job.Start.Check" test="true()" flag="Start">Start.NotEmpty
			</iso:report>
			<iso:assert id="Job.Start.NotEmpty" test="iso:validStringOrNA(Start)" flag="Start">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Start')"/>
			</iso:assert>
			<iso:report id="Job.TaskStartUnit.Check" test="true()" flag="TaskStartUnit">TaskStartUnit.NotEmpty
			</iso:report>
			<iso:assert id="Job.TaskStartUnit.NotEmpty" test="iso:validStringOrNA(TaskStartUnit)" flag="TaskStartUnit">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'TaskStartUnit')"/>
			</iso:assert>
			<iso:report id="Job.Frequency.Check" test="true()" flag="Frequency">Frequency.NotEmpty
			</iso:report>
			<iso:assert id="Job.Frequency.NotEmpty" test="iso:validStringOrNA(Frequency)" flag="Frequency">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Frequency')"/>
			</iso:assert>
			<iso:report id="Job.FrequencyUnit.Check" test="true()" flag="FrequencyUnit">FrequencyUnit.NotEmpty
			</iso:report>
			<iso:assert id="Job.FrequencyUnit.NotEmpty" test="iso:validStringOrNA(FrequencyUnit)" flag="FrequencyUnit">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'FrequencyUnit')"/>
			</iso:assert>
			<iso:report id="Job.TaskNumber.Check" test="true()" flag="TaskNumber">TaskNumber.NotEmpty
			</iso:report>
			<iso:assert id="Job.TaskNumber.NotEmpty" test="iso:validStringOrNA(TaskNumber)" flag="TaskNumber">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'TaskNumber')"/>
			</iso:assert>
			<iso:report id="Job.Priors.Check" test="true()" flag="Priors">Priors.NotEmpty
			</iso:report>
			<iso:assert id="Job.Priors.NotEmpty" test="iso:validStringOrNA(Priors)" flag="Priors">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Priors')"/>
			</iso:assert>
			<iso:report id="Job.ResourceNames.Check" test="true()" flag="ResourceNames">ResourceNames.NotEmpty
			</iso:report>
			<iso:assert id="Job.ResourceNames.NotEmpty" test="iso:validStringOrNA(ResourceNames)" flag="ResourceNames">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ResourceNames')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Documents/Document" id="COBie.Documents.Document" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Document.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Stage, SheetName, RowName)
			</iso:report>
			<iso:assert id="Document.PrimaryKey.Unique" test="iso:isKeyUnique(.)" flag="DocumentKey">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',Stage,',',SheetName,',',RowName),'Name,Stage,SheetName,RowName')"/>
			</iso:assert>
			<iso:report id="Document.Name.Check" test="true()" flag="Name">Name.NotNull
			</iso:report>
			<iso:assert id="Document.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
			</iso:assert>
			<iso:report id="Document.ApprovalBy.Check" test="true()" flag="ApprovalBy">ApprovalBy.NotEmpty
			</iso:report>
			<iso:assert id="Document.ApprovalBy.NotEmpty" test="iso:validStringOrNA(ApprovalBy)" flag="ApprovalBy">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'ApprovalBy')"/>
			</iso:assert>
			<iso:report id="Document.Stage.Check" test="true()" flag="Stage">Stage.NotNull
			</iso:report>
			<iso:assert id="Document.Stage.NotNull" test="iso:validString(Stage)" flag="Stage">
				<value-of select="iso:notNullMessage(name(.),@Name,'Stage')"/>
			</iso:assert>
			<iso:report id="Document.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetNameRowName.CrossReference
			</iso:report>
			<iso:assert id="Document.SheetName.NotNull" test="iso:validString(SheetName)" flag="SheetName">
				<value-of select="iso:notNullMessage(name(.),@Name,'SheetName')"/>
			</iso:assert>
			<iso:assert id="Document.SheetNameRowName.Reference" test="iso:keyMatch(SheetName,RowName,/)" flag="RowName">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',Stage,',',SheetName,',',RowName),'RowName',SheetName,'Name')"/>
			</iso:assert>
			<iso:report id="Document.RowName.Check" test="true()" flag="RowName">RowName.NotNull
			</iso:report>
			<iso:assert id="Document.RowName.NotNull" test="iso:validString(RowName)" flag="RowName">
				<value-of select="iso:notNullMessage(name(.),@Name,'RowName')"/>
			</iso:assert>
			<iso:report id="Document.Directory.Check" test="true()" flag="Directory">Directory.NotNull
			</iso:report>
			<iso:assert id="Document.Directory.NotNull" test="iso:validString(Directory)" flag="Directory">
				<value-of select="iso:notNullMessage(name(.),@Name,'Directory')"/>
			</iso:assert>
			<iso:report id="Document.File.Check" test="true()" flag="File">File.NotNull
			</iso:report>
			<iso:assert id="Document.File.NotNull" test="iso:validString(File)" flag="File">
				<value-of select="iso:notNullMessage(name(.),@Name,'File')"/>
			</iso:assert>
			<iso:report id="Document.Reference.Check" test="true()" flag="Reference">Reference.NotEmpty
			</iso:report>
			<iso:assert id="Document.Reference.NotEmpty" test="iso:validStringOrNA(Reference)" flag="Reference">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Reference')"/>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Attributes/Attribute" id="COBie.Attributes.Attribute" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Attribute.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, SheetName, RowName)
			</iso:report>
			<iso:assert id="Attribute.PrimaryKey.Unique" test="iso:isKeyUnique(.)" flag="AttributeKey">
				<value-of select="iso:uniqueNameMessage(name(.),concat(@Name,',',SheetName,',',RowName),'Name,SheetName,RowName')"/>
			</iso:assert>
			<iso:report id="Attribute.Name.Check" test="true()" flag="Name">Name.NotNull
			</iso:report>
			<iso:assert id="Attribute.Name.NotNull" test="iso:validString(@Name)" flag="Name">
				<value-of select="iso:notNullMessage(name(.),@Name,'Name')"/>
			</iso:assert>
			<iso:report id="Attribute.SheetNameRowName.Check" test="true()" flag="SheetNameRowName">SheetNameRowName.CrossReference
			</iso:report>
			<iso:assert id="Attribute.SheetNameRowName.CrossReference" test="iso:keyMatch(SheetName,RowName,/)" flag="RowName">
				<value-of select="iso:foreignKeyMessage(name(.),concat(@Name,',',SheetName,',',RowName),'RowName',SheetName,'Name')"/>
			</iso:assert>
			<iso:report id="Attribute.Value.Check" test="true()" flag="Value">Value.NotEmpty
			</iso:report>
			<iso:assert id="Attribute.Value.NotEmpty" test="iso:validStringOrNA(Value)" flag="Value">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Value')"/>
			</iso:assert>
			<iso:report id="Attribute.Unit.Check" test="true()" flag="Unit">Unit.NotEmpty
			</iso:report>
			<iso:assert id="Attribute.Unit.NotEmpty" test="iso:validStringOrNA(Unit)" flag="Unit">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'Unit')"/>
			</iso:assert>
			<iso:report id="Attribute.AllowedValues.Check" test="true()" flag="AllowedValues">AllowedValues.NotEmpty
			</iso:report>
			<iso:assert id="Attribute.AllowedValues.NotEmpty" test="iso:validStringOrNA(AllowedValues)" flag="AllowedValues">
				<value-of select="iso:notEmptyMessage(name(.),@Name,'AllowedValues')"/>
			</iso:assert>
		</iso:rule>
	</iso:pattern>
</iso:schema>
