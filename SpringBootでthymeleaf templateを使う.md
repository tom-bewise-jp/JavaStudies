# SpringBootでthymeleaf templateを使う

## Spring Initializerの設定
- 以下を有効にする
    - Spring Web: Webアプリケーション
    - Thymeleaf: Webテンプレート
    - SpringBoot Devtools: 高速なアプリケーションの再起動、Live Reload、コンフィグレーションのサポート

## Web Controllerの作成
### httpリクエストを処理するクラス
クラスに`@Controller`アノテーションを付ける。

http-getリクエストを処理するメソッドに`@GetMapping`アノテーションを付け、`@GetMapping`アノテーションの引数にパス (`"/foo"`) を文字列で与える

メソッドの引数はクエリ文字列を受け取る文字列型変数と、`Model`型変数を与える

クエリ文字列を受け取る引数には`@RequestParam`アノテーションを付ける。

`@RequestParam`アノテーションの引数は以下のとおり
- name: 文字列型、クエリの引数名
- required: ブール型、必須かどうか
- defaultValue: 文字列型、省略可能な場合の省略時値

メソッド内で`Model`型引数の`addAttribute`メソッドを呼ぶことでテンプレートへの値埋め込みができる。

`addAttribute(String name, String value)`
- name: テンプレート内の埋め込み先を指定する文字列
- value: 埋め込む文字列

メソッドの戻り値はテンプレート名 (ファイル名から拡張子を除いたもの)

## テンプレートの作成
テンプレートはhtmlファイル。
`th`ネームスペース (`http://www.thymeleaf.org`) を用意し、`<p>`要素を置き換える場合は以下のように記述する。

```html
<p th:text="'前置文字列' + ${埋め込み先の名前} + '後置文字列'" />
```

### テーブル表示
各行のエントリデータを保持するデータクラス (bean) を用意する。

エントリデータのリスト (`List<foo>`) をアトリビュートとして渡す。

テンプレート側には `<tr>` に以下の属性を付ける。

```html
<tr th:each="レコード名:${リストアトリビュート名}" th:object="${レコード名}">
```

`<td>`には`th:text="*{プロパティ名}`または`th:text="${レコード名.プロパティ名}"`のどちらかを付ける。

`*{プロパティ名}`で指定した場合には`th:object`で指定したレコードと接続される。
