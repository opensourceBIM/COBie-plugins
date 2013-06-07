<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="cb" uri="cobielite.cobie.bimserver.org"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="COBIE_lite.xsd" workingxmlfile="SampleCOBIEliteClinic.xml"/>
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
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<paragraph paragraphtag="h1">
								<children>
									<text fixtext="COBie Zone Report"/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<children>
									<autocalc xpath="current-dateTime()">
										<format basic-type="xsd" string="YYYY&apos;-&apos;MM&apos;-&apos;DD&apos;T&apos;hh:mm:ss" datatype="dateTime"/>
									</autocalc>
								</children>
							</paragraph>
							<paragraph paragraphtag="h2">
								<children>
									<text fixtext="Model Information"/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<children>
									<text fixtext="Facility Name:  "/>
									<template subtype="uservariable" match="$facilityName">
										<children>
											<text fixtext=" "/>
											<content/>
										</children>
										<variables/>
									</template>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<children>
									<text fixtext="Project Name: "/>
									<template subtype="uservariable" match="$projectName">
										<children>
											<text fixtext=" "/>
											<content/>
										</children>
										<variables/>
									</template>
									<text fixtext=" "/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<children>
									<text fixtext="Site Name:  "/>
									<template subtype="uservariable" match="$siteName">
										<children>
											<text fixtext=" "/>
											<content/>
										</children>
										<variables/>
									</template>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<children>
									<paragraph paragraphtag="h3">
										<children>
											<text fixtext="Description"/>
										</children>
									</paragraph>
									<text fixtext="This report provides a listing of zones contained in the model"/>
								</children>
							</paragraph>
							<line/>
							<template subtype="element" match="cb:COBIE">
								<children>
									<template subtype="element" match="Zones">
										<children>
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
																	<ref name="ZoneBookMark" createhyperlink="1">
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
											</toc>
											<line/>
											<template subtype="element" levelflag="1" filter="not(./@Name=preceding-sibling::Zone/@Name)" match="Zone">
												<children>
													<paragraph paragraphtag="h2">
														<children>
															<marker xpath="concat(concat(position(),&apos; &apos;),@Name)" name="ZoneBookMark" uses="xpath">
																<children>
																	<num-lvl format="1.1.1"/>
																	<text fixtext=" "/>
																	<template subtype="attribute" match="Name">
																		<children>
																			<text fixtext=" "/>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</marker>
														</children>
													</paragraph>
													<paragraph paragraphtag="p">
														<children>
															<template subtype="userdefined" match="parent::Zones/parent::cb:COBIE">
																<children>
																	<template subtype="element" match="Zones">
																		<children>
																			<paragraph paragraphtag="h3">
																				<children>
																					<text fixtext="Spaces"/>
																				</children>
																			</paragraph>
																			<template subtype="element" filter="@Name=$CurrentZoneName" match="Zone">
																				<children>
																					<template subtype="element" filter="not(text()=preceding-sibling::element()/SpaceNames)" match="SpaceNames">
																						<children>
																							<content/>
																						</children>
																						<variables>
																							<variable name="currentSpaceNames" value="./text()" valuetype="xs:string"/>
																							<variable name="thisPosition" value="position()" valuetype="&lt;auto&gt;"/>
																						</variables>
																					</template>
																					<condition>
																						<children>
																							<conditionbranch xpath="not(position()=last())">
																								<children>
																									<text fixtext=","/>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																					<condition>
																						<children>
																							<conditionbranch xpath="position() mod 10 = 0">
																								<children>
																									<paragraph paragraphtag="p"/>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
														</children>
													</paragraph>
													<newline/>
													<tgrid>
														<properties border="1"/>
														<children>
															<tgridheader-cols>
																<children>
																	<tgridcol/>
																</children>
															</tgridheader-cols>
															<tgridbody-cols>
																<children>
																	<tgridcol/>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Name"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="attribute" match="Name">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="CreatedBy"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="CreatedBy">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="CreatedOn"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="CreatedOn">
																						<children>
																							<content>
																								<format basic-type="xsd" datatype="dateTime"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Category"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Category">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="ExtSystem"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="ExtSystem">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="ExtObject"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="ExtObject">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="ExtIdentifier"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="ExtIdentifier">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Description"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Description">
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
															</tgridbody-rows>
														</children>
													</tgrid>
													<paragraph paragraphtag="p">
														<children>
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
													</paragraph>
													<line/>
												</children>
												<variables>
													<variable name="CurrentZoneName" value="./@Name" valuetype="xs:string"/>
												</variables>
											</template>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<newline/>
						</children>
						<variables>
							<variable name="facilityName" value="cb:COBIE/Facilities[1]/Facility[1]/@Name" valuetype="&lt;auto&gt;"/>
							<variable name="projectName" value="cb:COBIE/Facilities[1]/Facility[1]/ProjectName" valuetype="&lt;auto&gt;"/>
							<variable name="siteName" value="cb:COBIE/Facilities[1]/Facility[1]/SiteName" valuetype="&lt;auto&gt;"/>
						</variables>
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
