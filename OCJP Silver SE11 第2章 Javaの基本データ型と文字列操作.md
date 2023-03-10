# OCJP Silver SE11 第2章 Javaの基本データ型と文字列操作

第2章ではプリミティブ型のデータ、リテラル、varを使ったローカル変数の型推論、Stringクラス、Stringクラスのメソッド、文字列同士の連結、StringBuilderクラス、StringBuilderクラスのメソッドを扱っています。

## データ型について考える

大雑把に言うとCPUはメモリから読みだした所定の長さのビット列に加工を施してメモリに書き出すという動作を行うものです。

そのビット列がどういった情報を表現しているかはプログラムを書く人が決める問題になります。

例えば01000001という8桁のビット列は整数値を表す2進数であるとみなせば65という値を表現したものになりますし、文字コードとみなせば「A」という文字を示します。

これはあくまでもプログラマがそうみなしているということであって、ビット列に整数値、あるいは文字コードといった色分けがされているわけではありません。

実際、CPU命令をそのまま記述する機械語なりアセンブラなりではビット列が何を表しているかをプログラマが常に意識してプログラミングを行う必要があります。

しかし、それは面倒なことであり間違いも起きやすいのでプログラミング言語の多くはデータ型というものを定義して、それぞれのビット列がどのデータ型で扱われているのかをプログラム上で明示することによって、ビット列解釈のずれによる間違いを抑えるようにしています。

例えば先程の01000001というビット列を足し合わせることを考えてみてください。

これが整数値であれば65+65で答えは130となり問題はありませんが、文字コードで会った場合「A」+「A」という答えのない式となってしまいます。

実際にはJavaを含む多くの言語では文字コードは整数と互換としているので、エラーにならず謎の文字の文字コードとなってしまうのですが...。

## プリミティブ型と参照型

ところでデータ型、というか情報のビット列表現には大きく2種類があります。

プログラム中でデータを直接受け渡し、足し算などの加工を行うもので、具体的には整数値や浮動小数点値、文字コードなどが該当し、これをJavaではプリミティブ型と呼んでいます。

もう一つは文字列のようにデータのサイズが大きいため、データを直接受け渡すのに手間のかかるもので、こういったデータの場合はデータの位置を示すの指標値をデータの代替として使用するので参照型と呼んでいます。

昔のプログラミング言語ではこういった区分けを行っていなかったのですが、Javaは参照型であるオブジェクトを主要なデータ型としたこともあり、オブジェクトではないということ、言い換えると多くのデータに対してできることがこれらのデータ型に対してはできないということを明示するためにプリミティブ型という区分けを作ったのではないかと思っています。

そしてプリミティブ型は別になくても困らないのですが、プリミティブ型を導入することでプログラムの実行性能が向上すると考えられたために導入されたようです。

この辺のことについては後程触れる機会があるかと思います。

## プリミティブ型に含まれるデータ型

Javaでは以下のデータ型をプリミティブ型としています。

- **byte**: 8桁の2進数で表現可能な符号付の整数、-128から127までの値を扱うことができます。
- **short**: 16桁の2進数で表現可能な符号付の整数、-32768から32767までの値を扱うことができます。
- **int**: 32桁の2進数で表現可能な符号付の整数、細かく書くと面倒なので大体-20億から20億までの値を扱うことができます。
- **long**: 64桁の2進数で表現可能な符号付の整数、取り合えずかなり小さい整数からかなり大きい整数まで扱えると思ってください。
- **float**: 精度の高くない浮動小数点数、IEEE 754という規格で決まっている32-bit浮動小数点数ですので、詳細はそちらを見てください。
- **double**: 精度の高い浮動小数点数、floatと同じくIEEE 754の64-bit浮動小数点数形式です。
- **boolean**: **true**と**false**の2個の値のどちらかをとる型で、数値比較の結果などで用いられます。
- **char**: 文字コード用に用意されているデータ型ですが、その実態は16桁の符号なし2進数で0から65535の値、もしくは該当する文字コードを表しています。

## 整数型 (byte、short、int、long)

まず、整数型について調べていきます。

まず整数型が2進8桁を単位としている理由を少し考えてみます。

まず、2進数という点ですが、計算機が2進で計算を行うのは2進数がもっとも扱いやすい、1本の配線に電気を流すか否かで1桁を表現できるという点が挙げられます。

10進数を素直にあつかおうとすると0から9までの10本の配線が1桁ごとに必要になりますし、少し工夫をすれば配線の数は減らせますが、計算を行う回路が面倒になってしまいます。

この辺はきちんと理論的に解析がされていて、自然対数底*e*を基数としたe進法が最も効率的なのだそうです (*e*はおおよそ2.72です)。

ただe進法の計算機は作ったとしてもあまりに使いにくいと思われるので、作りやすさと使いやすさから2進法が採用されたものと思います (私的には3進法もありじゃないかと思うのですけど)。

そして桁数ですが、2進数8桁はJavaが開発された頃のコンピュータがあつかうデータの最小単位として一般的なものだったからというのが理由と思われます。

で、なぜ8桁かというとコンピュータが扱う情報の一つとして文字情報は欠かせないものです。

英語を扱おうという場合、アルファベット26文字が大文字小文字あわせて52文字、数字が0から9まで10文字、句読点としてカンマとピリオド、そして単語を区切る空白のあわせて65種類の文字が最低限必要となります。

これらに2進数の文字コードを割り当てると最低でも7桁必要になります。

また、10進数を扱う場合、10進数一桁には2進で4桁が必要となります。

そういったところから2進数8桁が10進数を扱う上でも英語の文字を扱う上でもちょうどいい大きさということで選ばれたのだろうと考えています。

実際、昔のコンピュータには基本のデータサイズにさまざまなものがありました。

メインフレームとも呼ばれる大型コンピュータでは2進36桁を基本単位としたものがあったり、電気製品などに組み込むことを目的としたマイクロコントローラでは2進4桁を基本単位としたもの、2進12桁を基本単位としたものなどもありました。

初期のマイクロコントローラはプログラミング言語など使用せず、コンピュータの命令そのままでグリグリとプログラムを書いていたので、データ型という概念そのものがありませんでした。

また、初期の大型計算機で使用されていたプログラミング言語は数値としてあつかえる範囲はプログラミング言語ごとに決まっていましたが、それがどのように計算機の中で表現されているかといったことを気にする必要はない仕様となっていました。

そして大型計算機であってもOSやコンパイラなどの基本的なソフトウエアはコンピュータの命令そのままでグリグリと書いていたので、データ型という概念を必要としていませんでした。

しかし、ソフトウエアに対する要求が大きくなってくるとOSやコンパイラをはじめとするCPUやメモリなど計算機ハードウエアに依存した基本的なソフトウエアもプログラミング言語で書けるようにという要求が高まってきました。

その結果として計算機の基本的な仕様、計算やメモリの読み書きの際の基本単位をプログラミング言語が意識するようになりました。

実際、初期のCプログラミング言語では**short**型は**int**型より大きくない、**long**型は**int**型より小さくないという仕様になっており、それぞれの桁数は対象となる計算機に合わせて決められていたので、Cプログラミング言語で書かれたプログラムをほかの計算機で動かす際には書き換えが必要となっていました。

しかしプログラミング言語を使用してOSやコンパイラなどを開発するようになると今度はプログラミング言語や既存のOSなどに合わせて計算機の仕様を決めていくという感じで仕様の基本的な部分が収束していくようになったのだと思います。

という感じで80年代の計算機ではデータとして扱う数値の最小単位を2進8桁、2進数の桁数はbinary digitを省略したbit (ビット) という単位で表現しますので8ビットとし、標準的に扱う数値の単位は32ビットが普通になっていました。

Javaもこういった80年代の計算機の仕様を引き継いで**byte**型を8ビット、**int**型を32ビットとし、加えて**short**型16ビットと**long**型64ビットの4種類を用意したのだと思われます。

### 符号付整数の補数表現

ここで整数値の符号について考えます。

符号付の値を考える場合、値と符合の組み合わせで1個のデータとする方法が考えられます。

例えば8ビットデータの場合、1番上の桁を符号を表すものとして1番上の桁が0であれば正の数、1であれば負の数として残り7桁で0から127までを表現するというものです。

これは人間にはわかりやすいのですが、**-0**という少し扱いにくい値が作れてしまうことと、計算を行う回路が少しばかり面倒になるというところがあるため、多くのプログラミング言語では使用されていません。

8ビットで表現できる範囲は0から255までとなりますので、紙テープか何かに0から255までの整数を等間隔で書き、256個目の数字を書くところでテープを切ってください。

この紙テープの0と255の間がほかの数字の間隔と同じになるように貼り合わせてループにしたものを作ってください。

このループになった紙テープが符号付整数の表現となります。

0から1、2、3と進む方向を正の方向、0から255、254、253と進む方向を負の方向として、255に-1、254に-2、253に-3というように負の値を割り当てたものがJavaを含む多くのプログラミング言語での符号付整数の表現形式となります。

それでは3から4を引くということを考えてみましょう。

4を引くというのは先ほどのループで3から数字が減る方向に4つ進んだところの値ということになります。

実際にループをたどってみると255になるので、-1という答えが得られます。

3から4を引くのではなく-4、つまり252を足したらどうなるでしょう。

これは先ほどのループを使用しなくとも3+252=255で期待通りの-1となります。

では4に-3を足してみます。

-3は253になるので4+253=257ですが、256以上になったところで最上位桁で繰上りが発生して、その繰上りは行き場がなく失われてしまうので、1という答えが出ます (気になる人は2進数の足し算をやって確かめてみてください)。

このような符号付整数をループで表現する形式を補数表現と呼んでいます。

ところで0の反対側の正負の切れ目を決めなくてはいけません。

多くのプログラミング言語では2進数で最上位の桁が1の数を負の数として扱うことに決めているので、8ビットデータであれば127までが正の数、128 (-128に該当) からは負の数としています。

これが先ほど紹介したそれぞれのデータ型の正負の範囲として紹介したものになります。

蛇足にはなりますが、例えば**byte**型の整数で100+100を計算すると答えは200になり、これは-56に該当するので、正の数同士を足し合わせたにもかかわらず結果が負になるという想定外の事態となります。

データ型を選択する際にはデータ型が扱える範囲をきちんと認識する必要があります。

## 変数

計算をする際にはデータを一時的に保存する容器が必要となることが多々あります。

例えば単価と個数が書かれた表の集計をする場合、1行目の単価と個数を掛け算して小計を出し、それをどこかにメモっておいて2行目の単価と個数をかけて出した小計とメモっておいた1行目の小計を足し合わせて2行目までの累計を出してまたメモっておくといったことをします。

このメモに当たるものを変数と呼んでいます。

Javaでは変数を使用する前に宣言する必要があります。

以下は整数 (**int**) 型の変数*sum*を宣言する例です。

```java
int sum;
```

データ型の名前を書いたあとに変数名を書いてセミコロンでくくるだけです。簡単ですね。

なお、変数名には大文字、小文字の英字と数字、下線 (_)、ドル記号 ($) が使用できますが、変数名の先頭に数字を使用することはできません。変数名の先頭が数字だと数値と見分けがつかない変数名が使用できてしまうということなんでしょう、たぶん。

また、変数名にはJava言語仕様で決められている予約語、たとえばこの例で出てくる**int**なども使用することができません。

なお、変数名の付け方には*sum*のように英字小文字を使用し、*accountNumber*のような複合語の場合は2語目以降の語の先頭を大文字にする慣例があります。

プログラムの動作には影響しませんが、プログラムの読みやすさに係わってきますので、従うべきと思います。

もう一つ、変数名は大文字、小文字を区別します。*foobar*と*fooBar*は異なる変数と認識されますので、こちらは注意が必要です。

## 変数の初期化とリテラル値

ところで、変数を宣言しただけでは容器を用意しただけで中身は空です、というか実際のところ何が入っているかわかりません。

Javaのコンパイラは、プログラムが何が入っているかわからない状態の変数に記録されている値を使おうとしていることを発見するとエラーを報告します。

もしも最初に変数に入っているべき値がわかっているときは変数宣言を行う際にしかるべき値で初期化を行うことができます。

以下は整数 (**int**) 型の変数*sum*を宣言し、*0*で初期化する例です。

```java
int sum = 0;
```

上の例では「0」という数値をベタ書きしていますが、このようにベタ書きした数値などのデータをリテラルあるいはリテラル値と呼びます。

### 整数リテラルと整数データ型の初期化

まずは整数についてです。

**int**型で表現可能な範囲の整数値、*-2,147,483,648*から*2,147,483,647*までの整数は**int**型の値として扱われ、その範囲外の整数値は**long**型として扱われます。

**int**型で表現可能な範囲であっても「*32L*」のように数値の後ろに「*L*」または「*l*」を付けることで**long**型であることを明示的に示すことができます (使い道は後で出てきます)。

見てわかるように「*l* (小文字の*L*)」は「*1*」と見分けがつきにくい場合があるので、大文字「*L*」を使用するのが普通です。

**byte**型や**short**型のリテラル値を示すための接尾辞はありません (必要ならば後程紹介するキャストを使ってください)。

また、位取り用の「, (カンマ)」を使用することはできませんが、その代わりに「_ (下線)」を使用して「*1_234_567*」のように書くことができます。

「_ (下線)」は位取り用ですので、「*_123*」のように整数値の前、あるいは「*123_*」のように整数値の後ろ、そして「*123_L*」のように「*L*」の直前に書くことはできません。

整数データ型変数の初期化に整数リテラル値を使用する場合は、リテラル値が**int**型から変数のデータ型に自動的に変換されます。

この時当然ですが、変数のデータ型と整合しない値、例えば**byte**型変数を300で初期化しようとした場合などはコンパイルエラーとなります。

また、**long**型のリテラル「*123L*」で**long**型以外の整数データ型変数を初期化することは (たとえ値が範囲内であっても) できません。エラーになります。

なお、初期化時に値が確定していればいいので、「*12\*4*」のようなリテラル値で構成される式を使うこともできます。

整数リテラルとして10進数以外に16進数と2進数を使用することができます。

16進数は「*0x1a*」のように「*0x*」で始まる数値列 (10から15は「*A*または*a*」から「*F*または*f*」を使用します) で表現し、2進数は「*0b00011010*」のように「*0b*」ではじまる数値列で表現し、「_ (下線)」による位取りも可能です。

### 浮動小数点数リテラルと浮動小数点数データ型の初期化

*3.14*といった小数点を含む数値は**double**型のリテラル値として扱われます。

**float**型の値を使用する場合は「*3.14F*」のように接尾辞「*F*または*f*」を付けます。

非常に大きな、あるいは小さな数を扱う場合には「*E*または*e*」で指数部を指定しますが、面倒なので自分で調べてください。

**int**型リテラル値と**long**型リテラル値は**double**型と**float**型変数の初期化に使用することができます。

**double**型リテラル値は**double**型変数の初期化には使用できますが、**float**型変数の初期化には使用できません。**double**型から**float**型への変換では値が変わってしまうことがあるためです。

**float**型リテラル値は**double**型変数と**float**型変数の両方で使用することができます。

### 文字型リテラルと文字型変数

文字型リテラルは「*'A'*」のように文字を「*'* (シングルクォーテーション)」で囲んで表現します。

文字型リテラルは一見文字を表しているように見えますが、実体は文字に該当する文字コードの数値で、*0*から*65535*の範囲の整数型の値として扱われます。

このため```int i = 'A' * 'B';```のように文字の掛け算というわけの分からない式を書いてもエラーにはなりません。

文字型変数も同じく*0*から*65535*の整数をあつかう整数型変数になりますので、```char c = 1234;```という初期化式もエラーとはなりません。

ところでJavaはUnicodeという文字コード体系を使用しています。

Unicodeは世の中にあるすべての文字は65536種類で表現できるだろうという甘い読みの下に始められた規格です。

しかし残念ながら世の中にあるすべての文字を拾っていこうとしたところ、とても65536種類では収まらないことがわかり、すでに10万を超える数の文字にコードが割り当てられています。

このため、文字型の値として扱えない文字も出てきていますので、文字型の値を使用する際にはそれなりの注意が必要です。

文字コードについてはいろいろと語りたいことがあるのですが、それはまた別の機会とします。

### boolean型リテラル

**boolean**型リテラルは*true*と*false*の2種類の値があります。

他のプログラミング言語と異なり、Javaのboolean型は整数型と互換性がない点に注意してください。

プリミティブ型だけでだいぶ長くなったので、他の項目に関しては稿を分けていきたいと思います。
