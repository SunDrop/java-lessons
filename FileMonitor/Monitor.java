import java.io.File;

public class Monitor {
	IFileEvent event;
    String[] files = new String[10];
    int iSize = 0;


    public Monitor(IFileEvent event) {
		this.event = event;
	}

    public Monitor addFile(String sName) throws Exception {
        if (iSize >= files.length) {
            throw new Exception("MaxFileMonitorLimit");
        }
        files[iSize++] = sName;
        return this;
    }
	
	public void start() {
		while (true) {
            for (int i = 0; i < iSize; i++) {
                File f = new File(files[i]);
                if (f.exists() && f.isFile()) {
                    if (event != null) {
                        event.onFileAdded(f);
                    }
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
			System.out.println("Waiting...");
		}
	}
}
