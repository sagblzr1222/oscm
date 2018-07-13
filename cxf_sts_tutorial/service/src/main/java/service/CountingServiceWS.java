package service;

import service.intf.CountingService;

import javax.jws.WebService;

@WebService(name = "CountingService",
            serviceName = "CountingService",
            targetNamespace = "http://oscm.org/xsd",
            endpointInterface = "service.intf.CountingService",
            wsdlLocation = "WEB-INF/wsdl/CountingService.wsdl")
public class CountingServiceWS implements CountingService {

    @Override
    public int sum(int paramA, int paramB) {
        return paramA + paramB;
    }
}
