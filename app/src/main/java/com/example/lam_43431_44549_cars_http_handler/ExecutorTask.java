package com.example.lam_43431_44549_cars_http_handler;

import android.os.Handler;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;

public class ExecutorTask {
    ExecutorService executor;
    Handler resultHandler;
    TextView textView;
    String jsonStr;


    public ExecutorTask(ExecutorService executor, Handler resultHandler, TextView textView, String url) {
        this.executor = executor;
        this.resultHandler = resultHandler;
        this.textView = textView;

        this.executor.execute(() -> {
            doWork(url);
            atualizaInterface(jsonStr);
        });
    }

    private void doWork(String url) {
        HttpHandler handler;

        handler = new HttpHandler();
        jsonStr = handler.lerInformacao(url);
    }

    private void atualizaInterface(String mensagem) {

        resultHandler.post(() -> textView.setText(mensagem));
    }
}
