package fr.sncf.d2d.up2dev.tortycolis.packages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class CreatePackageUseCase {
    public  CreatePackageRequestBody create  (CreatePackageRequestBody createPackageRequestBody){
    // System.out.println("je suis dans le service");
    ObjectMapper packageMapper = new ObjectMapper();
    // System.out.println("package dans service" + packageMapper);

    TypeReference<List<CreatePackageRequestBody>> createListPackageRequestBody = new TypeReference<List<CreatePackageRequestBody>>() {};

    // System.out.println("creeateListPackage dans service" + createListPackageRequestBody);
    InputStream stream = TypeReference.class.getResourceAsStream("/data.json");
    // System.out.println("stream ds service" + stream);


try{
   
    // CreatePackageRequestBody bodyObject = new CreatePackageRequestBody();
    List<CreatePackageRequestBody> packageList = packageMapper.readValue(stream, createListPackageRequestBody);
    // System.out.println("list: " + packageList);
  
    packageList.add(createPackageRequestBody);
    // System.out.println("package list apres sauvegarde: " + packageList);
    String jsonString = packageMapper.writeValueAsString(packageList);

try{
    File ressource = new ClassPathResource("data.json").getFile();
    // System.out.println("ressource: " + ressource);
   
   

    FileWriter fileWriter = new FileWriter(ressource);
    fileWriter.write(jsonString);
    fileWriter.close();}catch(IOException e)
    {
    e.printStackTrace();
    }

    // System.out.println("json string: " + jsonString);
   
  
}catch(Exception e){
    System.out.println(e.getMessage());
}


        return createPackageRequestBody; 
        //créer objet User
    }
}
