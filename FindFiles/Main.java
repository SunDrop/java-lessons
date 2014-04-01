import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    /**
     * Класс для фильтрации файлов
     */
    static class MyFileFilter implements FilenameFilter {
        private String ext = "";

        public MyFileFilter() {
        }

        /**
         * Конструктор с предопределенным расширением
         *
         * @param ext Расширение файла или несколько расширений, разделенных пайпом "|"
         */
        public MyFileFilter(String ext) {
            this.ext = ext.toLowerCase();
        }

        /**
         * Функция добавляет дополнительное расширение для фильтрации
         *
         * @param ext Расширение файла или несколько расширений, разделенных пайпом "|"
         * @return MyFileFilter - реализуем паттерн Fluent interface
         */
        public MyFileFilter addExt(String ext) {
            this.ext = this.ext.isEmpty() ? ext.toLowerCase() : this.ext  + "|" + ext.toLowerCase();
            return this;
        }

        public boolean accept(File dir, String name) {
            // Если фильтр не задан - отдаем все файлы
            if (this.ext.isEmpty()) {
                return true;
            }

            for (String ext : this.ext.split("\\|")) {
                // Оптимизированный фильтр по расширению файла
                if (name.toLowerCase().endsWith(ext)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static void findFiles(String srcPath, String ext, ArrayList<String> list) throws IOException {
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new MyFileFilter(ext));

        for (File file : files) {
            list.add(srcPath + file.getName());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        try {
            findFiles("C:/", ".doc|.xls", list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list)
            System.out.println(s);
    }

}
