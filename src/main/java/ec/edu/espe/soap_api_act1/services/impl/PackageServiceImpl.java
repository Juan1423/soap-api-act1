package ec.edu.espe.soap_api_act1.services.impl;

import ec.edu.espe.soap_api_act1.exception.TrackingNotFoundException; 
import ec.edu.espe.soap_api_act1.models.Package; 
import ec.edu.espe.soap_api_act1.models.TrackingEvent; 
import ec.edu.espe.soap_api_act1.repository.PackageRepository; 
import ec.edu.espe.soap_api_act1.services.PackageService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz PackageService.
 * Contiene la lógica de negocio real.
 */
@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public Package getPackageStatus(String trackingNumber) {
        if (trackingNumber == null || trackingNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de seguimiento no puede ser nulo o vacío.");
        }

        Optional<Package> foundPackage = packageRepository.findByTrackingNumber(trackingNumber);

        if (foundPackage.isEmpty()) {
            throw new TrackingNotFoundException("El número de seguimiento '" + trackingNumber + "' no fue encontrado.");
        }

        Package pkg = foundPackage.get();

        // Simular historial si no está cargado (debido a @Transient en Package)
        // En un escenario real con DB, el historial se cargaría desde otra tabla via relación JPA.
        if (pkg.getHistory() == null || pkg.getHistory().isEmpty()) {
            List<TrackingEvent> simulatedHistory = new ArrayList<>();
            simulatedHistory.add(new TrackingEvent(LocalDateTime.now().minusDays(3), "Paquete recibido en centro logístico", "Centro A"));
            simulatedHistory.add(new TrackingEvent(LocalDateTime.now().minusDays(2), "En transporte a destino", "Ruta Principal"));
            simulatedHistory.add(new TrackingEvent(LocalDateTime.now().minusDays(1), "Llegó a centro de distribución local", pkg.getCurrentLocation()));
            pkg.setHistory(simulatedHistory);
        }

        return pkg;
    }
}