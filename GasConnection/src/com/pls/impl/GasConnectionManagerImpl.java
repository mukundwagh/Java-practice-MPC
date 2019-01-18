package com.pls.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.pls.bean.GasConnection;
import com.pls.exception.InvalidConnectionDetailsException;

public class GasConnectionManagerImpl implements GasConnectionManager {

	@Override
	public Set<GasConnection> readData(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGasConnection(Set<GasConnection> set,
			GasConnection connection) throws InvalidConnectionDetailsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GasConnection getGasConnectionDetails(Set<GasConnection> set,
			int connectionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
