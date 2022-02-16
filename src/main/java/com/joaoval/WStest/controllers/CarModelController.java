package com.joaoval.WStest.controllers;

import com.joaoval.WStest.services.implementation.ExcelDataService;
import com.joaoval.WStest.services.implementation.FileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class CarModelController {

    @Autowired
    FileUploaderService fileService;

    @Autowired
    ExcelDataService excelService;

    @GetMapping("/")
    public String index() {
        return "uploadPage";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message", "You have successfully uploaded '" + file.getOriginalFilename() + "' !");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
