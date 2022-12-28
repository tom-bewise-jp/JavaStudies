# JDBCについて

## JDBCの構成

```
Javaプログラム
----    [JDBC API]     ----
JDBC Driver Manager
---- [JDBC Driver API] ----
JDBC Driver -> RDBMS
```

## JDBCでのデータベース接続
`Class.forname(ドライバクラス名文字列)`でドライバをロードする。

`Connection conn = DriverMangaer.getConnection(String url, String user, String password)`でデータベースと接続する。

`Statement stmt = conn.createStatement()`でステートメントを作成する。

`ResultSet rset = stmt.executeQuery(SQL文字列)`でクエリを実行する。

`rset.close()`で結果セットをクローズする。

`stmt.close()`でステートメントをクローズする。

`conn.close()`で接続をクローズする。

クエリ以外 (値を返さないもの) は`stmt.executeUpdata(SQL文字列)`を使う。

同じクエリを何度も行う場合`preparedStatement`を使用する。

`preparedStatement`のSQL文には`?`パラメータを配置でき、ステートメントに`set型名(Int pos, String str)`を実行することで指定位置 (1始まり) の`?`パラメータを置き換えることができる。

`preparedStatement`はSQLインジェクション対策が施されているので、一般的には`Statement`の代わりにこちらを使用するほうがいいと思われる。

## SQLのDATETIME型とTIMESTAMP型

SQLの`DATETIME`型と`TIMESTAMP`型はどちらもJDBCの`java.sql.TimeStamp`型に割り当てられる。

SQLの`DATETIME`型は日時データを記録し、`TIMESTAMP`型は日時データをUTCで記録する点が異なる。

MySQLでは`TIMESTAMP`型を入出力時にタイムゾーンを参照してローカルタイムに変換するので、`LocalTime`型で入出力すればよい。

## 重複項目を出力しない
`SELECT DISTINCT ...`で重複項目は出力されなくなる。
