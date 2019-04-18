/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class Product extends CoreObject {

    @Column(name = "buying_price")
    private float buyingPrice;

    @Column(name = "selling_price")
    private float sellingPrice;

    private float discount;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @OneToMany(mappedBy = "productCommented", fetch = FetchType.LAZY)
    private List<Comment> listComments;

    @OneToMany(mappedBy = "productMarked", fetch = FetchType.LAZY)
    private List<Mark> listMarks;

    @OneToMany(mappedBy = "productContainted", fetch = FetchType.LAZY)
    private List<ProductState> listProductStates;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> listImages;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<DescriptionLine> listDescriptionLines;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<FeatureGroup> listFeatureGroups;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductCategory> listProductCategorys;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Periods> listPeriods;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProviderProduct> listProviderProducts;

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public List<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(List<Comment> listComments) {
        this.listComments = listComments;
    }

    public List<Mark> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Mark> listMarks) {
        this.listMarks = listMarks;
    }

    public List<ProductState> getListProductStates() {
        return listProductStates;
    }

    public void setListProductStates(List<ProductState> listProductStates) {
        this.listProductStates = listProductStates;
    }

    public List<Image> getListImages() {
        return listImages;
    }

    public void setListImages(List<Image> listImages) {
        this.listImages = listImages;
    }

    public List<DescriptionLine> getListDescriptionLines() {
        return listDescriptionLines;
    }

    public void setListDescriptionLines(List<DescriptionLine> listDescriptionLines) {
        this.listDescriptionLines = listDescriptionLines;
    }

    public List<FeatureGroup> getListFeatureGroups() {
        return listFeatureGroups;
    }

    public void setListFeatureGroups(List<FeatureGroup> listFeatureGroups) {
        this.listFeatureGroups = listFeatureGroups;
    }

    public List<ProductCategory> getListProductCategorys() {
        return listProductCategorys;
    }

    public void setListProductCategorys(List<ProductCategory> listProductCategorys) {
        this.listProductCategorys = listProductCategorys;
    }

    public List<Periods> getListPeriods() {
        return listPeriods;
    }

    public void setListPeriods(List<Periods> listPeriods) {
        this.listPeriods = listPeriods;
    }

    public List<ProviderProduct> getListProviderProducts() {
        return listProviderProducts;
    }

    public void setListProviderProducts(List<ProviderProduct> listProviderProducts) {
        this.listProviderProducts = listProviderProducts;
    }

}
