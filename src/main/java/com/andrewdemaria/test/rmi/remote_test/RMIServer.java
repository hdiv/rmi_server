package com.andrewdemaria.test.rmi.remote_test;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RMIServerIntf {
	public static final String MESSAGE = "Hello world";

	public RMIServer() throws RemoteException {

	}

	@Override
	public String getMessage(final User user) throws RemoteException {
		myLocalMessage(user);
		return getFolder(user).getPath();

	}

	@Override
	public String myLocalMessage(final User user) throws RemoteException {
		return getFolder(user).getName();
	}

	private File getFolder(final User user) {
		return new File("Hello_World_Folder" + System.getProperty("file.separator") + user.name + System.getProperty("file.separator")
				+ user.surname);
	}

	public static void main(final String args[]) throws Exception {

		// if(System.getSecurityManager()==null){
		// System.setSecurityManager(new RMISecurityManager());
		// }
		System.out.println("RMI server started");

		// Instantiate RmiServer
		RMIServer obj = new RMIServer();

		try { // special exception handler for registry creation

			RMIServerIntf stub = (RMIServerIntf) UnicastRemoteObject.exportObject(obj, 0);
			Registry reg;
			try {
				reg = LocateRegistry.createRegistry(1099);
				System.out.println("java RMI registry created.");

			}
			catch (Exception e) {
				System.out.println("Using existing registry");
				reg = LocateRegistry.getRegistry();
			}
			reg.rebind("RMIServer", stub);

		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
