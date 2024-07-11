package projeect.springboot.CloudVendorAPI.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="cloud_vendor")
public class CloudVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vendorId;

    @Column(name="vendor_name",nullable = false)
    private String vendorName;

    @Column(name = "vendor_address",nullable = false)
    private String vendorAddress;

    @Column(name = "vendor_phone",nullable = false,unique = true)
    private String vendorPhone;

}
