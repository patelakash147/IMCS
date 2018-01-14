package batch;

public class FileloaderTask implements Runnable {

	String fileName;

	FileLoaderService fileloaderservice;
	{
		fileloaderservice = (FileLoaderService) new FileLoader();
	}

	public FileloaderTask(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			fileloaderservice.loadFile(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}
}
