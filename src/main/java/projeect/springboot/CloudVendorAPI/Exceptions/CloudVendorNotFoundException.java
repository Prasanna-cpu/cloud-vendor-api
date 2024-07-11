package projeect.springboot.CloudVendorAPI.Exceptions;

public class CloudVendorNotFoundException extends Exception{

    public CloudVendorNotFoundException(String message){
        super(message);
    }

    public CloudVendorNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public CloudVendorNotFoundException(Throwable cause){
        super(cause);
    }

    public CloudVendorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }




}
