/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.CommentDao;
import com.camerlocal.camerlocal.entities.Comment;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivien saa
 */
@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment, Long>
        implements CommentDao {

}
