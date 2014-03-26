import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Monitor {

    IFileEvent event;
    String[] filesMonitor = new String[10];
    String[] filesExclude = new String[100];
    int iSize = 0;
    int iExcludeSize = 0;


    public Monitor(IFileEvent event) {
        this.event = event;
    }

    public Monitor addDir(String sName) throws Exception {
        if (!(new File(sName)).isDirectory()) {
            throw new Exception("You add not directory");
        }
        return this.addFile(sName);
    }

    public Monitor addFile(String sName) throws Exception {
        if (iSize >= filesMonitor.length) {
            throw new Exception("MaxFileMonitorLimit");
        }
        filesMonitor[iSize++] = sName;
        return this;
    }

    public Monitor removeFile(int iIndex) throws Exception {
        if (iIndex >= filesMonitor.length) {
            throw new Exception("Index delete error");
        }
        System.arraycopy(filesMonitor, iIndex + 1, filesMonitor, iIndex, --iSize - iIndex);
        return this;
    }

    public boolean isExclude(String sName) {
        return Arrays.asList(filesExclude).contains(sName);
    }

    public void addExcludeFile(String sName) throws Exception {
        if (iExcludeSize >= filesExclude.length) {
            throw new Exception("MaxFileExcludeLimit");
        }
        filesExclude[iExcludeSize++] = sName;
    }

    public void start() {
        while (iSize > 0) {
            for (int i = 0; i < iSize; i++) {
                File f = new File(filesMonitor[i]);
                if (f.exists()) {
                    if (f.isFile()) {
                        if (event != null) {
                            event.onFileAdded(f);
                        }
                        try {
                            this.removeFile(i);
                        } catch (Exception e) {}
                    } else if (f.isDirectory()) {
                        File[] files = f.listFiles(new MyFileFilter(".txt"));

                        for (File file: files) {
                            try {
                                String sName = file.getCanonicalPath();
                                if (!isExclude(sName)) {
                                    if (event != null) {
                                        event.onFileAdded(file);
                                    }
                                    addExcludeFile(sName);
                                }
                            } catch (Exception e) {}
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("Waiting...");
        }
    }

    static class MyFileFilter implements FilenameFilter {
        private String ext;

        public MyFileFilter(String ext) {
            this.ext = ext.toLowerCase();
        }

        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(this.ext);
        }
    }
}
