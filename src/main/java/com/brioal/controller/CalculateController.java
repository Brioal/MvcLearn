package com.brioal.controller;

import com.brioal.model.ShapesEntity;
import com.brioal.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 玩弄温柔 on 2017/7/11.
 */
@Controller
public class CalculateController {

    @Autowired
    ShapeRepository mShapeRepository;

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
                userEntity.setArea(Math.PI * userEntity.getValue1() * userEntity.getValue1());
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

}
