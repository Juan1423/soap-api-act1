package ec.edu.espe.soap_api_act1.models; // CAMBIO DE PAQUETE

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    @Id
    @Column(name = "tracking_number", unique = true, nullable = false)
    private String trackingNumber;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "weight_kg", nullable = false)
    private double weight;

    @Column(name = "dimensions", nullable = false)
    private String dimensions;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "current_location", nullable = false)
    private String currentLocation;

    @Column(name = "estimated_delivery_date")
    private LocalDate estimatedDeliveryDate;

    @Transient
    private List<TrackingEvent> history = new ArrayList<>(); // Usamos models.TrackingEvent aquí
}