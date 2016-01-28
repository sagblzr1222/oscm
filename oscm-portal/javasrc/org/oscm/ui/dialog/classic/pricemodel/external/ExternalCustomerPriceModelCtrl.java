/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2015                    
 *                                                                                                                                 
 *  Creation Date: 24.02.2015                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.ui.dialog.classic.pricemodel.external;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.oscm.billing.external.pricemodel.service.PriceModel;
import org.oscm.billing.external.pricemodel.service.PriceModelContent;
import org.oscm.internal.pricemodel.external.ExternalPriceModelException;
import org.oscm.internal.vo.VOOrganization;
import org.oscm.internal.vo.VOServiceDetails;


/**
 * @author iversen
 *
 */
@ManagedBean
@ViewScoped
public class ExternalCustomerPriceModelCtrl extends ExternalPriceModelCtrl {

    public String upload() {

        if (getPriceModelBean().isExternalServiceSelected()) {

            VOServiceDetails service = getPriceModelBean().getSelectedService();
            VOOrganization customer = getPriceModelBean().getCustomer()
                    .getVOOrganization();

            try {
                PriceModel priceModel = getExternalPriceModelService()
                        .getExternalPriceModelForCustomer(service, customer);

                if (priceModel == null) {
                    addMessage(null, FacesMessage.SEVERITY_ERROR,
                            ERROR_EXTERNAL_PRICEMODEL_NOT_AVAILABLE);
                } else {
                    loadPriceModelContent(priceModel);
                    addMessage(null, FacesMessage.SEVERITY_INFO,
                            INFO_EXTERNAL_PRICE_UPLOADED);
                }
            } catch (ExternalPriceModelException e) {
                addMessage(null, FacesMessage.SEVERITY_ERROR,
                        ERROR_EXTERNAL_PRICEMODEL_NOT_AVAILABLE);
            }
        }
        return "";
    }

    public String display() throws IOException {

        PriceModelContent priceModelContent = getModel()
                .getSelectedPriceModelContent();

        if (priceModelContent == null) {
            addMessage(null, FacesMessage.SEVERITY_ERROR,
                    ERROR_EXTERNAL_PRICEMODEL_NOT_AVAILABLE);
            return "";
        }

        ExternalPriceModelDisplayHandler displayHandler = new ExternalPriceModelDisplayHandler();
        displayHandler.setContent(priceModelContent.getContent());
        displayHandler.setContentType(priceModelContent.getContentType());
        displayHandler.setFilename(priceModelContent.getFilename());
        displayHandler.display();
        return null;

    }
}
