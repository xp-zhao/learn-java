package word;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WordPoi {

  /**
   * 读取word文件内容
   *
   * @param path
   * @return buffer
   */
  public static String readWord(String path) {
    String buffer = "";
    try {
      if (path.endsWith(".doc")) {
        FileInputStream is = new FileInputStream(path);
        XWPFWordExtractor ex = new XWPFWordExtractor(new XWPFDocument(is));
        buffer = ex.getText();
        is.close();
      } else if (path.endsWith("docx")) {
        OPCPackage opcPackage = POIXMLDocument.openPackage(path);
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
        buffer = extractor.getText();
        opcPackage.close();
      } else {
        System.out.println("此文件不是word文件！");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return buffer;
  }

  /**
   * 读取word文档内容包含图片 docxReadPath 文档地址 uploadPic 图片上传地址 picFile 图片保存后地址
   *
   * @param document
   * @return XWPFDocument
   * @throws IOException
   */
  public static String readPar(XWPFDocument document, String uploadPic,
      String picFile) {
    String fail = "sucess";
    Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
    try {
      //读取word中所有内容
      while (itPara.hasNext()) {

        XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
        //run表示相同区域属性相同的字符，结果以‘，’分隔；
        List<XWPFRun> runs = paragraph.getRuns();
        // paragraph.getRuns();
        String fileName = "";
        for (int i = 0; i < runs.size(); i++) {

          String oneparaString = runs.get(i).getText(runs.get(i).getTextPosition());

          System.out.println(oneparaString);

        }
      }
      List<XWPFPictureData> picList = document.getAllPictures();
      for (XWPFPictureData pic : picList) {
        byte[] bytev = pic.getData();
        String imgName = pic.getFileName();
        System.out.println("=====图片生成中========" + imgName);
        FileOutputStream fos = new FileOutputStream(uploadPic + "/" + imgName);
        fos.write(bytev);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("=====错误信息====" + e.getMessage());
      fail = "false";
    }

    return fail;
  }

  /**
   * 读取文件
   *
   * @param srcPath 文件路径
   * @return XWPFDocument 文档
   */
  public static XWPFDocument read_file(String srcPath) {
    String[] sp = srcPath.split("\\.");
    if ((sp.length > 0) && sp[sp.length - 1].equalsIgnoreCase("docx")) {
      try {
        FileInputStream fis = new FileInputStream(srcPath);
        XWPFDocument xdoc = new XWPFDocument(fis);
        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);

        // OPCPackage pack = POIXMLDocument.openPackage(srcPath);
        // XWPFDocument doc = new XWPFDocument(pack);
        return xdoc;
      } catch (IOException e) {
        System.out.println("读取文件出错！");
        e.printStackTrace();
        return null;
      }
    }
    return null;
  }

  /**
   * 获取字符串
   *
   * @param runNode
   * @return
   */
  private static String getText(Node runNode) {
    Node textNode = getChildNode(runNode, "w:t");
    if (textNode == null) {
      return "";
    }
    return textNode.getFirstChild().getNodeValue();
  }

  /**
   * @param run
   * @param runNode
   * @return
   * @throws Exception
   */
  private static String getMath(XWPFRun run, Node runNode) throws Exception {
    Node objectNode = getChildNode(runNode, "w:object");
    if (objectNode == null) {
      return "";
    }
    Node shapeNode = getChildNode(objectNode, "v:shape");
    if (shapeNode == null) {
      return "";
    }
    Node imageNode = getChildNode(shapeNode, "v:imagedata");
    if (imageNode == null) {
      return "";
    }
    Node binNode = getChildNode(objectNode, "o:OLEObject");
    if (binNode == null) {
      return "";
    }
    Node drawingNode = getChildNode(binNode, "w:drawing");
    if (drawingNode == null) {
      return "";
    }

    XWPFDocument word = run.getDocument();

    NamedNodeMap shapeAttrs = shapeNode.getAttributes();
    // 图片在Word中显示的宽高
    String style = shapeAttrs.getNamedItem("style").getNodeValue();
    System.out.println("图片宽高：".concat(style));

    System.out.println("--------------");

    NamedNodeMap imageAttrs = imageNode.getAttributes();
    // 图片在Word中的ID
    String imageRid = imageAttrs.getNamedItem("r:id").getNodeValue();
    // 获取图片信息
    PackagePart imgPart = word.getPartById(imageRid);
    System.out.println("图片名称".concat(imgPart.getPartName().getName()));
    System.out.println(imgPart.getInputStream());

    System.out.println("--------------");

    NamedNodeMap binAttrs = binNode.getAttributes();
    // 公式二进制文件在Word中的ID
    String binRid = binAttrs.getNamedItem("r:id").getNodeValue();
    // 获取二进制文件
    PackagePart binPart = word.getPartById(binRid);
    System.out.println("二进制文件名称：".concat(binPart.getPartName().getName()));
    System.out.println(binPart.getInputStream());

    System.out.println("--------------");

    return "{公式#}";
  }

  /**
   * 获取文件流
   *
   * @param document 整个文档
   * @param runNode  节点
   * @return
   */
  private static String getImage(XWPFDocument document, Node runNode) {
    Node drawingNode = getChildNode(runNode, "w:drawing");
    if (drawingNode == null) {
      return "";
    }
    try {
      // 绘画图片的宽和高
      Node extentNode = getChildNode(drawingNode, "wp:extent");
      NamedNodeMap extentAttrs = extentNode.getAttributes();
      System.out.println("宽：".concat(extentAttrs.getNamedItem("cx").getNodeValue()).concat("emu"));
      System.out.println("高：".concat(extentAttrs.getNamedItem("cy").getNodeValue()).concat("emu"));

      // 绘画图片具体引用
      Node blipNode = getChildNode(drawingNode, "a:blip");
      NamedNodeMap blipAttrs = blipNode.getAttributes();
      String rid = blipAttrs.getNamedItem("r:embed").getNodeValue();
      System.out.println("word中图片ID：".concat(rid));

      // 获取图片信息
      PackagePart part = document.getPartById(rid);
      System.out.println(part.getContentType());
      System.out.println(part.getPartName().getName());
      InputStream inputStream = part.getInputStream();
      System.out.println(part.getInputStream());
      System.out.println("------ run ------");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * 获取子节点
   *
   * @param node
   * @param nodeName
   * @return
   */
  private static Node getChildNode(Node node, String nodeName) {
    if (!node.hasChildNodes()) {
      return null;
    }
    NodeList childNodes = node.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++) {
      Node childNode = (Node) childNodes.item(i);
      if (nodeName.equals(childNode.getNodeName())) {
        return childNode;
      }
      childNode = getChildNode(childNode, nodeName);
      if (childNode != null) {
        return childNode;
      }
    }
    return null;
  }

  /**
   * 根据url获取文档内容不包含图片
   *
   * @param url
   */
  public static void test4(String url) {
    try {
      XWPFDocument word = new XWPFDocument(new FileInputStream(url));
      List<XWPFParagraph> paragraphs = word.getParagraphs();
      for (XWPFParagraph paragraph : paragraphs) {

        StringBuffer text = new StringBuffer();
        List<XWPFRun> runs = paragraph.getRuns();
        for (XWPFRun run : runs) {

          Node runNode = (Node) run.getCTR().getDomNode();
          text.append(getText(runNode));
          //String math = getMath(run, runNode);
          //text.append(math);
          //getImage(word,runNode);
        }
        System.out.println("段落内容：".concat(text.toString()));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    //String content = WordPoi.readWord("D:/youxue/拍搜题型录入模板文档格式.docx");
    String url = "D:/youxue/拍搜题型录入模板文档格式.docx";
    String url2 = "D:/youxue/公式.txt";
//    XWPFDocument document = read_file(url);
//    String content = readPar(document, "D:/youxue/", "D:/youxue/");
//    System.out.println("content====");
    WordPoi.test4(url);
//    File file=new File(url2);
//    File file1=new File("D:/youxue/公式.svg");
//    file1.createNewFile();
//    Converter.convert(file,file1,Converter.TYPE_SVG);
    //MathmlToImageUtil.toImage("D:\\youxue\\公式.txt","D:\\youxue\\1.png");
  }

}
