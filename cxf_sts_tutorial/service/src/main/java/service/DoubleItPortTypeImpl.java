package service;

import javax.jws.WebService;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import service.intf.DoubleItPortType;

@WebService(targetNamespace = "http://www.example.org/contract/DoubleIt", portName = "DoubleItPort", serviceName = "DoubleItService", endpointInterface = "service.intf.DoubleItPortType", wsdlLocation = "WEB-INF/wsdl/DoubleIt.wsdl")
@EndpointProperties(value = {
        @EndpointProperty(key = "ws-security.signature.properties", value = "serviceKeystore.properties"),
        @EndpointProperty(key = "ws-security.callback-handler", value = "service.ServiceKeystorePasswordCallback") })
public class DoubleItPortTypeImpl implements DoubleItPortType {

    public int doubleIt(int numberToDouble) {
        return numberToDouble * 2;
    }
}
