/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.CoreObjectDao;
import com.camerlocal.camerlocal.dao.CoreObjectEditionDao;
import com.camerlocal.camerlocal.entities.CoreObject;
import com.camerlocal.camerlocal.entities.CoreObjectEdition;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.service.CoreObjectService;
import com.camerlocal.camerlocal.utils.Action;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author vivien saa
 * @param <CO>
 * @param <Dao>
 */
public abstract class CoreObjectServiceImpl<CO extends CoreObject, Dao extends CoreObjectDao<CO>>
        extends GenericServiceImpl<CO, Long, Dao>
        implements CoreObjectService<CO, Dao> {

    @Autowired
    private CoreObjectEditionDao coreObjectEditionDao;

    public CoreObjectServiceImpl(Dao coreObjectDao) {
        super(coreObjectDao);
    }

    @Override
    public CO create(CO c, User userCreator) throws CamerLocalServiceException {
        try {
            setMetaData(c, userCreator, Action.ADD);
            return genericDao.create(c);
        } catch (CamerLocalDaoException e) {
            throw new CamerLocalServiceException("unable to create a " + entityClass.getName(), e);
        }
    }

    @Override
    public CO update(CO c, User userEditor) throws CamerLocalServiceException {
        try {
            setMetaData(c, userEditor, Action.EDIT);
            return genericDao.update(c);
        } catch (CamerLocalDaoException e) {
            throw new CamerLocalServiceException("unable to update a" + entityClass.getName(), e);
        }
    }

    @Override
    public CO archive(CO c, User userArchivist) throws CamerLocalServiceException {
        try {
            setMetaData(c, userArchivist, Action.ARCHIVE);
            c.setIsActive(Boolean.FALSE);
            return c;
        } catch (CamerLocalDaoException e) {
            throw new CamerLocalServiceException("unable to archive a" + entityClass.getName(), e);
        }
    }

    protected void setMetaData(CO c, User author, Action action) throws CamerLocalDaoException {
        ZoneId utcZone = ZoneId.of("UTC");
        ZonedDateTime dateTime = ZonedDateTime.now(utcZone);
        Date now = Date.from(dateTime.toInstant());
        if (null != action) {
            switch (action) {
                case ADD:
                    c.setCreationDate(now);
                    c.setUserCreator(author);
                    c.setIsActive(Boolean.TRUE);
                    break;
                case EDIT:
                    c.setModificationDate(now);
                    CoreObjectEdition coe = new CoreObjectEdition();
                    coe.setCoreObjectEdited(c);
                    coe.setUsereditor(author);
                    coreObjectEditionDao.create(coe);
                    break;
                case ARCHIVE:
                    c.setArchivingDate(now);
                    c.setUserArchivist(author);
                    break;
                default:
                    break;
            }
        }
    }
}
