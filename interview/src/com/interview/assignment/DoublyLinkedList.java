package com.interview.assignment;

public class DoublyLinkedList {

	private Link head;
	private int size;
	
	public DoublyLinkedList()
	{
		head = null;
		size = 0;
	}
	
	public void addFirst(int data) {
		if(head == null)
		{
			head = new Link(null,data,null);
		}
		else
		{ 
			Link newLink = new Link(null,data,head);
			head.previous = newLink;
			head = newLink;
		}
		size++;
	}
	
	public void addLast(int data)
	{
		if(head == null)
		{
			head = new Link(null,data,null);
		}
		else
		{
			Link current = head;
			while(current.next != null)
			{
				current = current.next;
			}
			
			Link newLink = new Link(current,data,null);
			current.next = newLink;
		}
		size++;
	}
	
	
	public void removeFirst()
	{
		if(head== null) return;
		
		head = head.next;
		head.previous = null;
		
		size--;
	}
	
	
	public void removeLast()
	{
		if(head == null) return;
		
		if(head.next == null)
		{
			head = null;
			size--;
			return;
		}
		  Link current = head;
		  while(current.next.next != null)
		  {
			  current = current.next;
		  }
		    current.next = null;
		    
		    size--;
	}
	
	public void insertAt(int data,int index)
	{
		if(head == null) return;
		if(index < 1 || index > size) return;
		
		Link current = head;
		int i = 1;
		
		while(i<index)
		{
			current = current.next;
			i++;
		}
		  if(current.previous == null)
		  {
			  Link newLink = new Link(null,data,current);
			  current.previous = newLink;
			  head = newLink;
		  }
		  else
		  {
			  Link newLink = new Link(current.previous,data,current);
			  current.previous.next = newLink;
			  current.previous = newLink;
		  }
		  size++;
	}
	
	public void removeAt(int index)
	{
		if(head == null) return;
		if(index < 1 || index > size) return;
		
		Link current = head;
		int i = 1;
		
		while(i<index)
		{
			current = current.next;
			i++;
		}
		  if(current.next == null)
		  {
			  current.previous.next = null;
		  }
		  else if(current.previous == null)
		  {
			  current = current.next;
			  current.previous =null;
			  head = current;
		  }
		  else
		  {
			  current.previous.next = current.next;
			  current.next.previous = current.previous;
		  }
		  size--;
	}
	
	public void searchNode(int value)
	{
		int i = 1;
		boolean flag = false;
		
		Link current = head;
		
		if(head == null)
		{
			System.out.println("List is empty");
			
			return;
		}
		while(current != null)
		{
			if(current.Data() == value)
			{
				flag = true;
				break;
			}
			current = current.next;
			i++;
		}
		if(flag)
		{
			System.out.println("Node is present in the list at the position: " +i);
		}
		else {
			System.out.println("Node is not present in the list");
		}
	}
			
	
	
	public int size() {
		
		return size;
	}
	
	public void Display()
	{
		Link current = head;
		while(current != null)
		{
			System.out.println(current.Data());
			current = current.next;
		}
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}

	public static void main(String[] args) 
	{
		DoublyLinkedList dll = new DoublyLinkedList();
		
		System.out.println("----------- Inserting at first Node ------------");
		dll.addFirst(5);
		dll.addFirst(36);
		dll.addFirst(15);
		dll.addFirst(45);
		dll.addFirst(76);
		
		dll.Display();
		
		System.out.println("Size: "+ dll.size());
		
		System.out.println("----------- Inserting at Last Node ------------");
		dll.addLast(98);
		dll.Display();
		
		System.out.println("Size: "+ dll.size());
		
		System.out.println("----------- Removing at First Node ------------");
		dll.removeFirst();
		dll.Display();
		
		System.out.println("Size: "+ dll.size());
		
		System.out.println("----------- Removing at Last Node ------------");
		dll.removeLast();
		dll.Display();
		
		System.out.println("Size: "+ dll.size());
		
		System.out.println("----------- Inserting at particular Node ------------");
		dll.insertAt(135,3);
		dll.insertAt(87, 5);
		dll.Display();
		
		System.out.println("Size: "+ dll.size());
		
		System.out.println("----------- Removing at particular Node ------------");
		dll.removeAt(2);
		dll.removeAt(3);
		dll.Display();
		
		System.out.println("Size: "+ dll.size());
		
		System.out.println("----------- Search at particular Node ------------");
		
		dll.searchNode(135);
		
		
		
	
		
		
	}

}
