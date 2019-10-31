import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

	public class Merge {
		public static void main(String[]args) throws FileNotFoundException {
			
			Queue<Integer> q1 = new LinkedList<Integer>();
			Queue<Integer> q2 = new LinkedList<Integer>();
			Queue<Integer> q3;
			
			q1.add(1);
			q1.add(2);
			q1.add(3);
			q1.add(4);
			
			q2.add(5);
			q2.add(6);
			q2.add(7);
			q2.add(8);
			
			System.out.println("Queue 1: ");
			printQueue(q1);
			
			System.out.println("Queue 2: ");
			printQueue(q2);
			
			System.out.println("Sorted Merged Queue: ");
			
			Queue q = merge(q1,q2);
			q.toArray();
			System.out.print(q);
		}
 
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Queue merge(Queue q1, Queue q2) {
			if(q1.isEmpty()) {
				return q2;
			}
			if(q2.isEmpty()) {
				return q1;
			}
			
			Queue<Integer> q3 = new LinkedList<Integer>();
			
			int input1 = q1.size();
			int input2 = q2.size();
			
			int i = 0;
			int j = 0;
			
			int x;
			int y;
			
			while(i<input1 || j<input2) {
				if(1<input1 && j<input2) {
					x= (int) q1.peek();
					y= (int) q2.peek();
				
				if(x < y) {
					q1.remove();
					q3.add(x);
					q1.add(x);
					i++;
					}
				else {
					q2.remove();
					q3.add(y);
					q2.add(y);
					
					j++;
					
					}
				}
				else if(i<input1 && j>=input2) {
					x = (int) q1.remove();
					q1.add(x);
					q3.add(x);
					i++;
				}
				
				else if(i>=input1 && j<input2) {
					y = (int) q1.remove();
					q2.add(y);
					q3.add(y);
				}
			}
			return q3;
		}
		
		public static void printQueue (Queue q) {
			for(Object item: q) {
				System.out.print(item+" ");
			}
			
			System.out.println();
		}
		

	}