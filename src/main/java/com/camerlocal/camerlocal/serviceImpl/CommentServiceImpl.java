/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.CommentDao;
import com.camerlocal.camerlocal.entities.Comment;
import com.camerlocal.camerlocal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class CommentServiceImpl
        extends GenericServiceImpl<Comment, Long, CommentDao>
        implements CommentService {

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        super(commentDao);
    }

}
