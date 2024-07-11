package projeect.springboot.CloudVendorAPI.Exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@RequiredArgsConstructor
public class CloudVendorException{


    private final String message;

    private final Throwable cause;

    private final HttpStatus httpStatus;


}
