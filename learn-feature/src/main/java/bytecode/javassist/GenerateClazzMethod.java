package bytecode.javassist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.*;

/**
 * @author zhaoxiaoping
 * @date 2024-5-15
 */
public class GenerateClazzMethod {
  public static void main(String[] args)
      throws IOException,
          CannotCompileException,
          NotFoundException,
          IllegalAccessException,
          InstantiationException,
          NoSuchMethodException,
          InvocationTargetException {

    ClassPool pool = ClassPool.getDefault();

    // 创建类 classname：创建类路径和名称
    CtClass ctClass = pool.makeClass("bytecode.javassist.HelloWorld");

    // 添加方法
    CtMethod mainMethod =
        new CtMethod(
            CtClass.voidType, "main", new CtClass[] {pool.get(String[].class.getName())}, ctClass);
    mainMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);
    mainMethod.setBody("{System.out.println(\"hello javassist new\");}");
    ctClass.addMethod(mainMethod);

    // 创建无参数构造方法
    CtConstructor ctConstructor = new CtConstructor(new CtClass[] {}, ctClass);
    ctConstructor.setBody("{}");
    ctClass.addConstructor(ctConstructor);

    // 输出类内容
    ctClass.writeFile();

    // 测试调用
    Class clazz = ctClass.toClass();
    Object obj = clazz.newInstance();

    Method main = clazz.getDeclaredMethod("main", String[].class);
    main.invoke(obj, (Object) new String[1]);
  }
}
