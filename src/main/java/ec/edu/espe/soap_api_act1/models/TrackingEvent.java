package ec.edu.espe.soap_api_act1.models; // CAMBIO DE PAQUETE

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Transient; // Si este TrackingEvent se usa solo en el modelo, y no se persiste solo
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.time.LocalDateTime;

/**
 * Representa un evento de seguimiento. Se usa tanto en el modelo de dominio como en el contrato SOAP.
 * Si las estructuras fueran diferentes, se necesitarían dos clases TrackingEvent separadas.
 */
@XmlAccessorType(XmlAccessType.FIELD) // Necesario para JAXB para el contrato SOAP
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

    // Si TrackingEvent fuera una entidad JPA separada y se persistiera,
    // necesitaría un @Id y otras anotaciones JPA.
    // Como lo tenemos @Transient en Package y lo simulamos, esto es suficiente.
}