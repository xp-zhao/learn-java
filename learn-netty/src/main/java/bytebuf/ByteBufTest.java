package bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @description: netty 数据载体 ByteBuf 实战
 * @author: zhaoxp
 * @create: 2019/05/29
 **/
public class ByteBufTest {

  public static void main(String[] args) {
    ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(9, 100);

    print("allocate ByteBuf(9, 100)", byteBuf);

    // write 方法改变写指针，写完之后写指针未到 capacity 的时候，buffer 任然可以写
    byteBuf.writeBytes(new byte[]{1, 2, 3, 4});
    print("writeBytes(1,2,3,4)", byteBuf);

    // write 方法改变写指针，写完之后写指针未到 capacity 的时候，buffer 任然可以写，写完 int 类型之后写指针增加 4
    byteBuf.writeInt(12);
    print("writeInt(12)", byteBuf);

    // write 方法改变写指针，写完之后写指针等于 capacity 的时候，buffer 不可写
    byteBuf.writeBytes(new byte[]{5});
    print("writeBytes(5)", byteBuf);

    // write 方法改变写指针，写的时候发现 buffer 不可写，则开始扩容，扩容之后 capacity 随即改变
    byteBuf.writeBytes(new byte[]{6});
    print("writeBytes(6)", byteBuf);

    // get 方法不改变读写指针
    System.out.println("getByte(3) return: " + byteBuf.getByte(3));
    System.out.println("getShort(3) return: " + byteBuf.getShort(3));
    System.out.println("getInt(3) return: " + byteBuf.getInt(3));
    print("getByte()", byteBuf);

    // set 方法不改变读写指针
    byteBuf.setByte(byteBuf.readableBytes() + 1, 0);
    print("setByte()", byteBuf);

    // read 方法改变读指针
    byte[] dst = new byte[byteBuf.readableBytes()];
    byteBuf.readBytes(dst);
    print("readBytes(" + dst.length + ")", byteBuf);
  }

  private static void print(String action, ByteBuf buffer) {
    System.out.println("after ===========" + action + "============");
    System.out.println("capacity(): " + buffer.capacity());
    System.out.println("maxCapacity(): " + buffer.maxCapacity());
    System.out.println("readerIndex(): " + buffer.readerIndex());
    System.out.println("readableBytes(): " + buffer.readableBytes());
    System.out.println("isReadable(): " + buffer.isReadable());
    System.out.println("writerIndex(): " + buffer.writerIndex());
    System.out.println("writableBytes(): " + buffer.writableBytes());
    System.out.println("isWritable(): " + buffer.isWritable());
    System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());
    System.out.println();
  }
}