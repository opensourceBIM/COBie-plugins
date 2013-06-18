<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*XML" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://www.altova.com/documentation"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="C:\Users\RDITLACB\Documents\Altova\XMLSpy2011\Documentation\Schema\SchemaDocumentation.xsd" workingxmlfile="C:\Users\RDITLACB\Documents\Altova\XMLSpy2011\Documentation\Schema\SampleData\Sample.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<mainparts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
		<xpath-functions/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="2" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles>
		<rules selector=".elementHeader">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="10pt"/>
		</rules>
		<rules selector=".elementHeader2">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="10pt" font-weight="bold"/>
		</rules>
		<rules selector=".schemaHeader">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="11pt"/>
		</rules>
		<rules selector=".schemaHeader2">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="11pt" font-weight="bold"/>
		</rules>
		<rules selector=".schemaName">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="8pt" font-weight="bold"/>
		</rules>
		<rules selector=".schemaSubData">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="8pt"/>
		</rules>
		<rules selector=".schemaSubTitle">
			<media>
				<media value="all"/>
			</media>
			<rule color="black" font-family="Arial" font-size="8pt" font-style="italic"/>
		</rules>
		<rules selector=".table-border">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom-color="#ACA899" border-left-color="#ECE9D8" border-right-color="#ACA899" border-style="solid" border-top-color="#ECE9D8" border-width="1px"/>
		</rules>
		<rules selector=".table-no-border">
			<media>
				<media value="all"/>
			</media>
			<rule/>
		</rules>
		<rules selector=".td-border">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom-color="#ECE9D8" border-left-color="#ACA899" border-right-color="#ECE9D8" border-style="solid" border-top-color="#ACA899" border-width="1px"/>
		</rules>
		<rules selector=".textOperator">
			<media>
				<media value="all"/>
			</media>
			<rule color="#0000FF" font-family="Arial" font-size="10pt"/>
		</rules>
		<rules selector=".textElement">
			<media>
				<media value="all"/>
			</media>
			<rule color="#800000" font-family="Arial" font-size="10pt"/>
		</rules>
		<rules selector=".textAttr">
			<media>
				<media value="all"/>
			</media>
			<rule color="#FF0000" font-family="Arial" font-size="10pt"/>
		</rules>
		<rules selector=".textContents">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Arial" font-size="10pt"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties _xtitle="$XML/n1:SchemaDocumentation/n1:Document/@title"/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
						<children>
							<globaltemplate subtype="pagelayout" match="footerall">
								<children>
									<calltemplate subtype="named" match="Footer">
										<parameters/>
									</calltemplate>
								</children>
							</globaltemplate>
							<globaltemplate subtype="pdf-bookmarktree" match="pdf-bookmarktree">
								<children>
									<template subtype="source" match="XML">
										<children>
											<template subtype="element" match="n1:SchemaDocumentation">
												<children>
													<template subtype="element" match="n1:SchemaDocument">
														<children>
															<pdf-bookmark>
																<children>
																	<link>
																		<children>
																			<autocalc xpath="tokenize(@schemaLocation,&apos;\\&apos;)[last()]"/>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#"/>
																			<xpath value="@schemaLocation"/>
																		</hyperlink>
																	</link>
																	<template subtype="userdefined" match="element()">
																		<children>
																			<pdf-bookmark starting-state="hide">
																				<children>
																					<link>
																						<children>
																							<template subtype="attribute" match="name">
																								<children>
																									<content subtype="regular"/>
																								</children>
																								<variables/>
																							</template>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<hyperlink>
																							<fixtext value="#"/>
																							<xpath value="@id"/>
																						</hyperlink>
																					</link>
																					<template subtype="userdefined" match="descendant::n1:Attribute | descendant::n1:Element">
																						<children>
																							<pdf-bookmark>
																								<children>
																									<link>
																										<children>
																											<template subtype="attribute" match="name">
																												<children>
																													<content subtype="regular"/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																										<action>
																											<none/>
																										</action>
																										<hyperlink>
																											<fixtext value="#"/>
																											<xpath value="@id"/>
																										</hyperlink>
																									</link>
																								</children>
																							</pdf-bookmark>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</pdf-bookmark>
																		</children>
																		<variables/>
																	</template>
																</children>
															</pdf-bookmark>
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
							</globaltemplate>
						</children>
						<watermark>
							<image transparency="50" fill-page="1" center-if-not-fill="1"/>
							<text transparency="50"/>
						</watermark>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="n1:SchemaDocumentation">
								<children>
									<template subtype="element" match="n1:Document">
										<children>
											<template subtype="attribute" match="title">
												<children>
													<paragraph>
														<children>
															<bookmark>
																<children>
																	<text fixtext="Schema ">
																		<properties class="schemaHeader"/>
																	</text>
																	<content subtype="regular">
																		<properties class="schemaHeader2"/>
																	</content>
																</children>
																<action>
																	<none/>
																</action>
																<bookmark>
																	<fixtext value="toc"/>
																</bookmark>
															</bookmark>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<newline/>
									<template subtype="element" match="n1:SchemaDocument">
										<children>
											<tgrid hiderows="when-body-empty">
												<properties cellpadding="2" cellspacing="0"/>
												<children>
													<tgridheader-cols>
														<children>
															<tgridcol>
																<properties class="schemaSubTitle"/>
																<styles width="3cm"/>
															</tgridcol>
														</children>
													</tgridheader-cols>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<properties class="schemaName"/>
																<styles width="15cm"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="schema location:">
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<bookmark>
																				<children>
																					<link>
																						<children>
																							<template subtype="attribute" match="schemaLocation">
																								<children>
																									<content subtype="regular">
																										<properties class="schemaName"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<hyperlink>
																							<xpath value="@href"/>
																						</hyperlink>
																					</link>
																				</children>
																				<action>
																					<none/>
																				</action>
																				<bookmark>
																					<xpath value="@schemaLocation"/>
																				</bookmark>
																			</bookmark>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="attribute form default:">
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="attributeFormDefault">
																				<children>
																					<content subtype="regular">
																						<properties class="schemaName"/>
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
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="element form default:">
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="elementFormDefault">
																				<children>
																					<content subtype="regular">
																						<properties class="schemaName"/>
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
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="block default:">
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="blockDefault">
																				<children>
																					<content subtype="regular">
																						<properties class="schemaName"/>
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
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="final default:">
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="finalDefault">
																				<children>
																					<content subtype="regular">
																						<properties class="schemaName"/>
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
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="targetNamespace:">
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="targetNamespace">
																				<children>
																					<content subtype="regular">
																						<properties class="schemaName"/>
																					</content>
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
											<newline/>
											<tgrid hidecols="when-body-empty">
												<properties cellpadding="2" cellspacing="0" class="table-no-border"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<styles background-color="#F0F0F0"/>
															</tgridcol>
															<tgridcol>
																<styles background-color="#E6E8F2"/>
															</tgridcol>
															<tgridcol>
																<styles background-color="#C9CDE0"/>
															</tgridcol>
															<tgridcol>
																<styles background-color="#BAC0E0"/>
															</tgridcol>
															<tgridcol>
																<styles background-color="#FFD9CC"/>
															</tgridcol>
															<tgridcol>
																<styles background-color="#FFC6B2"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridheader-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<children>
																			<text fixtext="Elements">
																				<properties class="schemaSubTitle"/>
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="Groups">
																				<properties class="schemaSubTitle"/>
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<children>
																			<text fixtext="Complex types">
																				<properties class="schemaSubTitle"/>
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<children>
																			<text fixtext="Simple types">
																				<properties class="schemaSubTitle"/>
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<children>
																			<text fixtext="Attributes">
																				<properties class="schemaSubTitle"/>
																				<styles font-weight="normal"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="Attribute Groups">
																				<properties class="schemaSubTitle"/>
																				<styles font-weight="normal"/>
																			</text>
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
																		<properties align="left" valign="top"/>
																		<styles vertical-align="top"/>
																		<children>
																			<template subtype="element" match="n1:Element">
																				<children>
																					<calltemplate subtype="named" match="BookmarkItem">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<children>
																			<template subtype="element" match="n1:Group">
																				<children>
																					<calltemplate subtype="named" match="BookmarkItem">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<styles vertical-align="top"/>
																		<children>
																			<template subtype="element" match="n1:ComplexType">
																				<children>
																					<calltemplate subtype="named" match="BookmarkItem">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<styles vertical-align="top"/>
																		<children>
																			<template subtype="element" match="n1:SimpleType">
																				<children>
																					<calltemplate subtype="named" match="BookmarkItem">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<styles vertical-align="top"/>
																		<children>
																			<template subtype="element" match="n1:Attribute">
																				<children>
																					<calltemplate subtype="named" match="BookmarkItem">
																						<parameters/>
																					</calltemplate>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="left" valign="top"/>
																		<children>
																			<template subtype="element" match="n1:AttributeGroup">
																				<children>
																					<calltemplate subtype="named" match="BookmarkItem">
																						<parameters/>
																					</calltemplate>
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
											<newline/>
											<newline/>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:SchemaDocument">
										<children>
											<template subtype="userdefined" match="element()">
												<children>
													<condition>
														<children>
															<conditionbranch xpath="@newFile">
																<children>
																	<resultdocument _xurl="@newFile">
																		<children>
																			<documentsection>
																				<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
																				<children>
																					<globaltemplate subtype="pagelayout" match="footerall">
																						<children>
																							<calltemplate subtype="named" match="Footer">
																								<parameters/>
																							</calltemplate>
																						</children>
																					</globaltemplate>
																					<globaltemplate subtype="pdf-bookmarktree" match="pdf-bookmarktree">
																						<children>
																							<pdf-bookmark>
																								<children>
																									<link>
																										<children>
																											<template subtype="attribute" match="name">
																												<children>
																													<content subtype="regular"/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																										<action>
																											<none/>
																										</action>
																										<hyperlink>
																											<fixtext value="#"/>
																											<xpath value="@id"/>
																										</hyperlink>
																									</link>
																									<template subtype="userdefined" match="descendant::n1:Attribute | descendant::n1:Element">
																										<children>
																											<pdf-bookmark>
																												<children>
																													<link>
																														<children>
																															<template subtype="attribute" match="name">
																																<children>
																																	<content subtype="regular"/>
																																</children>
																																<variables/>
																															</template>
																														</children>
																														<action>
																															<none/>
																														</action>
																														<hyperlink>
																															<fixtext value="#"/>
																															<xpath value="@id"/>
																														</hyperlink>
																													</link>
																												</children>
																											</pdf-bookmark>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</pdf-bookmark>
																						</children>
																					</globaltemplate>
																				</children>
																				<watermark>
																					<image transparency="50" fill-page="1" center-if-not-fill="1"/>
																					<text transparency="50"/>
																				</watermark>
																			</documentsection>
																			<calltemplate subtype="userdefined" match="current()"/>
																			<paragraph>
																				<children>
																					<link>
																						<children>
																							<text fixtext="Back to TOC">
																								<properties class="schemaName"/>
																								<styles font-style="italic"/>
																							</text>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<hyperlink>
																							<fixtext value="#toc"/>
																						</hyperlink>
																					</link>
																				</children>
																			</paragraph>
																			<newline/>
																			<condition>
																				<children>
																					<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
																						<children>
																							<calltemplate subtype="named" match="Footer">
																								<parameters/>
																							</calltemplate>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																		<document-properties _xtitle="concat($XML/n1:SchemaDocumentation/n1:Document/@title,&apos; - &apos;,@name)"/>
																	</resultdocument>
																</children>
															</conditionbranch>
															<conditionbranch>
																<children>
																	<calltemplate subtype="userdefined" match="current()"/>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
												<variables/>
											</template>
											<newline/>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
										<children>
											<calltemplate subtype="named" match="Footer">
												<parameters/>
											</calltemplate>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="n1:Attribute" schema-tree-path="$XML/n1:Documentation/n1:SchemaDocument/n1:Attribute">
				<children>
					<template subtype="element" match="n1:Attribute">
						<children>
							<calltemplate subtype="named" match="SchemaItem">
								<parameters>
									<parameter name="type" value="&apos;attribute&apos;"/>
									<parameter name="backgroundColor" value="&apos;#FFD9CC&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Element" schema-tree-path="$XML/n1:Documentation/n1:SchemaDocument/n1:Element">
				<children>
					<template subtype="element" match="n1:Element">
						<children>
							<calltemplate subtype="named" match="SchemaItem">
								<parameters>
									<parameter name="type" value="&apos;element&apos;"/>
									<parameter name="backgroundColor" value="&apos;#F0F0F0&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:ComplexType" schema-tree-path="$XML/n1:Documentation/n1:SchemaDocument/n1:ComplexType">
				<children>
					<template subtype="element" match="n1:ComplexType">
						<children>
							<calltemplate subtype="named" match="SchemaItem">
								<parameters>
									<parameter name="type" value="&apos;complexType&apos;"/>
									<parameter name="backgroundColor" value="&apos;#C9CDE0&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:SimpleType" schema-tree-path="$XML/n1:Documentation/n1:SchemaDocument/n1:SimpleType">
				<children>
					<template subtype="element" match="n1:SimpleType">
						<children>
							<calltemplate subtype="named" match="SchemaItem">
								<parameters>
									<parameter name="type" value="&apos;simpleType&apos;"/>
									<parameter name="backgroundColor" value="&apos;#BAC0E0&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Reference" schema-tree-path="$XML/n1:Attribute/n1:Type/n1:Reference">
				<children>
					<template subtype="element" match="n1:Reference">
						<children>
							<calltemplate subtype="named" match="RefContent1">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Restriction" schema-tree-path="n1:Restriction">
				<children>
					<template subtype="element" match="n1:Restriction">
						<children>
							<text fixtext="restriction of ">
								<properties class="schemaSubData"/>
							</text>
							<content subtype="regular"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Extension" schema-tree-path="n1:Type/n1:Extension">
				<children>
					<template subtype="element" match="n1:Extension">
						<children>
							<text fixtext="extension of ">
								<properties class="schemaSubData"/>
							</text>
							<content subtype="regular"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:List" schema-tree-path="n1:List">
				<children>
					<template subtype="element" match="n1:List">
						<children>
							<text fixtext="list of ">
								<properties class="schemaSubData"/>
							</text>
							<content subtype="regular"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Union" schema-tree-path="n1:Union">
				<children>
					<template subtype="element" match="n1:Union">
						<children>
							<text fixtext="union of ">
								<properties class="schemaSubData"/>
							</text>
							<content subtype="regular"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Group" schema-tree-path="$XML/n1:Documentation/n1:SchemaDocument/n1:Group">
				<children>
					<template subtype="element" match="n1:Group">
						<children>
							<calltemplate subtype="named" match="SchemaItem">
								<parameters>
									<parameter name="type" value="&apos;group&apos;"/>
									<parameter name="backgroundColor" value="&apos;#E6E8F2&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:AttributeGroup" schema-tree-path="$XML/n1:Documentation/n1:SchemaDocument/n1:AttributeGroup">
				<children>
					<template subtype="element" match="n1:AttributeGroup">
						<children>
							<calltemplate subtype="named" match="SchemaItem">
								<parameters>
									<parameter name="type" value="&apos;attributeGroup&apos;"/>
									<parameter name="backgroundColor" value="&apos;#FFC6B2&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="XMLSource">
				<parameters>
					<parameter name="InMixed" type="xs:boolean" occurrence="none-or-one" default-value="false()"/>
				</parameters>
				<children>
					<text fixtext="&lt;">
						<properties class="textOperator"/>
					</text>
					<autocalc xpath="name()">
						<properties class="textElement"/>
					</autocalc>
					<template subtype="userdefined" match="@*">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="not(starts-with(name(),&apos;xsi:&apos;))">
										<children>
											<text fixtext="  ">
												<styles font-size="smaller"/>
											</text>
											<autocalc xpath="./name()">
												<properties class="textAttr"/>
											</autocalc>
											<text fixtext="=&quot;">
												<properties class="textOperator"/>
											</text>
											<content subtype="regular">
												<properties class="textContents"/>
											</content>
											<text fixtext="&quot;">
												<properties class="textOperator"/>
											</text>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
					<condition>
						<children>
							<conditionbranch xpath="( exists(*) and exists(text()) ) or $InMixed">
								<children>
									<text fixtext="&gt;">
										<properties class="textOperator"/>
									</text>
									<template subtype="userdefined" match="* | text()">
										<children>
											<condition>
												<children>
													<conditionbranch xpath=".instance of element()">
														<children>
															<calltemplate subtype="named" match="XMLSource">
																<parameters>
																	<parameter name="InMixed" value="true()"/>
																</parameters>
															</calltemplate>
														</children>
													</conditionbranch>
													<conditionbranch>
														<children>
															<content subtype="regular">
																<properties class="textContents"/>
															</content>
														</children>
													</conditionbranch>
												</children>
											</condition>
										</children>
										<variables/>
									</template>
									<text fixtext="&lt;">
										<properties class="textOperator"/>
									</text>
									<text fixtext="/"/>
									<autocalc xpath="./name()">
										<properties class="textElement"/>
									</autocalc>
									<text fixtext="&gt;">
										<properties class="textOperator"/>
									</text>
								</children>
							</conditionbranch>
							<conditionbranch xpath="exists(*)">
								<children>
									<text fixtext="&gt;">
										<properties class="textOperator"/>
									</text>
									<template subtype="userdefined" match="*">
										<children>
											<tgrid>
												<properties cellpadding="0" cellspacing="0" width="100%"/>
												<styles width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<styles width="2%"/>
															</tgridcol>
															<tgridcol>
																<styles width="98%"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell/>
																	<tgridcell>
																		<children>
																			<calltemplate subtype="named" match="XMLSource">
																				<parameters>
																					<parameter name="InMixed"/>
																				</parameters>
																			</calltemplate>
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
									<text fixtext="&lt;">
										<properties class="textOperator"/>
									</text>
									<text fixtext="/"/>
									<autocalc xpath="./name()">
										<properties class="textElement"/>
									</autocalc>
									<text fixtext="&gt;">
										<properties class="textOperator"/>
									</text>
								</children>
							</conditionbranch>
							<conditionbranch>
								<children>
									<text fixtext="/&gt;">
										<properties class="textOperator"/>
									</text>
								</children>
							</conditionbranch>
						</children>
					</condition>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="PropertyTable">
				<parameters>
					<parameter name="backgroundColor" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<tgrid>
						<properties _xbgcolor="$backgroundColor" border="1" cellpadding="5" cellspacing="0"/>
						<styles width="100%"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol>
										<styles width="10%"/>
									</tgridcol>
									<tgridcol>
										<styles width="90%"/>
									</tgridcol>
								</children>
							</tgridbody-cols>
							<tgridbody-rows>
								<children>
									<template subtype="element" match="n1:Diagram">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="diagram">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<styles background-color="white"/>
														<children>
															<image>
																<styles _xheight="concat(@height,&apos;px&apos;)" _xwidth="concat(@width,&apos;px&apos;)"/>
																<target>
																	<xpath value="@src"/>
																</target>
															</image>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Namespace">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="namespace">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<content subtype="regular">
																<properties class="schemaSubData"/>
															</content>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Type">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="type">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<content subtype="regular"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Properties">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="properties">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<tgrid>
																<properties cellpadding="0" cellspacing="0"/>
																<styles width="15cm"/>
																<children>
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
																							<tgrid>
																								<properties cellpadding="0" cellspacing="0" class="table-no-border"/>
																								<styles width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties valign="top"/>
																												<styles width="13%"/>
																											</tgridcol>
																											<tgridcol>
																												<properties valign="top"/>
																												<styles width="1%"/>
																											</tgridcol>
																											<tgridcol>
																												<properties valign="top"/>
																												<styles width="86%"/>
																											</tgridcol>
																										</children>
																									</tgridbody-cols>
																									<tgridbody-rows>
																										<children>
																											<template subtype="element" match="n1:Property">
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<properties align="right" valign="top"/>
																																<children>
																																	<template subtype="attribute" match="name">
																																		<children>
																																			<content subtype="regular">
																																				<properties class="schemaSubTitle"/>
																																			</content>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell/>
																															<tgridcell>
																																<properties align="left" valign="top"/>
																																<children>
																																	<content subtype="regular">
																																		<properties class="schemaSubData"/>
																																	</content>
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
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Children">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="children">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<template subtype="element" match="n1:Child">
																<children>
																	<calltemplate subtype="named" match="RefContentList1">
																		<parameters/>
																	</calltemplate>
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
									<template subtype="element" match="n1:UsedBy">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="used by">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<tgrid>
																<properties cellpadding="0" cellspacing="0"/>
																<styles width="15cm"/>
																<children>
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
																							<tgrid>
																								<properties cellpadding="0" cellspacing="0" class="table-no-border"/>
																								<styles width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties valign="top"/>
																												<styles width="13%"/>
																											</tgridcol>
																											<tgridcol>
																												<properties valign="top"/>
																												<styles width="1%"/>
																											</tgridcol>
																											<tgridcol>
																												<properties valign="top"/>
																												<styles width="86%"/>
																											</tgridcol>
																										</children>
																									</tgridbody-cols>
																									<tgridbody-rows>
																										<children>
																											<template subtype="element" groupingtype="group-by" groupingmatch="@type" match="n1:By">
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<properties align="right" valign="top"/>
																																<children>
																																	<condition>
																																		<children>
																																			<conditionbranch xpath="current-grouping-key()=&apos;element&apos;">
																																				<children>
																																					<text fixtext="element">
																																						<properties class="schemaSubTitle"/>
																																					</text>
																																				</children>
																																			</conditionbranch>
																																			<conditionbranch xpath="current-grouping-key()=&apos;complexType&apos;">
																																				<children>
																																					<text fixtext="complexType">
																																						<properties class="schemaSubTitle"/>
																																					</text>
																																				</children>
																																			</conditionbranch>
																																		</children>
																																	</condition>
																																</children>
																															</tgridcell>
																															<tgridcell/>
																															<tgridcell>
																																<properties align="left" valign="top"/>
																																<children>
																																	<template subtype="userdefined" match="current-group()">
																																		<children>
																																			<calltemplate subtype="named" match="RefContentList1">
																																				<parameters/>
																																			</calltemplate>
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
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Facets">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="facets">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<tgrid>
																<properties cellpadding="0" cellspacing="0" class="table-no-border"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<properties align="left" valign="top"/>
																						<children>
																							<text fixtext="Kind">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<properties align="left" valign="top"/>
																						<children>
																							<text fixtext="Value">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<properties align="left" valign="top"/>
																						<children>
																							<text fixtext="annotation">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<template subtype="element" match="n1:Facet">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="kind">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																											<text fixtext=" ">
																												<properties class="schemaSubData"/>
																											</text>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="value">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																											<text fixtext=" ">
																												<properties class="schemaSubData"/>
																											</text>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="element" match="n1:Annotations">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:LocalAttributes">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="attributes">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<tgrid>
																<properties cellpadding="0" cellspacing="0" class="table-no-border"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="Name ">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Type">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Use">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Default">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Fixed">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="annotation">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<template subtype="element" match="n1:LocalAttribute">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="name">
																										<children>
																											<calltemplate subtype="named" match="RefContent2">
																												<parameters/>
																											</calltemplate>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="element" match="n1:Type">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaName"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="use">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="default">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="fixed">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="element" match="n1:Annotations">
																										<children>
																											<template subtype="element" match="n1:Annotation">
																												<children>
																													<template subtype="attribute" match="name">
																														<children>
																															<content subtype="regular">
																																<properties class="schemaSubTitle"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																													<newline/>
																													<content subtype="regular">
																														<properties class="schemaSubData"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:IdentityConstraints">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="identity contstraints">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<tgrid>
																<properties cellpadding="0" cellspacing="0" class="schemaSubTitle"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																			<tgridcol>
																				<styles width="0.01in"/>
																			</tgridcol>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell/>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Name">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Refer">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Selector">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell>
																						<children>
																							<text fixtext="Field(s)">
																								<properties class="schemaSubTitle"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<template subtype="element" match="n1:Constraint">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="kind">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="name">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="refer">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="attribute" match="selector">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubData"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell/>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<template subtype="element" match="n1:Field">
																										<children>
																											<paragraph>
																												<properties class="schemaSubData"/>
																												<children>
																													<content subtype="regular">
																														<properties class="schemaSubData"/>
																													</content>
																												</children>
																											</paragraph>
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Annotations">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="annotation">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<tgrid>
																<properties cellpadding="0" cellspacing="0" class="table-no-border"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<template subtype="element" match="n1:Annotation">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<template subtype="attribute" match="name">
																										<children>
																											<content subtype="regular">
																												<properties class="schemaSubTitle"/>
																											</content>
																										</children>
																										<variables/>
																									</template>
																									<text fixtext=" "/>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<properties align="left" valign="top"/>
																								<children>
																									<content subtype="regular">
																										<properties class="schemaSubData"/>
																									</content>
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Source">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="source">
																<properties class="schemaSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<template subtype="userdefined" match="node()">
																<children>
																	<calltemplate subtype="named" match="XMLSource">
																		<parameters>
																			<parameter name="InMixed"/>
																		</parameters>
																	</calltemplate>
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
			</globaltemplate>
			<globaltemplate subtype="named" match="BookmarkItem">
				<parameters/>
				<children>
					<paragraph>
						<properties class="schemaName"/>
						<children>
							<link>
								<properties class="schemaName"/>
								<children>
									<template subtype="attribute" match="name">
										<children>
											<content subtype="regular">
												<properties class="schemaName"/>
											</content>
										</children>
										<variables/>
									</template>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="@id"/>
								</hyperlink>
							</link>
							<condition>
								<children>
									<conditionbranch xpath="@redefinition">
										<children>
											<text fixtext=" (r)">
												<properties class="schemaSubTitle"/>
											</text>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="SchemaItem">
				<parameters>
					<parameter name="type" type="xs:string" default-value="&apos;&apos;"/>
					<parameter name="backgroundColor" type="xs:string" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<paragraph>
						<styles keep-with-next="always"/>
						<children>
							<bookmark>
								<children>
									<condition>
										<children>
											<conditionbranch xpath="xs:boolean(@redefinition)">
												<children>
													<text fixtext="redefinition of ">
														<properties class="elementHeader"/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<template subtype="parameter" match="$type">
										<children>
											<content subtype="regular">
												<properties class="elementHeader"/>
											</content>
										</children>
										<variables/>
									</template>
									<text fixtext=" ">
										<properties class="elementHeader"/>
									</text>
									<template subtype="attribute" match="name">
										<children>
											<calltemplate subtype="named" match="RefContent3">
												<parameters/>
											</calltemplate>
										</children>
										<variables/>
									</template>
								</children>
								<action>
									<none/>
								</action>
								<bookmark>
									<xpath value="@id"/>
								</bookmark>
							</bookmark>
						</children>
					</paragraph>
					<calltemplate subtype="named" match="PropertyTable">
						<parameters>
							<parameter name="backgroundColor" value="$backgroundColor"/>
						</parameters>
					</calltemplate>
					<newline/>
					<template subtype="userdefined" match="(n1:Attribute|n1:Element)">
						<children>
							<calltemplate subtype="userdefined" match="current()"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="Footer">
				<parameters/>
				<children>
					<paragraph>
						<properties class="schemaSubTitle"/>
						<children>
							<text fixtext="XML Schema documentation generated by ">
								<properties class="schemaSubTitle"/>
							</text>
							<link>
								<children>
									<text fixtext="XMLSpy">
										<properties class="schemaName"/>
									</text>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
							<text fixtext=" Schema Editor ">
								<properties class="schemaSubTitle"/>
							</text>
							<link>
								<properties class="schemaName"/>
								<children>
									<text fixtext="http://www.altova.com/xmlspy">
										<properties class="schemaName"/>
									</text>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="RefContent1">
				<parameters/>
				<children>
					<link conditional-processing="if (self::attribute()) then ../@ref else @ref">
						<properties class="schemaName"/>
						<children>
							<content subtype="regular">
								<properties class="schemaName"/>
							</content>
						</children>
						<action>
							<none/>
						</action>
						<hyperlink>
							<fixtext value="#"/>
							<xpath value="if (self::attribute()) then ../@ref else @ref"/>
						</hyperlink>
					</link>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="RefContent2">
				<parameters/>
				<children>
					<link conditional-processing="if (self::attribute()) then ../@ref else @ref">
						<properties class="schemaSubTitle"/>
						<children>
							<content subtype="regular">
								<properties class="schemaSubTitle"/>
							</content>
						</children>
						<action>
							<none/>
						</action>
						<hyperlink>
							<fixtext value="#"/>
							<xpath value="if (self::attribute()) then ../@ref else @ref"/>
						</hyperlink>
					</link>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="RefContent3">
				<parameters/>
				<children>
					<link conditional-processing="if (self::attribute()) then ../@ref else @ref">
						<properties class="elementHeader2"/>
						<children>
							<content subtype="regular">
								<properties class="elementHeader2"/>
							</content>
						</children>
						<action>
							<none/>
						</action>
						<hyperlink>
							<fixtext value="#"/>
							<xpath value="if (self::attribute()) then ../@ref else @ref"/>
						</hyperlink>
					</link>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="RefContentList1">
				<parameters/>
				<children>
					<condition>
						<children>
							<conditionbranch xpath="position() != 1">
								<children>
									<text fixtext="  ">
										<properties class="schemaName"/>
									</text>
								</children>
							</conditionbranch>
						</children>
					</condition>
					<calltemplate subtype="named" match="RefContent1">
						<parameters/>
					</calltemplate>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
