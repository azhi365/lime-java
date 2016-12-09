package org.walnuts.study.concurrency.Appendix.recipe07.util;

public class DBConnectionOK {

	private DBConnectionOK() {
		System.out.printf("%s: Connection created.\n",Thread.currentThread().getName());
	}

    private static class LazyDBConnection {
        private static final DBConnectionOK INSTANCE = new DBConnectionOK();
    }
    
    public static DBConnectionOK getConnection() {
        return LazyDBConnection.INSTANCE;
    }	
	
}
