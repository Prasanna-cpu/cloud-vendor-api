package projeect.springboot.CloudVendorAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeect.springboot.CloudVendorAPI.Entity.CloudVendor;

import java.awt.*;
import java.util.List;


@Repository
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    List<CloudVendor> getAllByVendorName(String vendorName);
}
