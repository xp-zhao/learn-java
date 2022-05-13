package cache;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * guava 双键 Map, Table 使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-5-13
 */
public class TableExample {
  public static void main(String[] args) {
    Table<String, String, Integer> table = HashBasedTable.create();
    // 存放元素
    table.put("Hydra", "Jan", 20);
    table.put("Hydra", "Feb", 28);
    table.put("Trunks", "Jan", 28);
    table.put("Trunks", "Feb", 16);

    // 取出元素
    Integer dayCount = table.get("Hydra", "Feb");
    System.out.println(dayCount);

    // rowKey或columnKey的集合
    Set<String> rowKeys = table.rowKeySet();
    Set<String> columnKeys = table.columnKeySet();
    System.out.println(rowKeys);
    System.out.println(columnKeys);
    // value集合
    Collection<Integer> values = table.values();
    System.out.println(values);
    // 计算 key 对应的所有 value 的和
    for (String key : table.rowKeySet()) {
      Set<Map.Entry<String, Integer>> rows = table.row(key).entrySet();
      int total = 0;
      for (Map.Entry<String, Integer> row : rows) {
        total += row.getValue();
      }
      System.out.println(key + ": " + total);
    }
    // 转换 rowKey 和 columnKey
    Table<String, String, Integer> table2 = Tables.transpose(table);
    Set<Table.Cell<String, String, Integer>> cells = table2.cellSet();
    cells.forEach(
        cell ->
            System.out.println(
                cell.getRowKey() + "," + cell.getColumnKey() + ":" + cell.getValue()));
    // 转为嵌套的 Map
    Map<String, Map<String, Integer>> rowMap = table.rowMap();
    Map<String, Map<String, Integer>> columnMap = table.columnMap();
    System.out.println(rowMap);
    System.out.println(columnMap);
  }
}
