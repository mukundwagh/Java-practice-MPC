package com.pls.impl;

import java.util.Set;

import com.pls.bean.GasConnection;
import com.pls.exception.InvalidConnectionDetailsException;

public interface GasConnectionManager {
	Set<GasConnection> readData(String fileName);
	boolean addGasConnection(Set<GasConnection> set,GasConnection connection) throws InvalidConnectionDetailsException;
	GasConnection getGasConnectionDetails(Set<GasConnection> set,int connectionId);
	
}
