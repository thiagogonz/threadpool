package br.com.tg.threadpool;

import java.util.concurrent.BlockingQueue;

public class MessageProcessor implements Runnable{
	private final int taskId;
	private final BlockingQueue<String> messageQueue;
	
	public MessageProcessor(BlockingQueue<String> messageQueue, int taskId) {
		this.taskId = taskId;
		this.messageQueue = messageQueue;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(messageQueue.poll());
		}
		
	}

}
