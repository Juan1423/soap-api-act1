package ec.edu.espe.soap_api_act1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.espe.soap_api_act1.models.Package;

public interface PackageRepository extends JpaRepository<Package, String> {
    
    Optional<Package> findByTrackingNumber(String trackingNumber);

}
