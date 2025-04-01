package br.com.tg.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App 
{
    public static void main( String[] args )
    {
    	BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    	
        int consumers = 3;
        int processors = 2;

        ExecutorService consumerExecs = Executors.newFixedThreadPool(consumers);
        ExecutorService processorExecs = Executors.newFixedThreadPool(processors);
        
        
        for(int x = 0; x < consumers ; x ++) {
        	consumerExecs.submit(new Consumer(messageQueue, x));
        }
        
        for(int y = 0; y < processors ; y ++) {
        	processorExecs.submit(new MessageProcessor(messageQueue, y));
        }
    }
}
