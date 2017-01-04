package javatuning.ch2.bd;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javatuning.ch2.vo.Order;

public interface IOrderManager  extends Remote {
	 Order getOrder(int id) throws RemoteException;
	 boolean checkUser(int userid) throws RemoteException;
	 boolean updateOrder(Order order) throws RemoteException;
}
