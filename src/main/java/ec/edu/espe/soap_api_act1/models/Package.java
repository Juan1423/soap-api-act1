package ec.edu.espe.soap_api_act1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackingNumber;

    @Column(name= "sender_name", nullable = false)
    private String senderName;

    @Column(name= "receiver_name", nullable = false)
    private String receiverName;

    @Column(name= "origin", nullable = false)
    private String origin;

    @Column(name= "destination", nullable = false)
    private String destination;

    @Column(name= "weight", nullable = false)
    private String weight;

    @Column(name= "dimensions", nullable = false)
    private String dimensions;

    @Column(name= "status", nullable = false)
    private String status;

    @Column(name= "current_location", nullable = false)
    private String currentLocation;

    @Column(name= "estimated_delivery_date", nullable = false)
    private String estimatedDeliveryDate;

    @Column(name= "history", nullable = false)
    private List<TrackingEvent> history;



}
