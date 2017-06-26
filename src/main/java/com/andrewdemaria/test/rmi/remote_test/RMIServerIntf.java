package com.andrewdemaria.test.rmi.remote_test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerIntf extends Remote {
	public String getMessage(User user) throws RemoteException;

	public String myLocalMessage(User user) throws RemoteException;
}
