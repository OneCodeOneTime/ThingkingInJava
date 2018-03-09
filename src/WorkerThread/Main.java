package WorkerThread;

public class Main {

	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkers();
		new ClientThread("³ÂÄË¾²",channel).start();
		new ClientThread("ÅëÖó",channel).start();
		new ClientThread("ÅôÖí^(*£ş(oo)£ş)^",channel).start();
	}

}
