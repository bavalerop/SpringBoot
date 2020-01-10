package com.ciudad.repository;

import java.util.List;
import com.ciudad.entity.CiudadEntity;

public interface ICiudadRepoCustom {
	
	public List<CiudadEntity> BuscarByName(String name);
	
	public void Logg(String data);
	
	public int idSig();
	
}
