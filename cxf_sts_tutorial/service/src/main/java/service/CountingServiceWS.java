package service;

import service.intf.CountingService;

import javax.jws.WebService;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;

@WebService(name = "CountingService",
            serviceName = "CountingService",
            targetNamespace = "http://oscm.org/xsd",
            endpointInterface = "service.intf.CountingService",
            wsdlLocation = "WEB-INF/wsdl/CountingService.wsdl")
@EndpointProperties(value = {
        @EndpointProperty(key = "ws-security.signature.properties", value = "serviceKeystore.properties"),
        @EndpointProperty(key = "ws-security.callback-handler", value = "service.ServiceKeystorePasswordCallback") })
public class CountingServiceWS implements CountingService {

    @Override
    public int sum(int paramA, int paramB) {
        return paramA + paramB;
    }
}
