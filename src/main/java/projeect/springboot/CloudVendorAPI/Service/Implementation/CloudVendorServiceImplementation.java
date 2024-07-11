package projeect.springboot.CloudVendorAPI.Service.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projeect.springboot.CloudVendorAPI.Entity.CloudVendor;
import projeect.springboot.CloudVendorAPI.Exceptions.CloudVendorException;
import projeect.springboot.CloudVendorAPI.Exceptions.CloudVendorNotFoundException;
import projeect.springboot.CloudVendorAPI.Repository.CloudVendorRepository;
import projeect.springboot.CloudVendorAPI.Service.Abstract.CloudVendorService;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CloudVendorServiceImplementation implements CloudVendorService {


    private final CloudVendorRepository repository;

    @Override
    public List<CloudVendor> getCloudVendorList() {
        return repository.findAll();
    }

    @Override
    public CloudVendor getCloudVendorById(String id) throws CloudVendorNotFoundException {
        return repository.findById(id).orElseThrow(()->new CloudVendorNotFoundException("Static object not available"));
    }

    @Override
    public CloudVendor createCloudVendor(CloudVendor cloudVendor) {
        return repository.save(cloudVendor);
    }

    @Override
    public CloudVendor updateCloudVendor(CloudVendor cloudVendor,String id) throws CloudVendorNotFoundException {
        CloudVendor targetVendor=repository.findById(id).orElseThrow(()->new CloudVendorNotFoundException("Static object not available"));
        targetVendor.setVendorName(cloudVendor.getVendorName());
        targetVendor.setVendorAddress(cloudVendor.getVendorAddress());
        targetVendor.setVendorPhone(cloudVendor.getVendorPhone());
        return repository.save(targetVendor);
    }

    @Override
    public void deleteCloudVendor(String id) throws CloudVendorNotFoundException {

        CloudVendor targetVendor=repository.findById(id).orElseThrow(()->new CloudVendorNotFoundException("Static object not available"));

        repository.deleteById(id);
    }

    @Override
    public List<CloudVendor> getCloudVendorByName(String name) {
        List<CloudVendor> list=repository.getAllByVendorName(name);
        return list;
    }
}
