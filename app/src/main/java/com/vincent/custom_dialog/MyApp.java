package com.vincent.custom_dialog;

import android.app.Application;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.flattener.DefaultFlattener;
import com.elvishew.xlog.formatter.border.DefaultBorderFormatter;
import com.elvishew.xlog.formatter.message.json.DefaultJsonFormatter;
import com.elvishew.xlog.formatter.message.throwable.DefaultThrowableFormatter;
import com.elvishew.xlog.formatter.message.xml.DefaultXmlFormatter;
import com.elvishew.xlog.formatter.stacktrace.DefaultStackTraceFormatter;
import com.elvishew.xlog.formatter.thread.DefaultThreadFormatter;
import com.elvishew.xlog.interceptor.BlacklistTagsFilterInterceptor;
import com.elvishew.xlog.printer.AndroidPrinter;
import com.elvishew.xlog.printer.ConsolePrinter;
import com.elvishew.xlog.printer.Printer;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.elvishew.xlog.printer.file.backup.NeverBackupStrategy;
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2018/1/11 15:41
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initXLogs();
    }

    private void initXLogs() {

        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(BuildConfig.DEBUG ? LogLevel.ALL             // Specify log level, logs below this level won't be printed, default: LogLevel.ALL
                        : LogLevel.NONE)
                .tag("MY_TAG")                                         // Specify TAG, default: "X-LOG"
                .t()                                                   // Enable thread info, disabled by default
                .st(2)                                                 // Enable stack trace info with depth 2, disabled by default
                .b()                                                   // Enable border, disabled by default
                .jsonFormatter(new DefaultJsonFormatter())                  // Default: DefaultJsonFormatter
                .xmlFormatter(new DefaultXmlFormatter())                    // Default: DefaultXmlFormatter
                .throwableFormatter(new DefaultThrowableFormatter())        // Default: DefaultThrowableFormatter
                .threadFormatter(new DefaultThreadFormatter())              // Default: DefaultThreadFormatter
                .stackTraceFormatter(new DefaultStackTraceFormatter())      // Default: DefaultStackTraceFormatter
                .borderFormatter(new DefaultBorderFormatter())               // Default: DefaultBorderFormatter
                /*.addObjectFormatter(AnyClass.class,                    // Add formatter for specific class of object
                        new Object().toString())      */               // Use Object.toString() by default
                .addInterceptor(new BlacklistTagsFilterInterceptor(    // Add blacklist tags filter
                        "blacklist1", "blacklist2", "blacklist3"))
                .addInterceptor(new MyInterceptor())                   // Add a log interceptor
                .build();

        Printer androidPrinter = new AndroidPrinter();             // Printer that print the log using android.util.Log
        Printer consolePrinter = new ConsolePrinter();             // Printer that print the log to console using System.out
        Printer filePrinter = new FilePrinter                      // Printer that print the log to the file system
                .Builder("/sdcard/xlog/")                              // Specify the path to save log file
                .fileNameGenerator(new DateFileNameGenerator())        // Default: ChangelessFileNameGenerator("log")
                .backupStrategy(new NeverBackupStrategy())             // Default: FileSizeBackupStrategy(1024 * 1024)
                .logFlattener(new DefaultFlattener())                       // Default: DefaultFlattener
                .build();

        XLog.init();
//        XLog.init(                                                 // Initialize XLog
//                config,                                                // Specify the log configuration, if not specified, will use new LogConfiguration.Builder().build()
//                androidPrinter//,                                        // Specify printers, if no printer is specified, AndroidPrinter(for Android)/ConsolePrinter(for java) will be used.
//                consolePrinter,
//                filePrinter
//        );
    }
}
