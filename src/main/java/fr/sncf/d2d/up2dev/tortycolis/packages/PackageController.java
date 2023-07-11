package fr.sncf.d2d.up2dev.tortycolis.packages;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController("/packages")
public class PackageController {
    

    private final CreatePackageUseCase createPackageUseCase;

    public PackageController(CreatePackageUseCase createPackageUseCase){
        this.createPackageUseCase = createPackageUseCase;
    }
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping("/packages")
    public CreatePackageRequestBody create(@RequestBody CreatePackageRequestBody body){
        System.out.println("body: " +  body);
        return this.createPackageUseCase.create(body);
      
    }

}
