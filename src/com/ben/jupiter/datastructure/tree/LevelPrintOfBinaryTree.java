/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: LevelPrintOfBinaryTree.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月30日 下午4:07:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月30日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ben
 *
 */
class Node<E extends Comparable<E>>{
	Node<E> left;
	Node<E> right;
	E value;
	Node(){
		left = null;
		right = null;
		value = null;
	}
	Node(E value){
		this.value = value;
		left = null;
		right = null;
	}
	
	void PreOrderPrint(){
		System.out.print(value.toString() + " ");
		if(left != null)
			left.PreOrderPrint();
		if(right != null)
			right.PreOrderPrint();
	}
	
	void InOrderPrint(){
		if(left != null)
			left.InOrderPrint();
		System.out.print(value.toString() + " ");
		if(right != null)
			right.InOrderPrint();
	}
	
	void PostOrderPrint(){
		if(left != null)
			left.PostOrderPrint();
		if(right != null)
			right.PostOrderPrint();
		System.out.print(value.toString() + " ");
	}
	
	//Print By Level
	void LevelOrderPrint(){
		if(this == null)
			throw new IllegalArgumentException("null node !");
		Queue<Node<E>> queue1 = new LinkedList<Node<E>>();
		Queue<Node<E>> queue2 = new LinkedList<Node<E>>();
		queue1.add(this);
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(queue2.isEmpty()){
				while(!queue1.isEmpty()){
					Node<E> currentNode = queue1.poll();
					System.out.print(currentNode.value.toString() + " ");
					if(currentNode.left != null){
						queue2.add(currentNode.left);
					}
					if(currentNode.right != null){
						queue2.add(currentNode.right);
					}
				}
			}
			else{
				while(!queue2.isEmpty()){
					Node<E> currentNode = queue2.poll();
					System.out.print(currentNode.value.toString() + " ");
					if(currentNode.left != null){
						queue1.add(currentNode.left);
					}
					if(currentNode.right != null){
						queue1.add(currentNode.right);
					}
				}
			}
			System.out.println();
		}
	}
	
	//Print By Level S-style
	public void S_LevelOrderPrint(){
		Stack<Node<E>> stack1 = new Stack<Node<E>>();
		Stack<Node<E>> stack2 = new Stack<Node<E>>();
		stack1.add(this);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			if(stack1.isEmpty()){
				while(!stack2.isEmpty()){
					Node<E> currentNode = stack2.pop();
					System.out.print(currentNode.value + " ");
					if(currentNode.left != null)
						stack1.push(currentNode.left);
					if(currentNode.right != null)
						stack1.push(currentNode.right);
				}
			}else{
				while(!stack1.isEmpty()){
					Node<E> currentNode = stack1.pop();
					System.out.print(currentNode.value + " ");
					if(currentNode.right != null)
						stack2.add(currentNode.right);
					if(currentNode.left != null)
						stack2.add(currentNode.left);
				}
			}
			System.out.println();
		}
	}
}

class BinarySearchTree<E extends Comparable<E>>{
	private Node<E> root;
	
	public Node<E> getRoot(){
		return root;
	}
	
	BinarySearchTree(){
		root = null;
	}
	
	public void InsertNode(E value){
		if(root == null){
			root = new Node<E>(value);
			return;
		}
		Node<E> currentNode = root;
		while(true){
			if(value.compareTo(currentNode.value) > 0){
				if(currentNode.right == null){
					currentNode.right = new Node<E>(value);
					break;
				}
				currentNode = currentNode.right;
			}else{
				if(currentNode.left == null){
					currentNode.left = new Node<E>(value);
					break;
				}
				currentNode = currentNode.left;
			}
		}
	}
	
}

public class LevelPrintOfBinaryTree<E extends Comparable<E>> {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		{
			tree.InsertNode(4);
			tree.InsertNode(2);
			tree.InsertNode(1);
			tree.InsertNode(3);
			tree.InsertNode(6);
			tree.InsertNode(5);
			tree.InsertNode(7);
			tree.InsertNode(8);
		}
		System.out.print("PreOrderPrint: ");
		tree.getRoot().PreOrderPrint();
		System.out.print("\nInOrderPrint: ");
		tree.getRoot().InOrderPrint();
		System.out.print("\nPostOrderPrint: ");
		tree.getRoot().PostOrderPrint();
		System.out.println("\nLevelOrderPrint: ");
		tree.getRoot().LevelOrderPrint();
		System.out.println("\nS_LevelOrderPrint: ");
		tree.getRoot().S_LevelOrderPrint();
	}
}

class Nodes<E extends Comparable<E>> {
	Nodes<E> left;
	Nodes<E> right;
	E value;
	
	Nodes() {
		left = null;
		right = null;
		value = null;
	}
	
	Nodes(E value) {
		this.value = value;
	}
	
	public void print() {
		System.out.println(value.toString() + " ");
		if (left != null) {
			left.print();
		}
		if (right != null) {
			right.print();
		}
	}
}

class BinaryTree<E extends Comparable<E>> {
	
}

