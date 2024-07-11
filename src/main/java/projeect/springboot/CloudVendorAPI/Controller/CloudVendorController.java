package projeect.springboot.CloudVendorAPI.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeect.springboot.CloudVendorAPI.Entity.CloudVendor;
import projeect.springboot.CloudVendorAPI.Exceptions.CloudVendorNotFoundException;
import projeect.springboot.CloudVendorAPI.Response.ResponseHandler;
import projeect.springboot.CloudVendorAPI.Service.Abstract.CloudVendorService;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
@Slf4j
@RequiredArgsConstructor
public class CloudVendorController {

    private final CloudVendorService service;

    @GetMapping("/all")
    public ResponseEntity<Object> allVendors(){
        List<CloudVendor> list=service.getCloudVendorList();
        log.debug("List of all vendors{}",list);
        return ResponseHandler.responseBuilder("List of all vendors", HttpStatus.OK,list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVendor(@PathVariable("id") String id) throws CloudVendorNotFoundException {
        CloudVendor cloudVendor=service.getCloudVendorById(id);
        log.debug("Vendor of id {} is {}",id,cloudVendor);
        return ResponseHandler.responseBuilder("Vendor of id "+id,HttpStatus.OK,cloudVendor);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveVendor(@RequestBody CloudVendor cloudVendor){

        CloudVendor cv=service.createCloudVendor(cloudVendor);
        log.debug("Vendor added {}",cv);
        return ResponseHandler.responseBuilder("Vendor added",HttpStatus.CREATED,cv);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVendor(@PathVariable("id") String id, @RequestBody CloudVendor cloudVendor) throws CloudVendorNotFoundException {
        CloudVendor updatedVendor=service.updateCloudVendor(cloudVendor,id);
        log.debug("Vendor updated {}",updatedVendor);
        return ResponseHandler.responseBuilder("Vendor updated",HttpStatus.ACCEPTED,updatedVendor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVendor(@PathVariable("id") String id) throws CloudVendorNotFoundException {
        service.deleteCloudVendor(id);
        log.debug("Vendor deleted {}",id);
        return ResponseHandler.responseBuilder("Vendor deleted",HttpStatus.OK,id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getVendorByName(@PathVariable("name") String name){
        List<CloudVendor> cloudVendors=service.getCloudVendorByName(name);
        log.debug("Vendor of name {} is {}",name,cloudVendors);
        return ResponseHandler.responseBuilder("Vendor of name "+name,HttpStatus.OK,cloudVendors);
    }

}
