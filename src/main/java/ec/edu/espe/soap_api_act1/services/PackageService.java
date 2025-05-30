package ec.edu.espe.soap_api_act1.services; 

import ec.edu.espe.soap_api_act1.models.Package; 

/**
 * Interfaz que define las operaciones de negocio relacionadas con los paquetes.
 */
public interface PackageService {

    Package getPackageStatus(String trackingNumber);

}