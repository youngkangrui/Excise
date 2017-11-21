package exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Node {
	Node next;
	int val;
	Node(int v){
		val=v;
	}
	@Override
	public String toString() {
		return   " val=" + val ;
	}
	public static void main(String[] args){
		Integer[] a={0,1,2,3};//1+2+3+4=10;
		List b=new ArrayList();
		Collections.addAll(b, a);
//		for(int i=0;i<b.size();i++)
//			System.out.print(b.get(i));
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(j!=i){
					for(int k=0;k<4;k++){
						if(k!=i&&k!=j){
							for(int m=0;m<4;m++){
								if(m!=i&&m!=j&&m!=k){
									System.out.print(a[i]);//选择第i个作为第一个；
									System.out.print(a[j]);//选择第j个作为第二个；
									System.out.print(a[k]);//选择第k个作为第三个；
									System.out.println(a[m]);
								}
							}
						}
					}
				}
			}
		}
	}
}
