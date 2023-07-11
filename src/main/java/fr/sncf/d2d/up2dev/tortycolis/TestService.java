package fr.sncf.d2d.up2dev.tortycolis;

import org.springframework.stereotype.Service;

//@Service
public class TestService {

   
public String sayHello(String name){
    return String.format("hello %s", name);
}
    
}
