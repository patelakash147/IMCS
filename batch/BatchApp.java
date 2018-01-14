package batch;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchApp {

	public static void main(String[] args) throws IOException {
		File folder = new File("K://Files");
		listFilesForFolder(folder);
	}

	public static void listFilesForFolder(final File folder) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				executorService.execute(new FileloaderTask(fileEntry.getPath()));
			}
		}
	}
}
