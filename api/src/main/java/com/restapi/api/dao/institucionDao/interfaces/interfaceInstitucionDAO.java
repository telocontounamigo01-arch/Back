package com.restapi.api.dao.institucionDao.interfaces;

import com.restapi.api.entities.Institucion;

public interface interfaceInstitucionDAO {

    String createInstitucion(Institucion institucion);
    Institucion institucionFindByID(Long ID);
    
}
