package org.walnuts.study.concurrency.chapter10.Appendix;

public class AppendixRecipe07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=0; i<20; i++){
			Task task=new Task();
			Thread thread=new Thread(task);
			thread.start();
		}

	}

	public static class Task implements Runnable {

		@Override
		public void run() {

			System.out.printf("%s: Getting the connection...\n",Thread.currentThread().getName());
			DBConnectionOK connection=DBConnectionOK.getConnection();
			System.out.printf("%s: End\n",Thread.currentThread().getName());
		}

	}

	public static class DBConnection {

		private static DBConnection connection;

		private DBConnection() {

		}

		public static DBConnection getConnection(){
			if (connection==null) {
				connection=new DBConnection();
			}
			return connection;
		}
	}

	public static class DBConnectionOK {

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



}
