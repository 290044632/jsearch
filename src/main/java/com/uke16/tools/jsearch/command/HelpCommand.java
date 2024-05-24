package com.uke16.tools.jsearch.command;

import static java.lang.StringTemplate.STR;

public class HelpCommand implements ICommand {
    @Override
    public String getName() {
        return "h";
    }

    @Override
    public void execute(IOptions options) {
        String usage = STR."""
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
                \\  转义符,关键字符匹配自己本身使用转义符
                其他字符匹配自己本身
                """;
        System.out.println(usage);
    }
}
