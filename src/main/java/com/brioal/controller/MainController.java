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

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public String toRecorders(ModelMap modelMap) {
        List<ShapesEntity> list = mShapeRepository.findAll();

        for (int i = 0; i < list.size(); i++) {
            ShapesEntity entity = list.get(i);
            switch (entity.getType()) {
                case 0:
                    //三角形
                    entity.setStringType("三角形");
                    break;
                case 1:
                    //矩形
                    entity.setStringType("矩形");
                    break;
                case 2:
                    //圆形
                    entity.setStringType("圆形");
                    break;
                case 3:
                    //梯形
                    entity.setStringType("梯形");
                    break;
            }
        }
        modelMap.addAttribute("list", list);
        return "records";
    }

    @RequestMapping(value = "/calcu", method = RequestMethod.POST)
    public String calculate(@ModelAttribute("shape") ShapesEntity userEntity, ModelMap map) {
        userEntity.setXuhao((int) System.currentTimeMillis());
        switch (userEntity.getType()) {
            case 1:
                //三角形
                double a = userEntity.getValue1();
                double b = userEntity.getValue2();
                double c = userEntity.getValue3();
                userEntity.setArea(((1.0 / 4.0) * Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a))));
                userEntity.setStringType("三角形");
                break;
            case 2:
                //矩形
                userEntity.setArea(userEntity.getValue1() * userEntity.getValue2());
                userEntity.setStringType("矩形");
                break;
            case 3:
                //圆形
                userEntity.setArea(2 * Math.PI * userEntity.getValue1() * userEntity.getValue1());
                userEntity.setStringType("圆形");
                break;
            case 4:
                //梯形
                a = userEntity.getValue1();
                b = userEntity.getValue2();
                c = userEntity.getValue3();
                userEntity.setArea((a + b) * c / 2);
                userEntity.setStringType("梯形");
                break;
        }
        mShapeRepository.saveAndFlush(userEntity);
        map.addAttribute("result", userEntity);
        return "result";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        mShapeRepository.delete(id);
        mShapeRepository.flush();
        return "redirect:/records";
    }


}
