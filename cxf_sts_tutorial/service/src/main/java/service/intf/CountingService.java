package service.intf;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Remote
@WebService(targetNamespace = "http://oscm.org/xsd")
public interface CountingService {

    @WebMethod
    int sum(@WebParam(name = "paramA") int paramA, @WebParam(name = "paramB") int paramB);

}
