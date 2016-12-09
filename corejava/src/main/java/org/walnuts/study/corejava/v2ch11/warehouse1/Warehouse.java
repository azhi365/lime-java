package org.walnuts.study.corejava.v2ch11.warehouse1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The remote interface for a simple warehouse.
 *
 * @author Cay Horstmann
 * @version 1.0 2007-10-09
 */
public interface Warehouse extends Remote {
    double getPrice(String description) throws RemoteException;
}
