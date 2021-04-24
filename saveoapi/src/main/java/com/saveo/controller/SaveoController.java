package com.saveo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.saveo.UploadCSV;
import com.saveo.model.SaveoModel;
import com.saveo.model.SaveoOrderModel;
import com.saveo.service.SaveoService;

@Controller
public class SaveoController {

  @Autowired
  SaveoService saveoService;

	
  @GetMapping("/searchmedicine")
  public String medicineData(Model model) {
	  System.out.println("ok566");
	  SaveoModel saveoModel=new SaveoModel();
      model.addAttribute("med", saveoModel);
      return "search";
  }
  @GetMapping("/medicinedetails")
  public String search(Model model) {
	  SaveoModel saveoModel=new SaveoModel();
      model.addAttribute("cid", saveoModel);
      System.out.println("what");
      return "medicine";
  }
  @GetMapping("/")
  public String homePage(Model model) {
	  System.out.println("okhome");
	  SaveoOrderModel order = new SaveoOrderModel();
      model.addAttribute("order", order);
      return "Welcome";
  }
	
  @GetMapping("/upload")
  public String csvUpload(Model model) {

      return "upload";
  }
  @GetMapping("/order")
  public String orderPlacing(Model model) {
	  System.out.println("ok");
	  SaveoOrderModel order = new SaveoOrderModel();
      model.addAttribute("order", order);
      return "order";
  }
	@RequestMapping(value="/uploadCSV", method = RequestMethod.POST)
  public String uploadFile(@RequestParam("file") MultipartFile file,Model model) {
    String uploadMessage = "";
    if (UploadCSV.isCSVFormat(file)) {
      try {
        saveoService.save(file);

        uploadMessage = "Uploaded  " + file.getOriginalFilename();
        
       

} catch (Exception e) {
    	  System.out.println(e);
        uploadMessage = "Could not upload the file: " + file.getOriginalFilename();
}}
	return "uploadsucess";  
	}
	
	@RequestMapping(value="/placeorder", method = RequestMethod.POST)

	public String placeorder(Model model ,@ModelAttribute("order") SaveoOrderModel order)
	{
		int n=saveoService.order(order).getOrder_id();
		model.addAttribute("oid",n);
		
		return "orderconfirmation";
		
	}
	@RequestMapping(value="/getMedicineDetails", method = RequestMethod.GET)

	public String getMedicineDetails(@RequestParam("id") int id,Model model )
	{
		System.out.println("ppp");
	model.addAttribute( "data",saveoService.getMedicineDetails(id));
		return "MedicineDetails";
		
	}
	
	@RequestMapping(value="/searchMedicine", method = RequestMethod.GET)
	public String searchMedicine(@RequestParam("name") String name,Model model  )
	{
		model.addAttribute( "meddata",saveoService.searchMedicine(name));
		return "result";
		
	}

	
	
	
}

