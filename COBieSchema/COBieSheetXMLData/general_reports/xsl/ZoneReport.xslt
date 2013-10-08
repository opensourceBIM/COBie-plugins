<?xml version="1.0" encoding="UTF-8"?>
<!--Designed and generated by Altova StyleVision Enterprise Edition 2011 rel. 2 sp1 - see http://www.altova.com/stylevision for more information.-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:altova="http://www.altova.com" xmlns:altovaext="http://www.altova.com/xslt-extensions" xmlns:cb="sheetxmldata.cobie.erdc.org" xmlns:clitype="clitype" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:iso4217="http://www.xbrl.org/2003/iso4217" xmlns:ix="http://www.xbrl.org/2008/inlineXBRL" xmlns:java="java" xmlns:link="http://www.xbrl.org/2003/linkbase" xmlns:sps="http://www.altova.com/StyleVision/user-xpath-functions" xmlns:xbrldi="http://xbrl.org/2006/xbrldi" xmlns:xbrli="http://www.xbrl.org/2003/instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" exclude-result-prefixes="#all">
	<xsl:output version="4.0" method="html" indent="no" encoding="UTF-8" use-character-maps="spaces" doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN" doctype-system="http://www.w3.org/TR/html4/loose.dtd"/>
	<xsl:character-map name="spaces">
		<xsl:output-character character="&#160;" string="&amp;nbsp;"/>
	</xsl:character-map>
	<xsl:param name="SV_OutputFormat" select="'HTML'"/>
	<xsl:param name="SV_BaseOutputFileName" as="xs:string?">
		<xsl:sequence select="for $i in altovaext:get-base-output-uri(), $j in tokenize( $i, &apos;[/\\]&apos; )[last()] return replace( $j, &apos;\.[^\.\s#%;]*$&apos;, &apos;&apos; )" use-when="function-available(&apos;altovaext:get-base-output-uri&apos;)"/>
	</xsl:param>
	<xsl:param name="SV_GeneratedFileNamePrefix" select="if ( $SV_BaseOutputFileName ) then $SV_BaseOutputFileName else &apos;ZoneReport&apos;" as="xs:string?"/>
	<xsl:variable name="XML" select="/"/>
	<xsl:variable name="altova:nPxPerIn" select="96"/>
	<xsl:variable name="altova:DesignAfterStep1">
		<altova:main-document url="{if ($SV_BaseOutputFileName) then concat($SV_BaseOutputFileName,'.html') else ''}">
			<html>
				<head>
					<meta http-equiv="X-UA-Compatible" content="IE=7"/>
					<xsl:comment>[if IE]&gt;&lt;STYLE type=&quot;text/css&quot;&gt;.altova-rotate-left-textbox{filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=3)} .altova-rotate-right-textbox{filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=1)} &lt;/STYLE&gt;&lt;![endif]</xsl:comment>
					<xsl:comment>[if !IE]&gt;&lt;!</xsl:comment>
					<style type="text/css">.altova-rotate-left-textbox{-webkit-transform: rotate(-90deg) translate(-100%, 0%); -webkit-transform-origin: 0% 0%;-moz-transform: rotate(-90deg) translate(-100%, 0%); -moz-transform-origin: 0% 0%}.altova-rotate-right-textbox{-webkit-transform: rotate(90deg) translate(0%, -100%); -webkit-transform-origin: 0% 0%;-moz-transform: rotate(90deg) translate(0%, -100%); -moz-transform-origin: 0% 0%}</style>
					<xsl:comment>&lt;![endif]</xsl:comment>
					<style type="text/css">@page { margin-left:0.60in; margin-right:0.60in; margin-top:0.79in; margin-bottom:0.79in } @media print { br.altova-page-break { page-break-before: always; } }</style>
				</head>
				<body>
					<br class="altova-page-break" clear="all"/>
					<xsl:for-each select="$XML">
						<xsl:variable name="facilityName" select="cb:COBIE/Facilities[1]/Facility[1]/@Name"/>
						<xsl:variable name="projectName" select="cb:COBIE/Facilities[1]/Facility[1]/ProjectName"/>
						<xsl:variable name="siteName" select="cb:COBIE/Facilities[1]/Facility[1]/SiteName"/>
						<h1>
							<span>
								<xsl:text>COBie Zone Report</xsl:text>
							</span>
						</h1>
						<p>
							<span>
								<xsl:variable name="altova:seqContentStrings_177CD6F0">
									<xsl:value-of select="format-number(number(substring(string(string(current-dateTime())), 1, 4)), '0000')"/>
									<xsl:variable name="sText" as="xs:string?">
										<xsl:text>-</xsl:text>
									</xsl:variable>
									<xsl:value-of select="$sText"/>
									<xsl:value-of select="format-number(number(substring(string(current-dateTime()), 6, 2)), '00')"/>
									<xsl:variable name="sText" as="xs:string?">
										<xsl:text>-</xsl:text>
									</xsl:variable>
									<xsl:value-of select="$sText"/>
									<xsl:value-of select="format-number(number(substring(string(current-dateTime()), 9, 2)), '00')"/>
									<xsl:variable name="sText" as="xs:string?">
										<xsl:text>T</xsl:text>
									</xsl:variable>
									<xsl:value-of select="$sText"/>
									<xsl:value-of select="format-number(number(substring(string(current-dateTime()), 12, 2)), '00')"/>
									<xsl:variable name="sText" as="xs:string?">
										<xsl:text>:</xsl:text>
									</xsl:variable>
									<xsl:value-of select="$sText"/>
									<xsl:value-of select="format-number(number(substring(string(current-dateTime()), 15, 2)), '00')"/>
									<xsl:variable name="sText" as="xs:string?">
										<xsl:text>:</xsl:text>
									</xsl:variable>
									<xsl:value-of select="$sText"/>
									<xsl:choose>
										<xsl:when test="contains(string(current-dateTime()), 'Z')">
											<xsl:value-of select="format-number(number(substring-after(substring-after(substring-before(string(current-dateTime()), 'Z'), ':'), ':')), '00')"/>
										</xsl:when>
										<xsl:when test="contains(string(current-dateTime()), '+')">
											<xsl:value-of select="format-number(number(substring-after(substring-after(substring-before(string(current-dateTime()), '+'), ':'), ':')), '00')"/>
										</xsl:when>
										<xsl:when test="contains(substring(string(current-dateTime()), 18), '-')">
											<xsl:value-of select="format-number(number(substring-before(substring(string(current-dateTime()), 18), '-')), '00')"/>
										</xsl:when>
										<xsl:otherwise>
											<xsl:value-of select="format-number(number(substring(string(current-dateTime()), 18)), '00')"/>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:variable>
								<xsl:variable name="altova:sContent_177CD6F0" select="string($altova:seqContentStrings_177CD6F0)"/>
								<xsl:value-of select="$altova:sContent_177CD6F0"/>
							</span>
						</p>
						<h2>
							<span>
								<xsl:text>Model Information</xsl:text>
							</span>
						</h2>
						<p>
							<span>
								<xsl:text>Facility Name:&#160; </xsl:text>
							</span>
							<xsl:for-each select="$facilityName">
								<span>
									<xsl:text>&#160;</xsl:text>
								</span>
								<xsl:choose>
									<xsl:when test=". instance of element() or . instance of document-node()">
										<xsl:apply-templates/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="."/>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:for-each>
						</p>
						<p>
							<span>
								<xsl:text>Project Name: </xsl:text>
							</span>
							<xsl:for-each select="$projectName">
								<span>
									<xsl:text>&#160;</xsl:text>
								</span>
								<xsl:choose>
									<xsl:when test=". instance of element() or . instance of document-node()">
										<xsl:apply-templates/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="."/>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:for-each>
							<span>
								<xsl:text>&#160;</xsl:text>
							</span>
						</p>
						<p>
							<span>
								<xsl:text>Site Name:&#160; </xsl:text>
							</span>
							<xsl:for-each select="$siteName">
								<span>
									<xsl:text>&#160;</xsl:text>
								</span>
								<xsl:choose>
									<xsl:when test=". instance of element() or . instance of document-node()">
										<xsl:apply-templates/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="."/>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:for-each>
						</p>
						<p>
							<h3>
								<span>
									<xsl:text>Description</xsl:text>
								</span>
							</h3>
							<span>
								<xsl:text>This report provides a listing of zones contained in the model</xsl:text>
							</span>
						</p>
						<hr/>
						<xsl:for-each select="cb:COBIE">
							<xsl:for-each select="Zones">
								<altova:toc altova:name="toc"/>
								<hr/>
								<xsl:for-each select="Zone[not(./@Name=preceding-sibling::Zone/@Name)]">
									<xsl:variable name="CurrentZoneName" as="xs:string" select="./@Name"/>
									<altova:level>
										<h2>
											<altova:marker altova:name="ZoneBookMark">
												<xsl:attribute name="altova:entrytext">
													<xsl:value-of select="concat(concat(position(),' '),@Name)"/>
												</xsl:attribute>
												<span>
													<altova:num-lvl altova:format="1.1.1"/>
												</span>
												<span>
													<xsl:text>&#160;</xsl:text>
												</span>
												<xsl:for-each select="@Name">
													<span>
														<xsl:text>&#160;</xsl:text>
													</span>
													<span>
														<xsl:value-of select="string(.)"/>
													</span>
												</xsl:for-each>
											</altova:marker>
										</h2>
										<p>
											<xsl:for-each select="parent::Zones/parent::cb:COBIE">
												<xsl:for-each select="Zones">
													<h3>
														<span>
															<xsl:text>Spaces</xsl:text>
														</span>
													</h3>
													<xsl:for-each select="Zone[@Name=$CurrentZoneName]">
														<xsl:for-each select="SpaceNames[not(text()=preceding-sibling::element()/SpaceNames)]">
															<xsl:variable name="currentSpaceNames" as="xs:string" select="./text()"/>
															<xsl:variable name="thisPosition" select="position()"/>
															<xsl:apply-templates/>
														</xsl:for-each>
														<xsl:if test="not(position()=last())">
															<span>
																<xsl:text>,</xsl:text>
															</span>
														</xsl:if>
														<xsl:if test="position() mod 10 = 0">
															<p/>
														</xsl:if>
													</xsl:for-each>
												</xsl:for-each>
											</xsl:for-each>
										</p>
										<br/>
										<table border="1">
											<xsl:variable name="altova:CurrContextGrid_15F81CD0" select="."/>
											<xsl:variable name="altova:ColumnData">
												<altova:Internal/>
											</xsl:variable>
											<tbody>
												<tr>
													<th>
														<span>
															<xsl:text>Name</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="@Name">
															<span>
																<xsl:value-of select="string(.)"/>
															</span>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>CreatedBy</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="CreatedBy">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>CreatedOn</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="CreatedOn">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>Category</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="Category">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>ExtSystem</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="ExtSystem">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>ExtObject</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="ExtObject">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>ExtIdentifier</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="ExtIdentifier">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
												<tr>
													<th>
														<span>
															<xsl:text>Description</xsl:text>
														</span>
													</th>
													<td>
														<xsl:for-each select="Description">
															<xsl:apply-templates/>
														</xsl:for-each>
													</td>
												</tr>
											</tbody>
										</table>
										<p>
											<altova:hyperlink>
												<xsl:choose>
													<xsl:when test="not(string(&apos;#TOP&apos;))">
														<xsl:attribute name="href">
															<xsl:text>#</xsl:text>
														</xsl:attribute>
													</xsl:when>
													<xsl:when test="substring(string(&apos;#TOP&apos;), 1, 1) = '#'">
														<xsl:attribute name="href">
															<xsl:value-of select="&apos;#TOP&apos;"/>
														</xsl:attribute>
													</xsl:when>
													<xsl:otherwise>
														<xsl:attribute name="href">
															<xsl:if test="substring(string(&apos;#TOP&apos;), 2, 1) = ':'">
																<xsl:text>file:///</xsl:text>
															</xsl:if>
															<xsl:value-of select="translate(string(&apos;#TOP&apos;), '&#x5c;', '/')"/>
														</xsl:attribute>
													</xsl:otherwise>
												</xsl:choose>
												<span>
													<xsl:text>Table of Contents</xsl:text>
												</span>
											</altova:hyperlink>
										</p>
										<hr/>
									</altova:level>
								</xsl:for-each>
							</xsl:for-each>
						</xsl:for-each>
						<br/>
					</xsl:for-each>
				</body>
			</html>
		</altova:main-document>
	</xsl:variable>
	<xsl:template match="altova:toc[ @altova:name = 'toc' ]" mode="altova:generate-toc-xslt-tree">
		<xsl:variable name="altova:source-document" select="ancestor::*[self::altova:result-document | self::altova:main-document][1]"/>
		<altova:toc altova:design-id="{generate-id()}">
			<xsl:variable name="altova:current-level-id" select="generate-id( ancestor::altova:level[1] )"/>
			<h1>
				<span>
					<xsl:text>Table of Contents</xsl:text>
				</span>
			</h1>
			<xsl:for-each select="ancestor::*[self::altova:level | self::altova:main-document][1]">
				<xsl:for-each select="descendant::altova:level[ ancestor::*[self::altova:level | self::altova:main-document][1] is current() ]">
					<xsl:variable name="altova:current-level-id" select="generate-id()"/>
					<h3>
						<xsl:for-each select="descendant::altova:marker[ @altova:name = 'ZoneBookMark' and ancestor::altova:level[1] is current() ]">
							<xsl:variable name="altova:current-marker-id" select="generate-id()"/>
							<a href="{concat(altova:calc-relative-path($altova:source-document/@url,ancestor::*[self::altova:result-document | self::altova:main-document][1]/@url),'#',generate-id())}">
								<span>
									<xsl:choose>
										<xsl:when test="@altova:entrytext">
											<xsl:value-of select="@altova:entrytext"/>
										</xsl:when>
										<xsl:otherwise>
											<xsl:apply-templates mode="altova:extract-text-from-marker">
												<xsl:with-param name="altova:level-design-id" select="$altova:current-level-id"/>
												<xsl:with-param name="altova:marker-design-id" select="$altova:current-marker-id"/>
											</xsl:apply-templates>
										</xsl:otherwise>
									</xsl:choose>
								</span>
							</a>
						</xsl:for-each>
					</h3>
				</xsl:for-each>
			</xsl:for-each>
		</altova:toc>
	</xsl:template>
	<xsl:template match="/">
		<xsl:for-each select="$altova:DesignAfterStep1">
			<xsl:apply-templates mode="altova:step2"/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="@* | node()" mode="altova:step2">
		<xsl:copy>
			<xsl:apply-templates select="@* | node()" mode="#current"/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="table" mode="altova:step2">
		<xsl:variable name="altova:table">
			<xsl:copy>
				<xsl:apply-templates select="@* | node()" mode="#current"/>
			</xsl:copy>
		</xsl:variable>
		<xsl:apply-templates select="$altova:table" mode="altova:generate-table"/>
	</xsl:template>
	<xsl:variable name="altova:toc-xslt-tree1">
		<xsl:for-each select="$altova:DesignAfterStep1">
			<xsl:apply-templates mode="altova:generate-toc-xslt-tree"/>
		</xsl:for-each>
	</xsl:variable>
	<xsl:template match="altova:level" mode="altova:generate-toc-xslt-tree">
		<altova:level altova:design-id="{generate-id()}">
			<xsl:apply-templates mode="#current"/>
		</altova:level>
	</xsl:template>
	<xsl:template match="altova:marker" mode="altova:generate-toc-xslt-tree">
		<altova:marker altova:design-id="{generate-id()}" altova:name="{@altova:name}">
			<xsl:apply-templates mode="#current"/>
		</altova:marker>
	</xsl:template>
	<xsl:template match="@* | text()" mode="altova:generate-toc-xslt-tree"/>
	<xsl:template match="altova:UnescapedText" mode="altova:extract-text-from-marker">
		<xsl:param name="altova:level-design-id"/>
		<xsl:param name="altova:marker-design-id"/>
		<xsl:copy copy-namespaces="no">
			<xsl:apply-templates mode="#current"/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="text()" mode="altova:extract-text-from-marker">
		<xsl:param name="altova:level-design-id"/>
		<xsl:param name="altova:marker-design-id"/>
		<xsl:value-of select="."/>
	</xsl:template>
	<xsl:template match="altova:num-lvl" mode="altova:extract-text-from-marker">
		<xsl:param name="altova:level-design-id"/>
		<xsl:param name="altova:marker-design-id"/>
		<xsl:copy>
			<xsl:copy-of select="@*"/>
			<xsl:attribute name="altova:level-design-id" select="$altova:level-design-id"/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="altova:num-seq" mode="altova:extract-text-from-marker">
		<xsl:param name="altova:level-design-id"/>
		<xsl:param name="altova:marker-design-id"/>
		<xsl:copy>
			<xsl:copy-of select="@*"/>
			<xsl:attribute name="altova:marker-design-id" select="generate-id( ancestor::altova:marker[1] )"/>
		</xsl:copy>
	</xsl:template>
	<xsl:variable name="altova:toc-xslt-tree" select="$altova:toc-xslt-tree1"/>
	<xsl:key name="altova:bookmark-key" match="altova:bookmark" use="@name"/>
	<xsl:key name="altova:toc-xslt-tree-key" match="altova:level | altova:toc | altova:ref | altova:marker" use="@altova:design-id"/>
	<xsl:template match="altova:main-document" mode="altova:step2">
		<xsl:apply-templates select="node()" mode="#current"/>
	</xsl:template>
	<xsl:template match="altova:level" mode="altova:step2">
		<xsl:apply-templates select="node()" mode="#current"/>
	</xsl:template>
	<xsl:template match="altova:bookmark | altova:hyperlink" mode="altova:step2">
		<a>
			<xsl:apply-templates select="@* | node()" mode="#current"/>
		</a>
	</xsl:template>
	<xsl:template match="altova:hyperlink/@href[starts-with(.,'#')]" mode="altova:step2">
		<xsl:variable name="altova:bookmark-name" select="substring(.,2)"/>
		<xsl:attribute name="href">
			<xsl:variable name="altova:source-document" select="ancestor::*[self::altova:result-document | self::altova:main-document][1]"/>
			<xsl:variable name="altova:target-document" select="key('altova:bookmark-key',$altova:bookmark-name,$altova:DesignAfterStep1)[1]/ancestor::*[self::altova:result-document | self::altova:main-document][1]"/>
			<xsl:value-of select="concat(altova:calc-relative-path($altova:source-document/@url,$altova:target-document/@url),.)"/>
		</xsl:attribute>
	</xsl:template>
	<xsl:template match="altova:toc | altova:ref" mode="altova:step2">
		<xsl:apply-templates select="$altova:toc-xslt-tree/key( 'altova:toc-xslt-tree-key', generate-id( current() ) )/node()" mode="#current"/>
	</xsl:template>
	<xsl:template match="altova:marker" mode="altova:step2">
		<a name="{generate-id()}"/>
		<xsl:apply-templates select="node()" mode="#current"/>
	</xsl:template>
	<xsl:template match="altova:num-lvl" mode="altova:step2">
		<xsl:variable name="altova:format" select="@altova:format"/>
		<xsl:variable name="altova:omit-levels" select="@altova:omit-levels"/>
		<xsl:variable name="altova:level-design-id">
			<xsl:choose>
				<xsl:when test="@altova:level-design-id">
					<xsl:value-of select="@altova:level-design-id"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="generate-id( ancestor::altova:level[1] )"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:for-each select="$altova:toc-xslt-tree/key( 'altova:toc-xslt-tree-key', $altova:level-design-id )">
			<xsl:choose>
				<xsl:when test="$altova:omit-levels">
					<xsl:number level="multiple" count="altova:level[ count( ancestor::altova:level ) >= $altova:omit-levels ]" format="{$altova:format}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:number level="multiple" count="altova:level" format="{$altova:format}"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="altova:num-seq" mode="altova:step2">
		<xsl:variable name="altova:format" select="@altova:format"/>
		<xsl:variable name="altova:marker-design-id">
			<xsl:choose>
				<xsl:when test="@altova:marker-design-id">
					<xsl:value-of select="@altova:marker-design-id"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="generate-id( ancestor::altova:marker[1] )"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:for-each select="$altova:toc-xslt-tree/key( 'altova:toc-xslt-tree-key', $altova:marker-design-id )">
			<xsl:variable name="altova:name" select="@altova:name"/>
			<xsl:number level="any" count="altova:marker[ @altova:name = $altova:name ]" format="{$altova:format}"/>
		</xsl:for-each>
	</xsl:template>
	<xsl:function name="altova:calc-relative-path" as="xs:string">
		<xsl:param name="altova:source-path"/>
		<xsl:param name="altova:target-path"/>
		<xsl:choose>
			<xsl:when test="$altova:source-path = $altova:target-path">
				<xsl:sequence select="''"/>
			</xsl:when>
			<xsl:when test="starts-with($altova:target-path,'http:') or starts-with($altova:target-path,'ftp:') or starts-with($altova:target-path,'file:')">
				<xsl:sequence select="$altova:target-path"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="altova:source-parts" select="tokenize($altova:source-path,'[/\\]')"/>
				<xsl:variable name="altova:target-parts" select="tokenize($altova:target-path,'[/\\]')"/>
				<xsl:variable name="altova:common-part-count" select="sum(for $i in (1 to count($altova:source-parts) - 1) return if( subsequence($altova:source-parts,1,$i) = subsequence($altova:target-parts,1,$i) ) then 1 else 0)"/>
				<xsl:sequence select="string-join((for $i in ($altova:common-part-count + 1 to count($altova:source-parts) - 1) return '..',for $i in ($altova:common-part-count + 1 to count($altova:target-parts)) return $altova:target-parts[$i]),'/')"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="altova:map-preview-filepath" as="xs:string">
		<xsl:param name="filepath"/>
		<xsl:sequence select="altovaext:create-temp-file-mapping($filepath)" use-when="function-available('altovaext:create-temp-file-mapping',1)"/>
		<xsl:sequence select="$filepath" use-when="not(function-available('altovaext:create-temp-file-mapping',1))"/>
	</xsl:function>
	<xsl:function name="altova:is-cell-empty" as="xs:boolean">
		<xsl:param name="altova:cell" as="element()"/>
		<xsl:sequence select="altova:is-node-empty( $altova:cell )"/>
	</xsl:function>
	<xsl:function name="altova:is-node-empty" as="xs:boolean">
		<xsl:param name="altova:node" as="element()"/>
		<xsl:sequence select="every $altova:child in $altova:node/child::node() satisfies ( ( boolean( $altova:child/self::text() ) and string-length( $altova:child ) = 0 ) or ( ( boolean( $altova:child/self::div ) or boolean( $altova:child/self::span ) or boolean( $altova:child/self::a ) ) and altova:is-node-empty( $altova:child ) ) )"/>
	</xsl:function>
	<xsl:function name="altova:col-span" as="xs:integer">
		<xsl:param name="altova:cell" as="element()"/>
		<xsl:sequence select="if ( exists( $altova:cell/@colspan ) ) then xs:integer( $altova:cell/@colspan ) else 1"/>
	</xsl:function>
	<xsl:template match="@* | node()" mode="altova:generate-table">
		<xsl:param name="altova:generate-cols"/>
		<xsl:copy>
			<xsl:apply-templates select="@* | node()" mode="#current">
				<xsl:with-param name="altova:generate-cols" select="$altova:generate-cols"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="tbody" mode="altova:generate-table">
		<xsl:param name="altova:generate-cols"/>
		<xsl:choose>
			<xsl:when test="empty(tr)">
				<xsl:copy>
					<tr>
						<td/>
					</tr>
				</xsl:copy>
			</xsl:when>
			<xsl:otherwise>
				<xsl:copy>
					<xsl:apply-templates select="@* | node()" mode="#current">
						<xsl:with-param name="altova:generate-cols" select="$altova:generate-cols"/>
					</xsl:apply-templates>
				</xsl:copy>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template match="th | td" mode="altova:generate-table">
		<xsl:choose>
			<xsl:when test="altova:is-cell-empty( . )">
				<xsl:copy>
					<xsl:apply-templates select="@*" mode="#current"/>
					<xsl:text>&#160;</xsl:text>
				</xsl:copy>
			</xsl:when>
			<xsl:otherwise>
				<xsl:copy>
					<xsl:apply-templates select="@* | node()" mode="#current"/>
				</xsl:copy>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:function name="altova:GetChartYValuesForSingleSeries">
		<xsl:param name="seqCategoryLeafPos" as="node()*"/>
		<xsl:param name="nodeSeriesLeafPos" as="node()"/>
		<xsl:param name="bValuesInCategory" as="xs:boolean"/>
		<xsl:for-each select="$seqCategoryLeafPos">
			<xsl:element name="altova:Value">
				<xsl:value-of select="altova:GetChartYValueForSingleSeriesPos($nodeSeriesLeafPos, ., $bValuesInCategory)"/>
			</xsl:element>
		</xsl:for-each>
	</xsl:function>
	<xsl:function name="altova:GetChartYValueForSingleSeriesPos">
		<xsl:param name="nodeSeriesLeafPos" as="node()"/>
		<xsl:param name="nodeCategoryLeafPos" as="node()"/>
		<xsl:param name="bValuesInCategory" as="xs:boolean"/>
		<xsl:variable name="altova:seqCategoryContextIds" select="$nodeCategoryLeafPos/altova:Context/@altova:ContextId" as="xs:string*"/>
		<xsl:variable name="altova:seqSeriesContextIds" select="$nodeSeriesLeafPos/altova:Context/@altova:ContextId" as="xs:string*"/>
		<xsl:variable name="altova:sCommonContextId" select="for $i in $altova:seqCategoryContextIds return if (some $j in $altova:seqSeriesContextIds satisfies $i eq $j) then $i else ()" as="xs:string*"/>
		<xsl:choose>
			<xsl:when test="count($altova:sCommonContextId) gt 1">
				<xsl:message select="concat('XBRL Chart: Error: Found several values instead of a single one (contexts: ', string-join($altova:sCommonContextId, ', '), ').')" terminate="yes"/>
			</xsl:when>
			<xsl:when test="count($altova:sCommonContextId) lt 1">
				<xsl:message select="concat('XBRL Chart: Info: No value found for position labeled &quot;', $nodeCategoryLeafPos/@altova:sLabel, '&quot;')" terminate="no"/>
				<xsl:sequence select="'altova:no-value'"/>
			</xsl:when>
			<xsl:when test="$bValuesInCategory">
				<xsl:sequence select="xs:string($nodeCategoryLeafPos/altova:Context[@altova:ContextId eq $altova:sCommonContextId]/@altova:Value)"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:sequence select="xs:string($nodeSeriesLeafPos/altova:Context[@altova:ContextId eq $altova:sCommonContextId]/@altova:Value)"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="altova:GetChartLabelForPos" as="xs:string">
		<xsl:param name="nodeParam" as="node()"/>
		<xsl:value-of select="string-join($nodeParam/ancestor-or-self::altova:Pos/@altova:sLabel, ' ')"/>
	</xsl:function>
	<xsl:function name="altova:convert-length-to-pixel" as="xs:decimal">
		<xsl:param name="altova:length"/>
		<xsl:variable name="normLength" select="normalize-space($altova:length)"/>
		<xsl:choose>
			<xsl:when test="ends-with($normLength, 'px')">
				<xsl:value-of select="substring-before($normLength, 'px')"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'in')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'in')) * $altova:nPxPerIn"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'cm')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'cm')) * $altova:nPxPerIn div 2.54"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'mm')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'mm')) * $altova:nPxPerIn div 25.4"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'pt')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'pt')) * $altova:nPxPerIn div 72.0"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'pc')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'pc')) * $altova:nPxPerIn div 6.0"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$normLength"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<xsl:function name="altova:convert-length-to-mm" as="xs:decimal">
		<xsl:param name="altova:length"/>
		<xsl:variable name="normLength" select="normalize-space($altova:length)"/>
		<xsl:choose>
			<xsl:when test="ends-with($normLength, 'px')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'px')) div $altova:nPxPerIn * 25.4"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'in')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'in')) * 25.4"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'cm')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'cm')) * 10"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'mm')">
				<xsl:value-of select="substring-before($normLength, 'mm') "/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'pt')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'pt')) * 25.4 div 72.0"/>
			</xsl:when>
			<xsl:when test="ends-with($normLength, 'pc')">
				<xsl:value-of select="xs:decimal(substring-before($normLength, 'pc')) * 25.4 div 6.0"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="number($normLength) div $altova:nPxPerIn * 25.4"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
</xsl:stylesheet>
