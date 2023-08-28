# OCJP Silver SE11 第8章 関数型インタフェース、ラムダ式 (1)

第8章は関数型インタフェースとラムダ式についてですが、その準備としてラムダ式に至る道のりを少し追ってみたいと思います。

## オブジェクトの並べ替えを考えてみる

プログラムでよく行われる処理にソート、例えば値の小さい順に並べ替えるといったものがあります。

例えば従業員オブジェクトのリストを氏名の順に並べ替える、勤続年数順に並べ替えるといったものです。

このような並べ替えをどういう風に実現するかを考えていこうと思います。

### Comparableインタフェースとjava.util.Collections.sort

並べ替えのアルゴリズムはよく知られているので、氏名で並べ替えを行うのであれば、氏名を比較する部分だけを考えれば、あとは既存のアルゴリズムを使用することができます。

これを実現するのが**java.util.Comparable**インタフェースと**java.util.Collections.sort**メソッドになります。

従業員オブジェクトを氏名の順に並べ替える場合、以下の例に示すように従業員オブジェクトに**Comparable**インタフェースを実装し、**compareTo**メソッドを定義します。

```Java
public class Employee implements Comparable<Employee> {
    private String name;

    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }

    // 以下略
}
```

上のように"Employee"クラスを定義すると、"Employee"クラスのオブジェクトは"name"フィールドを使用したオブジェクト間の比較ができるようになり、以下のようなプログラムで"name"フィールドでの並べ替えができるようになります。

```java
// 関連する部分のみ
List<Employee> employeeList = ArrayList<>();
// リストにEmployeeオブジェクトを追加するコードは省略
// 並べ替えは以下のように実施
Collections.sort(employeeList);
// 以下略
```

このように要素オブジェクトが**Comparable**インタフェースを実装していれば**List**を渡すだけで並べ替えができるようになります。

### java.util.Comparatorインタフェースとjava.util.List.sort

上で見たように**Comparable**インタフェースを使用するとオブジェクトの並べ替えが簡単になりますが、**Comparable**インタフェースでは比較対象が1個だけしか設定できないため、例えば従業員を氏名で並べ替えたい場合と勤続年数で並べ替えたい場合といった複数の基準で並べ替えを行いたい場合には使うことができません。

※ 無理やりやろうと思えばできるのかなあ。

そこで登場するのが**Comparator**インタフェースとなります。

**Comparator**インタフェースは引数で指定された2個のオブジェクトを比較し、その結果を返すメソッドを定義したインタフェースで、**List.sort**メソッドの引数として渡すことでリストの並べ替え方法を指定することができるようになっています。

本来であればオブジェクト間の比較を行うメソッドだけを並べ替えメソッドに渡せればいいのですが、Javaにそのような仕組みがないため、メソッドを定義したオブジェクトを渡すというちょっと面倒な仕組みになっています。

まず、"Employee"クラスと2種の**Comparator**インタフェースを実装したクラスの例を以下に示します。

```java
public class Employee {
    private String name;
    private LocalDate joined;

    public String getName() {
        return name;
    }

    public LocalDate getJoined() {
        return joined;
    }
    // 以下略
}

public class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class EmployeeJoinedComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, employee o2) {
        return o1.getJoined().compareTo(o2.getJoined());
    }
}
```

そして、これらのクラスを使用した並べ替えは以下のように行います。

```java
// 関連する部分のみ
List<Employee> employeeList = ArrayList<>();
// リストにEmployeeオブジェクトを追加するコードは省略
// nameフィールドでの並べ替えは以下のようにします
employeeList.sort(new EmployeeNameComparator());
// Comparatorオブジェクトを変数に保存して使いまわすこともできます
Comparator employeeJoinedComparator = new EmployeeJoindComparator();
employeeList.sort(employeeJoinedComparator);
// 以下略
```

このように**Comparator**インタフェースを実装したクラスのオブジェクトを生成して**List**の**sort**メソッドに渡すことで様々なプロパティでの並べ替えができるようになります。

## スタティック内部クラス

**Comparator**インタフェースを使用することで任意のフィールド値を使用した並べ替えができるようになりますが、いくつかの問題があります。

その一つは並べ替えの対象となるクラスと比較に使用するクラスが別のクラスになっているため、並べ替えに使用するフィールドが公開されている必要があるということです。上の例ではアクセサメソッドを使用することでフィールド自体へのアクセスは制限していますが。

フィールドをプロパティとしても後悔したくない場合にはスタティック内部クラスを使用することができます。

上の例をスタティック内部クラスを使用した例を以下に示します。

```java
public class Employee {
    private String name;
    private LocalDate joined;

    private static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.  compareTo(o2.name);
        }  
    }

    private static class JoinedComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.joined.compareTo(o2.joined);
        }
    }

    public static final Comparator<Employee> NAME_COMPARATOR = new NameComparator();
    public static final Comparator<Employee> JOINED_COMPARATOR = new JoinedComparator();
    // 以下略
}
```

ざっくりいうと前の例で独立したクラスとして定義していた**Comparator**インタフェースを実装したクラスをクラスのスタティックメンバーとして定義するようにしただけです。

ただ、それだけだとあまり芸がないので、比較用のオブジェクトを他のクラスで簡単に使えるように公開しています。

スタティック内部クラスはそれが定義されているクラスのメンバーですので、プライベートなメンバーにもアクセスが可能となります。

ただし、スタティックメンバーですので、インスタンスのメンバーにアクセスする際にはインスタンスへの参照が必要ですが、上の例で分かるように**compare**メソッドにはインスタンスが渡されるので、特に問題はありません。

この例を使用して並べ替えを行うプログラム例を以下に示します。

```java
// 関連する部分のみ
List<Employee> employeeList = ArrayList<>();
// リストにEmployeeオブジェクトを追加するコードは省略
// nameフィールドでの並べ替えは以下のようにします
employeeList.sort(Employee.NAME_COMPARATOR);
// joinedフィールドでの並べ替えは以下のようになります。
employeeList.sort(Employee.JOINED_COMPARATOR);
// 以下略
```

公開フィールドを使用できるようにしたこともあり、だいぶすっきりとしたコードになりました。

### 無名クラス

上の例をもう一度見直してみると、"NameComparator"と"JoinedComparator"の2個のクラスは定義されて、公開用のフィールドを初期化する際に1度使われるだけなので、わざわざクラス名をつけるのは面倒という気持ちになってきます。

そしてこれら2個のクラスはどちらも**Comparator**インタフェースで宣言されているメソッドを実装しているだけで、**Comparator**型として扱われるので、データ型としてもクラス名を持つ必要はありません。

ということでクラス定義をフィールド初期化に組み込んでしまおうというのが無名クラスの考え方です。

上の例を無名クラスで書き換えた例を以下に示します。

```java
public class Employee {
    private String name;
    private LocalDate joined;

    public static final Comparator<Employee> NAME_COMPARATOR = new Comparator<>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.  compareTo(o2.name);
        }  
    };
    
    public static final Comparator<Employee> JOINED_COMPARATOR = new Comparator<>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.joined.compareTo(o2.joined);
        }
    };
    // 以下略
}
```

だいぶすっきりしました。

2個の公開フィールドは**Comparator**型なので**Comparator**オブジェクトを**new**で生成しますが、**Comparator**はインタフェースなのでインスタンスを直接生成することはできません。

そのため、インタフェースを実装するクラスの本体を指定することでオブジェクトを生成できるようにするというのが無名クラスのやり方になります。

並べ替えのコード自体はスタティック内部クラスの例と同じものとなりますので、省略させてください。

ここまではインスタンスと直接関連しない事例を考えてきました。

次は少し違った例を考えてみます。

## 拡張for文を考える

Javaには拡張for文という仕組みがあります。

例えば従業員リスト ```List<Employee> employeeList```の要素を一つずつ扱いたい場合、```for (Employee e: employeeList)```のように記述することができます。

これをどう実現するかを少し考えてみようと思います。

まず最初に思いつくのはコンパイラで何とかするという方法。

配列や**List**型の内部構造が分かっていればコンパイラがそれに合わせてコードを出せばいいという考え方です。

しかし、このやり方だと**List**型の実装を改良するごとにコンパイラを修正しなければなりませんし、なによりユーザー定義型に対応できないという問題点があります。

そこで考えられる方法として、拡張for文用のメソッドを定義したインタフェースを実装するという考え方です。

例えば、以下のようなインタフェースが考えられます。

```java
public interface Iterable<T> {
    public void resetIteration();
    public T getNextIteration();
}
```

"resetIteration"メソッドでアクセスするインデクスをリセットし、その後"getNextIteration"でインデクスを進めながら読みだしていくといった感じです。

これで拡張for文を実現できそうな気がしますが、一つ問題があります。

それは複数の拡張for文が同時に実行される場合、インデクスが1個しかないため、期待通りに動かないという点です。

ということで、Javaでは**Iterator**というインタフェースを定義し、拡張for文では最初に**Iterator**オブジェクトを生成し、**Iterator**オブジェクトを使用して要素を取り出す構成としています。

具体的にはどうなっているかを見ていきます。

まず、**java.lang.Iterable**インタフェースを見ていきます。

これは**Iterator**オブジェクトを取り出すためのメソッド**iterator**を定義するもので、コンパイラは拡張for文の対象となっているリストオブジェクトが**Iterable**インタフェースを実装しているかを確認します。

拡張for文は最初にリストオブジェクトから**iterator**メソッドで**Iterator**オブジェクトを取り出し、**Iterator**オブジェクトの**hasNext**メソッドと**next**メソッドを使用して要素を1個ずつ取り出していきます。

ということで、**Iterator**オブジェクトをどのように実装するかを考えてみます。

### スタティック内部クラスで実装してみる

ここでは**Iterator**オブジェクトの説明ということで、非常に簡単な (ほぼ意味のない) 実装例を作ってみようと思います。

そして、**List**を含む多くの**Iterable**なクラスでは拡張for文など**Iterator**オブジェクトを使用している途中で要素の追加などリストを変更する操作が起きた場合には例外を発生する実装となっていますが、面倒なので今回の例では気にしないことにします。

まず "Employee" オブジェクトのリストを保持する "EmployeeList" クラスを定義します。

```java
public class EmployeeList implements Iterable<Employee> {
    // EmployeeオブジェクトはListで保持することにします
    List<Employee> list;

    // Iteratorクラスをスタティック内部クラスとして定義します
    public static EmployeeIterator implements Iterator<Employee> {
        private EmployeeList list;
        private int index = 0;

        public EmployeeIterator(EmployeeList list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.list.size();
        }

        @Override
        public Employee next() {
            if (index < 0 || list.list.size() <= index) {
                throw new NoSuchElementException();
            }
            return list.list.get(index++);
        }
    }

    // Iteratorオブジェクトを取得するメソッドを用意します
    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator(this);
    }
    // 以下略
}
```

スタティック内部クラスである "EmployeeIterator" は "EmployeeList" オブジェクトにアクセスする必要があるため、コンストラクタ引数として "EmployeeList" が必要で、"EmployeeList" クラスの "iterator" メソッドも "EmployeeIterator" オブジェクトを生成する際に自分自身のオブジェクト参照 **this** をコンストラクタ引数で渡しています。

このような手続きが必要となるのは、スタティック内部クラスがその外側のクラス (エンクロージングクラス) に属していて、エンクロージングクラスのインスタンスに属しているわけではないからです。

### 内部クラスによる実装

ということで内部クラスでの実装例を示します。

```java
public class EmployeeList implements Iterable<Employee> {
    // EmployeeオブジェクトはListで保持することにします
    List<Employee> list;

    // Iteratorクラスをスタティック内部クラスとして定義します
    public EmployeeIterator implements Iterator<Employee> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public Employee next() {
            if (index < 0 || list.size() <= index) {
                throw new NoSuchElementException();
            }
            return list.get(index++);
        }
    }

    // Iteratorオブジェクトを取得するメソッドを用意します
    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator();
    }
    // 以下略
}
```

内部クラスはインスタンスフィールドやインスタンスメソッド (これらも通常はインスタンスと明示せずフィールド、メソッドと呼ばれています) と同様にインスタンスに属するのでインスタンスフィールドやインスタンスメソッドに直接アクセスができます。

このため、"EmployeeIterator" オブジェクトはエンクロージングクラスである "EmployeeList" クラスの参照を記憶する必要がなくなり、"hasNext" メソッドや "next" メソッドの実装も簡単になっています。

### 無名クラスを使用する

そして**Iterator**オブジェクトを無名クラスとして実装することも可能になります。

```java
public class EmployeeList implements Iterable<Employee> {
    // EmployeeオブジェクトはListで保持することにします
    List<Employee> list;

    // Iteratorクラスをスタティック内部クラスとして定義します
    public EmployeeIterator implements Iterator<Employee> {
    }

    // Iteratorオブジェクトを取得するメソッドを用意します
    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public Employee next() {
                if (index < 0 || list.size() <= index) {
                    throw new NoSuchElementException();
                }
                return list.get(index++);
            }
        };
    }
    // 以下略
}
```

スタティック内部クラス、内部クラスのどちらもクラスとして定義を行っていたので、クラス名が必要でした。

しかし、これらのクラス名は1度しか使われない形式的な存在ですので省略できればというのが無名クラスという記法となります。

上の例で示したように無名クラスは``` new インタフェース名() {クラス本体}``` のように書くことができますし、インタフェースではなく拡張するクラス名を指定することもできます。

Javaではすべてのクラスは**Object**を継承しているので、```new Object() {クラス本体}``` という書き方で任意のオブジェクトを定義することができます。

しかし、生成したオブジェクトを受け取る変数の型で使用できるメソッドが制約されるとともに、指定できるクラス名またはインタフェース名が一つであることでも制約が発生します。

※ オブジェクトを受け取る変数として**var**型を使うと生成した無名クラスのメソッドすべてが使えるようになりますが、フィールドの値やメソッドの引数や戻り値として**var**型を指定することはできないので、使用できる範囲は限られたものになります。

以上で何となく内部クラスと無名クラスについてまとめられたので、次は本題のラムダ式に入りたいと思います。
