/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.transport.netty.config;

import org.mule.config.spring.handlers.AbstractMuleNamespaceHandler;
import org.mule.transport.netty.NettyConnector;
import org.mule.endpoint.URIBuilder;

/**
 * Registers a Bean Definition Parser for handling <code>&lt;netty:connector&gt;</code> elements
 * and supporting endpoint elements.
 */
public class NettyNamespaceHandler extends AbstractMuleNamespaceHandler
{
    public void init()
    {
        /* This creates handlers for 'endpoint', 'outbound-endpoint' and 'inbound-endpoint' elements.
           The defaults are sufficient unless you have endpoint styles different from the Mule standard ones
           The URIBuilder as constants for common required attributes, but you can also pass in a user-defined String[].
         */
        registerStandardTransportEndpoints("netty", URIBuilder.PATH_ATTRIBUTES);

        /* This will create the handler for your custom 'connector' element.  You will need to add handlers for any other
           xml elements you define.  For more information see:
           http://www.mulesoft.org/documentation/display/MULE3USER/Creating+a+Custom+XML+Namespace
        */
        registerConnectorDefinitionParser(NettyConnector.class);
    }
}
