/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2018
 *                                                                                                                                 
 *  Creation Date: Jan 30, 2015                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.apiversioning.adapter;

import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.oscm.apiversioning.upgrade.info.ModificationDetail;

/**
 * @author qiu
 * 
 */
public interface IAdapter {
    public void exec(SOAPMessageContext soapMessageContext,
            ModificationDetail detail) throws SOAPException;
}
