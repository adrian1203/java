package my.zadanie;

import static org.junit.Assert.*;

import my.zadanie.Heap;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {
	@Test
	public void meld() throws Exception {
		double tab[]={1000,9,7,966,5,594,3,2,1000};
		Heap heap1=new Heap();
		heap1.heapify(tab);
		Heap heap2=new Heap();
		heap2.insert(36);
		heap2.insert(1236);
		heap2.insert(32586);
		heap2.insert(3886);
		heap2.insert(3);
		heap2.insert(36);
		heap1.meld(heap2);
		assertEquals("Meld", 32586, heap1.top(), 0.001);
	}

	@Test
	public void merge() throws Exception {
		double tab[]={10,9,7,6,5,4,3,2,1};
		Heap heap1=new Heap();
		Heap heap2=new Heap();
		heap1.heapify(tab);
		heap2.heapify(tab);
		Heap mergeheap=new Heap();
		mergeheap.merge(heap1,heap2);
		assertEquals("Merge", 10,mergeheap.top(),0.001);
	}

	@Test
	public void heapify() throws Exception {
		double tab[]={10,9,7,6,5,4,3,2,1,};
		Heap heap=new Heap();
		heap.heapify(tab);
		assertEquals("Wierzchołek", 10, heap.top(), 0.001);
	}

	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}
	@Test
	public void Extract0And2And3And5And6(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		assertEquals("Usuwanie najwięskzego z kopca", 6,heap.extract(),0.001);
	}
	@Test
	public void Extract0And7And4And5And6(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(7);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		assertEquals("Usuwanie najwięskzego z kopca", 7,heap.extract(),0.001);
	}
	@Test
	public void Delete0And7And4And5And6(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(7);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.delete();
		//Heap heap=set();
		assertEquals("Usuwanie najwięskzego z kopca", 6,heap.top(),0.001);
	}
	@Test
	public void ReplaceTest25(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(7);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.replace(25);
		assertEquals("usuwanie i dodawanie nowego elemntu do kopca, ",25, heap.top(), 0.0001);
	}
	@Test
	public void ReplaceTest2(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(7);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.replace(2);
		assertEquals("usuwanie i dodawanie nowego elemntu do kopca, ",6, heap.top(), 0.0001);
	}

}

