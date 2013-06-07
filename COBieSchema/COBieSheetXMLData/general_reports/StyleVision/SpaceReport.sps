<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="quirks" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="cb" uri="cobielite.cobie.bimserver.org"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="COBIE_lite.xsd" workingxmlfile="SampleCOBIEliteNSCHange.xml"/>
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
					<template subtype="source" match="XML">
						<children>
							<paragraph paragraphtag="h1">
								<children>
									<text fixtext="COBie Room Data Sheet"/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<styles text-align="left"/>
								<children>
									<autocalc xpath="current-dateTime()">
										<format basic-type="xsd" string="YYYY&apos;-&apos;MM&apos;-&apos;DD&apos;T&apos;hh:mm:ss" datatype="dateTime"/>
									</autocalc>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<styles text-align="left"/>
								<children>
									<text fixtext="This report provides a listing of installed component grouped by space and then by type."/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<styles text-align="left"/>
								<children>
									<paragraph paragraphtag="h2">
										<styles text-align="left"/>
										<children>
											<text fixtext="Model Information"/>
										</children>
									</paragraph>
									<paragraph paragraphtag="p">
										<styles text-align="left"/>
										<children>
											<text fixtext="Facility Name: "/>
											<template subtype="uservariable" match="$facilityName">
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
										<styles text-align="left"/>
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
										<styles text-align="left"/>
										<children>
											<text fixtext="Site Name: "/>
											<template subtype="uservariable" match="$siteName">
												<children>
													<text fixtext=" "/>
													<content/>
												</children>
												<variables/>
											</template>
											<text fixtext=" "/>
										</children>
									</paragraph>
								</children>
							</paragraph>
							<template subtype="element" match="cb:COBIE">
								<children>
									<template subtype="element" match="Components">
										<children>
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
																	<ref name="SpaceBookMark" createhyperlink="1">
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
																		<styles padding-left="20px"/>
																		<children>
																			<ref name="SpaceTypeBookMark" createhyperlink="1">
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
											<template subtype="element" levelflag="1" groupingtype="group-by" groupingmatch="Space" match="Component">
												<children>
													<line/>
													<marker xpath="concat(generate,&apos;Space:  &apos;,current-grouping-key())" name="SpaceBookMark">
														<children>
															<paragraph paragraphtag="h2">
																<children>
																	<template subtype="element" match="Space">
																		<children>
																			<num-lvl format="1.1.1"/>
																			<text fixtext=" Space: "/>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</paragraph>
															<text fixtext=" "/>
														</children>
													</marker>
													<text fixtext=" "/>
													<template subtype="userdefined" match="parent::Components/parent::cb:COBIE">
														<children>
															<template subtype="element" match="Spaces">
																<children>
																	<template subtype="element" filter="@Name=current-grouping-key()" match="Space">
																		<children>
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
																											<text fixtext="FloorName"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="FloorName">
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
																											<text fixtext="RoomTag"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="RoomTag">
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
																											<text fixtext="UsableHeight"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="UsableHeight">
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
																											<text fixtext="GrossArea"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="GrossArea">
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
																											<text fixtext="NetArea"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="NetArea">
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
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
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
														<variables/>
													</template>
													<template subtype="userdefined" groupingtype="group-by" groupingmatch="TypeName" levelflag="1" match="current-group()">
														<sort>
															<key match="current-grouping-key()"/>
														</sort>
														<children>
															<text fixtext=" "/>
															<paragraph>
																<properties id="TypeDiv"/>
																<children>
																	<marker xpath="$currentTypeName" name="SpaceTypeBookMark">
																		<children>
																			<text fixtext=" "/>
																			<paragraph paragraphtag="h3">
																				<children>
																					<num-lvl format="1.1.1"/>
																					<text fixtext=" Space "/>
																					<template subtype="element" match="Space">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																					<text fixtext=", Type:  "/>
																					<template subtype="element" match="TypeName">
																						<children>
																							<content/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</paragraph>
																		</children>
																	</marker>
																</children>
															</paragraph>
															<paragraph>
																<properties id="TypeDiv"/>
																<children>
																	<template subtype="userdefined" match="parent::Components/parent::cb:COBIE">
																		<children>
																			<template subtype="element" match="Types">
																				<children>
																					<template subtype="element" filter="@Name=$currentTypeName" match="Type">
																						<children>
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
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="AssetType"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="AssetType">
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
																															<text fixtext="Manufacturer"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Manufacturer">
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
																															<text fixtext="ModelNumber"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ModelNumber">
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
																															<text fixtext="WarrantyGuarantorParts"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="WarrantyGuarantorParts">
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
																															<text fixtext="WarrantyDurationParts"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="WarrantyDurationParts">
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
																															<text fixtext="WarrantyGuarantorLabor"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="WarrantyGuarantorLabor">
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
																															<text fixtext="WarrantyDurationLabor"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="WarrantyDurationLabor">
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
																															<text fixtext="WarrantyDurationUnit"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="WarrantyDurationUnit">
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
																															<text fixtext="ReplacementCost"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ReplacementCost">
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
																															<text fixtext="ExpectedLife"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ExpectedLife">
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
																															<text fixtext="DurationUnit"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="DurationUnit">
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
																															<text fixtext="WarrantyDescription"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="WarrantyDescription">
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
																															<text fixtext="NominalLength"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="NominalLength">
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
																															<text fixtext="NominalWidth"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="NominalWidth">
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
																															<text fixtext="NominalHeight"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="NominalHeight">
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
																															<text fixtext="ModelReference"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ModelReference">
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
																															<text fixtext="Shape"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Shape">
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
																															<text fixtext="Size"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Size">
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
																															<text fixtext="Color"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Color">
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
																															<text fixtext="Finish"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Finish">
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
																															<text fixtext="Grade"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Grade">
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
																															<text fixtext="Material"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Material">
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
																															<text fixtext="Constituents"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Constituents">
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
																															<text fixtext="Features"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="Features">
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
																															<text fixtext="AccessibilityPerformance"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="AccessibilityPerformance">
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
																															<text fixtext="CodePerformance"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="CodePerformance">
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
																															<text fixtext="SustainabilityPerformance"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="SustainabilityPerformance">
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
																						</children>
																						<variables/>
																					</template>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																	<level>
																		<children>
																			<marker xpath="&apos;Matching Components&apos;" name="SpaceTypeComponentsBookMark" uses="xpath">
																				<children>
																					<text fixtext=" "/>
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
																					<paragraph>
																						<properties id="ComponentDiv"/>
																						<children>
																							<text fixtext=" "/>
																							<paragraph paragraphtag="h4">
																								<children>
																									<text fixtext="Space "/>
																									<template subtype="element" match="Space">
																										<children>
																											<content/>
																										</children>
																										<variables/>
																									</template>
																									<text fixtext=", Type:  "/>
																									<template subtype="element" match="TypeName">
																										<children>
																											<content/>
																										</children>
																										<variables/>
																									</template>
																									<text fixtext=", Matching Components"/>
																								</children>
																							</paragraph>
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
																											<tgridcol/>
																											<tgridcol/>
																											<tgridcol/>
																											<tgridcol/>
																											<tgridcol/>
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
																															<text fixtext="Name"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="CreatedBy"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="CreatedOn"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="TypeName"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="Space"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="Description"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="ExtSystem"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="ExtObject"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="ExtIdentifier"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="SerialNumber"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="InstallationDate"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="WarrantyStartDate"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="TagNumber"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="BarCode"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<text fixtext="AssetIdentifier"/>
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
																																	<template subtype="attribute" match="Name">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
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
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="TypeName">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="Space">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
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
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="SerialNumber">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="InstallationDate">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="WarrantyStartDate">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="TagNumber">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="BarCode">
																																		<children>
																																			<content/>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="AssetIdentifier">
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
																				</children>
																			</marker>
																		</children>
																	</level>
																</children>
															</paragraph>
														</children>
														<variables>
															<variable name="currentTypeName" value="TypeName" valuetype="xs:string"/>
														</variables>
													</template>
													<newline/>
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
