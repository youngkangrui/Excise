package exercise;

public class E5 {
    private char[] s;
    private int now=0;
    public E5(String compressedString) {
        s=compressedString.toCharArray();
    }
    
    public char next() {
        if(hasNext()==false){
            return ' ';
        }else{
            char rs=s[now];
            s[now+1]--;
            if(s[now+1]=='0'){
                now+=2;
            }
            return rs;
        }
    }
    
    public boolean hasNext() {
        return now<s.length-1&&s[now+1]>0?true:false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="L1e2t1C1o1d1e1";
		E5 e=new E5(s);
		while(e.hasNext()){
			System.out.println(e.next());
		}
	}

}
