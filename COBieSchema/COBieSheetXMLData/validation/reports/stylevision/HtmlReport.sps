<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
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
							<text fixtext="COBie Validation Report"/>
						</children>
					</paragraph>
					<template subtype="source" match="XML">
						<children>
							<template subtype="userdefined" match="for $XML in distinct-values(n1:schematron-output/n1:failed-assert/string(@location)) return string($XML)">
								<children>
									<calltemplate subtype="named" match="Template1">
										<parameters>
											<parameter name="locationFilter" value="."/>
										</parameters>
									</calltemplate>
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
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="Template1">
				<parameters>
					<parameter name="locationFilter" type="xs:string" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<newline/>
					<paragraph>
						<children>
							<template subtype="source" match="XML">
								<children>
									<paragraph paragraphtag="h3">
										<children>
											<template subtype="uservariable" match="$locationTrimmed">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
										</children>
									</paragraph>
									<template subtype="element" match="n1:schematron-output">
										<children>
											<tgrid add-row-expand-collapse-buttons="1" add-column-close-buttons="1">
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
															<template subtype="element" filter="@location=$locationFilter" match="n1:failed-assert">
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
										<variables/>
									</template>
								</children>
								<variables>
									<variable name="locationTrimmed" value="sps:COBieLocationHeading( $locationFilter )" valuetype="&lt;auto&gt;"/>
								</variables>
							</template>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
	<xpath-functions>
		<xpath-function name="COBieLocationHeading" value="replace(replace(string(tokenize($cobiePathString,&apos;/&apos;)[last()]),&apos;\[&apos;,&apos; &apos;),&apos;\]&apos;,&apos;&apos;)" valuetype="xs:string"/>
		<xpath-function-name>
			<variable name="cobiePathString" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
</structure>
