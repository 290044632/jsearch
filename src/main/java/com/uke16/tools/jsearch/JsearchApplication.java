package com.uke16.tools.jsearch;

import com.uke16.tools.jsearch.command.*;

import java.util.Arrays;

public class JsearchApplication {
    public static void main(String[] args) {
        ICommandRegistry registry = CommandRegistryFactory.getDefault();

        if (args.length == 0) {
            new HelpCommand().execute(IOptions.EMPTY_OPTIONS);
            return;
        }
        String cmd = args[0];
        if (!cmd.contains("-")) {
            new HelpCommand().execute(IOptions.EMPTY_OPTIONS);
            return;
        }
        cmd = cmd.substring(1);
        ICommand command = registry.getCommand(cmd);
        if (null == command) {
            new HelpCommand().execute(IOptions.EMPTY_OPTIONS);
            return;
        }
        IOptions options = new PairValueOptions();
        Arrays.stream(args).skip(1)
                .forEach(value -> {
                    String[] split = value.split("=");
                    options.setValue(split[0], split[1]);
                });
        command.execute(options);
    }

}
