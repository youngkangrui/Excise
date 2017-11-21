package exercise;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
public class Tuniu {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
			int a=0,b=4;
			int c=a=b;
			System.out.println(a+" "+b+" "+c);
			Integer i=8;
			int ii=(int)i;
			System.out.println(ii);
			Pattern p=Pattern.compile("\\w+\\.");
			Method m=Test.class.getMethod("m");
			String s=p.matcher(m.toString()).replaceAll("");
			System.out.println(p.matcher("abc.abcabc").replaceAll("young"));
			String s1="young";
			byte[] b1=s1.getBytes();
			for(byte x:b1)
			System.out.print(x+" ");
			char c1=121;
			byte b11=0;
			int i1=0;
			boolean d1;
			System.out.print(c1);
	}
}
class Test{
	private void p(){
		System.out.println ("young");
	}
	public void m(){
		System.out.println ("young");
	}
}
