<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="comp" uri="compare.projent.shared.bimserver.org"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="COBieCompare.xsd" workingxmlfile="sampleCompareSatellite.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
		<xpath-functions/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="1" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles/>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="comp:COBieCompare">
								<children>
									<template subtype="element" match="comp:CompareMetadata">
										<children>
											<paragraph paragraphtag="h1">
												<children>
													<text fixtext="COBie Comparison Report"/>
												</children>
											</paragraph>
											<newline/>
											<template subtype="uservariable" match="$baselineHeader">
												<children>
													<paragraph paragraphtag="h2">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
											<template subtype="uservariable" match="$revisionHeader">
												<children>
													<paragraph paragraphtag="h2">
														<children>
															<content/>
														</children>
													</paragraph>
													<newline/>
												</children>
												<variables/>
											</template>
											<paragraph paragraphtag="p">
												<children>
													<template subtype="element" match="comp:CompareDateTime">
														<children>
															<text fixtext="Comparison performed on: "/>
															<content>
																<format basic-type="xsd" datatype="dateTime"/>
															</content>
															<text fixtext=" "/>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
										<variables>
											<variable name="baselineHeader" value="concat(&apos;Baseline Model:  &apos;,comp:COBieModelADisplayName)" valuetype="xs:string"/>
											<variable name="revisionHeader" value="concat(&apos;Revision Model:  &apos;,comp:COBieModelBDisplayName)" valuetype="xs:string"/>
										</variables>
									</template>
									<newline/>
									<paragraph paragraphtag="h3">
										<children>
											<text fixtext="Description"/>
										</children>
									</paragraph>
									<newline/>
									<paragraph paragraphtag="p">
										<children>
											<text fixtext="This report indicates the difference evaluated between a baseline version of a COBie document and a revision version of a COBie document.  The evaluation algorithm is implemented in a BiMServer satellite application and in a custom build of BiMServer.  Visit the "/>
											<link>
												<children>
													<text fixtext="COBie project page"/>
												</children>
												<action>
													<none/>
												</action>
												<hyperlink>
													<fixtext value="http://www.wbdg.org/resources/cobie.php"/>
												</hyperlink>
											</link>
											<text fixtext=" for more information."/>
										</children>
									</paragraph>
									<line/>
									<line/>
									<template subtype="element" levelflag="1" match="comp:COBieSheetComparisons">
										<children>
											<template subtype="uservariable" match="$sectionHeader">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
											<template subtype="element" levelflag="1" match="comp:Added">
												<children>
													<condition>
														<children>
															<conditionbranch xpath="count(comp:COBieItemAdded)=0">
																<children>
																	<text fixtext="No records added"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="count(comp:COBieItemAdded)&gt;0">
																<children>
																	<tgrid hiderows="when-empty">
																		<properties border="1"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol/>
																					<tgridcol/>
																				</children>
																			</tgridbody-cols>
																			<tgridheader-rows>
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<text fixtext="Row Key"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Row #"/>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																			</tgridheader-rows>
																			<tgridbody-rows>
																				<children>
																					<template subtype="element" match="comp:COBieItemAdded">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="comp:RowId">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="userdefined" match="sum(comp:RowNumbersum,1)">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="int"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<properties bgcolor="silver"/>
																								<children>
																									<tgridcell>
																										<styles text-align="center"/>
																									</tgridcell>
																									<tgridcell joinleft="1"/>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<properties bgcolor="white"/>
																								<children>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Row Key">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Row #">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables>
													<variable name="headerText" value="concat($sectionPosition,&apos;.&apos;,1,&apos; &apos;,parent::comp:COBieSheetComparisons/comp:COBieSheetName,&apos; Added&apos;)" valuetype="xs:string"/>
												</variables>
											</template>
											<template subtype="element" levelflag="1" match="comp:Deleted">
												<children>
													<condition>
														<children>
															<conditionbranch xpath="count(comp:COBieItemDeleted)=0">
																<children>
																	<text fixtext="No records deleted"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="count(comp:COBieItemDeleted)&gt;0">
																<children>
																	<tgrid hiderows="when-empty">
																		<properties border="1"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol/>
																					<tgridcol/>
																				</children>
																			</tgridbody-cols>
																			<tgridheader-rows>
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<text fixtext="Row Key"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Row #"/>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																			</tgridheader-rows>
																			<tgridbody-rows>
																				<children>
																					<template subtype="element" match="comp:COBieItemDeleted">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="comp:RowId">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="userdefined" match="sum(comp:RowNumber,1)">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="int"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<properties bgcolor="silver"/>
																								<children>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0"/>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell joinleft="1"/>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<properties align="center" bgcolor="white"/>
																								<children>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Row Key">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Row #">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables>
													<variable name="subsectionNumber" value="if(count(preceding::comp:Added/comp:COBieItemAdded)&gt;0) then &apos;2&apos; else &apos;1&apos;" valuetype="xs:string"/>
													<variable name="headerText" value="concat($sectionPosition,&apos;.&apos;,$subsectionNumber,&apos; &apos;,parent::comp:COBieSheetComparisons/comp:COBieSheetName,&apos; Deleted&apos;)" valuetype="xs:string"/>
												</variables>
											</template>
											<template subtype="element" levelflag="1" match="comp:Modified">
												<children>
													<condition>
														<children>
															<conditionbranch xpath="count(comp:COBieItemModified)=0">
																<children>
																	<text fixtext="No records modified"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="count(comp:COBieItemModified)&gt;0">
																<children>
																	<tgrid hiderows="when-empty">
																		<properties border="1"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol/>
																					<tgridcol/>
																					<tgridcol/>
																					<tgridcol/>
																				</children>
																			</tgridbody-cols>
																			<tgridheader-rows>
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<text fixtext="Row Key"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Baseline Row #"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Revision Row #"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Changes"/>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																			</tgridheader-rows>
																			<tgridbody-rows>
																				<children>
																					<template subtype="element" match="comp:COBieItemModified">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="comp:RowId">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="userdefined" match="sum(comp:Model1RowNumber,1)">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="int"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="userdefined" match="sum(comp:Model2RowNumber,1)">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="int"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="comp:Changes">
																												<children>
																													<tgrid>
																														<properties border="1"/>
																														<children>
																															<tgridbody-cols>
																																<children>
																																	<tgridcol/>
																																	<tgridcol/>
																																	<tgridcol/>
																																</children>
																															</tgridbody-cols>
																															<tgridheader-rows>
																																<children>
																																	<tgridrow>
																																		<children>
																																			<tgridcell>
																																				<children>
																																					<text fixtext="Column"/>
																																				</children>
																																			</tgridcell>
																																			<tgridcell>
																																				<children>
																																					<text fixtext="Baseline Value"/>
																																				</children>
																																			</tgridcell>
																																			<tgridcell>
																																				<children>
																																					<text fixtext="Revision Value"/>
																																				</children>
																																			</tgridcell>
																																		</children>
																																	</tgridrow>
																																</children>
																															</tgridheader-rows>
																															<tgridbody-rows>
																																<children>
																																	<template subtype="element" match="comp:COBieChangeItem">
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<template subtype="element" match="comp:ColumnName">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<template subtype="element" match="comp:Model1Value">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<template subtype="element" match="comp:Model2Value">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																				</children>
																																			</tgridrow>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridbody-rows>
																														</children>
																													</tgrid>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<properties bgcolor="silver"/>
																								<children>
																									<tgridcell>
																										<styles text-align="center"/>
																									</tgridcell>
																									<tgridcell joinleft="1"/>
																									<tgridcell joinleft="1"/>
																									<tgridcell joinleft="1"/>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Row Key">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Baseline Row #">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 5 = 0">
																														<children>
																															<text fixtext="Revision Row #">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<styles text-align="center"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<text fixtext="Changes">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables>
													<variable name="subsectionNumber" value="if(count(preceding::comp:Added/comp:COBieItemAdded)&gt;0 and 
count(preceding::comp:Deleted/comp:COBieItemDeleted)&gt;0) then &apos;3&apos; else
if(count(preceding::comp:Added/comp:COBieItemAdded)&gt;0 and 
count(preceding::comp:Deleted/comp:COBieItemDeleted)=0) then &apos;2&apos; else
if(count(preceding::comp:Added/comp:COBieItemDeleted&gt;0))then &apos;2&apos; else
&apos;1&apos;" valuetype="xs:string"/>
													<variable name="subsectionHeaderText" value="concat($sectionPosition,&apos;.&apos;,$subsectionNumber,&apos; &apos;, parent::comp:COBieSheetComparisons/comp:COBieSheetName,&apos; Modified&apos;)" valuetype="xs:string"/>
												</variables>
											</template>
										</children>
										<variables>
											<variable name="addedHeader" value="concat(position(),&apos;.1 &apos;,comp:COBieSheetName,&apos; Added&apos;)" valuetype="xs:string"/>
											<variable name="modifiedHeader" value="concat(position(),&apos;.3 &apos;,comp:COBieSheetName,&apos; modified&apos;)" valuetype="xs:string"/>
											<variable name="deletedHeader" value="concat(position(),&apos;.2 &apos;,comp:COBieSheetName,&apos; deleted&apos;)" valuetype="xs:string"/>
											<variable name="sectionHeader" value="concat(position(),&apos;. &apos;,comp:COBieSheetName)" valuetype="xs:string"/>
											<variable name="sectionPosition" value="position()" valuetype="xs:integer"/>
										</variables>
									</template>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
