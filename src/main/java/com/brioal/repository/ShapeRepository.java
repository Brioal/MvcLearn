package com.brioal.repository;

import com.brioal.model.ShapesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/10.
 */
@Repository
public interface ShapeRepository extends JpaRepository<ShapesEntity, Integer> {

}
