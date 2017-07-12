package com.brioal.controller;

import com.brioal.model.ShapesEntity;
import com.brioal.repository.ShapeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/10.
 */
@Controller
class MainController {

    @Autowired
    ShapeRepository mShapeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }




    @RequestMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        mShapeRepository.delete(id);
        mShapeRepository.flush();
        return "redirect:/records";
    }


}
