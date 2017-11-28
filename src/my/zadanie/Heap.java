package my.zadanie;

import java.util.ArrayList;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}
	public double extract(){
		heapSize--;
		return tab.remove(0);

	}
	public void delete(){
		tab.remove(0);
		heapSize--;
	}
	public void replace(double new_value){
		double tmp=top();
		delete();
		if(tmp<new_value){
			tab.add(0,new_value);
			System.out.println("chuj");
		}
		else {
			insert(new_value);
		}
	}
	public void  heapify( double [] tablica){
		Heap heap=new Heap();
		for(double x: tablica){
			insert(x);
		}
	}
	public void merge(Heap heap1, Heap heap2){

		for(Double x:heap1.tab){
			tab.add(x);
		}
		for(Double x:heap2.tab){
			tab.add(x);
		}

	}
	public void meld(Heap heap){
		for(double x:heap.tab){
			insert(x);
		}
	}

}
