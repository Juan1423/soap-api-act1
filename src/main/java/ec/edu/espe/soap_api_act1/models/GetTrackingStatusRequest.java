package ec.edu.espe.soap_api_act1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trackingNumber"
})
@XmlRootElement(name = "GetTrackingStatusRequest", namespace = "http://miservicio.tracking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTrackingStatusRequest { 

    @XmlElement(required = true, namespace = "http://miservicio.tracking")
    protected String trackingNumber;
}