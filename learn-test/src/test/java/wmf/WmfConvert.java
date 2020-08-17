package wmf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.arnx.wmf2svg.gdi.svg.SvgGdi;
import net.arnx.wmf2svg.gdi.wmf.WmfParser;
import org.junit.Test;
import org.w3c.dom.Document;

public class WmfConvert {

    @Test
    public void testConvert() throws Exception {
        String path = "D:\\data\\wmf\\1-提取图片_image6.wmf";
        String dest = "D:\\data\\wmf\\1-提取图片_image6.svg";
        InputStream is = new FileInputStream(path);
        WmfParser parser = new WmfParser();
        final SvgGdi gdi = new SvgGdi(false);
        parser.parse(is, gdi);
        Document doc = gdi.getDocument();
        OutputStream out = new FileOutputStream(dest);
        output(doc, out);
        if (out != null) {
            out.close();
        }
        if (is != null) {
            is.close();
        }
    }

    private void output(Document doc, OutputStream out) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,
                "-//W3C//DTD SVG 1.0//EN");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
                "http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd");
        transformer.transform(new DOMSource(doc), new StreamResult(out));
        if (out != null) {
            out.flush();
            out.close();
        }
    }
}
