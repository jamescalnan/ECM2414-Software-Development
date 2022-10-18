import java.util.LinkedList;
public class mainApp {

	public static void main(String[] args) throws InterruptedException
	{
		// Object of a class that has both produce()
		// and consume() methods
		final PC pc = new PC();
		// Create producer thread
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i < 4 ; i++){

					try {
						pc.produce();	
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();	
					}
				}

			}
		});

		// Create consumer thread
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i < 3; i++){
					try {
						pc.consume();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();
		// t1 finishes before t2
		t1.join();
		t2.join();

		System.out.println(pc.out());
	}

	// This class has a list, producer (adds items to list
	// and consumber (removes items).
	public static class PC {
		// Create a list shared by producer and consumer
		// Size of list is 2.
		// LinkedList<Integer> - it’s Java generics. You will learn

		// Java generics in Week 9. For this exercise, you can go to
		// https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html to
		// check useful methods of LinkedList.
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		public String out() {
			return "List: " + list;
		}

		// Function called by producer thread
		public synchronized void produce() throws InterruptedException {
			if (list.size() > capacity - 1) {
				System.out.println("List full, waiting... " + list);
				wait();
				list.add(1);
				System.out.println("Stopped waiting, item added to list: " + list);
			} else {
				list.add(1);
				System.out.println("Item added to list: " + list);
			}
			// TODO: Add your code here
		}

		// Function called by consumer thread
		public synchronized void consume() throws InterruptedException {
			// TODO: Add your code here
			if (list.size() > 0) {
				notifyAll();
				list.pop();
				System.out.println("Item removed from list: " + list);
			} else {

				System.out.println("Nothing in the list: " + list);
				return;
			}
		}
	}
}