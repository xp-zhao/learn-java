package stm;

/**
 * 带版本号的对象引用
 *
 * @author zhaoxiaoping
 * @date 2024-9-26
 */
public final class VersionedRef<T> {
  final T value;
  final long version;

  public VersionedRef(T value, long version) {
    this.value = value;
    this.version = version;
  }
}
