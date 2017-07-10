package com.brioal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/10.
 */

@Entity
@Table(name = "shapes", schema = "homework", catalog = "")
public class ShapesEntity {
    private Double mValue1;
    private Double mValue2;
    private Double mValue3;
    private Double mValue4;
    private Double mArea;
    private int mType;
    private int mXuhao;
    private String mTime = "";
    private String mStringType = "";


    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getStringType() {
        return mStringType;
    }

    public void setStringType(String stringType) {
        mStringType = stringType;
    }

    @Basic
    @Column(name = "value1", nullable = true, precision = 0)
    public Double getValue1() {
        return mValue1;
    }

    public void setValue1(Double value1) {
        mValue1 = value1;
    }

    @Basic
    @Column(name = "value2", nullable = true, precision = 0)
    public Double getValue2() {
        return mValue2;
    }

    public void setValue2(Double value2) {
        mValue2 = value2;
    }

    @Basic
    @Column(name = "value3", nullable = true, precision = 0)
    public Double getValue3() {
        return mValue3;
    }

    public void setValue3(Double value3) {
        mValue3 = value3;
    }

    @Basic
    @Column(name = "value4", nullable = true, precision = 0)
    public Double getValue4() {
        return mValue4;
    }

    public void setValue4(Double value4) {
        mValue4 = value4;
    }

    @Basic
    @Column(name = "area", nullable = true, precision = 0)
    public Double getArea() {
        return mArea;
    }

    public void setArea(Double area) {
        mArea = area;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    @Id
    @Column(name = "xuhao", nullable = false)
    public int getXuhao() {
        return mXuhao;
    }

    public void setXuhao(int xuhao) {
        mXuhao = xuhao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapesEntity that = (ShapesEntity) o;

        if (mType != that.mType) return false;
        if (mXuhao != that.mXuhao) return false;
        if (mValue1 != null ? !mValue1.equals(that.mValue1) : that.mValue1 != null) return false;
        if (mValue2 != null ? !mValue2.equals(that.mValue2) : that.mValue2 != null) return false;
        if (mValue3 != null ? !mValue3.equals(that.mValue3) : that.mValue3 != null) return false;
        if (mValue4 != null ? !mValue4.equals(that.mValue4) : that.mValue4 != null) return false;
        if (mArea != null ? !mArea.equals(that.mArea) : that.mArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mValue1 != null ? mValue1.hashCode() : 0;
        result = 31 * result + (mValue2 != null ? mValue2.hashCode() : 0);
        result = 31 * result + (mValue3 != null ? mValue3.hashCode() : 0);
        result = 31 * result + (mValue4 != null ? mValue4.hashCode() : 0);
        result = 31 * result + (mArea != null ? mArea.hashCode() : 0);
        result = 31 * result + mType;
        result = 31 * result + mXuhao;
        return result;
    }
}
