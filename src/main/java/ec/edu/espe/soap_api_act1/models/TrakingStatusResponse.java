package ec.edu.espe.soap_api_act1.models;

import java.sql.Date;
import java.util.List;

public class TrakingStatusResponse {
    private String status;
    private String currentLocation;
    private Date estimatedDeliveryDate;
    private List<TrackingEvent> history;
}
