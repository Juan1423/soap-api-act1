package ec.edu.espe.soap_api_act1.models; // CAMBIO DE PAQUETE

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackingError", propOrder = {
    "errorCode",
    "errorMessage",
    "invalidField"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingError {

    @XmlElement(required = true, namespace = "http://miservicio.tracking")
    protected int errorCode;

    @XmlElement(required = true, namespace = "http://miservicio.tracking")
    protected String errorMessage;

    @XmlElement(namespace = "http://miservicio.tracking")
    protected String invalidField;
}