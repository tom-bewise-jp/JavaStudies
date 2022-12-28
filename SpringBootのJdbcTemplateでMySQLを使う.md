# SpringBootのJdbcTemplateでMySQLを使う

## Spring Initializerの設定

以下を有効にしてプロジェクトを作成する。
- JDBC API
- MySQL Driver

## コネクションの設定

`src/main/resources/application.properties`に以下の行を追加する。
- spring.datasource.url=jdbc:mysql://host:port/データベース名 (ポートのデフォルトは3306)
- spring.datasource.username=ユーザー名
- spring.datasource.password=パスワード
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.datasource.initialization-mode=always (不要かもしれない)

## データベースへの接続とアクセス
`JdbcTemplate`変数を通してデータベースにアクセスする。

`JdbcTemplate`変数宣言に`@Autowired`アノテーションを付けるとデータベースに自動接続できる (らしい)。

`JdbcTemplate.execute("SQL文")`でSQL文を実行する。

`JdbcTemplate.batchUpdate("SQL文", コレクション)`で複数の`INSERT`/`UPDATE`が実行できる。

`JdbcTemplate.query`でクエリができる。引数は以下のとおり。

```java
<T> List<T> query(String sql, Object[] args, int[] argTypes, RawMapper<T> rowMapper)
```

サンプルでは`RawMapper`にラムダ式を使っていた。コンパイラが良く認識できたなと思う。
