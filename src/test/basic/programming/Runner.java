package test.basic.programming;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Runner {  //case8
	
	
	private static Logger logger = Logger.getLogger(Runner.class.getName());
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		
		try {
			
			//loading class
			
			Class cls=Class.forName("task.basic.programming.Employee");
			
			//get declared methods of the loaded class
			
			Method[] methods=cls.getDeclaredMethods();
			for(Method method : methods) {
				logger.info("Method : "+method.getName());			
			}
			
			//get declared constructors of the loaded class
			
			Constructor[] constructors = cls.getDeclaredConstructors();
			for(Constructor construct : constructors) {
				logger.info("Constructor : "+construct);
				
				//get parameters
				
				Parameter[] parameters = construct.getParameters();
				for(Parameter parameter : parameters) {
					logger.info("Parameter : "+parameter);
				}
			}
			
			//invoking default constructor
			
			Constructor defaultCons=cls.getConstructor();	
			Object beni= defaultCons.newInstance();
			
			//invoking setName Method
			
			Method setMethod=cls.getMethod("setName",String.class);
			setMethod.invoke(beni,"Benilin");
			
			//invoking getName Method
			
			Method getNameMethod=cls.getMethod("getName");
			String name=(String) getNameMethod.invoke(beni);
			
			logger.info(name);
			
			//invoking overridden constructor
			
			Constructor overRidCons=cls.getConstructor(String.class,int.class);
			Object benilin=overRidCons.newInstance("Beni",2012014);
			
			
			
			
			
		} 
		catch (ReflectiveOperationException exception) {
			logger.log(Level.SEVERE,"Reflection Runner", exception);
		}
	}
}
