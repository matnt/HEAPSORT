package heapsort;

import java.util.Scanner;

public class HEAPSORT {

	int n;
	int[] k;
	Scanner in;
	public HEAPSORT() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HEAPSORT heap = new HEAPSORT();
		heap.input();
		heap.heapSort();
		heap.printResult();
	}
	
	public void input() {
		in = new Scanner(System.in);
		n = in.nextInt();
		k = new int[n];
		for(int i = 0; i < n; i++) {
			k[i] = in.nextInt();
		}
		
	}
	
	public void heapify(int i, int n) {
		int l = 2 * i;
		int r = 2 * i + 1;
		int max = i;
		if(l < n && k[l] > k[i]) 
			max = l;
		if(r < n && k[r] > k[max]) 
			max = r;
		if(max != i) {
			int tmp = k[i];
			k[i] = k[max];
			k[max] = tmp;
			heapify(max, n);
		}
	}

	public void buildheap() {
		for(int i = n/2; i >= 0; i--) {
			heapify(i, n);
		}
	}
	public void heapSort() {
		buildheap();
		for(int i = n - 1; i > 0; i--) {
			int tmp = k[0];
			k[0] = k[i];
			k[i] = tmp;
			heapify(0, i - 1);
		}
	}
	
	public void printResult() {
		for(int i = 0; i < n; i++) {
			System.out.print(k[i] + " ");
		}
	}
}
