package projeect.springboot.CloudVendorAPI.Service.Abstract;


import projeect.springboot.CloudVendorAPI.Entity.CloudVendor;
import projeect.springboot.CloudVendorAPI.Exceptions.CloudVendorNotFoundException;

import java.util.List;

public interface CloudVendorService {

    public List<CloudVendor> getCloudVendorList();

    public CloudVendor getCloudVendorById(String id) throws CloudVendorNotFoundException;

    public CloudVendor createCloudVendor(CloudVendor cloudVendor);

    public CloudVendor updateCloudVendor(CloudVendor cloudVendor,String id) throws CloudVendorNotFoundException;

    public void deleteCloudVendor(String id) throws CloudVendorNotFoundException;

    public List<CloudVendor> getCloudVendorByName(String name);


}
