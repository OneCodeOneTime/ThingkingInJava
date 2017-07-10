package btp.oneP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PDFTest {
	public static void main(String...args){
		Pdf2htmlEXUtil.pdf2html("C:\\Users\\dell\\Desktop\\pdfתhtml\\pdf2htmlEX-v1.0\\pdf2htmlEX.exe","C:\\Users\\dell\\Desktop\\ƥ��ȷ����.pdf","C:\\Users\\dell\\Desktop\\pdfתhtml","my.html");
	}
	
}






/**
 * @author liuzhengyong
 * @version 1.0 ʱ�䣺2013-12-30 ����2:24:10 pdf�ļ�תhtml������
 */
class Pdf2htmlEXUtil {
    /**
     * ����pdf2htmlEX��pdf�ļ�ת��Ϊhtml�ļ�
     * 
     * @param exeFilePath
     *            pdf2htmlEX.exe�ļ�·��
     * @param pdfFile
     *            pdf�ļ�����·��
     * @param [destDir] ���ɵ�html�ļ����·��
     * @param htmlName
     *            ���ɵ�html�ļ�����
     * @return
     */
    public static boolean pdf2html(String exeFilePath, String pdfFile,
            String destDir, String htmlFileName) {
        if (!(exeFilePath != null && !"".equals(exeFilePath) && pdfFile != null
                && !"".equals(pdfFile) && htmlFileName != null && !""
                    .equals(htmlFileName))) {
            System.out.println("���ݵĲ�������");
            return false;
        }
        Runtime rt = Runtime.getRuntime();
        StringBuilder command = new StringBuilder();
        command.append(exeFilePath).append(" ");
        if (destDir != null && !"".equals(destDir.trim()))// �����ļ����λ��,��Ҫ�滻�ļ�·���еĿո�
            command.append("--dest-dir ").append(destDir.replace(" ", "\" \""))
                    .append(" ");
        command.append("--optimize-text 1 ");// �������������ı���HTMLԪ�ص���Ŀ (default: 0)
        command.append("--zoom 1.4 ");
        command.append("--process-outline 0 ");// html����ʾ���ӣ�0����false��1����true
        command.append("--font-format woff ");// Ƕ��html�е������׺(default ttf)
                                                // ttf,otf,woff,svg
        command.append(pdfFile.replace(" ", "\" \"")).append(" ");// ��Ҫ�滻�ļ�·���еĿո�
        if (htmlFileName != null && !"".equals(htmlFileName.trim())) {
            command.append(htmlFileName);
            if (htmlFileName.indexOf(".html") == -1)
                command.append(".html");
        }
        try {
            System.out.println("Command��" + command.toString());
            Process p = rt.exec(command.toString());
            StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(),
                    "ERROR");
            // ������Ļ��׼������
            errorGobbler.start();
            StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(),
                    "STDOUT");
            // ������Ļ��׼�����
            outGobbler.start();
            int w = p.waitFor();
            int v = p.exitValue();
            if (w == 0 && v == 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean pdf2html_linux(String pdfFile, String destDir,
            String htmlFileName) {
        if (!(pdfFile != null && !"".equals(pdfFile) && htmlFileName != null && !""
                .equals(htmlFileName))) {
            System.out.println("���ݵĲ�������");
            return false;
        }
        Runtime rt = Runtime.getRuntime();
        StringBuilder command = new StringBuilder();
        command.append("pdf2htmlEX").append(" ");
        if (destDir != null && !"".equals(destDir.trim()))// �����ļ����λ��,��Ҫ�滻�ļ�·���еĿո�
            command.append("--dest-dir ").append(destDir.replace(" ", "\" \""))
                    .append(" ");
        command.append("--optimize-text 1 ");// �������������ı���HTMLԪ�ص���Ŀ (default: 0)
        command.append("--process-outline 0 ");// html����ʾ���ӣ�0����false��1����true
        command.append("--font-format woff ");// Ƕ��html�е������׺(default ttf)
                                                // ttf,otf,woff,svg
        command.append(pdfFile.replace(" ", "\" \"")).append(" ");// ��Ҫ�滻�ļ�·���еĿո�
        if (htmlFileName != null && !"".equals(htmlFileName.trim())) {
            command.append(htmlFileName);
            if (htmlFileName.indexOf(".html") == -1)
                command.append(".html");
        }
        try {
            System.out.println("Command��" + command.toString());
            Process p = rt.exec(command.toString());
            StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(),
                    "ERROR");
            // ������Ļ��׼������
            errorGobbler.start();
            StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(),
                    "STDOUT");
            // ������Ļ��׼�����
            outGobbler.start();
            int w = p.waitFor();
            int v = p.exitValue();
            if (w == 0 && v == 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}



/**
 * ���ڴ���Runtime.getRuntime().exec�����Ĵ������������
 * 
 * @author shaojing
 * 
 */
class StreamGobbler extends Thread {
    InputStream is;
    String type;
    OutputStream os;

    public StreamGobbler(InputStream is, String type) {
        this(is, type, null);
    }

    StreamGobbler(InputStream is, String type, OutputStream redirect) {
        this.is = is;
        this.type = type;
        this.os = redirect;
    }

    public void run() {
        InputStreamReader isr = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            if (os != null)
                pw = new PrintWriter(os);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (pw != null)
                    pw.println(line);
                System.out.println(type + ">" + line);
            }
            if (pw != null)
                pw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (pw != null)
                    pw.close();
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}