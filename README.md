# jsearch
一款基于Java实现的文件搜索小组件

# 编译方法

- 安装`jdk21`及以上版本；
- 执行`git`命令下载源码：`git clone https://github.com/290044632/jsearch.git`；
- 执行`maven`命令生成jar可执行文件：`mvn package`；
- 使用`jpackage`工具生成操作系统相关的应用包：`jpackage --name jsearch --main-jar jsearch-1.0-SNAPSHOT.jar  --java-options "--enable-preview" --input .`；不同平台的安装包需要去相应的操作系统下执行该命令；
- `jpackage`更多配置参数参照[https://docs.oracle.com/en/java/javase/22/docs/specs/man/jpackage.html](https://docs.oracle.com/en/java/javase/22/docs/specs/man/jpackage.html)；

# 安装方法

- 在Linux环境下执行上述`jpackage`命令会生成一个`jsearch-1.0-1.x86_64.rpm`*(不同的打包参数生成的文件会有一定的区别，请以实际文件为准)*；
- 执行`sudo rpm -ivh`命令安装`.rpm`文件，安装后的目录为`/opt/jsearch/bin`*(不同的打包参数安装后的目录会有一定区别，请以实际打包参数结果为准)*；可使用`whereis jsearch`命令搜索安装路径；

# 使用方法

```
jsearch  -- 打印命令帮助文档
```
```
jsearch -h -- 打印命令帮助文档

Usage: jsearch commnd [options,......]
【Command】:
-v: 打印版本号
-h: 打印帮助文档
-s: 搜索文件
【-s Options】：
dir=? 搜索路径，默认为当前目录
regx=? regex语法规则表达式
glob=? glob语法规则表达式
【Glob Syntax】:
* 匹配任意数量字符
** 类似*，但包含目录，通常用于匹配全路径
? 匹配一个字符
{} 匹配列表中的任意一个子模式
[] 匹配列表中的任意一个字符，如果用“-”连接表示一个范围
\  转义符,关键字符匹配自己本身使用转义符
其他字符匹配自己本身

```
