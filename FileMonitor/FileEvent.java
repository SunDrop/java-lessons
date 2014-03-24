import java.io.File;

public class FileEvent implements IFileEvent {
	@Override
	public void onFileAdded(File file) {
		System.out.println("File added: " + file.getName());
        	System.out.println("File date created: " + new java.util.Date((long)file.lastModified()));
	}
}
