package com.tianmaying.snake;

import java.util.LinkedList;

public class Snake {

    private static Node newHead = null;
	private final LinkedList<Node> body = new LinkedList<>();

    public Node eat(Node food) {
        if(isNeighbor(body.getFirst(), food)){
        	body.addLast(food);
        	newHead=food;
        	body.set(0, newHead);
        	return food;
        }else{
        	return null;
        }
    }

    /**
     * 往某个方向移动，蛇的身体可能会重叠，重叠判断由<code>Grid</code>处理。
     *
     * @param direction
     * @return <code>Snake</code>原来的尾部，即最后一个<code>SquareArea</code>
     */
    public Node move(Direction direction) {
        int headX=body.getFirst().getX();
        int headY=body.getFirst().getY();
    	switch(direction){
	        case UP:
	        	headY--;
	        	break;
	        case RIGHT:
	        	headX++;
	        	break;
	        case DOWN:
	        	headY++;
	        	break;
	        case LEFT:
	        	headX--;
	        	break;
        }
    	newHead=new Node(headX, headY);
    	body.addFirst(newHead);
        return body.removeLast();
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }
}
