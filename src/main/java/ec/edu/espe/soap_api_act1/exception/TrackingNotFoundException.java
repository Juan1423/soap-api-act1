package ec.edu.espe.soap_api_act1.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * Excepción lanzada cuando un número de seguimiento no es encontrado.
 * Mapeada a un SOAP Fault de tipo CLIENT.
 */
@SoapFault(faultCode = FaultCode.CLIENT)
public class TrackingNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TrackingNotFoundException(String message) {
        super(message);
    }
}