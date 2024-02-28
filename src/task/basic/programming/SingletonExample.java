package task.basic.programming;

import java.io.Serializable;

public class SingletonExample implements Cloneable,Serializable{
	
	//make not serializable
	
	private static final long serialVersionUID = -570499928678063818L;

	private SingletonExample(){
		
	}
	public SingletonExample clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	private static SingletonExample sEg;
	
	public static SingletonExample getObj() {
		if (sEg==null) {
			synchronized (SingletonExample.class) {
				if(sEg==null) {
					sEg=new SingletonExample();
				}
			}
		}
		return sEg;
	}
}
