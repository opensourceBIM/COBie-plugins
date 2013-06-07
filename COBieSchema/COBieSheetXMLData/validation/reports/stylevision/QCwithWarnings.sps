<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="XHTML 1.0" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="svrl" uri="http://purl.oclc.org/dsdl/svrl"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="svrl.xsd" workingxmlfile="SVRMLExample.xml"/>
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
	<globalstyles>
		<rules selector="body">
			<media>
				<media value="all"/>
			</media>
			<rule background="#fff" font="76%/160% &quot;Trebuchet MS&quot;,Verdana,Arial,Helvetica,sans-serif"/>
		</rules>
		<rules selector="table">
			<media>
				<media value="all"/>
			</media>
			<rule border-right="1px solid #e5eff8" border-top="1px solid #e5eff8" width="90%"/>
		</rules>
		<rules selector="tr.odd td">
			<media>
				<media value="all"/>
			</media>
			<rule background="#f7fbff"/>
		</rules>
		<rules selector="tr.odd .column1">
			<media>
				<media value="all"/>
			</media>
			<rule background="#f4f9fe"/>
		</rules>
		<rules selector=".column1">
			<media>
				<media value="all"/>
			</media>
			<rule background="#f9fcfe"/>
		</rules>
		<rules selector="td">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom="1px solid #e5eff8" border-left="1px solid #e5eff8" color="#678197" padding="1em 1em" text-align="center"/>
		</rules>
		<rules selector="th">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom="1px solid #e5eff8" border-left="1px solid #e5eff8" color="#678197" font-weight="normal" padding=".3em 1em" text-align="left"/>
		</rules>
		<rules selector="thead th">
			<media>
				<media value="all"/>
			</media>
			<rule background="#f4f9fe" color="#66a3d3" font="bold 1.2em/2em &quot;Century Gothic&quot;,&quot;Trebuchet MS&quot;,Arial,Helvetica,sans-serif" text-align="center"/>
		</rules>
		<rules selector="tfoot th">
			<media>
				<media value="all"/>
			</media>
			<rule background="#f4f9fe" text-align="center"/>
		</rules>
		<rules selector="tfoot th strong">
			<media>
				<media value="all"/>
			</media>
			<rule color="#66a3d3" font="bold 1.2em &quot;Century Gothic&quot;,&quot;Trebuchet MS&quot;,Arial,Helvetica,sans-serif" margin=".5em .5em .5em 0"/>
		</rules>
		<rules selector="tfoot th em">
			<media>
				<media value="all"/>
			</media>
			<rule color="#f03b58" font-size="1.1em" font-style="normal" font-weight="bold"/>
		</rules>
		<rules selector="table a, table a:link, table a:visited">
			<media>
				<media value="all"/>
			</media>
			<rule border="none"/>
		</rules>
		<rules selector="a:hover,a:focus">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom="1px solid #f03b58" color="#f03b58" text-decoration="none"/>
		</rules>
		<rules selector="a:visited">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom="none" color="rgb(0, 138, 255)" text-decoration="none"/>
		</rules>
		<rules selector="a:link">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom="1px dotted rgb(0, 138, 255)" color="rgb(0, 138, 255)" text-decoration="none"/>
		</rules>
		<rules selector="html, body, form, fieldset, h1, h2, h3, h4, h5, h6, pre, blockquote, ul, ol, dl, address">
			<media>
				<media value="all"/>
			</media>
			<rule margin="10px" padding="0"/>
		</rules>
		<rules selector="p">
			<media>
				<media value="all"/>
			</media>
			<rule font-size="small" margin-left="20px"/>
		</rules>
		<rules selector="h2">
			<media>
				<media value="all"/>
			</media>
			<rule font-size="xx-large"/>
		</rules>
		<rules selector="h3">
			<media>
				<media value="all"/>
			</media>
			<rule font-size="x-large"/>
		</rules>
		<rules selector="h4">
			<media>
				<media value="all"/>
			</media>
			<rule font-size="large"/>
		</rules>
		<rules selector="h5">
			<media>
				<media value="all"/>
			</media>
			<rule font-size="medium"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<paragraph paragraphtag="h1">
						<children>
							<text fixtext="COBie QC report - Construction Deliverable">
								<styles font-size="xx-large"/>
							</text>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<children>
							<autocalc xpath="current-dateTime()">
								<format basic-type="xsd" string="YYYY&apos;-&apos;MM&apos;-&apos;DD&apos;T&apos;hh&apos;:&apos;mm&apos;:&apos;ss" datatype="dateTime"/>
							</autocalc>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<styles text-align="justify"/>
						<children>
							<text fixtext="Note:  This checking routine only validates the internal quality of the COBie file.  It does not validate the quality of the data with respect to the actual project.  For more information on the COBie checker please visit the COBie Means and Methods page at:"/>
						</children>
					</paragraph>
					<link>
						<children>
							<paragraph paragraphtag="p">
								<children>
									<text fixtext="http://www.buildingsmartalliance.org/index.php/projects/cobie"/>
								</children>
							</paragraph>
						</children>
						<action>
							<none/>
						</action>
						<hyperlink>
							<fixtext value="http://www.buildingsmartalliance.org/index.php/projects/cobie"/>
						</hyperlink>
					</link>
					<line/>
					<paragraph paragraphtag="h2">
						<children>
							<text fixtext="Instructions">
								<styles font-weight="bold"/>
							</text>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<styles text-align="justify"/>
						<children>
							<text fixtext="Save a new copy of your COBie model (either IFC or Spreadsheet) to a new file name so that you have a backup.  Based on the information in this report update the copied file to correct each issue.  To find the error in the COBie file, match the issue by Worksheet Name, Row Number, and object name to the data in your file.  For example, a problem with the fifth space in the space worksheet, pertaining to the room named &quot;Vestibule&quot; would be listed as Space[5]:Vestibule.  Once each relevant issue is fixed, re-run your file and see the impact of your changes. Note that this report provides a generic test, therefore, some issues may be allowed if the terms and conditions of your contract differ from those assumed in this reporting tool.  Please consult your contract to evaluate the specific requirements for specific COBie deliverables on your projects."/>
						</children>
					</paragraph>
					<line/>
					<newline/>
					<paragraph>
						<styles text-align="left"/>
						<children>
							<bookmark>
								<children>
									<toc name="toc">
										<children>
											<paragraph paragraphtag="h1">
												<styles text-align="left"/>
												<children>
													<text fixtext="Table of Contents"/>
												</children>
											</paragraph>
											<newline/>
											<reflevel>
												<children>
													<paragraph paragraphtag="h3">
														<styles text-align="left"/>
														<children>
															<ref name="Level1Section" createhyperlink="1">
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
																<styles text-align="left"/>
																<children>
																	<ref name="Level1Section" createhyperlink="1">
																		<children>
																			<text fixtext="   "/>
																			<field type="ref-entrytext"/>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</ref>
																</children>
															</paragraph>
															<reflevel>
																<children>
																	<paragraph paragraphtag="h5">
																		<styles text-align="left"/>
																		<children>
																			<ref name="Level1Section" createhyperlink="1">
																				<children>
																					<text fixtext="      "/>
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
											</reflevel>
										</children>
									</toc>
								</children>
								<action>
									<none/>
								</action>
								<bookmark>
									<fixtext value="TOC"/>
								</bookmark>
							</bookmark>
							<line/>
							<template subtype="source" match="XML">
								<children>
									<calltemplate subtype="element" match="svrl:schematron-output"/>
								</children>
								<variables/>
							</template>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="svrl:schematron-output" schema-tree-path="$XML/svrl:schematron-output">
				<children>
					<template subtype="element" match="svrl:schematron-output">
						<children>
							<level>
								<children>
									<marker name="Level1Section">
										<children>
											<text fixtext=" "/>
											<paragraph paragraphtag="h2">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" QC Summary"/>
												</children>
											</paragraph>
										</children>
									</marker>
									<paragraph paragraphtag="p">
										<children>
											<text fixtext="Note: Row/Column checks are only listed for worksheets containing at least one row, but row count checks are listed for Contact, Facility, Space, Type, and Component (worksheets that must contain data) regardless of row count. "/>
										</children>
									</paragraph>
									<level>
										<children>
											<marker name="Level1Section">
												<children>
													<text fixtext=" "/>
													<paragraph paragraphtag="h3">
														<children>
															<num-lvl format="1.1.1"/>
															<text fixtext=" COBie Summary Table"/>
														</children>
													</paragraph>
												</children>
											</marker>
											<tgrid>
												<properties border="1"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol/>
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
																			<text fixtext="Worksheet"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<text fixtext="Has Rows?"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<text fixtext="Row Count"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<text fixtext="Row Warning Count"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<text fixtext="Row Error Count"/>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridheader-rows>
													<tgridbody-rows>
														<children>
															<template subtype="element" groupingtype="group-by" groupingmatch="@id" filter="@role=&apos;WorksheetCount&apos;" match="svrl:fired-rule">
																<children>
																	<template subtype="userdefined" match="current-grouping-key()">
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="$rowCount&gt;0">
																										<children>
																											<link>
																												<children>
																													<template subtype="uservariable" match="$singularizedWorksheetName">
																														<children>
																															<content/>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<action>
																													<none/>
																												</action>
																												<hyperlink>
																													<fixtext value="#"/>
																													<xpath value="string($rootMatch)"/>
																												</hyperlink>
																											</link>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="$rowCount=0 or $rowCount!=$rowCount">
																										<children>
																											<template subtype="uservariable" match="$singularizedWorksheetName">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="uservariable" match="$moreThanOneRow">
																								<children>
																									<content/>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="string($rowCount)=&apos;NaN&apos;">
																										<children>
																											<text fixtext="0"/>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="string($rowCount)!=&apos;NaN&apos;">
																										<children>
																											<template subtype="uservariable" match="$rowCount">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="double"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="uservariable" match="$warningCount">
																								<children>
																									<content/>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="uservariable" match="$errorCount">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="integer"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																		<variables>
																			<variable name="rootMatch" value="if  ($rowCount&gt;0) then $errorRules[starts-with(@id,current-grouping-key()) and @id!=current-grouping-key()][1]/@id else &apos;n/a&apos;" valuetype="xs:string"/>
																			<variable name="matchingErrorRule" value="$failedAssertions[starts-with(preceding-sibling::svrl:fired-rule[1]/@id,current-grouping-key())]/preceding-sibling::svrl:fired-rule[1]" valuetype="&lt;auto&gt;"/>
																			<variable name="matchingErrorRuleID" value="$matchingErrorRule/@id" valuetype="xs:string"/>
																			<variable name="failedAsserts" value="$failedAssertions[starts-with(preceding-sibling::svrl:fired-rule[1]/@id,current-grouping-key())]" valuetype="&lt;auto&gt;"/>
																			<variable name="errorCount" value="if (string($rowCount)!=&apos;NaN&apos; and $rowCount&gt;0) then string(count(distinct-values($failedAsserts[not(sps:isAssertWarning(@id))]/@location))) else &apos;n/a&apos;" valuetype="xs:string"/>
																			<variable name="moreThanOneRow" value="$rowCount=$rowCount and $rowCount&gt;0" valuetype="xs:boolean"/>
																			<variable name="warningCount" value="if (string($rowCount)!=&apos;NaN&apos; and $rowCount&gt;0) then string(count(distinct-values($failedAsserts[sps:isAssertWarning(@id)]/@location))) else &apos;n/a&apos;" valuetype="xs:string"/>
																		</variables>
																	</template>
																</children>
																<variables>
																	<variable name="worksheetName" value="if (string-length(substring-after(replace(@id,&apos;COBie.&apos;,&apos;&apos;),&apos;.&apos;))=0)
then replace(@id,&apos;COBie.&apos;,&apos;&apos;)
else
substring-after(replace(@id,&apos;COBie.&apos;,&apos;&apos;),&apos;.&apos;)" valuetype="xs:string"/>
																	<variable name="singularizedWorksheetName" value="if(sps:isPluralSheetName($worksheetName)) then sps:singularizeSheetName($worksheetName) else
$worksheetName" valuetype="xs:string"/>
																	<variable name="successfulReport" value="following-sibling::svrl:successful-report[1]" valuetype="xs:string"/>
																	<variable name="rowCount" value="number(normalize-space(replace($successfulReport,$worksheetName,&apos;&apos;)))" valuetype="xs:double"/>
																	<variable name="idNode" value="@id" valuetype="&lt;auto&gt;"/>
																</variables>
															</template>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
											<newline/>
											<newline/>
										</children>
									</level>
									<text fixtext=" "/>
									<template subtype="uservariable" groupingtype="group-by" groupingmatch="preceding-sibling::svrl:fired-rule[1]/@id" match="$errorRoleContent">
										<children>
											<level>
												<children>
													<marker name="Level1Section">
														<children>
															<text fixtext=" "/>
															<bookmark>
																<children>
																	<paragraph paragraphtag="h4">
																		<children>
																			<template subtype="uservariable" match="$ruleGroupName">
																				<children>
																					<num-lvl format="1.1.1"/>
																					<text fixtext=" "/>
																					<content/>
																					<text fixtext="  "/>
																					<condition>
																						<children>
																							<conditionbranch xpath="$isWorksheet">
																								<children>
																									<text fixtext="(row count check)"/>
																								</children>
																							</conditionbranch>
																							<conditionbranch xpath="not($isWorksheet) and $countTotalSheetRows=1">
																								<children>
																									<text fixtext="(checked "/>
																									<template subtype="uservariable" match="$countTotalSheetRows">
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="integer"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																									<text fixtext=" row)"/>
																								</children>
																							</conditionbranch>
																							<conditionbranch xpath="not($isWorksheet) and $countTotalSheetRows!=1">
																								<children>
																									<text fixtext="(checked "/>
																									<template subtype="uservariable" match="$countTotalSheetRows">
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="integer"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																									<text fixtext=" rows)"/>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																</children>
																<action>
																	<none/>
																</action>
																<bookmark>
																	<xpath value="encode-for-uri($ruleGroupName)"/>
																</bookmark>
															</bookmark>
														</children>
													</marker>
													<paragraph paragraphtag="p">
														<styles text-align="left"/>
														<children>
															<text fixtext="Total ">
																<styles font-style="italic"/>
															</text>
															<template subtype="uservariable" match="$ruleGroupName">
																<children>
																	<text fixtext="correct ">
																		<styles font-style="italic"/>
																	</text>
																	<content>
																		<styles font-style="italic"/>
																	</content>
																	<text fixtext=" items"/>
																	<text fixtext=" ">
																		<styles font-style="italic"/>
																	</text>
																</children>
																<variables/>
															</template>
															<text fixtext=" = ">
																<styles font-style="italic"/>
															</text>
															<template subtype="uservariable" match="$correctCount">
																<children>
																	<content>
																		<format basic-type="xsd" datatype="integer"/>
																	</content>
																</children>
																<variables/>
															</template>
															<text fixtext=" of ">
																<styles font-style="italic"/>
															</text>
															<template subtype="uservariable" match="$countTotalSheetRows">
																<children>
																	<content>
																		<styles font-style="italic"/>
																		<format basic-type="xsd" datatype="integer"/>
																	</content>
																</children>
																<variables/>
															</template>
															<text fixtext=" (">
																<styles font-style="italic"/>
															</text>
															<template subtype="uservariable" match="$percentCorrect">
																<children>
																	<content>
																		<styles font-style="italic"/>
																		<format basic-type="xsd" string="##0.##" datatype="double"/>
																	</content>
																	<text fixtext="% correct">
																		<styles font-style="italic"/>
																	</text>
																</children>
																<variables/>
															</template>
															<text fixtext=")">
																<styles font-style="italic"/>
															</text>
														</children>
													</paragraph>
													<paragraph paragraphtag="h5">
														<children>
															<text fixtext="Checks Performed">
																<styles text-decoration="underline"/>
															</text>
														</children>
													</paragraph>
													<paragraph paragraphtag="p">
														<styles text-align="left"/>
														<children>
															<template subtype="uservariable" match="$distinctRules">
																<children>
																	<condition>
																		<children>
																			<conditionbranch xpath="position()=last()">
																				<children>
																					<template subtype="uservariable" match="$currentValue">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="position()&lt;last()">
																				<children>
																					<template subtype="uservariable" match="$currentValue">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																					<text fixtext=", "/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
																<variables>
																	<variable name="currentValue" value="current()" valuetype="xs:string"/>
																</variables>
															</template>
														</children>
													</paragraph>
													<paragraph paragraphtag="h5">
														<children>
															<text fixtext="Field Error Counts">
																<styles text-decoration="underline"/>
															</text>
														</children>
													</paragraph>
													<paragraph paragraphtag="p">
														<styles text-align="left"/>
														<children>
															<template subtype="userdefined" groupingtype="group-by" groupingmatch="@flag" match="current-group()">
																<children>
																	<template subtype="userdefined" match="current-grouping-key()">
																		<children>
																			<template subtype="uservariable" match="$incorrectFieldOccurencesMessage">
																				<children>
																					<content/>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables>
																			<variable name="incorrectFieldOccurenceCount" value="count(distinct-values(current-group()[name(self::element())=&apos;svrl:failed-assert&apos; and not(sps:isAssertWarning(@id))]/@location))" valuetype="xs:integer"/>
																			<variable name="incorrectFieldOccurencesMessage" value="concat(concat(string(current-grouping-key()),string(&apos;: &apos;)),string($incorrectFieldOccurenceCount))" valuetype="xs:string"/>
																		</variables>
																	</template>
																	<condition>
																		<children>
																			<conditionbranch xpath="position()&gt;=1 and position()&lt;last()">
																				<children>
																					<text fixtext=", "/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
																<variables/>
															</template>
														</children>
													</paragraph>
													<newline/>
													<paragraph paragraphtag="h5">
														<children>
															<text fixtext="Field Warning Counts">
																<styles text-decoration="underline"/>
															</text>
														</children>
													</paragraph>
													<paragraph paragraphtag="p">
														<styles text-align="left"/>
														<children>
															<template subtype="userdefined" groupingtype="group-by" groupingmatch="@flag" match="current-group()">
																<children>
																	<template subtype="userdefined" match="current-grouping-key()">
																		<children>
																			<template subtype="uservariable" match="$incorrectFieldOccurencesMessage">
																				<children>
																					<content/>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables>
																			<variable name="incorrectFieldOccurenceCount" value="count(distinct-values(current-group()[name(self::element())=&apos;svrl:failed-assert&apos; and sps:isAssertWarning(@id)]/@location))" valuetype="xs:integer"/>
																			<variable name="incorrectFieldOccurencesMessage" value="concat(concat(string(current-grouping-key()),string(&apos;: &apos;)),string($incorrectFieldOccurenceCount))" valuetype="xs:string"/>
																		</variables>
																	</template>
																	<condition>
																		<children>
																			<conditionbranch xpath="position()&gt;=1 and position()&lt;last()">
																				<children>
																					<text fixtext=", "/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
																<variables/>
															</template>
														</children>
													</paragraph>
												</children>
											</level>
											<paragraph paragraphtag="p">
												<styles text-align="left"/>
												<children>
													<link>
														<children>
															<text fixtext="Table of Contents">
																<styles padding-left="25px"/>
															</text>
														</children>
														<action>
															<none/>
														</action>
														<hyperlink>
															<fixtext value="#TOC"/>
														</hyperlink>
													</link>
												</children>
											</paragraph>
											<line/>
										</children>
										<variables>
											<variable name="ruleGroupName" value="string(current-grouping-key())" valuetype="xs:string"/>
											<variable name="countTotalSheetRows" value="count(distinct-values(current-group()/@location))" valuetype="xs:integer"/>
											<variable name="countDistinctRowErrors" value="count(distinct-values(current-group()[name(self::element())=&apos;svrl:failed-assert&apos; and not(sps:isAssertWarning(@id))]/@location))" valuetype="xs:integer"/>
											<variable name="distinctRules" value="distinct-values(current-group()[name(.)=&apos;svrl:successful-report&apos;]/svrl:text)" valuetype="&lt;auto&gt;"/>
											<variable name="isWorksheet" value="string-length($ruleGroupName)-string-length(translate($ruleGroupName,&apos;.&apos;,&apos;&apos;))=1" valuetype="xs:boolean"/>
											<variable name="correctCount" value="$countTotalSheetRows - $countDistinctRowErrors" valuetype="xs:integer"/>
											<variable name="percentCorrect" value="100*(( $correctCount) div $countTotalSheetRows)" valuetype="&lt;auto&gt;"/>
										</variables>
									</template>
									<text fixtext=" "/>
								</children>
							</level>
							<text fixtext=" "/>
							<level>
								<children>
									<marker name="Level1Section">
										<children>
											<text fixtext=" "/>
											<paragraph paragraphtag="h2">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" Detailed Error Report Grouped by Error/Warning Type"/>
												</children>
											</paragraph>
										</children>
									</marker>
									<condition>
										<children>
											<conditionbranch xpath="count($errorRoleContent[name(.)=&apos;svrl:failed-assert&apos; and not(ends-with(@id,&apos;Warning&apos;))])=0">
												<children>
													<paragraph paragraphtag="p">
														<children>
															<text fixtext="No Errors"/>
														</children>
													</paragraph>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<template subtype="userdefined" groupingtype="group-by" groupingmatch="preceding-sibling::svrl:fired-rule[1]/@id" match="$errorRoleContent[name(.)=&apos;svrl:failed-assert&apos;]">
										<children>
											<level>
												<children>
													<marker name="Level1Section">
														<children>
															<text fixtext=" "/>
															<paragraph paragraphtag="h3">
																<children>
																	<template subtype="uservariable" match="$ruleGroupName">
																		<children>
																			<num-lvl format="1.1.1"/>
																			<text fixtext=" "/>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" ("/>
																	<template subtype="uservariable" match="$errorCount">
																		<children>
																			<content>
																				<format basic-type="xsd" datatype="integer"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" invalid "/>
																	<condition displayallbranches="1">
																		<children>
																			<conditionbranch xpath="not($isWorksheet) and $errorCount=1">
																				<children>
																					<text fixtext="row "/>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="not($isWorksheet) and $errorCount!=1">
																				<children>
																					<text fixtext="rows"/>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="$isWorksheet">
																				<children>
																					<text fixtext=" worksheet error(s)"/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																	<text fixtext=", "/>
																	<template subtype="uservariable" match="$warningCount">
																		<children>
																			<content>
																				<format basic-type="xsd" datatype="integer"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" warnings)"/>
																</children>
															</paragraph>
														</children>
													</marker>
													<template subtype="userdefined" groupingtype="group-by" groupingmatch="@id" match="current-group()">
														<children>
															<level>
																<children>
																	<marker name="Level2Section">
																		<children>
																			<text fixtext=" "/>
																			<bookmark>
																				<children>
																					<paragraph paragraphtag="h4">
																						<children>
																							<num-lvl format="1.1.1"/>
																							<text fixtext=" "/>
																							<condition>
																								<children>
																									<conditionbranch xpath="$isThisAWarning=true()">
																										<children>
																											<text fixtext="Warning:  "/>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="not($isThisAWarning)">
																										<children>
																											<text fixtext="Error:  "/>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																							<template subtype="uservariable" match="$tableHeadingText">
																								<children>
																									<content/>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" ("/>
																							<template subtype="uservariable" match="$groupCount">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="integer"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" occurence"/>
																							<condition>
																								<children>
																									<conditionbranch xpath="$groupCount!=1">
																										<children>
																											<text fixtext="s"/>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																							<text fixtext=")"/>
																						</children>
																					</paragraph>
																				</children>
																				<action>
																					<none/>
																				</action>
																				<bookmark>
																					<xpath value="encode-for-uri(@id)"/>
																				</bookmark>
																			</bookmark>
																		</children>
																	</marker>
																	<paragraph paragraphtag="p">
																		<children>
																			<condition>
																				<children>
																					<conditionbranch xpath="count(current-group())=0">
																						<children>
																							<text fixtext="No Effected Rows">
																								<styles text-decoration="underline"/>
																							</text>
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="count(current-group())&gt;0">
																						<children>
																							<text fixtext="Effected Rows:  ">
																								<styles text-decoration="underline"/>
																							</text>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</paragraph>
																	<paragraph paragraphtag="p">
																		<styles text-align="left"/>
																		<children>
																			<template subtype="userdefined" match="current-group()">
																				<children>
																					<link>
																						<children>
																							<template subtype="uservariable" match="$RowNumber">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="double"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																							<condition>
																								<children>
																									<conditionbranch xpath="position()&gt;=1 and position()&lt;last()">
																										<children>
																											<text fixtext=", "/>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<hyperlink>
																							<fixtext value="#"/>
																							<xpath value="@location"/>
																						</hyperlink>
																					</link>
																					<condition>
																						<children>
																							<conditionbranch xpath="position() mod 20 =0">
																								<children>
																									<paragraph paragraphtag="p">
																										<styles text-align="left"/>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables>
																					<variable name="RowNumber" value="number(substring-after(sps:COBieLocationHeading(current()/@location),&apos; &apos;))+1" valuetype="xs:double"/>
																				</variables>
																			</template>
																		</children>
																	</paragraph>
																</children>
															</level>
															<paragraph paragraphtag="p">
																<styles text-align="left"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="Table of Contents">
																				<styles padding-left="25px"/>
																			</text>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#TOC"/>
																		</hyperlink>
																	</link>
																</children>
															</paragraph>
															<line/>
														</children>
														<variables>
															<variable name="formattedLocation" value="sps:COBieLocationHeading( @location )" valuetype="xs:string"/>
															<variable name="cobieRowName" value="substring-before(svrl:text ,&apos;:&apos; )" valuetype="xs:string"/>
															<variable name="cobieRowNameNoPrefix" value="substring-after($cobieRowName,&apos;.&apos;)" valuetype="xs:string"/>
															<variable name="locationPrefix" value="substring-before($formattedLocation,&apos; &apos;)" valuetype="xs:string"/>
															<variable name="locationSuffix" value="substring-after($formattedLocation,&apos; &apos;)" valuetype="xs:string"/>
															<variable name="tableHeadingText" value="@id" valuetype="xs:string"/>
															<variable name="lastRuleFired" value="preceding-sibling::svrl:fired-rule[1]/@id" valuetype="xs:string"/>
															<variable name="groupCount" value="count(current-group())" valuetype="xs:integer"/>
															<variable name="isThisAWarning" value="sps:isAssertWarning(@id)" valuetype="xs:boolean"/>
														</variables>
													</template>
												</children>
											</level>
											<text fixtext="  "/>
										</children>
										<variables>
											<variable name="ruleGroupName" value="string(current-grouping-key())" valuetype="xs:string"/>
											<variable name="isWorksheet" value="string-length($ruleGroupName)-string-length(translate($ruleGroupName,&apos;.&apos;,&apos;&apos;))=1" valuetype="xs:boolean"/>
											<variable name="errorCount" value="count(distinct-values(current-group()[not(sps:isAssertWarning(@id))]/@location))" valuetype="xs:integer"/>
											<variable name="warningCount" value="count(distinct-values(current-group()[sps:isAssertWarning(@id)]/@location))" valuetype="xs:integer"/>
										</variables>
									</template>
								</children>
							</level>
							<text fixtext=" "/>
							<level>
								<children>
									<marker name="Level1Section">
										<children>
											<text fixtext=" "/>
											<paragraph paragraphtag="h2">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" Detailed Error Report Grouped by Row"/>
												</children>
											</paragraph>
										</children>
									</marker>
									<condition>
										<children>
											<conditionbranch xpath="count($errorRoleContent[name(.)=&apos;svrl:failed-assert&apos;])=0">
												<children>
													<paragraph paragraphtag="p">
														<children>
															<text fixtext="No Errors"/>
														</children>
													</paragraph>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<template subtype="userdefined" groupingtype="group-by" groupingmatch="preceding-sibling::svrl:fired-rule[1]/@id" match="$errorRoleContent[name(.)=&apos;svrl:failed-assert&apos;]">
										<children>
											<level>
												<children>
													<marker name="Level1Section">
														<children>
															<text fixtext=" "/>
															<paragraph paragraphtag="h3">
																<children>
																	<template subtype="uservariable" match="$ruleGroupName">
																		<children>
																			<num-lvl format="1.1.1"/>
																			<text fixtext=" "/>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" ("/>
																	<template subtype="uservariable" match="$errorCount">
																		<children>
																			<content>
																				<format basic-type="xsd" datatype="integer"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" invalid "/>
																	<condition displayallbranches="1">
																		<children>
																			<conditionbranch xpath="not($isWorksheet) and $errorCount=1">
																				<children>
																					<text fixtext="row "/>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="not($isWorksheet) and $errorCount!=1">
																				<children>
																					<text fixtext="rows"/>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="$isWorksheet">
																				<children>
																					<text fixtext=" worksheet error(s)"/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																	<text fixtext=", "/>
																	<template subtype="uservariable" match="$warningCount">
																		<children>
																			<content>
																				<format basic-type="xsd" datatype="integer"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" warnings)"/>
																</children>
															</paragraph>
														</children>
													</marker>
													<template subtype="userdefined" groupingtype="group-by" groupingmatch="@location" match="current-group()">
														<children>
															<level>
																<children>
																	<marker name="Level2Section">
																		<children>
																			<text fixtext=" "/>
																			<bookmark>
																				<children>
																					<paragraph paragraphtag="h4">
																						<children>
																							<num-lvl format="1.1.1"/>
																							<text fixtext=" "/>
																							<template subtype="uservariable" match="$tableHeadingText">
																								<children>
																									<content/>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" "/>
																						</children>
																					</paragraph>
																				</children>
																				<action>
																					<none/>
																				</action>
																				<bookmark>
																					<xpath value="@location"/>
																				</bookmark>
																			</bookmark>
																		</children>
																	</marker>
																	<newline/>
																	<condition>
																		<children>
																			<conditionbranch xpath="count(current-group()[not(sps:isAssertWarning(@id))])&gt;0">
																				<children>
																					<tgrid>
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
																													<text fixtext="Errors"/>
																												</children>
																											</tgridcell>
																											<tgridcell joinleft="1"/>
																										</children>
																									</tgridrow>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<text fixtext="Error ID"/>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<text fixtext="Error Message"/>
																												</children>
																											</tgridcell>
																										</children>
																									</tgridrow>
																								</children>
																							</tgridheader-rows>
																							<tgridbody-rows>
																								<children>
																									<template subtype="userdefined" groupingtype="group-adjacent" groupingmatch="@id" match="current-group()[not(sps:isAssertWarning(@id))]">
																										<children>
																											<template subtype="userdefined" match="current-group()">
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<link>
																																		<children>
																																			<template subtype="attribute" match="id">
																																				<children>
																																					<content/>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																		<action>
																																			<none/>
																																		</action>
																																		<hyperlink>
																																			<fixtext value="#"/>
																																			<xpath value="encode-for-uri(@id)"/>
																																		</hyperlink>
																																	</link>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="svrl:text">
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
																	<newline/>
																	<newline/>
																	<condition>
																		<children>
																			<conditionbranch xpath="count(current-group()[sps:isAssertWarning(@id)])&gt;0">
																				<children>
																					<tgrid>
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
																													<text fixtext="Warnings"/>
																												</children>
																											</tgridcell>
																											<tgridcell joinleft="1"/>
																										</children>
																									</tgridrow>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<text fixtext="Warning ID"/>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<text fixtext="Warning Message"/>
																												</children>
																											</tgridcell>
																										</children>
																									</tgridrow>
																								</children>
																							</tgridheader-rows>
																							<tgridbody-rows>
																								<children>
																									<template subtype="userdefined" groupingtype="group-adjacent" groupingmatch="@id" match="current-group()[sps:isAssertWarning(@id)]">
																										<children>
																											<template subtype="userdefined" match="current-group()">
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<link>
																																		<children>
																																			<template subtype="attribute" match="id">
																																				<children>
																																					<content/>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																		<action>
																																			<none/>
																																		</action>
																																		<hyperlink>
																																			<fixtext value="#"/>
																																			<xpath value="encode-for-uri(@id)"/>
																																		</hyperlink>
																																	</link>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="svrl:text">
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
															</level>
															<newline/>
															<text fixtext=" "/>
															<paragraph>
																<styles text-align="left"/>
																<children>
																	<link>
																		<children>
																			<text fixtext="Table of Contents">
																				<styles padding-left="25px"/>
																			</text>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#TOC"/>
																		</hyperlink>
																	</link>
																</children>
															</paragraph>
														</children>
														<variables>
															<variable name="formattedLocation" value="sps:COBieLocationHeading( @location )" valuetype="xs:string"/>
															<variable name="cobieRowName" value="substring-before(svrl:text ,&apos;:&apos; )" valuetype="xs:string"/>
															<variable name="cobieRowNameNoPrefix" value="substring-after($cobieRowName,&apos;.&apos;)" valuetype="xs:string"/>
															<variable name="locationPrefix" value="substring-before($formattedLocation,&apos; &apos;)" valuetype="xs:string"/>
															<variable name="locationSuffix" value="string(number(substring-after($formattedLocation,&apos; &apos;))+1)" valuetype="xs:string"/>
															<variable name="tableHeadingText" value="if  (not(sps:isPluralSheetName($locationPrefix)))
then 
if (string-length($cobieRowNameNoPrefix)&gt;0) then
concat(concat(concat(concat(sps:singularizeSheetName($locationPrefix),&apos;[&apos;),$locationSuffix),&apos;]:  &apos;),$cobieRowNameNoPrefix)
else
concat(concat(concat(sps:singularizeSheetName($locationPrefix),&apos;[&apos;),$locationSuffix),&apos;]&apos;)
else 
concat(sps:singularizeSheetName($locationPrefix),&apos;[*]&apos;)" valuetype="xs:string"/>
															<variable name="lastRuleFired" value="preceding-sibling::svrl:fired-rule[1]/@id" valuetype="xs:string"/>
														</variables>
													</template>
												</children>
											</level>
											<text fixtext="  "/>
											<line/>
										</children>
										<variables>
											<variable name="ruleGroupName" value="string(current-grouping-key())" valuetype="xs:string"/>
											<variable name="isWorksheet" value="string-length($ruleGroupName)-string-length(translate($ruleGroupName,&apos;.&apos;,&apos;&apos;))=1" valuetype="xs:boolean"/>
											<variable name="errorCount" value="count(distinct-values(current-group()[not(sps:isAssertWarning(@id))]/@location))" valuetype="xs:integer"/>
											<variable name="warningCount" value="count(distinct-values(current-group()[sps:isAssertWarning(@id)]/@location))" valuetype="xs:integer"/>
										</variables>
									</template>
								</children>
							</level>
						</children>
						<variables>
							<variable name="errorRules" value="svrl:fired-rule[@role=&apos;WorksheetErrors&apos;]" valuetype="&lt;auto&gt;"/>
							<variable name="failedAssertions" value="svrl:failed-assert[preceding-sibling::svrl:fired-rule/@role=&apos;WorksheetErrors&apos;]" valuetype="&lt;auto&gt;"/>
							<variable name="errorRoleReports" value="svrl:successful-report[preceding-sibling::svrl:fired-rule/@role=&apos;WorksheetErrors&apos;]" valuetype="&lt;auto&gt;"/>
							<variable name="errorRoleContent" value="$errorRoleReports |
$failedAssertions" valuetype="&lt;auto&gt;"/>
						</variables>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
	<xpath-functions>
		<xpath-function name="COBieLocationHeading" value="replace(replace(string(tokenize($cobiePathString,&apos;/&apos;)[last()]),&apos;\[&apos;,&apos; &apos;),&apos;\]&apos;,&apos;&apos;)" valuetype="xs:string"/>
		<xpath-function-name>
			<variable name="cobiePathString" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
	<xpath-functions>
		<xpath-function name="singularizeSheetName" value="replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace($sheetNameString,&apos;Facilities&apos;,&apos;Facility&apos;),&apos;Contacts&apos;,&apos;Contact&apos;),&apos;Floors&apos;,&apos;Floor&apos;),&apos;Spaces&apos;,&apos;Space&apos;),&apos;Zones&apos;,&apos;Zone&apos;),&apos;Types&apos;,&apos;Type&apos;),&apos;Components&apos;,&apos;Component&apos;),&apos;Attributes&apos;,&apos;Attribute&apos;),&apos;Systems&apos;,&apos;System&apos;),&apos;Assemblies&apos;,&apos;Assembly&apos;),&apos;Documents&apos;,&apos;Document&apos;),&apos;Connections&apos;,&apos;Connection&apos;),&apos;Spares&apos;,&apos;Spare&apos;),&apos;Jobs&apos;,&apos;Job&apos;),&apos;Resources&apos;,&apos;Resource&apos;),&apos;Coordinates&apos;,&apos;Coordinate&apos;),&apos;Issues&apos;,&apos;Issue&apos;),&apos;Impacts&apos;,&apos;Impact&apos;)" valuetype="xs:string"/>
		<xpath-function-name>
			<variable name="sheetNameString" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
	<xpath-functions>
		<xpath-function name="isPluralSheetName" value="if ( $sheetName=&apos;Contacts&apos;) 
then true()
else
if($sheetName=&apos;Facilities&apos;)
then true()
else
if ($sheetName=&apos;Floors&apos;)
then true()
else
if($sheetName=&apos;Spaces&apos;)
then true()
else
if($sheetName=&apos;Zones&apos;)
then true()
else
if($sheetName=&apos;Types&apos;)
then true()
else
if($sheetName=&apos;Components&apos;)
then true()
else
if($sheetName=&apos;Systems&apos;)
then true()
else
if($sheetName=&apos;Assemblies&apos;)
then true()
else if($sheetName=&apos;Documents&apos;)
then true()
else
if($sheetName=&apos;Resources&apos;)
then true()
else
if($sheetName=&apos;Jobs&apos;)
then true()
else
if($sheetName=&apos;Impacts&apos;)
then true()
else
if($sheetName=&apos;Issues&apos;)
then true()
else
if ($sheetName=&apos;Connections&apos;)
then true()
else
if ($sheetName=&apos;Coordinates&apos;)
then true()
else
if ($sheetName=&apos;Spares&apos;)
then true()
else
if($sheetName=&apos;Attributes&apos;)
then true()
else
false()" valuetype="xs:boolean"/>
		<xpath-function-name>
			<variable name="sheetName" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
	<xpath-functions>
		<xpath-function name="isAssertWarning" value="ends-with($id,&apos;Warning&apos;)" valuetype="xs:boolean"/>
		<xpath-function-name>
			<variable name="id" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
</structure>
