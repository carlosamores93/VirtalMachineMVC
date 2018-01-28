package tp.pr5.mv;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CheckFieldVisibility {

	public static void checkThisPackage() {
		String packageName = CheckFieldVisibility.class.getPackage().getName();
		String packageNameSlashed = System.getProperty("user.dir")+"/bin/" + packageName.replace(".", "/")+"/"  ;
		String directoryString = packageNameSlashed;  
		File directory = new File(directoryString);  
		if (directory.exists()) {  
			checkDirectory(directory, packageName);
		} else {  
			System.err.println(packageName + " does not appear to exist as a valid package on the file system.");  
		}  
	}

	public static void checkDirectory(File directory, String packageName) {
		File[] files = directory.listFiles();  
		for (File file : files) {  
			if (!file.isDirectory()){
				String fileName = file.getName();
				// We are only interested in .class files  
				if (fileName.endsWith(".class")) {  
					// Remove the .class extension  
					fileName = fileName.substring(0, fileName.length() - 6);  
					try {  
						//System.out.println(Class.forName(packageName + "." + fileName));
						checkFields(Class.forName(packageName + "." + fileName));
					} catch (ClassNotFoundException e) {  
						System.err.println(packageName + "." + fileName + " does not appear to be a valid class.");  
					}  
				} 
			}
			else {
				checkDirectory(file, packageName+"."+file.getName());
			}
		}  
	}


	public static void checkFields(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		String cName = clazz.getName();
		System.out.println(">> CHECKING: "+cName+"("+fields.length+")");
		for (Field f: fields) {
			if (Modifier.isPublic(f.getModifiers())){
				if (!Modifier.isStatic(f.getModifiers()))
					System.err.println("   ERROR: public attribute in "+cName+": "+f.getName());
				else
					System.out.println("   INFO: public static attribute in "+cName+": "+f.getName());
			}
			else if (Modifier.isProtected(f.getModifiers())){
				System.out.println("   WARNING: protected attribute in "+cName+": "+f.getName());				
			}
		}
		System.out.println("<< END CHECKING: "+cName);		
	}

	public static void main(String[] args) {
		CheckFieldVisibility.checkThisPackage();
	}

}
