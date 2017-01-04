/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.command.cmd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * 根据父类获得子类
 * @author YZhi
 * @since 1.0
 */
public class ClassUtils{
	public static List<Class<?>> getSonClass(Class<?> fatherClass){
		List<Class<?>> returnClassList = new ArrayList<Class<?>>();
		String packageName = fatherClass.getPackage().getName();
		List<Class<?>> packageClasses = getClasses(packageName);
		for (Class<?> c : packageClasses) {
			if(fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)){
				returnClassList.add(c);
			}
		}
		return returnClassList;
	}

	/**
	 *
	 * @param packageName
	 * @return
	 */
	private static List<Class<?>> getClasses(String packageName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace(".", "/");
		Enumeration<URL> resources = null;
		try {
			resources = classLoader.getResources(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = (URL) resources.nextElement();
			dirs.add(new File(resource.getFile()));
			
		}
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		for (File directory:dirs) {
			classes.addAll(findClasses(directory,packageName));
		}
		return classes;
	}

	/**
	 *
	 * @param directory
	 * @param packageName
	 * @return
	 */
	private static Collection<? extends Class<?>> findClasses(File directory,
			String packageName) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if(!directory.exists()){
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if(file.isDirectory()){
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			}else if (file.getName().endsWith(".class")) {
				try {
					classes.add(Class.forName(packageName + "." + file.getName().substring(0,file.getName().length() -6)));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
