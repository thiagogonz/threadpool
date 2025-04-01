package br.com.tg.threadpool;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{
	private final int taskId;
	private BlockingQueue<String> messageQueue;
	
	public Consumer(BlockingQueue<String> messageQueue, int taskId) {
		this.taskId = taskId;
		this.messageQueue = messageQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String msg = "Id da Mensagem: " + UUID.randomUUID() + " posição: " + messageQueue.size() + " na Thread: " + Thread.currentThread().toString();
				messageQueue.put(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}