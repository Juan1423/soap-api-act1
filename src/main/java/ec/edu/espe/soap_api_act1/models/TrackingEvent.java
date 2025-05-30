package ec.edu.espe.soap_api_act1.models; // CAMBIO DE PAQUETE

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.time.LocalDateTime;


@XmlAccessorType(XmlAccessType.FIELD) 
@XmlType(name = "TrackingEvent", propOrder = {
    "date",
    "description",
    "location"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingEvent {

    @XmlElement(required = true, namespace = "http://miservicio.tracking") // Para el contrato SOAP
    private LocalDateTime date;

    @XmlElement(required = true, namespace = "http://miservicio.tracking") // Para el contrato SOAP
    private String description;

    @XmlElement(required = true, namespace = "http://miservicio.tracking") // Para el contrato SOAP
    private String location;

}