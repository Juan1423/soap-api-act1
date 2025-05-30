package ec.edu.espe.soap_api_act1.models; 

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "currentLocation",
    "estimatedDeliveryDate",
    "history"
})
@XmlRootElement(name = "GetTrackingStatusResponse", namespace = "http://miservicio.tracking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTrackingStatusResponse { // RENOMBRADA

    @XmlElement(required = true, namespace = "http://miservicio.tracking")
    protected String status;

    @XmlElement(required = true, namespace = "http://miservicio.tracking")
    protected String currentLocation;

    @XmlElement(namespace = "http://miservicio.tracking")
    protected LocalDate estimatedDeliveryDate;

    // Aquí usamos el TrackingEvent del mismo paquete `models` para la respuesta
    @XmlElement(name = "history", namespace = "http://miservicio.tracking")
    protected List<TrackingEvent> history = new ArrayList<>();
}