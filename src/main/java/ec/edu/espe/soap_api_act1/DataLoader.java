package ec.edu.espe.soap_api_act1;

import ec.edu.espe.soap_api_act1.models.Package; 
import ec.edu.espe.soap_api_act1.models.TrackingEvent; 
import ec.edu.espe.soap_api_act1.repository.PackageRepository; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner initDatabase(PackageRepository repository) {
        return args -> {

            List<TrackingEvent> history1 = new ArrayList<>();
            history1.add(new TrackingEvent(LocalDateTime.of(2025, 4, 5, 10, 0, 0), "Paquete recibido en bodega central", "Lima"));
            history1.add(new TrackingEvent(LocalDateTime.of(2025, 4, 7, 14, 30, 0), "Salida hacia Lima", "Arequipa"));
            history1.add(new TrackingEvent(LocalDateTime.of(2025, 4, 10, 8, 15, 0), "En tránsito a destino", "Cajamarca"));

            Package pkg1 = new Package(
                    "PE1234567890",
                    "Juan Pérez",
                    "Ana Gómez",
                    "Arequipa",
                    "Lima",
                    2.5,
                    "20x15x10 cm",
                    "En tránsito",
                    "Cajamarca - Perú",
                    LocalDate.of(2025, 4, 15),
                    history1
            );
            repository.save(pkg1);

            // ... (el resto de tus paquetes de prueba) ...
            List<TrackingEvent> history2 = new ArrayList<>();
            history2.add(new TrackingEvent(LocalDateTime.of(2025, 3, 10, 9, 0, 0), "Paquete recibido en origen", "Quito"));
            history2.add(new TrackingEvent(LocalDateTime.of(2025, 3, 15, 11, 0, 0), "En ruta a destino", "Ambato"));
            history2.add(new TrackingEvent(LocalDateTime.of(2025, 3, 20, 16, 0, 0), "Entregado al destinatario", "Guayaquil"));

            Package pkg2 = new Package(
                    "EC9876543210",
                    "María López",
                    "Carlos Sánchez",
                    "Quito",
                    "Guayaquil",
                    1.0,
                    "10x10x10 cm",
                    "Entregado",
                    "Guayaquil - Ecuador",
                    LocalDate.of(2025, 3, 20),
                    history2
            );
            repository.save(pkg2);

            // Paquete 3 (sin fecha estimada de entrega, para probar el campo opcional)
            List<TrackingEvent> history3 = new ArrayList<>();
            history3.add(new TrackingEvent(LocalDateTime.of(2025, 5, 1, 9, 0, 0), "Paquete en aduana", "Bogotá"));

            Package pkg3 = new Package(
                    "CO1122334455",
                    "Pedro Ramírez",
                    "Laura Vega",
                    "Medellín",
                    "Bogotá",
                    5.0,
                    "30x20x20 cm",
                    "En aduana",
                    "Bogotá - Colombia",
                    null, // Fecha estimada de entrega nula
                    history3
            );
            repository.save(pkg3);
            System.out.println("Datos de paquetes cargados en H2 Database.");
        };
    }
}