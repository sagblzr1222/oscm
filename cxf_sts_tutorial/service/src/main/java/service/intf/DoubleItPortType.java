package service.intf;

import javax.ejb.Remote;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Remote
@WebService(targetNamespace = "http://www.example.org/contract/DoubleIt")
public interface DoubleItPortType {

    @WebMethod
    int doubleIt(@WebParam(name = "numberToDouble") int numberToDouble);
}
