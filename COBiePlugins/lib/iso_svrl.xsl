<?xml version="1.0" ?>
<!--  This is the most recent. Determined, sans tests 2008-05-29T12:24:48Z -->
<!-- 
   ISO_SVRL.xsl   

   Implementation of Schematron Validation Report Language from ISO Schematron
   ISO/IEC 19757 Document Schema Definition Languages (DSDL) 
     Part 3: Rule-based validation  Schematron 
     Annex D: Schematron Validation Report Language 

  This ISO Standard is available free as a Publicly Available Specification in PDF from ISO.
  Also see www.schematron.com for drafts and other information.

  This implementation of SVRL is designed to run with the "Skeleton" implementation 
  of Schematron which Oliver Becker devised. The skeleton code provides a 
  Schematron implementation but with named templates for handling all output; 
  the skeleton provides basic templates for output using this API, but client
  validators can be written to import the skeleton and override the default output
  templates as required. (In order to understand this, you must understand that
  a named template such as "process-assert" in this XSLT stylesheet overrides and
  replaces any template with the same name in the imported skeleton XSLT file.)

  The other important thing to understand in this code is that there are different
  versions of the Schematron skeleton. These track the development of Schematron through
  Schematron 1.5, Schematron 1.6 and now ISO Schematron. One only skeleton must be
  imported. The code has templates for the different skeletons commented out for 
  convenience. ISO Schematron has a different namespace than Schematron 1.5 and 1.6;
  so the ISO Schematron skeleton has been written itself with an optional import
  statement to in turn import the Schematron 1.6 skeleton. This will allow you to 
  validate with schemas from either namespace.
  

  History:
    2007-02-01
       * DP. Updated to contain all decorative attributes and inline elements.

    2007-01-22
    	* DP change svrl:ns to svrl:ns-in-attribute-value
	* Change default when no queryBinding from "unknown" to "xslt"
	
    2007-01-18:
          * Improve documentation
          * KH Add command-line options to generate paths or not 
          * Use axsl:attribute rather than xsl:attribute to shut XSLT2 up
          * Add extra command-line options to pass to the iso_schematron_skeleton
  
    2006-12-01: iso_svrl.xsl Rick Jelliffe, 
          * update namespace, 
          * update phase handling,
          * add flag param to process-assert and process-report & @ flag on output
  
    2001: Conformance1-5.xsl Rick Jelliffe, 
          * Created, using the skeleton code contributed by Oliver Becker
-->
<!--
 Derived from Conformance1-5.xsl.

 Copyright (c) 2001, 2006 Rick Jelliffe and Academia Sinica Computing Center, Taiwan

 This software is provided 'as-is', without any express or implied warranty. 
 In no event will the authors be held liable for any damages arising from 
 the use of this software.

 Permission is granted to anyone to use this software for any purpose, 
 including commercial applications, and to alter it and redistribute it freely,
 subject to the following restrictions:

 1. The origin of this software must not be misrepresented; you must not claim
 that you wrote the original software. If you use this software in a product, 
 an acknowledgment in the product documentation would be appreciated but is 
 not required.

 2. Altered source versions must be plainly marked as such, and must not be 
 misrepresented as being the original software.

 3. This notice may not be removed or altered from any source distribution.
-->

<!-- Ideas nabbed from schematrons by Francis N., Miloslav N. and David C. -->

<!-- The command-line parameters are:
  			phase           NMTOKEN | "#ALL" (default) Select the phase for validation
    		allow-foreign   "true" | "false" (default)   Pass non-Schematron elements to the generated stylesheet
#DP was true | false for diagnose, test is for yes | no
            diagnose= yes | no    Add the diagnostics to the assertion test in reports
            generate-paths=true|false   generate the @location attribute with XPaths
            sch.exslt.imports semi-colon delimited string of filenames for some EXSLT implementations  
            
-->

<xsl:stylesheet
   version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:axsl="http://www.w3.org/1999/XSL/TransformAlias"
   xmlns:sch="http://www.ascc.net/xml/schematron"
   xmlns:iso="http://purl.oclc.org/dsdl/schematron"
   xmlns:svrl="http://purl.oclc.org/dsdl/svrl"
   
>


<xsl:import href="iso_schematron_skeleton_for_xslt1.xsl"/>

<!-- Input document root -->
<xsl:variable name='root' select="/*"/>


<xsl:param name="diagnose" select="yes"/>
<xsl:param name="phase">
  <xsl:choose>
    <!-- Handle Schematron 1.5 and 1.6 phases -->
    <xsl:when test="//sch:schema/@defaultPhase">
      <xsl:value-of select="//sch:schema/@defaultPhase"/>
    </xsl:when>
    <!-- Handle ISO Schematron phases -->
    <xsl:when test="//iso:schema/@defaultPhase">
      <xsl:value-of select="//iso:schema/@defaultPhase"/>
    </xsl:when>
    <xsl:otherwise>#ALL</xsl:otherwise>
  </xsl:choose>
</xsl:param>


<xsl:param name="allow-foreign">true</xsl:param>

<xsl:param name="generate-paths">true</xsl:param>

<!-- e.g. saxon file.xml file.xsl "sch.exslt.imports=.../string.xsl;.../math.xsl" -->
<xsl:param name="sch.exslt.imports"/>


 <!-- DP Addition. Which mode are we in? -->
 <!-- This file called, so must be generating svrl. -->
 <!-- Can't be 1.5, 1.6 since iso_svrl being used. -->
 <!-- Mode is one from 1.5 1.6 iso -->
  <!-- If this file called, then must be generating svrl -->
 <xsl:variable name="svrlTest" select="true()" as='xs:boolean'/>


<xsl:template name="process-prolog">
   <axsl:output method="xml" omit-xml-declaration="no" standalone="yes"  indent="yes"/>
</xsl:template>


 <!-- Overrides skeleton.xsl -->
<xsl:template name="process-root">
  <xsl:param name="contents"/>
  <xsl:param name="id" />
  <xsl:param name="queryBinding" />
  <xsl:param name="title" />
  <!-- "Rich" parameters -->
  <xsl:param name="fpi" />
  <xsl:param name="icon" />
  <xsl:param name="lang" />
  <xsl:param name="see" />
  <xsl:param name="space" />
  <xsl:param name="schemaVersion" >xslt2</xsl:param>
   <svrl:schematron-output title="{$title}" schemaVersion="{$schemaVersion}">
     
     <xsl:if test=" string-length( $phase ) &gt; 0 and not( $phase = '#ALL') ">
       <axsl:attribute name="phase"><xsl:value-of select=" $phase " /></axsl:attribute>
     </xsl:if>
     <xsl:apply-templates mode="do-schema-p"   />
     <xsl:copy-of select="$contents" />
   </svrl:schematron-output>
</xsl:template>

<xsl:template name="process-assert">
  <xsl:param name="test"/>
  <xsl:param name="diagnostics" />
  <xsl:param name="id" />
  <xsl:param name="flag" />
 <!-- Added, DP -->
 <!-- "Linkable" parameters -->
 <xsl:param name="role"/>
 <xsl:param name="subject"/>

<!-- Added, DP -->
 <!-- "Rich" parameters -->
 <xsl:param name="fpi" />
 <xsl:param name="icon" />
 <xsl:param name="lang" />
 <xsl:param name="see" />
 <xsl:param name="space" />
 
 <svrl:failed-assert  test="{$test}" >
   <xsl:if test="string-length( $id ) &gt; 0">
     <axsl:attribute name="id"><xsl:value-of select=" $id " /></axsl:attribute>
   </xsl:if>
   <xsl:if test=" $generate-paths = 'true' ">
     <axsl:attribute name="location"><axsl:apply-templates
     select="." mode="schematron-get-full-path"/></axsl:attribute>
   </xsl:if>
   <xsl:if test=" string-length( $flag ) &gt; 0">
     <axsl:attribute name="flag"><xsl:value-of select=" $flag " /></axsl:attribute>
   </xsl:if>
   
   <!-- Process rich attributes.  -->
   <xsl:call-template name="richParms">
     <xsl:with-param name="fpi" select="$fpi"/>
     <xsl:with-param name="icon" select="$icon"/>
     <xsl:with-param name="lang" select="$lang"/>
     <xsl:with-param name="see" select="$see" />
     <xsl:with-param name="space" select="$space" />   
   </xsl:call-template>
   
   <xsl:call-template name='linkableParms'>
     <xsl:with-param name="role" select="$role" />
     <xsl:with-param name="subject" select="$subject"/>
   </xsl:call-template>
   
   <svrl:text><xsl:apply-templates mode="text" /></svrl:text>
   
   <xsl:if test="($diagnose = 'yes' or $diagnose='true') and @diagnostics">
     <xsl:call-template name="diagnosticsSplit">
         <xsl:with-param name="str" select="$diagnostics"/>
       </xsl:call-template>
     </xsl:if>
 </svrl:failed-assert>
</xsl:template>


<xsl:template name="process-report">
  <xsl:param name="id"/>
  <xsl:param name="test"/>
  <xsl:param name="diagnostics"/>
  <xsl:param name="flag" />

 <!-- "Linkable" parameters -->
 <xsl:param name="role"/>
 <xsl:param name="subject"/>
 <!-- "Rich" parameters -->
 <xsl:param name="fpi" />
 <xsl:param name="icon" />
 <xsl:param name="lang" />
 <xsl:param name="see" />
 <xsl:param name="space" />

    <svrl:successful-report test="{$test}" >
      <xsl:if test=" string-length( $id ) &gt; 0">
        <axsl:attribute name="id"><xsl:value-of select=" $id " /></axsl:attribute>
      </xsl:if>

      <!-- Process rich attributes.  -->
      <xsl:call-template name="richParms">
        <xsl:with-param name="fpi" select="$fpi"/>
        <xsl:with-param name="icon" select="$icon"/>
        <xsl:with-param name="lang" select="$lang"/>
        <xsl:with-param name="see" select="$see" />
        <xsl:with-param name="space" select="$space" />   
      </xsl:call-template>
      <!-- Process Linkable parameters -->
      <xsl:call-template name='linkableParms'>
         <xsl:with-param name="role" select="$role" />
         <xsl:with-param name="subject" select="$subject"/>
       </xsl:call-template>

       <xsl:if test=" string-length( $flag ) &gt; 0">
         <axsl:attribute name="flag"><xsl:value-of select=" $flag " /></axsl:attribute>
       </xsl:if>
       
  
      <xsl:if test=" $generate-paths = 'true' ">
        <axsl:attribute name="location"><axsl:apply-templates
        select="." mode="schematron-get-full-path"/></axsl:attribute>
      </xsl:if>
    
      <xsl:if test="($diagnose = 'yes' or $diagnose='true') and $diagnostics">
        <xsl:choose>
          <xsl:when test="string($diagnostics)">
              <xsl:call-template name="diagnosticsSplit">
          <xsl:with-param name="str" select="$diagnostics"/>
        </xsl:call-template>
          </xsl:when>
          <xsl:otherwise>
            <xsl:message terminate="yes">
              Diagnostics called up with no value.
              <xsl:value-of select="name()"/>
            </xsl:message>
          </xsl:otherwise>
        </xsl:choose>
      
      </xsl:if>
      <svrl:text><xsl:apply-templates mode="text" /></svrl:text>
    </svrl:successful-report>
  </xsl:template>


<!-- PROCESS-DIAGNOSTIC  -->
<xsl:template name="process-diagnostic">
  <xsl:param name="id"/>
  <!-- Rich parameters -->
  <xsl:param name="fpi" />
  <xsl:param name="icon" />
  <xsl:param name="lang" />
  <xsl:param name="see" />
  <xsl:param name="space" />



  <svrl:diagnostic-reference diagnostic="{$id}" >
    <xsl:call-template name="richParms">
      <xsl:with-param name="fpi" select="$fpi"/>
      <xsl:with-param name="icon" select="$icon"/>
      <xsl:with-param name="lang" select="$lang"/>
      <xsl:with-param name="see" select="$see" />
      <xsl:with-param name="space" select="$space" />   
    </xsl:call-template>
      <svrl:text><xsl:apply-templates mode="text"/></svrl:text>
  </svrl:diagnostic-reference>
 </xsl:template>

<xsl:template name="process-rule">
  <xsl:param name="context" />
  
  <xsl:param name="id" />
  <xsl:param name="flag" />
  
  <!-- "Linkable" parameters -->
  <xsl:param name="role"/>
  <xsl:param name="subject"/>
  
  <!-- "Rich" parameters -->
  <xsl:param name="fpi" />
  <xsl:param name="icon" />
  <xsl:param name="lang" />
  <xsl:param name="see" />
  <xsl:param name="space" />

  <svrl:fired-rule context="{$context}" >
    <!--
Generates multiple identical id values.
    <xsl:if test=" string-length( $id ) &gt; 0">
      <xsl:attribute name="id"><xsl:value-of select=" $id " /></xsl:attribute>
    </xsl:if>
    -->
    <axsl:attribute name="location"><axsl:apply-templates
     select="." mode="schematron-get-full-path"/></axsl:attribute>
    <xsl:if test=" string-length( $role ) &gt; 0">
      <xsl:attribute name="role"><xsl:value-of select=" $role " /></xsl:attribute>
    </xsl:if>

  </svrl:fired-rule>
  </xsl:template>


<xsl:template name="process-ns">
     <xsl:param name="prefix"/>
	<xsl:param name="uri"/>
        <svrl:ns-prefix-in-attribute-values uri="{$uri}" prefix="{$prefix}" />
</xsl:template>

 <!-- Overrides skeleton  -->
 <xsl:template name="process-title" >
     <svrl:title><xsl:apply-templates mode="text"/></svrl:title>
   </xsl:template>

 <!-- Added to compensate for moded call from process-pattern -->
 <xsl:template match="iso:title" mode="do-pattern-p">
   <xsl:call-template name="process-title"/>
 </xsl:template>



<xsl:template name="process-p">
  <xsl:param name="id" />
  <xsl:param name="class" />
  <xsl:param name="icon" />
  <xsl:param name="lang" />
  <!-- params: pattern, role -->
  <svrl:text><xsl:apply-templates mode="text"/></svrl:text>
</xsl:template>

<xsl:template name="process-pattern">
     <xsl:param name="name"/>
     <xsl:param name="role"/>
     <xsl:param name="id"/> 
     <xsl:param name="is-a"/>
 <!-- Added, DP -->
 <!-- "Rich" parameters -->
 <xsl:param name="fpi" />
 <xsl:param name="icon" />
 <xsl:param name="lang" />
 <xsl:param name="see" />
 <xsl:param name="space" />

  <svrl:active-pattern >
   <xsl:if test=" string( $id )">
       <axsl:attribute name="id"><xsl:value-of select=" $id " /></axsl:attribute>
     </xsl:if>
     <xsl:if test=" string( $name )">
       <axsl:attribute name="name"><xsl:value-of select=" $name " /></axsl:attribute>
     </xsl:if>
  
    <xsl:call-template name='linkableParms'>
         <xsl:with-param name="role" select="$role" />
         <xsl:with-param name="subject" select="''"/>
    </xsl:call-template>

    <xsl:call-template name='richParms'>
  <xsl:with-param name="fpi" select="$fpi"/>
  <xsl:with-param name="icon" select="$icon"/>
  <xsl:with-param name="lang" select="$lang"/>
  <xsl:with-param name="see" select="$see" />
  <xsl:with-param name="space" select="$space" />      
    </xsl:call-template>


 <!-- this screws up iso:title processing  -->
    <xsl:apply-templates mode="do-pattern-p"/>
 <!-- Seems that this apply-templates is never triggered DP -->
 <!-- <axsl:apply-templates select="/" mode="M{count(preceding-sibling::*)}"/> -->
    <axsl:apply-templates />
    </svrl:active-pattern>
</xsl:template>


 <!-- DP  addition for processing rich parameters. -->
 <xsl:template name='richParms'>
 <!-- "Rich" parameters -->
 <xsl:param name="fpi" />
 <xsl:param name="icon" />
 <xsl:param name="lang" />
 <xsl:param name="see" />
 <xsl:param name="space" />

 <!-- Process rich attributes.  -->
   <xsl:if test="string($see)">
     <axsl:attribute name="see"><xsl:value-of select="$see"/></axsl:attribute>
   </xsl:if>
   <xsl:if test="string($icon)">
     <axsl:attribute name="icon"><xsl:value-of select="$icon"/></axsl:attribute>
   </xsl:if>
   <xsl:if test="string($fpi)">
     <axsl:attribute name="fpi"><xsl:value-of select="$fpi"/></axsl:attribute>
   </xsl:if>
   <xsl:if test="string($space)">
     <axsl:attribute name="xml:space"><xsl:value-of select="$space"/></axsl:attribute>
   </xsl:if>
   <xsl:if test="string($lang)">
     <axsl:attribute name="xml:lang"><xsl:value-of select="$lang"/></axsl:attribute>
   </xsl:if>
 </xsl:template>


 <!-- DP  addition for processing linkable parameters. -->
 <xsl:template name='linkableParms'>
     <xsl:param name="role"/>
     <xsl:param name="subject"/> 

     <xsl:if test=" string($role )">
       <axsl:attribute name="role"><xsl:value-of select=" $role " /></axsl:attribute>
     </xsl:if>
     <xsl:if test=" string( $subject )">
       <axsl:attribute name="subject"><xsl:value-of select=" $subject " /></axsl:attribute>
     </xsl:if>
   </xsl:template>


 <!-- DP addition, process span -->
 <xsl:template name="process-span" >
   <xsl:param name="class" />
     <svrl:span class="{$class}">
     <xsl:apply-templates mode="inline-text"/>
   </svrl:span>
   </xsl:template>


 <!-- DP addition -->
 <xsl:template name="process-emph">
   <svrl:emph><xsl:apply-templates mode="inline-text"/></svrl:emph>
 </xsl:template>



 <!-- DP Overrides skeleton -->
 <xsl:template name="process-dir">
   <xsl:param name="value" />
     <svrl:dir value='{$value}'>
   <xsl:apply-templates mode="inline-text"/>
 </svrl:dir>
 </xsl:template>

 <!-- DP Overrides skeleton -->
 <xsl:template name="process-name">
   <xsl:param name="name"/>
  
   <svrl:name> <axsl:value-of select="{$name}"/> </svrl:name>
 </xsl:template>

  
 <!-- DP Overrides skeleton -->
<!-- @FIXME. Action?? -->
 <xsl:template name="process-message">
   <xsl:param name="pattern" />
   <xsl:param name="role" />
 </xsl:template>

</xsl:stylesheet>

