package com.restapi.api.dao.bitacoraDao.interfaces;

import com.restapi.api.entities.Bitacora;

public interface interfaceBitacoraDAO {

    String createBitacora(Bitacora bitacora);
    Bitacora bitacoraFindByID(Long ID);
}
