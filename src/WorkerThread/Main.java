package WorkerThread;

public class Main {

	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkers();
		new ClientThread("���˾�",channel).start();
		new ClientThread("����",channel).start();
		new ClientThread("����^(*��(oo)��)^",channel).start();
	}

}
