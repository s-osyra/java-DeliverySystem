package com.so.DeliverySystem.integration_tests.Controller;

import com.so.DeliverySystem.repository.PackageRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest()
@AutoConfigureMockMvc
@DisplayName("On testing PackageController")
public class PackageControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private PackageRepo packageRepo;

   @Test
   @DisplayName("getall should return all packages")
   public void testGetAll()  throws Exception{
      mockMvc.perform(get("/package/getall")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
   }

   @Test
   @DisplayName("getPackage should read package")
   public void testNewPackage()  throws Exception{
      mockMvc.perform(get("/package/get/1")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
   }

}
