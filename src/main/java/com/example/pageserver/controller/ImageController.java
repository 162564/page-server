package com.example.pageserver.controller;


import com.example.pageserver.service.ImageService;
import jakarta.annotation.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class ImageController {

    @Resource
    private ImageService imageService;

    @ResponseBody
    @GetMapping("/getImgById/{id}")
    public ResponseEntity<byte[]> selectAllImg(@PathVariable Integer id) {
        byte[] data = imageService.selectByIdImg(id).getImg();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("data.jpeg").build());
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
