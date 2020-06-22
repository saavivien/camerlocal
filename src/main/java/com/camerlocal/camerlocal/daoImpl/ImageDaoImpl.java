/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.ImageDao;
import com.camerlocal.camerlocal.entities.Image;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 *
 * @author vivien saa
 */
@Repository
public class ImageDaoImpl extends GenericDaoImpl<Image, Long>
        implements ImageDao {

    @Override
    public Image findImageByUser(long userId) throws CamerLocalDaoException {
        List<Image> results = getEntityManager()
                .createNamedQuery("image_find_image_by_user_id")
                .setParameter("userId", userId).getResultList();
        try {
            return results.isEmpty() ? null : results.get(0);
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }
    }
}
