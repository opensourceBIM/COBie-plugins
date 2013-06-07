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
		<rule url="SpaceReport.css">
			<media>
				<media value="all"/>
			</media>
		</rule>
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
							<text fixtext="COBie QC report - Design Deliverable"/>
						</children>
					</paragraph>
					<paragraph>
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
					<paragraph paragraphtag="p">
						<styles text-align="left"/>
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
											<ref name="RuleGroupBookmark" createhyperlink="1">
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
												<styles padding-left="25px"/>
												<children>
													<ref name="ErrorLocationBookmark" createhyperlink="1">
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
					<paragraph>
						<children>
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
							<paragraph paragraphtag="h1">
								<children>
									<text fixtext="Worksheet Counts"/>
								</children>
							</paragraph>
							<template subtype="element" match="svrl:successful-report">
								<children>
									<list>
										<children>
											<listrow>
												<children>
													<paragraph paragraphtag="p">
														<styles text-align="left"/>
														<children>
															<template subtype="element" match="svrl:text">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</paragraph>
												</children>
											</listrow>
										</children>
									</list>
								</children>
								<variables/>
							</template>
							<line/>
							<template subtype="element" levelflag="1" groupingtype="group-by" groupingmatch="preceding-sibling::svrl:fired-rule[1]/@id" match="svrl:failed-assert">
								<children>
									<marker name="RuleGroupBookmark">
										<children>
											<text fixtext=" "/>
											<paragraph paragraphtag="h2">
												<children>
													<template subtype="uservariable" match="$ruleGroupName">
														<children>
															<num-lvl format="1.1.1"/>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
									</marker>
									<template subtype="userdefined" groupingtype="group-by" groupingmatch="@location" levelflag="1" match="current-group()">
										<children>
											<paragraph paragraphtag="h3">
												<children>
													<marker name="ErrorLocationBookmark">
														<children>
															<num-lvl format="1.1.1"/>
															<text fixtext=" ">
																<styles padding-left="25px"/>
															</text>
															<template subtype="uservariable" match="$tableHeadingText">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</marker>
												</children>
											</paragraph>
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
																			<text fixtext="id">
																				<styles padding-left="25px"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<text fixtext="text">
																				<styles padding-left="25px"/>
																			</text>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridheader-rows>
													<tgridbody-rows>
														<children>
															<template subtype="userdefined" match="current-group()">
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<template subtype="attribute" match="id">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
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
													</tgridbody-rows>
												</children>
											</tgrid>
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
													<fixtext value="#TOP"/>
												</hyperlink>
											</link>
										</children>
										<variables>
											<variable name="formattedLocation" value="sps:COBieLocationHeading( @location )" valuetype="xs:string"/>
											<variable name="cobieRowName" value="substring-before(svrl:text ,&apos;:&apos; )" valuetype="xs:string"/>
											<variable name="cobieRowNameNoPrefix" value="substring-after($cobieRowName,&apos;.&apos;)" valuetype="xs:string"/>
											<variable name="locationPrefix" value="substring-before($formattedLocation,&apos; &apos;)" valuetype="xs:string"/>
											<variable name="locationSuffix" value="substring-after($formattedLocation,&apos; &apos;)" valuetype="xs:string"/>
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
									<line/>
								</children>
								<variables>
									<variable name="ruleGroupName" value="string(current-grouping-key())" valuetype="xs:string"/>
								</variables>
							</template>
						</children>
						<variables/>
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
		<xpath-function name="singularizeSheetName" value="replace(replace(replace(replace(replace(replace(replace(replace(replace($sheetNameString,&apos;Facilities&apos;,&apos;Facility&apos;),&apos;Contacts&apos;,&apos;Contact&apos;),&apos;Floors&apos;,&apos;Floor&apos;),&apos;Spaces&apos;,&apos;Space&apos;),&apos;Zones&apos;,&apos;Zone&apos;),&apos;Types&apos;,&apos;Type&apos;),&apos;Components&apos;,&apos;Component&apos;),&apos;Attributes&apos;,&apos;Attribute&apos;),&apos;Systems&apos;,&apos;System&apos;)" valuetype="xs:string"/>
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
if($sheetName=&apos;Attributes&apos;)
then true()
else
false()" valuetype="xs:boolean"/>
		<xpath-function-name>
			<variable name="sheetName" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
</structure>
