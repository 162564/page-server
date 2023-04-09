package com.example.pageserver.service.impl;

import com.example.pageserver.entity.Image;
import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.children.MyException;
import com.example.pageserver.mapper.ImageMapper;
import com.example.pageserver.service.ImageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public Image selectByIdImg(Integer id) {
        Image image =  imageMapper.selectByIdImg(id);
        if (image.getImg().length == 0) {
            throw new MyException(ExceptionEnum.GET_IMAGE_EXCEPTION);
        }
        return image;
    }
}
