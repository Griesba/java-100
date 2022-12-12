import java.util.concurrent.ForkJoinPool;

public class Hello {
	public static void main(String[] args){
		int numberOfProcess = Runtime.getRuntime().availableProcessors() - 1;// One process is the main process
		int defaultPoolSize = ForkJoinPool.commonPool().getPoolSize();
		System.out.println("Available processors : "+ numberOfProcess);
		System.out.println("Default pool size : " + defaultPoolSize);
	}
}
