/*
 * Copyright (c) 2002-2022, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.rest.util.xml;

import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.xml.XmlUtil;

/**
 * Xml Response Util
 */
public final class XMLUtil
{
    private static final String TAG_ERROR = "error";
    private static final String TAG_MESSAGE = "error-message";
    private static final String TAG_CODE = "error-code";
    private static String _strHeader = AppPropertiesService.getProperty( XmlUtil.PROPERTIES_XML_HEADER );

    /**
     * Private constructor
     */
    private XMLUtil( )
    {
    }

    /**
     * Format an error response
     * 
     * @param strMessage
     *            The message
     * @param nCode
     *            The error code
     * @return An XML response
     */
    public static String formatError( String strMessage, int nCode )
    {
        StringBuffer sbXMl = new StringBuffer( _strHeader );
        XmlUtil.beginElement( sbXMl, TAG_ERROR );
        XmlUtil.addElement( sbXMl, TAG_MESSAGE, strMessage );
        XmlUtil.addElement( sbXMl, TAG_CODE, "" + nCode );
        XmlUtil.endElement( sbXMl, TAG_ERROR );

        return sbXMl.toString( );
    }
}
