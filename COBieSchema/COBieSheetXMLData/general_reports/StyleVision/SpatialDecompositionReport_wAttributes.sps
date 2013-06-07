<?xml version="1.0" encoding="UTF-8"?>
<structure version="13" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="0" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="cb" uri="cobielite.cobie.bimserver.org"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="COBIE_lite.xsd" workingxmlfile="DuplexMerged.xml"/>
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
					<newline/>
					<template subtype="source" match="XML">
						<children>
							<paragraph paragraphtag="h1">
								<children>
									<text fixtext="COBie Spatial Decomposition Report"/>
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
									<text fixtext="This report provides a spatial decomposition of the model from facility, floor, zone, and spaces."/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<styles text-align="left"/>
								<children>
									<paragraph paragraphtag="h2">
										<children>
											<text fixtext="Model Information"/>
										</children>
									</paragraph>
									<paragraph paragraphtag="p">
										<styles text-align="left"/>
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
										<styles text-align="left"/>
										<children>
											<text fixtext="Project Name:  "/>
											<template subtype="uservariable" match="$projectName">
												<children>
													<text fixtext=" "/>
													<content/>
												</children>
												<variables/>
											</template>
										</children>
									</paragraph>
									<paragraph paragraphtag="p">
										<styles text-align="left"/>
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
													<ref name="FloorLevel" createhyperlink="1">
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
														<styles padding-left="50px"/>
														<children>
															<ref name="SpaceLevel" createhyperlink="1">
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
							<newline/>
							<line/>
							<template subtype="element" match="cb:COBIE">
								<children>
									<template subtype="element" match="Facilities">
										<children>
											<template subtype="element" filter="1" match="Facility">
												<children>
													<paragraph>
														<children>
															<paragraph paragraphtag="h1">
																<children>
																	<template subtype="uservariable" match="$facilityHeading">
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
																							<text fixtext="LinearUnits"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="LinearUnits">
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
																							<text fixtext="AreaUnits"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="AreaUnits">
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
																							<text fixtext="VolumeUnits"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="VolumeUnits">
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
																							<text fixtext="CurrencyUnits"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="CurrencyUnits">
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
																							<text fixtext="AreaMeasurement"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="AreaMeasurement">
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
																							<text fixtext="ExternalSystem"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalSystem">
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
																							<text fixtext="ExternalProjectObject"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalProjectObject">
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
																							<text fixtext="ExternalProjectIdentifier"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalProjectIdentifier">
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
																							<text fixtext="ExternalSiteObject"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalSiteObject">
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
																							<text fixtext="ExternalSiteIdentifier"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalSiteIdentifier">
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
																							<text fixtext="ExternalFacilityObject"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalFacilityObject">
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
																							<text fixtext="ExternalFacilityIdentifier"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ExternalFacilityIdentifier">
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
																							<text fixtext="ProjectDescription"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ProjectDescription">
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
																							<text fixtext="SiteDescription"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="SiteDescription">
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
																							<text fixtext="Phase"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="Phase">
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
													</paragraph>
													<template subtype="userdefined" match="..">
														<children>
															<template subtype="userdefined" match="..">
																<children>
																	<template subtype="element" match="Floors">
																		<children>
																			<template subtype="element" levelflag="1" match="Floor">
																				<children>
																					<paragraph>
																						<children>
																							<paragraph paragraphtag="h2">
																								<children>
																									<text fixtext=" "/>
																									<marker name="FloorLevel">
																										<children>
																											<text fixtext=" "/>
																											<template subtype="uservariable" match="$floorHeadingText">
																												<children>
																													<num-lvl format="1.1.1"/>
																													<text fixtext=" "/>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</marker>
																								</children>
																							</paragraph>
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
																													<text fixtext="Category"/>
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
																													<text fixtext="Description"/>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<text fixtext="Elevation"/>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<text fixtext="Height"/>
																												</children>
																											</tgridcell>
																										</children>
																									</tgridrow>
																								</children>
																							</tgridheader-rows>
																							<tgridbody-rows>
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
																													<template subtype="element" match="Category">
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
																													<template subtype="element" match="Elevation">
																														<children>
																															<content/>
																														</children>
																														<variables/>
																													</template>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<template subtype="element" match="Height">
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
																						<styles padding-left="25px"/>
																						<children>
																							<template subtype="source" match="XML">
																								<children>
																									<template subtype="element" match="cb:COBIE">
																										<children>
																											<template subtype="element" match="Spaces">
																												<children>
																													<template subtype="element" levelflag="1" filter="FloorName=$currentFloorName" match="Space">
																														<children>
																															<marker name="SpaceLevel">
																																<children>
																																	<text fixtext=" "/>
																																	<template subtype="uservariable" match="$spaceHeading">
																																		<children>
																																			<paragraph paragraphtag="h3">
																																				<children>
																																					<num-lvl format="1.1.1"/>
																																					<text fixtext=" "/>
																																					<content/>
																																				</children>
																																			</paragraph>
																																		</children>
																																		<variables/>
																																	</template>
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
																																							<text fixtext="Category"/>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="FloorName"/>
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
																																							<text fixtext="RoomTag"/>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="UsableHeight"/>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="GrossArea"/>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="NetArea"/>
																																						</children>
																																					</tgridcell>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
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
																																							<template subtype="element" match="Category">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
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
																																							<template subtype="element" match="RoomTag">
																																								<children>
																																									<content/>
																																								</children>
																																								<variables/>
																																							</template>
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
																															<template subtype="source" match="XML">
																																<children>
																																	<template subtype="element" match="cb:COBIE">
																																		<children>
																																			<template subtype="element" match="Attributes">
																																				<children>
																																					<template subtype="element" filter="lower-case(SheetName)=&apos;space&apos; and RowName=$spaceName" match="Attribute">
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
																																															<text fixtext="Value"/>
																																														</children>
																																													</tgridcell>
																																													<tgridcell>
																																														<children>
																																															<template subtype="element" match="Value">
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
																																															<text fixtext="Unit"/>
																																														</children>
																																													</tgridcell>
																																													<tgridcell>
																																														<children>
																																															<template subtype="element" match="Unit">
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
																																											<tgridrow>
																																												<children>
																																													<tgridcell>
																																														<children>
																																															<text fixtext="AllowedValues"/>
																																														</children>
																																													</tgridcell>
																																													<tgridcell>
																																														<children>
																																															<template subtype="element" match="AllowedValues">
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
																														<variables>
																															<variable name="spaceHeading" value="concat(&apos;Space:  &apos;,@Name)" valuetype="xs:string"/>
																															<variable name="spaceName" value="@Name" valuetype="xs:string"/>
																														</variables>
																													</template>
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
																				</children>
																				<variables>
																					<variable name="floorHeadingText" value="concat(&apos;Floor: &apos;,@Name)" valuetype="xs:string"/>
																					<variable name="currentFloorName" value="@Name" valuetype="xs:string"/>
																				</variables>
																			</template>
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
													<variable name="facilityHeading" value="concat(&apos;Facility[1]:  Project:  &apos;,ProjectName,&apos;, Site:  &apos;,SiteName,&apos;, Building:  &apos;,@Name)" valuetype="xs:string"/>
												</variables>
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
					<newline/>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
