package structures;

public class Tester {

	/**
	 * Main method to test out data structure implementations
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 1; i <= 10; i++) {
			q.enqueue(i);
		}
		System.out.println("Size of queue: " + q.getSize());
		System.out.println("Head is: " + q.peekHead());
		System.out.println("Tail is: " + q.peekTail());
		q.printQ();
		
		LinkedList<Character> l = new LinkedList<Character>();
		String word = "eternalenvy";
		for (int j = 0; j < word.length(); j++) {
			l.addToBack(word.charAt(j));
		}
		l.printLL();
		l.removeHead();
		l.addToFront('E');
		l.printLL();
		System.out.println(l.getSize());
		//System.out.println(l.getHead() + " " + l.getTail());
		
		Stack<Integer> stk = new Stack<Integer>();
		for (int x = 1; x <= 10; x++) {
			stk.push(x);
		}
		System.out.println("Stack size: " + stk.getSize());
		
		while(!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}
	}
}
