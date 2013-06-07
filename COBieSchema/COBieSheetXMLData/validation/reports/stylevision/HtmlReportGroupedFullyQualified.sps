<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="XHTML 1.0" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://purl.oclc.org/dsdl/svrl"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="SVRMLExample.xsd" workingxmlfile="SVRMLExample.xml"/>
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
					<paragraph paragraphtag="h1">
						<children>
							<text fixtext="COBie Compliance Verification Report"/>
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
					<paragraph>
						<children>
							<template subtype="source" match="XML">
								<children>
									<calltemplate subtype="element" match="n1:schematron-output"/>
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
			<globaltemplate subtype="element" match="n1:schematron-output" schema-tree-path="$XML/n1:schematron-output">
				<children>
					<template subtype="element" match="n1:schematron-output">
						<children>
							<template subtype="element" groupingtype="group-by" groupingmatch="@location" match="n1:failed-assert">
								<children>
									<paragraph paragraphtag="h3">
										<children>
											<template subtype="uservariable" match="$tableHeadingText">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
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
																	<text fixtext="Error Code"/>
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
																			<template subtype="element" match="n1:text">
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
								<variables>
									<variable name="formattedLocation" value="sps:COBieLocationHeading( @location )" valuetype="xs:string"/>
									<variable name="cobieRowName" value="substring-before(n1:text ,&apos;:&apos; )" valuetype="xs:string"/>
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
