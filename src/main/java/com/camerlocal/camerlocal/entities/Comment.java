/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author vivien saa
 */
@Entity
public class Comment extends BaseObject {

    @Column(nullable = false, name = "comment_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date commentDate;

    @Column(nullable = false)
    private String content;

    @ManyToOne(optional = true)
    private User userCommentator;

    @ManyToOne(optional = true)
    private Product productCommented;

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserCommentator() {
        return userCommentator;
    }

    public void setUserCommentator(User userCommentator) {
        this.userCommentator = userCommentator;
    }

    public Product getProductCommented() {
        return productCommented;
    }

    public void setProductCommented(Product productCommented) {
        this.productCommented = productCommented;
    }

}
