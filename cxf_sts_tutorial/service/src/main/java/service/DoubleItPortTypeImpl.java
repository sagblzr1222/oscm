package service;

import javax.jws.WebService;

import service.intf.DoubleItPortType;

@WebService(targetNamespace = "http://www.example.org/contract/DoubleIt", 
            portName="DoubleItPort",
            serviceName="DoubleItService", 
            endpointInterface="service.intf.DoubleItPortType",
            wsdlLocation = "WEB-INF/wsdl/DoubleIt.wsdl")
public class DoubleItPortTypeImpl implements DoubleItPortType {

    public int doubleIt(int numberToDouble) {
        return numberToDouble * 2;
    }
}
