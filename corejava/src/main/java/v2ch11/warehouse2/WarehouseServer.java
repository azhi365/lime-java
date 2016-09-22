package v2ch11.warehouse2;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * This server program instantiates a remote warehouse objects, registers it with the naming
 * service, and waits for clients to invoke e17_methods.
 *
 * @author Cay Horstmann
 * @version 1.12 2007-10-09
 */
public class WarehouseServer {
    public static void main(String[] args) throws RemoteException, NamingException {
        System.setProperty("java.security.policy", "server.policy");
        System.setSecurityManager(new SecurityManager());

        System.out.println("Constructing server implementation...");
        WarehouseImpl backupWarehouse = new WarehouseImpl(null);
        WarehouseImpl centralWarehouse = new WarehouseImpl(backupWarehouse);

        centralWarehouse.add("toaster", new Product("Blackwell Toaster", 23.95));
        backupWarehouse.add("java", new Book("Core Java vol. 2", "0132354799", 44.95));

        System.out.println("Binding server implementation to registry...");
        Context namingContext = new InitialContext();
        namingContext.bind("rmi:central_warehouse", centralWarehouse);

        System.out.println("Waiting for invocations from clients...");
    }
}
