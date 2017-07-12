package com.brioal.controller;

import com.brioal.model.ShapesEntity;
import com.brioal.repository.ShapeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 玩弄温柔 on 2017/7/11.
 */
@Controller
public class RecordsController {
    @Autowired
    ShapeRepository mShapeRepository;

    /**
     * 记录显示
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/records/{page}", method = RequestMethod.GET)
    public String toRecorders(@PathVariable("page") final int page, ModelMap modelMap) {
        long allCount = mShapeRepository.count();
        Page<ShapesEntity> pagers = mShapeRepository.findAll(new PageRequest(page, 5, null));

        List<ShapesEntity> list = pagers.getContent();
        for (int i = 0; i < list.size(); i++) {
            ShapesEntity entity = list.get(i);
            switch (entity.getType()) {
                case 1:
                    //三角形
                    entity.setStringType("三角形");
                    break;
                case 2:
                    //矩形
                    entity.setStringType("矩形");
                    break;
                case 3:
                    //圆形
                    entity.setStringType("圆形");
                    break;
                case 4:
                    //梯形
                    entity.setStringType("梯形");
                    break;
            }
        }
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("count", (int)(allCount/5.0f+0.5));
        return "records";
    }
}
