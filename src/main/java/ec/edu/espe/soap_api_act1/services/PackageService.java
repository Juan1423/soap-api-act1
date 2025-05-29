package ec.edu.espe.soap_api_act1.services;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


@WebService(name = "PackageService")
public interface PackageService {
    
    @WebMethod
    List<Package> getAllPackages();

    Package getPackageByTrackingNumber(Long trackingNumber);

}
