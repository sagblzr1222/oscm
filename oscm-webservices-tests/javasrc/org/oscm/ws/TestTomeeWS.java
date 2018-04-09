/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2018                                           
 *                                                                                                                                 
 *  Creation Date: 26.03.2018                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.ws;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.oscm.internal.intf.OperatorService;
import org.oscm.intf.AccountService;
import org.oscm.vo.VOPaymentType;
import org.oscm.ws.base.ServiceFactory;


/**
 * @author KowalczykA
 *
 */
public class TestTomeeWS {
    
    @Test
    public void testConnection() throws Exception{
        
        AccountService accountService = ServiceFactory.getDefault().getAccountService("1000", "admin123");
        Set<VOPaymentType> paymentTypes = accountService.getAvailablePaymentTypes();
        
        paymentTypes.forEach(paymentType->System.out.println(paymentType.getName()));
        
        OperatorService operatorService = ServiceFactory.getDefault().getOperatorService("1000", "admin123");
        Map<String, String> logOperations = operatorService.getAvailableAuditLogOperations();
        System.out.println(logOperations);
    }
    
}
