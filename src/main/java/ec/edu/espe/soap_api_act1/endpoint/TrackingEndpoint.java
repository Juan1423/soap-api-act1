package ec.edu.espe.soap_api_act1.endpoint; 

import ec.edu.espe.soap_api_act1.models.GetTrackingStatusRequest; 
import ec.edu.espe.soap_api_act1.models.GetTrackingStatusResponse; 
import ec.edu.espe.soap_api_act1.models.TrackingEvent; 
import ec.edu.espe.soap_api_act1.models.Package; 
import ec.edu.espe.soap_api_act1.services.PackageService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Endpoint de servicio web SOAP para la consulta del estado de paquetes.
 * Delega la lógica de negocio a PackageService y usa clases de contrato/modelo separadas.
 */
@Endpoint
public class TrackingEndpoint {

    private static final String NAMESPACE_URI = "http://miservicio.tracking";

    @Autowired
    private PackageService packageService; 

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTrackingStatusRequest")
    @ResponsePayload
    public JAXBElement<GetTrackingStatusResponse> getTrackingStatus(@RequestPayload JAXBElement<GetTrackingStatusRequest> requestElement) {
        String trackingNumber = requestElement.getValue().getTrackingNumber();

        // Llama al servicio de negocio
        Package pkg = packageService.getPackageStatus(trackingNumber);

        GetTrackingStatusResponse response = new GetTrackingStatusResponse();
        response.setStatus(pkg.getStatus());
        response.setCurrentLocation(pkg.getCurrentLocation());
        response.setEstimatedDeliveryDate(pkg.getEstimatedDeliveryDate());

        List<TrackingEvent> eventResponses = pkg.getHistory().stream()
                .map(event -> new TrackingEvent(event.getDate(), event.getDescription(), event.getLocation()))
                .collect(Collectors.toList());
        response.getHistory().addAll(eventResponses);

        return new JAXBElement<>(new QName(NAMESPACE_URI, "GetTrackingStatusResponse"), GetTrackingStatusResponse.class, response);
    }
}