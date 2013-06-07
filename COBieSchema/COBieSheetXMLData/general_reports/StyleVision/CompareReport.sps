<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="comp" uri="compare.cobie.shared.bimserver.org"/>
			<nspair prefix="n1" uri="compare.projent.shared.bimserver.org"/>
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
									<template subtype="element" match="CompareMetadata">
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
													<template subtype="element" match="CompareDateTime">
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
											<variable name="baselineHeader" value="concat(&apos;Baseline Model:  &apos;,COBieModelADisplayName)" valuetype="xs:string"/>
											<variable name="revisionHeader" value="concat(&apos;Revision Model:  &apos;,COBieModelBDisplayName)" valuetype="xs:string"/>
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
									<toc name="toc">
										<children>
											<paragraph paragraphtag="h1">
												<children>
													<text fixtext="Table of Contents"/>
												</children>
											</paragraph>
											<reflevel>
												<children>
													<paragraph paragraphtag="h3">
														<children>
															<ref name="tocBookmark" createhyperlink="1">
																<children>
																	<field type="ref-entrytext"/>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</ref>
														</children>
													</paragraph>
													<reflevel>
														<children>
															<paragraph paragraphtag="h4">
																<children>
																	<text fixtext="  "/>
																	<ref name="tocBookmark" createhyperlink="1">
																		<children>
																			<field type="ref-entrytext"/>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</ref>
																</children>
															</paragraph>
														</children>
													</reflevel>
												</children>
											</reflevel>
										</children>
									</toc>
									<line/>
									<template subtype="element" levelflag="1" match="COBieSheetComparisons">
										<children>
											<condition>
												<children>
													<conditionbranch xpath="$sectionPosition&gt;1">
														<children>
															<line/>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<marker name="tocBookmark">
												<children>
													<template subtype="uservariable" match="$sectionHeader">
														<children>
															<paragraph paragraphtag="h3">
																<children>
																	<content/>
																</children>
															</paragraph>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
											<template subtype="element" levelflag="1" match="Added">
												<children>
													<marker name="tocBookmark">
														<children>
															<paragraph paragraphtag="h4">
																<children>
																	<template subtype="uservariable" match="$headerText">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" "/>
																</children>
															</paragraph>
														</children>
													</marker>
													<condition>
														<children>
															<conditionbranch xpath="count(COBieItemAdded)=0">
																<children>
																	<text fixtext="No records added"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="count(COBieItemAdded)&gt;0">
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
																					<template subtype="element" match="COBieItemAdded">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="RowId">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="RowNumber">
																												<children>
																													<template subtype="uservariable" match="$realRowNumber">
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="integer"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables>
																													<variable name="realRowNumber" value="xs:integer(.)+1" valuetype="xs:integer"/>
																												</variables>
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
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<ref name="tocBookmark" createhyperlink="1">
																																<children>
																																	<text fixtext="Return to Top"/>
																																</children>
																															</ref>
																															<text fixtext=" "/>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
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
																	<link>
																		<children>
																			<text fixtext="Table of Contents"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#TOP"/>
																		</hyperlink>
																	</link>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables>
													<variable name="sectionName" value="concat(parent::COBieSheetComparisons/COBieSheetName,&apos; Added&apos;)" valuetype="xs:string"/>
													<variable name="headerText" value="concat($sectionPosition,&apos;.&apos;,1,&apos; &apos;,$sectionName)" valuetype="xs:string"/>
												</variables>
											</template>
											<template subtype="element" levelflag="1" match="Deleted">
												<children>
													<marker name="tocBookmark">
														<children>
															<paragraph paragraphtag="h4">
																<children>
																	<template subtype="uservariable" match="$headerText">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</paragraph>
														</children>
													</marker>
													<condition>
														<children>
															<conditionbranch xpath="count(COBieItemDeleted)=0">
																<children>
																	<text fixtext="No records deleted"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="count(COBieItemDeleted)&gt;0">
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
																					<template subtype="element" match="COBieItemDeleted">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="RowId">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="RowNumber">
																												<children>
																													<template subtype="uservariable" match="$realRowNumber">
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="integer"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables>
																													<variable name="realRowNumber" value="xs:integer(.)+1" valuetype="xs:integer"/>
																												</variables>
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
																													<conditionbranch xpath="position() mod 20 = 0">
																														<children>
																															<ref name="tocBookmark" createhyperlink="1">
																																<children>
																																	<text fixtext="Return to Top"/>
																																</children>
																															</ref>
																														</children>
																													</conditionbranch>
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
																	<link>
																		<children>
																			<text fixtext="Table of Contents"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#TOP"/>
																		</hyperlink>
																	</link>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables>
													<variable name="subsectionNumber" value="if(count(preceding::Added/COBieItemAdded)&gt;0) then &apos;2&apos; else &apos;1&apos;" valuetype="xs:string"/>
													<variable name="headerText" value="concat($sectionPosition,&apos;.&apos;,$subsectionNumber,&apos; &apos;,parent::COBieSheetComparisons/COBieSheetName,&apos; Deleted&apos;)" valuetype="xs:string"/>
												</variables>
											</template>
											<template subtype="element" levelflag="1" match="Modified">
												<children>
													<marker name="tocBookmark">
														<children>
															<template subtype="uservariable" match="$modifiedHeader">
																<children>
																	<paragraph paragraphtag="h4">
																		<children>
																			<content/>
																		</children>
																	</paragraph>
																</children>
																<variables/>
															</template>
														</children>
													</marker>
													<condition>
														<children>
															<conditionbranch xpath="count(COBieItemModified)=0">
																<children>
																	<text fixtext="No records modified"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="count(COBieItemModified)&gt;0">
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
																					<template subtype="element" match="COBieItemModified">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="RowId">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="Model1RowNumber">
																												<children>
																													<template subtype="uservariable" match="$realRowNumber">
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="integer"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables>
																													<variable name="realRowNumber" value="xs:integer(.)+1" valuetype="xs:integer"/>
																												</variables>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="Model2RowNumber">
																												<children>
																													<template subtype="uservariable" match="$realRowNumber">
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="integer"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables>
																													<variable name="realRowNumber" value="xs:integer(.)+1" valuetype="xs:integer"/>
																												</variables>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="Changes">
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
																																	<template subtype="element" match="COBieChangeItem">
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<template subtype="element" match="ColumnName">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<template subtype="element" match="Model1Value">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<template subtype="element" match="Model2Value">
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
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="position() mod 5 = 0">
																														<children>
																															<ref name="tocBookmark" createhyperlink="1">
																																<children>
																																	<text fixtext="Return to Top"/>
																																</children>
																															</ref>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
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
																	<link>
																		<children>
																			<text fixtext="Table of Contents"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#TOP"/>
																		</hyperlink>
																	</link>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables>
													<variable name="subsectionNumber" value="if(count(preceding::Added/COBieItemAdded)&gt;0 and 
count(preceding::Deleted/COBieItemDeleted)&gt;0) then &apos;3&apos; else
if(count(preceding::Added/COBieItemAdded)&gt;0 and 
count(preceding::Deleted/COBieItemDeleted)=0) then &apos;2&apos; else
if(count(preceding::Added/COBieItemDeleted&gt;0))then &apos;2&apos; else
&apos;1&apos;" valuetype="xs:string"/>
													<variable name="subsectionHeaderText" value="concat($sectionPosition,&apos;.&apos;,$subsectionNumber,&apos; &apos;, parent::COBieSheetComparisons/COBieSheetName,&apos; Modified&apos;)" valuetype="xs:string"/>
												</variables>
											</template>
										</children>
										<variables>
											<variable name="addedHeader" value="concat(position(),&apos;.1 &apos;,COBieSheetName,&apos; Added&apos;)" valuetype="xs:string"/>
											<variable name="modifiedHeader" value="concat(position(),&apos;.3 &apos;,COBieSheetName,&apos; modified&apos;)" valuetype="xs:string"/>
											<variable name="deletedHeader" value="concat(position(),&apos;.2 &apos;,COBieSheetName,&apos; deleted&apos;)" valuetype="xs:string"/>
											<variable name="sectionHeader" value="concat(position(),&apos;. &apos;,COBieSheetName)" valuetype="xs:string"/>
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
