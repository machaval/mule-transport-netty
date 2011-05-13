/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.netty.transformers;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractDiscoverableTransformer;

import java.io.UnsupportedEncodingException;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class ObjectToChannelBufferTransformer extends AbstractDiscoverableTransformer
{

    @Override
    protected ChannelBuffer doTransform(Object src, String enc) throws TransformerException
    {
        try
        {
            if (src instanceof String)
            {
                final byte[] data = ((String) src).getBytes(enc);
                return ChannelBuffers.wrappedBuffer(data);
            }
            else if (src instanceof byte[])
            {
                return ChannelBuffers.wrappedBuffer((byte[]) src);
            }

            throw new UnsupportedOperationException(src.getClass().getName());
        }
        catch (UnsupportedEncodingException e)
        {
            throw new TransformerException(this, e);
        }
    }
}
