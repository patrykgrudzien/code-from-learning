<?xml version="1.0" encoding="utf-8"?>
<xsl:styleseet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body style="font-family:Arial;font-size:12pt;background-color:#EEEEEE">
                <xsl:for-each select="sniadanie_menu/jedzenie">
                    <div style="background-color:teal;color:white;padding:4px">
                        <span style="font-weight:bold"><xsl:value-of select="nazwa"/></span>
                        <xsl:value-of select="cena"/>
                    </div>
                    <div style="margin-left:20px;margin-bottom:1em;font-size:10pt">
                        <p><xsl:value-of select="opis"/>.
                            <span style="font-style:italic">
                                <xsl:value-of select="kalorie"/> (kcal porcja)
                            </span>.</p>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:styleseet>